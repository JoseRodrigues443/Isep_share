/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150605.functionBasicWizard.ui;

import csheets.core.Value;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.lang.And;
import csheets.core.formula.lang.Average;
import csheets.core.formula.lang.Count;
import csheets.core.formula.lang.Do;
import csheets.core.formula.lang.Factorial;
import csheets.core.formula.lang.False;
import csheets.core.formula.lang.If;
import csheets.core.formula.lang.Not;
import csheets.core.formula.lang.Or;
import csheets.core.formula.lang.Sum;
import csheets.core.formula.lang.True;
import csheets.ui.ctrl.UIController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class FunctionBasicWizardControllerTest {
    
    public FunctionBasicWizardControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of functions method, of class FunctionBasicWizardController.
     */
    @Ignore
    @Test
    public void testFunctions() {
        System.out.println("functions");
        FunctionBasicWizardController instance = new FunctionBasicWizardController();
        Function[] expResult = {new Factorial(), new True(), new And(), new False(), new Sum(), new Not(), new Or(), new Count(), new If(), new Average(), new Do()};
        Function[] result = instance.functions();
        
        for (int i=0; i<expResult.length; i++) {
             assertEquals(expResult[i].getIdentifier(), result[i].getIdentifier());
        }
    }

    /**
     * Test of getFunctionIdentifier method, of class FunctionBasicWizardController.
     */
    @Test
    public void testGetFunctionIdentifier() {
        System.out.println("getFunctionIdentifier");
        Function f = new Factorial();
        FunctionBasicWizardController instance = new FunctionBasicWizardController();
        String expResult = "FACT";
        String result = instance.getFunctionIdentifier(f);
        assertEquals(expResult, result);
    }

    /**
     * Test of parameterName method, of class FunctionBasicWizardController.
     */
    @Test
    public void testParameterName() {
        System.out.println("parameterName");
        FunctionParameter p = new FunctionParameter(Value.Type.UNDEFINED, "Test", true, "Just testing");
        FunctionBasicWizardController instance = new FunctionBasicWizardController();
        String expResult = "Test";
        String result = instance.parameterName(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of parameterOptional method, of class FunctionBasicWizardController.
     */
    @Test
    public void testParameterOptional() {
        System.out.println("parameterOptional");
        FunctionParameter p = new FunctionParameter(Value.Type.UNDEFINED, "Test", true, "Just testing");
        FunctionBasicWizardController instance = new FunctionBasicWizardController();
        boolean expResult = true;
        boolean result = instance.parameterOptional(p);
        assertEquals(expResult, result);
    }

    /**
     * Test of parameterDescription method, of class FunctionBasicWizardController.
     */
    @Test
    public void testParameterDescription() {
        System.out.println("parameterDescription");
        FunctionParameter p = new FunctionParameter(Value.Type.UNDEFINED, "Test", true, "Just testing");;
        FunctionBasicWizardController instance = new FunctionBasicWizardController();
        String expResult = "Just testing";
        String result = instance.parameterDescription(p);
        assertEquals(expResult, result);
    }
}
