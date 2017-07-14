/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150993.ImportExportData.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 *
 * @author 1150993
 */
public class ImportExportDatabaseMenu extends JMenu {

    public ImportExportDatabaseMenu(UIController uiController) {
        super("Import/Export Database");
        setMnemonic(KeyEvent.VK_E);
        add(new ImportExportDatabaseAction(uiController));

    }
}
