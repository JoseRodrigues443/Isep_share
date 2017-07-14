/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1151117.chatApplication.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.Utils;

/**
 * This class represents a chat between two (or more) users.
 *
 * It contains a list of messages, so there will be a record of all sent
 * messages between all users, and a Set of users so there is a record of the
 * users in the current chat.
 *
 * To store messages is used an ArrayList so the users can send messages with
 * the same content, source and destination multiple times.
 *
 * Example: sending a Message with the content "Yes" to reply to different
 * messages in the same direction should be possible.
 *
 * @author Barros
 * 
 * edited by Jorge Campos (1150759)
 */
public class Chat implements Comparable<Chat>, Serializable {

    /**
     * a list of all the messages in the chat
     */
    private final List<Message> allMessages;

    /**
     * a Set of all the users in the chat
     */
    private final Set<NetworkAddress> allUsers;
    
    /**
     * Chat room's owner
     */
    private NetworkAddress owner;
    
    /**
     * Chat room's name
     */
    private String roomName;
    
    /**
     * Chat room's type (public or private)
     */
    private String roomType;
    
    /**
     * Chat room's types
     */
    private static final String TYPE_PUBLIC = "public";
    private static final String TYPE_PRIVATE = "private";

    /**
     * Creates a new Instance of a chat between two users, received as arguments
     *
     * @param address1 the first user's address
     * @param address2 the second user's address
     */
    public Chat(NetworkAddress address1, NetworkAddress address2) {
        if (address1 == null || address2 == null || address1.equals(address2)) {
            throw new IllegalStateException();
        }
        allMessages = new ArrayList<>();
        allUsers = new HashSet<>();
        addChatUser(address1);
        addChatUser(address2);
    }

    /**
     * Creates a new Instance of a chat between two users with a message,
     * received as arguments
     *
     * @param message the message between the users
     * @param address1 the first user's address
     * @param address2 the second user's address
     */
    public Chat(Message message, NetworkAddress address1, NetworkAddress address2) {
        if (message == null || address1 == null || address2 == null
                 || address1.equals(address2)) {
            throw new IllegalStateException();
        }
        allMessages = new ArrayList<>();
        allUsers = new HashSet<>();
        addChatMessage(message);
        addChatUser(address1);
        addChatUser(address2);
    }

    /**
     * Creates a new Instance of a chat between two users with a message, which
     * is received as arguments
     *
     * @param message the message between the users
     */
    public Chat(Message message) {
        if (message == null) {
            throw new IllegalStateException();
        }
        allMessages = new ArrayList<>();
        allUsers = new HashSet<>();
        addChatMessage(message);
        addChatUser(message.messageReceiver());
        addChatUser(message.messageSender());
    }
    
    /**
     * Creates a new instance of a chat room with it's owner, name and type
     * received as arguments
     * 
     * @param owner Chat room's owner
     * @param roomName Chat room's name
     * @param roomType Chat room's type
     */
    public Chat(NetworkAddress owner, String roomName, String roomType) {
        this.allMessages = new ArrayList<>();
        this.allUsers = new HashSet<>();
        this.owner = owner;
        this.roomName = roomName;
        this.roomType = roomType;
    }

    /**
     * Adds a new user to the chat
     *
     * @param address the user's address
     * @return true if added, false if the user is already in the chat
     */
    public boolean addChatUser(NetworkAddress address) {
        if (address == null || allUsers.contains(address)) {
            throw new IllegalStateException();
        }
        return allUsers.add(address);
    }

    /**
     * Adds a new Message to the chat
     *
     * @param message the message to adds
     * @return true if added
     */
    public boolean addChatMessage(Message message) {
        if (message == null) {
            throw new IllegalStateException();
        }
        return allMessages.add(message);
    }

    /**
     * Returns all the messages in the chat
     *
     * @return all the messages in the chat
     */
    public List<Message> allMessagesInChat() {
        return this.allMessages;
    }

    /**
     * Returns all the users in the chat
     *
     * @return all the users in the chat
     */
    public Set<NetworkAddress> allUsersInChat() {
        return this.allUsers;
    }
    
    /**
     * Returns all the users in the chat except the own user
     * 
     * @return All the users in the chat except the own user
     */
    public Set<NetworkAddress> allOtherUsersInChat() {
        Set<NetworkAddress> allOthers = allUsersInChat();
        allOthers.remove(Utils.ownIpAddress());
        
        return allOthers;
    }
    
    /**
     * Removes a user from a chat room
     * 
     * @param user User to be removed
     * @return True if successfully removed, false otherwise
     */
    public boolean leaveChatRoom(NetworkAddress user) {
        return this.allUsers.remove(user);
    }
    
    /**
     * Method to return the other user in the chat, to sort the active chats by
     * other user ip
     *
     * @return the other user's ip address
     */
    public NetworkAddress otherUserInChat() {
        for (NetworkAddress address : allUsers) {
            if (!address.getAddress().equals(Utils.ownIpAddress().getAddress())) {
                return address;
            }
        }
        return null;
    }

    /**
     * Method to return all the ip addresses in string format
     *
     * @return all the ip addresses in string format
     */
    public ArrayList<String> allIPsInChat() {
        ArrayList<String> allIPs = new ArrayList<>();
        for (NetworkAddress address : allUsers) {
            allIPs.add(address.getAddress());
        }
        return allIPs;
    }
    
    /**
     * Returns the owner of the chat room
     * 
     * @return Chat room's owner
     */
    public NetworkAddress getOwner() {
        return this.owner;
    }
    
    /**
     * Returns the chat room's name
     * 
     * @return Chat room's name
     */
    public String getRoomName() {
        return this.roomName;
    }
    
    /**
     * Returns the chat room's type
     * 
     * @return Chat room's type (Public or private)
     */
    public String getRoomType() {
        return this.roomType;
    }

    @Override
    public int compareTo(Chat o) {
        int cmp = Integer.compare(this.allMessages.size(), o.allMessages.size());
        return cmp == 0 ? Integer.compare(this.allUsers.size(), o.allUsers.size()) : cmp;
    }

}
