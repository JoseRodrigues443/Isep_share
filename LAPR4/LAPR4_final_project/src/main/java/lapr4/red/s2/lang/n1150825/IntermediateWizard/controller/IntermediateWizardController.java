/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150825.IntermediateWizard.controller;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import lapr4.green.s1.lang.n1150605.functionBasicWizard.ui.FunctionBasicWizardController;

/**
 *
 * Extends the methods from the FunctionBasicWizardController
 * 
 * @author João Coelho
 */
public class IntermediateWizardController extends FunctionBasicWizardController{
    public IntermediateWizardController(){
        super();
    }
    
    public Value cellPreview(String str) throws FormulaCompilationException{
        Workbook w=new Workbook(1);
        Cell cell=w.getSpreadsheet(0).getCell(0, 0);
        cell.setContent(str);
        return cell.getValue();
    }
    }
