/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1141114.temporaryVariables.domain;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class TemporaryVariableList implements Serializable{

    /**
     * Set with all the temporary variables
     */
    private Set<TemporaryVariable> temporaryValueList;

    /**
     * Default constructor
     */
    public TemporaryVariableList() {
        this.temporaryValueList = new HashSet<>();
    }
    
    /**
     * Returns the current set with all the temporary variables
     * @return Set with temporary variables
     */
    public Set<TemporaryVariable> currentVariables()
    {
        return temporaryValueList;
    }
    
    /**
     * Adds a new temporary variable to the list
     * @param cell - Cell where the variable was defined
     * @param sheet - Spreadsheet where the variable was defined
     * @param variable - Temporary variable name
     * @param stringValue - Temporary variable value
     * @return true or false
     */
    public boolean addTemporaryVariable(Cell cell, Spreadsheet sheet, String variable, Value stringValue){
        return this.temporaryValueList.add(new TemporaryVariable(sheet, cell, variable, stringValue));
    }
    
    /**
     * Returns the temporary variable given elements for search
     * @param cell - Cell where the variable was defined
     * @param sheet - Spreadsheet where the variable was defined
     * @param variable - Variable name
     * @return Temporary variable object if found, null otherwise
     */
    public TemporaryVariable returnTemporaryValueByElements(Cell cell, Spreadsheet sheet, String variable){
        for (TemporaryVariable temporaryVariable : temporaryValueList) {
            if(temporaryVariable.currentSheet().equals(sheet) 
                    && temporaryVariable.currentVariableName().equalsIgnoreCase(variable)
                    && temporaryVariable.currentCell().equals(cell)){
                return temporaryVariable;
            }
        }
        return null;
    }
    
    public TemporaryVariable returnVariable(String name){
        for(TemporaryVariable temp : currentVariables()){
            if(temp.currentVariableName().equals(name)){
                return temp;
            }
        }
        return null;
    }
    
    /**
     * Assigns a value to an existing temporary variable
     * @param cell - Cell where the variable was defined
     * @param sheet - Spreadsheet where the variable was defined
     * @param variable - Variable name
     * @param value - Variable value
     * @return true or false
     */
    public boolean updateVariableValue(Cell cell, Spreadsheet sheet, String variable, Value value){
        for (TemporaryVariable temporaryVariable : temporaryValueList) {
            if(temporaryVariable.currentSheet().equals(sheet) 
                    && temporaryVariable.currentVariableName().equalsIgnoreCase(variable)
                    && temporaryVariable.currentCell().equals(cell)){
                temporaryVariable.assignValueToVariable(value);
                return true;
            }
        }
        return false;
    }
}
