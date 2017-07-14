/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150605.networkExplorer;

import csheets.CleanSheets;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s3.ipc.n1150605.networkExplorer.ui.UIExtensionNetworkExplorer;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class networkExplorerExtension extends Extension {
    
     /**
     * The name of the extension
     */
    public static final String NAME = "Network Explorer";

    /**
     * The empty constructor
     */
    public networkExplorerExtension() {
        super(NAME, "Network Explorer", "1.0");
    } 
    
    /**
     * Returns the interface extension related with this extension
     * @param uiController
     * @return The ui extension related with this extension
     */
     @Override
	public UIExtension getUIExtension(UIController uiController) {
            return new UIExtensionNetworkExplorer(this, uiController);
	}
}
