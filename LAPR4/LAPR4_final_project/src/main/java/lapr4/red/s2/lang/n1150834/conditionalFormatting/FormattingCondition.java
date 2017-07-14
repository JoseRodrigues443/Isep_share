package lapr4.red.s2.lang.n1150834.conditionalFormatting;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Literal;
import csheets.core.formula.lang.RelationalOperator;
import java.awt.Color;

/**
 * A formatting condition to be used on a cell
 *
 * @author 1150834
 */
public class FormattingCondition {

    /**
     * The condition's operator
     */
    private RelationalOperator operator;
    /**
     * The format if condition is true
     */
    private Color trueFormat;
    /**
     * The format if condition is false
     */
    private Color falseFormat;
    /**
     * The right operand of the condition
     */
    private Expression rightOperand;

    /**
     * Creates a new formatting condition
     *
     * @param operator the condition's operator
     * @param operand the right operand of the condition
     */
    public FormattingCondition(RelationalOperator operator, Number operand) {
        this(operator, Color.green, Color.red, operand);
    }

    /**
     * Creates a new formatting condition
     *
     * @param operator the condition's operator
     * @param trueFormat the color if the condition is true
     * @param falseFormat the color if the condition is false
     * @param operand the right operand of the condition
     */
    public FormattingCondition(RelationalOperator operator, Color trueFormat, Color falseFormat, Number operand) {
        if (operator == null) {
            throw new IllegalArgumentException();
        }
        this.operator = operator;
        this.trueFormat = trueFormat;
        this.falseFormat = falseFormat;
        this.rightOperand = new Literal(new Value(operand));
    }

    /**
     * Return the operator's identifier
     *
     * @return the operator's identifier
     */
    public String operatorIdentifier() {
        return operator.getIdentifier();
    }

    /**
     * Returns the color related to the condition being true
     *
     * @return the color related to the condition being true
     */
    public Color trueFormatColor() {
        return trueFormat;
    }

    /**
     * Returns the color related to the condition being false
     *
     * @return the color related to the condition being false
     */
    public Color falseFormatColor() {
        return falseFormat;
    }

    /**
     * Alter's the color related to the condition being true
     *
     * @param trueFormat the new color
     */
    public void alterTrueFormatColor(Color trueFormat) {
        this.trueFormat = trueFormat;
    }

    /**
     * Alter's the color related to the condition being false
     *
     * @param falseFormat the new color
     */
    public void alterFalseFormatColor(Color falseFormat) {
        this.falseFormat = falseFormat;
    }

    /**
     * Alter's the value related to the right operand of the condition
     *
     * @param rightOperand the new value of the operand
     */
    public void alterRightOperand(String rightOperand) {
        this.rightOperand = new Literal(new Value(rightOperand));
    }

    /**
     * Returns the value of the operation between leftOperand and rightOperand
     *
     * @param leftOperand the left operand
     * @return the value of the operation
     * @throws IllegalValueTypeException
     */
    public Color checkCondition(Expression leftOperand) throws IllegalValueTypeException {
        Value applyTo = operator.applyTo(leftOperand, rightOperand);
        if (applyTo.toBoolean()) {
            return trueFormat;
        }
        return falseFormat;
    }

}
