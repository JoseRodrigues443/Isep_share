/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.network.library;

/**
 *
 * @author Tiago
 */
public interface MessageReceiverInterface{


    /**
     * when using the Connection TCP and UDP classes is needed in the
     * constructor to insert a object with the interface
     * MessageReceiverInterface.
     *
     * When a message is received the method will trigger what the object wants
     * to do to the message.
     *
     *
     *
     * @param object Sends the object
     * @return true success, false fail
     */
    public boolean messageReceivedTrigger(Object object);

    
    
    
    
}
