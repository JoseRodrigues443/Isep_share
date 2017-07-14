/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1151117.formula.lang;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Expression;
import java.util.Arrays;
import java.util.LinkedList;
import lapr4.gray.s1.lang.n3456789.formula.NaryOperator;

/**
 * Class representing a for loop
 *
 * @author Barros
 */
public class For implements NaryOperator {

    @Override
    public Value applyTo(Expression[] operands) throws IllegalValueTypeException {
        Value result = null; /* this variable will contain the final value of the for loop operation */
        LinkedList<Expression> expressions = new LinkedList<>(Arrays.asList(operands)); /* linkedlist to work with the operands */
        Expression init = expressions.poll();
        Expression cond = expressions.poll();
        for (init.evaluate(); cond.evaluate().toBoolean();) {
            for (Expression e : expressions) {
                result = e.evaluate();
            }
        }
        return result;
    }

    @Override
    public String getIdentifier() {
        return "FOR";
    }

    @Override
    public Value.Type getOperandValueType() {
        return Value.Type.UNDEFINED;
    }
}
