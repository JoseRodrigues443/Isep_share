/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150710.BeanShell;

import bsh.UtilEvalError;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.formula.lang.Macro;
import lapr4.red.s2.lang.n1141114.globalVariables.domain.GlobalVariable;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariable;

/**
 *
 * @author 11050710@isep.ipp.pt
 * @edited by 1150630
 *
 *
 */
public class BeanShellController {

    BeanShellInterpretationExtension bsie;

    private final static String REGEX_DETECT_CODE_DEFAULT = "[a-zA-Z\\\"\\[\\]\\(\\)\\.]*;";

    public BeanShellController() {
        try {
            this.bsie = new BeanShellInterpretationExtension();
        } catch (UtilEvalError e) {
        }
    }

    /**
     * validates if a string/script is made with java code
     *
     * @param s
     * @return
     */
    public boolean validate(String s) {
        return (s.contains("return") || s.contains("new") || s.matches(REGEX_DETECT_CODE_DEFAULT));
    }

    public String executeScript(String s, Workbook workbook, Spreadsheet spreadsheet, Cell cell, Macro macro, TemporaryVariable temporaryVariable, GlobalVariable globalVariable) {
        //bsie.testScript();
        Value response = bsie.execute(s, workbook, spreadsheet, cell, macro, temporaryVariable, globalVariable);
        return response.toString();
    }
}
