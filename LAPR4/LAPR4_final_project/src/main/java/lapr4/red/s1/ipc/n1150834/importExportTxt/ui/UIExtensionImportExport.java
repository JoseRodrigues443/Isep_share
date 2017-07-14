package lapr4.red.s1.ipc.n1150834.importExportTxt.ui;

import csheets.ext.Extension;
import csheets.ext.simple.ui.ExampleMenu;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

/**
 * This class implements the UI interface extension for the import/export
 * extension.
 *
 * @author 1150834
 */
public class UIExtensionImportExport extends UIExtension {

    /**
     * The menu of the extension
     */
    private ImportExportMenu menu;

    /**
     * The menu of the extension
     *
     * @param extension extension
     * @param uiController ui controller
     */
    public UIExtensionImportExport(Extension extension, UIController uiController) {
        super(extension, uiController);
    }

    /**
     * Returns an icon to display with the extension's name.
     *
     * @return an icon with style
     */
    public Icon getIcon() {
        return null;
    }

    /**
     * Returns an instance of a class that implements JMenu.
     *
     * @see ExampleMenu
     * @return a JMenu component
     */
    public JMenu getMenu() {
        if (menu == null) {
            menu = new ImportExportMenu(uiController);
        }
        return menu;
    }

    /**
     * Returns a cell decorator that visualizes comments on cells.
     *
     * @return decorator for cells with comments
     */
    public CellDecorator getCellDecorator() {
        return null;
    }

    /**
     * Returns a table decorator that visualizes the data added by the
     * extension.
     *
     * @return a table decorator, or null if the extension does not provide one
     */
    public TableDecorator getTableDecorator() {
        return null;
    }

    /**
     * Returns a toolbar that gives access to extension-specific functionality.
     *
     * @return a JToolBar component, or null if the extension does not provide
     * one
     */
    public JToolBar getToolBar() {
        return null;
    }

    /**
     * Returns a side bar that provides editing of comments.
     *
     * @return a side bar, or null if the extension does not provide one
     */
    public JComponent getSideBar() {
        return null;
    }
}
