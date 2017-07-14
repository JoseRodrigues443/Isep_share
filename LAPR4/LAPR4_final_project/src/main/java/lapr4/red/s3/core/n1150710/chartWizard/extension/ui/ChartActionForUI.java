package lapr4.red.s3.core.n1150710.chartWizard.extension.ui;

import csheets.core.Cell;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.event.ActionEvent;

/**
 * An action of the simple extension that exemplifies how to interact with the
 * spreadsheet.
 *
 * @author 1150710@isep.ipp.pt
 */
public class ChartActionForUI extends FocusOwnerAction {

    private Cell[][] cellRange;

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new action.
     *
     * @param uiController the user interface controller
     */
    public ChartActionForUI(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Chart editor";
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.cellRange = this.focusOwner.getSelectedCells();
        
        SpreadsheetTable s = new SpreadsheetTable(uiController.getActiveSpreadsheet(), uiController);
        this.cellRange  = s.getSelectedCells();
    }

    public Cell[][] getCellRange() {
        return cellRange;
    }

//
//    @Override
//    protected String getName() {
//        return "Chart Wizard";
//    }
//
//    @Override
//    protected void defineProperties() {
//    }
//    /**
//     * A simple action that presents a confirmation dialog. If the user confirms
//     * then the contents of the cell A1 of the current sheet are set to the
//     * string "Changed".
//     *
//     * @param event the event that was fired
//     */
//    @Override
//    public void actionPerformed(ActionEvent event) {
//        // Lets user select a font
//        int result = JOptionPane.showConfirmDialog(null, "How to use this extension? "
//                + "\n(yes to see help window)");
//
//        if (result == JOptionPane.YES_OPTION) {
//            // Vamos exemplificar como se acede ao modelo de dominio (o workbook)
//
//            Object[] options = {"OK"};
//            int n = JOptionPane.showOptionDialog(null,
//                    "In the the right panel you will find a tab named 'Chart Menu'",
//                    "Share Cell - Help",
//                    JOptionPane.PLAIN_MESSAGE,
//                    JOptionPane.QUESTION_MESSAGE,
//                    null,
//                    options,
//                    options[0]);
//            //this.uiController.getActiveSpreadsheet().getCell(0, 2).setContent("Eu gosto muitissimo de lapr4 e não sou nada ironico");
//
//        }
//    }
}
