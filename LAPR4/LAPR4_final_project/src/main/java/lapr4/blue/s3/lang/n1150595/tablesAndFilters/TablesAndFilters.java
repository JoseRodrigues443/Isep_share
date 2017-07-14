/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1150595.tablesAndFilters;

import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
public class TablesAndFilters {

    /**
     * Cells that aren't part of the header
     */
    private Cell[][] withoutHeaderContent;

    /**
     * Header cells
     */
    private Cell[] header;

    /**
     * Content of all table
     */
    private Cell[][] content;

    /**
     * Name of the table
     */
    private String name;

    /**
     * Filters being used
     */
    private List<String> filters;

    /**
     * Actual filter
     */
    private String actualFilter;

    /**
     * Inicial content of the table
     */
    private String[][] inicialContent;

    /**
     * Iniciates the table state
     *
     * @param name the name of the table
     */
    public TablesAndFilters(String name) {
        this.name = name;
        this.filters = new ArrayList<>();
    }

    /**
     * Iniciates the table state
     */
    public TablesAndFilters() {
        this.filters = new ArrayList<>();
    }

    /**
     * Returns the content of the table, minus the header
     *
     * @return table without header
     */
    public Cell[][] withoutHeaderContent() {
        return withoutHeaderContent;
    }

    /**
     * Modifies the content of the table, minus the header
     *
     * @param withoutHeaderContent table without header
     */
    public void setWithoutHeaderContent(Cell[][] withoutHeaderContent) {
        this.withoutHeaderContent = withoutHeaderContent;
    }

    /**
     * Returns the header
     *
     * @return the header
     */
    public Cell[] header() {
        return header;
    }

    /**
     * Modifies the header
     *
     * @param header the new header
     */
    public void setHeader(Cell[] header) {
        this.header = header;
    }

    /**
     * Returns the content of the table
     *
     * @return content
     */
    public Cell[][] content() {
        return content;
    }

    /**
     * Modifies the content of the table
     *
     * @param content the new content of the table
     */
    public void setContent(Cell[][] content) {
        this.content = content;
    }

    /**
     * Returns the name of the table
     *
     * @return name of the table
     */
    public String name() {
        return name;
    }

    /**
     * Modifies the name of the table
     *
     * @param name the new name of the table
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the used filters
     *
     * @return the used filters
     */
    public List<String> filters() {
        return filters;
    }

    /**
     * Modifies the used filters
     *
     * @param filters the new used filters
     */
    public void setFilters(List<String> filters) {
        this.filters = filters;
    }

    /**
     * Returns the actual filter
     *
     * @return the actual filter
     */
    public String actualFilter() {
        return actualFilter;
    }

    /**
     * Modifies the actual filter
     *
     * @param actualFilter the new actual filter
     */
    public void setActualFilter(String actualFilter) {
        this.actualFilter = actualFilter;
    }

    /**
     * Returns the inicial content
     *
     * @return the inicial content
     */
    public String[][] inicialContent() {
        return inicialContent;
    }

    /**
     * Sets the inicial content
     *
     * @param inicialContent the inicial content
     */
    public void setInicialContent(String[][] inicialContent) {
        this.inicialContent = inicialContent;
    }

    /**
     * Adds a filter to the filters list
     *
     * @param filter the new filter
     */
    public void addFilter(String filter) {
        this.filters.add(filter);
    }

    /**
     * Removes a filter of the list
     *
     * @param filter to remove filter
     */
    public void removeFilter(String filter) {
        this.filters.remove(filter);
    }

    /**
     * Resets the content of the table
     *
     * @throws FormulaCompilationException
     */
    public void resetContent() throws FormulaCompilationException {
        for (int i = 0; i < this.content.length; i++) {
            for (int j = 0; j < this.content[i].length; j++) {
                this.content[i][j].setContent(this.inicialContent[i][j]);
            }
        }
    }

}
