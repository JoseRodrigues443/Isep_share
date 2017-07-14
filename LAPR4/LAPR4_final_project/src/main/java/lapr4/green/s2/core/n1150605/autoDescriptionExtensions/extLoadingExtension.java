/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150605.autoDescriptionExtensions;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s2.core.n1150605.autoDescriptionExtensions.ui.UIExtensionExtLoading;

/**
 *
 * @author Miguel Morgado 1150605
 */
   public class extLoadingExtension extends Extension {
    
    /**
     * The name of the extension
     */
    public static final String NAME = "Load Extensions";

    /**
     * The empty constructor
     */
    public extLoadingExtension() {
        super(NAME, "Description of Load Extensions", "1.0");
    } 
    
    /**
     * Returns the interface extension related with this extension
     * @param uiController
     * @return The ui extension related with this extension
     */
     @Override
	public UIExtension getUIExtension(UIController uiController) {
            return new UIExtensionExtLoading(this, uiController);
	}
}
