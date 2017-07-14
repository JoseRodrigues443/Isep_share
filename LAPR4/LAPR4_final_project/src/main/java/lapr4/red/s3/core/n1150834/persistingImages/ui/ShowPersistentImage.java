package lapr4.red.s3.core.n1150834.persistingImages.ui;

import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.blue.s1.core.n1150630.insertImage.ui.InsertImageUI;
import lapr4.red.s3.core.n1150834.persistingImages.PersistentImage;
import lapr4.red.s3.core.n1150834.persistingImages.PersistentImageCell;

/**
 * An operation used for showing a cell's images
 *
 * @author 1150834
 */
public class ShowPersistentImage {

    /**
     * Controller for cleansheets
     */
    private UIController uiController;

    /**
     * Panel that calls this controller
     */
    private PersistentImageSideBar uiPanel;

    /**
     * Current image
     */
    private PersistentImage activeImage;

    /**
     * Current selected cell
     */
    private PersistentImageCell activeCell;

    public ShowPersistentImage(UIController uiController, PersistentImageSideBar uiPanel) {
        this.uiController = uiController;
        this.uiPanel = uiPanel;

    }

    protected ShowPersistentImage() {
    }

    /**
     * When a cell is selected in cleansheets this method updates the activeCell
     * and the image showed in the panel
     *
     * @param cell New cell selected
     */
    public void cellSelected(PersistentImageCell cell) {
        if (cell.hasImage()) {
            activeCell = cell;
            activeImage = cell.getList().get(0);
            uiPanel.setImage(cell.getList().get(0));
        } else {
            activeCell = cell;
            uiPanel.setImage(null);
        }
    }

    /**
     * Method that returns a String with the path to the next image;
     *
     * @return returns a String with a path to the next CellImage.
     */
    public PersistentImage nexCellImage() {
        int index = activeCell.getList().indexOf(activeImage);
        activeImage = activeCell.getList().get(index + 1);
        return activeImage;

    }

    /**
     * Method that returns a String with the path to the previous image.
     *
     * @return returns a String with a path to the previous image.
     */
    public PersistentImage previousCellImage() {
        int index = activeCell.getList().indexOf(activeImage);
        activeImage = activeCell.getList().get(index - 1);
        return activeImage;
    }

    /**
     * Method that checks if this cell has Next image
     *
     * @return true if the cell has at least one more image after the current
     * one.
     */
    public boolean hasNextCellImage() {
        int index = activeCell.getList().indexOf(activeImage);
        if (index < activeCell.getList().size() - 1) {
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
        int index = activeCell.getList().indexOf(activeImage);
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
        int index = activeCell.getList().indexOf(activeImage);
        if (activeCell.removeImage(activeImage) == true) {
            JOptionPane.showMessageDialog(null, "Image successfully removed");
        }
        if (activeCell.getList().isEmpty()) {
            uiPanel.setImage(null);
            activeImage = null;
            try {
                this.uiController.getActiveSpreadsheet().getCell(activeCell.getAddress()).setContent("");
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(InsertImageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (index == 0) {
            activeImage = activeCell.getList().get(0);
            uiPanel.setImage(activeImage);
            try {
                this.uiController.getActiveSpreadsheet().getCell(activeCell.getAddress()).setContent(activeCell.getList().toString());
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(InsertImageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            activeImage = activeCell.getList().get(index - 1);
            uiPanel.setImage(activeImage);
            try {
                this.uiController.getActiveSpreadsheet().getCell(activeCell.getAddress()).setContent(activeCell.getList().toString());
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(InsertImageUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
