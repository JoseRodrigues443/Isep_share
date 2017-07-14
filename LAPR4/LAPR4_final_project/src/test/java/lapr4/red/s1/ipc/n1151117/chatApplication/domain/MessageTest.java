/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1151117.chatApplication.domain;

import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.Utils;
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
public class MessageTest {
    
    private Message message;
    private NetworkAddress address1;
    private NetworkAddress address2;
    
    public MessageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        address1 = Utils.ownIpAddress();
        address2 = Utils.ownIpAddress();
        address2.setAddress("192.168.1.102");
        message = new Message("Hello, friend!", address1, address2);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test(expected = IllegalStateException.class)
    public void testUserCannotMessageHimself(){
        System.out.println("user cannot message himself");
        message = new Message(address1, address1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testMessageSenderMustNotBeNull(){
        System.out.println("message sender must not be null");
        message = new Message(null, address1);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testMessageReceiverMustNotBeNull(){
        System.out.println("message receiver must not be null");
        message = new Message(address1, null);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testMessageContentMustNotBeNull(){
        System.out.println("message content must not be null");
        message = new Message(null, address1, address2);
    }
    
    @Test(expected = IllegalStateException.class)
    public void testMessageContentMustNotBeEmpty(){
        System.out.println("message content must not be null");
        message = new Message("", address1, address2);
    }
    
    @Test
    public void testMessageBuiltSuccessfully(){
        System.out.println("message built successfully");
        message = new Message("Hello, friend!", address1, address2);
    }

    /**
     * Test of message method, of class Message.
     */
    @Test
    public void testMessage() {
        System.out.println("message has the same content");
        assertEquals("Hello, friend!", message.message());
    }

    /**
     * Test of messageSender method, of class Message.
     */
    @Test
    public void testMessageSender() {
        System.out.println("message has the same sender");
        assertEquals(address1, message.messageSender());
    }

    /**
     * Test of messageReceiver method, of class Message.
     */
    @Test
    public void testMessageReceiver() {
        System.out.println("message has the same receiver");
        assertEquals(address2, message.messageReceiver());
    }

    /**
     * Test of changeMessageContent method, of class Message.
     */
    @Test
    public void testChangeMessageContent() {
        System.out.println("message content has changed");
        String content = "Hello, how are you?";
        assertNotEquals(message.message(), content);
        message.changeMessageContent(content);
        assertEquals(message.message(), content);
    }
    
}
