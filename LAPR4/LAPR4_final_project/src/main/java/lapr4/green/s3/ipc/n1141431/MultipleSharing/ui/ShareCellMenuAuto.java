/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1141431.MultipleSharing.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Pedro Oliveira 1141431
 */
public class ShareCellMenuAuto extends JMenu {

    /**
     * Creates a new simple menu. This constructor creates and adds the menu
     * options. In this simple example only one menu option is created. A menu
     * option is an action (in this case
     * {@link csheets.ext.simple.ui.ExampleAction})
     *
     * @param uiController the user interface controller
     */
    public ShareCellMenuAuto(UIController uiController) {
        super("Multiple Share Cell");
        

        // Adds font actions
        add(new ShareCellAutoAction(uiController));
    }
}
