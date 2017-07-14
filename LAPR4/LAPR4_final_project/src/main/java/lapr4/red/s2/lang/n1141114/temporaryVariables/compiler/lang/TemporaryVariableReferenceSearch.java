/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1141114.temporaryVariables.compiler.lang;

import bsh.Variable;
import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.util.ExpressionVisitor;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariable;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class TemporaryVariableReferenceSearch implements Expression{
    
    private String tempVariable;
    private Spreadsheet sheet;
    private Cell cell;
    
    public TemporaryVariableReferenceSearch(String tempVariable, Spreadsheet sheet, Cell cell){
        this.tempVariable = tempVariable;
        this.sheet = sheet;
        this.cell = cell;
        TemporaryVariable tempVariableObject = 
                this.sheet.getWorkbook().findTemporaryVariable().returnTemporaryValueByElements(cell, sheet, tempVariable);
        
        if(tempVariableObject == null)
        {
            this.sheet.getWorkbook().findTemporaryVariable().addTemporaryVariable(cell, sheet, tempVariable, new Value());
        }
    }

    @Override
    public Value evaluate() throws IllegalValueTypeException {
        
        Value value = new Value();
        
        TemporaryVariable temporaryVariable = this.sheet.getWorkbook().findTemporaryVariable().returnTemporaryValueByElements(cell, sheet, tempVariable);
        if(temporaryVariable != null)
        {
            value = temporaryVariable.currentVariableValue();
        }
        
        return value;
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return visitor.vistiVariableReference(this);
    }

    public String tempVariable() {
        return tempVariable;
    }

    public Spreadsheet currentSheet() {
        return sheet;
    }

    public Cell currentCell() {
        return cell;
    }    
}
