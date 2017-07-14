/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150767.multipleWorkbookSearch.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Catarina Sousa
 */
public class MultipleWorkbookSearch_Action extends BaseAction {
    
    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new export action
     *
     * @param uiController the user interface controller
     */
    public MultipleWorkbookSearch_Action(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     * Returns the action's name
     *
     * @return the action's name
     */
    @Override
    protected String getName() {
        return "Multiple Workbook Search";
    }

    @Override
    protected void defineProperties() {
    }

    /**
     * Creates a new ExportUI
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MultipleWorkbookSearchUI ui = new MultipleWorkbookSearchUI(uiController);
    }
}
