/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1140412.fileSharing;

import java.util.ArrayList;
import java.util.TimerTask;
import lapr4.red.s1.ipc.n1140412.fileShareApplication.FileShareController;
import lapr4.red.s1.ipc.n1140412.fileShareApplication.NetworkMachinesAndFileList;
import lapr4.red.s1.ipc.network.library.*;

/**
 *
 * @author Tiago
 * @author Filipe Correia <1150524@isep.ipp.pt> getNetworkMachinesList
 */
public class ConnectionManagerFileSharing implements ConnectionManagerInterface {

    /**
     * all the machines in the network that use these extension
     */
    private NetworkMachinesAndFileList networkMachinesList;

    private NetworkAddress computerNetworkAddress;

    private final int udpPort;

    private String udpMessageToSend;

    private FileShareController controller;

    /**
     * listens all the tcp request
     */
    private ObjectConnectionTCP.ReceiverTCP receiverTCP;

    /**
     * listen all udp request
     */
    private ConnectionUDP.UDPReceiverManager receiverUDP;

    /**
     *
     * @param controller
     */
    public ConnectionManagerFileSharing(FileShareController controller) {
        networkMachinesList = new NetworkMachinesAndFileList(NetworkExtensionEnum.FILE_SHARING);
        this.controller = controller;

        /**
         * discover own ip address
         */
        computerNetworkAddress = Utils.ownIpAddress();

        udpPort = NetworkExtensionEnum.FILE_SHARING.udpPort();
        start();
    }
    /**
     * send every 2 seconds a UDP
     */
    private final static int SECONDS_DEFAULT = 7;

    @Override
    public boolean start() {
        /**
         * starts a listener
         */
        this.receiverTCP = newTcpListener(this);
        /**
         * example: @udp@192.168.0.1@2222@@
         */
        udpMessageToSend = Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT + "UDP" + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + computerNetworkAddress.getAddress() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + receiverTCP.getTcpPort() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT;

        /**
         * every N seconds send an UDP
         */
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

    /**
     * Sends an Announcement UDP in a specified time interval
     *
     * @param seconds
     * @return
     */
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
                connectionUDP.sendMessageUDP(udpMessageToSend, networkAddressTmp);
            }

        }, 0, timeInterval);

        return true;
    }

    /**
     * Sends a TCP to a given address
     *
     * @param object
     * @param tcpPort
     * @param addressToSend
     * @return
     */
    @Override
    public boolean sendTcp(Object object, int tcpPort, NetworkAddress addressToSend) {
        ObjectConnectionTCP objectConnectionTCP = new ObjectConnectionTCP(tcpPort);
        return objectConnectionTCP.tcpSenderSendMessage(object, addressToSend);
    }

    /**
     * Udp Listener
     */
    @Override
    public void udpListener() {
        ConnectionUDP connectionUDP = new ConnectionUDP(this.udpPort);
        this.receiverUDP = connectionUDP.startReceiveMessage(this);
    }

    /**
     * New Tcp Listener
     *
     * @param mri
     * @return
     */
    @Override
    public ObjectConnectionTCP.ReceiverTCP newTcpListener(MessageReceiverInterface mri) {
        ObjectConnectionTCP cP = new ObjectConnectionTCP(0);

        return cP.tcpListener(mri);
    }

    /**
     * Adds a new Machine to the network machine map
     *
     * @param tcpAnnoucement
     * @return
     */
    @Override
    public boolean addMachineToMap(String tcpAnnoucement) {
        //System.out.println("--> »»»»» maps = " + udpAnnoucement);
        ArrayList<String> files = new ArrayList<>();
        int ipLocaton = 2;
        int tcpLocation = 3;
        String splited[] = tcpAnnoucement.split(Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT);
        if (splited.length == 0) {
            return false;
        }
        String address = splited[ipLocaton];
        if (Utils.validateAddress(address, NetworkIpProtocolEnum.IPV4)
                && splited.length > (tcpLocation + 1)) {
            int tcpPort = Integer.parseInt(splited[tcpLocation]);
            NetworkAddress networkAddressTmp = new NetworkAddress(NetworkIpProtocolEnum.IPV4,
                    address,
                    this.computerNetworkAddress.getMaskAddress(),
                    this.computerNetworkAddress.getBroadcastAddress(),
                    -1,
                    tcpPort);
            /**
             * get files
             */
            for (int i = (tcpLocation + 1); i < splited.length; i++) {
                files.add(splited[i]);
            }
            networkMachinesList.addNewMemberToMap(networkAddressTmp, tcpPort, files);
            return true;
        }
        return false;
    }

    /**
     * Message Received Trigger
     *
     * @param object
     * @return
     */
    @Override
    public boolean messageReceivedTrigger(Object object) {
        String defaultUDP = "udp";
        String defaultTCP = "tcp";
        //System.out.println("--> $$$$$ --> trigred");
        /**
         * it receive a string
         */
        if (object.getClass() == String.class) {
            String s = (String) object;
            //System.out.println("--> $$$$$  ▀ ▀ ▀ ▀ --> String: " + s);
            /**
             * is a UDP
             */
            if (s.toLowerCase().contains(defaultUDP)) {
//                System.out.println("--> $$$$$  ▀▓▀▓▀▓▀▓▀▓▀▓▀ --> String: " + s);
                sendTcpToWithFileList(s);
            } /**
             * is a TCP
             */
            else if (s.toLowerCase().contains(defaultTCP)) {
//                System.out.println("--> $$$$$  ░▀░▓░▀░▓░▀░▓░▀░▀▀▀▀▀▀▀▀▀▀▀ --> String: " + s);
                addMachineToMap(s);
            }
        } else {
            //System.out.println("▓░▓░▓░▓░▓░▓░▓ Object receiveid in classe: " + this.getClass().getCanonicalName()
            // + "\n ▀▀▀▀▀▀▀▀▀▀ The classe received was: " + object.getClass().getCanonicalName());
        }
        return false;
    }

    /**
     * @tcp@192.168.0.1@1111@text.txt@pao.txt@reerere.jpeg@
     * @param tcpAnnoucement
     * @return
     */
    private boolean sendTcpToWithFileList(String tcpAnnoucement) {
        //System.out.println("--> »»»»» maps = " + udpAnnoucement);
        ArrayList<String> files = new ArrayList<>();
        int ipLocaton = 2;
        int tcpLocation = 3;
        String splited[] = tcpAnnoucement.split(Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT);
        if (splited.length == 0) {
            return false;
        }
        String address = splited[ipLocaton];
        if (Utils.validateAddress(address, NetworkIpProtocolEnum.IPV4)) {
            int tcpPort = Integer.parseInt(splited[tcpLocation]);
            NetworkAddress networkAddressTmp = new NetworkAddress(NetworkIpProtocolEnum.IPV4,
                    address,
                    this.computerNetworkAddress.getMaskAddress(),
                    this.computerNetworkAddress.getBroadcastAddress(),
                    -1,
                    tcpPort);
            /**
             * @tcp@192.168.0.1@11111@
             */
            String toSend = Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT + "tcp" + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                    + this.computerNetworkAddress.getAddress() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                    + this.receiverTCP.getTcpPort() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT;
            ArrayList<String> al = controller.shareFileList(controller.getShareDirectoryPath());
            ArrayList<String> sizes = controller.fileSizeList(controller.getShareDirectoryPath());
            for (int i = 0; i < al.size(); i++) {
                toSend += al.get(i) + "|| Size: " + sizes.get(i) + "|| From: " + System.getProperty("user.name") + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT;
            }

            /**
             *
             */
            sendTcp(toSend, tcpPort, networkAddressTmp);
            //networkMachinesList.addNewMemberToMap(networkAddressTmp, tcpPort, files);
            return true;
        }
        return false;
    }

    /**
     * all files to download
     *
     * @return
     */
    public ArrayList<String> filesListToDownloadWithData() {
        return this.networkMachinesList.findAllFilesWithData();
    }
    
    public NetworkMachinesAndFileList getNetworkMachinesAndFileList() {
        return networkMachinesList;
    }
}
