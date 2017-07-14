package lapr4.blue.s3.lang.n1150595.tablesAndFilters.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 * This class implements the UI interface extension for the Tables and Filters
 * extension.
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
public class UIExtensionTablesAndFilters extends UIExtension {

    /**
     * The side bar of the extension
     */
    private TablesAndFiltersSideBar bar;

    /**
     * The menu of the extension
     *
     * @param extension extension
     * @param uiController ui controller
     */
    public UIExtensionTablesAndFilters(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns a side bar that provides editing of comments.
     *
     * @return a side bar, or null if the extension does not provide one
     */
    @Override
    public JComponent getSideBar() {
        if (bar == null) {
            bar = new TablesAndFiltersSideBar(uiController);
        }
        return bar;
    }

}
