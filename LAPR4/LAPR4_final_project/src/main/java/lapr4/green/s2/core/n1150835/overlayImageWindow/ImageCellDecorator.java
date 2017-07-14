/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150835.overlayImageWindow;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.ui.ext.CellDecorator;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import lapr4.blue.s1.core.n1150630.insertImage.ImageExtension;
import lapr4.blue.s1.core.n1150630.insertImage.InsertImageCell;

/**
 *
 * @author Rui Braga
 */
public class ImageCellDecorator extends CellDecorator {

    private static final Font font = new Font("Dialog", Font.PLAIN, 10);
    private java.awt.Image iconImage;

    /**
     * Creates a new cell decorator.
     */
    public ImageCellDecorator() {
        super();
        setEnabled(true);
        /*try {
            BufferedImage img = ImageIO.read(ImageExtension.class.getResource("res/img/image-icon.png"));
            iconImage = img;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
    }

    /**
     * Decorates the given graphics context if the cell being rendered has a
     * comment.
     *
     * @param component the cell renderer component
     * @param g the graphics context on which drawing should be done
     * @param cell the cell being rendered
     * @param selected whether the cell is selected
     * @param hasFocus whether the cell has focus
     */
    @Override
    public void decorate(JComponent component, Graphics g, Cell cell,
            boolean selected, boolean hasFocus) {
        if (enabled) {
            InsertImageCell imageCell = (InsertImageCell) cell.getExtension(ImageExtension.NAME);
            if (imageCell.hasImage()) {
                // Stores current graphics context properties
                Graphics2D g2 = (Graphics2D) g;
                Color oldPaint = g2.getColor();
                Font oldFont = g2.getFont();

                // Prints 'A' using own font, then restores the old font
                g2.setColor(Color.red);
                g2.setFont(font);
                g2.drawImage(iconImage, 1, 1, null);
                g2.setColor(oldPaint);
                g2.setFont(oldFont);
            }
        }
    }
}
