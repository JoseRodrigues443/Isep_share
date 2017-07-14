/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150767.macroWindow;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Workbook;
import csheets.core.formula.Function;
import csheets.core.formula.Operator;
import csheets.core.formula.lang.MacroLanguage;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Catarina Sousa
 */
public class MacroWindowControllerTest {
    
    Cell cell;
    
    public MacroWindowControllerTest() {
        Workbook wb = new Workbook();
        wb.addSpreadsheet();
        cell = wb.getSpreadsheet(0).getCell(new Address(0,0));
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
     * Test of functions method, of class MacroWindowController.
     */
    @Test
    public void testFunctions() {
        System.out.println("functions");
        MacroWindowController instance = new MacroWindowController(cell);       
        List<Function> expResult = MacroLanguage.getInstance().functions();
        List<Function> result = instance.functions();
        assertEquals(expResult, result);
    }

    /**
     * Test of operators method, of class MacroWindowController.
     */
    @Test
    public void testOperators() {
        System.out.println("operators");
        MacroWindowController instance = new MacroWindowController(cell);
        List<Operator> expResult = MacroLanguage.getInstance().operators();
        List<Operator> result = instance.operators();
        assertEquals(expResult, result);
    }

    /**
     * Test of execute method, of class MacroWindowController.
     */
    @Ignore
    @Test
    public void testExecute() throws Exception {
        System.out.println("executeMacro");
        List<String> list = new ArrayList<>();
        MacroWindowController instance = new MacroWindowController(cell);
        
        list.add("b1:=12");
        list.add("b2:=3");
        list.add("=b1+b2+10");
        
        String expResult = "25";
        String result = instance.execute(list);
        assertEquals(expResult, result);
        
        list.clear();
        list.add("={_Counter:=1;_Counter:=_Counter+10}");
        list.add("{A5:=_Counter+100}");
        
        expResult = "111";
        result = instance.execute(list);
        assertEquals(expResult, result);
    }
    
}
