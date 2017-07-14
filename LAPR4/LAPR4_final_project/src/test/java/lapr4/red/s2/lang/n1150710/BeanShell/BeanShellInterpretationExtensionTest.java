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
import csheets.ui.ctrl.UIController;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.red.s2.lang.n1141114.globalVariables.domain.GlobalVariable;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariable;
import lapr4.red.s2.lang.n1150710.BeanShell.Integration.RunScript;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public class BeanShellInterpretationExtensionTest {

    public BeanShellInterpretationExtensionTest() {
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

    @Test
    public void testSomeMethod() {

    }

    /**
     * Test of testScript method, of class BeanShellInterpretationExtension.
     */
    @Test
    public void testTestScript() {
        System.out.println("testScript");
        BeanShellInterpretationExtension instance = null;
        try {
            instance = new BeanShellInterpretationExtension();
        } catch (UtilEvalError ex) {
            Logger.getLogger(BeanShellInterpretationExtensionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean expResult = true;
        boolean result = instance.testScript();
        assertEquals(expResult, result);
    }

    /**
     * Test of execute method, of class BeanShellInterpretationExtension.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        String insertedCode = BeanShellInterpretationExtension.exampleScript();
        BeanShellInterpretationExtension instance;
        try {
            instance = new BeanShellInterpretationExtension();
            Value expResult = new Value("10\n");
            Workbook workbook = new Workbook(1);
            Spreadsheet spreadsheet = null;
            Cell cell = null;
            Macro macro = new Macro();
            Value v = new Value(10);
            TemporaryVariable t = new TemporaryVariable(spreadsheet, cell, "temp", v);
            GlobalVariable g = new GlobalVariable(spreadsheet, cell, "glob", v);
            Value result = instance.execute(insertedCode, workbook, spreadsheet, cell, macro, t, g);
            assertEquals(expResult, result);
        } catch (UtilEvalError ex) {
            Logger.getLogger(BeanShellInterpretationExtensionTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }

    }

    /**
     * Test of exampleScript method, of class BeanShellInterpretationExtension.
     */
    @Test
    public void testExampleScript() {
        System.out.println("exampleScript");
        String expResult = "import csheets.core.Address;\n"
                + "import csheets.core.Value;\n"
                + "import csheets.core.Workbook;\n"
                + "import csheets.core.formula.lang.Macro;\n"
                + "\n"
                + "Workbook workbookParameter = new Workbook(1);\n"
                + "Macro macroParameter = new Macro(workbookParameter.getSpreadsheet(0).getCell(new Address(0, 0)),\"5+5\");\n"
                + "String result = macroParameter.execute();\n"
                + "Value v = new Value(result);\n"
                + "return v;\n";;
        String result = BeanShellInterpretationExtension.exampleScript();
        assertEquals(expResult, result);
    }

}
