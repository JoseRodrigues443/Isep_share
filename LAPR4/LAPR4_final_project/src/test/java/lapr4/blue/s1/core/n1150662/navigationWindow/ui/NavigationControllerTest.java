///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package lapr4.blue.s1.core.n1150662.navigationWindow.ui;
//
//import csheets.CleanSheets;
//import csheets.core.Cell;
//import csheets.core.Spreadsheet;
//import csheets.core.Value;
//import csheets.core.Workbook;
//import csheets.core.formula.Formula;
//import csheets.core.formula.compiler.FormulaCompilationException;
//import csheets.ui.ctrl.UIController;
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import lapr4.blue.s1.core.n1150662.navigationWindow.NavigationComment;
//import lapr4.white.s1.core.n1234567.comments.CommentableCell;
//import lapr4.white.s1.core.n1234567.comments.CommentsExtension;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author bruno
// */
//public class NavigationControllerTest {
//    
//    public NavigationControllerTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getCommentsFromCells method, of class NavigationController.
//     */
//    @Test
//    public void testGetCommentsFromCells() throws FormulaCompilationException {
//        System.out.println("getCommentsFromCells");
//		CleanSheets cs = new CleanSheets();
//		cs.create();
//		UIController uic = new UIController(cs);
//
//		Workbook wb = cs.getWorkbooks()[0];
//		Spreadsheet sp = wb.getSpreadsheet(0);
//		Cell cell = sp.getCell(0, 0);
//		sp.getCell(10, 10).setContent("bananas");
//		uic.setActiveWorkbook(wb);
//		uic.setActiveSpreadsheet(sp);
//		uic.setActiveCell(cell);
//		cell.setContent("oi");
//
//		CommentableCell activeCell = (CommentableCell) cell.
//			getExtension(CommentsExtension.NAME);
//
//		activeCell.setUserComment("no comments");
//
//		sp.getCell(cell.getAddress()).copyFrom(activeCell);
//
//		NavigationController instance = new NavigationController(uic,new NavigationPanel(uic));
//
//		ArrayList<NavigationComment> tmp = new ArrayList<NavigationComment>();
//		tmp.add(new NavigationComment("A1", "no comments"));
//
//		Map<String, ArrayList<NavigationComment>> expResult = new LinkedHashMap<String, ArrayList<NavigationComment>>();
//		expResult.put("Sheet  1", tmp);
//		expResult.put("Sheet  2", new ArrayList<NavigationComment>());
//		expResult.put("Sheet  3", new ArrayList<NavigationComment>());
//
//		Map<String, ArrayList<NavigationComment>> result = instance.
//			getCommentsFromCells();
//
//		assertTrue(expResult.equals(result) == true);
//    }
//
//  
//
//
//    
//}
