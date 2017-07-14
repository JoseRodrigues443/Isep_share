/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1151117.chatApplication.domain;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class will store all chats for the user.
 *
 * Example: if the user is having a chat with two users, both chats should be
 * stored in this class.
 *
 * @author Barros
 */
public class ChatList {

    /**
     * The set to store all the chats of the user
     */
    private final Set<Chat> chatSet;

    /**
     * Creates a new Instance of the chatList to store the user's chats
     */
    public ChatList() {
        chatSet = new TreeSet<>();
    }

    /**
     * Creates a new Instance of the chatList to store the user's chats,
     * receiving the first chat as an argument
     *
     * @param c the user's chat to add
     */
    public ChatList(Chat c) {
        if(c == null){
            throw new IllegalStateException();
        }
        chatSet = new TreeSet<>();
        addChat(c);
    }

    /**
     * This method is responsible to store a new chat in the chatList
     *
     * @param c the chat to add to the list
     * @return true if the chat is added, or false if it's not added (if the
     * chat is already saved, the chat will not be added
     */
    public boolean addChat(Chat c) {
        if(chatSet.contains(c) || c == null){
            throw new IllegalStateException();
        }
        return chatSet.add(c);
    }

    /**
     * This method returns all the active chats of the user
     *
     * @return all the active chats of the user
     */
    public Set<Chat> allChats() {
        return this.chatSet;
    }

    /**
     * This method returns a chat that contains all the addresses given as
     * argument
     *
     * @param addresses the lsit of addresses to match
     * @return the chat of the user, or null if there is no chat
     */
    public Chat findChatFromIPAddresses(ArrayList<String> addresses) {
        Chat foundChat = null;
        for (Chat c : chatSet) {
            if (c.allUsersInChat().size() == addresses.size()) {
                if(c.allIPsInChat().containsAll(addresses)){
                    return c;
                }
            }
        }
        return foundChat;
    }
}
