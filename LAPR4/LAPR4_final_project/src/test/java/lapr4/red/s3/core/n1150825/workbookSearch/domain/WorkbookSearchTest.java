/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150825.workbookSearch.domain;

import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Coelho
 */
public class WorkbookSearchTest {
    
    public WorkbookSearchTest() {
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
     * 
     * Sees if the search gets the cells correctly and that the returned result is as expected
     * 
     * Test of searchSpreadsheet and searchResults method, of class WorkbookSearch.
     */
    @Test
    public void testSearchSpreadsheet() throws FormulaCompilationException {
        System.out.println("searchSpreadsheet");
        Workbook w = new Workbook(1);
        Spreadsheet activeSpreadsheet = w.getSpreadsheet(0);
        activeSpreadsheet.getCell(1, 3).setContent(" test confirmed");
        String text = "test";
        WorkbookSearch instance = new WorkbookSearch();
        instance.searchSpreadsheet(activeSpreadsheet, text);
        assertEquals("Address "+activeSpreadsheet.getCell(1, 3).getAddress()+
                " with content "+activeSpreadsheet.getCell(1, 3).getContent(),
                instance.searchResults().get(0));
    }
    
}
