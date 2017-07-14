/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1141114.autoSorting.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.event.ActionEvent;
import java.awt.event.FocusListener;
import lapr4.red.s3.core.n1141114.autoSorting.application.AutoSortingController;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class AutoSortingAction extends FocusOwnerAction {

    /**
     * UIController
     */
    private UIController uiController;
    
    /**
     * Default constructor
     * @param uiController - UIController 
     */
    public AutoSortingAction(UIController uiController) {
        this.uiController = uiController;
    }

    /*returns the name*/
    @Override
    protected String getName() {
        return "Auto-Sorting";
    }
    
    /**
     * Returns the focusOwner
     * @return focusOwner
     */
    public SpreadsheetTable getFocusOwner(){
        return this.focusOwner;
    }

    /**
     * Action perfomed when the extension is pressed
     * @param e - ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        new AutoSortingController(uiController, this.focusOwner);
        }

}
