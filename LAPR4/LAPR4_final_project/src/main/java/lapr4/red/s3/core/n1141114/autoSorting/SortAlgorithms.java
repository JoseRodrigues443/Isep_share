/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1141114.autoSorting;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class SortAlgorithms {

    /**
     * Ascending Sort Algortitm
     * @param cell - Cell range selected by the user
     * @param columnIndex - Active column to sort
     * @return Cell content sorted
     */
    public String[][] ascendingRangeSort(Cell[][] cell, int columnIndex) {
        int i, j, k, p;
        String[][] cellContent = new String[cell.length][cell[0].length];
        for (i = 0; i < cell.length; i++) {
            for (j = 0; j < cell[0].length; j++) {
                cellContent[i][j] = cell[i][j].getContent();
            }
        }

        for (k = 0; k < cellContent.length; k++) {
            for (p = k + 1; p < cellContent.length; p++) {
                /*if both values to be compared are numbers*/
                if (isNumeric(cellContent[k][columnIndex]) && isNumeric(cellContent[p][columnIndex])) {
                    double v1 = Double.parseDouble(cellContent[k][columnIndex].replace(",", "."));
                    double v2 = Double.parseDouble(cellContent[p][columnIndex].replace(",", "."));
                    if (v1 > v2) {
                        for (int l = 0; l < cellContent[0].length; l++) {
                            String aux = cellContent[p][l];
                            cellContent[p][l] = cellContent[k][l];
                            cellContent[k][l] = aux;
                        }
                    }
                    /*if one of the cells is not a number*/
                } else if (cellContent[k][columnIndex].compareTo(cellContent[p][columnIndex]) > 0) {
                    for (int l = 0; l < cellContent[0].length; l++) {
                        String aux = cellContent[p][l];
                        cellContent[p][l] = cellContent[k][l];
                        cellContent[k][l] = aux;
                    }
                }
            }
        }

        return cellContent;
    }

    /**
     * Descending Sort Algortitm
     * @param cell - Cell range selected by the user
     * @param columnIndex - Active column to sort
     * @return Cell content sorted
     */
    public String[][] descendingRangeSort(Cell[][] cell, int columnIndex) {
        int i, j, k, p;
        String[][] cellContent = new String[cell.length][cell[0].length];
        for (i = 0; i < cell.length; i++) {
            for (j = 0; j < cell[0].length; j++) {
                cellContent[i][j] = cell[i][j].getContent();
            }
        }

        for (k = 0; k < cellContent.length; k++) {
            for (p = k + 1; p < cellContent.length; p++) {
                /*if both values to be compared are numbers*/
                if (isNumeric(cellContent[k][columnIndex]) && isNumeric(cellContent[p][columnIndex])) {
                    double v1 = Double.parseDouble(cellContent[k][columnIndex].replace(",", "."));
                    double v2 = Double.parseDouble(cellContent[p][columnIndex].replace(",", "."));
                    if (v1 < v2) {
                        for (int l = 0; l < cellContent[0].length; l++) {
                            String aux = cellContent[p][l];
                            cellContent[p][l] = cellContent[k][l];
                            cellContent[k][l] = aux;
                        }
                    }
                    /*if one of the cells is not a number*/
                } else if (cellContent[k][columnIndex].compareTo(cellContent[p][columnIndex]) < 0) {
                    for (int l = 0; l < cellContent[0].length; l++) {
                        String aux = cellContent[p][l];
                        cellContent[p][l] = cellContent[k][l];
                        cellContent[k][l] = aux;
                    }
                }
            }
        }

        return cellContent;
    }

    /**
     * Updates the spreadsheet content with the selected range sorted
     * @param sheet - Active spreadsheet
     * @param cellRange - Cell range selected by the user
     * @param cell - Cell content sorted
     * @throws FormulaCompilationException 
     */
    public void sortSpreadSheetRangedCells(Spreadsheet sheet, Cell[][] cellRange, String[][] cell) throws FormulaCompilationException {

        for (int i = 0; i < cellRange.length; i++) {
            for (int j = 0; j < cellRange[i].length; j++) {
                String str = cell[i][j];
                sheet.getCell(cellRange[i][j].getAddress()).setContentSorted(str);
            }
        }
    }

    /**
     * Verifys if the cell content its a date
     * @param str - Cell content
     * @return true or false
     */
    private boolean isDate(String str) {
        if (str != null) {
            return str.matches("[0-9]{1,2}(/|-)[0-9]{1,2}(/|-)[0-9]{4}");
        }
        return false;
    }

    /**
     * Verifys if the cell content its a number
     * @param s - Cell content
     * @return true or false
     */
    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }
}
