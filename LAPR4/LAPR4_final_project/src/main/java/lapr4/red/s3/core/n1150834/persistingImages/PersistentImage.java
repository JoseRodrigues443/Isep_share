package lapr4.red.s3.core.n1150834.persistingImages;

import java.awt.Image;
import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 * Represents a persistan
 *
 * @author 1150834
 */
public class PersistentImage implements Serializable {

    /**
     * The image file
     */
    private ImageIcon image;

    /**
     * Creates a new PersistentImage
     *
     * @param image the image
     * @param name the image name
     */
    public PersistentImage(Image image, String name) {
        this.image = new ImageIcon(image, name);
    }

    /**
     * Creates a new PersistentImage
     */
    protected PersistentImage() {
    }

    /**
     * Returns the image
     *
     * @return the image
     */
    public ImageIcon image() {
        return image;
    }

    /**
     * Returns the name of the image
     *
     * @return the name of the image
     */
    @Override
    public String toString() {
        return image.getDescription();
    }
}
