/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150662.sharedCells;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.formula.Formula;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import java.io.Serializable;

/**
 *
 * @author bruno
 */
public class DTOCell implements Serializable, Comparable<DTOCell> {

    private Address address;
    private String content;
    private CellStyleInfo style;
    

    public DTOCell(Address addr, String cont) {
        address = addr;
        content = cont;
        

    }

    public DTOCell(Cell c, CellStyleInfo style) {
        address = c.getAddress();
        content = c.getContent();
        this.style = style;
        
    }

    public static DTOCell createFromCell(Cell aCell) {
        StylableCell sCell = (StylableCell) aCell.getExtension(StyleExtension.NAME);
        
        CellStyleInfo style = new CellStyleInfo(sCell.getFormat(), sCell.getFont(), sCell.getHorizontalAlignment(), sCell.getVerticalAlignment(), sCell.getForegroundColor(), sCell.getBackgroundColor(), sCell.getBorder());
        return new DTOCell(aCell, style);
    }

    public Address getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }

    public CellStyleInfo getStyleInfo(){
        return style;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setStyleInfo(CellStyleInfo style) {
        this.style = style;
    }

    @Override
    public int compareTo(DTOCell o) {
        return address.compareTo(o.getAddress());
    }

    /**
     *
     * @return EX: "B13" or "CC12"
     */
    public String cellIdentificationToHumanFormat() {
        String toReturn = "";
        int row = this.address.getRow();
        int letterA = 65;
        int letterZ = 90;
        /**
         * to letters
         */
        int column = this.address.getColumn();
        /**
         * 90-65 = 25 the number of letters of the ALFABET [a-z] ex: A11, Z22
         * etc
         */
        if (column < (letterZ - letterA)) {
            char tmp = (char) ('A' + column);
            toReturn = tmp + "" + ++row;
        } else if (column >= (letterZ - letterA) && column < (letterZ - letterA) * 2) {
            /**
             * EX: when the colum it exceds the Z letter
             *
             * the matriz uses values like AA, AB, AC...AZ and nothing more
             */
            toReturn = "A"
                    + ('A' + column - (letterZ - letterA)) + "" + ++row;
        }

        return toReturn;
    }
}
