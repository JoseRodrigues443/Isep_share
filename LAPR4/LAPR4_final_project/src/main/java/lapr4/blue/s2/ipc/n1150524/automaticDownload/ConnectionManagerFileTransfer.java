/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150524.automaticDownload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.blue.s2.ipc.n1150524.automaticDownload.application.FileTransferController;
import lapr4.blue.s2.ipc.n1150524.automaticDownload.permanentDownload.PermanentFile;
import lapr4.red.s1.ipc.network.library.ConnectionManagerInterface;
import lapr4.red.s1.ipc.network.library.ConnectionUDP;
import lapr4.red.s1.ipc.network.library.FileConnectionTCP;
import lapr4.red.s1.ipc.network.library.MessageReceiverInterface;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkExtensionEnum;
import lapr4.red.s1.ipc.network.library.NetworkIpProtocolEnum;
import lapr4.red.s1.ipc.network.library.ObjectConnectionTCP;
import lapr4.red.s1.ipc.network.library.TextConnectionTCP;
import lapr4.red.s1.ipc.network.library.Utils;

/**
 *
 * @author Filipe Correia <1150524@isep.ipp.pt>
 */
public class ConnectionManagerFileTransfer implements ConnectionManagerInterface {

    private NetworkMachinesTcpPortsList networkMachinesList;

    private NetworkAddress computerNetworkAddress;

    private FileTransferController ctrl;

    private final int FILE_NAME = 7;

    private TextConnectionTCP.ReceiverTCP textReceiverTCP;

    private ObjectConnectionTCP.ReceiverTCP objectRecieverTCP;

    private TextConnectionTCP.ReceiverTCP downloadPortReciverTCP;

    private int udpPort;

    private NetworkAddress serverIpAddress;

    private int serverTcpPort;

    private String downloadFolder;

    private String shareFolder;

    private String udpMessageToSend;

    private final static int SECONDS_DEFAULT = 7;

    private ConnectionUDP.UDPReceiverManager receiverUDP;

    private String downloadedFileName;

    public ConnectionManagerFileTransfer(FileTransferController ctrl) {
        networkMachinesList = new NetworkMachinesTcpPortsList(NetworkExtensionEnum.FILE_TRANSFER);
        this.ctrl = ctrl;
        computerNetworkAddress = Utils.ownIpAddress();
        udpPort = NetworkExtensionEnum.FILE_TRANSFER.udpPort();

        start();
    }

    @Override
    public boolean start() {

        this.textReceiverTCP = newTcpListenerText(this);
        this.downloadPortReciverTCP = newTcpListenerText(this);
        this.objectRecieverTCP = newTcpListener(this);

        udpMessageToSend = Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT + "FileTransfer"
                + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT + "UDP" + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + Utils.ownIpAddress().getAddress() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + textReceiverTCP.getTcpPort() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + downloadPortReciverTCP.getTcpPort() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + objectRecieverTCP.getTcpPort() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT;

        sendAnnouncementTimedUDP(SECONDS_DEFAULT);

        udpListener();

        return true;
    }

    @Override
    public ArrayList<String> getMachineList() {
        ArrayList<String> toReturn = new ArrayList<>();
        for (NetworkAddress address : networkMachinesList.findAllAdresses()) {
            toReturn.add(address.getAddress());
        }
        return toReturn;
    }

    @Override
    public boolean sendAnnouncementTimedUDP(int seconds) {
        /*amount of time to the run method be executed again*/
        int timeInterval = seconds * 1000;
        java.util.Timer timerToSendUdp = new java.util.Timer();
        timerToSendUdp.schedule(new TimerTask() {
            @Override
            public void run() {
                ConnectionUDP connectionUDP = new ConnectionUDP(udpPort);
                /**
                 * network address , but for the broadcast network
                 */
                String broadcast = computerNetworkAddress.getBroadcastAddress();
                NetworkAddress networkAddressTmp = new NetworkAddress(NetworkIpProtocolEnum.IPV4,
                        broadcast,
                        computerNetworkAddress.getMaskAddress(),
                        computerNetworkAddress.getBroadcastAddress(),
                        -1,
                        -1);
                /**
                 * sends an address
                 */
                //System.out.println("UDP TEXT----> " + udpMessageToSend);
                connectionUDP.sendMessageUDP(udpMessageToSend, networkAddressTmp);
            }

        }, 0, timeInterval);

        return true;

    }

    @Override
    public boolean sendTcp(Object object, int tcpPort, NetworkAddress addressToSend) {
        serverIpAddress = addressToSend;
        serverTcpPort = tcpPort;
        String s = (String) object;
        TextConnectionTCP textConnectionTCP = new TextConnectionTCP(tcpPort);
        return textConnectionTCP.tcpSenderSendMessage(s, addressToSend);
    }

    @Override
    public void udpListener() {
        ConnectionUDP connectionUDP = new ConnectionUDP(this.udpPort);
        this.receiverUDP = connectionUDP.startReceiveMessage(this);
    }

    public boolean tcpObjectSender(Object msg, int tcpPort, NetworkAddress address) {
        ObjectConnectionTCP cP = new ObjectConnectionTCP(tcpPort);
        return cP.tcpSenderSendMessage(msg, address);
    }

    @Override
    public ObjectConnectionTCP.ReceiverTCP newTcpListener(MessageReceiverInterface mri) {
        ObjectConnectionTCP cP = new ObjectConnectionTCP(0);
        return cP.tcpListener(mri);
    }

    public FileConnectionTCP.SenderTCP newTcpFileSender(File file) {
        FileConnectionTCP cP = new FileConnectionTCP(0);
        return cP.tcpSender(file);
    }

    public boolean sendTcpFile(File file, int tcpPort, NetworkAddress addressToSend) {
        FileConnectionTCP cP = new FileConnectionTCP(tcpPort);
        return cP.sendFile(file);

    }

    public File recieveTcpFile(String filePath, NetworkAddress addressOfFileServer, int tcpPort) {
        FileConnectionTCP cP = new FileConnectionTCP(tcpPort);
        return cP.receiveFile(filePath, addressOfFileServer);
    }

    public TextConnectionTCP.ReceiverTCP newTcpListenerText(MessageReceiverInterface mri) {
        TextConnectionTCP cP = new TextConnectionTCP(0);

        return cP.tcpListener(mri);
    }

    @Override
    public boolean addMachineToMap(String tcpAnnoucement) {
        //System.out.println("--> »»»»» maps = " + udpAnnoucement);

        String splited[] = tcpAnnoucement.split(Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT);
        if (splited.length == 0) {
            return false;
        }
        String address = splited[3];
        if (Utils.validateAddress(address, NetworkIpProtocolEnum.IPV4)) {
            NetworkAddress networkAddressTmp = new NetworkAddress(NetworkIpProtocolEnum.IPV4,
                    address,
                    this.computerNetworkAddress.getMaskAddress(),
                    this.computerNetworkAddress.getBroadcastAddress(),
                    -1,
                    Integer.parseInt(splited[4]));

            networkMachinesList.addNewMemberToMap(networkAddressTmp, Integer.parseInt(splited[4]),
                    Integer.parseInt(splited[5]), Integer.parseInt(splited[6]));
            return true;
        }
        return false;
    }

    @Override
    public boolean messageReceivedTrigger(Object object) {
        String defaultUDP = "udp";
        String defaultTCP = "tcp";
        /**
         * it receive a string
         */
        if (object.getClass() == String.class) {

            String s = (String) object;
            //System.out.println("TEXT ------------>" + s);           // use only for tests

            String tmp[] = s.split("@");
            //System.out.println(s.toLowerCase());
            /**
             * is a UDP
             */
            if (s.toLowerCase().contains(defaultUDP) && tmp.length == 7 && s.toLowerCase().contains("filetransfer")) {
                System.out.println(tmp.length);
                if (tmp.length == 7) {
                    addMachineToMap(s);
                }
            } /*
                return false;
            } /**
             * is a TCP
             */ else if (s.toLowerCase().contains(defaultTCP) && tmp.length == 9
                    && s.toLowerCase().contains("filetransfer")) {

                if (s.toLowerCase().contains("request")) {
                                    
                    File file = new File(shareFolder + "\\" + tmp[FILE_NAME]);
                    
                    if (s.toLowerCase().contains("permanent")) { 
                        PermanentFile pFile = new PermanentFile(networkMachinesList.findNetworkAddressByIP(tmp[4]),
                                file.getAbsolutePath(), false, new Date());
                    }

                    System.out.println("file to send " + s.toLowerCase());

                    FileConnectionTCP.SenderTCP fctcp = newTcpFileSender(file);

                    int tcpPortToRecieve = fctcp.getTcpPort();

                    if (tcpPortToRecieve != 0) {
                        String toSend = "@FileTransfer@FileSent@senderPort@TCP@" + tcpPortToRecieve + "@" + Utils.ownIpAddress().getAddress() + "@";
                        //System.out.println("SENDING-------->" + toSend);
                        sendTcp(toSend, Integer.parseInt(tmp[5]), networkMachinesList.findNetworkAddressByIP(tmp[4]));
                    }

                    //System.out.println("SENDING FILE!!!");

                    try {
                        fctcp.fileSender();
                    } catch (IOException ex) {
                        Logger.getLogger(ConnectionManagerFileTransfer.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    if (s.toLowerCase().contains("terminate")) {

                    }
                }

            } else if (s.toLowerCase().contains("filesent") && s.toLowerCase().contains(defaultTCP)) {

                System.out.println("FILE DOWNLOADED" + s);
                try {
                    Thread.sleep(90000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ConnectionManagerFileTransfer.class.getName()).log(Level.SEVERE, null, ex);
                }
                recieveTcpFile(downloadFolder + "\\" + downloadedFileName,
                        networkMachinesList.findNetworkAddressByIP(tmp[6]), Integer.parseInt(tmp[5]));
                System.out.println("FILE RECIEVED");

            }

        }

        return false;
    }

    public void setDownloadFolder(String downloadFolder) {
        this.downloadFolder = downloadFolder;
    }

    public void setShareFolder(String shareFolder) {
        this.shareFolder = shareFolder;
    }

    public NetworkMachinesTcpPortsList getNetworkMachinesList() {
        return networkMachinesList;
    }

    public void setDownloadedFileName(String downloadedFileName) {
        this.downloadedFileName = downloadedFileName;
    }
    
    public int getDownloadPort() {
        return downloadPortReciverTCP.getTcpPort();
    }

}
