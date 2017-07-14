/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1151117.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.CellReference;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.blue.s3.lang.n1130679.arrayVariableEditor.VariableReference;
import lapr4.red.s2.lang.n1141114.globalVariables.lang.GlobalVariableReferenceSearch;
import lapr4.red.s2.lang.n1141114.temporaryVariables.compiler.lang.TemporaryVariableReferenceSearch;

/**
 *
 * @author Barros Edited and Used By: Joao Fernandes 1141114@isep.ipp.pt and Ana Pacheco 1130679@isep.ipp.pt
 */
public class Assign implements BinaryOperator {

    @Override
    public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
        Value value = rightOperand.evaluate();
        if (leftOperand instanceof CellReference) {
            // do the assignment
            CellReference left = (CellReference) leftOperand;
            String content;
            try {
//                 Need to handle all possible types because the set of a cell only accepts "text" or "formula"!!!
                switch (value.getType()) {

                    case NUMERIC:
                        content = value.toString(new DecimalFormat());
                        break;
                    case DATE:
                        content = value.toString(new SimpleDateFormat());
                        break;
                    case UNDEFINED:
                        content = "";
                        JOptionPane.showMessageDialog(null, "The variable that you tried to use doesnt exist!", "Error message", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        content = value.toString();
                }
                left.getCell().setContent(content);
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(Assign.class.getName()).log(Level.SEVERE, null, ex);
            }
            return value;
        } else if (leftOperand instanceof TemporaryVariableReferenceSearch) {
            TemporaryVariableReferenceSearch tempVariableRef = (TemporaryVariableReferenceSearch) leftOperand;

            value = rightOperand.evaluate();

            tempVariableRef.currentSheet().getWorkbook().findTemporaryVariable().updateVariableValue(tempVariableRef.currentCell(), tempVariableRef.currentSheet(), tempVariableRef.tempVariable(), value);

            return new Value();
        } else if (leftOperand instanceof GlobalVariableReferenceSearch) {
            GlobalVariableReferenceSearch globalVariableReference = (GlobalVariableReferenceSearch) leftOperand;

            value = rightOperand.evaluate();

            globalVariableReference.currentSpreadSheet().getWorkbook().findGlobalVariables().updateVariableValue(globalVariableReference.currentCell(), globalVariableReference.currentSpreadSheet(), globalVariableReference.currentGlobalVariableName(), value);

            return new Value();
        } else if (leftOperand instanceof VariableReference) {
            VariableReference varRef = (VariableReference) leftOperand;

            value = rightOperand.evaluate();
            varRef.getSheet().getWorkbook().createVariable(varRef.getVar(),
                    varRef.getPosition(),
                    value, varRef.getSheet());
            return value;
        } else {
            // error!!!!
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    @Override
    public String getIdentifier() {
        return ":=";
    }

    @Override
    public Value.Type getOperandValueType() {
        return Value.Type.UNDEFINED;
    }

}
