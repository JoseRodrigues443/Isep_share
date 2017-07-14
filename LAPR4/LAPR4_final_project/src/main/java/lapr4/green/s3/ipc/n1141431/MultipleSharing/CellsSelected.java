/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1141431.MultipleSharing;

import csheets.core.Cell;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.SortedSet;
import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 *
 * @author Pedro Oliveira 1141431
 */
public class CellsSelected implements Serializable {

    private String name;
    private static final String NAME = "AREA";
    private static int cont = 0;
    /**
     * Data transfer objects, the data to trasnfer
     */
    private ArrayList<DTOCell> cellDTOs;
    private Cell firstCell;
    private Cell lastCell;
    /**
     * The origin address
     */
    private final NetworkAddress objectOriginAddress;

    /**
     * Constructor
     *
     * @param allCellSorted
     * @param objectOriginAddress
     */
    public CellsSelected(SortedSet<Cell> allCellSorted, NetworkAddress objectOriginAddress) {
        name = NAME + " " + cont + "";
        cellDTOs = new ArrayList<>();
        this.objectOriginAddress = objectOriginAddress;
        fill(allCellSorted);
        cont++;
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
     *
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

    /**
     * @return the name
     */
    public String getNameArea() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the firstCell
     */
    public Cell getFirstCell() {
        return firstCell;
    }

    /**
     * @param firstCell the firstCell to set
     */
    public void setFirstCell(Cell firstCell) {
        this.firstCell = firstCell;
    }

    /**
     * @return the lastCell
     */
    public Cell getLastCell() {
        return lastCell;
    }

    /**
     * @param lastCell the lastCell to set
     */
    public void setLastCell(Cell lastCell) {
        this.lastCell = lastCell;
    }

   
}
