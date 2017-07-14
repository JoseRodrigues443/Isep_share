/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.application;

import csheets.CleanSheets;
import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Filipe
 */
public class EnableDisableExtensionControllerTest {

    public EnableDisableExtensionControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getExtensions method, of class EnableDisableExtensionController.
     */
    @Test
    @Ignore
    public void testGetExtensions() {
        System.out.println("getExtensions");
        CleanSheets app = new CleanSheets();
        UIController uiCtrl = new UIController(app);
        EnableDisableExtensionController instance = new EnableDisableExtensionController(uiCtrl);
        List<String> temp = new ArrayList<>();
        for (Extension e : ExtensionManager.getInstance().getExtensions()) {
            temp.add(e.getName());
        }
        Iterable<String> expResult = temp;
        Iterable<String> result = instance.getExtensions();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUIExtension method, of class EnableDisableExtensionController.
     */
    @Test
    @Ignore
    public void testSetUIExtension() {
        System.out.println("setUIExtension");
        String extName = "Chat";
        CleanSheets app = new CleanSheets();
        UIController uiCtrl = new UIController(app);
        EnableDisableExtensionController instance = new EnableDisableExtensionController(uiCtrl);
        instance.setUIExtension(extName);
    }

    /**
     * Test of changeExtensionState method, of class
     * EnableDisableExtensionController.
     */
    @Ignore
    @Test
    public void testChangeExtensionState() {
        System.out.println("changeExtensionState");
        boolean option = true;
        CleanSheets app = new CleanSheets();
        UIController uiCtrl = new UIController(app);
        EnableDisableExtensionController instance = new EnableDisableExtensionController(uiCtrl);
        instance.setUIExtension("Chat");
        boolean expResult = true;
        boolean result = instance.changeExtensionState(option);
        assertEquals(expResult, result);
    }

}
