/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150767.extensionNavigator;

import csheets.CleanSheets;
import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Catarina Sousa
 */
public class ExtensionNavigatorControllerTest {

    ExtensionNavigatorController instance;
    UIController uictrl;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        CleanSheets app = new CleanSheets();
        uictrl = new UIController(app);
        instance = new ExtensionNavigatorController(uictrl);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getEnabledExtensions method, of class
     * ExtensionNavigatorController.
     */
    @Ignore
    @Test
    public void testGetEnabledExtensions() {
        System.out.println("getEnabledExtensions");
        Map<String, ArrayList<String>> expResult = new LinkedHashMap<>();
        Integer num = null;
        for (Extension extension : ExtensionManager.getInstance().getExtensions()) {
            if (uictrl.getExtensions() == null) {
                break;
            }
            for (int i = 0; i < uictrl.getExtensions().length; i++) {
                if (uictrl.getExtensions()[i].getExtension().getName().equals(extension.getName())) {
                    //if (uictrl.getExtensions()[i].getExtension().equals(extension)) {
                    num = i;
                }
            }
            if (num == null) {
                throw new IllegalArgumentException();
            }
            /*
            NOME DA EXTENSÃO
            
            System.out.println("Extension: " + uictrl.getExtensions()[num].getExtension().getName());
            
             */
            String s = uictrl.getExtensions()[num].getExtension().getName();

            ArrayList<String> array = new ArrayList<String>();
            if (uictrl.getExtensions()[num].getCellDecorator() != null) {
                /*
                CELL DECORATOR
                System.out.println("Cell Decorator");
                 */
                array.add("Cell Decorator");
            }

            if (uictrl.getExtensions()[num].getTableDecorator() != null) {
                /*
                TABLE DECORATOR
                System.out.println("Table Decorator");
                 */
                array.add("Table Decorator");
            }
            if (uictrl.getExtensions()[num].getToolBar() != null) {
                /*
                TOLLBAR
                System.out.println("Toolbar "+ uictrl.getExtensions()[num].getToolBar().getName());
                 */
                array.add("Toolbar " + uictrl.getExtensions()[num].getToolBar().getName());
            }
            if (uictrl.getExtensions()[num].getSideBar() != null) {
                /*
                SIDEBAR
                System.out.println("Sidebar "+ uictrl.getExtensions()[num].getSideBar().getName());
                 */
                array.add("Sidebar " + uictrl.getExtensions()[num].getSideBar().getName());
            }
            if (uictrl.getExtensions()[num].getMenu() != null) {
                /*
                MENU
                System.out.println("Menu "+ uictrl.getExtensions()[num].getMenu().getName());
                 */
                array.add("Menu " + uictrl.getExtensions()[num].getMenu().getName());
            }

            expResult.put(s, array);
        }
        Map<String, ArrayList<String>> result = instance.getEnabledExtensions();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDisabledExtensions method, of class
     * ExtensionNavigatorController.
     */
    @Ignore
    @Test
    public void testGetDisabledExtensions() {
        System.out.println("getDisabledExtensions");
        int num = 0;
        ListEnabledDisabledExtensions.getInstance().addDisabledExtension(uictrl.getExtensions()[num]);
        Map<String, ArrayList<String>> expResult = new LinkedHashMap<String, ArrayList<String>>();
        ArrayList<String> array = new ArrayList<String>();
        if (uictrl.getExtensions()[num].getCellDecorator() != null) {
            /*
                CELL DECORATOR
                System.out.println("Cell Decorator");
             */
            array.add("Cell Decorator");
        }

        if (uictrl.getExtensions()[num].getTableDecorator() != null) {
            /*
                TABLE DECORATOR
                System.out.println("Table Decorator");
             */
            array.add("Table Decorator");
        }
        if (uictrl.getExtensions()[num].getToolBar() != null) {
            /*
                TOLLBAR
                System.out.println("Toolbar "+ uictrl.getExtensions()[num].getToolBar().getName());
             */
            array.add("Toolbar " + uictrl.getExtensions()[num].getToolBar().getName());
        }
        if (uictrl.getExtensions()[num].getSideBar() != null) {
            /*
                SIDEBAR
                System.out.println("Sidebar "+ uictrl.getExtensions()[num].getSideBar().getName());
             */
            array.add("Sidebar " + uictrl.getExtensions()[num].getSideBar().getName());
        }
        if (uictrl.getExtensions()[num].getMenu() != null) {
            /*
                MENU
                System.out.println("Menu "+ uictrl.getExtensions()[num].getMenu().getName());
             */
            array.add("Menu " + uictrl.getExtensions()[num].getMenu().getName());
        }
        expResult.put(uictrl.getExtensions()[0].getExtension().getName(), array);
        Map<String, ArrayList<String>> result = instance.getDisabledExtensions();
        assertEquals(expResult, result);
    }

    /**
     * Test of runExtension method, of class ExtensionNavigatorController.
     */
    @Ignore
    @Test
    public void testRunExtension() {
        System.out.println("runExtension");
        String extension = "";
        UIExtension expResult = null;
//        UIExtension result = instance.runExtension(extension);
//        assertEquals(expResult, result);
    }
    
}
