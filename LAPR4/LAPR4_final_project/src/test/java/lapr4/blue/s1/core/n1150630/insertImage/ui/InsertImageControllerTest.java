/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150630.insertImage.ui;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.SpreadsheetImpl;
import csheets.core.Workbook;
import lapr4.blue.s1.core.n1150630.insertImage.InsertImageCell;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class InsertImageControllerTest {
    
    public InsertImageControllerTest() {
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
     * Test of addImage method, of class InsertImageController.
     */
    @Test
    public void testAddImage() {
        System.out.println("addImage, the resul must be true because there is no Image with that path");
        Workbook w = new Workbook();
        w.addSpreadsheet();
        InsertImageCell cellI = new InsertImageCell(w.getSpreadsheet(0).getCell(0,0));
        String path = "test";
        InsertImageController instance = new InsertImageController();
        boolean expResult = true;
        boolean result = instance.addImage(cellI, path);
        assertEquals(expResult, result);
    }

    /**
     * Test of addImage method, of class InsertImageController.
     */
    @Test
    public void testAddImage2() {
        System.out.println("addImage, the result must be false because there is an image with that path");
        Workbook w = new Workbook();
        w.addSpreadsheet();
        InsertImageCell cellI = new InsertImageCell(w.getSpreadsheet(0).getCell(0,0));
        String path = "test";
        cellI.addImage(path);
        InsertImageController instance = new InsertImageController();
        boolean expResult = false;
        boolean result = instance.addImage(cellI, path);
        assertEquals(expResult, result);
    }
    
}
