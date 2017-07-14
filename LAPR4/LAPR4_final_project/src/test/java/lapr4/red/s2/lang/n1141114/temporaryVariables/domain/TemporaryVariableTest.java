/*

 * To change this license header, choose License Headers in Project Properties.

 * To change this template file, choose Tools | Templates

 * and open the template in the editor.

 */
package lapr4.red.s2.lang.n1141114.temporaryVariables.domain;

import csheets.CleanSheets;

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
 *
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 *
 */
public class TemporaryVariableTest {

    CleanSheets spreadSheetInstance;

    TemporaryVariable temporaryVariable;

    public TemporaryVariableTest() {

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

        temporaryVariable = new TemporaryVariable(spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 0), "@a", new Value("7"));

        spreadSheetInstance.getWorkbooks()[0].findTemporaryVariable().addTemporaryVariable(spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 0), spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), "@a", new Value("7"));

    }

    @After

    public void tearDown() {

    }

    /**
     *
     * Test of getTempVariableName method, of class TemporaryVariable.
     *
     */
    @Test

    public void testGetTempVariableName() {

        System.out.println("getTempVariableName");

        assertEquals("@a", spreadSheetInstance.getWorkbooks()[0].findTemporaryVariable().currentVariables().iterator().next().currentVariableName());

    }

    /**
     *
     * Test of getTempVariableValue method, of class TemporaryVariable.
     *
     */
    @Test

    public void testGetTempVariableValue() throws IllegalValueTypeException {

        System.out.println("getTempVariableValue");

        assertEquals("7", spreadSheetInstance.getWorkbooks()[0].findTemporaryVariable().currentVariables().iterator().next().currentVariableValue().toText());

    }

    /**
     *
     * Test of setValueToVariable method, of class TemporaryVariable.
     *
     */
    @Test

    public void testSetValueToVariable() throws IllegalValueTypeException {

        System.out.println("setValueToVariable");

        Value value = new Value("10");

        this.temporaryVariable.assignValueToVariable(value);

        assertEquals("10", this.temporaryVariable.currentVariableValue().toText());

    }

    /**
     *
     * Test of temporaryVariableAcessDeniedOutsideContext
     *
     */
    @Test

    public void temporaryVariableAcessDeniedOutsideContext() {

        System.out.println("temporaryVariableAcessDeniedOutsideContext");

        TemporaryVariable temp = this.spreadSheetInstance.getWorkbooks()[0].findTemporaryVariable()
                .returnTemporaryValueByElements(this.spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 1), this.spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), "@a"); // Diferente cell trying to access the temporary variable, should return null

        assertNull(temp);

        TemporaryVariable temp1 = this.spreadSheetInstance.getWorkbooks()[0].findTemporaryVariable()
                .returnTemporaryValueByElements(this.spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 0), this.spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), "@a"); // Same cell trying to access the temporary variable, should return the temp variable

        assertEquals("@a", temp1.currentVariableName());

    }

}
