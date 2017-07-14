package lapr4.red.s3.core.n1150710.chartWizard.extension;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * A simple extension just to show how the extension mechanism works.
 * An extension must extend the Extension abstract class.
 * The class that implements the Extension is the "bootstrap" of the extension.
 * @see Extension
 * @author 1150710@isep.ipp.pt
 */
public class ChartExtension extends Extension {

	/** The name of the extension */
	public static final String NAME = "Chart Editor";
        

        
	/**
	 * Creates a new Example extension.
	 */
	public ChartExtension() {
		super(NAME, "Description of Chart Editor", "1.0");
	}
	
	/**
	 * Returns the user interface extension of this extension (an instance of the class {@link  csheets.ext.simple.ui.UIExtensionExample}).
	 * In this extension example we are only extending the user interface.
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionChartWizard(this, uiController);
	}
}
