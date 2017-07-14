/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1150825.networkingTools.app;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s1.ipc.n1150825.networkingTools.ui.UIextensionLogList;

/**
 *
 * @author João Coelho
 */
public class ExtensionLogList extends Extension {
    
    /** The name of the extension */
    public static final String NAME = "Log";
    
    public ExtensionLogList() {
        super(NAME, "Description of Log", "1.0");
    }
   
	
	/**
	 * Returns the user interface extension of this extension (an instance of the class {@link  csheets.ext.simple.ui.UIGameCenterExtension}).
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIextensionLogList(this, uiController);
	}
}