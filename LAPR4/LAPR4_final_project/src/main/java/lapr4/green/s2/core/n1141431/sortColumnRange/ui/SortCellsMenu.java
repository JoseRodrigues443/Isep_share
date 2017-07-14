/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1141431.sortColumnRange.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Pedro Oliveira 1141431
 */
public class SortCellsMenu extends JMenu {

    /**
     * Creates a JMenu with the sorting options
     *
     * @param uiController The User Interface Controller associated with this
     * instance
     */
    public SortCellsMenu(UIController uiController) {
        super("Cells Sort v2");
        add(new AscendingSortRangeCellsAction(uiController));
        add(new DescendingSortRangeCellsAction(uiController));
    }

}
