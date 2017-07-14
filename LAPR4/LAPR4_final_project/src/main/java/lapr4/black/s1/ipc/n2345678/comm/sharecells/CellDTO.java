/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.black.s1.ipc.n2345678.comm.sharecells;

import csheets.core.Address;
import csheets.core.Cell;
import java.io.Serializable;

/**
 * This class implements a "version" of the Cell that is suitable for
 * communication without serializing the all graph of the sheet.<p>
 * Need to include at least: getAddress() and getContent()
 * <p>
 * Need to see the best way to get a set of CellDTO from a set o regular Cells
 * <p>
 * (see SortedSet SpreadsheetImpl.getCells(Address address1, Address address2)).
 *
 * @author alexandrebraganca
 */
public class CellDTO implements Serializable, Comparable<CellDTO> {

    private Address address;
    private String content;

    public CellDTO(Address addr, String cont) {
        address = addr;
        content = cont;
    }
     public CellDTO(Cell c) {
        address = c.getAddress();
        content = c.getContent();
    }

    public static CellDTO createFromCell(Cell aCell) {
        return new CellDTO(aCell.getAddress(), aCell.getContent());
    }

    public Address getAddress() {
        return address;
    }

    public String getContent() {
        return content;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int compareTo(CellDTO o) {
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
            char tmp = (char)('A' + column);
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
