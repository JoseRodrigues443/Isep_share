/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1141431.sortColumnRange.ctr2;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import lapr4.blue.s1.core.n1140525.sortColumn.domain.Sort;
import lapr4.green.s2.core.n1141431.sortColumnRange.ctr.SortColumnController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Pedro Oliveira 1141431
 */
public class SortColumnControllerIT {

    public SortColumnControllerIT() {
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

    @Ignore
    @Test
    public void testAscendingRangeSort() throws FormulaCompilationException {
        Workbook wb = new Workbook(1);
        CleanSheets ap = new CleanSheets();
        ap.create();
        UIController uic = new UIController(ap);
        SortColumnController instance = new SortColumnController(uic);
        wb.addSpreadsheet();
        uic.setActiveWorkbook(wb);

        uic.setActiveSpreadsheet(wb.getSpreadsheet(0));
        uic.getActiveSpreadsheet().getCell(0, 0).setContent("3");
        uic.getActiveSpreadsheet().getCell(0, 1).setContent("4");
        uic.getActiveSpreadsheet().getCell(1, 0).setContent("1");
        uic.getActiveSpreadsheet().getCell(1, 1).setContent("2");

        Cell beginning = instance.getCellFromRange("1-1");
        Cell end = instance.getCellFromRange("2-2");
        Cell[][] cell = instance.chosenRange(beginning, end);
        for (int i = 0; i < cell.length; i++) {
            for (int j = 0; j < cell.length; j++) {
                System.out.println(cell[i][j].getContent() + " ");

            }
            System.out.println("\n");
        }

        String[][] result = instance.ascendingRangeSort(cell);
        String[][] expectedResult = new String[2][2];

        expectedResult[0][0] = "1";
        expectedResult[0][1] = "2";
        expectedResult[1][0] = "3";
        expectedResult[1][1] = "4";
        assertArrayEquals("test", expectedResult, result);
    }

    @Ignore
    @Test
    public void testDescendingRangeSort() throws FormulaCompilationException {
        Workbook wb = new Workbook(1);
        CleanSheets ap = new CleanSheets();
        ap.create();
        UIController uic = new UIController(ap);
        SortColumnController instance = new SortColumnController(uic);

        uic.getActiveSpreadsheet().getCell(0, 0).setContent("3");
        uic.getActiveSpreadsheet().getCell(0, 1).setContent("4");
        uic.getActiveSpreadsheet().getCell(1, 0).setContent("1");
        uic.getActiveSpreadsheet().getCell(1, 1).setContent("2");

        Cell beginning = instance.getCellFromRange("1-1");
        Cell end = instance.getCellFromRange("2-2");
        Cell[][] cell = instance.chosenRange(beginning, end);
        String[][] result = instance.descendingRangeSort(cell);
        String[][] expectedResult = new String[2][2];

        expectedResult[0][0] = "4";
        expectedResult[0][1] = "3";
        expectedResult[1][0] = "1";
        expectedResult[1][1] = "2";
        assertArrayEquals("test", expectedResult, result);
    }
}
