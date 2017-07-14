///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package lapr4.blue.s1.core.n1140525.sortColumn.domain;
//
//import csheets.CleanSheets;
//import csheets.core.Address;
//import csheets.core.Cell;
//import csheets.core.Spreadsheet;
//import csheets.core.Workbook;
//import csheets.ui.ctrl.UIController;
//import lapr4.blue.s1.core.n1140525.sortColumn.application.SortColumnController;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author MariaJoão
// */
//public class SortTest {
//    
//   
//    /**
//     * Test of sortSpreadsheet method, of class Sort.
//     */
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
//        Sort i= new Sort();
//        i.sortSpreadsheet(s,0,instance.getSortedColumn());
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
//        int i2=0;
//        for (Cell cell : s.getCells(a, a1)) {
//            if(!cell.getContent().equals(s2.getCell(new Address(0,i2)).getContent())){
//                ans=false;
//            }
//            i2++;
//        }
//
//        assertTrue(ans);
//    }
//
//    /**
//     * Test of ascendingSort method, of class Sort.
//     */
//    @Test
//    public void testAscendingSort() throws Exception {
//        System.out.println("ascendingSort");
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
//        
//        
//        Sort instanc = new Sort();
//        String[] expResult = {"3","2","1"};
//        String[] result = instanc.ascendingSort(instance.getNotSortedColumn());
//        assertArrayEquals(exp,result);
//    }
//
//    /**
//     * Test of descendingSort method, of class Sort.
//     */
//    @Test
//    public void testDescendingSort() throws Exception {
//        System.out.println("descendingSort");
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
//        
//        
//        Sort instanc = new Sort();
//        String[] expResult = {"3","2","1"};
//        String[] result = instanc.descendingSort(instance.getNotSortedColumn());
//        assertArrayEquals(exp,result);
//    }
//
//    /**
//     * Test of isNumeric method, of class Sort.
//     */
//    @Test
//    public void testIsNumeric() {
//        System.out.println("isNumeric");
//        String s = "a";
//        Sort instance = new Sort();
//        boolean expResult = false;
//        boolean result = instance.isNumeric(s);
//        assertEquals(expResult, result);
//    }
//    
//}
