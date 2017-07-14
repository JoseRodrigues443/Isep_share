/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1130679.arrayVariableEditor;

import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.util.ExpressionVisitor;

/**
 *
 * @author Ana Pacheco - 1130679@isep.ipp.pt
 */
public class VariableReference implements Expression {

    private String var;
    private int position = 1;
    private Spreadsheet sheet;

    /**
     * Empty constructor
     */
    public VariableReference() {

    }

    /**
     * Complete constructor that create one var if it not exist in the list of
     * variables.
     *
     * @param var name of the referenced var
     * @param spreadsheet spreadsheet of the referenced var
     */
    public VariableReference(String var, Spreadsheet spreadsheet) {
        separateVar(var);
        this.sheet = spreadsheet;
        Variable variable = this.sheet.getWorkbook().findVar(spreadsheet, this.var);

        if (variable == null) {
            this.sheet.getWorkbook().
                    createVariable(var, this.position, new Value(), this.sheet);
        }
    }

    private void separateVar(String text) {
        int firstP = text.indexOf("[");
        if (firstP == -1) {

            this.var = text;

        } else {
            this.var = text.substring(0, firstP);

            int lastP = text.indexOf("]");
            if (lastP != -1) {
                String auxPos;
                auxPos = text.substring(firstP + 1, lastP);
                this.position = Integer.parseInt(auxPos);
            }
        }
        /**
         * test
         */
        System.out.println("Variable : " + this.var);
        System.out.println("Position : " + this.position);

    }

    
    public String getVar() {
        return var;
    }

    public int getPosition() {
        return this.position;
    }

   
    public Spreadsheet getSheet() {
        return sheet;
    }

    
    public Value evaluate() {
        Value value = new Value();

        Variable var = this.sheet.getWorkbook().findVar(sheet, this.var);
        if (var != null) {
            value = var.getValue(this.position);
        }

        return value;
    }

    public Object accept(ExpressionVisitor visitor) {
        return visitor.visitVarReference(this);
    }

}
