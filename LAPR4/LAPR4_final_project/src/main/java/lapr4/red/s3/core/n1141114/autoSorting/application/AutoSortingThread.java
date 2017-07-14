/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1141114.autoSorting.application;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.CellImpl;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ext.style.StylableCell;
import csheets.ext.style.StyleExtension;
import csheets.ui.ctrl.UIController;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.red.s3.core.n1141114.autoSorting.SortAlgorithms;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class AutoSortingThread extends Thread implements Observer {

    /**
     * Cell range selected by the user
     */
    private Cell cellRange[][];

    /**
     * UIController
     */
    private UIController uiController;

    /**
     * Class that contains all the sort algorithms
     */
    private SortAlgorithms sortAlgorithms;

    /**
     * Index of the selected column to sort
     */
    private int columnIndex;

    /**
     * Type of sort used to sort
     */
    private int sortType;

    /**
     * Default constructor
     *
     * @param cellRange - Cell range selected by the user
     * @param uiController - UIController
     */
    public AutoSortingThread(Cell cellRange[][], UIController uiController) {
        this.cellRange = cellRange;
        this.uiController = uiController;
        for (int i = 0; i < cellRange.length; i++) {
            for (int j = 0; j < cellRange[i].length; j++) {
                Cell cell = cellRange[i][j];
                CellImpl imp = (CellImpl) cell;
                imp.addObserver(this);
            }
        }
        this.sortAlgorithms = new SortAlgorithms();
        this.columnIndex = -1;
    }

    /**
     * Method run of the thread that sorts the cell content
     */
    @Override
    public void run() {
        System.out.println("ENTREI NO RUN");
        if (columnIndex != -1) {
            if (this.uiController.getSortingOrder()) {
                String[][] cell = this.sortAlgorithms.ascendingRangeSort(cellRange, columnIndex);
                try {
                    this.sortAlgorithms.sortSpreadSheetRangedCells(uiController.getActiveSpreadsheet(), cellRange, cell);
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(AutoSortingThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                String[][] cell = this.sortAlgorithms.descendingRangeSort(cellRange, columnIndex);
                try {
                    this.sortAlgorithms.sortSpreadSheetRangedCells(uiController.getActiveSpreadsheet(), cellRange, cell);
                } catch (FormulaCompilationException ex) {
                    Logger.getLogger(AutoSortingThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean checkDifferentCells(Cell[][] cellRange, String[][] cellRangeSorted) {
        for (int i = 0; i < cellRange.length; i++) {
            for (int j = 0; j < cellRange[0].length; j++) {
                if (cellRange[i][j].getContent() != cellRangeSorted[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Method that is called when one of the observers in the cell range are
     * called. Initiates the run method
     *
     * @param o - Observable
     * @param o1 - Object(in this case the addres of the cell to verify if it is
     * inside the cell range)
     */
    @Override
    public void update(Observable o, Object o1) {
        boolean cellFlag = false;
        int emptyFlag = 0;
        for (int i = 0; i < cellRange.length; i++) {
            for (int j = 0; j < cellRange[i].length; j++) {
                if (cellRange[i][j].getAddress() == (Address) o1) {
                    for (int k = 0; k < cellRange[i].length; k++) {
                        if (cellRange[i][k].getContent().isEmpty()) {
                            emptyFlag = 1;
                            break;
                        }
                    }
                    cellFlag = true;
                    break;
                }
            }
            if (cellFlag) {
                break;
            }
        }
        if (cellFlag && emptyFlag == 0) {
            columnIndex = this.uiController.getActivateColumn();
            if (columnIndex != -1) {
                for (int i = 0; i < cellRange[0].length; i++) {
                    if (cellRange[0][i].getAddress().getColumn() == columnIndex) {
                        columnIndex = i;
                        run();
                        break;
                    }
                }
            }
        }
    }
}
