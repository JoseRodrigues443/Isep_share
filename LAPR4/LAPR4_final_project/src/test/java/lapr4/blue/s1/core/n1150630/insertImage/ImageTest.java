/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150630.insertImage;

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
public class ImageTest {

    public ImageTest() {
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
     * Test of getImagePath method, of class CellImage.
     */
    @Test
    public void testGetImagePath() {
        System.out.println("getImagePath");
        String path = "Test";
        CellImage instance = new CellImage(path);
        String expResult = path;
        String result = instance.getImagePath();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class CellImage.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String path = "Test";
        CellImage instance = new CellImage(path);
        String expResult = String.format("The image's path is %s.\n", path);
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class CellImage.
     */
    @Test
    public void testEquals() {
        System.out.println("equals showing that Images are diffent ");
        String path = "Test";
        String path2 = "Test/Fail";
        Object obj = new CellImage(path2);
        CellImage instance = new CellImage(path);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class CellImage.
     */
    @Test
    public void testEquals2() {
        System.out.println("equals showing that different obj are equal");
        String path = "Test";
        String path2 = "Test";
        Object obj = new CellImage(path);
        CellImage instance = new CellImage(path2);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

}
