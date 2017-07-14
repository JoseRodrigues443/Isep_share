/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150759.chatApplication;

import lapr4.red.s1.ipc.n1151117.chatApplication.domain.Message;

/**
 *
 * @author Jorge Campos <1150759@isep.ipp.pt>
 */
public interface IObserverChatRoom {
    /**
     * Method to update the chat in a chat room
     * 
     * @param message Message received
     */
    void updateChat(Message message);
}
