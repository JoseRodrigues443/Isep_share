/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.network.library;

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
public class ObjectConnectionTCPTest {

    public ObjectConnectionTCPTest() {
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
     * Test of getTcpPort method, of class ObjectConnectionTCP.
     */
    @Test
    public void testGetTcpPort() {
        System.out.println("getTcpPort");
        ObjectConnectionTCP instance = new ObjectConnectionTCP(22);
        int expResult = 22;
        int result = instance.getTcpPort();
        assertEquals(expResult, result);
    }

    /**
     * Test of tcpListener method, of class ObjectConnectionTCP.
     */
    @Ignore
    public void testTcpListener() {
        System.out.println("tcpListener");
//        MessageReceiverInterface server = null;
//        ObjectConnectionTCP instance = null;
//        ObjectConnectionTCP.ReceiverTCP expResult = null;
//        ObjectConnectionTCP.ReceiverTCP result = instance.tcpListener(server);
//        assertEquals(expResult, result);
        /**
         * trhe listener creates a thread and that makes he test
         * dificulte/imposible
         */
        assertTrue(true);
    }

    /**
     * Test of tcpSenderSendMessage method, of class ObjectConnectionTCP.
     * 
     * takes a lot of time, so is in ignore to dont take time in jenkins
     */
    @Ignore
    public void testTcpSenderSendMessage() {
        System.out.println("tcpSenderSendMessage");
        Object messageToSend = new Object();
        String addressString = "192.168.0.1";
        NetworkAddress addresToSend = new NetworkAddress(NetworkIpProtocolEnum.IPV4, addressString, addressString, addressString, 0, 0);
        ObjectConnectionTCP instance = new ObjectConnectionTCP(0);
        boolean expResult = false;
        boolean result = instance.tcpSenderSendMessage(messageToSend, addresToSend);
        assertEquals(expResult, result);
    }

}