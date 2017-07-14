/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150767.multipleWorkbookSearch.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.TableDecorator;
import csheets.ui.ext.UIExtension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

/**
 *
 * @author Catarina Sousa
 */
public class MWS_UIExtension extends UIExtension{
       /**
     * The menu of the extension
     */
    private MWS_Menu menu;
    
    public MWS_UIExtension(Extension extension, UIController uiController) {
        super(extension, uiController);
    }
    
//    /**
//    * Returns an instance of a class that implements JMenu.
//	 * In this simple case this class only supplies one menu option.
//	 * @see ExampleMenu
//	 * @return a JMenu component
//	 */
//	public JMenu getMenu() { 
//            JMenu mwsMenu = new JMenu("Workbook Search");
//            mwsMenu.setMnemonic(KeyEvent.VK_M); 
//            JMenuItem item = new JMenuItem("Multiple Realtime Workbook Search");
//            mwsMenu.add(item);
//            ActionListener listener =new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    new MultipleWorkbookSearchUI(uiController);
//                }
//            };
//            item.addActionListener(listener);
//            return mwsMenu;
//	}
    
     

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
            menu = new MWS_Menu(uiController);
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
