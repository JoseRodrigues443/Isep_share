/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150630.insertImage;

import csheets.core.Cell;
import csheets.ext.Extension;
import lapr4.blue.s1.core.n1150630.insertImage.ui.InsertImageUIExtension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author David
 */
public class ImageExtension extends Extension {

    public static final String NAME = "Images";

    /**
     * Creates an object ImageExtension
     */
    public ImageExtension() {
        super(NAME, "Description of Images", "1.0");
    }

    /**
     * Returns an extension of the given cell.
     *
     * @param cell the cell to extend
     * @return a cell extension, or null if none is provided
     */
    @Override
    public InsertImageCell extend(Cell cell) {
        return new InsertImageCell(cell);
    }

    /**
     * Returns the user interface extension of this extension.
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new InsertImageUIExtension(this, uiController);
    }
}
