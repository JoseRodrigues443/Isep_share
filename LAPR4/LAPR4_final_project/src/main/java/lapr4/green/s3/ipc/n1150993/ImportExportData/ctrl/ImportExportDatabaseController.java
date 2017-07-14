/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150993.ImportExportData.ctrl;

import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.util.List;
import lapr4.green.s3.ipc.n1150993.ImportExportData.aplication.ImportExportTable;

/**
 *
 * @author 1150993
 */
public class ImportExportDatabaseController {
    /**
     * The user interface controller
     */
    private UIController uiController;
    
    /**
     * Instance of ImportExportTable
     */
    private ImportExportTable ieTable;
    
    /**
     * Instance of SpreadsheetTable
     */
    private SpreadsheetTable focusOwner;

    /**
     * Create an instance of ImportExportDatabaseController, receiving a interface controller as parameter.
     * @param uiController
     * @param focusOwner
     * @param connectionName The connection name
     * @param username The username of connection
     * @param password The password of connection
     */
    public ImportExportDatabaseController(UIController uiController,SpreadsheetTable focusOwner,String connectionName, String username, String password){
        this.uiController=uiController;
        this.focusOwner=focusOwner;
        this.ieTable=new ImportExportTable(uiController, connectionName, username, password);
    }
    
    
    /**
     * Verify if the connection is established.
     * 
     * @return true if estabilished and false otherwise
     */
    public boolean testConnection() {
        return ieTable.testConnection();
    }
    
    /**
     * Return all name table of database.
     * @return list of name of tables
     */
    public List<String> getTables(){
        return this.ieTable.getTables();
    }
    
    /**
     * Verify if tabel exists on database.
     * 
     * @param nameTabel
     * @return 
     */
    public boolean checkTable(String nameTabel){
        return this.ieTable.checkTable(nameTabel);
    }
    
    /**
     * Import the table of database to selected cells.
     * 
     * @param tableName Table to import
     * @return true if table is imported and false otherwise
     */
    public boolean importTable(String tableName){
        return this.ieTable.importTable(tableName, this.focusOwner);
    }
    
    /**
     * Export selected cells to database.
     * 
     * @param tableName The name of table 
     * @return true if table is exported and false otherwise
     */
    public boolean exportTable(String tableName){
       return this.ieTable.exportNewTable(tableName, this.focusOwner);
    }
    
    public boolean insertOnExistingTable(String tableName){
       return this.ieTable.setTable(tableName, focusOwner);
    }
}
