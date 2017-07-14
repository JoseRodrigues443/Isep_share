package lapr4.green.s2.core.n1150835.overlayImageWindow.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import javax.swing.JMenu;
import lapr4.blue.s1.core.n1150630.insertImage.ui.InsertImageUIExtension;
import lapr4.green.s2.core.n1150835.overlayImageWindow.ImageCellDecorator;

/**
 *
 * @author 1150834
 */
public class OverlayImageUIExtension extends InsertImageUIExtension {

    private OverlayImageMenu menu;

    private CellDecorator cellDecorator;

    public OverlayImageUIExtension(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a cell decorator that visualizes comments on cells.
     *
     * @return decorator for cells with comments
     */
    @Override
    public CellDecorator getCellDecorator() {
        if (cellDecorator == null) {
            cellDecorator = new ImageCellDecorator();
        }
        return cellDecorator;
    }

    /**
     * Returns a JMenu that provides to add an image to the selected cell
     *
     * @return an Menu
     */
    @Override
    public JMenu getMenu() {
        if (menu == null) {
            menu = new OverlayImageMenu(uiController);
        }
        return menu;
    }
}
