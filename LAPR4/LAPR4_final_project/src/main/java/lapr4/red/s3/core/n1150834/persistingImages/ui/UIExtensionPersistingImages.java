package lapr4.red.s3.core.n1150834.persistingImages.ui;

import csheets.ext.Extension;
import csheets.ext.simple.ui.ExampleMenu;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;
import javax.swing.JMenu;
import lapr4.red.s3.core.n1150834.persistingImages.PersistingImagesExtension;

/**
 * This class implements the UI interface extension for the Persisting Images
 * extension.
 *
 * @author 1150834
 */
public class UIExtensionPersistingImages extends UIExtension {

    /**
     * The menu of the extension
     */
    private PersistingImagesMenu menu;
    /**
     * The panel of the extension
     */
    private PersistentImageSideBar sideBar;

    /**
     * The menu of the extension
     *
     * @param extension extension
     * @param uiController ui controller
     */
    public UIExtensionPersistingImages(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a side bar that to show and remove persistent images.
     *
     * @return a side bar, or null if the extension does not provide one
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new PersistentImageSideBar(uiController);
            sideBar.setName(PersistingImagesExtension.NAME);
        }
        return sideBar;
    }

    /**
     * Returns an instance of a class that implements JMenu.
     *
     * @see ExampleMenu
     * @return a JMenu component
     */
    @Override
    public JMenu getMenu() {
        if (menu == null) {
            menu = new PersistingImagesMenu(uiController);
        }
        return menu;
    }

}
