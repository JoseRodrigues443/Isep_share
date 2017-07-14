package lapr4.red.s3.core.n1150466.extensibleNavigator;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s3.core.n1150466.extensibleNavigator.ui.UIExtensibleNavigator;

/**
 *
 * @author Sebastiao
 */
public class ExtensibleNavigatorExtension extends Extension {

    public static final String NAME = "Extension Navigator v2";

    public ExtensibleNavigatorExtension() {
        super(NAME, "Navigates extensions with specific content", "2.0");
    }

    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensibleNavigator(this, uiController);
        //change to UIExtensibleNavigator
    }

}
