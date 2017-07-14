/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1141114.temporaryVariables.domain;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.util.ExpressionVisitor;
import java.io.Serializable;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class TemporaryVariable implements Serializable {

    /**
     * Sheet where the temporary variable was defined
     */
    private Spreadsheet sheet;
    
    /**
     * Cell where the temporary variable was defined
     */
    private Cell currentCell;
    
    /**
     * Temporary variable name
     */
    private String tempVariableName;
    
    /**
     * Temporary variable value
     */
    private Value tempVariableValue;

    /**
     * Default constructor
     * @param sheet - Current cell
     * @param currentCell - Current spreadsheet
     * @param tempVariableName - Variable name
     * @param tempVariableValue - Variable value
     */
    public TemporaryVariable(Spreadsheet sheet, Cell currentCell, String tempVariableName, Value tempVariableValue) {
        this.sheet = sheet;
        this.currentCell = currentCell;
        this.tempVariableName = tempVariableName;
        this.tempVariableValue = tempVariableValue;
    }

    /**
     * Returns the current variable name
     * @return variable name
     */
    public String currentVariableName() {
        return tempVariableName;
    }

    /**
     * Returns the current variable value
     * @return variable value
     */
    public Value currentVariableValue() {
        return tempVariableValue;
    }

    /**
     * Returns the spreadsheet where the variable was defined
     * @return spreadsheet
     */
    public Spreadsheet currentSheet() {
        return sheet;
    }

    /**
     * Returns the cell where the variable was defined
     * @return cell
     */
    public Cell currentCell() {
        return currentCell;
    }

    /**
     * Assigns a new value to the temporary variable
     * @param v - new value
     */
    public void assignValueToVariable(Value v) {
        tempVariableValue = v;
    }

    /**
     * Assigns a new cell to the temporary variable
     * @param cell - new cell
     */
    public void defineNewCell(Cell cell) {
        this.currentCell = cell;
    }

    /**
     * Assigns a new spreadsheet to the temporary variable
     * @param sheet - new spreadsheet
     */
    public void defineNewSheet(Spreadsheet sheet) {
        this.sheet = sheet;
    }
}
