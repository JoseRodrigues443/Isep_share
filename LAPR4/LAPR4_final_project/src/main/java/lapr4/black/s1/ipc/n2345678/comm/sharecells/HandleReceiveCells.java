/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.black.s1.ipc.n2345678.comm.sharecells;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import lapr4.black.s1.ipc.n2345678.comm.CommHandler;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandrebraganca
 */
public class HandleReceiveCells implements CommHandler {

    private Object lastReceivedDTO=null;
    
    private CleanSheets cleanSheets;
    
    public HandleReceiveCells(CleanSheets cs) {
        cleanSheets=cs;
    }
        
    @Override
    public void handleDTO(Object dto, ObjectOutputStream outStream) {
        Logger.getLogger(HandleReceiveCells.class.getName()).log(Level.INFO, CleanSheets.getString("received_object"), dto.getClass().toString());
       
        RequestSharedCellsDTO shareDTO=(RequestSharedCellsDTO)dto;
        lastReceivedDTO=shareDTO;
        //Logger.getLogger(HandleReceiveCells.class.getName()).log(Level.INFO, CleanSheets.getString("message_received"), shareDTO..getMessage());
    
        // Get the name of the destination sheet. NOTE: need to deal also with the destination workbook!
        String sheetName=shareDTO.getSpreadsheetName();
        Logger.getLogger(HandleReceiveCells.class.getName()).log(Level.INFO, "Spreadsheet destination = {0}", sheetName);
        
        Spreadsheet dst=null;
        for (Spreadsheet ss: cleanSheets.getWorkbooks()[0]) {
            if (sheetName.compareTo(ss.getTitle())==0) dst=ss;
        }
        
        if (dst==null) {
            
        }
        else {
            // Update the cells
            for (CellDTO cellDTO: shareDTO.getCells()) {
                 Cell aCell=dst.getCell(cellDTO.getAddress());
                 try {
                     aCell.setContent(cellDTO.getContent());
                 } catch (FormulaCompilationException ex) {
                     Logger.getLogger(HandleReceiveCells.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
        }
         
//        // Lets reply
//        EchoDTO reply=new EchoDTO("Reply to "+hello.getMessage());
//        try {
//            outStream.writeObject(reply);
//        } catch (IOException ex) {
//            Logger.getLogger(EchoServerHandler.class.getName()).log(Level.SEVERE, null, ex);
//        }    
    }

    @Override
    public Object getLastReceivedDTO() {
        return lastReceivedDTO;
    }
    
}
