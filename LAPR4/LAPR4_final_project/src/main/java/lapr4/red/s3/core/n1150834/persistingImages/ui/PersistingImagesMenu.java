package lapr4.red.s3.core.n1150834.persistingImages.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 * A menu that displays the import and enable/disable options
 *
 * @author 1150834
 */
public class PersistingImagesMenu extends JMenu {

    /**
     * Creates a new PersistingImagesMenu
     *
     * @param uiController the user interface controller
     */
    public PersistingImagesMenu(UIController uiController) {
        super("Persisting Images");

        add(new ImportImageAction(uiController));
        addSeparator();
        add(new EnableDisableAction(uiController));
    }

}
