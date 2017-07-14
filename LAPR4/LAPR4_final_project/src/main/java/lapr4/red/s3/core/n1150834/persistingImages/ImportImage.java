package lapr4.red.s3.core.n1150834.persistingImages;

import csheets.ui.ctrl.UIController;
import eapli.util.Strings;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Import image operation
 *
 * @author 1150834
 */
public class ImportImage {

    /**
     * The user interface controller
     */
    private UIController uiController;
    /**
     * The path to the image
     */
    private String path;

    /**
     * Creates a new ImportImage operations
     *
     * @param uiController the user interface controller
     * @param path the path to the image
     */
    public ImportImage(UIController uiController, String path) {
        if (Strings.isNullOrEmpty(path) || Strings.isNullOrWhiteSpace(path) || !isImagePath(path)) {
            throw new IllegalArgumentException("Image path can't be null, empty, or white space!");
        }
        this.path = path;
        this.uiController = uiController;
    }

    /**
     * Determines if the given path refers to an image
     *
     * @param path the image path
     * @return true if it is a image path, false otherwhise
     */
    private boolean isImagePath(String path) {
        return path.endsWith(".png") || path.endsWith(".jpg") || path.endsWith(".gif");
    }

    /**
     * Imports image represented by path
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void importImage() throws FileNotFoundException, IOException {
        File file = new File(path);

        BufferedImage img = ImageIO.read(file);

        Image dimg = img.getScaledInstance(img.getWidth(), img.getHeight(), Image.SCALE_SMOOTH);

        PersistentImage image = new PersistentImage(dimg, file.getName());

        PersistentImageCell cell = (PersistentImageCell) uiController.getActiveCell().getExtension(PersistingImagesExtension.NAME);

        cell.addImage(image);

    }
}
