/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150630.insertImage.ui;

import csheets.ext.Extension;
import lapr4.blue.s1.core.n1150630.insertImage.ImageExtension;
import lapr4.blue.s1.core.n1150630.insertImage.InsertImageCell;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.UIExtension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import lapr4.green.s2.core.n1150835.overlayImageWindow.ImageCellDecorator;

/**
 *
 * @author David
 */
public class InsertImageUIExtension extends UIExtension {

    private JComponent sideBar;
    private CellDecorator cellDecorator;

    public InsertImageUIExtension(Extension extension, UIController uiController) {
        super(extension, uiController);
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
     * Returns a JMenu that provides to add an image to the selected cell
     *
     * @return an Menu
     */
    @Override
    public JMenu getMenu() {
        JMenu insertImageMenu = new JMenu("Image");
        JMenuItem item = new JMenuItem("Insert Image");
        insertImageMenu.add(item);
        ActionListener insertImageListener;
        insertImageListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InsertImageUI((InsertImageCell) uiController.getActiveCell().getExtension(ImageExtension.NAME), uiController);
            }
        };
        item.addActionListener(insertImageListener);
        return insertImageMenu;
    }

    /**
     * Returns a side bar that provides display and remove images
     *
     * @return a side bar
     */
    @Override
    public JComponent getSideBar() {
        if (sideBar == null) {
            sideBar = new ImagePanel(uiController);
            sideBar.setName(ImageExtension.NAME);
        }
        return sideBar;
    }
    
    /**
     * Returns a cell decorator that visualizes images on cells.
     *
     * @return decorator for cells with images
     */
    @Override
    public CellDecorator getCellDecorator() {
        if (cellDecorator == null) {
            cellDecorator = new ImageCellDecorator();
        }
        return cellDecorator;
    }

}
