/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1150433.evalWhileLoops.domain;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.compiler.FormulaCompilationException;
import lapr4.blue.s3.lang.n1150433.evalWhileLoops.compile.ExcelExpressionCompiler;

/**
 *
 * @author Débora Costa - 1150433
 */
public class Eval implements Function{
    public static final FunctionParameter[] parameters = new FunctionParameter[]{
		new FunctionParameter(Value.Type.TEXT, "Expression", false, "Expression")
    };
    
    public Eval(){
    }
    
    @Override
    public String getIdentifier() {
        return "EVAL";
    }

    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        String value = args[0].evaluate().toString();
        ExcelExpressionCompiler compiler = new ExcelExpressionCompiler();
        try{
            Expression expression = compiler.compile(null, "=" + value);
            return expression.evaluate();
        } catch (FormulaCompilationException ex) {
            System.out.println(ex + "\nThe expression " + value + " couldn't be compiled!");
        }
        return new Value();
    }

    @Override
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    @Override
    public boolean isVarArg() {
        return false;
    }

    @Override
    public String getDescription() {
        return "Eval function";
    }

    @Override
    public String getSyntax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
