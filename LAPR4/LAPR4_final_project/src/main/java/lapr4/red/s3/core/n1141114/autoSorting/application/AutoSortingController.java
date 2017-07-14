/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1141114.autoSorting.application;

import csheets.core.Cell;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class AutoSortingController {

    /**
     * The UIController
     */
    private UIController uiController;
    
    /**
     * Class that contains the thread updating the cell content when needed
     */
    private AutoSortingThread thread;

    /**
     * Default constructor
     * @param uiController - UIController
     * @param focusOwner - focusOwner
     */
    public AutoSortingController(UIController uiController, SpreadsheetTable focusOwner) {
        this.uiController = uiController;
        checkRange(focusOwner);
    }

    /**
     * Verifys if the selected range by the user is valid
     * @param focusOwner - focusOwner
     */
    public void checkRange(SpreadsheetTable focusOwner) {
        Cell range[][] = focusOwner.getSelectedCells();
        if (range.length == 1) {
            System.out.println("error");
        } else {
            System.out.println("SORTING STARTING --------------->");
            for (int i = 0; i < range.length; i++) {
                for (int j = 0; j < range[i].length; j++) {
                    StylableCell cell = (StylableCell) range[i][j].getExtension(StyleExtension.NAME);
                    cell.setBorder(new MatteBorder(1, 1, 1, 1, Color.RED));
                }
            }
            thread = new AutoSortingThread(range, uiController);
            thread.run();
        }
    }
}
