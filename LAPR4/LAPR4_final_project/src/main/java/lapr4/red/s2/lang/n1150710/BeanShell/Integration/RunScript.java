/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150710.BeanShell.Integration;

import bsh.UtilEvalError;
import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.lang.Macro;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.red.s2.lang.n1141114.globalVariables.domain.GlobalVariable;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariable;
import lapr4.red.s2.lang.n1150710.BeanShell.BeanShellInterpretationExtension;

/**
 * Responsible to run the script synchronously or asynchronously
 *
 * It should now be possible to invoke Beanshell scripts from macros and
 * formulas using a new function. The new function should be able to execute
 * Beanshell scripts synchronously or asynchronously. If the execution mode is
 * synchronous, then the function should wait for the script to end its
 * execution. In this case the return value of the function should be the value
 * of the last expression of the Beanshell script. If the execution mode is
 * asynchronous then the function should return immediately after launching the
 * execution of the script: the script and the formula/macro will execute in
 * parallel. Existing varia
 *
 *
 *
 * @author 1150710@isep.ipp.pt 
 * @edited by 1150630
 */
public class RunScript extends Thread {

    private final BeanShellScriptList beanShellScriptList;
    private final BeanShellScript selectedScript;
    private final String receivedString;
    private final Workbook workbook;
    private final Spreadsheet spreadsheet;
    private final Cell cell;
    private final Macro macro;
    private final TemporaryVariable temporaryVariable;
    private final GlobalVariable globalVariable;
    private final static String REGEX_DEFAULT = "\\([0-1]{1}\\)";

    /**
     * gets all the saved scripts in the conf file
     *
     * @param scriptName
     * @param workbook
     * @param spreadsheet
     * @param cell
     * @param macro
     */
    public RunScript(String scriptName, Workbook workbook, Spreadsheet spreadsheet, Cell cell, Macro macro, TemporaryVariable temporaryVariable, GlobalVariable globalVariable) {
        this.receivedString = scriptName;
        this.beanShellScriptList = new BeanShellScriptList();
        this.selectedScript = discoverSelectedScript(scriptName.replaceAll(REGEX_DEFAULT, ""));
        this.workbook = workbook;
        this.spreadsheet = spreadsheet;
        this.cell = cell;
        this.macro = macro;
        this.globalVariable = globalVariable;
        this.temporaryVariable = temporaryVariable;
    }

    /**
     * runs the script
     *
     * 0 if synchronously 1 if asynchronously
     *
     *
     * EX: script1(0) or script1(1)
     *
     * @return
     */
    public String runSyncOrAsync() {
        if (this.selectedScript == null) {
            return "";
        }
        /**
         * synchronously
         */
        if (this.receivedString.contains("(0)")) {
            return runScript();
        } /**
         * asynchronously
         */
        else if (this.receivedString.contains("(1)")) {
            /**
             * creates a trhead and runs it
             */
            this.start();
            return "";
        }
        return "";
    }

    /**
     * responsible for asynchronously runtime
     */
    @Override
    public void run() {
        String scriptOutput = runScript();
        Object[] options = {"OK"};
        int n = JOptionPane.showOptionDialog(null,
                "The script " + this.selectedScript.getScriptName()
                + " have an output of:\n\n" + scriptOutput,
                "Script: " + this.selectedScript.getScriptName(),
                JOptionPane.PLAIN_MESSAGE,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
    }

    /**
     * responsible for synchronously runtime
     *
     * @return
     */
    private String runScript() {
        String toReturn = "";
        try {
            BeanShellInterpretationExtension beanShellInterpretationExtension = new BeanShellInterpretationExtension();
            if (this.selectedScript != null) {
                try {
                    toReturn = beanShellInterpretationExtension.execute(this.selectedScript.getBeanShellScript(),
                            this.workbook, this.spreadsheet, this.cell, this.macro, this.temporaryVariable, this.globalVariable)
                            .toText().replace("\n", "");
                } catch (IllegalValueTypeException ex) {
                    Logger.getLogger(RunScript.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (UtilEvalError ex) {
            Logger.getLogger(RunScript.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toReturn;
    }

    /**
     * discover the script selected
     *
     * @return
     */
    public BeanShellScript discoverSelectedScript(String scriptName) {
        for (BeanShellScript bss : this.beanShellScriptList.getBeanShellScripts()) {
            if (bss.getScriptName().equalsIgnoreCase(scriptName)) {
                return bss;
            }
        }
        return null;
    }

}
