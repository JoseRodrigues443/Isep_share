/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150835.overlayImageWindow;

import csheets.core.Cell;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import lapr4.blue.s1.core.n1150630.insertImage.ImageExtension;
import lapr4.blue.s1.core.n1150630.insertImage.InsertImageCell;
import lapr4.green.s2.core.n1150835.overlayImageWindow.ui.ImageBrowserUI;

/**
 *
 * @author Rui Braga
 * @author 1150834(alterations)
 */
public class ImageBrowserListener implements MouseMotionListener {

    private static InsertImageCell chosenCell;

    public ImageBrowserListener() {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        // nothing happens
    }

    @Override
    /**
     * This method will
     */
    public void mouseMoved(MouseEvent me) {
        SpreadsheetTable table = (SpreadsheetTable) me.getComponent();
        try {
            int rowindex = table.rowAtPoint(me.getPoint());
            int columnindex = table.columnAtPoint(me.getPoint());
            Cell cell = (Cell) table.getSpreadsheet().getCell(columnindex, rowindex);
            InsertImageCell imageCell = (InsertImageCell) cell.getExtension(ImageExtension.NAME);

            // If it's not the chosen cell, it closes the window
            if (chosenCell != null) {
                if (!imageCell.equals(chosenCell) && ImageBrowserUI.visible()) {
                    ImageBrowserUI.getCurrentUI().close();
                }
            }
            chosenCell = imageCell;
            if (imageCell.hasImage()) {
                if (!ImageBrowserUI.visible()) {
                    ImageBrowserUI.instance(imageCell);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
