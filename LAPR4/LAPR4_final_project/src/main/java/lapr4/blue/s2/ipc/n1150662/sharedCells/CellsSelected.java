/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150662.sharedCells;

import csheets.core.Cell;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.SortedSet;
import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 *
 * @author bruno
 */
public class CellsSelected implements Serializable {

    /**
     * Data transfer objects, the data to trasnfer
     */

    private ArrayList<DTOCell> cellDTOs;
    
    /**
     * The origin address
     */
    private final NetworkAddress objectOriginAddress;
    
    /**
     * Constructor
     * @param allCellSorted
     * @param objectOriginAddress 
     */

    public CellsSelected(SortedSet<Cell> allCellSorted, NetworkAddress objectOriginAddress) {
        cellDTOs = new ArrayList<>();
        this.objectOriginAddress = objectOriginAddress;
        fill(allCellSorted);
    }
    
    /**
     * 
     * @return the data transfer objects
     */

    public ArrayList<DTOCell> getCellDTOs() {
        return cellDTOs;
    }
    
    /**
     * Changes the data transfer objects
     * @param cellDTOs 
     */
    public void setCellDTOs(ArrayList<DTOCell> cellDTOs) {
        this.cellDTOs = cellDTOs;
    }
    /**
     * 
     * @param allCellSorted 
     */
    public void setCellDTOsSorted(SortedSet<Cell> allCellSorted) {
        this.cellDTOs = new ArrayList<>();
        fill(allCellSorted);
    }

    /**
     *
     * @param allCellSorted
     */
    private void fill(SortedSet<Cell> allCellSorted) {
        for (Cell c : allCellSorted) {
            cellDTOs.add(DTOCell.createFromCell(c));
        }
    }

    public NetworkAddress getObjectOriginAddress() {
        return objectOriginAddress;
    }
}
