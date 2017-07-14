package lapr4.red.s2.lang.n1150834.conditionalFormatting;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.GreaterThanOrEqual;
import csheets.core.formula.lang.RelationalOperator;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;

/**
 * A Unit Test class to test ConditionalFormattingRange
 *
 * @author 1150834
 */
public class ConditionalFormattingRangeTest {

    ConditionalFormattingRange instance;
    private FormattingCondition condition;
    private RelationalOperator greaterEqual;
    private UIController ui;
    private Cell begin;
    private Cell end;
    private Iterator<Cell> it;
    private Spreadsheet sheet;

    public ConditionalFormattingRangeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws FormulaCompilationException {
        greaterEqual = new GreaterThanOrEqual();
        condition = new FormattingCondition(greaterEqual, 0);
        CleanSheets app = new CleanSheets();
        ui = new UIController(app);
        Workbook book = new Workbook(1);
        sheet = book.getSpreadsheet(0);
        ui.setActiveWorkbook(book);
        ui.setActiveSpreadsheet(sheet);
        begin = sheet.getCell(0, 0);
        end = sheet.getCell(1, 1);
        instance = new ConditionalFormattingRange(ui, begin, end, condition);
        begin.setContent("=5");
        end.setContent("=20");
        sheet.getCell(0, 1).setContent("=10");
        sheet.getCell(1, 0).setContent("=15");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of formatRange method for equal operation.
     *
     * @throws csheets.core.IllegalValueTypeException
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    @Ignore
    public void testFormatRangeEquals() throws IllegalValueTypeException, FormulaCompilationException {
        System.out.println("Equal");

        instance.formatRange("=10");

        it = sheet.iterator();

        while (it.hasNext()) {
            StylableCell cell = (StylableCell) it.next().getExtension(StyleExtension.NAME);
            if (cell.getValue().toNumber().intValue() == 10) {
                assertEquals(Color.green, cell.getBackgroundColor());
            } else {
                assertEquals(Color.red, cell.getBackgroundColor());
            }
        }
    }

    /**
     * Test of formatRange method for not equal operation.
     *
     * @throws csheets.core.IllegalValueTypeException
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    @Ignore
    public void testFormatRangeNotEquals() throws IllegalValueTypeException, FormulaCompilationException {
        System.out.println("Not Equal");

        instance.formatRange("<>10");

        it = sheet.iterator();

        while (it.hasNext()) {
            StylableCell cell = (StylableCell) it.next().getExtension(StyleExtension.NAME);
            if (cell.getValue().toNumber().intValue() != 10) {
                assertEquals(Color.green, cell.getBackgroundColor());
            } else {
                assertEquals(Color.red, cell.getBackgroundColor());
            }
        }
    }

    /**
     * Test of formatRange method for greater than operation.
     *
     * @throws csheets.core.IllegalValueTypeException
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    @Ignore
    public void testFormatRangeGreaterThan() throws IllegalValueTypeException, FormulaCompilationException {
        System.out.println("Greater Than");

        instance.formatRange(">10");

        it = sheet.iterator();

        while (it.hasNext()) {
            StylableCell cell = (StylableCell) it.next().getExtension(StyleExtension.NAME);
            if (cell.getValue().toNumber().intValue() > 10) {
                assertEquals(Color.green, cell.getBackgroundColor());
            } else {
                assertEquals(Color.red, cell.getBackgroundColor());
            }
        }
    }

    /**
     * Test of formatRange method for greater than or equal operation.
     *
     * @throws csheets.core.IllegalValueTypeException
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    @Ignore
    public void testFormatRangeGreaterThanOrEqual() throws IllegalValueTypeException, FormulaCompilationException {
        System.out.println("Greater Than Or Equal");

        instance.formatRange(">=10");

        it = sheet.iterator();

        while (it.hasNext()) {
            StylableCell cell = (StylableCell) it.next().getExtension(StyleExtension.NAME);
            if (cell.getValue().toNumber().intValue() >= 10) {
                assertEquals(Color.green, cell.getBackgroundColor());
            } else {
                assertEquals(Color.red, cell.getBackgroundColor());
            }
        }
    }

    /**
     * Test of formatRange method for less than operation.
     *
     * @throws csheets.core.IllegalValueTypeException
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    @Ignore
    public void testFormatRangeLessThan() throws IllegalValueTypeException, FormulaCompilationException {
        System.out.println("Less Than");

        instance.formatRange("<10");

        it = sheet.iterator();

        while (it.hasNext()) {
            StylableCell cell = (StylableCell) it.next().getExtension(StyleExtension.NAME);
            if (cell.getValue().toNumber().intValue() < 10) {
                assertEquals(Color.green, cell.getBackgroundColor());
            } else {
                assertEquals(Color.red, cell.getBackgroundColor());
            }
        }
    }

    /**
     * Test of formatRange method for less than or equal operation.
     *
     * @throws csheets.core.IllegalValueTypeException
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    @Test
    @Ignore
    public void testFormatRangeLessThanOrEqual() throws IllegalValueTypeException, FormulaCompilationException {
        System.out.println("Less Than Or Equal");

        instance.formatRange("<=10");

        it = sheet.iterator();

        while (it.hasNext()) {
            StylableCell cell = (StylableCell) it.next().getExtension(StyleExtension.NAME);
            if (cell.getValue().toNumber().intValue() <= 10) {
                assertEquals(Color.green, cell.getBackgroundColor());
            } else {
                assertEquals(Color.red, cell.getBackgroundColor());
            }
        }
    }
}
