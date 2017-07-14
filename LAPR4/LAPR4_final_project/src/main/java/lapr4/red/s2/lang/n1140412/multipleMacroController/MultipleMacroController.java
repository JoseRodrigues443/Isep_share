/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1140412.multipleMacroController;

import csheets.core.Cell;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.Macro;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import lapr4.red.s2.lang.n1140412.multipleMacro.Macro_Handler;

/**
 *
 * @author Tiago
 */
public class MultipleMacroController {
    /**
     * Current workbook
     */
    private final Workbook workbook;
    /**
     * MacroHandler class
     */
    private Macro_Handler macroHandler;
    /**
     * Cell
     */
    private Cell cell;
    /**
     * Controller constructor
     * @param uiController
     * @param cell 
     */
    public MultipleMacroController(UIController uiController,Cell cell) {
        this.workbook = uiController.getActiveWorkbook();
        this.cell=cell;
    }
    /**
     * Saves Macro in the workbook macroMap
     * @param name
     * @param macro 
     */
    public void saveMacro(String name, Macro macro) {
        this.workbook.addMacro(name, macro);
    }
    /**
     * Removes Macro from the workbook macroMap
     * @param name 
     */
    public void removeMacro(String name) {
        this.workbook.removeMacro(name);
    }
    /**
     * Returns the macroMap from the workbook
     * @return 
     */
    public Map<String, Macro> macroMap() {
        return this.workbook.macroMap();
    }
    /**
     * 
     * @param lines
     * @param cell
     * @return 
     */
    public Macro createMacro(List<String> lines, Cell cell) {
        return new Macro(cell, lines);
    }
    /**
     * Returns the macroScript
     * @param name
     * @return 
     */
    public List<String> getMacroScript(String name) {
        return macroMap().get(name).getScript();
    }
    /**
     * Returns a list of all saved macros
     * @return ArrayList
     */
    public ArrayList<String> savedMacros() {
        ArrayList<String> ret = new ArrayList<>();
        Map<String, Macro> map = macroMap();
        for (String s : map.keySet()) {
            ret.add(s);
        }
        return ret;
    }
    /**
     * Returns a DefaultListModel to be shown on the UI
     * @return DefaultListModel
     */
    public DefaultListModel listForUI() {
        return returnModelForJListStringFormat(savedMacros());
    }
    /**
     * Moves the contents of an ArrayList to a DefaultListModel
     * @param string
     * @return DefaultListModel
     */
    private static DefaultListModel returnModelForJListStringFormat(ArrayList<String> string) {
        DefaultListModel model = new DefaultListModel<>();
        for (String s : string) {
            model.addElement(s);
        }

        return model;
    }
    /**
     * Executes the receiveed script
     * @param lines
     * @return
     * @throws FormulaCompilationException 
     */
    public String execute(List<String> lines) throws FormulaCompilationException{
        Macro macro = new Macro(cell, lines);
        macroHandler= new Macro_Handler(macro, macroMap());
        List<String> script= macroHandler.invocations();
        macro.setScrip(script);
        String value = macro.execute();
        return value;
    }
}
