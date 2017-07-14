package lapr4.red.s2.lang.n1150834.conditionalFormatting;

import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Literal;
import csheets.core.formula.lang.Equal;
import csheets.core.formula.lang.GreaterThan;
import csheets.core.formula.lang.GreaterThanOrEqual;
import csheets.core.formula.lang.LessThan;
import csheets.core.formula.lang.LessThanOrEqual;
import csheets.core.formula.lang.NotEqual;
import csheets.core.formula.lang.RelationalOperator;
import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 * A Unit Test class to test FormattingCondition
 *
 * @author 1150834
 */
public class FormattingConditionTest {

    private FormattingCondition instance;
    private RelationalOperator equal, greaterThan, greaterEqual, notEqual,
            lessThan, lessEqual;
    private int value;

    public FormattingConditionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        equal = new Equal();
        notEqual = new NotEqual();
        greaterThan = new GreaterThan();
        greaterEqual = new GreaterThanOrEqual();
        lessThan = new LessThan();
        lessEqual = new LessThanOrEqual();
        value = 10;
    }

    @After
    public void tearDown() {
    }

    /**
     * Test that relational operator is not null.
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testRelationalOperatorCannotBeNull1() {
        System.out.println("Relational operator cannot not be null 1");

        instance = new FormattingCondition(null, 0);
    }

    /**
     * Test that relational operator is not null.
     */
    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void testRelationalOperatorCannotBeNull2() {
        System.out.println("Relational operator cannot not be null 2");

        instance = new FormattingCondition(null, Color.green, Color.red, 0);
    }

    /**
     * Test checkCondition method for equal operation.
     *
     * @throws csheets.core.IllegalValueTypeException
     */
    @Test
    @Ignore
    public void testCheckConditionEqual() throws IllegalValueTypeException {
        System.out.println("Equal");

        instance = new FormattingCondition(equal, value);

        Color result = instance.checkCondition(new Literal(new Value(11)));
        assertEquals(Color.red, result);

        result = instance.checkCondition(new Literal(new Value(9)));
        assertEquals(Color.red, result);

        result = instance.checkCondition(new Literal(new Value(10)));
        assertEquals(Color.green, result);
    }

    /**
     * Test checkCondition method for not equal operation.
     *
     * @throws csheets.core.IllegalValueTypeException
     */
    @Test
    @Ignore
    public void testCheckConditionNotEqual() throws IllegalValueTypeException {
        System.out.println("Not Equal");

        instance = new FormattingCondition(notEqual, value);

        Color result = instance.checkCondition(new Literal(new Value(11)));
        assertEquals(Color.green, result);

        result = instance.checkCondition(new Literal(new Value(9)));
        assertEquals(Color.green, result);

        result = instance.checkCondition(new Literal(new Value(10)));
        assertEquals(Color.red, result);
    }

    /**
     * Test checkCondition method for greater than operation.
     *
     * @throws csheets.core.IllegalValueTypeException
     */
    @Test
    @Ignore
    public void testCheckConditionGreaterThan() throws IllegalValueTypeException {
        System.out.println("Greater Than");

        instance = new FormattingCondition(greaterThan, value);

        Color result = instance.checkCondition(new Literal(new Value(11)));
        assertEquals(Color.green, result);

        result = instance.checkCondition(new Literal(new Value(9)));
        assertEquals(Color.red, result);

        result = instance.checkCondition(new Literal(new Value(10)));
        assertEquals(Color.red, result);
    }

    /**
     * Test checkCondition method for greater than or equal operation.
     *
     * @throws csheets.core.IllegalValueTypeException
     */
    @Test
    @Ignore
    public void testCheckConditionGreaterThanOrEqual() throws IllegalValueTypeException {
        System.out.println("Greater Than Or Equal");

        instance = new FormattingCondition(greaterEqual, value);

        Color result = instance.checkCondition(new Literal(new Value(11)));
        assertEquals(Color.green, result);

        result = instance.checkCondition(new Literal(new Value(9)));
        assertEquals(Color.red, result);

        result = instance.checkCondition(new Literal(new Value(10)));
        assertEquals(Color.green, result);
    }

    /**
     * Test checkCondition method for less than operation.
     *
     * @throws csheets.core.IllegalValueTypeException
     */
    @Test
    @Ignore
    public void testCheckConditionLessThan() throws IllegalValueTypeException {
        System.out.println("Less Than");

        instance = new FormattingCondition(lessThan, value);

        Color result = instance.checkCondition(new Literal(new Value(11)));
        assertEquals(Color.red, result);

        result = instance.checkCondition(new Literal(new Value(9)));
        assertEquals(Color.green, result);

        result = instance.checkCondition(new Literal(new Value(10)));
        assertEquals(Color.red, result);
    }

    /**
     * Test checkCondition method for less than or equal operation.
     *
     * @throws csheets.core.IllegalValueTypeException
     */
    @Test
    @Ignore
    public void testCheckConditionLessThanOrEqual() throws IllegalValueTypeException {
        System.out.println("Less Than Or Equal");

        instance = new FormattingCondition(lessEqual, value);

        Color result = instance.checkCondition(new Literal(new Value(11)));
        assertEquals(Color.red, result);

        result = instance.checkCondition(new Literal(new Value(9)));
        assertEquals(Color.green, result);

        result = instance.checkCondition(new Literal(new Value(10)));
        assertEquals(Color.green, result);
    }

    /**
     * Test color alterations.
     *
     * @throws csheets.core.IllegalValueTypeException
     */
    @Test
    @Ignore
    public void testAlterColors() throws IllegalValueTypeException {
        System.out.println("Alter Colors");

        instance = new FormattingCondition(equal, value);

        Color result = instance.checkCondition(new Literal(new Value(11)));
        assertEquals(Color.red, result);

        result = instance.checkCondition(new Literal(new Value(9)));
        assertEquals(Color.red, result);

        result = instance.checkCondition(new Literal(new Value(10)));
        assertEquals(Color.green, result);

        instance.alterFalseFormatColor(Color.orange);
        instance.alterTrueFormatColor(Color.blue);

        result = instance.checkCondition(new Literal(new Value(11)));
        assertEquals(Color.orange, result);

        result = instance.checkCondition(new Literal(new Value(9)));
        assertEquals(Color.orange, result);

        result = instance.checkCondition(new Literal(new Value(10)));
        assertEquals(Color.blue, result);
    }

}
