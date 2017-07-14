/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1151117.chatApplication.domain;

import eapli.util.Strings;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;
import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 * Class that represents a message sent between two users.
 *
 * This class contains a message, the user that send the message and the user
 * that receives the message.
 *
 * The users are currently identified by their ip address. in the future, they
 * can be identified by a contact.
 *
 * @author Barros
 */
public class Message implements Serializable{

    private static final String MESSAGE_BY_DEFAULT = "";

    /**
     * The message content
     */
    private String msg;

    /**
     * The source of the message
     */
    private final NetworkAddress fromUser;

    /**
     * The destination of the message
     */
    private final NetworkAddress toUser;
    
    /**
     * Set with the multiple receivers of the chat room
     */
    private Set<NetworkAddress> receivers = new TreeSet<>();

    /**
     * Creates a new Message, receiving the content, the source and the
     * destination of the message as arguments
     *
     * @param msg the content of the message
     * @param fromUser the destination of the message
     * @param toUser the source of the message
     */
    public Message(String msg, NetworkAddress fromUser, NetworkAddress toUser) {
        if(Strings.isNullOrEmpty(msg) || Strings.isNullOrWhiteSpace(msg) ||
                fromUser == null || toUser == null || toUser.equals(fromUser)){
            throw new IllegalStateException();
        }
        this.msg = msg;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }

    /**
     * Creates a new Message, receiving the source and the destination of the
     * message as arguments
     *
     * @param fromUser the destination of the message
     * @param toUser the source of the message
     */
    public Message(NetworkAddress fromUser, NetworkAddress toUser) {
        if(fromUser == null || toUser == null || toUser.equals(fromUser)){
            throw new IllegalStateException();
        }
        this.msg = MESSAGE_BY_DEFAULT;
        this.fromUser = fromUser;
        this.toUser = toUser;
    }
    
    /**
     * Creates a new Message, receiving the source and the receivers of the
     * message as arguments
     * 
     * @param msg Message's content
     * @param fromUser Destination of the message
     * @param receivers Set with all the receivers in the chat room
     */
    public Message(String msg, NetworkAddress fromUser, 
            Set<NetworkAddress> receivers) {
        if (Strings.isNullOrEmpty(msg) || Strings.isNullOrWhiteSpace(msg) ||
                fromUser == null || receivers == null) {
            throw new IllegalStateException();
        }
        
        this.msg = msg;
        this.fromUser = fromUser;
        this.receivers = receivers;
        this.toUser = null;
    }

    /**
     * Returns the message content
     *
     * @return the message content
     */
    public String message() {
        return this.msg;
    }

    /**
     * Returns the source of the message
     *
     * @return the source of the message
     */
    public NetworkAddress messageSender() {
        return this.fromUser;
    }

    /**
     * Returns the destination of the message
     *
     * @return the destination of the message
     */
    public NetworkAddress messageReceiver() {
        return this.toUser;
    }
 
    /**
     * Returns a set with all the receivers of the message
     * 
     * @return Set with all the receivers of the message
     */
    public Set<NetworkAddress> allReceivers() {        
        return this.receivers;
    }

    /**
     * Method to change the message content, with the content received as
     * argument
     *
     * @param content the new message content
     */
    public void changeMessageContent(String content) {
        if (Strings.isNullOrEmpty(content) || Strings.isNullOrWhiteSpace(content)) {
            throw new IllegalStateException();
        }
        this.msg = content;
    }

}
