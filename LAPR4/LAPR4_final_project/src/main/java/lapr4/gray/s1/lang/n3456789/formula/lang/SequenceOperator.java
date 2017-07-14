/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.gray.s1.lang.n3456789.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;

import lapr4.gray.s1.lang.n3456789.formula.NaryOperator;

/**
 *
 * @author alexandrebraganca
 */
public class SequenceOperator implements NaryOperator {
    
    //private Expression[] operands=null;

    @Override
    public Value applyTo(Expression[] operands) throws IllegalValueTypeException {
        Value value=null;
        //this.operands=operands;
        
        // evaluate each expression and return the last value
        for (Expression expr: operands) {
            value=expr.evaluate();
        }
        
        return value;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Need to modify the identifier????
     * @return identifier
     */
    @Override
    public String getIdentifier() {
        return "{";
    }

    @Override
    public Value.Type getOperandValueType() {
        return Value.Type.UNDEFINED;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
