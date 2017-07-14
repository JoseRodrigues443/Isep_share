package lapr4.red.s2.lang.n1150834.conditionalFormatting.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 * A menu that displays range format option
 *
 * @author 1150834
 */
public class ConditionalFormattingRangeAction extends BaseAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new ConditionalFormattingRangeAction
     *
     * @param uiController the user interface controller
     */
    public ConditionalFormattingRangeAction(UIController uiController) {
        this.uiController = uiController;

    }

    /**
     * Returns the action's name
     *
     * @return the action's name
     */
    @Override
    protected String getName() {
        return "Range Formatting";
    }

    /**
     * Creates a new ConditionalFormattingRangeUI
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        new ConditionalFormattingRangeUI(uiController, null, null);
    }

}
