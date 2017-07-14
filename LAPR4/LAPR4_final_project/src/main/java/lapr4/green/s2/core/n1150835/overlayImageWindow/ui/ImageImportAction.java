package lapr4.green.s2.core.n1150835.overlayImageWindow.ui;

import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;
import lapr4.blue.s1.core.n1150630.insertImage.ImageExtension;
import lapr4.blue.s1.core.n1150630.insertImage.InsertImageCell;
import lapr4.blue.s1.core.n1150630.insertImage.ui.InsertImageUI;
import lapr4.green.s2.core.n1150835.overlayImageWindow.ImageBrowserListener;

/**
 *
 * @author 1150834
 */
public class ImageImportAction extends FocusOwnerAction {

    protected UIController uiController;

    public ImageImportAction(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Insert Image";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new InsertImageUI((InsertImageCell) uiController.getActiveCell().getExtension(ImageExtension.NAME), uiController);
        focusOwner.addMouseMotionListener((MouseMotionListener) new ImageBrowserListener());
    }

}
