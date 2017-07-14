/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150759.ImportExportEmailAndPhone.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import lapr4.green.s3.ipc.n1150993.ImportExportData.ui.ImportExportDatabaseAction;

/**
 *
 * @author Jorge Campos <1150759@isep.ipp.pt>
 */
public class ImportExportEmailsAndPhonesMenu extends JMenu {
    /**
    * Creates a new simple menu
    * @param uiController the user interface controller
    */
   public ImportExportEmailsAndPhonesMenu(UIController uiController) {
        super("Import/Export");
        setMnemonic(KeyEvent.VK_E);

        add(new ImportExportEmailsAndPhonesAction(uiController));
        add(new ImportExportDatabaseAction(uiController));
   }	
}
