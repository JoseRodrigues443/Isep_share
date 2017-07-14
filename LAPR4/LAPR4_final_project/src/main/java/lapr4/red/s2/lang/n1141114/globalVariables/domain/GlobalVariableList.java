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
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class GlobalVariableList implements Serializable{
    
    /**
     * Set with all the current globalVariables in the workbook
     */
    private Set<GlobalVariable> globalVariableList;

    /**
     * Default constructor
     */
    public GlobalVariableList() {
        this.globalVariableList = new HashSet<>();
    }
    
    /**
     * Returns the current set with the global variables
     * @return Set<GlobalVariable>
     */
    public Set<GlobalVariable> currentVariables()
    {
        return globalVariableList;
    }
    
    /**
     * Adds a new global variable to the workbook context
     * @param cell - Current cell
     * @param sheet - Current sheet
     * @param variable - Global variable name
     * @param stringValue - Global variable value
     * @return true or false
     */
    public boolean addGlobalVariable(Cell cell, Spreadsheet sheet, String variable, Value stringValue){
        return this.globalVariableList.add(new GlobalVariable(sheet, cell, variable, stringValue));
    }
    
    /**
     * Returns a global variable 
     * @param cell - Selected cell
     * @param sheet - Active sheet
     * @param variable - Global variable name
     * @return GlobalVariable if found else null
     */
    public GlobalVariable returnGlobalVariableByElements(Cell cell, Spreadsheet sheet, String variable){
        for (GlobalVariable globalVar : globalVariableList) {
            if(globalVar.currentGlobalVariableName().equalsIgnoreCase(variable)){
                return globalVar;
            }
        }
        return null;
    }
    
    /**
     * Updates a Global variable value
     * @param cell - Selected cell
     * @param sheet - Active sheet 
     * @param variable - Global variable name
     * @param value - New value
     * @return true or false
     */
    public boolean updateVariableValue(Cell cell, Spreadsheet sheet, String variable, Value value){
        for (GlobalVariable globalVar : globalVariableList) {
            if(globalVar.currentGlobalVariableName().equalsIgnoreCase(variable)){
                globalVar.assignGlobalVariableValue(value, cell, sheet);
                return true;
            }
        }
        return false;
    }
}
