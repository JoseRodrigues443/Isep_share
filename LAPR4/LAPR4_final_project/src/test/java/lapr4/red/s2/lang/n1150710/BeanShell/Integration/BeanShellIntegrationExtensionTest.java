/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150710.BeanShell.Integration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public class BeanShellIntegrationExtensionTest {
    
    public BeanShellIntegrationExtensionTest() {
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

    /**
     * Test of beanShellIntegration method, of class BeanShellIntegrationExtension.
     */
    @Ignore
    @Test
    public void testBeanShellIntegration() {
        System.out.println("beanShellIntegration");
        String allTextInCell = "=fact([macroFivePlusFive(0)])";
        String expResult = "=fact(10)";
        String result = BeanShellIntegrationExtension.beanShellIntegration(allTextInCell);
        //System.out.println("-->-->" + result);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of beanShellIntegration method, of class BeanShellIntegrationExtension.
     */
    @Ignore
    @Test
    public void testBeanShellIntegrationMoraThanOnScript() {
        System.out.println("beanShellIntegration");
        String allTextInCell = "=fact([macroFivePlusFive(0)]) + [macroFivePlusFive(0)]";
        String expResult = "=fact(10) + 10";
        String result = BeanShellIntegrationExtension.beanShellIntegration(allTextInCell);
        //System.out.println("-->-->" + result);
        assertEquals(expResult, result);
    }
    
}
