/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150605.functionBasicWizard;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s1.lang.n1150605.functionBasicWizard.ui.UIExtensionFunctionBasicWizard;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class FunctionBasicWizardExtension extends Extension {
        /** the name of the extension */
	public static final String NAME = "Function Basic Wizard";
            
	/**
	 * Creates a new Example extension.
	 */
	public FunctionBasicWizardExtension() {
		super(NAME, "Description of Function Basic Wizard", "1.0");
	}
	
	/**
	 * Returns the user interface extension of this extension 
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
            return new UIExtensionFunctionBasicWizard(this, uiController);
	}
    
}


