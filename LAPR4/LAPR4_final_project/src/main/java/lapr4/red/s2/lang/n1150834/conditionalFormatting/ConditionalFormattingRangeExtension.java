package lapr4.red.s2.lang.n1150834.conditionalFormatting;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s2.lang.n1150834.conditionalFormatting.ui.UIExtensionConditionalFormattingRange;

/**
 * The extension for import and export Conditional Formatting of Ranges
 *
 * @author 1150834
 */
public class ConditionalFormattingRangeExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Conditional Range Formatting";

    /**
     * Creates a new ConditionalFormattingRange extension.
     */
    public ConditionalFormattingRangeExtension() {
        super(NAME, "Description of Conditional Range Formatting", "1.0");
    }

    /**
     * Returns a user interface extension for conditional range formatting
     * operations.
     *
     * @param uiController the user interface controller
     * @return a user interface extension for conditional range formatting
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        if (this.uiExtension == null) {
            this.uiExtension = new UIExtensionConditionalFormattingRange(this, uiController);
        }
        return uiExtension;
    }

    /**
     * Alter's the side bar in order to indicate which format is being used
     *
     * @param inUse the format being used
     */
    public void inUse(String inUse) {
        UIExtensionConditionalFormattingRange ui = (UIExtensionConditionalFormattingRange) uiExtension;
        ui.inUse(inUse);
    }
}
