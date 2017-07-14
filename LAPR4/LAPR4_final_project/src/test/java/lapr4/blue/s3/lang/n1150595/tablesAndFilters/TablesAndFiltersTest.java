/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1150595.tablesAndFilters;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
public class TablesAndFiltersTest {
    
    TablesAndFilters instance = new TablesAndFilters("test");
    Workbook workbook = new Workbook(2);
    Spreadsheet spreadsheet = workbook.getSpreadsheet(0);

    /**
     * Test of resetContent method, of class TablesAndFilters.
     */
    @Test
    public void testResetContent() throws Exception {
        System.out.println("resetContent");
        Cell cell1 = spreadsheet.getCell(0, 0);
        cell1.setContent("1");
        Cell cell2 = spreadsheet.getCell(1, 0);
        cell2.setContent("2");
        Cell[][] expResult = new Cell[2][1];
        expResult[0][0] = cell1;
        expResult[1][0] = cell2;
        String[][] contents = new String[2][1];
        contents[0][0] = "1";
        contents[1][0] = "2";
        instance.setInicialContent(contents);
        instance.setContent(expResult);
        cell1.setContent("3");
        cell2.setContent("4");
        instance.resetContent();
        assertEquals(spreadsheet.getCell(0,0).getContent(),"1");
        assertEquals(spreadsheet.getCell(1,0).getContent(),"2");
    }
    
}
