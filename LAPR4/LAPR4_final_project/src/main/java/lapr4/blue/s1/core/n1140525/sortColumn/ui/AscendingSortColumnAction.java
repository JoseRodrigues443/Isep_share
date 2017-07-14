/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1140525.sortColumn.ui;

import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.blue.s1.core.n1140525.sortColumn.application.SortColumnController;

/**
 *
 * @author MariaJoão
 */
public class AscendingSortColumnAction extends BaseAction {

    UIController ctrlUI;
    SortColumnController ctrlSort;
    
    public AscendingSortColumnAction(UIController ui) {
        this.ctrlUI=ui;
    }

    /*returns the name*/
    @Override
    protected String getName() {
        return "Ascending Sort Column";
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        ctrlSort = new SortColumnController(ctrlUI);
        try {
            ctrlSort.ascendSorting();
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(DescendingSortColumnAction.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Column Sorted");
    }
}

   
