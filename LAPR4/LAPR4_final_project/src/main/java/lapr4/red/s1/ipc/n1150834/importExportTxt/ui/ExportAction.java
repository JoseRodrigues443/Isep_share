package lapr4.red.s1.ipc.n1150834.importExportTxt.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 * A export text operation.
 *
 * @author 1150834
 */
public class ExportAction extends BaseAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new export action
     *
     * @param uiController the user interface controller
     */
    public ExportAction(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     * Returns the action's name
     *
     * @return the action's name
     */
    @Override
    protected String getName() {
        return "Export text";
    }

    @Override
    protected void defineProperties() {
    }

    /**
     * Creates a new ExportUI
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ExportUI ui = new ExportUI(uiController);
    }

}
