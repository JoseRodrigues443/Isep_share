/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150759.chatApplication.domain;

import java.util.HashSet;
import java.util.Set;
import lapr4.red.s1.ipc.n1151117.chatApplication.domain.Chat;

/**
 *
 * @author Jorge Campos <1150759@isep.ipp.pt>
 */
public class ChatRoomList {
    /**
     * Set to store all the existing chat rooms
     */
    private final Set<Chat> chatSet;
    
    /**
     * Creates a new instance of ChatRoomList to store all the 
     * existing chat rooms
     */
    public ChatRoomList() {
        chatSet = new HashSet<>();
    }
    
    /**
     * Stores a new chat room in the list
     *
     * @param chat Chat to be added to the list
     * @return True if the chat is added, false otherwise
     */
    public boolean addChatRoom(Chat chat) {
        // TO DO: validate chat room's name (can't add a room if the name
        // already exists)
        if (chat == null)
            throw new IllegalStateException();
        
        return chatSet.add(chat);
    }
    
    /**
     * Deletes a chat room
     * 
     * @param chat Chat room to be deleted
     * @return True if the chat is deleted, false otherwise
     */
    public boolean deleteChatRoom(Chat chat) {
        if (chat == null)
            throw new IllegalStateException();
        
        return chatSet.remove(chat);
    }
    
    /**
     * Returns all the active chat rooms
     *
     * @return All the active chat rooms
     */
    public Set<Chat> allChatRooms() {
        return this.chatSet;
    }
    
    /**
     * Returns all the public chat rooms
     * 
     * @return All the public chat rooms
     */
    public Set<Chat> allPublicChatRooms() {
        Set<Chat> publicRooms = new HashSet<>();
        
        for (Chat chat : chatSet)
            if (chat.getRoomType().equals("public"))
                publicRooms.add(chat);
        
        return publicRooms;
    }
}
