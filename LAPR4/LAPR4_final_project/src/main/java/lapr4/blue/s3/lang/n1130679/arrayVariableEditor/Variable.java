/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1130679.arrayVariableEditor;

import csheets.core.Spreadsheet;
import csheets.core.Value;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ana Pacheco - 1130679@isep.ipp.pt
 */
public class Variable implements Serializable {

    private String variableName;
    private ArrayList<Value> variableValues = new ArrayList<Value>();
    private Spreadsheet sheet;
    private int currentPosition = 1;

    /**
     * Empty constructor
     */
    public Variable() {
    }

    /**
     */
    public Variable(String variableName, int variablePos, Value sheet,
            Spreadsheet spreadsheet) {
        this.variableName = variableName;
        this.currentPosition = variablePos;
        initialize(variablePos);
        this.variableValues.add(variablePos - 1, sheet);
        this.sheet = spreadsheet;
    }

    /**
     * Method that returns the variable name
     *
     * @return variable name
     */
    public String getVariableName() {
        return variableName;
    }

    private void initialize(int varPosition) {
        int size = variableValues.size();
        for (int i = size; i < varPosition; i++) {
            this.variableValues.add(i, new Value("NULL"));
        }
    }

    /**
     * Method that modifies the variable name
     *
     * @param variableName the new variable name
     */
    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    /**
     * Method that returns the variable value
     *
     * @return the variable value
     */
    public ArrayList<Value> getVariableValues() {
        return variableValues;
    }

    public Value getValue(int position) {
        initialize(position);
        return variableValues.get(position - 1);
    }

    /**
     * Method that modifies the variable value
     *
     * @param varValue the new variable value
     * @param position the position of the variable
     */
    public void setValues(Value varValue, int position) {
        initialize(position);
        this.variableValues.add(position - 1, varValue);
    }

    /**
     * Method that returns the variable sheet
     *
     * @return variable sheet
     */
    public Spreadsheet getSheet() {
        return sheet;
    }

    /**
     * Method that prints the name and value of the variable
     *
     * @return name and value of the variable
     */
    @Override
    public String toString() {
        return "Variable Name: " + variableName + ", Variable Value: " + variableValues.
                get(0);
    }

}
