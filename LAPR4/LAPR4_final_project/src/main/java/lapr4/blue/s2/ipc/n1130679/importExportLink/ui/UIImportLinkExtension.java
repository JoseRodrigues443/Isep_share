/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.ImportExportLink.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JMenu;

/**
 *
 * @author Ana Pacheco (1130679)
 */
public class UIImportLinkExtension extends UIExtension {

    private Icon icon;

    private ImportFileLinkMenu menu;

    public UIImportLinkExtension(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    @Override
    public Icon getIcon() {
        return null;
    }

    @Override
    public JMenu getMenu() {
        if (menu == null) {
            menu = new ImportFileLinkMenu(uiController);
        }
        return menu;
    }

}
