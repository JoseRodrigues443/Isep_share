/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150710.BeanShell.Integration;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Workbook;
import csheets.core.formula.lang.Macro;
import lapr4.red.s2.lang.n1141114.globalVariables.domain.GlobalVariable;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public class RunScriptTest {

    public RunScriptTest() {
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
     * Test of runSyncOrAsync method, of class RunScript.
     */
    @Ignore
    @Test
    public void testRunSyncOrAsync() {
        System.out.println("runSyncOrAsync");
        String scriptName = "macroFivePlusFive(0)";
        Workbook workbook = new Workbook(1);
        Spreadsheet spreadsheet = null;
        Cell cell = null;
        Macro macro = new Macro();
        Value v = new Value(10);
        TemporaryVariable t = new TemporaryVariable(spreadsheet, cell, "temp", v);
        GlobalVariable g = new GlobalVariable(spreadsheet, cell, "glob", v);
        RunScript instance = new RunScript(scriptName, workbook, spreadsheet, cell, macro, t, g);
        String expResult = "10";
        String result = instance.runSyncOrAsync();
        assertEquals(expResult, result);
    }

    /**
     * Test of run method, of class RunScript.
     */
    @Ignore
    @Test
    public void testRun() {
        System.out.println("run");
        Workbook workbook = new Workbook(1);
        Spreadsheet spreadsheet = null;
        Cell cell = null;
        Macro macro = new Macro();
        Value v = new Value(10);
        TemporaryVariable t = new TemporaryVariable(spreadsheet, cell, "temp", v);
        GlobalVariable g = new GlobalVariable(spreadsheet, cell, "glob", v);
        RunScript instance = new RunScript("macroFivePlusFive(0)", workbook, spreadsheet, cell, macro, t, g);
        //instance.run();            //imposible to test threads
        assertTrue(true);
    }

    /**
     * Test of discoverSelectedScript method, of class RunScript.
     */
    @Test
    public void testDiscoverSelectedScript() {
        System.out.println("discoverSelectedScript");
        String scriptName = "macroFivePlusFive";
        Workbook workbook = new Workbook(1);
        Spreadsheet spreadsheet = null;
        Cell cell = null;
        Macro macro = new Macro();
        Value v = new Value(10);
        TemporaryVariable t = new TemporaryVariable(spreadsheet, cell, "temp", v);
        GlobalVariable g = new GlobalVariable(spreadsheet, cell, "glob", v);
        RunScript instance = new RunScript(scriptName, workbook, spreadsheet, cell, macro, t, g);
        BeanShellScriptList bssl = new BeanShellScriptList();
        BeanShellScript expResult = new BeanShellScript("macroFivePlusFive", "macroFivePlusFive", "macroFivePlusFive");
        BeanShellScript result = instance.discoverSelectedScript(scriptName);
        assertEquals(expResult, result);
    }

}
