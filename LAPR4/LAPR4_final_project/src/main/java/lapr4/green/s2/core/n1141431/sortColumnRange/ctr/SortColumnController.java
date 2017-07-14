
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1141431.sortColumnRange.ctr;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.util.SortedSet;
import lapr4.green.s2.core.n1141431.sortColumnRange.domain.Sort;

/**
 *
 * @author Pedro Oliveira 1141431
 */
public class SortColumnController extends FocusOwnerAction {

    private Cell begining;
    private Cell end;

    /**
     * @return the sortedColumn
     */
    public String[] getSortedColumn() {
        return sortedColumn;
    }

    /**
     * Variable responsible for holding the selected cells in the
     * SpreadsheetTable
     */
    private Cell[][] selectedCells;
    private UIController ctrlUI;
    private Sort sort;
    private Cell[] notSortedColumn;
    private String[] sortedColumn;
    private Spreadsheet sheet;
    private int indexColumn;

    public SortColumnController(UIController ctrlUI) {
        this.ctrlUI = ctrlUI;
        this.sort = new Sort();
        this.sheet = ctrlUI.getActiveSpreadsheet();
    }

//--------------------------------------sprint2--------------------------
    /**
     * method that return the chosen range of cells en an matrix
     *
     * @param beginning
     * @param end
     * @return
     */
    public Cell[][] chosenRange(Cell beginning, Cell end) {

        int beginRow = beginning.getAddress().getRow(); //gives the statrting row
        int beginColumn = beginning.getAddress().getColumn();// gives the column of the first cell
        int row = end.getAddress().getRow() - beginRow + 1; //gives the number of rows
        int column = end.getAddress().getColumn() - beginColumn + 1;
        Cell[][] cell = new Cell[row][column];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                    cell[i][j] = getSheet().getCell(beginRow + j, beginColumn + i);
                }
            }
        return cell;
    }

    /**
     * gets the cells of the adress introduced by the user
     *
     * @param range
     * @return
     */
    public Cell getCellFromRange(String range) {
        String[] split = range.trim().split("-");
        int row = Integer.parseInt(split[0]) - 1;
        int column = Integer.parseInt(split[1]) - 1;

        return ctrlUI.getActiveSpreadsheet().getCell(column, row);
    }

    /**
     * returns a matrix string of the range of cells in an ascending order
     *
     * @param cell
     * @return
     */
    public String[][] ascendingRangeSort(Cell[][] cell) {

        return getSort().ascendingRangeSort(cell);
    }

    /**
     * returns a matrix string of the range of cells in an descending order
     *
     * @param cell
     * @return
     */
    public String[][] descendingRangeSort(Cell[][] cell) {

        return getSort().descendingRangeSort(cell);
    }

    /**
     * puts in the spreadsheet the sorted cells selected
     *
     * @param begining
     * @param end
     * @param cell
     */
    public void sortSpreadSheetRangedCells(Cell begining, Cell end, String[][] cell) throws FormulaCompilationException {
        getSort().sortSpreadSheetRangedCells(getSheet(), begining, end, cell);
    }
//_------------------------------------------------------------------------------

    public void activeSpreadsheet() {
        this.setSheet(getCtrlUI().getActiveSpreadsheet());

    }

    /**
     * @param sheet the sheet to set
     */
    public void setSheet(Spreadsheet sheet) {
        this.sheet = sheet;
    }

    /**
     * @return the ctrlUI
     */
    public UIController getCtrlUI() {
        return ctrlUI;
    }

    /**
     * @return the sort
     */
    public Sort getSort() {
        return sort;
    }

    /**
     * @return the sheet
     */
    public Spreadsheet getSheet() {
        return sheet;
    }

    @Override
    protected String getName() {
        return "sort v2";
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * @return the begining
     */
    public Cell getBegining() {
        return begining;
    }

    /**
     * @param begining the begining to set
     */
    public void setBegining(Cell begining) {
        this.begining = begining;
    }

    /**
     * @return the end
     */
    public Cell getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Cell end) {
        this.end = end;
    }

}
