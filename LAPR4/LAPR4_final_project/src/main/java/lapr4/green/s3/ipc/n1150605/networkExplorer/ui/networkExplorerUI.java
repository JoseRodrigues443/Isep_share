/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150605.networkExplorer.ui;

import csheets.CleanSheets;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import lapr4.green.s3.ipc.n1150605.networkExplorer.CleanSheetsInstance;
import lapr4.green.s3.ipc.n1150605.networkExplorer.application.networkExplorerController;
import lapr4.green.s3.ipc.n1150605.networkExplorer.networkExplorerExtension;
import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class networkExplorerUI extends JPanel {
    private UIController uiController;
    private networkExplorerController controller;
    private CleanSheets c;
    private NetworkAddress adressToSend;
    private int tcpPort;
    
    public networkExplorerUI(UIController uiC) {
        super(new BorderLayout());
        
        setName(networkExplorerExtension.NAME);
        this.uiController = uiC;
        controller = new networkExplorerController(uiController, this);
        
        this.c = uiController.getCleanSheets();
        
        do {

        } while (controller.getMachineList().isEmpty());
        
        if (controller.getMachineList().size() > 0) {
            
        
        
        this.adressToSend = controller.discoverMachineAddress();
      //  System.out.println("AddressToSend------------"+adressToSend);
        this.tcpPort = controller.returnMapMembers().findTCPPortByAddress(adressToSend);
        
     //  System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<"+tcpPort);  
    // System.out.println("---EXTENSIONS:´"+uiController.getExtensions());
     // controller.sendTcp(new CleanSheetsInstance(uiController), tcpPort, adressToSend);
         
       
        }
        createComponents();
    }

    private void createComponents() {
        JPanel p = new JPanel(new GridLayout(2,2));
        
        JPanel p1 = new JPanel(new BorderLayout());
        JButton b = new JButton("Botao");
        
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               controller.sendTcp(new CleanSheetsInstance(), tcpPort, adressToSend);
               System.out.println(controller.getMachineList().size());
            }
            
            
        });
                
        p1.add(b, BorderLayout.CENTER);
        
        p.add(p1);
        
        add(p);
    }
}
