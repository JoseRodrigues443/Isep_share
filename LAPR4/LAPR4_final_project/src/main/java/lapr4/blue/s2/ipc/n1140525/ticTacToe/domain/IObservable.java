/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.domain;

/**
 *
 * @author MariaJoão
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
    void notifyObserversYes();
    
    void notifyChangePort();
}
