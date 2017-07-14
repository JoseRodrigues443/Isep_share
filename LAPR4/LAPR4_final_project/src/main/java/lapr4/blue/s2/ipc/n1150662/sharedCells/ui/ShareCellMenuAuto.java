/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150662.sharedCells.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;


/**
 *
 * @author bruno
 */
public class ShareCellMenuAuto extends JMenu  {
    	/**
	 * Creates a new simple menu.
	 * This constructor creates and adds the menu options. 
	 * In this simple example only one menu option is created.
	 * A menu option is an action (in this case {@link csheets.ext.simple.ui.ExampleAction})
	 * @param uiController the user interface controller
	 */
	public ShareCellMenuAuto(UIController uiController) {
		super("Share Cell Automatic");
		setMnemonic(KeyEvent.VK_E);

		// Adds font actions
		add(new ShareCellAutoAction(uiController));
	}
}
