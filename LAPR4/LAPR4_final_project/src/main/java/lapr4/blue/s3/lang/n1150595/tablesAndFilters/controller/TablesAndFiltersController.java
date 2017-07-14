/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1150595.tablesAndFilters.controller;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import csheets.core.formula.Formula;
import csheets.core.formula.Function;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.compiler.FormulaCompiler;
import csheets.core.formula.lang.Language;
import csheets.ui.ctrl.FocusOwnerAction;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.blue.s3.lang.n1150595.tablesAndFilters.TablesAndFilters;
import lapr4.blue.s3.lang.n1150595.tablesAndFilters.ui.TablesAndFiltersSideBar;

/**
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
public class TablesAndFiltersController extends FocusOwnerAction {

    /**
     * The controller
     */
    private static TablesAndFiltersController controller = new TablesAndFiltersController();

    /**
     * Tables and Filters side bar
     */
    private TablesAndFiltersSideBar sideBar;

    /**
     * Actual table
     */
    private TablesAndFilters actualTable;

    /**
     * List of tables
     */
    private List<TablesAndFilters> tablesAndFilters = new ArrayList<>();

    /**
     * List of available functions
     */
    private List<Function> functions = new ArrayList<>();

    /**
     * Editable
     */
    private boolean edit = false;

    /**
     * Cell listener
     */
    private CellListener cellListener;

    /**
     * Base function String
     */
    private String baseFunction;
    /**
     * Syntax String
     */
    private String syntax;
    /**
     * List of parameters
     */
    private String[] parameters;
    /**
     * Separator String
     */
    private String separator;

    /**
     * Empty constructor
     */
    protected TablesAndFiltersController() {
    }

    /**
     * Returns the controller
     *
     * @return the controller
     */
    public static TablesAndFiltersController controller() {
        return controller;
    }

    /**
     * Sets the side bar
     *
     * @param sideBar the side bar
     */
    public void setSideBar(TablesAndFiltersSideBar sideBar) {
        this.sideBar = sideBar;
    }

    /**
     * Returns the list of tables
     *
     * @return the list of tables
     */
    public List<TablesAndFilters> tablesAndFilters() {
        return tablesAndFilters;
    }

    /**
     * Returns the actual table
     *
     * @return the actual table
     */
    public TablesAndFilters actualTable() {
        return actualTable;
    }

    /**
     * Modifies the actual table
     *
     * @param actualTable the actual table
     */
    public void setActualTable(TablesAndFilters actualTable) {
        this.actualTable = actualTable;
    }

    /**
     * Sets the editable
     *
     * @param edit editable
     */
    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    /**
     * Returns the list of available functions
     *
     * @return list of functions
     */
    public List<Function> functions() {
        return functions;
    }

    /**
     * Returns the syntax string
     *
     * @return the syntax
     */
    public String syntax() {
        return syntax;
    }

    /**
     * Returns the base function string
     *
     * @return the base function
     */
    public String baseFunction() {
        return baseFunction;
    }

    /**
     * Updates the functions
     */
    public void updateFunctions() {
        for (Function f : Language.getInstance().getFunctions()) {
            if (f.getDescription().contains("true") || f.getDescription().contains("false") || f.getDescription().contains("boolean")) {

                if (!f.getIdentifier().equals("TRUE") && !f.getIdentifier().equals("FALSE")) {
                    functions.add(f);
                }

            }
        }
    }

    /**
     * Validates the selected cells
     *
     * @return if the cells are valid or not
     */
    public boolean validateCells() {
        Cell[][] selectedCells = focusOwner.getSelectedCells();
        for (int row = 0; row < selectedCells.length; row++) {
            for (int column = 0; column < selectedCells[row].length; column++) {
                if (selectedCells[row][column] == null
                        || selectedCells[row][column].getValue().equals(new Value())
                        || selectedCells[row][column].getContent().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Validates the selected cells that will be the constitution of a table
     *
     * @return if the selected cells are valid or not
     */
    public boolean validateSelectedCells() {
        if (focusOwner.getSelectedRowCount() > 1 && focusOwner.getSelectedColumnCount() > 0) {
            boolean b = validateCells();
            if (b == true) {
                Cell[][] selectedCells = focusOwner.getSelectedCells();
                for (int i = 0; i < 10; i++) {
                    cellListener = new CellListener() {

                        @Override
                        public void valueChanged(Cell cell) {
                            if (edit == false) {
                                for (int row = 0; row < actualTable().content().length; row++) {
                                    for (int column = 0; column < actualTable().content()[row].length; column++) {
                                        if (cell.getAddress().equals(actualTable().content()[row][column].getAddress())) {
                                            try {
                                                cell.setContent(actualTable().inicialContent()[row][column]);
                                            } catch (FormulaCompilationException ex) {
                                                Logger.getLogger(TablesAndFiltersController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                }
                            } else {
                                try {
                                    cell.setContent(cell.getContent());
                                } catch (FormulaCompilationException ex) {
                                    Logger.getLogger(TablesAndFiltersController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }

                        @Override
                        public void contentChanged(Cell cell) {
                            if (edit == false) {
                                for (int row = 0; row < actualTable().content().length; row++) {
                                    for (int column = 0; column < actualTable().content()[row].length; column++) {
                                        if (cell.getAddress().equals(actualTable().content()[row][column].getAddress())) {
                                            try {
                                                cell.setContent(actualTable().inicialContent()[row][column]);
                                            } catch (FormulaCompilationException ex) {
                                                Logger.getLogger(TablesAndFiltersController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    }
                                }
                            } else {
                                try {
                                    cell.setContent(cell.getContent());
                                } catch (FormulaCompilationException ex) {
                                    Logger.getLogger(TablesAndFiltersController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }

                        @Override
                        public void dependentsChanged(Cell cell) {
                        }

                        @Override
                        public void cellCleared(Cell cell) {
                            if (edit == true) {
                                try {
                                    cell.setContent("");
                                } catch (FormulaCompilationException ex) {
                                    Logger.getLogger(TablesAndFiltersController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }

                        @Override
                        public void cellCopied(Cell cell, Cell source) {
                        }
                    };
                }
                for (int row = 0; row < selectedCells.length; row++) {
                    for (int column = 0; column < selectedCells[row].length; column++) {
                        selectedCells[row][column].addCellListener(cellListener);
                    }
                }
                TablesAndFilters t = new TablesAndFilters();
                t.setContent(selectedCells);
                Cell[] header = new Cell[focusOwner.getSelectedColumnCount()];
                Cell[][] content = new Cell[focusOwner.getSelectedRowCount() - 1][focusOwner.getSelectedColumnCount()];
                String[][] inicialContent = new String[focusOwner.getSelectedRowCount()][focusOwner.getSelectedColumnCount()];
                for (int row = 0; row < selectedCells.length; row++) {
                    for (int column = 0; column < selectedCells[row].length; column++) {
                        inicialContent[row][column] = selectedCells[row][column].getContent();
                        if (row == 0) {
                            header[column] = selectedCells[row][column];
                        } else {
                            content[row - 1][column] = selectedCells[row][column];
                        }
                    }
                }
                t.setHeader(header);
                t.setWithoutHeaderContent(content);
                t.setInicialContent(inicialContent);
                tablesAndFilters.add(t);
                setActualTable(t);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * Updates the table content
     *
     * @param name name of the table
     * @param cells cells that correspond to the content
     */
    public void updateContent(String name, Cell[][] cells) {
        if (name != null && !name.equals("")) {
            this.actualTable.setName(name);
        }
        if (cells != null && cells.length > 0) {
            this.actualTable.setContent(cells);
        }
        this.sideBar.addTable(this.actualTable);
        this.tablesAndFilters.add(actualTable);
    }

    /**
     * Select a formula
     *
     * @param index index of the function
     */
    public void selectFunction(int index) {
        this.baseFunction = functions.get(index).getIdentifier();
        this.parameters = new String[functions.get(index).getParameters().length];
        this.syntax = functions.get(index).getSyntax();
    }

    /**
     * Returns a table by the name
     *
     * @param name the name of the table
     * @return the table
     */
    public TablesAndFilters tableByName(String name) {
        for (TablesAndFilters table : this.tablesAndFilters) {
            if (table.name().equals(name)) {
                return table;
            }
        }
        return null;
    }

    /**
     * Apply filter to a table
     *
     * @param text the filter text
     * @param b
     * @return the formula
     * @throws IllegalValueTypeException
     * @throws FormulaCompilationException
     */
    public Formula applyFilter(String text, boolean b) throws IllegalValueTypeException, FormulaCompilationException {
        if (text.contains(";")) {
            separator = ";";
        } else if (text.contains(",")) {
            separator = ",";
        }
        Formula f = null;
        Cell[][] content = this.actualTable.withoutHeaderContent();
        for (int row = 0; row < content.length; row++) {
            Cell createdCell = null;
            String formula = null;
            if (b == true) {
                formula = formula(row, text, createdCell, parameters.length, b);
            } else if (b == false) {
                formula = formula(row, text, createdCell, 1, b);
                formula = "=" + formula;
            }
            FormulaCompiler fc = FormulaCompiler.getInstance();
            if (formula != null) {
                f = fc.compile(createdCell, formula);
                Value v = f.evaluate();
                String result = v.toString();
                if (result.equals("FALSE")) {
                    this.edit = true;
                    for (int column = 0; column < content[row].length; column++) {
                        content[row][column].clear();
                    }
                    this.edit = false;
                }
            }
        }
        return f;
    }

    /**
     * Returns the formula
     *
     * @param row
     * @param text
     * @param createdCell
     * @param length
     * @param b
     * @return
     */
    private String formula(int row, String text, Cell createdCell, int length, boolean b) {
        String formula = "";
        if (b == true) {
            formula = "=" + baseFunction + "(";
        }
        for (int i = 0; i < length; i++) {
            String[] separatedText = new String[length];
            if (separator == null) {
                separatedText[i] = text;
            } else {
                separatedText = text.split(separator);
            }
            if (separatedText[i].startsWith("_col")) {
                int start = separatedText[i].indexOf("[");
                int finish = separatedText[i].indexOf("]");
                String p = separatedText[i].substring(start + 1, finish);
                if (p.matches("[0-9]+")) {
                    try {
                        createdCell = this.actualTable.withoutHeaderContent()[row][Integer.parseInt(p)];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(null, "Column doesn't exist!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                    if (createdCell.getContent().matches("[a-zA-Z]+")) {
                        formula += "\"" + createdCell.getContent() + "\"" + separatedText[i].substring(finish + 1);
                    } else {
                        formula += createdCell.getContent() + separatedText[i].substring(finish + 1);
                    }
                } else if (p.matches("\"[a-zA-Z]+\"")) {
                    p = p.substring(p.indexOf("\"", 0) + 1, p.indexOf("\"", 1));
                    Cell[] header = this.actualTable.header();
                    for (int h = 0; h < header.length; h++) {
                        if (header[h].getContent().equals(p)) {
                            createdCell = this.actualTable.withoutHeaderContent()[row][h];
                            if (createdCell.getContent().matches("[a-zA-Z]+")) {
                                formula += "\"" + createdCell.getContent() + "\"" + separatedText[i].substring(finish + 1);
                            } else {
                                formula += createdCell.getContent() + separatedText[i].substring(finish + 1);
                            }
                        }
                    }
                }
            } else if (separatedText[i].startsWith("_")) {
                return null;
            } else {
                formula += separatedText[i];
            }

            if (i != length - 1) {
                formula += " " + separator + " ";
            }
        }
        if (b == true) {
            formula += ")";
        }
        return formula;
    }

    @Override
    protected String getName() {
        return "Tables and Filters Controller";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
