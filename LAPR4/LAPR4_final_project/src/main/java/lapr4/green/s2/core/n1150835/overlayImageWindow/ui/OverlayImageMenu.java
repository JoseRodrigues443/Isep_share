package lapr4.green.s2.core.n1150835.overlayImageWindow.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author 1150834
 */
class OverlayImageMenu extends JMenu {

    public OverlayImageMenu(UIController uiController) {
        super("Overlay Image");

        add(new ImageImportAction(uiController));
    }
}
