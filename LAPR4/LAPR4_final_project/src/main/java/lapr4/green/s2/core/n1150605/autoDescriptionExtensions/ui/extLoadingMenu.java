/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150605.autoDescriptionExtensions.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Miguel Morgado
 */
public class extLoadingMenu extends JMenu {

    /**
     * Creates a new simple menu
     * @param uiController the user interface controller
     */
    public extLoadingMenu(UIController uiController) {
        super("Load extensions");
        add(new extLoadingAction(uiController));
    }
}
