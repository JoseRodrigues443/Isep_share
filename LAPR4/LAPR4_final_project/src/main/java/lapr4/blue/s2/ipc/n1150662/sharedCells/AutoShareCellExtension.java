/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150662.sharedCells;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.blue.s2.ipc.n1150662.sharedCells.ui.UIExtensionAutoShareCells;

/**
 *
 * @author bruno
 */
public class AutoShareCellExtension extends Extension{
    /** The name of the extension */
	public static final String NAME = "Share Cell Automatic";
        

        
	/**
	 * Creates a new Example extension.
	 */
	public AutoShareCellExtension() {
		super(NAME, "Description of Share Cell Automatic", "1.0");
	}
	
	/**
	 * Returns the user interface extension of this extension (an instance of the class {@link  csheets.ext.simple.ui.UIExtensionExample}).
	 * In this extension example we are only extending the user interface.
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionAutoShareCells(this, uiController);
	}
}