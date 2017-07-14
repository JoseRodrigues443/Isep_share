package lapr4.red.s3.core.n1150834.persistingImages;

import csheets.core.Cell;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s3.core.n1150834.persistingImages.ui.UIExtensionPersistingImages;

/**
 * The extension for Persisting Images
 *
 * @author 1150834
 */
public class PersistingImagesExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Persisting Images";

    /**
     * Creates a new PersistingImagesExtension
     */
    public PersistingImagesExtension() {

        super(NAME, "Description of Images", "3.0");
    }
    /**
     * Returns an extension of the given cell.
     *
     * @param cell the cell to extend
     * @return a cell extension, or null if none is provided
     */
    @Override
    public PersistentImageCell extend(Cell cell) {
        return new PersistentImageCell(cell);
    }
    /**
     * Returns a user interface extension for Persisting Images.
     *
     * @param uiController the user interface controller
     * @return a user interface extension for Persisting Images
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionPersistingImages(this, uiController);
    }
}
