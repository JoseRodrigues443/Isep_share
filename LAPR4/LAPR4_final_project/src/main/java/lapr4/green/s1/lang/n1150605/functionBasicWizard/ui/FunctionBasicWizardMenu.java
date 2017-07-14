/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150605.functionBasicWizard.ui;

import csheets.ui.ctrl.UIController;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class FunctionBasicWizardMenu extends JMenu {
    
         /**
	 * Creates a new simple menu
	 * @param uiController the user interface controller
	 */
	public FunctionBasicWizardMenu(UIController uiController) {
		super("Functions");
		setMnemonic(KeyEvent.VK_E);

		add(new FunctionBasicWizardAction(uiController));
	}	
}
