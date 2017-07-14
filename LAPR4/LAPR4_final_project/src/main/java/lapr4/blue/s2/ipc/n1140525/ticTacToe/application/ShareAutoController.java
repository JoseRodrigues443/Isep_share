/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.application;

import lapr4.blue.s2.ipc.n1150662.sharedCells.ui.*;
import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.SortedSet;
import lapr4.blue.s2.ipc.n1150662.sharedCells.CellsSelected;
import lapr4.red.s1.ipc.n1141114.netGames.ExtensionConnectionManagerGameCenter;
import lapr4.red.s1.ipc.n1150710.network.shareCell.SelectedCells;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkMachinesList;

/**
 *
 * @author bruno
 */
public class ShareAutoController {

    private UIController uiController;

    private SharePanelAuto uiPanel;

    private ExtensionConnectionManagerGameCenter manager;

    private SortedSet<Cell> cellsToShare;

    public ShareAutoController(UIController uiController, SharePanelAuto uiPanel, ExtensionConnectionManagerGameCenter c) {
        this.uiController = uiController;
        this.uiPanel = uiPanel;
        this.manager = c;
        cellsToShare = null;

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

    public boolean sendTcpCells(Object object, int tcpPort, NetworkAddress addressToSend) {
        return manager.sendTcpCells(object, tcpPort, addressToSend);
    }

    public Cell getSelectedCell() {
        return uiController.getActiveCell();
    }

    public ArrayList<String> getMachineList() {
        return manager.getMachineList();
    }

    public void changedCell(Cell cell, int tcpPort, NetworkAddress addressToSend) {
        sendTcpCells(cell, tcpPort, addressToSend);
    }
    public boolean start(){
        return manager.start();
    }
}
