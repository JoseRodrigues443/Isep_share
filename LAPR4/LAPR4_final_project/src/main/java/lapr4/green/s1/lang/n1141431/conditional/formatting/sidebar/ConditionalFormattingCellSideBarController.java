/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1141431.conditional.formatting.sidebar;

import csheets.ui.ctrl.UIController;
import javax.swing.JTextArea;

/**
 * this will change the text in the sidebar
 *
 * @author Pedro Oliveira 1141431
 */
public class ConditionalFormattingCellSideBarController {

    private UIController uiController;

    public ConditionalFormattingCellSideBarController(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     * Set the text in sideBar,with the information of the condition inserted on
     * the window that is displayed for that purpose
     *
     *
     */
    public void setText(JTextArea jtext) {

        String str = "";
        if (uiController.getCondition() != null) {
            str = uiController.getCondition();

        } else {
            str = "";

        }

        jtext.setText(str);
    }
}
