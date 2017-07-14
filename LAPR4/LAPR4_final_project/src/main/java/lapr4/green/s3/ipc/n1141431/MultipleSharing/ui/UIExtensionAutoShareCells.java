/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1141431.MultipleSharing.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

/**
 *
 * @author Pedro Oliveira 1141431
 */
public class UIExtensionAutoShareCells extends UIExtension {

    /**
     * The icon to display with the extension's name
     */
    private Icon icon;

    /**
     * The menu of the extension
     */
    private ShareCellMenuAuto menu;

    /**
     * A side bar that provides editing of comments
     */
    private JComponent sideBar;

    private SharePanelAuto sharePanel;

    public UIExtensionAutoShareCells(Extension extension, UIController uiController) {
        super(extension, uiController);
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns an icon to display with the extension's name.
     *
     * @return an icon with style
     */
    @Override
    public Icon getIcon() {
        return null;
    }

    /**
     * Returns an instance of a class that implements JMenu. In this simple case
     * this class only supplies one menu option.
     *
     * @see ShareCellMenu
     * @return a JMenu component
     */
    public JMenu getMenu() {
        if (menu == null) {
            menu = new ShareCellMenuAuto(uiController);
        }
        return menu;
        //return null;
    }

    /**
     * Returns a cell decorator that visualizes the data added by the extension.
     *
     * @return a cell decorator, or null if the extension does not provide one
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
     * Returns a side bar that provides list off instances.
     *
     * @return a side bar
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sharePanel = new SharePanelAuto(uiController);
            sideBar = sharePanel;
        }
        return sideBar;
    }
}
