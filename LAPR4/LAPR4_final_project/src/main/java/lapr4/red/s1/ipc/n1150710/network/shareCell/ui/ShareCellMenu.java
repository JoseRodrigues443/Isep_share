package lapr4.red.s1.ipc.n1150710.network.shareCell.ui;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;

import csheets.ui.ctrl.UIController;

/**
 * Representes the UI extension menu of the simple extension.
 * @author 1150710@isep.ipp.pt
 */
public class ShareCellMenu extends JMenu {

	/**
	 * Creates a new simple menu.
	 * This constructor creates and adds the menu options. 
	 * In this simple example only one menu option is created.
	 * A menu option is an action (in this case {@link csheets.ext.simple.ui.ExampleAction})
	 * @param uiController the user interface controller
	 */
	public ShareCellMenu(UIController uiController) {
		super("Share Cell");
		setMnemonic(KeyEvent.VK_E);

		// Adds font actions
		add(new ShareCellAction(uiController));
	}	
}
