/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1141114.globalVariables.domain;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
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
public class GlobalVariableTest {

    CleanSheets spreadSheetInstance;
    GlobalVariable globalVariable;

    public GlobalVariableTest() {
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
     * Test of currentGlobalVariableName method, of class GlobalVariable.
     */
    @Test
    public void testCurrentGlobalVariableName() {
        System.out.println("currentGlobalVariableName");
        assertEquals("@a", this.globalVariable.currentGlobalVariableName());
    }

    /**
     * Test of currentGlobalVariableValue method, of class GlobalVariable.
     */
    @Test
    public void testCurrentGlobalVariableValue() throws IllegalValueTypeException {
        System.out.println("currentGlobalVariableValue");
        assertEquals("7", this.globalVariable.currentGlobalVariableValue().toText());
    }

    /**
     * Test of assignGlobalVariableValue method, of class GlobalVariable.
     */
    @Test
    public void testAssignGlobalVariableValue() throws IllegalValueTypeException {
        System.out.println("assignGlobalVariableValue");
        Value value = new Value("10");
        this.globalVariable.assignGlobalVariableValue(value,spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 1), spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0) );
        assertEquals("10", this.globalVariable.currentGlobalVariableValue().toText());
    }

    /**
     * Test of GlobalVariableAccessDifferentCells method
     */
    @Test
    public void globalVariableAccessDifferentCells() {
        System.out.println("GlobalVariableAccessDifferentCells");
        GlobalVariable temp = this.spreadSheetInstance.getWorkbooks()[0].findGlobalVariables()
                .returnGlobalVariableByElements(this.spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 1), this.spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), "@a"); // Diferente cell trying to access the global variable
        assertEquals("@a", temp.currentGlobalVariableName());
        assertEquals("A1", temp.cellWhereDefined().getAddress().toString());
    }

}
