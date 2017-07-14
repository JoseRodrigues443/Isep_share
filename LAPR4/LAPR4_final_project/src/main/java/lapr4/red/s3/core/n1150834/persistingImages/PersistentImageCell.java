package lapr4.red.s3.core.n1150834.persistingImages;

import csheets.core.Cell;
import csheets.ext.CellExtension;
import java.util.ArrayList;
import java.util.List;

/**
 * Cell with persistent images
 *
 * @author 1150834
 */
public class PersistentImageCell extends CellExtension {

    /**
     * The listeners registered to receive events from the insertImageCell.
     */
    private final List<PersistentImageCellListener> listeners;

    /**
     * List that contains all the images of this cell
     */
    private final List<PersistentImage> imageList;

    /**
     * Creates a new PersistentImageCell
     *
     * @param cell the cell to extend
     */
    public PersistentImageCell(Cell cell) {
        super(cell, PersistingImagesExtension.NAME);
        listeners = new ArrayList<>();
        imageList = new ArrayList<>();
    }

    /**
     * Adds listener
     *
     * @param listener listener to be added
     */
    public void addInsertImageCellListener(PersistentImageCellListener listener) {
        if (listeners != null) {
            listeners.add(listener);
        }
    }

    /**
     * Removes given listener
     *
     * @param listener listener to be removed
     */
    public void removeInsertImageCellListener(PersistentImageCellListener listener) {
        if (listeners != null) {
            listeners.remove(listener);
        }
    }

    /**
     * Get the cell image list.
     *
     * @return The user suplied image list for the cell
     */
    public List<PersistentImage> getList() {
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
     * Add an image to the list
     *
     * @param image image to be added
     * @return return true if image was added successfully
     */
    public boolean addImage(PersistentImage image) {

        if (!imageList.contains(image)) {
            return imageList.add(image);
        }
        return true;
    }

    /**
     * Remove the image list
     *
     * @param image the image that is going to be removed
     * @return returns true if the image was succesfully removed
     */
    public boolean removeImage(PersistentImage image) {
        return imageList.remove(image);
    }
}
