/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150630.insertImage;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.Spreadsheet;
import csheets.core.SpreadsheetImpl;
import csheets.core.Workbook;
import java.util.ArrayList;
import java.util.List;
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
public class InsertImageCellTest{
    
    public InsertImageCellTest() {
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
     * Test of imageList method, of class InsertImageCell.
     */
    @Test
    public void testImageList() {
        System.out.println("imageList");
        Workbook w = new Workbook();
        w.addSpreadsheet();
        Address address = new Address(1, 1);
        InsertImageCell instance = new InsertImageCell(w.getSpreadsheet(0).getCell(0,0));
        String path = "Test";
        String path2 = "Test1";
        String path3 = "Test2";
        CellImage img = new CellImage(path);
        CellImage img2 = new CellImage(path2);
        CellImage img3 = new CellImage(path3);
        instance.addImage(path);
        instance.addImage(path2);
        instance.addImage(path3);
        List<CellImage> expResult = new ArrayList<>();
        expResult.add(img);
        expResult.add(img2);
        expResult.add(img3);
        List<CellImage> result = instance.getImageList();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasImage method, of class InsertImageCell.
     */
    @Test
    public void testHasImage() {
        System.out.println("hasImage since we didn't add any image the result should be false");
        Workbook w = new Workbook();
        w.addSpreadsheet();
        InsertImageCell instance = new InsertImageCell(w.getSpreadsheet(0).getCell(0,0));
        boolean expResult = false;
        boolean result = instance.hasImage();
        assertEquals(expResult, result);
    }

    /**
     * Test of hasImage method, of class InsertImageCell.
     */
    @Test
    public void testHasImage2() {
        System.out.println("hasImage");
        Workbook w = new Workbook();
        w.addSpreadsheet();
        InsertImageCell instance = new InsertImageCell(w.getSpreadsheet(0).getCell(0,0));
        instance.addImage("Test");
        boolean expResult = true;
        boolean result = instance.hasImage();
        assertEquals(expResult, result);
    }

    /**
     * Test of addImage method, of class InsertImageCell.
     */
    @Test
    public void testAddImage() {
        System.out.println("addImage, the result must be true because there is no other image with this path");
        String path = "Test";
        Workbook w = new Workbook();
        w.addSpreadsheet();
        InsertImageCell instance = new InsertImageCell(w.getSpreadsheet(0).getCell(0,0));
        boolean expResult = true;
        boolean result = instance.addImage(path);
        assertEquals(expResult, result);
    }

    /**
     * Test of addImage method, of class InsertImageCell.
     */
    @Test
    public void testAddImage2() {
        System.out.println("addImage, the result must be false because there is  other image with this path");
        String path = "Test";
        Workbook w = new Workbook();
        w.addSpreadsheet();
        InsertImageCell instance = new InsertImageCell(w.getSpreadsheet(0).getCell(0,0));
        instance.addImage(path);
        instance.addImage(path);
        boolean expResult = false;
        boolean result = instance.addImage(path);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeImage method, of class InsertImageCell.
     */
    @Test
    public void testRemoveImage() {
        System.out.println("removeImage, the result must be false because there is no Image with that path to be removed");
        String path = "Test";
        String path2 = "TestError";
        Workbook w = new Workbook();
        w.addSpreadsheet();
        InsertImageCell instance = new InsertImageCell(w.getSpreadsheet(0).getCell(0,0));
        instance.addImage(path);
        CellImage image = new CellImage(path2);
        boolean expResult = false;
        boolean result = instance.removeImage(image);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeImage method, of class InsertImageCell.
     */
    @Test
    public void testRemoveImage2() {
        System.out.println("removeImage, the result must be true because there is an Image with that path to be removed");
        String path = "Test";
        Workbook w = new Workbook();
        w.addSpreadsheet();
        InsertImageCell instance = new InsertImageCell(w.getSpreadsheet(0).getCell(0,0));
        instance.addImage(path);
        CellImage image = new CellImage(path);
        boolean expResult = true;
        boolean result = instance.removeImage(image);
        assertEquals(expResult, result);
    }

    
}
