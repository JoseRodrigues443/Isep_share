/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150825.workbookSearch.controller;

import csheets.core.Spreadsheet;
import java.util.List;
import lapr4.red.s3.core.n1150825.workbookSearch.domain.WorkbookSearch;

/**
 *
 * @author João Coelho
 */
public class WorkbookSearchController {
    
    private WorkbookSearch search;
    
    public WorkbookSearchController(){
        search=new WorkbookSearch();
    }

    /**
     *
     * Calls the method searchSpreadsheet that sees if the cells from the spreadsheet contain the text
     * 
     * @param activeSpreadsheet
     * @param text
     */
    public void searchSpreadsheet(Spreadsheet activeSpreadsheet, String text) {
        search.searchSpreadsheet(activeSpreadsheet, text);
    }

    /**
     *
     * Returns the results of the search
     * 
     * @return
     */
    public List<String> searchResults() {
        return search.searchResults();
    }
    
}
