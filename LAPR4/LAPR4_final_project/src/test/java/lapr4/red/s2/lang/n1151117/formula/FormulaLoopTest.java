/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1151117.formula;

import csheets.CleanSheets;
import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author alexandrebraganca
 * @author Barros
 */
public class FormulaLoopTest {

    CleanSheets app;

    @Before
    public void setUp() {

        // Try to create the CS application object
        app = new CleanSheets();

        // This will create a workbook with 3 sheets
        app.create();

    }

    @Test
    public void testBasicExpression() throws FormulaCompilationException {
        String content = "={ 1+2; 2+4; 5-4 }";
        Cell cell = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));

        try {
            // #1 test
            content = "=1+2";

            cell.setContent(content);

            assertTrue(cell.getValue().toDouble() == 3.0);
        } catch (IllegalValueTypeException ex) {
            Logger.getLogger(FormulaLoopTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test Blocks<br/>
     * "={ 1+2; sum(a1:a10); b3+4 }"
     *
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Ignore
    @Test
    public void testFormulaBlocks() throws FormulaCompilationException {
        String content = "={ 1+2; 2+4; 5-4 }";
        Cell cell = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));

        try {
            // #1 test
            content = "=1+2";
            cell.setContent(content);
            assertTrue(cell.getValue().toDouble() == 3.0);

            // #2 test
            content = "={ 1+2; 2+4; 5-2 }";
            cell.setContent(content);
            assertTrue(cell.getValue().toDouble() == 3.0);

            // #3 test
            /* EDITED BY: José Barros : 1151117 */
            content = "={C1:=1+2; B1:=sum(A1:A10);B3+4}";
            ArrayList<Cell> cellList = new ArrayList<>(); // list of cells from A1 to A10
            for(int i = 0; i < 10; i++){
                Cell tmp = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, i));
                tmp.setContent(""+i);
                cellList.add(tmp);
            }
            // Cells c1, b1 and b3 must be initialized so b4 can execute the
            // formula and avoid null pointer exceptions
            Cell cellB3 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(1, 2));
            cellB3.setContent("2");
            Cell cellB1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(1, 0));
            cellB1.setContent("0");
            Cell cellC1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(2, 0));
            cellC1.setContent("0");
            Cell cellB4 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(1, 3));
            cellB4.setContent(content);

            assertTrue(cellB4.getValue().toDouble() == 6.0);
            assertTrue(cellB1.getValue().toDouble() == 45.0);
            assertTrue(cellC1.getValue().toDouble() == 3.0);
        } catch (IllegalValueTypeException ex) {
            Logger.getLogger(FormulaLoopTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test Assignment operator<br/>
     * "={ 1+2; sum(a1:a10); b3+4 }"
     *
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    @Ignore
    public void testAssignmentOperator() throws FormulaCompilationException, IllegalValueTypeException {
        String content = "=(A2:=1+2)";
        Cell cell = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));

        // #1 test
        cell.setContent(content);
        assertTrue(cell.getValue().toDouble() == 3.0);
        Cell cell2 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 1));
        assertTrue(cell2.getValue().toDouble() == 3.0);

        // #2 test
        //content="=(A2:=\"abc\" & \"d\")";
        // IMPORTANT: A assignment inside the formula to the same cell as the target of 
        // the formula will result in a circular reference!!!
        content = "=(A3:=\"abc\" & \"d\")";
        cell.setContent(content);
        assertTrue(cell.getValue().toText().compareTo("abcd") == 0);
        cell2 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 2));
        assertTrue(cell2.getValue().toText().compareTo("abcd") == 0);

        // #3 test
        /* EDITED BY: José Barros : 1151117 */
        content = "=C3:=C3+4";
        Cell cellC3 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(2, 2));
        cellC3.setContent("10");
        Cell cellC4 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(2, 3));
        cellC4.setContent(content);
        assertTrue(cellC4.getValue().toDouble() == 14.0);
        assertTrue(cellC3.getValue().toDouble() == 14.0);
    }

    /**
     * Test For Loop function<br/>
     * '=For{A1:=1;A1<10;A2:=A2+A1; A1:=A1+1}'
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     * @throws csheets.core.IllegalValueTypeException
     */
    @Test
    @Ignore
    public void testForLoop() throws FormulaCompilationException, IllegalValueTypeException {
        // Cell with content
        Cell cellA1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 0));
        cellA1.setContent("0");
        Cell cellA2 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(0, 1));
        cellA2.setContent("0");

        // ForLoop execution
        // The A1 cell will contain the "counter" so the result will be 10
        // The A2 cell will contain the result of the for loop execution
        // The B1 cell will have the same result as A1 cell since is the cell
        // with the for loop command and will have the same result as the last operation
        Cell cellB1 = app.getWorkbooks()[0].getSpreadsheet(0).getCell(new Address(1, 1));
        cellB1.setContent("=For{A1:=1;A1<10;A2:=A2+A1; A1:=A1+1}");

        assertTrue(cellA2.getValue().toDouble() == 45.0);
        assertTrue(cellA1.getValue().toDouble() == 10.0);
        assertTrue(cellB1.getValue().toDouble() == 10.0);

    }

    @After
    public void cleanUp() {

    }
}
