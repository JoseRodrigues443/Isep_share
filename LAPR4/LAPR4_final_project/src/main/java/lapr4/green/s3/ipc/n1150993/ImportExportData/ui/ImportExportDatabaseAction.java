/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150993.ImportExportData.ui;

import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author 1150993
 */
public class ImportExportDatabaseAction extends FocusOwnerAction{
    
    /**
     * The user interface controller
     */
    private UIController uiController;
    
    /**
     * Creates an instance of ImportExportDatabaseAction.
     *
     * @param uiController the user interface controller
     */
    public ImportExportDatabaseAction(UIController uiController){
        this.uiController=uiController;
    }

    @Override
    protected String getName() {
        return "Import/Export Database";
    }

    @Override
    protected void defineProperties() {
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MakeConnectionUI ui = new MakeConnectionUI(this.uiController, this.focusOwner);
        ui.show();
    }
}
