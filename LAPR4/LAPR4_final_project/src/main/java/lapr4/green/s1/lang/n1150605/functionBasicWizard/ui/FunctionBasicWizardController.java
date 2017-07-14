/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150605.functionBasicWizard.ui;

import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.Language;
import csheets.ui.ctrl.UIController;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class FunctionBasicWizardController {
    Language lang;
    
    public FunctionBasicWizardController() {
        this.lang = Language.getInstance();
    }
    
    /**
     * Returns the singleton instance.
     *
     * @return the singleton instance
     */
    public Function[] functions() {
        return lang.getFunctions();
    }
    
    /**
     * Returns the function's string identirifer.
     * @param f, the function
     * @return a string representation of the operator.
     */
    public String getFunctionIdentifier(Function f) {
        return f.getIdentifier();
    }
    
    /**
    * Returns the parameters of the function.
    * @param f, the function
    * @return the parameters of the function
    */
    public FunctionParameter[] functionParameters(Function f) {
        return f.getParameters();
    }
    
    /**
     * Returns the name of the argument.
     * @param p, the argument
     * @return the name of the argument
     */
    public String parameterName(FunctionParameter p) {
        return p.getName();
    }
    
    /**
    * Returns whether the parameter is optional.
     * @param p, the argument
    * @return whether the parameter is optional
    */
    public boolean parameterOptional(FunctionParameter p) {
        return p.isOptional();
    }
    
    /**
    * Returns the description of the argument.
    * @param p, the argument
    * @return the description of the argument
    */
    public String parameterDescription(FunctionParameter p) {
        return p.getDescription();
    }
    
    /**
     * Changes the cell's value, given a string.
     * @param UICont, the user interface controller
     * @param str, the string to copy
     * @throws FormulaCompilationException 
     */
    public void setFormulaBarExpression(UIController UICont, String str) throws FormulaCompilationException {
        UICont.getActiveCell().setContent(str);
    }
}
