package lapr4.red.s1.ipc.n1150710.network.shareCell;

import csheets.CleanSheets;
import csheets.ext.simple.*;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s1.ipc.n1150710.network.shareCell.ui.UIExtensionShareCell;

/**
 * A simple extension just to show how the extension mechanism works.
 * An extension must extend the Extension abstract class.
 * The class that implements the Extension is the "bootstrap" of the extension.
 * @see Extension
 * @author 1150710@isep.ipp.pt
 */
public class ShareExtension extends Extension {

	/** The name of the extension */
	public static final String NAME = "Share Cell";
        

        
	/**
	 * Creates a new Example extension.
	 */
	public ShareExtension() {
		super(NAME, "Description of Share Cell", "1.0");
	}
	
	/**
	 * Returns the user interface extension of this extension (an instance of the class {@link  csheets.ext.simple.ui.UIExtensionExample}).
	 * In this extension example we are only extending the user interface.
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionShareCell(this, uiController);
	}
}
