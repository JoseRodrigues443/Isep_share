/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150630.insertImage;

import java.util.Objects;

/**
 *
 * @author David
 */
public class CellImage {

    /**
     * String that contains the image's path
     */
    private String imagePath;

    /**
     * Creates an object Image with an image's string
     *
     * @param imagePath path to the image
     */
    public CellImage(String imagePath) {
        if (validatePath(imagePath)) {
            this.imagePath = imagePath;
        }
    }

    /**
     * return the string that contains the path
     *
     * @return a String with the path
     */
    public String getImagePath() {
        return this.imagePath;
    }

    /**
     * Method to validade the path Method is valid if the path is not null or
     * empty
     *
     * @param path path to validade
     * @return returns true if the path is valid
     */
    private boolean validatePath(String imagePath) {
        return !"".equals(imagePath);
    }

    @Override
    public String toString() {
        return String.format("The image's path is %s.\n", this.imagePath);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof CellImage)) {
            return false;
        }

        final CellImage that = (CellImage) obj;
        if (!this.imagePath.equals(that.imagePath)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.imagePath);
        return hash;
    }

}
