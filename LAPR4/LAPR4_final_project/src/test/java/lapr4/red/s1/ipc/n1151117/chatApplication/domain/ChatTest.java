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
public class ChatTest {

    private Chat chat;
    private Message message1;
    private Message message2;
    private NetworkAddress address1;
    private NetworkAddress address2;
    private NetworkAddress address3;

    public ChatTest() {
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
        address3 = Utils.ownIpAddress();
        address3.setAddress("192.168.1.106");
        message1 = new Message("Hello, friend!", address1, address2);
        message2 = new Message("Hello, how are you?", address2, address1);
        chat = new Chat(address1, address2);
        chat.addChatMessage(message1);
        chat.addChatMessage(message2);
    }

    @After
    public void tearDown() {
    }

    @Test(expected = IllegalStateException.class)
    public void testChatMustHaveTwoDifferentAddresses() {
        System.out.println("chat must have two different addresses");
        chat = new Chat(address1, address1);
    }

    @Test(expected = IllegalStateException.class)
    public void testChatMustNotHaveAnyNullAddresses() {
        System.out.println("chat must not have any null addresses");
        chat = new Chat(null, address1);
    }

    @Test(expected = IllegalStateException.class)
    public void testChatMustNotHaveAnyNullAddresses2() {
        System.out.println("chat must not have any null addresses2");
        chat = new Chat(address2, null);
    }

    @Test(expected = IllegalStateException.class)
    public void testChatMessageMustNotBeNull() {
        System.out.println("chat message must not be null");
        chat = new Chat(null);
    }

    @Test
    public void testChatBuiltSuccessfully() {
        System.out.println("chat build succesfully");
        chat = new Chat(message1, address1, address2);
    }

    /**
     * Test of addChatUser method, of class Chat.
     */
    @Test
    public void testAddChatUser() {
        System.out.println("addChatUser");
        assertEquals(chat.addChatUser(address3), true);
    }

    /**
     * Test of addChatUser method, of class Chat.
     */
    @Test(expected = IllegalStateException.class)
    public void testChatMustNotHaveUserAlready() {
        System.out.println("Chat must not have user already");
        assertEquals(chat.addChatUser(address1), true);
    }

    /**
     * Test of addChatMessage method, of class Chat.
     */
    @Test
    public void testAddChatMessage() {
        System.out.println("addChatMessage");
        Message message = new Message("I'm happy, fiend", address2, address1);
        assertEquals(chat.addChatMessage(message), true);
    }

}
