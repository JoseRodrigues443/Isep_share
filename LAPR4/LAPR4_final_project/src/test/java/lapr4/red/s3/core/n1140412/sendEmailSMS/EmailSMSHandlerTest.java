/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1140412.sendEmailSMS;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class EmailSMSHandlerTest {
    
    public EmailSMSHandlerTest() {
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
     * Test of sendMail method, of class EmailSMSHandler.
     */
    @Test
    public void testSendMail() throws Exception {
        System.out.println("sendMail");
        List<String> recipients = new ArrayList<>();
        String subject = "";
        String body = "";
        boolean expResult = false;
        boolean result = EmailSMSHandler.sendMail(recipients, subject, body);
        assertEquals(expResult, result);
        
    }

    
    
}
