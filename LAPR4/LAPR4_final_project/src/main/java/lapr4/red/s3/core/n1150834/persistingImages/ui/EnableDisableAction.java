package lapr4.red.s3.core.n1150834.persistingImages.ui;

import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 * Enables/Disables automatic image window
 *
 * @author 1150834
 */
public class EnableDisableAction extends FocusOwnerAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new enable/disable action
     *
     * @param uiController the user interface controller
     */
    public EnableDisableAction(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     * Returns the action's name
     *
     * @return the action's name
     */
    @Override
    protected String getName() {
        return "Enable/Disable";
    }

    /**
     * Creates a new EnableDisableUI
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        new EnableDisableUI(uiController,focusOwner);
    }

}
