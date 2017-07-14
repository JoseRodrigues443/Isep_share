/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1141431.conditional.formatting;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Pedro Oliveira(1141431)
 */
public class ConditionalFormattingCellTest {

    public ConditionalFormattingCellTest() {
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

//    @Test
//    public void cellMustNotBeNull() throws FormulaCompilationException {
//
//        String expResult = "21";
//        CleanSheets app = new CleanSheets();
//
//        Spreadsheet folha;
//        // This will create a workbook with 3 sheets
//        app.create();
//        folha = app.getWorkbooks()[0].getSpreadsheet(1);
//        folha.getCell(new Address(1, 1)).setContent("21");
//        UIController instance = new UIController(app);
//        assertEquals(expResult, folha.getCell(1, 1).getContent());
//
//    }

//    /*
//    checks if the method that puts the information in the sidebar is working
//     */
//    @Test
//    public void checksIfConditionInformationIsRight() throws FormulaCompilationException {
//
//        String result = "";
//        CleanSheets app = new CleanSheets();
//        Spreadsheet folha;
//        app.create();
//
//        folha = app.getWorkbooks()[0].getSpreadsheet(1);
//        folha.getCell(new Address(2, 2)).setContent("1");
//        UIController instance = new UIController(app);
//        System.out.println(folha.getCell(2, 2).getContent());
//        instance.setCondition(folha.getCell(2, 2).getContent());
//
//        result = instance.getCondition();
//
//        assertEquals(folha.getCell(2, 2).getContent(), result);
//
//    }

}
