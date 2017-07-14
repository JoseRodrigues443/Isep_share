/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.ImportExportLink;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.blue.s2.ipc.n1130679.ImportExportLink.ui.UIImportLinkExtension;

/**
 *
 * @author Ana Pacheco (1130679)
 */
public class ImportTxtExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "ImportTxtLink";

    /**
     * Creates a new extension.
     */
    public ImportTxtExtension() {
        super(NAME,"Import txt file link","1.0");
    }

    /**
     * Returns the user interface extension of this extension (an instance of
     * the class {@link  csheets.ext.simple.ui.UIExtensionExample}). <br/>
     * In this extension example we are only extending the user interface.
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    public UIExtension getUIExtension(UIController uiController) {
        return new UIImportLinkExtension(this, uiController);
    }
}
