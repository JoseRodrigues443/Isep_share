/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150825.workbookSearch.app;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s3.core.n1150825.workbookSearch.ui.UIWorkbookSearchExtension;

/**
 *
 * @author João Coelho
 */
public class ExtensionWorkbookSearch extends Extension {
    
    /** The name of the extension */
    public static final String NAME = "Workbook Search";
    
    public ExtensionWorkbookSearch() {
        super(NAME, "Workbook Search", "1.0");
    }
   
	
	/**
	 * Returns the user interface extension of this extension (an instance of the class {@link  csheets.ext.simple.ui.UIGameCenterExtension}).
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIWorkbookSearchExtension(this, uiController);
	}
}