/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150630.insertImage.ui;

import csheets.core.Spreadsheet;
import lapr4.blue.s1.core.n1150630.insertImage.InsertImageCell;
import csheets.ui.ctrl.UIController;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class InsertImageController {

    
    /**
     * The active spreadsheet
     */
    private Spreadsheet activeSpreadsheet;
    
    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * Main constructor
     *
     * @param uiController main controller of clean sheets
     */
    public InsertImageController(UIController uiController) {
        this.uiController = uiController;
    }

    protected InsertImageController() {
        //Just for test
    }

    /**
     * Method that adds the Image that is in that path to the selected cell
     *
     * @param cell Cell that is going to added a new Image
     * @param imagePath path to the image
     * @return returns true if the image was added succesfully
     */
    public boolean addImage(InsertImageCell cell, String imagePath) {
        return cell.addImage(imagePath);
    }
    
    /**
     * Returns the active spreadsheet.
     *
     * @return the active spreadsheet
     */
    public Spreadsheet getActiveSpreadsheet() {
        return activeSpreadsheet;
    }

}
