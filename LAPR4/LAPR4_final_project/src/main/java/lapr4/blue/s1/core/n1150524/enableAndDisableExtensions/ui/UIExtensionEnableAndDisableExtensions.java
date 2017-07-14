/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JMenu;

/**
 *
 * @author Filipe
 */
public class UIExtensionEnableAndDisableExtensions extends UIExtension {

    JMenu menu;

    public UIExtensionEnableAndDisableExtensions(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns an instance of a class that implements JMenu. In this simple case
     * this class only supplies one menu option.
     *
     * @see ExampleMenu
     * @return a JMenu component
     */
    public JMenu getMenu() {
        if (menu == null) {
            menu = new EnableAndDisableExtensionsMenu(uiController);
        }
        return menu;
    }

}
