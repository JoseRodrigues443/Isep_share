/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1151117.chatApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.green.s3.ipc.n1150759.chatApplication.IObservableChatRoom;
import lapr4.green.s3.ipc.n1150759.chatApplication.IObservableChatRoomList;
import lapr4.green.s3.ipc.n1150759.chatApplication.IObserverChatRoom;
import lapr4.green.s3.ipc.n1150759.chatApplication.IObserverChatRoomList;
import lapr4.red.s1.ipc.n1141114.netGames.NetworkMachinesListProfiles;
import lapr4.red.s1.ipc.n1141114.netGames.UserProfile;
import lapr4.red.s1.ipc.n1150825.networkingTools.domain.SecureCommunication;
import lapr4.red.s1.ipc.n1151117.chatApplication.domain.Chat;
import lapr4.red.s1.ipc.n1151117.chatApplication.domain.Message;
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
 * @author Barros
 */
public class ExtensionConnectionManagerChatApplication implements 
        ConnectionManagerInterface, IObservable, IObservableChatRoom,
        IObservableChatRoomList {

    /**
     * the encrypter/decrypter responsible
     */
    private SecureCommunication secureCommunication;
    /**
     * message received by tcp
     */
    private Message receivedMessage;
    
    /**
     * Chat room created
     */
    private Chat receivedChatRoom;
    
    /**
     * ArrayList to store all the observers
     */
    private ArrayList allObservers;
    
    /**
     * Chat room observers
     */
    private ArrayList chatRoomObservers;
    
    /**
     * Chat room list observers
     */
    private ArrayList chatRoomListObservers;
    
    /**
     * all the machines in the network that use these extension
     */
    private NetworkMachinesList networkMachinesList;

    /**
     * Added for the s2 that requires a profile
     */
    private NetworkMachinesListProfiles networkMachinesListProfile;

    private NetworkAddress computerNetworkAddress;

    private final int udpPort;

    private String udpMessageToSend;

    /**
     * Added for the s2 that requires a image and nickname associated to the
     * profile
     */
    private String imageDir;
    private String nickname;
    private String status;

    /**
     * listens all the tcp request
     */
    private ObjectConnectionTCP.ReceiverTCP receiverTCP;

    /**
     * listen all udp request
     */
    private ConnectionUDP.UDPReceiverManager receiverUDP;

    /**
     * send every 2 seconds a UDP
     */
    private final static int SECONDS_DEFAULT = 2;

    public ExtensionConnectionManagerChatApplication() {
        secureCommunication = new SecureCommunication();
        receivedMessage = null;
        allObservers = new ArrayList();
        chatRoomObservers = new ArrayList();
        chatRoomListObservers = new ArrayList();
        networkMachinesList = new NetworkMachinesList(NetworkExtensionEnum.CHAT);
        networkMachinesListProfile = new NetworkMachinesListProfiles(NetworkExtensionEnum.CHAT);
        /**
         * discover own ip address
         */
        computerNetworkAddress = Utils.ownIpAddress();

        udpPort = NetworkExtensionEnum.CHAT.udpPort();
        start();
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
        /**
         * Added parameters for s2 system name, nickname and imagedir (lines
         * 119,120)
         */
        udpMessageToSend = messageToSend();

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
        /**
         * it receive a string
         */
        if (object.getClass() == String.class) {
            String s = (String) object;
            /**
             * is a UDP
             */
            if (s.toLowerCase().contains(defaultUDP)) {
                //System.out.println("CHAT -> " + s);
                addMachineToMap(s);
                notifyObserversNewUser();
            } /**
             * is a TCP
             */
            else if (s.toLowerCase().contains(defaultTCP)) {
                /**
                 * do nothing
                 */
            }
        } /**
         * is a specific object, EX: selected cells OR chat
         */
        else if (object instanceof Message) {
            receivedMessage = (Message) object;
            if (receivedMessage.allReceivers().isEmpty())
                notifyObservers();
            else
                notifyObserversChatRoom();
        } else if (object instanceof byte[]) {
            try {
                Message m = (Message) secureCommunication.deCrypt(object);
                receivedMessage = m;
                notifyObservers();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ExtensionConnectionManagerChatApplication.class.getName()).log(Level.FINE, null, ex);
            }
        } else if (object instanceof Chat) {
            receivedChatRoom = (Chat) object;
            notifyObserversChatRoomList();
        }
        return false;
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
                 * network addres , but for the broadcast network
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
                udpMessageToSend = messageToSend();
                connectionUDP.sendMessageUDP(udpMessageToSend, networkAddressTmp);
            }

        }, 0, timeInterval);

        return true;
    }

    @Override
    public boolean sendTcp(Object object, int tcpPort, NetworkAddress addressToSend) {
        ObjectConnectionTCP objectConnectionTCP = new ObjectConnectionTCP(tcpPort);
        return objectConnectionTCP.tcpSenderSendMessage(object, addressToSend);
    }

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
        //System.out.println("--> »»»»» maps");
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
            //the next seven lines are added for the s2, where is required a new a profile
            for (UserProfile machineProfile : getMachineProfiles()) {
                if (machineProfile.getAddress().getAddress().equals(networkAddressTmp.getAddress())) {
                    networkMachinesListProfile.removeMapMember(machineProfile);
                }
                if (machineProfile.getStatus().equals("Offline")) {
                    networkMachinesListProfile.removeMapMember(machineProfile);

                }
            }
            if (splited[6].equals("Online")) {
                UserProfile tmp = new UserProfile(splited[4], splited[7], networkAddressTmp, splited[5], splited[6]);
                networkMachinesListProfile.addNewMemberToMap(tmp, tcpPort);
                return networkMachinesList.addNewMemberToMap(networkAddressTmp, tcpPort);
            }
        }
        return false;
    }

    public NetworkMachinesList returnMapMembers() {
        return networkMachinesList;
    }

    /**
     * Added for the s2, to return the profiles of other users
     *
     * @return a map of user profiles and tcp ports
     */
    public NetworkMachinesListProfiles returnMapProfileMembers() {
        return this.networkMachinesListProfile;
    }

    public TreeMap<NetworkAddress, Integer> allMapMembers() {
        return networkMachinesList.allMapMembers();
    }

    /**
     * Added for the s2, to return an array of profiles
     *
     * @return an array of profiles
     */
    public ArrayList<UserProfile> getMachineProfiles() {
        ArrayList<UserProfile> toReturn = new ArrayList<>();
        for (UserProfile profile : networkMachinesListProfile.findAllAdresses()) {
            toReturn.add(profile);
        }
        return toReturn;
    }

    /**
     * Added for the s2, to update the user's nickname and photo
     *
     * @param nickname the user's nickname
     * @param imageDir the user's image directory
     */
    public void updateProfileInfo(String nickname, String imageDir, String status) {
        this.nickname = nickname;
        this.imageDir = imageDir;
        this.status = status;
    }

    @Override
    public ObjectConnectionTCP.ReceiverTCP newTcpListener(MessageReceiverInterface mri) {
        ObjectConnectionTCP cP = new ObjectConnectionTCP(-1);

        return cP.tcpListener(mri);
    }

    private String messageToSend() {
        return Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT + "UDP" + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + computerNetworkAddress.getAddress() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + receiverTCP.getTcpPort() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + System.getProperty("user.name") + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + nickname + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + status + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT + imageDir;
    }

    @Override
    public void registNewObserver(IObserver o) {
        allObservers.add(o);
    }
    
    @Override
    public void registNewChatRoomObserver(IObserverChatRoom o) {
        chatRoomObservers.add(o);
    }
    
    @Override
    public void registNewChatRoomListObserver(IObserverChatRoomList o) {
        chatRoomListObservers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < allObservers.size(); i++) {
            IObserver obs = (IObserver) allObservers.get(i);
            obs.showPopUp(receivedMessage);
        }
    }

    @Override
    public void notifyObserversNewUser() {
        for (int i = 0; i < allObservers.size(); i++) {
            IObserver obs = (IObserver) allObservers.get(i);
            obs.updateUsersList();
        }
    }
    
    @Override
    public void notifyObserversChatRoom() {
        for (int i = 0; i < chatRoomObservers.size(); i++) {
            IObserverChatRoom obs = (IObserverChatRoom) chatRoomObservers.get(i);
            obs.updateChat(receivedMessage);
        }
    }
    
    @Override
    public void notifyObserversChatRoomList() {
        System.out.println("received "+receivedChatRoom.toString());
        for (int i = 0; i < chatRoomListObservers.size(); i++) {
            IObserverChatRoomList obs = (IObserverChatRoomList) chatRoomListObservers.get(i);
            obs.updateChatRoomList(receivedChatRoom);
        }
    }

    public String findProfileNickByIP(String ip) {
        for (UserProfile object : networkMachinesListProfile.findAllAdresses()) {
            if (object.getAddress().getAddress().equals(ip)) {
                return object.getNickname();
            }
        }
        return null;
    }
}
