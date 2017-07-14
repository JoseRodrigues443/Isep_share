package lapr4.red.s1.ipc.n1150710.network.shareCell.ui;

import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

/**
 * An action of the simple extension that exemplifies how to interact with the
 * spreadsheet.
 *
 * @author 1150710@isep.ipp.pt
 */
public class ShareCellAction extends BaseAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new action.
     *
     * @param uiController the user interface controller
     */
    public ShareCellAction(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Share Cell";
    }

    @Override
    protected void defineProperties() {
    }

    /**
     * A simple action that presents a confirmation dialog. If the user confirms
     * then the contents of the cell A1 of the current sheet are set to the
     * string "Changed".
     *
     * @param event the event that was fired
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        // Lets user select a font
        int result = JOptionPane.showConfirmDialog(null, "How to use this extension? "
                + "\n(yes to see help window)");

        if (result == JOptionPane.YES_OPTION) {
            // Vamos exemplificar como se acede ao modelo de dominio (o workbook)

            Object[] options = {"OK"};
            int n = JOptionPane.showOptionDialog(null,
                    "In the the right panel you will find a tab named 'Share Cell'"
                            + "\nPlease select some cells, then the computer ip to send."
                            + "\nThen select the 'Share selected cells' button.", "Share Cell - Help",
                    JOptionPane.PLAIN_MESSAGE,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);
            //this.uiController.getActiveSpreadsheet().getCell(0, 2).setContent("Eu gosto muitissimo de lapr4 e não sou nada ironico");

        }
    }
}
