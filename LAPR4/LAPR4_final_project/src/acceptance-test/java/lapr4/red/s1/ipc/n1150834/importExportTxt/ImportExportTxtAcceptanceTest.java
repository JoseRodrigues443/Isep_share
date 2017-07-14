package lapr4.red.s1.ipc.n1150834.importExportTxt;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import lapr4.red.s1.ipc.n1150834.importExportTxt.ui.ExportController;
import lapr4.red.s1.ipc.n1150834.importExportTxt.ui.ImportController;
import org.junit.*;

/**
 *
 * @author 1150834
 */
public class ImportExportTxtAcceptanceTest {

    private UIController ui;
    private Cell begin;
    private Cell end;
    private CleanSheets app;
    private Workbook book;
    private Spreadsheet sheet;
    private String fileIn;
    private String fileOut;
    private char special;
    private ImportController in;
    private ExportController out;
    int row, column, i, j;

    public ImportExportTxtAcceptanceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        app = new CleanSheets();
        ui = new UIController(app);
        book = new Workbook(1);
        sheet = book.getSpreadsheet(0);
        ui.setActiveWorkbook(book);
        ui.setActiveSpreadsheet(sheet);
        begin = sheet.getCell(0, 0);
        end = sheet.getCell(3, 3);

        special = ';';
        fileIn = "src\\acceptance-test\\java\\lapr4\\red\\s1\\ipc\\n1150834\\importExportTxt\\testIn.txt";
        fileOut = "src\\acceptance-test\\java\\lapr4\\red\\s1\\ipc\\n1150834\\importExportTxt\\testOut.txt";

    }

    @After
    public void tearDown() {
    }

    /**
     * Test Import Controller, regular row.
     *
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    @Ignore
    public void testImportControllerRegularRow() throws FormulaCompilationException {
        System.out.println("Import Controller Regular Row");

        in = new ImportController(ui);
        in.importInformationTxt(fileIn, begin, end, false);

        row = sheet.getRowCount();
        column = sheet.getColumnCount();

        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                System.out.printf("%s%c", sheet.getCell(j, i).getContent(), special);
            }
            System.out.println("");
        }

    }

    /**
     * Test Import Controller, column header.
     *
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    @Ignore
    public void testImportControllerColumnHeader() throws FormulaCompilationException {
        System.out.println("Import Controller Column Header");

        in = new ImportController(ui);
        in.importInformationTxt(fileIn, begin, end, true);

        row = sheet.getRowCount();
        column = sheet.getColumnCount();

        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                System.out.printf("%s%c", sheet.getCell(j, i).getContent(), special);
            }
            System.out.println("");
        }

    }

    /**
     * Test Export Controller, regular row.
     *
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    @Ignore
    public void testExportControllerRegularRow() throws FormulaCompilationException {
        System.out.println("Export Controller Regular Row");

        in = new ImportController(ui);
        in.importInformationTxt(fileIn, begin, end, false);

        row = sheet.getRowCount();
        column = sheet.getColumnCount();

        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                System.out.printf("%s%c", sheet.getCell(j, i).getContent(), special);
            }
            System.out.println("");
        }

        out = new ExportController(ui);
        out.exportInformation(fileOut, begin, end, special, false);

    }

    /**
     * Test Export Controller, column header.
     *
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    @Ignore
    public void testExportControllerColumnHeader() throws FormulaCompilationException {
        System.out.println("Export Controller Column Header");

        in = new ImportController(ui);
        in.importInformationTxt(fileIn, begin, end, false);

        row = sheet.getRowCount();
        column = sheet.getColumnCount();

        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                System.out.printf("%s%c", sheet.getCell(j, i).getContent(), special);
            }
            System.out.println("");
        }

        out = new ExportController(ui);
        out.exportInformation(fileOut, begin, end, special, true);

    }
}
