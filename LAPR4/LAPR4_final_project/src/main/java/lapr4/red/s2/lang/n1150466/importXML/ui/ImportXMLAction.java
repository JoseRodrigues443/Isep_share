package lapr4.red.s2.lang.n1150466.importXML.ui;

import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import javax.swing.KeyStroke;

/**
 *
 * @author Sebastiao
 */
public class ImportXMLAction extends FocusOwnerAction {

    /**
     * The user interface controller.
     */
    private UIController uiController;

    /**
     * Creates a new ImportXML Action
     *
     * @param uiController the user interface controller
     */
    public ImportXMLAction(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Import XML";
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        new ImportXMLUI(this.uiController,this.focusOwner);
    }

}
