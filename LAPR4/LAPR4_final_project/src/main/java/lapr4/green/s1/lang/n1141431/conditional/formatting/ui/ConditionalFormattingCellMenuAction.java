/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1141431.conditional.formatting.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 * this class makes that when the menu item Conditional Formatting of cell is
 * selected a menu item named "create" appears
 *
 * @author Utilizador
 */
public class ConditionalFormattingCellMenuAction extends BaseAction {

    private UIController uiController;

    ConditionalFormattingCellMenuAction(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     * name for the menu item
     *
     * @return
     */
    @Override
    protected String getName() {
        return "create";
    }

    /**
     * returns a window where the condition will be written
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        UIConditionalFormattingJFrame window = new UIConditionalFormattingJFrame(uiController);
       

    }

}
