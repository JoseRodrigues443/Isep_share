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
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * A Unit Test class to test ImportTxt.
 *
 * @see ImportTxt
 * @author 1150834
 */
public class ImportTxtTest {

    private ImportTxt in;
    private UIController ui;
    private Cell begin;
    private Cell end;

    public ImportTxtTest() {
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
        begin= sheet.getCell(0, 0);
        end = sheet.getCell(1, 0);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test is file name is not null.
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testfileNameCannotBeNull() {
        System.out.println("intput file name cannot not be null");

        in = new ImportTxt(ui,null,begin, end, true);
    }

    /**
     * Test is file name is not empty.
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testfileNameCannotBeEmpty() {
        System.out.println("intput file name cannot be empty");

        in = new ImportTxt(ui,"",begin, end, true);
    }

    /**
     * Test is file name is not whitespace.
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testfileNameCannotBeWhiteSpace() {
        System.out.println("intput file name cannot be whitespace");

        in = new ImportTxt(ui," ",begin, end, true);
    }

    /**
     * Test that given file has .txt extension
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testInputFileHasToBeTxt() {
        System.out.println("input file has to be .txt");

        in = new ImportTxt(ui,"file.xml",begin, end, true);
    }
}
