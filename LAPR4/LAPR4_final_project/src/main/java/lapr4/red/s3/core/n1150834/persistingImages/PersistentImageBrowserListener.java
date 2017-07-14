package lapr4.red.s3.core.n1150834.persistingImages;

import csheets.core.Cell;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import lapr4.red.s3.core.n1150834.persistingImages.ui.PersistingImageBrowserUI;

/**
 * A listener to detect mouse actions
 *
 * @author 1150834
 */
public class PersistentImageBrowserListener implements MouseMotionListener, MouseListener {

    /**
     * The current cell
     */
    private static PersistentImageCell chosenCell;

    /**
     * Creates a new PersistentImageBrowserListener
     */
    public PersistentImageBrowserListener() {

    }

    @Override
    public void mouseDragged(MouseEvent me) {
        // nothing happens
    }

    /**
     * Shows image window when mouse moves
     *
     * @param me
     */
    @Override
    public void mouseMoved(MouseEvent me) {
        if (AutomaticBehavior.currentBehavior()) {
            PersistentImageCell currentCell = getCurrentCell(me);
            showWindow(currentCell);
        }
    }

    /**
     * Shows image window when the mouse is clicked
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
        if (!AutomaticBehavior.currentBehavior()) {
            if (me.getClickCount() == 1) {
                PersistentImageCell currentCell = getCurrentCell(me);
                showWindow(currentCell);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        // nothing happens
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        // nothing happens
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        if (!AutomaticBehavior.currentBehavior() && PersistingImageBrowserUI.visible()) {
            PersistentImageCell currentCell = getCurrentCell(me);
            showWindow(currentCell);
        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
        // nothing happens    
    }

    private PersistentImageCell getCurrentCell(MouseEvent me) {
        SpreadsheetTable table = (SpreadsheetTable) me.getComponent();
        int rowindex = table.rowAtPoint(me.getPoint());
        int columnindex = table.columnAtPoint(me.getPoint());
        Cell cell = (Cell) table.getSpreadsheet().getCell(columnindex, rowindex);
        PersistentImageCell imageCell = (PersistentImageCell) cell.getExtension(PersistingImagesExtension.NAME);

        return imageCell;
    }

    private void showWindow(PersistentImageCell imageCell) {
        chosenCell = imageCell;
        if (imageCell.hasImage()) {
            if (!PersistingImageBrowserUI.visible()) {
                PersistingImageBrowserUI.instance(imageCell);
            } else {
                PersistingImageBrowserUI.update(imageCell);
            }
        } else {
            if (chosenCell != null) {
                if (PersistingImageBrowserUI.visible()) {
                    PersistingImageBrowserUI.getCurrentUI().close();
                }
            }
        }
    }
}
