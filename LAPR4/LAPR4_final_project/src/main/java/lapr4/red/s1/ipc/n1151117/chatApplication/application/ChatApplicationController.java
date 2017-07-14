/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1151117.chatApplication.application;

import eapli.framework.application.Controller;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import lapr4.green.s3.ipc.n1150759.chatApplication.domain.ChatRoomList;
import lapr4.red.s1.ipc.n1141114.netGames.UserProfile;
import lapr4.red.s1.ipc.n1151117.chatApplication.ExtensionConnectionManagerChatApplication;
import lapr4.red.s1.ipc.n1151117.chatApplication.domain.Chat;
import lapr4.red.s1.ipc.n1151117.chatApplication.domain.ChatList;
import lapr4.red.s1.ipc.n1151117.chatApplication.domain.Message;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkExtensionEnum;
import lapr4.red.s1.ipc.network.library.NetworkMachinesList;
import lapr4.red.s1.ipc.network.library.Utils;

/**
 * Controller to
 *
 * @author Barros
 *
 * edited by Jorge Campos (1150759)
 */
public class ChatApplicationController implements Controller {

    private final ChatList chatList;
    private Chat chat;
    private final NetworkMachinesList usersList;
    private ExtensionConnectionManagerChatApplication extensionChat;
    private final ChatRoomList chatRoomList;

    public ChatApplicationController() {
        this.usersList = new NetworkMachinesList(NetworkExtensionEnum.CHAT);
        this.chatList = new ChatList();
        this.extensionChat = new ExtensionConnectionManagerChatApplication();
        this.chatRoomList = new ChatRoomList();
    }

    public TreeMap<NetworkAddress, Integer> showOnlineUsers() {
        return this.extensionChat.allMapMembers();
    }

    public Set<Chat> allActiveChats() {
        return this.chatList.allChats(); //fix after tested
    }

    public Chat findChatFromIPAddresses(ArrayList<String> addresses) {
        return chatList.findChatFromIPAddresses(addresses);
    }

    public boolean addChatToList(Chat c) {
        return chatList.addChat(c);
    }

    /**
     * Added for s2,
     *
     * @param nickname
     * @param imageDir
     * @return
     */
    public boolean updateProfile(String nickname, String imageDir, String status) {
        this.extensionChat.updateProfileInfo(nickname, imageDir, status);
        return true;
    }

    public String findIPAddressByProfileName(String name) {
        return extensionChat.returnMapProfileMembers().findNetworkAddressByProfile(name);
    }

    public NetworkAddress findNetworkAddressByIP(String otherAddress) {
        return extensionChat.returnMapMembers().findNetworkAddressByIP(otherAddress);
    }

    public Chat createChat(Message message) {
        return chat = new Chat(message);
    }

    public ExtensionConnectionManagerChatApplication extensionConnectionManager() {
        return this.extensionChat;
    }

    /**
     * Added for s2
     *
     * @param ip
     * @return
     */
    public String findProfileByIP(String ip) {
        return extensionChat.findProfileNickByIP(ip);
    }

    /**
     * Creates a new chat room with an associated owner, name and type
     *
     * @param name Room's name
     * @param type Room's type (Public or private)
     *
     * @return New chat room
     */
    public Chat createChat(String name, String type) {
        return chat = new Chat(Utils.ownIpAddress(), name, type);
    }

    /**
     * Returns all the public chat rooms
     *
     * @return All the public chat rooms
     */
    public Set<Chat> allPublicChatRooms() {
        return this.chatRoomList.allPublicChatRooms();
    }

    /**
     * Adds a chat room to the list of chat rooms
     *
     * @param c the chat room
     * @return true if added
     */
    public boolean addChatRoomToList(Chat c) {
        return chatRoomList.addChatRoom(c);
    }
    
    /**
     * Deleted a chat room from the list
     * 
     * @param c Chat room
     * @return True if deleted, false otherwise
     */
    public boolean deleteChatRoom(Chat c) {
        return chatRoomList.deleteChatRoom(c);
    }
}
