package lapr4.red.s3.core.n1150834.persistingImages;

import java.util.EventListener;

/**
 * A listener for when an image is inserted into a cell
 *
 * @author 1150834
 */
public interface PersistentImageCellListener extends EventListener {

    /**
     * Method called when an image is insert to the selected cell
     *
     * @param cell the cell that was selected
     */
    public void insertImageChanged(PersistentImageCell cell);
}
