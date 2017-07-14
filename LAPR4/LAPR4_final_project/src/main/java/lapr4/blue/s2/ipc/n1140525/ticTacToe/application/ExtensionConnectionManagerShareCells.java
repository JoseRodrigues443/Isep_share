/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.application;

import lapr4.blue.s2.ipc.n1150662.sharedCells.*;
import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.IObservable;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.domain.IObserver;
import lapr4.blue.s2.ipc.n1150662.sharedCells.ui.SharePanelAuto;
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
 * @author bruno
 */
public class ExtensionConnectionManagerShareCells implements ConnectionManagerInterface, IObservable{

    /**
     * All the machines in the same network that use this extension
     */
    private final NetworkMachinesList networkMachinesList;

    private final NetworkAddress computerNetworkAddress;

    private final int udpPort;

    private String udpMessageToSend;

    private int cont;

    private int result;

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

    private final SharePanelAuto uiPanel;

    /**
     * send every 2 seconds a UDP
     */
    private final static int SECONDS_DEFAULT = 2;

    public ExtensionConnectionManagerShareCells(UIController uiController, SharePanelAuto uiPanel) {
        networkMachinesList = new NetworkMachinesList(NetworkExtensionEnum.SHARE_CELL_AUTO);
        this.uiController = uiController;
        this.uiPanel = uiPanel;
        this.cont = 0;

        /**
         * Own ip
         */
        this.computerNetworkAddress = Utils.ownIpAddress();

        udpPort = NetworkExtensionEnum.TIC_TAC_TOE.udpPort();
        boolean check = start();
    }

    @Override
    public boolean start() {
        this.receiverTCP = newTcpListener(this);

        this.udpMessageToSend = Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT + "UDP" + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + computerNetworkAddress.getAddress() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT
                + receiverTCP.getTcpPort() + Utils.SEPARATOR_FOR_UDP_ANNOUNCEMENTS_DEFAULT;

        sendAnnouncementTimedUDP(SECONDS_DEFAULT);

        udpListener();

        return true;
    }

    @Override
    public ArrayList<String> getMachineList() {
        ArrayList<String> list = new ArrayList<>();
        for (NetworkAddress address : networkMachinesList.findAllAdresses()) {
            list.add(address.getAddress());
        }
        return list;
    }

    @Override
    public boolean sendAnnouncementTimedUDP(int seconds) {
        int period = seconds * 1000;

        java.util.Timer udpTimer = new java.util.Timer();
        udpTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                ConnectionUDP conUDP = new ConnectionUDP(udpPort);

                String broadcast = computerNetworkAddress.getBroadcastAddress();
                NetworkAddress networkAddressTmp = new NetworkAddress(NetworkIpProtocolEnum.IPV4,
                        broadcast,
                        computerNetworkAddress.getMaskAddress(),
                        computerNetworkAddress.getBroadcastAddress(),
                        -1,
                        -1);

                conUDP.sendMessageUDP(udpMessageToSend, networkAddressTmp);
            }
        }, 0, period);

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

    @Override
    public ObjectConnectionTCP.ReceiverTCP newTcpListener(MessageReceiverInterface mri) {
        ObjectConnectionTCP cP = new ObjectConnectionTCP(0);

        return cP.tcpListener(mri);
    }

    @Override
    public boolean addMachineToMap(String udpAnnoucement) {
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
    public boolean messageReceivedTrigger(Object object) {
        String defaultUDP = "udp";
        String defaultTCP = "tcp";

        if (object.getClass() == String.class) {
            String s = (String) object;

            if (s.toLowerCase().contains(defaultUDP)) {

                addMachineToMap(s);
            } /**
             * is a TCP
             */
            else if (s.toLowerCase().contains(defaultTCP)) {

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
                Cell c = this.uiController.getActiveSpreadsheet().getCell(cdto.getAddress());

                StylableCell stylableCell = (StylableCell) c.getExtension(StyleExtension.NAME);
                try {
                    //cdto.setContent("Banana"); to test
                    this.uiController.getActiveSpreadsheet().getCell(cdto.getAddress()).setContent(cdto.getContent());
                    

                    stylableCell.setBackgroundColor(cdto.getStyleInfo().getBgColor());
                    stylableCell.setBorder(cdto.getStyleInfo().getBorder());
                    stylableCell.setFont(cdto.getStyleInfo().getFont());
                    stylableCell.setForegroundColor(cdto.getStyleInfo().getFgColor());
                    stylableCell.setFormat(cdto.getStyleInfo().getFormat());
                    stylableCell.setHorizontalAlignment(cdto.getStyleInfo().gethAlignment());
                    stylableCell.setVerticalAlignment(cdto.getStyleInfo().getvAlignment());
                    uiPanel.putON();

                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(ExtensionConnectionManagerShareCells.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    public NetworkAddress discoverMachineAddress() {
        return this.computerNetworkAddress;
    }

    public NetworkMachinesList returnMapMembers() {
        return networkMachinesList;
    }

    @Override
    public void registNewObserver(IObserver o) {
    }

    @Override
    public void notifyObservers() {
    }

    @Override
    public void notifyObserversYes() {
    }

    @Override
    public void notifyChangePort() {
    }

}
