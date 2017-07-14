/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150630.insertImage.ui;

import csheets.core.formula.compiler.FormulaCompilationException;
import lapr4.blue.s1.core.n1150630.insertImage.CellImage;
import lapr4.blue.s1.core.n1150630.insertImage.InsertImageCell;
import csheets.ui.ctrl.UIController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class ShowImage {

    /**
     * Controller for cleansheets
     */
    private UIController uiController;

    /**
     * Panel that calls this controller
     */
    private ImagePanel uiPanel;

    /**
     * Current image
     */
    private CellImage activeImage;

    /**
     * Current selected cell
     */
    private InsertImageCell activeCell;

    public ShowImage(UIController uiController, ImagePanel uiPanel) {
        this.uiController = uiController;
        this.uiPanel = uiPanel;

    }

    protected ShowImage() {
        //Just for unit Test
    }

    /**
     * When a cell is selected in cleansheets this method updates the activeCell
     * and the image showed in the panel
     *
     * @param cell New cell selected
     */
    public void cellSelected(InsertImageCell cell) {
        if (cell.hasImage()) {
            activeCell = cell;
            activeImage = cell.getImageList().get(0);
            uiPanel.setImage(cell.getImageList().get(0).getImagePath());
        } else {
            activeCell = cell;
            uiPanel.setImage("This cell has no image.");
        }
    }

    /**
     * Method that returns a String with the path to the next image;
     *
     * @return returns a String with a path to the next CellImage.
     */
    public String nexCellImage() {
        int index = activeCell.getImageList().indexOf(activeImage);
        activeImage = activeCell.getImageList().get(index + 1);
        return activeImage.getImagePath();

    }

    /**
     * Method that returns a String with the path to the previous image.
     *
     * @return returns a String with a path to the previous image.
     */
    public String previousCellImage() {
        int index = activeCell.getImageList().indexOf(activeImage);
        activeImage = activeCell.getImageList().get(index - 1);
        return activeImage.getImagePath();
    }

    /**
     * Method that checks if this cell has Next image
     *
     * @return true if the cell has at least one more image after the current
     * one.
     */
    public boolean hasNextCellImage() {
        int index = activeCell.getImageList().indexOf(activeImage);
        if (index < activeCell.getImageList().size() - 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method that checks if this cell has previous image
     *
     * @return true if the cell has at least one more image before the current
     * one.
     */
    public boolean hasPreviousCellImage() {
        int index = activeCell.getImageList().indexOf(activeImage);
        if (index > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method the checks if an image is beeing displayed
     *
     * @return true if there is an image beeing displayed
     */
    public boolean hasImage() {
        if (activeImage != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes the current displayed image from the pannel and deletes her from
     * the cell list
     */
    public void removeImage() {
        int index = activeCell.getImageList().indexOf(activeImage);
        if (activeCell.removeImage(activeImage) == true) {
            JOptionPane.showMessageDialog(null, "Image successfully removed");
        }
        if (activeCell.getImageList().isEmpty()) {
            uiPanel.setImage("This cell has no image.");
            activeImage = null;
            try {
                this.uiController.getActiveSpreadsheet().getCell(activeCell.getAddress()).setContent("");
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(InsertImageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (index == 0) {
            activeImage = activeCell.getImageList().get(0);
            uiPanel.setImage(activeImage.getImagePath());
            try {
                this.uiController.getActiveSpreadsheet().getCell(activeCell.getAddress()).setContent(activeCell.getImageList().toString());
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(InsertImageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            activeImage = activeCell.getImageList().get(index - 1);
            uiPanel.setImage(activeImage.getImagePath());
            try {
                this.uiController.getActiveSpreadsheet().getCell(activeCell.getAddress()).setContent(activeCell.getImageList().toString());
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(InsertImageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
