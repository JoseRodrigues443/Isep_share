package lapr4.red.s2.lang.n1150834.conditionalFormatting;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.FormulaCompiler;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;
import java.util.Set;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariable;

/**
 * An operation to apply cell formatting to a range of cells
 *
 * @author 1150834
 */
public class ConditionalFormattingRange {

    /**
     * The user interface controller
     */
    private UIController uiController;
    /**
     * Cell on one end of the range
     */
    private Cell beginning;
    /**
     * Cell on the other end of the range
     */
    private Cell end;
    /**
     * The formatting condition
     */
    private FormattingCondition condition;

    /**
     * Creates a new conditional formatting for a range of cells
     *
     * @param uiController the user interface controller
     * @param beginning the cell where the range begins
     * @param end the cell where the range ends
     * @param condition the formatting condition
     */
    public ConditionalFormattingRange(UIController uiController, Cell beginning, Cell end, FormattingCondition condition) {
        this.uiController = uiController;
        this.beginning = beginning;
        this.end = end;
        this.condition = condition;
    }

    /**
     * Formats a range of cells to match a given condition
     *
     * @param form
     * @throws csheets.core.IllegalValueTypeException
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    public void formatRange(String form) throws IllegalValueTypeException, FormulaCompilationException {
        Spreadsheet sheet = uiController.getActiveSpreadsheet();
        int beginRow = beginning.getAddress().getRow();
        int beginColumn = beginning.getAddress().getColumn();
        int row = end.getAddress().getRow() - beginRow + 1;
        int column = end.getAddress().getColumn() - beginColumn + 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                StylableCell cell = (StylableCell) sheet.getCell(beginColumn + j, beginRow + i).getExtension(StyleExtension.NAME);
                if (cell.getFormula() != null) {
                    updateVariable(cell);
                    String value = cell.getValue().toString().replace(".", ",");
                    String temp = "={_cell:=" + value + ";_cell" + form + "}";
                    Boolean format = FormulaCompiler.getInstance().compile(cell, temp).evaluate().toBoolean();
                    if (format) {
                        cell.setBackgroundColor(condition.trueFormatColor());
                    } else {
                        cell.setBackgroundColor(condition.falseFormatColor());
                    }
                }
            }
        }

    }

    /**
     * Updates the current cell variable so it will represent a new cell
     *
     * @param cell the cell to be represented
     */
    private void updateVariable(Cell cell) {
        Set<TemporaryVariable> currentVariables = this.uiController.getActiveWorkbook().findTemporaryVariable().currentVariables();

        for (TemporaryVariable var : currentVariables) {
            if (var.currentVariableName().equals("_cell")) {
                this.uiController.getActiveWorkbook().findTemporaryVariable().currentVariables().remove(var);
                var.defineNewCell(cell);
                var.assignValueToVariable(cell.getValue());
                this.uiController.getActiveWorkbook().findTemporaryVariable().currentVariables().add(var);
                break;
            }
        }
    }
}
