/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1140525.ticTacToe.application;

import csheets.ui.ctrl.UIController;

/**
 *
 * @author MariaJoão
 */
public interface TcpClassWrapper {
    /**
      * Sets the UIController of the instance that receives this class
      * @param uiController The UIController of the instance that receives the object of this class
      */
    void setUIController(UIController uiController);
     
    /**
     * Method to process the data on the receivers side.
     */
    void processData();
     
}
