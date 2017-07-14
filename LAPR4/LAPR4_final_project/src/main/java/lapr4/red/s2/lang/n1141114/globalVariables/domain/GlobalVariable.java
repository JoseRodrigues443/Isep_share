/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1141114.globalVariables.domain;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import java.io.Serializable;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class GlobalVariable implements Serializable{

    /**
     * Sheet where the global variable is defined
     */
    private Spreadsheet sheet;

    /**
     * Cell where the global variable is defined
     */
    private Cell currentCell;

    /**
     * Global variable name
     */
    private String globalVariableName;

    /**
     * Global variable value
     */
    private Value globalVariableValue;

    /**
     * Default constructor for Global Variable
     *
     * @param sheet - Sheet where variable is defined
     * @param currentCell - Cell where variable is defined
     * @param glovalVariableName - Global variable name
     * @param globalVariableValue - Global variable value
     */
    public GlobalVariable(Spreadsheet sheet, Cell currentCell, String glovalVariableName, Value globalVariableValue) {
        this.sheet = sheet;
        this.currentCell = currentCell;
        this.globalVariableName = glovalVariableName;
        this.globalVariableValue = globalVariableValue;
    }

    /**
     * Returns the current global variable name
     *
     * @return Global variable name (String)
     */
    public String currentGlobalVariableName() {
        return globalVariableName;
    }

    /**
     * Returns the current global variable value
     * @return Global variable value (Value)
     */
    public Value currentGlobalVariableValue() {
        return globalVariableValue;
    }

    /**
     * Updates the global variable value
     *
     * @param globalVariableValue - new global variable value
     */
    public void assignGlobalVariableValue(Value globalVariableValue, Cell cell, Spreadsheet sheet) {
        this.globalVariableValue = globalVariableValue;
        this.currentCell = cell;
        this.sheet = sheet;
    }

    /**
     * Returns the cell where the global variable was defined
     * @return Cell
     */
    public Cell cellWhereDefined() {
        return currentCell;
    }
    
    /**
     * Returns the sheet where the global variable was defined
     * @return Spreadsheet
     */
    public Spreadsheet sheetWhereDefined(){
        return sheet;
    }
    

}
