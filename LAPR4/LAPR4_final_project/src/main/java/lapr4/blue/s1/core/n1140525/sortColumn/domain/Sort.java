/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1140525.sortColumn.domain;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;

/**
 *
 * @author 1140525
 */
public class Sort {
    
   /**
    * Sorts the spreadsheet (puts the sorted column in the spreadsheet) 
    * @param activeSpreadsheet
    * @param column_index
    * @param sortedColumn
    * @throws FormulaCompilationException 
    */
   public void sortSpreadsheet(Spreadsheet activeSpreadsheet, int column_index, String[] sortedColumn) throws FormulaCompilationException {
        int j = 0;
        for (int i = 0; i < sortedColumn.length; i++) {
            activeSpreadsheet.getCell(column_index, i).setContent("");
            if (sortedColumn[i] != null && !sortedColumn[i].equals("")) {
                activeSpreadsheet.getCell(column_index, j).setContent(sortedColumn[i]);
                j++;
            }
        }
    }
    
    
    /**
     * Returns the cellList in ascending order
     *
     * @param cellList the list of cells to ordered
     * @return array in ascending
     * @throws FormulaCompilationException
     */
    public String[] ascendingSort(Cell cellList[]) throws FormulaCompilationException {
        int i, j;
        String[] cellTemp = new String[cellList.length];
        String[] ret = new String[cellList.length];

        for (i = 0; i < cellList.length; i++) {
            cellTemp[i] = cellList[i].getContent();
        }

        for (i = 0; i < cellTemp.length; i++) {
            for (j = i + 1; j < cellTemp.length; j++) {
                /*If cells are both numbers*/
                if (isNumeric(cellTemp[i]) && isNumeric(cellTemp[j])) {
                    double n1 = Double.parseDouble(cellTemp[i].replace(",", "."));
                    double n2 = Double.parseDouble(cellTemp[j].replace(",", "."));
                    if (n1 > n2) {
                        String aux = cellTemp[i];
                        cellTemp[i] = cellTemp[j];
                        cellTemp[j] = aux;
                    }
                /*if one of the cells is not a number*/
                } else if (cellTemp[i].compareTo(cellTemp[j]) > 0) {
                    String aux = cellTemp[i];
                    cellTemp[i] = cellTemp[j];
                    cellTemp[j] = aux;
                }

            }
        }
        for (i = 0; i < cellTemp.length; i++) {
            if (cellTemp[i] != null) {
                ret[i] = cellTemp[i];
            }
        }

        return ret;
    }
      /**
     * Returns the cellList in descending order
     *
     * @param cellList the list of cells to be ordered
     * @return array in descending
     * @throws FormulaCompilationException
     */
    public String[] descendingSort(Cell cellList[]) throws FormulaCompilationException {
        int i, j;
        String[] celTemp = new String[cellList.length];
        String[] ret = new String[cellList.length];

        for (i = 0; i < cellList.length; i++) {
            celTemp[i] = cellList[i].getContent();
        }

        for (i = 0; i < celTemp.length; i++) {
            for (j = i + 1; j < celTemp.length; j++) {
                /*If cells are both numbers*/
                if (isNumeric(celTemp[i]) && isNumeric(celTemp[j])) {
                    double v1 = Double.parseDouble(celTemp[i].replace(",", "."));
                    double v2 = Double.parseDouble(celTemp[j].replace(",", "."));
                    if (v1 < v2) {
                        String aux = celTemp[i];
                        celTemp[i] = celTemp[j];
                        celTemp[j] = aux;
                    }
                 /*if one of the cells is not a number*/
                } else if (celTemp[i].compareTo(celTemp[j]) < 0) {
                    String aux = celTemp[i];
                    celTemp[i] = celTemp[j];
                    celTemp[j] = aux;
                }

            }
        }
        for (i = 0; i < celTemp.length; i++) {
            if (celTemp[i] != null) {
                ret[i] = celTemp[i];
            }
        }

        return ret;
    }
    
    public boolean isNumeric(String s) {  
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
    }  
}
