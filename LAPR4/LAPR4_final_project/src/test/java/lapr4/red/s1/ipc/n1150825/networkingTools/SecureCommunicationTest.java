/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1150825.networkingTools;

import lapr4.red.s1.ipc.n1150825.networkingTools.domain.SecureCommunication;
import csheets.core.Address;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author João Coelho
 */
public class SecureCommunicationTest {
    
    public SecureCommunicationTest() {
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
     * Test of enCrypt method, of class SecureCommunication.
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testStringEnCryptDecrypt() throws IOException, ClassNotFoundException {
        System.out.println("enCrypt");
        String expResult = "Olá Mundo??";
        SecureCommunication instance = new SecureCommunication();
        Object middlestep = instance.enCrypt((String) expResult);
        Object result = instance.deCrypt((String)middlestep, instance.keyNum());
        assertEquals(expResult, (String) result);
    }
    
    /**
     * Test of enCrypt method, of class SecureCommunication.
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    @Test
    public void testObjectEnCryptDecrypt() throws IOException, ClassNotFoundException {
        System.out.println("enCrypt");
        Address expResult = new Address(2, 3);
        SecureCommunication instance = new SecureCommunication();
        Object middlestep = instance.enCrypt(expResult);
        Object result = instance.deCrypt(middlestep);
        assertEquals(expResult, result);
    }
}
