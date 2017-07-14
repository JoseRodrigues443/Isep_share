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
public class TemporaryVariableListTest {

    CleanSheets spreadSheetInstance;

    TemporaryVariable temporaryVariable;

    public TemporaryVariableListTest() {

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
     * Test of currentVariables method, of class TemporaryVariableList.
     *
     */
    @Test

    public void testCurrentVariables() {

        System.out.println("currentVariables");

        assertEquals(1, this.spreadSheetInstance.getWorkbooks()[0].findTemporaryVariable().currentVariables().size());

    }

    /**
     *
     * Test of addTemporaryVariable method, of class TemporaryVariableList.
     *
     */
    @Test

    public void testAddTemporaryVariable() {

        System.out.println("addTemporaryVariable");

        TemporaryVariable tmp = new TemporaryVariable(spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(2, 0), "@b", new Value("7"));

        spreadSheetInstance.getWorkbooks()[0].findTemporaryVariable().addTemporaryVariable(spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(2, 0), spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), "@b", new Value("7"));

        assertEquals(2, this.spreadSheetInstance.getWorkbooks()[0].findTemporaryVariable().currentVariables().size());

    }

    /**
     *
     * Test of returnTemporaryValueByElements method, of class
     * TemporaryVariableList.
     *
     */
    @Test

    public void testReturnTemporaryValueByElements() {

        System.out.println("returnTemporaryValueByElements");

        TemporaryVariable tmp = spreadSheetInstance.getWorkbooks()[0].findTemporaryVariable().returnTemporaryValueByElements(spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 0), spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), "@a");

        assertEquals("@a", tmp.currentVariableName());

    }

    /**
     *
     * Test of updateVariableValue method, of class TemporaryVariableList.
     *
     */
    @Test

    public void testUpdateVariableValue() throws IllegalValueTypeException {

        System.out.println("updateVariableValue");

        spreadSheetInstance.getWorkbooks()[0].findTemporaryVariable().updateVariableValue(spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 0), spreadSheetInstance.getWorkbooks()[0].getSpreadsheet(0), "@a", new Value("10"));

        assertEquals("10", spreadSheetInstance.getWorkbooks()[0].findTemporaryVariable().currentVariables().iterator().next().currentVariableValue().toText());

    }
}
