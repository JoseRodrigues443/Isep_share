/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Formula;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.MacroFormulaCompiler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariableList;

/**
 *
 * @author Catarina Sousa 1150767
 * @edited by Bruno Martins 1150662
 */
public class Macro implements Serializable {

    private final MacroFormulaCompiler compiler;
    private List<String> lines;
    private Cell cell;
    private ArrayList<String> parameters;
    private TemporaryVariableList list;

    /**
     * @param cell any cell to identify the spreadsheet where Macro will be
     * executed
     * @param singleLines single lines with comments or formulas
     */
    public Macro(Cell cell, String singleLines) {
        this.lines = new ArrayList<>();
        lines.add(singleLines);
        this.cell = cell;
        compiler = MacroFormulaCompiler.getInstance(); // this Macro uses MacroFormula compiler

    }

    public Macro(Cell cell, List<String> lines, ArrayList<String> parameters) {
        this.lines = new ArrayList<>();
        this.lines = lines;
        this.cell = cell;
        compiler = MacroFormulaCompiler.getInstance();
        this.parameters = parameters;

    }

    /**
     * @param cell any cell to identify the spreadsheet where Macro will be
     * executed
     * @param lines lines with comments or formulas
     */
    public Macro(Cell cell, List<String> lines) {
        this.lines = lines;
        this.cell = cell;
        compiler = MacroFormulaCompiler.getInstance(); // this Macro uses MacroFormula compiler
    }

    /**
     * @param cell any cell to identify the spreadsheet where Macro will be
     * executed
     * @param lines lines with comments or formulas
     * @param list
     */
    public Macro(Cell cell, List<String> lines, TemporaryVariableList list) {
        this.lines = lines;
        this.cell = cell;
        compiler = MacroFormulaCompiler.getInstance();
        this.list = list;// this Macro uses MacroFormula compiler
    }

    public Macro() {
        this.lines = new ArrayList<>();
        compiler = MacroFormulaCompiler.getInstance(); // this Macro uses MacroFormula compiler
    }

    /**
     * Return the macro script by Tiago Vilaça 1140412@isep.ipp.pt
     *
     * @return
     */
    public List<String> getScript() {
        return this.lines;
    }

    public ArrayList<String> parameters() {
        return this.parameters;
    }

    public void setScrip(List<String> script) {
        this.lines = script;
    }

    public void setList(TemporaryVariableList list) {
        this.list = list;
    }

    public String execute() throws FormulaCompilationException {
        String toReturn = "";
        Formula formula;
        Value value = new Value("");
        for (String line : lines) {
            if (line != null) {
                if (!line.isEmpty()) {
                    formula = compiler.compile(this.cell, line,list);
                    try {
                        if (formula != null) {
                            value = formula.evaluate();
                            toReturn += value.toString() + "\n";
                        }
                    } catch (IllegalValueTypeException ex) {
                        // wraps exception message
                        throw new FormulaCompilationException(ex.toString());
                    }
                }
            }
        }
        return toReturn;
    }

}
