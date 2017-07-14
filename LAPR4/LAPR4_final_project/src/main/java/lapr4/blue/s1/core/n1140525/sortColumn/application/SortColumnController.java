/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1140525.sortColumn.application;

import csheets.core.Address;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.util.SortedSet;
import lapr4.blue.s1.core.n1140525.sortColumn.domain.Sort;

/**
 *
 * @author 1140525
 */
public class SortColumnController {

    /**
     * @return the sortedColumn
     */
    public String[] getSortedColumn() {
        return sortedColumn;
    }

    private UIController ctrlUI;
    private Sort sort;
    private Cell[]notSortedColumn;
    private String[]sortedColumn;
    private Spreadsheet sheet;
    private int indexColumn;
    
    public SortColumnController(UIController ctrlUI) {
        this.ctrlUI=ctrlUI;
        this.sort=new Sort();
    }

    /**
     * Calls the methods in order so that it can sort by ascending order 
     * having all paramethers filled
     * @throws FormulaCompilationException 
     */
    public void ascendSorting() throws FormulaCompilationException{
        indexColumn();
        activeSpreadsheet();
        notSortedColumn();
        ascendingSort();
        
        sortSpreadsheet();
  
    }
    
    /**
     * Calls the methods in order so that it can sort by descending order 
     * having all paramethers filled
     * @throws FormulaCompilationException 
     */
    public void descendSorting() throws FormulaCompilationException{
        indexColumn();
        activeSpreadsheet();
        notSortedColumn();
        descendingSort();
        sortSpreadsheet();
  
    }

    public void ascendingSort() throws FormulaCompilationException {
        this.setSortedColumn(getSort().ascendingSort(getNotSortedColumn()));
    }
    public void descendingSort() throws FormulaCompilationException {
        this.setSortedColumn(getSort().descendingSort(getNotSortedColumn()));
    }
    
    public void indexColumn() {
        this.setIndexColumn(getCtrlUI().getActiveCell().getAddress().getColumn());
    }

    public void activeSpreadsheet() {
        this.setSheet(getCtrlUI().getActiveSpreadsheet());

    }
    /**
     * Fills the array with the cells of the column selected
     * in the order they are in the column (not sorted yet)
     */
    public void notSortedColumn(){
        
        Address a1;
        Address a2;
        int colInd=getCtrlUI().getActiveCell().getAddress().getColumn();
        int rowIndxend=getSheet().getRowCount();
        int rowIndxbeg=0;
        a1= new Address(colInd, rowIndxbeg);
        a2= new Address(colInd, rowIndxend);
        SortedSet<Cell> s=getSheet().getCells(a1, a2);   
        Cell[]arr = new Cell[s.size()];
        int i =0;
        for (Cell cell : s) {
            arr[i]=cell;
            i++;        
        }
        this.setNotSortedColumn(arr);
        /*getColumn doesnt work*/
        /*setNotSortedColumn(sheet.getColumn(this.getIndexColumn()));
        */
    }
    
    public void sortSpreadsheet() throws FormulaCompilationException {
        getSort().sortSpreadsheet(getSheet(), getIndexColumn(), getSortedColumn());
    }

    /**
     * @param notSortedColumn the notSortedColumn to set
     */
    public void setNotSortedColumn(Cell[] notSortedColumn) {
        this.notSortedColumn = notSortedColumn;
    }


    /**
     * @param indexColumn the indexColumn to set
     */
    public void setIndexColumn(int indexColumn) {
        this.indexColumn = indexColumn;
    }

    /**
     * @param sortedColumn the sortedColumn to set
     */
    public void setSortedColumn(String[] sortedColumn) {
        this.sortedColumn = sortedColumn;
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
     * @return the notSortedColumn
     */
    public Cell[] getNotSortedColumn() {
        return notSortedColumn;
    }

    /**
     * @return the sheet
     */
    public Spreadsheet getSheet() {
        return sheet;
    }

    /**
     * @return the indexColumn
     */
    public int getIndexColumn() {
        return indexColumn;
    }


    
}
