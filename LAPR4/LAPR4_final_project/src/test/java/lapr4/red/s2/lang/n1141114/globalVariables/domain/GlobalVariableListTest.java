/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1141114.globalVariables.domain;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class GlobalVariableListTest {

    CleanSheets spreadSheetInstance;
    GlobalVariable globalVariable;

    public GlobalVariableListTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        spreadSheetInstance = new CleanSheets();
        spreadSheetInstance.create();
        globalVariable = new GlobalVariable(spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 0), "@a", new Value("7"));
        spreadSheetInstance.getWorkbooks()[0].findGlobalVariables().addGlobalVariable(spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 0), spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), "@a", new Value("7"));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of currentVariables method, of class GlobalVariableList.
     */
    @Test
    public void testCurrentVariables() {
        System.out.println("currentVariables");
        assertEquals(1, this.spreadSheetInstance.getWorkbooks()[0].findGlobalVariables().currentVariables().size());
    }

    /**
     * Test of addGlobalVariable method, of class GlobalVariableList.
     */
    @Test
    public void testAddGlobalVariable() {
        System.out.println("addGlobalVariable");
        GlobalVariable tmp = new GlobalVariable(spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(2, 0), "@b", new Value("7"));
        spreadSheetInstance.getWorkbooks()[0].findGlobalVariables().addGlobalVariable(spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(2, 0), spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), "@b", new Value("7"));
        assertEquals(2, this.spreadSheetInstance.getWorkbooks()[0].findGlobalVariables().currentVariables().size());
    }

    /**
     * Test of returnGlobalVariableByElements method, of class
     * GlobalVariableList.
     */
    @Test
    public void testReturnGlobalVariableByElements() {
        System.out.println("returnGlobalVariableByElements");
        GlobalVariable tmp = spreadSheetInstance.getWorkbooks()[0].findGlobalVariables().returnGlobalVariableByElements(null, null, "@a");
        assertEquals("@a", tmp.currentGlobalVariableName());
    }

    /**
     * Test of updateVariableValue method, of class GlobalVariableList.
     */
    @Test
    public void testUpdateVariableValue() throws IllegalValueTypeException {
        System.out.println("updateVariableValue");
        spreadSheetInstance.getWorkbooks()[0].findGlobalVariables().updateVariableValue(null, null, "@a", new Value("10"));
        assertEquals("10", spreadSheetInstance.getWorkbooks()[0].findGlobalVariables().currentVariables().iterator().next().currentGlobalVariableValue().toText());
    }

}
