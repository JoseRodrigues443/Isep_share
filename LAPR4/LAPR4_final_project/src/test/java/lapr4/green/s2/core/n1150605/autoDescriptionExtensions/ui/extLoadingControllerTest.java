/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150605.autoDescriptionExtensions.ui;

import csheets.CleanSheets;
import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import lapr4.green.s2.core.n1150605.autoDescriptionExtensions.extLoadingExtension;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class extLoadingControllerTest {

    public extLoadingControllerTest() {
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
     * Test of getExtensions method, of class extLoadingController.
     */
    @Ignore
    @Test
    public void testGetExtensions() {
        System.out.println("getExtensions");
        CleanSheets c = new CleanSheets();
        extLoadingController instance = new extLoadingController(new UIController(c));
        Extension[] expResult = ExtensionManager.getInstance().getExtensions();
        Extension[] result = instance.getExtensions();

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of unloadExtension method, of class extLoadingController.
     */
    @Ignore
    @Test
    public void testUnloadExtension() {
        System.out.println("unloadExtension");
        String name = "Load Extensions";
        String version = "1.0";
        int index = 0;
        CleanSheets c = new CleanSheets();
        extLoadingController instance = new extLoadingController(new UIController(c));;
        instance.unloadExtension(name, version, index);

        boolean expResult = true;
        boolean result = true;

        for (Extension e : instance.getExtensions()) {
            if (e.getName().equals(name) && e.getVersion().equals(version)) {
                result = false;
            }
        }

        assertEquals(expResult, result);
    }

    /**
     * Test of loadExtension method, of class extLoadingController.
     */
    @Ignore
    @Test
    public void testLoadExtension() {
        System.out.println("loadExtension");
        String s = extLoadingExtension.class.getName();
        int index = 0;

        String name = "Load Extensions";
        String version = "1.0";
        CleanSheets c = new CleanSheets();
        extLoadingController instance = new extLoadingController(new UIController(c));
        instance.unloadExtension(name, version, index);
        instance.loadExtension(s, index);

        boolean expResult = true;
        boolean result = false;

        for (Extension e : instance.getExtensions()) {
            if (e.getName().equals(name) && e.getVersion().equals(version)) {
                result = true;
            }
        }

        assertEquals(expResult, result);
    }

    /**
     * Test of getExtensionName method, of class extLoadingController.
     */
    @Ignore
    @Test
    public void testGetExtensionName() {
        System.out.println("getExtensionName");
        CleanSheets c = new CleanSheets();
        extLoadingController instance = new extLoadingController(new UIController(c));
        Extension e = instance.getExtensions()[0];
        String expResult = "Agenda";
        String result = instance.getExtensionName(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of getExtensionDescription method, of class extLoadingController.
     */
    @Ignore
    @Test
    public void testGetExtensionDescription() {
        System.out.println("getExtensionDescription");
        CleanSheets c = new CleanSheets();
        extLoadingController instance = new extLoadingController(new UIController(c));;
        Extension e = instance.getExtensions()[0];
        String expResult = "Description of Agenda";
        String result = instance.getExtensionDescription(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of getExtensionVersions method, of class extLoadingController.
     */
    @Ignore
    @Test
    public void testGetExtensionVersions() {
        System.out.println("getExtensionVersions");
        String extName = "Load Extensions";
        CleanSheets c = new CleanSheets();
        extLoadingController instance = new extLoadingController(new UIController(c));;
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("1.0");

        ArrayList<String> result = new ArrayList<>();

        for (Extension r : instance.getExtensionVersions(extName)) {
            result.add(r.getVersion());
        }

        assertEquals(expResult, result);
    }

}
