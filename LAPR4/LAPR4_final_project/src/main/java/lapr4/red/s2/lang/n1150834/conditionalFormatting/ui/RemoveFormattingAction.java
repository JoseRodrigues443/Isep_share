package lapr4.red.s2.lang.n1150834.conditionalFormatting.ui;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.awt.event.ActionEvent;

/**
 * Remove formatting operation
 *
 * @author Utilizador
 */
public class RemoveFormattingAction extends BaseAction {

    /**
     * The user interface controller
     */
    private UIController uiController;
    /**
     * Cell on one end of the range
     */
    private Cell first;
    /**
     * Cell on the other end of the range
     */
    private Cell last;

    /**
     * Creates a new remove formatting action.
     *
     * @param uiController the user interface controller
     * @param first the first cell in the range
     * @param last the last cell in the range
     */
    public RemoveFormattingAction(UIController uiController, Cell first, Cell last) {
        this.uiController = uiController;
        this.first = first;
        this.last = last;
    }

    @Override
    protected String getName() {
        return null;
    }

    /**
     * Removes the formatting from the selected cells.
     *
     * @param e the event that was fired
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Spreadsheet sheet = uiController.getActiveSpreadsheet();
        int beginRow = first.getAddress().getRow();
        int beginColumn = first.getAddress().getColumn();
        int row = last.getAddress().getRow() - beginRow + 1;
        int column = last.getAddress().getColumn() - beginColumn + 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                StylableCell cell = (StylableCell) sheet.getCell(beginColumn + j, beginRow + i).getExtension(StyleExtension.NAME);
                if (cell.getFormula() != null) {
                    StylableCell stylableCell = (StylableCell) cell.getExtension(
                            StyleExtension.NAME);
                    stylableCell.setBackgroundColor(Color.white);
                }
            }
        }
    }

}
