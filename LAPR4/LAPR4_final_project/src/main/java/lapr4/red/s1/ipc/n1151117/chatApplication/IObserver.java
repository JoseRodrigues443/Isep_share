/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1151117.chatApplication;

import lapr4.red.s1.ipc.n1151117.chatApplication.domain.Message;

/**
 * Interface that will be implemented by the observer
 *
 * @author Barros
 */
public interface IObserver {

    /**
     * Method to show the pop-up when notified
     *
     * @param message the message to show the pop-up
     */
    void showPopUp(Message message);

    /**
     * Method to update the available user lsit when notified
     */
    void updateUsersList();
}
