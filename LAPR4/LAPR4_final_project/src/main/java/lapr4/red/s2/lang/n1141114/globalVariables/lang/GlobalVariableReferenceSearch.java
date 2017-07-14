/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1141114.globalVariables.lang;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.formula.util.ExpressionVisitor;
import lapr4.red.s2.lang.n1141114.globalVariables.domain.GlobalVariable;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariable;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class GlobalVariableReferenceSearch implements csheets.core.formula.Expression {

    /**
     * Global variable name
     */
    private String globalVariable;
    
    /**
     * Sheet where the global variable is defined
     */
    private Spreadsheet sheet;
    
    /**
     * Cell where the global variable is defined
     */
    private Cell cell;

    /**
     * Default construtor
     * @param globalVariable - Global variable name
     * @param sheet - Spreadsheet
     * @param cell - Cell
     */
    public GlobalVariableReferenceSearch(String globalVariable, Spreadsheet sheet, Cell cell) {
        this.globalVariable = globalVariable;
        this.sheet = sheet;
        this.cell = cell;
        GlobalVariable globalVariableTemp
                = this.sheet.getWorkbook().findGlobalVariables().returnGlobalVariableByElements(cell, sheet, globalVariable);

        if (globalVariableTemp == null) {
            this.sheet.getWorkbook().findGlobalVariables().addGlobalVariable(cell, sheet, globalVariable, new Value());
        }
    }

    @Override
    public Value evaluate() throws IllegalValueTypeException {

        Value value = new Value();

        GlobalVariable globalVariable = this.sheet.getWorkbook().findGlobalVariables().returnGlobalVariableByElements(cell, sheet, this.globalVariable);
        if (globalVariable != null) {
            value = globalVariable.currentGlobalVariableValue();
        }

        return value;
    }

    @Override
    public Object accept(ExpressionVisitor visitor) {
        return visitor.visitGlobalVariableReference(this);
    }

    public String currentGlobalVariableName() {
        return globalVariable;
    }

    public Spreadsheet currentSpreadSheet() {
        return sheet;
    }

    public Cell currentCell() {
        return cell;
    }
    
    
}
