/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150605.functionBasicWizard.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class FunctionBasicWizardAction extends BaseAction {
    
   /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new action.
     *
     * @param uiController the user interface controller
     */
    public FunctionBasicWizardAction(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Function Basic Wizard";
    }

    @Override
    protected void defineProperties() {
    }

    /**
     * @param event the event that was fired
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        FunctionBasicWizardUI functionBasicWizardUI = new FunctionBasicWizardUI(uiController);
    }
    
}
