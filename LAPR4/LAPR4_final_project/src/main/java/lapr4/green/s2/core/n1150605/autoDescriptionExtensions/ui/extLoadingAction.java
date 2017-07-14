/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150605.autoDescriptionExtensions.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class extLoadingAction extends BaseAction {
    
    /**
     * The user interface controller
     */
    protected UIController uiController;

     /**
     * Creates a new action.
     *
     * @param uiController the user interface controller
     */
    public extLoadingAction(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Load Extensions";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        extLoadingUI extLoadingUI = new extLoadingUI(uiController);
    }
}

