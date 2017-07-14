/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lapr4.black.s1.ipc.n2345678.comm.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 *
 * @author alexandrebraganca
 */
public class CommMenu extends JMenu {

	/**
	 * Creates a new simple menu.
	 * This constructor creates and adds the menu options. 
	 * In this simple example only one menu option is created.
	 * A menu option is an action (in this case {@link ClientTestAction})
	 * @param uiController the user interface controller
	 */
	public CommMenu(UIController uiController) {
		super("Comm");
		setMnemonic(KeyEvent.VK_E);

		// Adds font actions
		add(new ClientTestAction(uiController));
	}	
}
