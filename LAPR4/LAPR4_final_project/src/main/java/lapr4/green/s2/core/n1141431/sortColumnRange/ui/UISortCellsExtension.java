/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1141431.sortColumnRange.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JMenu;

/**
 *
 * @author Pedro Oliveira 1141431
 */
public class UISortCellsExtension extends UIExtension {

    /**
     * The JMenu associated with the extension
     */
    private SortCellsMenu menu;

    /**
     * Creates a new instance of UISortCellsExtension
     *
     * @param extension
     * @param uiController
     */
    public UISortCellsExtension(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns an instance of a class that implements JMenu.
     *
     * @return menu of extension
     */
    @Override
    public JMenu getMenu() {
        if (menu == null) {
            menu = new SortCellsMenu(this.uiController);
        }
        return menu;
    }
}
