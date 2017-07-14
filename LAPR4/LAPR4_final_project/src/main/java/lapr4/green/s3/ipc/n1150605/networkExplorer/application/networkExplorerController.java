/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150605.networkExplorer.application;

import csheets.CleanSheets;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.TreeMap;
import lapr4.green.s3.ipc.n1150605.networkExplorer.CleanSheetsInstance;
import lapr4.green.s3.ipc.n1150605.networkExplorer.ExtensionConnectionManagerNetworkExplorer;
import lapr4.green.s3.ipc.n1150605.networkExplorer.ui.networkExplorerUI;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkMachinesList;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class networkExplorerController {
    /**
     * the user interface controller
     */
    private UIController uiController;
    
    /**
     * the connection manager
     */
    private ExtensionConnectionManagerNetworkExplorer manager;
    
    /** 
     * Class constructor.
     * @param uic, the user interface controller
     * @param ui, use case UI
     */
    public networkExplorerController(UIController uic, networkExplorerUI ui) {
        this.uiController = uic;
        this.manager = new ExtensionConnectionManagerNetworkExplorer(uic, ui, this);
    }
    
    public NetworkAddress discoverMachineAddress() {
        return manager.discoverMachineAddress();
    }

    public NetworkMachinesList returnMapMembers() {
        return manager.returnMapMembers();
    }

    public boolean sendTcp(Object object, int tcpPort, NetworkAddress addressToSend) {
        return manager.sendTcp(object, tcpPort, addressToSend);
    }

    public TreeMap<NetworkAddress, Integer> getMachineList() {
        return manager.returnMapMembers().allMapMembers();
    }
    
    public boolean start() {
        return manager.start();
    }
}
