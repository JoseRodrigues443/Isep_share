/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1150595.tablesAndFilters.controller;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.List;
import lapr4.blue.s3.lang.n1150595.tablesAndFilters.TablesAndFilters;
import lapr4.blue.s3.lang.n1150595.tablesAndFilters.ui.TablesAndFiltersSideBar;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
public class TablesAndFiltersControllerTest {

    TablesAndFiltersController instance = new TablesAndFiltersController();

    /**
     * Test of updateFunctions method, of class TablesAndFiltersController.
     */
    @Test
    public void testUpdateFunctions() {
        System.out.println("updateFunctions");
        List<String> strs = new ArrayList<>();
        strs.add("AND");
        strs.add("NOT");
        strs.add("OR");
        instance.updateFunctions();
        assertEquals(strs.get(0), instance.functions().get(0).getIdentifier());
        assertEquals(strs.get(1), instance.functions().get(1).getIdentifier());
        assertEquals(strs.get(2), instance.functions().get(2).getIdentifier());
    }

    /**
     * Test of updateContent method, of class TablesAndFiltersController.
     */
    @Test
    public void testUpdateContent() {
        System.out.println("updateContent");
        CleanSheets cleansheets = new CleanSheets();
        UIController uiController = new UIController(cleansheets);
        String name = "test1";
        Cell[][] cells = null;
        TablesAndFilters t = new TablesAndFilters("test2");
        instance.setSideBar(new TablesAndFiltersSideBar(uiController));
        instance.setActualTable(t);
        instance.updateContent(name, cells);
        assertEquals(name, t.name());
    }

    /**
     * Test of selectFunction method, of class TablesAndFiltersController.
     */
    @Test
    public void testSelectFunction() {
        System.out.println("selectFunction");
        int index = 0;
        instance.updateFunctions();
        instance.selectFunction(index);
        assertEquals(instance.baseFunction(), "AND");
        assertEquals(instance.syntax(), "=AND(rowColumnNumber binaryOperator rowColumnNumber, rowColumnNumber binaryOperator rowColumnNumber)");
    }

    /**
     * Test of tableByName method, of class TablesAndFiltersController.
     */
    @Test
    public void testTableByName() {
        System.out.println("tableByName");
        String name = "test3";
        TablesAndFilters expResult = new TablesAndFilters(name);
        instance.tablesAndFilters().add(expResult);
        TablesAndFilters result = instance.tableByName(name);
        assertEquals(expResult, result);
    }

}
