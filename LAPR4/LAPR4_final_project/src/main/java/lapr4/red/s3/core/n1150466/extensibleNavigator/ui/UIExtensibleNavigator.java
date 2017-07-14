package lapr4.red.s3.core.n1150466.extensibleNavigator.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 *
 * @author Sebastiao
 */
public class UIExtensibleNavigator extends UIExtension{
     private JComponent sideBar;

    public UIExtensibleNavigator(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a side bar that gives access to extension-specific functionality.
     *
     * @return a component, or null if the extension does not provide one
     */
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new ExtensibleNavigatorPanel(uiController);
        }
        return sideBar;
    }
}
