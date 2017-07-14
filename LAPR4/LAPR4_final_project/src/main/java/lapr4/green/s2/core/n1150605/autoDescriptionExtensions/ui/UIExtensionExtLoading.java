/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150605.autoDescriptionExtensions.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JMenu;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class UIExtensionExtLoading extends UIExtension {

    /*
    * the menu of the extension
    */
    JMenu menu;

    public UIExtensionExtLoading(Extension ext, UIController uiC) {
        super(ext, uiC);
    }

    /**
     * Returns an instance of a class that implements JMenu. In this simple case
     * this class only supplies one menu option.
     *
     * @see extLoadingMenu
     * @return a JMenu component
     */
    public JMenu getMenu() {
        if (menu == null) {
            menu = new extLoadingMenu(uiController);
        }
        return menu;
    }
}
