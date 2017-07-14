package lapr4.red.s1.ipc.n1151117.chatApplication;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s1.ipc.n1151117.chatApplication.ui.UIExtensionChatApplication;

/**
 * 
 * @author BArros
 */
public class ExtensionChatApplication extends Extension {

	/** The name of the extension */
	public static final String NAME = "Chat";

	/**
	 * Creates a new GameCenter extension.
	 */
	public ExtensionChatApplication() {
		super(NAME, "Description of Chat", "1.0");
	}
	
	/**
	 * Returns the user interface extension of this extension (an instance of the class {@link  csheets.ext.simple.ui.UIGameCenterExtension}).
	 * @param uiController the user interface controller
	 * @return a user interface extension, or null if none is provided
	 */
        @Override
	public UIExtension getUIExtension(UIController uiController) {
		return new UIExtensionChatApplication(this, uiController);
	}
}
