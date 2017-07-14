/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.gray.s1.lang.n3456789.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.CellReference;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.red.s2.lang.n1141114.globalVariables.lang.GlobalVariableReferenceSearch;
import lapr4.red.s2.lang.n1141114.temporaryVariables.compiler.lang.TemporaryVariableReferenceSearch;

/**
 *
 * @author alexandrebraganca
 */
public class AssignmentOperator implements BinaryOperator {

    @Override
    public Value applyTo(Expression leftOperand, Expression rightOperand) throws IllegalValueTypeException {
        Value value = rightOperand.evaluate();

        if (leftOperand instanceof CellReference) {
            // do the assignment
            CellReference left = (CellReference) leftOperand;
            String content = "";
            try {
                // Need to handle all possible types because the set of a cell only accepts "text" or "formula"!!!
                switch (value.getType()) {
                    case NUMERIC:
                        content = value.toString(new DecimalFormat());
                        break;
                    case TEXT:
                        content = value.toText();
                        break;
                    case BOOLEAN:
                        content = value.toBoolean().toString();
                        break;
                    case DATE:
                        content = value.toDate().toString();
                        break;
                    case UNDEFINED:
                        JOptionPane.showMessageDialog(null, "The temporary variable that you used doesnt exist!", "Error message", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                left.getCell().setContent(content);
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(AssignmentOperator.class.getName()).log(Level.SEVERE, null, ex);
            }
            return value;
        } else if (leftOperand instanceof TemporaryVariableReferenceSearch) {
            TemporaryVariableReferenceSearch temporaryVariableReference = (TemporaryVariableReferenceSearch) leftOperand;

            value = rightOperand.evaluate();

            temporaryVariableReference.currentSheet().getWorkbook().findTemporaryVariable().updateVariableValue(temporaryVariableReference.currentCell(), temporaryVariableReference.currentSheet(), temporaryVariableReference.tempVariable(), value);

            return new Value();
        } else if(leftOperand instanceof GlobalVariableReferenceSearch){
            GlobalVariableReferenceSearch globalVariableReference = (GlobalVariableReferenceSearch) leftOperand;
            
            value = rightOperand.evaluate();
            
            globalVariableReference.currentSpreadSheet().getWorkbook().findGlobalVariables().updateVariableValue(globalVariableReference.currentCell(), globalVariableReference.currentSpreadSheet(), globalVariableReference.currentGlobalVariableName(), value);
        
            return new Value();
        }else {
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

    public String toString() {
        return getIdentifier();
    }

}
