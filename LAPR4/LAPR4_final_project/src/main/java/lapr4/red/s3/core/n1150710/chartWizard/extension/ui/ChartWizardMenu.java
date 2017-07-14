package lapr4.red.s3.core.n1150710.chartWizard.extension.ui;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;

import csheets.ui.ctrl.UIController;

/**
 * Representes the UI extension menu of the simple extension.
 * @author 1150710@isep.ipp.pt
 */
public class ChartWizardMenu extends JMenu {

	/**
	 * Creates a new simple menu.
	 * This constructor creates and adds the menu options. 
	 * In this simple example only one menu option is created.
	 * A menu option is an action (in this case {@link csheets.ext.simple.ui.ExampleAction})
	 * @param uiController the user interface controller
	 */
	public ChartWizardMenu(UIController uiController) {
		super("Chart Wizard");
		setMnemonic(KeyEvent.VK_E);

		// Adds font actions
		add(new ChartActionForMenu(uiController));
	}	
}
