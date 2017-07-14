/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150767.multipleWorkbookSearch;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s3.ipc.n1150767.multipleWorkbookSearch.ui.MWS_UIExtension;

/**
 *
 * @author Catarina Sousa
 */
public class ExtensionMultipleWorkbookSearch extends Extension{
    
    /**
     * The name of the extension
     */
    public static final String NAME = "Multiple Workbook Search";

    /**
     * Creates a new import/export extension.
     */
    public ExtensionMultipleWorkbookSearch() {
        super(NAME, "Description of Multiple Workbook Search", "1.0");
    }

    /**
     * Returns a user interface extension for Import and Export operations.
     *
     * @param uiController the user interface controller
     * @return a user interface extension for import/export
     */
    public UIExtension getUIExtension(UIController uiController) {
        return new MWS_UIExtension(this, uiController);
    }
}
