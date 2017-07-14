package lapr4.red.s2.lang.n1150834.conditionalFormatting.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 * This class implements the UI interface extension for the Conditional
 * Formatting of Ranges extension.
 *
 * @author 1150834
 */
public class UIExtensionConditionalFormattingRange extends UIExtension {

    /**
     * The side bar of the extension
     */
    private ConditionalFormattingRangeSideBar bar;

    /**
     * The menu of the extension
     *
     * @param extension extension
     * @param uiController ui controller
     */
    public UIExtensionConditionalFormattingRange(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a side bar that provides editing of comments.
     *
     * @return a side bar, or null if the extension does not provide one
     */
    public JComponent getSideBar() {
        if (bar == null) {
            bar = new ConditionalFormattingRangeSideBar(uiController);
        }
        return bar;
    }

    /**
     * Indicates the format that is currently being used
     *
     * @param inUse the format being used
     */
    public void inUse(String inUse) {
        bar.setinUse(inUse);
    }
}
