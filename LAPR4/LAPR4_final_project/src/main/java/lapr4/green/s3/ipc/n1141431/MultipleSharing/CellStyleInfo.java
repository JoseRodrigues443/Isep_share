/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1141431.MultipleSharing;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import java.text.Format;
import javax.swing.border.Border;

/**
 *
 * @author bruno
 */
public class CellStyleInfo implements Serializable {

    /**
     * The format used by the cell
     */
    private Format format;

    /**
     * The font used when rendering the cell's content
     */
    private Font font;

    /**
     * The horizontal alignment of the cell's content
     */
    private int hAlignment;

    /**
     * The vertical alignment of the cell's content
     */
    private int vAlignment;

    /**
     * The color used when rendering the cell's content
     */
    private Color fgColor;

    /**
     * The background color of the cell
     */
    private Color bgColor;

    /**
     * The border of the cell
     */
    private Border border;

    /**
     * Full constructor
     *
     * @param format
     * @param font
     * @param hAlignment
     * @param vAlignment
     * @param fgColor
     * @param bgColor
     * @param border
     */
    public CellStyleInfo(Format format, Font font, int hAlignment, int vAlignment, Color fgColor, Color bgColor, Border border) {
        this.format = format;
        this.font = font;
        this.hAlignment = hAlignment;
        this.vAlignment = vAlignment;
        this.fgColor = fgColor;
        this.bgColor = bgColor;
        this.border = border;
    }

    /**
     * @return the format
     */
    public Format getFormat() {
        return format;
    }

    /**
     * @return the font
     */
    public Font getFont() {
        return font;
    }

    /**
     * @return the hAlignment
     */
    public int gethAlignment() {
        return hAlignment;
    }

    /**
     * @return the vAlignment
     */
    public int getvAlignment() {
        return vAlignment;
    }

    /**
     * @return the fgColor
     */
    public Color getFgColor() {
        return fgColor;
    }

    /**
     * @return the bgColor
     */
    public Color getBgColor() {
        return bgColor;
    }

    /**
     * @return the border
     */
    public Border getBorder() {
        return border;
    }

    /**
     * @param format the format to set
     */
    public void setFormat(Format format) {
        this.format = format;
    }

    /**
     * @param font the font to set
     */
    public void setFont(Font font) {
        this.font = font;
    }

    /**
     * @param hAlignment the hAlignment to set
     */
    public void sethAlignment(int hAlignment) {
        this.hAlignment = hAlignment;
    }

    /**
     * @param vAlignment the vAlignment to set
     */
    public void setvAlignment(int vAlignment) {
        this.vAlignment = vAlignment;
    }

    /**
     * @param fgColor the fgColor to set
     */
    public void setFgColor(Color fgColor) {
        this.fgColor = fgColor;
    }

    /**
     * @param bgColor the bgColor to set
     */
    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    /**
     * @param border the border to set
     */
    public void setBorder(Border border) {
        this.border = border;
    }

}
