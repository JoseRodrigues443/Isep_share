/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150759.chatApplication;

/**
 *
 * @author Jorge Campos <1150759@isep.ipp.pt>
 */
public interface IObservableChatRoom {
    /**
     * Registers a new chat room observer
     * 
     * @param o IObserverChatRoom 
     */
    void registNewChatRoomObserver(IObserverChatRoom o);
    
     /**
     * Notifies the observers of a chat room
     */
    void notifyObserversChatRoom();
}
