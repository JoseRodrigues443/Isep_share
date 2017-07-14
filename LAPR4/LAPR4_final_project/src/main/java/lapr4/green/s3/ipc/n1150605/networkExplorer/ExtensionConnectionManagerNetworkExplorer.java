/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150605.networkExplorer;

import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.TreeMap;
import lapr4.green.s3.ipc.n1150605.networkExplorer.application.networkExplorerController;
import lapr4.green.s3.ipc.n1150605.networkExplorer.ui.JTreeWindow;
import lapr4.green.s3.ipc.n1150605.networkExplorer.ui.networkExplorerUI;
import lapr4.red.s1.ipc.network.library.ConnectionManagerInterface;
import lapr4.red.s1.ipc.network.library.ConnectionUDP;
import lapr4.red.s1.ipc.network.library.MessageReceiverInterface;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkExtensionEnum;
import lapr4.red.s1.ipc.network.library.NetworkIpProtocolEnum;
import lapr4.red.s1.ipc.network.library.NetworkMachinesList;
import lapr4.red.s1.ipc.network.library.ObjectConnectionTCP;
import lapr4.red.s1.ipc.network.library.Utils;

/**
 *
 * @author Miguel Morgado 1150605
 */
   
public class ExtensionConnectionManagerNetworkExplorer implements ConnectionManagerInterface {

    /**
     * all the machines in the network that use these extension
     */
    private final NetworkMachinesList networkMachinesList;

    private final NetworkAddress computerNetworkAddress;

    private final int udpPort;

    private String udpMessageToSend;
    
    private Extension[] allExtensions = ExtensionManager.getInstance().getExtensions();
    
    private networkExplorerController controller;

    /**
     * listens all the tcp request
     */
    private ObjectConnectionTCP.ReceiverTCP receiverTCP;

    /**
     * listen all udp request
     */
    private ConnectionUDP.UDPReceiverManager receiverUDP;
    /**
     * used to write in cells
     */
    private final UIController uiController;
    
    private networkExplorerUI ui;

    /**
     * send every 2 seconds a UDP
     */
    private final static int SECONDS_DEFAULT = 2;

    /**
     *
     * @param uic used to write in cells
     * @param ui
     * @param c, controller
     */
    public ExtensionConnectionManagerNetworkExplorer(UIController uic, networkExplorerUI ui, networkExplorerController c) {
        networkMachinesList = new NetworkMachinesList(NetworkExtensionEnum.NETWORK_EXPLORER);
        this.controller = c;
        this.uiController = uic;
        this.ui = ui;
        /**
         * discover own ip address
         */
        computerNetworkAddress = Utils.ownIpAddress();

        udpPort = NetworkExtensionEnum.NETWORK_EXPLORER.udpPort();
        boolean start = start();
    }

    /**
     * starts all the dependencies for the use case
     *
     * Dependencies: -> UDP listener and sender -> TCP listener -> map with all
     * the machines in network
     *
     * @return
     */
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

    /**
     * get all machine address
     *
     * @return
     */
    @Override
    public ArrayList<String> getMachineList() {
        ArrayList<String> toReturn = new ArrayList<>();
        for (NetworkAddress address : networkMachinesList.findAllAdresses()) {
            toReturn.add(address.getAddress());
        }
        return toReturn;
    }

    /**
     * when an udp
     *
     * @param object
     * @return
     */
    @Override
    public boolean messageReceivedTrigger(Object object) {
        String defaultUDP = "udp";
        String defaultTCP = "tcp";
        //System.out.println("--> $$$$$ --> Tignred");
        /**
         * it receive a string
         */
        if (object.getClass() == String.class) {
            String s = (String) object;
            //System.out.println("--> $$$$$ --> String");
            /**
             * is a UDP
             */
            if (s.toLowerCase().contains(defaultUDP)) {
                //System.out.println("--> »»»»»»$$$$$ --> UDP");
                addMachineToMap(s);
            } /**
             * is a TCP
             */
            else if (s.toLowerCase().contains(defaultTCP)) {
                //DO SOMETHING
            }
        } /**
         * is a specific object, EX: selected cells OR chat
         */
        
        else if (object.getClass() == CleanSheetsInstance.class) {
             CleanSheetsInstance s = (CleanSheetsInstance) object;
             System.out.println("------------siiiiimmmm");
             new JTreeWindow(s, allExtensions, uiController);
            /*  int size = s.getExtensions().length;
            for (int i=0; i<size; i++) {
            System.out.println(s.getExtensions()[i]);
            }*/
        }
        
        else {
            System.out.println("▓░▓░▓░▓░▓░▓░▓ Object receiveid in classe: " + this.getClass().getCanonicalName()
                   + "\n ▀▀▀▀▀▀▀▀▀▀ The classe received was: " + object.getClass().getCanonicalName()+"\nObject: "+object.toString());
            //DO SOMETHING WITH THAT OBJECT
            
        }
        return true;
    }

    /**
     * sends an udp request every n "seconds"
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
     * send TCp objet, object must be seriazable
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
     * receive udp in thread
     */
    @Override
    public void udpListener() {
        ConnectionUDP connectionUDP = new ConnectionUDP(this.udpPort);
        this.receiverUDP = connectionUDP.startReceiveMessage(this);
    }

    /**
     * To receive: @shareCell@Address@TcpPort@
     *
     * @param udpAnnoucement
     * @return
     */
    @Override
    public boolean addMachineToMap(String udpAnnoucement) {
        //System.out.println("--> »»»»» maps = " + udpAnnoucement);
        int ipLocaton = 2;
        int tcpLocation = 3;
        String splited[] = udpAnnoucement.split(Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT);
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
            networkMachinesList.addNewMemberToMap(networkAddressTmp, tcpPort);
            return true;
        }
        return false;
    }

    @Override
    public ObjectConnectionTCP.ReceiverTCP newTcpListener(MessageReceiverInterface mri) {
        ObjectConnectionTCP cP = new ObjectConnectionTCP(0);

        return cP.tcpListener(mri);
    }

    public TreeMap<NetworkAddress, Integer> allMapMembers() {
        return networkMachinesList.allMapMembers();
    }

    public NetworkMachinesList returnMapMembers() {
        return networkMachinesList;
    }

    public NetworkAddress discoverMachineAddress() {
        return this.computerNetworkAddress;
    }

}

