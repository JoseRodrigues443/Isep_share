///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package lapr4.blue.s1.core.n1140525.sortColumn.application;
//
//import csheets.CleanSheets;
//import csheets.core.Address;
//import csheets.core.Cell;
//import csheets.core.Spreadsheet;
//import csheets.core.Workbook;
//import csheets.core.formula.compiler.FormulaCompilationException;
//import csheets.ui.ctrl.UIController;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.Ignore;
//
///**
// *
// * @author MariaJoão
// */
//public class SortColumnControllerTest {
//    
//    public SortColumnControllerTest() {
//    }
//    
//
//    /**
//     * Test of ascendingSort method, of class SortColumnController.
//     */
//    @Test
//    public void testAscendingSort() throws Exception {
//        CleanSheets c= new CleanSheets();
//        c.create();
//        UIController u= new UIController(c);
//        Workbook w= new Workbook();
//        w.addSpreadsheet();
//        u.setActiveWorkbook(w);
//        u.setActiveSpreadsheet(w.getSpreadsheet(0));        
//        Spreadsheet s=u.getActiveSpreadsheet();
//        Address a=  new Address(0,0);
//        Cell ce= s.getCell(a);
//        s.getCell(a).setContent("1");
//        s.getCell(new Address(0, 1)).setContent("3");
//        s.getCell(new Address(0, 2)).setContent("2");
//        u.setActiveCell(ce);
//        SortColumnController instance = new SortColumnController(u);
//        String[]exp = {"1","2","3"}; 
//        instance.indexColumn();
//        instance.activeSpreadsheet();
//        instance.notSortedColumn();
//        instance.ascendingSort();
//        
//        Assert.assertArrayEquals(exp, instance.getSortedColumn());
//    }
//
//    /**
//     * Test of descendingSort method, of class SortColumnController.
//     */
//    @Test
//    public void testDescendingSort() throws Exception {
//        CleanSheets c= new CleanSheets();
//        c.create();
//        UIController u= new UIController(c);
//        Workbook w= new Workbook();
//        w.addSpreadsheet();
//        u.setActiveWorkbook(w);
//        u.setActiveSpreadsheet(w.getSpreadsheet(0));        
//        Spreadsheet s=u.getActiveSpreadsheet();
//        Address a=  new Address(0,0);
//        Cell ce= s.getCell(a);
//        s.getCell(a).setContent("1");
//        s.getCell(new Address(0, 1)).setContent("3");
//        s.getCell(new Address(0, 2)).setContent("2");
//        u.setActiveCell(ce);
//        SortColumnController instance = new SortColumnController(u);
//        String[]exp = {"3","2","1"}; 
//        instance.indexColumn();
//        instance.activeSpreadsheet();
//        instance.notSortedColumn();
//        instance.descendingSort();
//        
//        Assert.assertArrayEquals(exp, instance.getSortedColumn());
//    }
//
//    /**
//     * Test of indexColumn method, of class SortColumnController.
//     */
//    @Test
//    public void testIndexColumn() throws FormulaCompilationException {
//        CleanSheets c= new CleanSheets();
//        c.create();
//        UIController u= new UIController(c);
//        Workbook w= new Workbook();
//        w.addSpreadsheet();
//        u.setActiveWorkbook(w);
//        u.setActiveSpreadsheet(w.getSpreadsheet(0));        
//        Spreadsheet s=u.getActiveSpreadsheet();
//        Address a=  new Address(1,3);
//        Cell ce= s.getCell(a);
//        s.getCell(a).setContent("1");
//        u.setActiveCell(ce);
//        SortColumnController instance = new SortColumnController(u);
//
//        int exResult=1;
//        instance.indexColumn();
//        int result= instance.getIndexColumn();
//        
//        Assert.assertEquals(exResult, result);
//
//        
//    }
//
//    /**
//     * Test of activeSpreadsheet method, of class SortColumnController.
//     */
//    @Test
//    public void testActiveSpreadsheet() {
//        CleanSheets c= new CleanSheets();
//        c.create();
//        UIController u= new UIController(c);
//        Workbook w= new Workbook();
//        w.addSpreadsheet();
//        u.setActiveWorkbook(w);
//        u.setActiveSpreadsheet(w.getSpreadsheet(0));        
//        SortColumnController instance = new SortColumnController(u);
//
//        Spreadsheet exp=u.getActiveSpreadsheet();
//        instance.activeSpreadsheet();
//        Spreadsheet result= instance.getSheet();
//
//        Assert.assertEquals(exp, result);
//
//    }
//
//    /**
//     * Test of notSortedColumn method, of class SortColumnController.
//     */
//    @Test
//    public void testNotSortedColumn() throws FormulaCompilationException {
//        CleanSheets c= new CleanSheets();
//        c.create();
//        UIController u= new UIController(c);
//        Workbook w= new Workbook();
//        w.addSpreadsheet();
//        u.setActiveWorkbook(w);
//        u.setActiveSpreadsheet(w.getSpreadsheet(0));        
//        Spreadsheet s=u.getActiveSpreadsheet();
//        Address a=  new Address(0,0);
//        Cell ce= s.getCell(a);
//        s.getCell(a).setContent("1");
//        s.getCell(new Address(0, 1)).setContent("3");
//        s.getCell(new Address(0, 2)).setContent("2");
//        u.setActiveCell(ce);
//        SortColumnController instance = new SortColumnController(u);
//
//        String[]exp = {"1","3","2"}; 
//
//        instance.indexColumn();
//        instance.activeSpreadsheet();
//        instance.notSortedColumn();
//        Cell[]resultCell=instance.getNotSortedColumn();
//        String[]result= new String[3];
//        int i=0;
//        for (Cell cell : resultCell) {
//            result[i]=cell.getContent();
//            i++;        
//        }
//        Assert.assertArrayEquals(exp, result);
//    }
//
//    /**
//     * Test of sortSpreadsheet method, of class SortColumnController.
//     */
//    @Ignore
//    @Test
//    public void testSortSpreadsheet() throws Exception {
//        CleanSheets c= new CleanSheets();
//        c.create();
//        UIController u= new UIController(c);
//        Workbook w= new Workbook();
//        w.addSpreadsheet();
//        u.setActiveWorkbook(w);
//        u.setActiveSpreadsheet(w.getSpreadsheet(0));        
//        Spreadsheet s=u.getActiveSpreadsheet();
//        Address a=  new Address(0,0);
//        Address a1= new Address(0,2); 
//        Cell ce= s.getCell(a);
//        s.getCell(a).setContent("1");
//        s.getCell(new Address(0, 1)).setContent("3");
//        s.getCell(new Address(0, 2)).setContent("2");
//        u.setActiveCell(ce);
//        SortColumnController instance = new SortColumnController(u);
//        instance.indexColumn();
//        instance.activeSpreadsheet();
//        instance.notSortedColumn();
//        instance.ascendingSort();
//        instance.sortSpreadsheet();
//        
//        CleanSheets c2= new CleanSheets();
//        c.create();
//        UIController u2= new UIController(c2);
//        Workbook w2= new Workbook();
//        w2.addSpreadsheet();
//        u2.setActiveWorkbook(w2);
//        u2.setActiveSpreadsheet(w2.getSpreadsheet(0));        
//        Spreadsheet s2=u2.getActiveSpreadsheet();
//        Address a2=  new Address(0,0);
//        Address a3=  new Address(0,2);
//        Cell ce2= s2.getCell(a2);
//        s2.getCell(a).setContent("1");
//        s2.getCell(new Address(0, 1)).setContent("2");
//        s2.getCell(new Address(0, 2)).setContent("3");
//        u2.setActiveCell(ce2);
//        SortColumnController instance2 = new SortColumnController(u2);
//        instance2.indexColumn();
//        instance2.activeSpreadsheet();
//        instance2.notSortedColumn();
//        boolean ans=true;
//        int i=0;
//        for (Cell cell : s.getCells(a, a1)) {
//            if(!cell.getContent().equals(s2.getCell(new Address(0,i)).getContent())){
//                ans=false;
//            }
//            i++;
//        }
//
//        assertTrue(ans);
//        
//    }
//
//       
//}
