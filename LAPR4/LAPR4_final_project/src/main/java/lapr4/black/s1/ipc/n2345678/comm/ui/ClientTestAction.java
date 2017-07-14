/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.black.s1.ipc.n2345678.comm.ui;

import lapr4.black.s1.ipc.n2345678.comm.CommClientWorker;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.JOptionPane;

/**
 *
 * @author alexandrebraganca
 */
public class ClientTestAction extends BaseAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new action.
     *
     * @param uiController the user interface controller
     */
    public ClientTestAction(UIController uiController) {
        this.uiController = uiController;
    }

    protected String getName() {
        return "Client Test...";
    }

    protected void defineProperties() {
    }

    /**
     * A simple action that presents a confirmation dialog. If the user confirms
     * then the contents of the cell A1 of the current sheet are set to the
     * string "Changed".
     *
     * @param event the event that was fired
     */
    public void actionPerformed(ActionEvent event) {

        // We will test the CommServer by connecting and sending the HelloRequestDTO
//        Socket clientSocket;
//        try {
//            clientSocket = new Socket(InetAddress.getLocalHost(), 15000);
////            client.connect(new InetSocketAddress(InetAddress.getLocalHost(), 15000));
////            client.setSoTimeout(500);
//            CommClientWorker client=new CommClientWorker(clientSocket);
//            
//            ObjectOutputStream outStream=client.getObjectOutputStream();
//
//            outStream.writeObject(new HelloRequestDTO("Hello!"));
//            clientSocket.close();
//        } catch (IOException ex) {
//            Logger.getLogger(ClientTestAction.class.getName()).log(Level.SEVERE, null, ex);
//        }

//		// Lets user select a font
//		int result=JOptionPane.showConfirmDialog(null, "You have selected the Example option. Do you want to set cell A1 to 'Changed'");
//		
//		if (result==JOptionPane.YES_OPTION) {
//		// Vamos exemplificar como se acede ao modelo de dominio (o workbook)
//		try {
//			this.uiController.getActiveSpreadsheet().getCell(0, 0).setContent("Changed");
//		} catch (Exception ex) {
//			// para ja ignoramos a excepcao
//		}
//		}
    }
}
