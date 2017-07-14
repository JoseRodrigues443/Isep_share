/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150710.BeanShell;

/**
 * beanshell essential interpreter
 */
import bsh.EvalError;
import bsh.Interpreter;
import bsh.UtilEvalError;
import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.Macro;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.red.s2.lang.n1141114.globalVariables.domain.GlobalVariable;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariable;

/**
 *
 * @author 1150710@isep.ipp.pt
 * @edited by 1150630
 *
 */
public class BeanShellInterpretationExtension {

    /**
     * interpreter of beans
     */
    private final Interpreter beanShellInterpreter;


    private static final String EXAMPLE_SCRIPT_DEFAULT = "import csheets.core.Address;\n"
            + "import csheets.core.Value;\n"
            + "import csheets.core.Workbook;\n"
            + "import csheets.core.formula.lang.Macro;\n"
            + "\n"
            + "Workbook workbookParameter = new Workbook(1);\n"
            + "Macro macroParameter = new Macro(workbookParameter.getSpreadsheet(0).getCell(new Address(0, 0)),\"5+5\");\n"
            + "String result = macroParameter.execute();\n"
            + "Value v = new Value(result);\n"
            + "return v;\n";

    public BeanShellInterpretationExtension() throws UtilEvalError {
        this.beanShellInterpreter = new Interpreter();

        this.beanShellInterpreter.getNameSpace().doSuperImport();
        //testScript();
    }

    /**
     * test the example script as asked in the lapr4 manual
     *
     * (1) opens a new workbook, (2) creates a macro, (3) run the created macro
     * and (4) displays a window with the result of the invocation of the macro.
     *
     * @return
     */
    public boolean testScript() {
        try {

            Workbook w = new Workbook(1);
            Macro m = new Macro(w.getSpreadsheet(0).getCell(new Address(0, 0)), "5+5");
            String result = m.execute();
            System.out.println(this.getClass() + "==»» m.execute() == " + result);
            return true;
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(BeanShellInterpretationExtension.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Execute the BeanShell Script and returns the result of the script
     *
     * @param insertedCode BeanShell script code
     * @param workbook
     * @param spreadsheet
     * @param cell
     * @param macro
     * @return Returns Value of the script or null if non effective
     */
    public Value execute(String insertedCode, Workbook workbook, Spreadsheet spreadsheet, Cell cell, Macro macro, TemporaryVariable temporaryVariable, GlobalVariable globalVariable) {
        try {
            Value value;
            
            this.beanShellInterpreter.set("result", new String());
            this.beanShellInterpreter.set("workbook", workbook);
            this.beanShellInterpreter.set("spreadsheet", spreadsheet);
            this.beanShellInterpreter.set("cell", cell);
            this.beanShellInterpreter.set("macro", macro);
            this.beanShellInterpreter.set("temporaryVariable", temporaryVariable);
            this.beanShellInterpreter.set("globalVariable", globalVariable);
            //this.beanShellInterpreter.set(insertedCode, value);
            value = (Value) this.beanShellInterpreter.eval(insertedCode);
            if (value == null) {
                value = new Value();
            }

            return value;
        } catch (EvalError ex) {
            Logger.getLogger(BeanShellInterpretationExtension.class.getName()).log(Level.SEVERE, null, ex);
            return new Value("Your code does not work in the BeanShell API");
        }
    }

    /**
     * generates the example requested for beanshell_
     *
     * that does: (1) opens a new workbook, (2) creates a macro, (3) run the
     * created macro and (4) displays a window with the result of the invocation
     * of the macro.
     *
     *
     * @return string script example
     */
    public static String exampleScript() {
        return EXAMPLE_SCRIPT_DEFAULT;
//        System.out.println("\n-->" + EXAMPLE_SCRIPT_DEFAULT);
//        return "Macro m = new Macro()";
    }

}
