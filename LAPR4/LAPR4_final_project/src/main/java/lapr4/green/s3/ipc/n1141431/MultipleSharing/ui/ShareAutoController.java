/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1141431.MultipleSharing.ui;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.SortedSet;
import lapr4.green.s3.ipc.n1141431.MultipleSharing.CellsSelected;
import lapr4.green.s3.ipc.n1141431.MultipleSharing.ExtensionConnectionManager;

import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkMachinesList;

/**
 *
 * @author Pedro Oliveira 1141431
 */
public class ShareAutoController {

    private UIController uiController;

    private SharePanelAuto uiPanel;

    private ExtensionConnectionManager manager;

    private SortedSet<Cell> cellsToShare;

    public ShareAutoController(UIController uiController, SharePanelAuto uiPanel) { //
        this.uiController = uiController;
        this.manager = new ExtensionConnectionManager(uiController, uiPanel);
        cellsToShare = null;

    }
/*
    for testing purposes 
    */
    public ShareAutoController() {
    }

    public NetworkAddress discoverMachineAddress() {
        return manager.discoverMachineAddress();
    }

    public NetworkMachinesList returnMapMembers() {
        return manager.returnMapMembers();
    }

    public SortedSet<Cell> getCells(Address address1, Address address2) {
        return uiController.getActiveSpreadsheet().getCells(address1, address2);
    }

    public CellsSelected selectedCells(SortedSet<Cell> cellsToShare) {
        return new CellsSelected(cellsToShare, this.manager.discoverMachineAddress());
    }

    public boolean sendTcp(Object object, int tcpPort, NetworkAddress addressToSend) {
        return manager.sendTcp(object, tcpPort, addressToSend);
    }

    public Cell getSelectedCell() {
        return uiController.getActiveCell();
    }

    public ArrayList<String> getMachineList() {
        return manager.getMachineList();
    }

    public void stopThread() {
        manager.stopThread();
    }

    public boolean start() {
        return manager.start();
    }

    public void putOFF() {
        manager.putOFF();
    }

}
