/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.ImportExportLink.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 *
 * @author Ana Pacheco (1130679)
 */
public class ImportFileLinkMenu extends JMenu {

    public ImportFileLinkMenu(UIController uiController) {
        super("Import Link");
        setMnemonic(KeyEvent.VK_I);

        add(new ImportFileLinkAction(uiController));
    }
}
