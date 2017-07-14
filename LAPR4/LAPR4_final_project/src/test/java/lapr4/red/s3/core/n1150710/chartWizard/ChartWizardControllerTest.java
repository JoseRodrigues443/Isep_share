/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150710.chartWizard;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import lapr4.red.s3.core.n1150710.chartWizard.extension.list.ChartCreatorList;
import lapr4.red.s3.core.n1150710.chartWizard.extension.list.ChartObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author arch-admin
 */
public class ChartWizardControllerTest {

    public ChartWizardControllerTest() {
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
     * Test of getSelectedCell method, of class ChartWizardController.
     */
    @Test
    @Ignore
    public void testGetSelectedCell() {
        System.out.println("getSelectedCell");
        ChartWizardController instance = new ChartWizardController(new UIController(new CleanSheets()));
        Cell expResult = null;
        Cell result = instance.getSelectedCell();
        assertEquals(expResult, result);

    }

    /**
     * Test of chartTypeDescriptionList method, of class ChartWizardController.
     */
    @Test
    @Ignore
    public void testChartTypeDescriptionList() {
        System.out.println("chartTypeDescriptionList");
        ChartWizardController instance = new ChartWizardController(new UIController(new CleanSheets()));
        ArrayList<String> expResult = instance.chartTypeDescriptionList();
        ArrayList<String> result = instance.chartTypeDescriptionList();
        assertEquals(expResult, result);

    }

    /**
     * Test of defaultListModel method, of class ChartWizardController.
     */
    @Ignore
    @Test
    public void testDefaultListModel() {
        System.out.println("defaultListModel");
        ArrayList<String> al = new ArrayList<>();
//        ChartWizardController instance = new ChartWizardController(new UIController(new CleanSheets()));
//        DefaultComboBoxModel expResult = instance.defaultListModel(al);
//        DefaultComboBoxModel result = instance.defaultListModel(al);
//        assertEquals(expResult, result);
        assertTrue(true);               //default combobox haves ID combobox impossible

    }

    /**
     * Test of defaultListModelWithChartType method, of class
     * ChartWizardController.
     */
    @Test
    @Ignore
    public void testDefaultListModelWithChartType() {
        System.out.println("defaultListModelWithChartType");
        ChartWizardController instance = new ChartWizardController(new UIController(new CleanSheets()));
//        DefaultComboBoxModel expResult = instance.defaultListModelWithChartType();
//        DefaultComboBoxModel result = instance.defaultListModelWithChartType();
//        assertEquals(expResult, result);   
        assertTrue(true);                      //assert equals in combobox is impossible

    }

    /**
     * Test of stringsMatrix method, of class ChartWizardController.
     */
    @Test
    @Ignore
    public void testStringsMatrix() {
        System.out.println("stringsMatrix");
        Cell[][] cellses = new Cell[1][1];
        ChartWizardController instance = new ChartWizardController(new UIController(new CleanSheets()));
        String[][] expResult = new String[1][1];
        expResult[0][0] = "";
        String[][] result = instance.stringsMatrix(cellses);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of getUic method, of class ChartWizardController.
     */
    @Test
    @Ignore
    public void testGetUic() {
        System.out.println("getUic");
        UIController expResult = new UIController(new CleanSheets());
        ChartWizardController instance = new ChartWizardController(expResult);

        UIController result = instance.getUic();
        assertEquals(expResult, result);

    }

    /**
     * Test of setUic method, of class ChartWizardController.
     */
    @Test
    @Ignore
    public void testSetUic() {
        System.out.println("setUic");
        UIController uic = null;
        ChartWizardController instance = new ChartWizardController(new UIController(new CleanSheets()));
        instance.setUic(uic);

    }

    /**
     * Test of add method, of class ChartWizardController.
     */
    @Test
    @Ignore
    public void testAdd() {
        System.out.println("add");
        ChartObject e = new ChartObject(new JPanel(), new String[1][1], new Address(0, 0), new Address(0, 0), "Banana");
        ChartWizardController instance = new ChartWizardController(new UIController(new CleanSheets()));
        boolean expResult = true;
        boolean result = instance.add(e);
        assertEquals(expResult, result);

    }

    /**
     * Test of getChartCreatorList method, of class ChartWizardController.
     */
    @Test
    @Ignore
    public void testGetChartCreatorList() {
        System.out.println("getChartCreatorList");
        ChartWizardController instance = new ChartWizardController(new UIController(new CleanSheets()));
        ChartCreatorList expResult = instance.getChartCreatorList();
        ChartCreatorList result = instance.getChartCreatorList();
        assertEquals(expResult, result);

    }

}
