package lapr4.red.s3.core.n1150834.persistingImages.ui;

import lapr4.red.s3.core.n1150834.persistingImages.PersistentImageBrowserListener;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionListener;

/**
 * A import image operation.
 *
 * @author 1150834
 */
public class ImportImageAction extends FocusOwnerAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new import image action
     *
     * @param uiController the user interface controller
     */
    public ImportImageAction(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     * Returns the action's name
     *
     * @return the action's name
     */
    @Override
    protected String getName() {
        return "Import Image";
    }

    /**
     * Creates a new ImportImageUI and adds a new PersistentImageBrowserListener
     * to focusOwner
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        new ImportImageUI(uiController);
        focusOwner.addMouseMotionListener((MouseMotionListener) new PersistentImageBrowserListener());
    }

}
