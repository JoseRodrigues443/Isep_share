package lapr4.red.s1.ipc.n1150710.network.shareCell.ui;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.SortedSet;
import javax.swing.JFrame;
import lapr4.red.s1.ipc.n1150710.network.shareCell.ExtensionConnectionManager;
import lapr4.red.s1.ipc.n1150710.network.shareCell.SelectedCells;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkMachinesList;

/**
 * A controller for updating the user-specified share of a cell.
 *
 * @author 1150710@isep.ipp.pt
 */
public class ShareController {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * User interface panel *
     */
    private SharePanel uiPanel;

    /**
     * manager of UDP and TCP elements
     */
    private ExtensionConnectionManager extensionConnectionManager;

    private SortedSet<Cell> cellsToShare;

    /**
     * Creates a new comment controller.
     *
     * @param uiController the user interface controller
     * @param uiPanel the user interface panel
     */
    public ShareController(UIController uiController, SharePanel uiPanel) {
        this.uiController = uiController;
        this.uiPanel = uiPanel;
        this.extensionConnectionManager = new ExtensionConnectionManager(uiController);
        cellsToShare = null;
        //run();

    }

//    /**
//     * TODO remove for UI testing
//     */
//    private void run() {
//        //____________________________________
//
//        JFrame frame = new JFrame("JFrame para testar");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setContentPane(uiPanel);
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }

    public ArrayList<String> getMachineList() {
        return extensionConnectionManager.getMachineList();
    }

    public NetworkMachinesList returnMapMembers() {
        return extensionConnectionManager.returnMapMembers();
    }

    public NetworkAddress discoverMachineAddress() {
        return extensionConnectionManager.discoverMachineAddress();
    }

    public boolean sendTcp(Object object, int tcpPort, NetworkAddress addressToSend) {
        return extensionConnectionManager.sendTcp(object, tcpPort, addressToSend);
    }

    public SortedSet<Cell> getCells(Address address1, Address address2) {
        return uiController.getActiveSpreadsheet().getCells(address1, address2);
    }

    public Spreadsheet getThisSpreadSheet() {
        return uiController.getActiveSpreadsheet();
    }

    public Cell getSelectedCell() {
        return uiController.getActiveCell();
    }

    public void setSortedCell(SortedSet<Cell> cellsToShare) {
        this.cellsToShare = cellsToShare;
    }
    public SelectedCells selectedCells(SortedSet<Cell> cellsToShare){
        return new SelectedCells(cellsToShare, this.extensionConnectionManager.discoverMachineAddress());
    }
    
}
