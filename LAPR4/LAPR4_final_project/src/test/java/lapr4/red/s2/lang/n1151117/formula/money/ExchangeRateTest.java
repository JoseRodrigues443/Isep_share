/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1151117.formula.money;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Barros
 */
public class ExchangeRateTest {
    
    public ExchangeRateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected = IllegalStateException.class)
    public void testUpdateDollarEuroRateMustNotBeLowerThanZero() {
        System.out.println("update Dollar to Euro Rate must not be lower than 0");
        ExchangeRate.updateDollarEuroRate(-1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testUpdateDollarPoundRateMustNotBeLowerThanZero() {
        System.out.println("update Dollar to Pound Rate must not be lower than 0");
        ExchangeRate.updateDollarPoundRate(-1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testUpdateEuroDollarRateMustNotBeLowerThanZero() {
        System.out.println("update Euro to Dollar Rate must not be lower than 0");
        ExchangeRate.updateEuroDollarRate(-1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testUpdateEuroPoundRateMustNotBeLowerThanZero() {
        System.out.println("update Euro to Pound Rate must not be lower than 0");
        ExchangeRate.updateEuroPoundRate(-1);
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testUpdatePoundDollarRateMustNotBeLowerThanZero() {
        System.out.println("update Pound to Dollar Rate must not be lower than 0");
        ExchangeRate.updatePoundDollarRate(-1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testUpdatePoundEuroRateMustNotBeLowerThanZero() {
        System.out.println("update Pound to Euro Rate must not be lower than 0");
        ExchangeRate.updatePoundEuroRate(-1);
    }

    @Test
    public void testUpdateDollarEuroRate() {
        System.out.println("updateDollarEuroRate");
        ExchangeRate.updateDollarEuroRate(5);
        assertTrue(ExchangeRate.dollarEuroRate() == 5);
    }
    
    /**
     * Test of updateDollarPoundRate method, of class ExchangeRate.
     */
    @Test
    public void testUpdateDollarPoundRate() {
        System.out.println("updateDollarPoundRate");
        ExchangeRate.updateDollarPoundRate(3);
        assertTrue(ExchangeRate.dollarPoundRate() == 3);
    }

    /**
     * Test of updatePoundEuroRate method, of class ExchangeRate.
     */
    @Test
    public void testUpdatePoundEuroRate() {
        System.out.println("updatePoundEuroRate");
        ExchangeRate.updatePoundEuroRate(7);
        assertTrue(ExchangeRate.poundEuroRate() == 7);
    }

    /**
     * Test of updatePoundDollarRate method, of class ExchangeRate.
     */
    @Test
    public void testUpdatePoundDollarRate() {
        System.out.println("updatePoundDollarRate");
        ExchangeRate.updatePoundDollarRate(2.1);
        assertTrue(ExchangeRate.poundDollarRate() == 2.1);
    }

    /**
     * Test of updateEuroDollarRate method, of class ExchangeRate.
     */
    @Test
    public void testUpdateEuroDollarRate() {
        System.out.println("updateEuroDollarRate");
        ExchangeRate.updateEuroDollarRate(1.53);
        assertTrue(ExchangeRate.euroDollarRate() == 1.53);
    }

    /**
     * Test of updateEuroPoundRate method, of class ExchangeRate.
     */
    @Test
    public void testUpdateEuroPoundRate() {
        System.out.println("updateEuroPoundRate");
        ExchangeRate.updateEuroPoundRate(1.76);
        assertTrue(ExchangeRate.euroPoundRate() == 1.76);
    }
    
}
