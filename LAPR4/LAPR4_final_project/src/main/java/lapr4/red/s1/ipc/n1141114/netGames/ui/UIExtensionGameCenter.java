package lapr4.red.s1.ipc.n1141114.netGames.ui;

import csheets.ext.simple.ui.*;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JToolBar;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import lapr4.blue.s2.ipc.n1140525.ticTacToe.ui.NetworkingGamesTUI;
import lapr4.white.s1.core.n4567890.contacts.ui.ContactPanel;
/**
 *
 * @author Joao Fernandes - 1141114@isep.ipp.pt
 */
public class UIExtensionGameCenter extends UIExtension {

    /**
     * A side bar that provides editing of comments
     */
    private JComponent sideBar;

    public UIExtensionGameCenter(Extension extension, UIController uiController) {
        super(extension, uiController);
        // TODO Auto-generated constructor stub
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
     * Returns an instance of a class that implements JMenu. In this simple case
     * this class only supplies one menu option.
     *
     * @see GameCenterMenu
     * @return a JMenu component
     */
    public JMenu getMenu() {
        return null;
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
     * Returns a side bar that gives access to extension-specific functionality.
     *
     * @return a component, or null if the extension does not provide one
     */
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new NetworkingGamesTUI(uiController);
        }
        return sideBar;
    }

}
