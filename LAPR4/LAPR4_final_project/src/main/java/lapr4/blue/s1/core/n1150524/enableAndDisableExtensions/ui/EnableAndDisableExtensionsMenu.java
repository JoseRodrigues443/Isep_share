/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Filipe
 */
public class EnableAndDisableExtensionsMenu extends JMenu {

    /* Creates a new simple menu.
	 * This constructor creates and adds the menu options. 
	 * In this simple example only one menu option is created.
	 * A menu option is an action (in this case {@link csheets.ext.simple.ui.ExampleAction})
	 * @param uiController the user interface controller
     */
    public EnableAndDisableExtensionsMenu(UIController uiCtrl) {
        super("Toggle Extensions");
        add(new EnableAndDisableExtensionsAction(uiCtrl));
    }
	

}
