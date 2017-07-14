/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150630.insertImage;

import csheets.core.Cell;
import csheets.ext.CellExtension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class InsertImageCell extends CellExtension {

    /**
     * The listeners registered to receive events from the insertImageCell.
     */
    private final List<InsertImageCellListener> listeners = new ArrayList<>();

    /**
     * List that contains all the images of this cell
     */
    private final List<CellImage> imageList;

    /**
     * Creates a extension with image for the given cell.
     *
     * @param cell the cell to extend
     */
    public InsertImageCell(Cell cell) {
        super(cell, ImageExtension.NAME);
        this.imageList = new ArrayList<>();
    }

    /**
     * Get the cell image list.
     *
     * @return The user suplied image list for the cell
     */
    public List<CellImage> getImageList() {
        return this.imageList;
    }

    /**
     * Return whether the cell has an image
     *
     * @return true if the cell has a image
     */
    public boolean hasImage() {
        if (this.imageList == null) {
            return false;
        }
        return !this.imageList.isEmpty();
    }

    /**
     * Add an image to the list , if that image isn't in the list
     *
     * @param imagePath path to the image
     * @return return true if image was added successfully
     */
    public boolean addImage(String imagePath) {
        CellImage img = new CellImage(imagePath);
        if (!this.imageList.contains(img)) {
            this.imageList.add(img);
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method is to remove the CellImage from the cell list
     *
     * @param image the image that is going to be removed
     * @return returns true if the image was succesfully removed
     */
    public boolean removeImage(CellImage image) {
        return this.imageList.remove(image);
    }

    /**
     * Adds a listener to this class
     *
     * @param listener listener to be add
     */
    public void addInsertImageCellListener(InsertImageCellListener listener) {
        if (listeners != null) {
            listeners.add(listener);
        }
    }

    /**
     * Removes one of the listener of this class
     *
     * @param listener listener to be removed
     */
    public void removeInsertImageCellListener(InsertImageCellListener listener) {
        if (listeners != null) {
            listeners.remove(listener);
        }
    }
}
