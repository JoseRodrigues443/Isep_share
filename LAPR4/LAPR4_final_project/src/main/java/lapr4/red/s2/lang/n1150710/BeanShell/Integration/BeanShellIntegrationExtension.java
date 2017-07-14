/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150710.BeanShell.Integration;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.lang.Macro;
import lapr4.red.s2.lang.n1141114.globalVariables.domain.GlobalVariable;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariable;

/**
 * class that implementes the
 *
 *
 * @author 1150710@isep.ipp.pt
 * @edited by 1150630
 */
public class BeanShellIntegrationExtension {

    private static final String[] SEPARATORS_DEFAULT = {
        "#", "#"
    };

    /**
     * It should now be possible to invoke Beanshell scripts from macros and
     * formulas using a new function. The new function should be able to execute
     * Beanshell scripts synchronously or asynchronously. If the execution mode
     * is synchronous, then the function should wait for the script to end its
     * execution. In this case the return value of the function should be the
     * value of the last expression of the Beanshell script. If the execution
     * mode is asynchronous then the function should return immediately after
     * launching the execution of the script: the script and the formula/macro
     * will execute in parallel. Existing varia
     *
     *
     * EX: "=fact([script5Plus5(0)])" returns "=fact(10)"
     *
     * EX: "= 5*5[scriptShowRandomNumber(1)]" will return "=5*5" and
     * asynchronously run the script and show in a show option pane
     *
     *
     * @param allTextInCell
     * @return String
     */
    public static String beanShellIntegration(String allTextInCell) {
        String toReturn = allTextInCell;
        boolean isThereMoreScripts = true;
        while (isThereMoreScripts) {
            if (toReturn.contains(SEPARATORS_DEFAULT[0])
                    && toReturn.contains(SEPARATORS_DEFAULT[1])) {

                int start = allTextInCell.indexOf(SEPARATORS_DEFAULT[0]);
                start++;    //ignore [ character i only want whats inside of []
                int end = allTextInCell.indexOf(SEPARATORS_DEFAULT[1]);
                String beanShellScript = allTextInCell.substring(start, end);
                Workbook workbook = new Workbook(1);
                Spreadsheet spreadsheet = null;
                Cell cell = null;
                TemporaryVariable temporaryVariable = new TemporaryVariable(spreadsheet, cell, "temporaryVariable", null);
                GlobalVariable globalVariable = new GlobalVariable(spreadsheet, cell, "globalVariable", null);
                Macro macro = new Macro(workbook.getSpreadsheet(0).getCell(cell.getAddress()), cell.getContent());
                RunScript rs = new RunScript(beanShellScript, workbook, spreadsheet, cell, macro, temporaryVariable, globalVariable);
                String result = rs.runSyncOrAsync();
                toReturn = allTextInCell.replace(SEPARATORS_DEFAULT[0] + beanShellScript + SEPARATORS_DEFAULT[1], result);
                //System.out.println("");
            } else {
                /**
                 * get out of cicle no more scripts in macro
                 */
                isThereMoreScripts = false;
            }
        }
        return toReturn;
    }

}
