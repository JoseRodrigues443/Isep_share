/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.importExportLink.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 *
 * @author Ana
 */
public class ExportFileLinkMenu extends JMenu {

       public ExportFileLinkMenu(UIController uiController) {
        super("ExportLink");
        setMnemonic(KeyEvent.VK_E);

        // Adds font actions
        add(new ExportFileLinkAction(uiController));
    }
}
