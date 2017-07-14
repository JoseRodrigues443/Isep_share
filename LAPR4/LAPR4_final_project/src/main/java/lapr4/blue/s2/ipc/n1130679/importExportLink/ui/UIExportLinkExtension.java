/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.importExportLink.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JMenu;

/**
 *
 * @author Ana
 */
public class UIExportLinkExtension extends UIExtension {

    private Icon icon;

    private ExportFileLinkMenu menu;

    public UIExportLinkExtension(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    @Override
    public Icon getIcon() {
        return null;
    }

    @Override
    public JMenu getMenu() {
        if (menu == null) {
            menu = new ExportFileLinkMenu(uiController);
        }
        return menu;
    }

}
