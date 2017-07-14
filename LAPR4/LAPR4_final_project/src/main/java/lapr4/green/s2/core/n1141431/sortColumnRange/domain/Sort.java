/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1141431.sortColumnRange.domain;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.util.Date;

/**
 *
 * @author Pedro Oliveira 1141431
 */
public class Sort {

    
    
//_--------------------------------------------------------------------------------sprint2--------------------------------------------------------------------
    /**
     * returns a matrix string of the range of cells in an ascending order
     *
     * @param cell
     * @return
     */
    public String[][] ascendingRangeSort(Cell[][] cell) {
        int i, j, k, p;
        String[][] cellContent = new String[cell.length][cell[0].length];
        String[][] new_cellsContent = new String[cell.length][cell[0].length];
        for (i = 0; i < cell.length; i++) {
            for (j = 0; j < cell[0].length; j++) {                            //puts  the content of cell in a temp variable
                cellContent[i][j] = cell[i][j].getContent();
            }
        }

        for (i = 0; i < cellContent[0].length; i++) {
            for (k = 0; k < cellContent.length; k++) {
                for (p = k + 1; p < cellContent.length; p++) {
                    /*if both values to be compared are numbers*/
                    if (isNumeric(cellContent[k][i]) && isNumeric(cellContent[p][i])) {
                        double v1 = Double.parseDouble(cellContent[k][i].replace(",", "."));
                        double v2 = Double.parseDouble(cellContent[p][i].replace(",", "."));
                        if (v1 > v2) {
                            String aux = cellContent[p][i];
                            cellContent[p][i] = cellContent[k][i];
                            cellContent[k][i] = aux;
                        }
                        /*if one of the cells is not a number*/
                    } else if (cellContent[k][i].compareTo(cellContent[p][i]) > 0) {
                        String aux = cellContent[p][i];
                        cellContent[p][i] = cellContent[k][i];
                        cellContent[k][i] = aux;

                    }
                }
            }
        }

        for (i = 0; i < cellContent.length; i++) {
            for (j = 0; j < cellContent[0].length; j++) {
                if (cellContent[i][j] != null) {
                    new_cellsContent[i][j] = cellContent[i][j];     //puts the temp cell that is orded in a new one to send and ignores blank spaces
                }
            }
        }
        return new_cellsContent;
    }
    /**
     * returns a matrix string of the range of cells in a descended sorted
     *
     * @param cell
     * @return
     */
    public String[][] descendingRangeSort(Cell[][] cell) {
        int i, j, k, p;
        String[][] cellContent = new String[cell.length][cell[0].length];
        String[][] new_cellsContent = new String[cell.length][cell[0].length];

        for (i = 0; i < cell.length; i++) {
            for (j = 0; j < cell[0].length; j++) {                            //puts  the content of cell in a temp variable
                cellContent[i][j] = cell[i][j].getContent();
            }
        }
        for (i = 0; i < cellContent[0].length; i++) {
            for (k = 0; k < cellContent.length; k++) {
                for (p = k + 1; p < cellContent.length; p++) {
                    /*if both values to be compared are numbers*/
                    if (isNumeric(cellContent[k][i]) && isNumeric(cellContent[p][i])) {
                        double v1 = Double.parseDouble(cellContent[k][i].replace(",", "."));
                        double v2 = Double.parseDouble(cellContent[p][i].replace(",", "."));
                        if (v1 < v2) {
                            String aux = cellContent[k][i];
                            cellContent[k][i] = cellContent[p][i];
                            cellContent[p][i] = aux;
                        }
                        /*if one is not a numeric*/
                    } else if (cellContent[k][i].compareTo(cellContent[p][i]) < 0) {
                        String aux = cellContent[k][i];
                        cellContent[k][i] = cellContent[p][i];
                        cellContent[p][i] = aux;

                    }
                }
            }
        }

        for (i = 0; i < cellContent.length; i++) {
            for (j = 0; j < cellContent[0].length; j++) {
                if (cellContent[i][j] != null) {
                    new_cellsContent[i][j] = cellContent[i][j];     //puts the temp cell that is orded in a new one to send and ignores blank spaces
                }
            }
        }
        return new_cellsContent;
    }

    /**
     * puts the sorted values back in the spreadsheet
     *
     * @param sheet
     * @param beginning
     * @param end
     * @param cell
     *
     */
    public void sortSpreadSheetRangedCells(Spreadsheet sheet, Cell beginning, Cell end, String[][] cell) throws FormulaCompilationException {
        int beginRow = beginning.getAddress().getRow(); //gives the statrting row
        int beginColumn = beginning.getAddress().getColumn();// gives the column of the first cell
        int row = end.getAddress().getRow() - beginRow + 1; //gives the number of rows
        int column = end.getAddress().getColumn() - beginColumn + 1;

        for (int i = 0; i < column; i++) { //  goes to a column and then through all the rows
            for (int j = 0; j < row; j++) {

                String str = cell[i][j];
                    sheet.getCell(beginRow + j, beginColumn + i).setContent(str);
            }
        }
    }

    /**
     * Checks a given str has the structure of a date
     *
     * @param str the string that will be tested
     * @return true if has the structure of a date.
     */
    private boolean isDate(String str) {
        if (str != null) {
            return str.matches("[0-9]{1,2}(/|-)[0-9]{1,2}(/|-)[0-9]{4}");
        }
        return false;
    }

    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    /**
     *
     * @param str
     * @return
     */
    private Date convertToDate(String str) {
        String aux[] = str.split("-");
        int day = Integer.parseInt(aux[0]);
        int month = Integer.parseInt(aux[1]);
        int year = Integer.parseInt(aux[2]);
        Date dt = new Date(day, month, year);
        return dt;
    }

}
