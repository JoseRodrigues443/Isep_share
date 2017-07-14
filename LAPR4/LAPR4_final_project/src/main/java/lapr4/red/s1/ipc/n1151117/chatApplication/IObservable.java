/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1151117.chatApplication;

import lapr4.green.s3.ipc.n1150759.chatApplication.IObserverChatRoom;

/**
 * Interface that will be implemented by the observable
 *
 * @author Barros
 */
public interface IObservable {

    /**
     * Registers a new observer to the observable
     *
     * @param o the new Observable
     */
    void registNewObserver(IObserver o);

    /**
     * Notifies the observers to do something
     */
    void notifyObservers();

    /**
     * NOtifies the observers of a new user
     */
    void notifyObserversNewUser();
}
