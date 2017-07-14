/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150524.enableAndDisableExtensions;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.ui.UIExtensionEnableAndDisableExtensions;

/**
 * This class makes a new extension to be used in the main app CleanSheets
 * This extension will have the ability of enabling and disabling te other 
 * extensions loaded in the project
 * @author Filipe
 */
public class EnableAndDisableExtensionsExtension extends Extension {
    
      /**
       * The name of the extension
       */
    public static final String NAME = "Toggle Extensions";

    /**
     * The empty builder
     */
    public EnableAndDisableExtensionsExtension() {
        super(NAME, "Description of Toggle Extensions", "1.0");
    } 
    
    /**
     * Returns the interface extension related with this extension
     * @param uiController
     * @return The ui extension related with this extension
     */
     @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionEnableAndDisableExtensions(this, uiController);
	}
    
}
