/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1141431.sortColumnRange.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import lapr4.green.s2.core.n1141431.sortColumnRange.ctr.SortColumnController;


/**
 *
 * @author Pedro Oliveira 1141431
 */
public class DescendingSortRangeCellsAction extends BaseAction {

    UIController ctrlUI;
    SortColumnController ctrlSort;

    public DescendingSortRangeCellsAction(UIController ui) {
        this.ctrlUI = ui;
    }

    @Override
    protected String getName() {
        return "Descending Sort Column";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ctrlSort = new SortColumnController(ctrlUI);
 
         
           SortRangeUI window = new SortRangeUI(ctrlUI, ctrlSort, 1); 
    
    }

}
