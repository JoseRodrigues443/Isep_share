/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1141114.netGames;

import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.application.ExtensionConnectionManagerShareCells;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.application.GameCenterController;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.IObservable;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.IObserver;
import lapr4.blue.s2.ipc.n1150662.sharedCells.CellsSelected;
import lapr4.blue.s2.ipc.n1150662.sharedCells.DTOCell;
import lapr4.red.s1.ipc.n1141114.netGames.NetworkMachinesListProfiles;
import lapr4.red.s1.ipc.n1141114.netGames.UserProfile;
import lapr4.red.s1.ipc.network.library.ConnectionManagerInterface;
import lapr4.red.s1.ipc.network.library.ConnectionUDP;
import lapr4.red.s1.ipc.network.library.MessageReceiverInterface;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkExtensionEnum;
import lapr4.red.s1.ipc.network.library.NetworkIpProtocolEnum;
import lapr4.red.s1.ipc.network.library.NetworkMachinesList;
import lapr4.red.s1.ipc.network.library.ObjectConnectionTCP;
import lapr4.red.s1.ipc.network.library.TextConnectionTCP;
import lapr4.red.s1.ipc.network.library.Utils;
import csheets.ui.ctrl.UIController;


/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class ExtensionConnectionManagerGameCenter implements ConnectionManagerInterface, IObservable{

    /**
     * all the machines in the network that use these extension
     */
    private NetworkMachinesList networkMachinesList;
    
    private NetworkMachinesListProfiles networkMachinesListProfile;

    private NetworkAddress computerNetworkAddress;
    
    private int udpPort;

    private String udpMessageToSend;

    private String userAnswer;

    private String profileActive;

    private String imageDir;
    
    private ArrayList allObservers;
    private int result;

    private int cont;

    /**
     * listens all the tcp request
     */
    private TextConnectionTCP.ReceiverTCP receiverTCP;

    /**
     * listen all udp request
     */
    private ConnectionUDP.UDPReceiverManager receiverUDP;

    private UIController ui;
    /**
     * send every 2 seconds a UDP
     */
    private final static int SECONDS_DEFAULT = 2;

    public ExtensionConnectionManagerGameCenter(UIController ui) {
        // networkMachinesList = new NetworkMachinesList(NetworkExtensionEnum.GAME_CENTER);
        networkMachinesListProfile = new NetworkMachinesListProfiles(NetworkExtensionEnum.GAME_CENTER);
        allObservers = new ArrayList();        /**
         * discover own ip address
         */
        computerNetworkAddress = Utils.ownIpAddress();

        userAnswer = "No";
        profileActive = "NotActive";
        imageDir = "";
        this.ui=ui;
        this.cont = 0;

        udpPort = NetworkExtensionEnum.TIC_TAC_TOE.udpPort();
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
        this.receiverTCP = newTcpListenerText(this);
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
            String tmp[] = s.split("@");
            //System.out.println(s.toLowerCase());
            /**
             * is a UDP
             */
            
            if (s.toLowerCase().contains(defaultUDP) && !s.toLowerCase().contains("notactive")) {
                //System.out.println(tmp.length);
                if (tmp.length == 7) {
                    //System.out.println("ENTREI!!!!!!!!!!!!!!!!!!------------------->\n");
                    addMachineToMap(s);
                }
            } /**
             * is a TCP
             */
            else if (s.toLowerCase().contains(defaultTCP) && tmp.length == 9
                    && !s.toLowerCase().contains("yes")) {
                if (s.toLowerCase().contains("exit")) {
                    JOptionPane.showMessageDialog(null, "The opposite user ended the game!", "End Game", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    String string[] = s.split("@");

                    int answer;
                    String[] optionsForUser = {"Yes", "No"};
                    answer = JOptionPane.showOptionDialog(
                            null, "The user " + string[6] + " sent you an invite to play "+string[8]+"! Do you wish to accept?",
                            "Information Message!",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            optionsForUser,
                            optionsForUser[1]);
                    if (answer == 0) {
                        userAnswer = "Yes";
                        String sendMessage = s + "Yes@";
                        notifyObservers();
                        int index = -1;
                        int returnTcp = 0;
                        for (UserProfile profile : networkMachinesListProfile.findAllAdresses()) {
                            index++;
                            if (profile.getName().equals(string[6])) {
                                UserProfile temp = (UserProfile) networkMachinesListProfile.allMapMembers().keySet().toArray()[index];
                                returnTcp = networkMachinesListProfile.allMapMembers().get(temp);
                                GameCenterController g= GameCenterController.getInstance();
                               // notifyObserversYes(); 
                               g.StartNewGame(string[8], computerNetworkAddress.getAddress(), true,"notme");
                                sendTcp(sendMessage, returnTcp, temp.getAddress());

                                break;
                            }
                        }
                    } else {
                        userAnswer = "No";
                        String sendMessage = s + "No@";
                        int index = -1;
                        int returnTcp = 0;
                        for (UserProfile profile : networkMachinesListProfile.findAllAdresses()) {
                            index++;
                            if (profile.getName().equals(string[6])) {
                                UserProfile temp = (UserProfile) networkMachinesListProfile.allMapMembers().keySet().toArray()[index];
                                returnTcp = networkMachinesListProfile.allMapMembers().get(temp);
                                sendTcp(sendMessage, returnTcp, temp.getAddress());
                                break;
                            }
                        }
                    }
                }
            } else if (s.toLowerCase().contains(defaultTCP) && s.toLowerCase().contains("yes")) {
                userAnswer = "Yes";
                JOptionPane.showMessageDialog(null, "Game starting shortly!", "Invite accepted", JOptionPane.INFORMATION_MESSAGE);
            } else if (s.toLowerCase().contains(defaultTCP) && s.toLowerCase().contains("no")) {
                userAnswer = "No";
                JOptionPane.showMessageDialog(null, "The user refused the invite! Try again!", "Invite refused", JOptionPane.INFORMATION_MESSAGE);
            }
        } /**
         * is a specific object, EX: selected cells OR chat
         */
        else {
//            
            if (object.getClass().equals(CellsSelected.class)) {
                CellsSelected selectedCells = (CellsSelected) object;

                writeInCells(selectedCells);

            }
        }
        
        return false;
    }
    
    
     private void writeInCells(CellsSelected selectedCells) {

        if (cont == 0) {
            int size = selectedCells.getCellDTOs().size();
            String toMessage = "Hello, a user ("
                    + selectedCells.getObjectOriginAddress().getAddress()
                    + ") have shared with you " + size + " cell's. "
                    + "\nThey will be inserted between the cells: " + selectedCells.getCellDTOs().get(0).cellIdentificationToHumanFormat()
                    + " - " + selectedCells.getCellDTOs().get(size - 1).cellIdentificationToHumanFormat()
                    + "\n(yes to see help window)";

            result = JOptionPane.showConfirmDialog(null, toMessage);
        }
        cont++;
        if (result == JOptionPane.YES_OPTION) {
            for (DTOCell cdto : selectedCells.getCellDTOs()) {
                Cell c = this.ui.getActiveSpreadsheet().getCell(cdto.getAddress());

                StylableCell stylableCell = (StylableCell) c.getExtension(StyleExtension.NAME);
                try {
                    //cdto.setContent("Banana"); to test
                    this.ui.getActiveSpreadsheet().getCell(cdto.getAddress()).setContent(cdto.getContent());
                    

                    stylableCell.setBackgroundColor(cdto.getStyleInfo().getBgColor());
                    stylableCell.setBorder(cdto.getStyleInfo().getBorder());
                    stylableCell.setFont(cdto.getStyleInfo().getFont());
                    stylableCell.setForegroundColor(cdto.getStyleInfo().getFgColor());
                    stylableCell.setFormat(cdto.getStyleInfo().getFormat());
                    stylableCell.setHorizontalAlignment(cdto.getStyleInfo().gethAlignment());
                    stylableCell.setVerticalAlignment(cdto.getStyleInfo().getvAlignment());

                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(ExtensionConnectionManagerShareCells.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
    

    @Override
    public boolean sendAnnouncementTimedUDP(int seconds) {

        /*amount of time to the run method be executed again*/
        int timeInterval = seconds * 1000;
        java.util.Timer timerToSendUdp = new java.util.Timer();
        timerToSendUdp.schedule(new TimerTask() {
            @Override
            public void run() {
                /**
                 * example: @udp@192.168.0.1@2222@@
                 */
                udpMessageToSend = Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT + "UDP" + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                        + getComputerNetworkAddress().getAddress() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                        + receiverTCP.getTcpPort() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                        + profileActive + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                        + System.getProperty("user.name") + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                        + imageDir;
                ConnectionUDP connectionUDP = new ConnectionUDP(udpPort);
                /**
                 * network addres , but for the broadcast network
                 */
                String broadcast = getComputerNetworkAddress().getBroadcastAddress();
                NetworkAddress networkAddressTmp = new NetworkAddress(NetworkIpProtocolEnum.IPV4,
                        broadcast,
                        getComputerNetworkAddress().getMaskAddress(),
                        getComputerNetworkAddress().getBroadcastAddress(),
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

    @Override
    public boolean sendTcp(Object object, int tcpPort, NetworkAddress addressToSend) {
        String s = (String) object;
        TextConnectionTCP textConnectionTCP = new TextConnectionTCP(tcpPort);
        return textConnectionTCP.tcpSenderSendMessage(s, addressToSend);
    }
    public boolean sendTcpCells(Object object, int tcpPort, NetworkAddress addressToSend) {
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
                    this.getComputerNetworkAddress().getMaskAddress(),
                    this.getComputerNetworkAddress().getBroadcastAddress(),
                    -1,
                    tcpPort);
            UserProfile profile = new UserProfile(splited[5], imageDir, networkAddressTmp);
            return networkMachinesListProfile.addNewMemberToMap(profile, tcpPort);
        }
        return false;
    }

    public TextConnectionTCP.ReceiverTCP newTcpListenerText(MessageReceiverInterface mri) {
        TextConnectionTCP cP = new TextConnectionTCP(0);

        return cP.tcpListener(mri);
    }

    public NetworkMachinesList returnMapMembers() {
        return this.networkMachinesList;
    }

    public NetworkMachinesListProfiles returnMapProfileMembers() {
        return this.networkMachinesListProfile;
    }

    public NetworkAddress discoverMachineAddress() {
        return this.getComputerNetworkAddress();
    }

    public String userAnswer() {
        return this.userAnswer;
    }

    public void defineProfileActive(String profileActive, String imageDir) {
        this.profileActive = profileActive;
        this.imageDir = imageDir;
    }

    @Override
    public ObjectConnectionTCP.ReceiverTCP newTcpListener(MessageReceiverInterface mri) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<UserProfile> getMachineProfiles() {
        ArrayList<UserProfile> toReturn = new ArrayList<>();
        for (UserProfile profile : networkMachinesListProfile.findAllAdresses()) {
            toReturn.add(profile);
        }
        return toReturn;
    }

    /**
     * @return the computerNetworkAddress
     */
    public NetworkAddress getComputerNetworkAddress() {
        return computerNetworkAddress;
    }

    @Override
    public void registNewObserver(IObserver o) {
        allObservers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < allObservers.size(); i++) {
            IObserver obs = (IObserver) allObservers.get(i);
        }
    }

    @Override
    public void notifyObserversYes() {
       for (int i = 0; i < allObservers.size(); i++) {
            IObserver obs = (IObserver) allObservers.get(i);
            obs.createSpreadsheet();
        }
    }

    @Override
    public void notifyChangePort() {
    }

}
