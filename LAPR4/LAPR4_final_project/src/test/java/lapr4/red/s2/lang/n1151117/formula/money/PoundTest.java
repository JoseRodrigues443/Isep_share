/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1151117.formula.money;

import csheets.core.Value;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Barros
 */
public class PoundTest {

    private Money money;
    double amount = 20.0;

    public PoundTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        money = new Dollar(amount);
    }

    @After
    public void tearDown() {
    }

    @Test(expected = IllegalStateException.class)
    public void testMoneyAmountCantBeLowerThatZero() {
        System.out.println("test that money amount cant be lower than 0");
        Money m = new Pound(-2);
    }

    @Test
    public void testMoneyIsValid() {
        System.out.println("test that money is valid");
        Money m = new Pound(amount);
        assertTrue(m != null);
    }

    /**
     * Test of convertToEuro method, of class Pound.
     */
    @Ignore
    @Test
    public void testConvertToEuro() {
        System.out.println("convertToEuro");
        Pound pound = new Pound(amount);
        double output = 22.8;
        assertEquals(pound.convertToEuro(), output, 0.001);
    }

    /**
     * Test of convertToDollar method, of class Pound.
     */
    @Ignore
    @Test
    public void testConvertToDollar() {
        System.out.println("convertToDollar");
        Pound pound = new Pound(amount);
        double output = 25.4;
        assertEquals(pound.convertToDollar(), output, 0.001);
    }

    /**
     * Test of convertToPound method, of class Pound.
     */
    @Test
    public void testConvertToPound() {
        System.out.println("convertToPound");
        Pound pound = new Pound(amount);
        assertEquals(pound.convertToPound(), amount, 0.00);
    }

    /**
     * Test of amountInValue method, of class Pound.
     */
    @Ignore
    @Test
    public void testAmountInValue() {
        System.out.println("amountInValue");
        Value output = new Value(25.4);
        assertEquals(output, money.amountInValue("dollar"));
    }

}
