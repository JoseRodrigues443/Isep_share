/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150662.navigationWindow.ui;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.formula.Formula;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import lapr4.blue.s1.core.n1150662.navigationWindow.NavigationComment;
import lapr4.white.s1.core.n1234567.comments.CommentableCell;
import lapr4.white.s1.core.n1234567.comments.CommentsExtension;

/**
 *
 * @author bruno
 */
public class NavigationController {

    private UIController controller;

    private NavigationPanel uiPanel;

    private final Map<String, ArrayList<NavigationComment>> commentedCells;

    private final Map<String, Value> valueCells;
    
    private final Map<String,Formula> formulaCells;

    public NavigationController(UIController controller, NavigationPanel uiPanel) {
        this.controller = controller;
        this.uiPanel = uiPanel;
        commentedCells = new LinkedHashMap<>();
        valueCells = new LinkedHashMap<>();
        formulaCells = new LinkedHashMap<>();

    }

    public Map<String, ArrayList<NavigationComment>> getCommentsFromCells() {
        int numSpreadsheets;

        numSpreadsheets = this.controller.getActiveWorkbook().
                getSpreadsheetCount();

        for (int idSp = 0; idSp < numSpreadsheets; idSp++) {
            Spreadsheet sp = this.controller.getActiveWorkbook().
                    getSpreadsheet(idSp);
            int rows = sp.getRowCount();
            int columns = sp.getColumnCount();
            getAllComments(sp, rows, columns);
        }

        return commentedCells;
    }

    public void getAllComments(Spreadsheet sp, int rows, int columns) {
        String name = sp.getTitle();
        ArrayList<NavigationComment> array = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Cell cell = sp.getCell(column, row);
                CommentableCell cCell = (CommentableCell) cell.getExtension(CommentsExtension.NAME);

                if (cCell.hasComment()) {
                    array.add(new NavigationComment(cCell.toString(), cCell.getUserComment()));
                }

            }
        }
        this.commentedCells.put(name, array);

    }

    public Map<String, Value> getValueFromCells() {
        int numSpreadsheets;

        numSpreadsheets = this.controller.getActiveWorkbook().
                getSpreadsheetCount();

        for (int idSp = 0; idSp < numSpreadsheets; idSp++) {
            Spreadsheet sp = this.controller.getActiveWorkbook().
                    getSpreadsheet(idSp);
            int rows = sp.getRowCount();
            int columns = sp.getColumnCount();
            getAllValues(sp, rows, columns);
        }

        return valueCells;
    }

    public void getAllValues(Spreadsheet sp, int rows, int columns) {
        

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Cell cell = sp.getCell(column, row);
                CommentableCell cCell = (CommentableCell) cell.getExtension(CommentsExtension.NAME);

                if (cCell.hasComment()) {
                    this.valueCells.put(cell.getAddress().toString(),cell.getValue());
                }

            }
        }
        

    }
    
     public Map<String, Formula> getFormulaFromCells() {
        int numSpreadsheets;

        numSpreadsheets = this.controller.getActiveWorkbook().
                getSpreadsheetCount();

        for (int idSp = 0; idSp < numSpreadsheets; idSp++) {
            Spreadsheet sp = this.controller.getActiveWorkbook().
                    getSpreadsheet(idSp);
            int rows = sp.getRowCount();
            int columns = sp.getColumnCount();
            getAllFormulas(sp, rows, columns);
        }

        return formulaCells;
    }
     
      public void getAllFormulas(Spreadsheet sp, int rows, int columns) {
        

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Cell cell = sp.getCell(column, row);
                CommentableCell cCell = (CommentableCell) cell.getExtension(CommentsExtension.NAME);

                if (cCell.hasComment() && cell.getFormula() != null) {
                    this.formulaCells.put(cell.getAddress().toString(),cell.getFormula());
                }

            }
        }
        

    }
     
     

}
