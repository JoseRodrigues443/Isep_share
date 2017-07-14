package lapr4.red.s2.lang.n1150834.conditionalFormatting.ui;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.Language;
import csheets.core.formula.lang.RelationalOperator;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import lapr4.red.s2.lang.n1150834.conditionalFormatting.ConditionalFormattingRange;
import lapr4.red.s2.lang.n1150834.conditionalFormatting.FormattingCondition;

/**
 * A controller for formatting cell ranges
 *
 * @author 1150834
 */
public class ConditionalFormattingRangeController {

    /**
     * The user interface controller
     */
    private UIController uiController;
    /**
     * The used language
     */
    private Language lang;

    /**
     * Creates a new conditional formatting range controller
     *
     * @param uiController the user interface controller
     */
    public ConditionalFormattingRangeController(UIController uiController) {
        this.uiController = uiController;
        this.lang = Language.getInstance();
    }

    /**
     * Returns a list of cell formatting conditions
     *
     * @return a list of formatting conditions
     */
    public List<FormattingCondition> getFormattingConditions() {
        List<BinaryOperator> binaryOperators = lang.getBinaryOperators();
        List<FormattingCondition> conditions = new ArrayList<>();

        for (int i = 0; i < binaryOperators.size(); i++) {
            BinaryOperator op = binaryOperators.get(i);
            if (op instanceof RelationalOperator) {
                conditions.add(new FormattingCondition((RelationalOperator) op,0));
            }
        }

        return conditions;
    }

    /**
     * Formats a given range of cells
     *
     * @param begin the first cell of the range
     * @param end the last cell of the range
     * @param condition the condition to be applied to the cells
     * @param form
     * @throws IllegalValueTypeException
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    public void formatRange(Cell begin, Cell end, FormattingCondition condition,String form) throws IllegalValueTypeException, FormulaCompilationException {
        ConditionalFormattingRange formatter = new ConditionalFormattingRange(uiController, begin, end, condition);

        formatter.formatRange(form);
    }
}
