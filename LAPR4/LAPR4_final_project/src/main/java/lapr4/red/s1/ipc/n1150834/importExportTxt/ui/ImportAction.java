package lapr4.red.s1.ipc.n1150834.importExportTxt.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 * A import text operation.
 *
 * @author 1150834
 */
public class ImportAction extends BaseAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new import action
     *
     * @param uiController the user interface controller
     */
    public ImportAction(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     * Returns the action's name
     *
     * @return the action's name
     */
    @Override
    protected String getName() {
        return "Import text";
    }

    @Override
    protected void defineProperties() {
    }

    /**
     * Creates a new ImportUI
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ImportUI ui = new ImportUI(uiController);
    }

}
