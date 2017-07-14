/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1151117.chatApplication.domain;

import java.util.ArrayList;
import java.util.Set;
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
public class ChatListTest {

    private ChatList chatList;
    private Chat chat1;
    private Chat chat2;
    private Message message1;
    private Message message2;
    private Message message3;
    private Message message4;
    private NetworkAddress address1;
    private NetworkAddress address2;
    private NetworkAddress address3;
    private NetworkAddress address4;

    public ChatListTest() {
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
        address4 = Utils.ownIpAddress();
        address4.setAddress("192.168.1.115");
        message1 = new Message("Hello, friend!", address1, address2);
        message2 = new Message("Hello, how are you?", address2, address1);
        message3 = new Message("I'm fine thanks, and you?", address3, address4);
        message4 = new Message("I'm fine too, thanks", address4, address3);
        chat1 = new Chat(address1, address2);
        chat1.addChatMessage(message1);
        chat1.addChatMessage(message2);
        chat1.addChatMessage(message3);
        chat2 = new Chat(address3, address4);
        chat2.addChatMessage(message1);
        chat2.addChatMessage(message2);
        chat2.addChatMessage(message3);
        chat2.addChatMessage(message4);
        chatList = new ChatList();
        chatList.addChat(chat1);
    }

    @After
    public void tearDown() {
    }

    @Test(expected = IllegalStateException.class)
    public void testChatListMustNotHaveANullChat() {
        System.out.println("chatList must not have a null chat");
        chatList = new ChatList(null);
    }

    @Test
    public void testChatListBuildSuccessfully() {
        System.out.println("chatList is built successfully");
        chatList = new ChatList(chat1);
    }

    /**
     * Test of addChat method, of class ChatList.
     */
    @Test
    public void testAddChat() {
        System.out.println("addChat");
        assertEquals(chatList.addChat(chat2), true);
    }

    /**
     * Test of addChat method, of class ChatList.
     */
    @Test(expected = IllegalStateException.class)
    public void testChatMustNotAddRepeatedChats() {
        System.out.println("addChat");
        chatList.addChat(chat1);
    }
}
