/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1141114.autoSorting.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class AutoSortingMenu extends JMenu {

    /**
     * Creates a JMenu with the sorting options
     *
     * @param uiController The User Interface Controller associated with this
     * instance
     */
    public AutoSortingMenu(UIController uiController) {
        super("Automatic Sorting");
        add(new AutoSortingAction(uiController));
    }

}
