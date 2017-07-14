/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package csheets.core;

import csheets.core.formula.lang.Macro;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lapr4.blue.s3.lang.n1130679.arrayVariableEditor.Variable;
import lapr4.red.s2.lang.n1141114.globalVariables.domain.GlobalVariableList;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariable;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariableList;

/**
 * A workbook which can contain several spreadsheets.
 *
 * @author Einar Pehrson
 */
public class Workbook implements Iterable<Spreadsheet>, Serializable {

    /**
     * The unique version identifier used for serialization
     */
    private static final long serialVersionUID = -6324252462576447242L;

    /**
     * The spreadsheets of which the workbook consists
     */
    private List<Spreadsheet> spreadsheets = new ArrayList<Spreadsheet>();

    /**
     * Temporary variables list of the workbook
     */
    private TemporaryVariableList tempVariables = new TemporaryVariableList();

    /**
     * Global variables list of the workbook
     */
    private GlobalVariableList globalVariablesList = new GlobalVariableList();

    /**
     * contains all variables
     */
    public ArrayList<Variable> variableList = new ArrayList<>();

    private Map<String, Macro> macroMap = new TreeMap<>();

    /**
     * The cell listeners that have been registered on the cell
     */
    private transient List<WorkbookListener> listeners
            = new ArrayList<WorkbookListener>();

    /**
     * The number of spreadsheets that have been created in the workbook
     */
    private int createdSpreadsheets;

    /**
     * Creates a new empty workbook.
     */
    public Workbook() {
    }

    /**
     * Creates a new workbook, which initially contains the given number of
     * blank spreadsheets.
     *
     * @param sheets the number of sheets to create initially
     */
    public Workbook(int sheets) {
        for (int i = 0; i < sheets; i++) {
            spreadsheets.add(new SpreadsheetImpl(this,
                    getNextSpreadsheetTitle()));
        }
    }

    /**
     * Creates a new workbook, using the given content matrix to create
     * spreadsheets initially.
     *
     * @param contents the content matrices to use when creating spreadsheets
     */
    public Workbook(String[][]... contents) {
        for (String[][] content : contents) {
            spreadsheets.add(new SpreadsheetImpl(this,
                    getNextSpreadsheetTitle(), content));
        }
    }

    /**
     * Adds a blank spreadsheet to the end of the workbook.
     */
    public void addSpreadsheet() {
        Spreadsheet spreadsheet = new SpreadsheetImpl(this,
                getNextSpreadsheetTitle());
        spreadsheets.add(spreadsheet);
        fireSpreadsheetInserted(spreadsheet, spreadsheets.size() - 1);
    }

    /**
     * Adds a new spreadsheet to the workbook, in which cells are initialized
     * with data from the given content matrix.
     *
     * @param content the contents of the cells in the spreadsheet
     */
    public void addSpreadsheet(String[][] content) {
        Spreadsheet spreadsheet = new SpreadsheetImpl(this,
                getNextSpreadsheetTitle(), content);
        spreadsheets.add(spreadsheet);
        fireSpreadsheetInserted(spreadsheet, spreadsheets.size() - 1);
    }

    /**
     * Returns the title to be used for the next spreadsheet added.
     *
     * @return the title to be used for the next spreadsheet added
     */
    private String getNextSpreadsheetTitle() {
        return SpreadsheetImpl.BASE_TITLE + " " + (createdSpreadsheets++ + 1);
    }

    /**
     * Adds a new blank spreadsheet to the workbook.
     *
     * @param spreadsheet spreadsheet
     */
    public void removeSpreadsheet(Spreadsheet spreadsheet) {
        spreadsheets.remove(spreadsheet);
        // Remove references to the spreadsheet in remaining spreadsheets!
        fireSpreadsheetRemoved(spreadsheet);
    }

    /**
     * Returns the spreadsheet at the given index.
     *
     * @param index the index of the spreadsheet in the workbook
     * @return the spreadsheet at the given index
     * @throws IndexOutOfBoundsException if the index is out of range (index
     * less than 0 or index greater or equal |spreadsheets|)
     */
    public Spreadsheet getSpreadsheet(int index) throws IndexOutOfBoundsException {
        return spreadsheets.get(index);
    }

    /**
     * Returns the number of spreadsheets in the the workbook.
     *
     * @return the number of spreadsheets in the the workbook
     */
    public int getSpreadsheetCount() {
        return spreadsheets.size();
    }

    public ArrayList<Variable> getVariablesList() {
        return variableList;
    }

    /**
     * Returns an iterator over the spreadsheets in the workbook.
     *
     * @return an iterator over the spreadsheets in the workbook
     */
    public Iterator<Spreadsheet> iterator() {
        return spreadsheets.iterator();
    }

    /*
 * EVENT HANDLING
     */
    /**
     * Registers the given listener on the workbook.
     *
     * @param listener the listener to be added
     */
    public void addWorkbookListener(WorkbookListener listener) {
        listeners.add(listener);
    }

    /**
     * Removes the given listener from the workbook.
     *
     * @param listener the listener to be removed
     */
    public void removeWorkbookListener(WorkbookListener listener) {
        listeners.remove(listener);
    }

    /**
     * Returns the listeners that have been registered on the workbook.
     *
     * @return the listeners that have been registered on the workbook
     */
    public WorkbookListener[] getWorkbookListeners() {
        return listeners.toArray(new WorkbookListener[listeners.size()]);
    }

    /**
     * Notifies all registered listeners that a spreadsheet has been inserted.
     *
     * @param spreadsheet the spreadsheet that was inserted
     * @param index the index at which the spreadsheet was inserted
     */
    private void fireSpreadsheetInserted(Spreadsheet spreadsheet, int index) {
        for (WorkbookListener listener : listeners) {
            listener.spreadsheetInserted(spreadsheet, index);
        }
    }

    /**
     * Notifies all registered listeners that a spreadsheet has been removed.
     *
     * @param spreadsheet the spreadsheet that was removed
     */
    private void fireSpreadsheetRemoved(Spreadsheet spreadsheet) {
        for (WorkbookListener listener : listeners) {
            listener.spreadsheetRemoved(spreadsheet);
        }
    }

    /**
     * Notifies all registered listeners that a spreadsheet has been renamed.
     *
     * @param spreadsheet the spreadsheet that was renamed
     */
    @SuppressWarnings("unused")
    private void fireSpreadsheetRenamed(Spreadsheet spreadsheet) {
        for (WorkbookListener listener : listeners) {
            listener.spreadsheetRenamed(spreadsheet);
        }
    }

    /*
 * GENERAL
     */
    /**
     * Customizes deserialization by recreating the listener list.
     *
     * @param stream the object input stream from which the object is to be read
     * @throws IOException If any of the usual Input/Output related exceptions
     * occur
     * @throws ClassNotFoundException If the class of a serialized object cannot
     * be found.
     */
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        listeners = new ArrayList<WorkbookListener>();
    }

    /**
     * Returns the list of temporary variables in the workbook
     *
     * @return temporaryVariableList
     */
    public TemporaryVariableList findTemporaryVariable() {
        return tempVariables;
    }

    /**
     * Returns the list of global variables in the workbook
     *
     * @return globalVariableList
     */
    public GlobalVariableList findGlobalVariables() {
        return globalVariablesList;
    }

    /**
     * Adds a new macro to the macroMap
     *
     * @param name
     * @param macro
     */
    public void addMacro(String name, Macro macro) {
        this.macroMap.put(name, macro);
    }

    /**
     * Removes Macro from the macroMap
     *
     * @param name
     */
    public void removeMacro(String name) {
        this.macroMap.remove(name);
    }

    /**
     * Returns a treemap with name and corresponding macro
     *
     * @return
     */
    public Map<String, Macro> macroMap() {
        return this.macroMap;
    }

    public void addVariable(Variable variable) {
        if (findVar(variable.getSheet(), variable.getVariableName()) == null) {
            variableList.add(variable);
        } else {
            for (Variable var : variableList) {
                if (var.getVariableName().equalsIgnoreCase(variable.getVariableName())) {
                    variableList.set(variableList.indexOf(var), variable);
                }
            }
        }
    }

    public void removeVariable(Variable variable) {
        for (Variable var : variableList) {
            if (var.getVariableName().equalsIgnoreCase(variable.getVariableName())) {
                variableList.remove(variableList.indexOf(var));
            }
        }
    }

    public void createVariable(String variableName, int position, Value variableValue, Spreadsheet sheet) {
        Variable var = findVar(sheet, variableName);
        if (var == null) {
            var = new Variable(variableName, position, variableValue, sheet);
            addVariable(var);
        } else {
            var.setValues(variableValue, position);

        }
    }

    public Variable findVar(Spreadsheet spreadsheet, String variable) {

        for (Variable var : variableList) {
            if (var.getVariableName().equalsIgnoreCase(variable)) {
                return var;
            }
        }
        return null;
    }
}
