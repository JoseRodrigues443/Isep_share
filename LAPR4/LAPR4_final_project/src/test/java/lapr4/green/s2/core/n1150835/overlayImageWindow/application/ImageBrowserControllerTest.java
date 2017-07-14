/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150835.overlayImageWindow.application;

import csheets.core.Address;
import csheets.core.CellImpl;
import csheets.core.Workbook;
import lapr4.blue.s1.core.n1150630.insertImage.InsertImageCell;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rui Braga
 */
public class ImageBrowserControllerTest {

    public ImageBrowserControllerTest() {
    }

    /**
     * Test of imageList method, of class ShowImageBrowserController.
     */
    @Test
    public void testImageList() {
        System.out.println("imageList");
        Workbook wb = new Workbook();
        wb.addSpreadsheet();
        InsertImageCell imageCell = new InsertImageCell(new CellImpl(wb.getSpreadsheet(0), new Address(0, 0)));
        ImageBrowserController instance = new ImageBrowserController(imageCell);

        // tests if the cell has no image
        System.out.println("no image test");
        assertTrue(!imageCell.hasImage());

        // tests empty list
        int expResult = 0;
        int result = instance.getImageList().size();
        System.out.println("empty image list test");
        assertEquals(expResult, result);

        // tests if the cell has image
        imageCell.addImage("image1");
        expResult = 1;
        result = instance.getImageList().size();
        System.out.println("one image test");
        assertEquals(expResult, result);

        // tests the path of the image
        String strExpResult = "image1";
        String strResult = instance.getImageList().get(0).getImagePath();
        System.out.println("image path test");
        assertEquals(strExpResult, strResult);

    }

}
