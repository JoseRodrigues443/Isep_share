/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;

/**
 *
 * @author Jorge Campos <1150759@isep.ipp.pt>
 */
public class InstructionBlock implements Function {
    public static final FunctionParameter[] params = new FunctionParameter[] {
        new FunctionParameter(Value.Type.UNDEFINED, "Term", false, "A block"
                + "of instructions")
    };
    
    public InstructionBlock() {
    }
    
    @Override
    public String getIdentifier() {
        return "{";
    }
    
    @Override
    public Value applyTo(Expression[] args) throws IllegalValueTypeException {
        double expResult = 0.0;
        Value value;
        Expression exp = args[args.length-1];
        
        for (int i = 0; i < args.length-1; i++)
            value = args[i].evaluate();
        
        value = exp.evaluate();
        if (null == value.getType())
            throw new IllegalValueTypeException(value, Value.Type.NUMERIC);
        else switch (value.getType()) {
            case NUMERIC:
                expResult += value.toDouble();
                break;
            case MATRIX:
                for (Value[] vec : value.toMatrix())
                    for (Value item : vec) {
                        if (item.getType() == Value.Type.NUMERIC)
                            expResult += item.toDouble();
                        else
                            throw new IllegalValueTypeException(item, Value.Type.NUMERIC);
                    }
                break;
            default:
                throw new IllegalValueTypeException(value, Value.Type.NUMERIC);
        }
        
        return new Value(expResult);
    }
    
    @Override
    public FunctionParameter[] getParameters() {
        return params;
    }
    
    @Override
    public boolean isVarArg() {
        return true;
    }

    @Override
    public String getDescription() {
        return "Represents a function that executes a block of instructions.";
    }

    @Override
    public String getSyntax() {
        return "";
    }
    
}
