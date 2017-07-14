/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1150710.network.shareCell;

import csheets.core.Cell;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.SortedSet;
import lapr4.black.s1.ipc.n2345678.comm.sharecells.CellDTO;
import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 * used to send all the select cells via TCP
 *
 * @author 1150710@isep.ipp.pt
 */
public class SelectedCells implements Serializable {

    private ArrayList<CellDTO> cellDTOs;
    private final NetworkAddress objectOriginAddress;

    public SelectedCells(SortedSet<Cell> allCellSorted, NetworkAddress objectOriginAddress) {
        cellDTOs = new ArrayList<>();
        this.objectOriginAddress = objectOriginAddress;
        fill(allCellSorted);
    }

    public ArrayList<CellDTO> getCellDTOs() {
        return cellDTOs;
    }

    public void setCellDTOs(ArrayList<CellDTO> cellDTOs) {
        this.cellDTOs = cellDTOs;
    }

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
            cellDTOs.add(new CellDTO(c.getAddress(), c.getContent()));
        }
    }

    public NetworkAddress getObjectOriginAddress() {
        return objectOriginAddress;
    }

  

}
