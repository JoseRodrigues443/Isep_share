/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1141114.autoSorting;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import lapr4.green.s2.core.n1141431.sortColumnRange.ctr.SortColumnController;
import lapr4.red.s3.core.n1141114.autoSorting.application.AutoSortingController;
import lapr4.red.s3.core.n1141114.autoSorting.application.AutoSortingThread;
import lapr4.red.s3.core.n1141114.autoSorting.ui.AutoSortingAction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class SortAlgorithmsTest {

    private CleanSheets sheet;
    private SortAlgorithms sortAlgorithms;
    private AutoSortingController controller;
    private AutoSortingThread sortingThread;
    private UIController uiController;
    private AutoSortingAction autoSortingAction;

    private Cell[][] cellRange;
    private String[][] cellRangeString;

    public SortAlgorithmsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Ignore
    @Before
    public void setUp() throws FormulaCompilationException {
        sheet = new CleanSheets();
        sheet.create();
        uiController = new UIController(sheet);
        uiController.setActiveWorkbook(sheet.getWorkbooks()[0]);

        autoSortingAction = new AutoSortingAction(uiController);

        controller = new AutoSortingController(uiController, autoSortingAction.getFocusOwner());

        cellRange = autoSortingAction.getFocusOwner().getSelectedCells();

        this.sortAlgorithms = new SortAlgorithms();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Cell cell = sheet.getWorkbooks()[0].getSpreadsheet(0).getCell(i, j);
                cell.setContent(String.valueOf(i + j));
                cellRange[i][j] = cell;
            }
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of ascendingRangeSort method, of class SortAlgorithms.
     */
    @Ignore
    @Test
    public void testAscendingRangeSort() {
        System.out.println("ascendingRangeSort");
        String[][] output = this.sortAlgorithms.ascendingRangeSort(cellRange, 0);
        assertEquals(output[0][0], "");
    }

    /**
     * Test of descendingRangeSort method, of class SortAlgorithms.
     */
    @Ignore
    @Test
    public void testDescendingRangeSort() {
        System.out.println("descendingRangeSort");
        String[][] output = this.sortAlgorithms.ascendingRangeSort(cellRange, 0);
        assertEquals(output[0][0], "0");
    }

    /**
     * Test of sortSpreadSheetRangedCells method, of class SortAlgorithms.
     */
    @Ignore
    @Test
    public void testSortSpreadSheetRangedCells() throws Exception {
        System.out.println("sortSpreadSheetRangedCells");
        String[][] output = this.sortAlgorithms.ascendingRangeSort(cellRange, 0);
        this.sortAlgorithms.sortSpreadSheetRangedCells(this.sheet.getWorkbooks()[0].getSpreadsheet(0), cellRange, output);
        assertEquals(this.sheet.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 0).getContent(), "");
    }

    /**
     * Test of isNumeric method, of class SortAlgorithms.
     */
    @Ignore
    @Test
    public void testIsNumeric() {
        System.out.println("isNumeric");
        String s = "1,50";
        assertTrue(this.sortAlgorithms.isNumeric(s));
    }

    /**
     * Test of AutoSortingSelectingColumn
     */
    @Ignore
    @Test
    public void autoSortingSelectingColumn() {
        System.out.println("AutoSortingSelectingColumn");
        this.uiController.setActivateColumn(0); //This will activate column A and ascending order
        this.sortingThread.update(null, this);
        assertEquals(this.sheet.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 0).getContent(), "");
    }

    /**
     * Test of AutoSortingSelectingColumn
     */
    @Ignore
    @Test
    public void columnOutsideRangeWontSort() {
        System.out.println("AutoSortingSelectingColumn");
        this.uiController.setActivateColumn(5);
        this.uiController.setActivateColumn(5); // This will activate column E and descending order
        this.sortingThread.update(null, this);
        assertEquals(this.sheet.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 0).getContent(), "0"); //This will be 0, because no sort was done
    }

    /**
     * Test of AutoSortingOnlyWhenRowIsComplete
     */
    @Ignore
    @Test
    public void autoSortingOnlyWhenRowIsComplete() throws FormulaCompilationException {
        System.out.println("AutoSortingSelectingColumn");
        this.uiController.setActivateColumn(0);
        this.cellRange[0][1].setContent("");
        this.sortingThread.update(null, this);
        assertEquals(this.sheet.getWorkbooks()[0].getSpreadsheet(0).getCell(0, 0).getContent(), "0"); // The cellRange would still be equal because no sort was implemented
    }

}
