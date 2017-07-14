/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1141431.conditional.formatting.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**this class is to show the option conditinal formatted in Extensions->Style
 *
 * @author Pedro Oliveira 1141431
 */
public class ConditionalFormattingCellJMenu extends JMenu {

    /**
     * Creates a new menu and a menu item
     *
     * @param uiController the user interface controller
     */
    public ConditionalFormattingCellJMenu(UIController uiController) {
        super("Conditional Format of a Cell");

        // Adds font actions
        add(new ConditionalFormattingCellMenuAction(uiController));
 
    }
}
