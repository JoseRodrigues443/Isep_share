/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150767.macroWindow;

import csheets.core.Cell;
import csheets.core.formula.Function;
import csheets.core.formula.Operator;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.Macro;
import csheets.core.formula.lang.MacroLanguage;
import java.util.List;

/**
 *
 * @author Catarina Sousa 1150767
 */
public class MacroWindowController {
    /**
     * 
     */
    private Cell cell;
    
    /**
     * 
     * @param cell 
     */
    public MacroWindowController(Cell cell) {
        this.cell = cell;
    }
    /**
     * 
     * @return 
     */
    public List<Function> functions() {
        return MacroLanguage.getInstance().functions();
    }
    /**
     * 
     * @return 
     */
    public List<Operator> operators() {
        return MacroLanguage.getInstance().operators();
    }
    /**
     * 
     * @param list
     * @return
     * @throws FormulaCompilationException 
     */
    public String execute(List<String> list) throws FormulaCompilationException{       
        String value = new Macro(cell,  list).execute();
        return value;        
    }
    
}
