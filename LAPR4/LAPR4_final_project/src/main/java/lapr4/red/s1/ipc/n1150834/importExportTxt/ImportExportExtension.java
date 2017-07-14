package lapr4.red.s1.ipc.n1150834.importExportTxt;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.red.s1.ipc.n1150834.importExportTxt.ui.UIExtensionImportExport;

/**
 * The extension for import and export
 *
 * @author 1150834
 */
public class ImportExportExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Import/Export text";

    /**
     * Creates a new import/export extension.
     */
    public ImportExportExtension() {
        super(NAME, "Description of Import/Export text", "1.0");
    }

    /**
     * Returns a user interface extension for Import and Export operations.
     *
     * @param uiController the user interface controller
     * @return a user interface extension for import/export
     */
    public UIExtension getUIExtension(UIController uiController) {
        return new UIExtensionImportExport(this, uiController);
    }
}
