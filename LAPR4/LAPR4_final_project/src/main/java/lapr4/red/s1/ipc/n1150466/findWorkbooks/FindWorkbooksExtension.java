package lapr4.red.s1.ipc.n1150466.findWorkbooks;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s1.ipc.n1150466.findWorkbooks.ui.FindWorkbooksExtensionUI;

public class FindWorkbooksExtension extends Extension {
    
    /**
     * The extension name.
     */
    public static final String NAME = "Find Workbooks";
    /**
     * Creates a new FindWorkbooksExtension
     */
    public FindWorkbooksExtension() {
        super(NAME, "Description of Find Workbooks", "1.0");
    }
    
    /**
     * Returns the UI used in the extension
     * @param uiController the user interface controller
     * @return new FindWorkbooksExtensionUI object
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new FindWorkbooksExtensionUI(this, uiController);
    }

}
