package lapr4.red.s3.core.n1141114.autoSorting;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s3.core.n1141114.autoSorting.ui.UIExtensionAutoSorting;

/**
 *
 * @author Joao Fernandes - 1141114@isep.ipp.pt
 */
public class ExtensionAutoSorting extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Auto-Sorting";

    /**
     * Creates a new GameCenter extension.
     */
    public ExtensionAutoSorting() {
        super(NAME, "Auto-Sorting functionality", "1.0");
    }

    /**
     * Returns the user interface extension of this extension (an instance of
     * the class {@link  csheets.ext.simple.ui.UIGameCenterExtension}).
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionAutoSorting(this, uiController);
    }
}
