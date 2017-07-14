/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150835.temporaryVariables.domain;

import csheets.core.Value;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rui Braga
 */
public class TemporaryVariableTest {
    
    public TemporaryVariableTest() {
    }
    
    /**
     * Test of getValue and setValue methods, of class TemporaryVariable.
     */
    @Test
    public void testGetSetValue() {
        TemporaryVariable instance = new TemporaryVariable("_a", new Value(0.0));
        Value expResult1 = new Value(0.0);
        Value result = instance.getValue();
        assertEquals(expResult1, result);

        instance.setValue(new Value(2.0));
        Value expResult2 = new Value(2.0);
        result = instance.getValue();
        assertEquals(expResult2, result);
    }

    /**
     * Test of getName method, of class TemporaryVariable.
     */
    @Test
    public void testGetName() {
        TemporaryVariable instance = new TemporaryVariable("_a", new Value(0.0));
        String expResult = "_a";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

     /**
     * Test of toString method, of class TemporaryVariable.
     */
    @Test
    public void testToString() {
        TemporaryVariable instance = new TemporaryVariable("_a", new Value(0.0));
        String expResult = "_a = 0";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of equals method, of class TemporaryVariable.
     */
    @Test
    public void testEquals() {
        Object obj = new TemporaryVariable("_a", new Value(0.0));;
        TemporaryVariable instance = new TemporaryVariable("_a", new Value(0.0));
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class TemporaryVariable, when two variables aren't equal
     */
    @Test
    public void testNotEquals() {
        Object obj = new TemporaryVariable("_a", new Value(0.0));;
        TemporaryVariable instance = new TemporaryVariable("_b", new Value(0.0));
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
