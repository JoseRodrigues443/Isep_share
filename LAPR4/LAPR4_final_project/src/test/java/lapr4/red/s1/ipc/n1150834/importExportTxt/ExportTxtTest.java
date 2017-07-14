package lapr4.red.s1.ipc.n1150834.importExportTxt;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.ui.ctrl.UIController;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * A Unit Test class to test ExportTxt.
 *
 * @see ExportTxt
 * @author 1150834
 */
public class ExportTxtTest {

    private ExportTxt out;
    private UIController ui;
    private Cell begin;
    private Cell end;

    public ExportTxtTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        CleanSheets app = new CleanSheets();
        ui = new UIController(app);
        Workbook book = new Workbook(1);
        Spreadsheet sheet = book.getSpreadsheet(0);
        begin = sheet.getCell(0, 0);
        end = sheet.getCell(1, 0);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test that file name is not null.
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testfileNameCannotBeNull() {
        System.out.println("output file name cannot not be null");

        out = new ExportTxt(ui, null, begin, end, ';', true);
    }

    /**
     * Test that file name is not empty.
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testfileNameCannotBeEmpty() {
        System.out.println("output file name cannot be empty");

        out = new ExportTxt(ui, "", begin, end, ';', true);
    }

    /**
     * Test that file name is not whitespace.
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testfileNameCannotBeWhiteSpace() {
        System.out.println("output file name cannot be whitespace");

        out = new ExportTxt(ui, " ", begin, end, ';', true);
    }

}
