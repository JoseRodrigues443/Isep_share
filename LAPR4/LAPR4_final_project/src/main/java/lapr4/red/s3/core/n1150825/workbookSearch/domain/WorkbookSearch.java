/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150825.workbookSearch.domain;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author João Coelho
 */
public class WorkbookSearch {

    private List<String> searchResult;
    
    /**
     *
     * Sees if the list is empty and, if so, returns null, else it returns the 
     * searchResult
     * 
     * @return
     */
    public List<String> searchResults() {
        if(searchResult.size()==0){
            return null;
        }
        return searchResult;
    }

    /**
     *
     * Sees if any of the cells from the spreadsheet contain the text, be it as a 
     * value or as content, and puts a string with its address and content/value 
     * into the searchResults
     * 
     * @param activeSpreadsheet
     * @param text
     */
    public void searchSpreadsheet(Spreadsheet activeSpreadsheet, String text) {
        searchResult=new ArrayList<>();
        for(Cell cell: activeSpreadsheet){
           if(cell.getContent().contains(text)){
               searchResult.add("Address "+cell.getAddress()+" with content "+cell.getContent());
           }else if(cell.getValue().toString().contains(text)){
               searchResult.add("Address "+cell.getAddress()+" with content "+cell.getValue());
           }
        }
        
    }
    
}
