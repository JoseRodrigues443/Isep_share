package lapr4.red.s1.ipc.n1141114.netGames;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s1.ipc.n1141114.netGames.ui.UIExtensionGameCenter;

/**
 *
 * @author Joao Fernandes - 1141114@isep.ipp.pt
 */
public class ExtensionGameCenter extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Game Center";

    /**
     * Creates a new GameCenter extension.
     */
    public ExtensionGameCenter() {
        super(NAME, "Description of Game Center", "1.0");
    }

    /**
     * Returns the user interface extension of this extension (an instance of
     * the class {@link  csheets.ext.simple.ui.UIGameCenterExtension}).
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionGameCenter(this, uiController);
    }
}
