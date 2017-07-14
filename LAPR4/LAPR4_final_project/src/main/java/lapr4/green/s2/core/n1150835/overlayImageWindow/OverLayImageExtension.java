package lapr4.green.s2.core.n1150835.overlayImageWindow;

import csheets.core.Cell;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.blue.s1.core.n1150630.insertImage.InsertImageCell;
import lapr4.green.s2.core.n1150835.overlayImageWindow.ui.OverlayImageUIExtension;

/**
 *
 * @author 1150834
 */
public class OverLayImageExtension extends Extension {

    public OverLayImageExtension() {
        super("Overlay Image", "Description of Images", "2.0");
    }

    @Override
    public InsertImageCell extend(Cell cell) {
        return new InsertImageCell(cell);
    }

    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new OverlayImageUIExtension(this, uiController);
    }
}
