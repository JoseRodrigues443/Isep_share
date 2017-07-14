/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1141431.MultipleSharing.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro Oliveira 1141431
 */
public class ShareCellAutoAction extends BaseAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new action.
     *
     * @param uiController the user interface controller
     */
    public ShareCellAutoAction(UIController uiController) {
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
