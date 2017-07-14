/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1150595.tablesAndFilters;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.blue.s3.lang.n1150595.tablesAndFilters.ui.UIExtensionTablesAndFilters;

/**
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
public class TablesAndFiltersExtension extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Tables and Filters";

    /**
     * Creates a new Tables and Filters extension.
     */
    public TablesAndFiltersExtension() {
        super(NAME, "Filter contents of a table", "1.0");
    }

    /**
     * Returns a user interface extension for conditional range formatting
     * operations.
     *
     * @param uiController the user interface controller
     * @return a user interface extension for conditional range formatting
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        if (this.uiExtension == null) {
            this.uiExtension = new UIExtensionTablesAndFilters(this, uiController);
        }
        return uiExtension;
    }

}
