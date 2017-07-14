package lapr4.red.s3.core.n1150834.persistingImages.ui;

import csheets.ui.ctrl.UIController;
import java.io.FileNotFoundException;
import java.io.IOException;
import lapr4.red.s3.core.n1150834.persistingImages.ImportImage;

/**
 * A controller for importing images
 *
 * @author 1150834
 */
public class ImportImageController {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * Creates a new import controller
     *
     * @param uiController the user interface controller
     */
    public ImportImageController(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     * Imports the image indicated by the path
     *
     * @param path the image path
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void importImage(String path) throws FileNotFoundException, IOException {
        ImportImage in = new ImportImage(uiController, path);
        in.importImage();
    }
}
