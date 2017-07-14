/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150993.ImportExportData.aplication;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 1150993
 */
public class ImportExportTable {

    /**
     * The user interface controller
     */
    private final UIController uiController;

    /**
     * The selected cells by user
     */
    private Cell[][] cells;

    /**
     * The username of the session in the oracle SQL database.
     */
    private final String username;

    /**
     * The password of the session in the oracle SQL database.
     */
    private final String password;

    /**
     * The connection name.
     */
    private final String connectionName;

    /**
     * Creates an instance of ImportExportTable receiving the user interface
     * controller as parameter.
     *
     * @param uiController
     * @param connectionName
     * @param username
     * @param password
     */
    public ImportExportTable(UIController uiController, String connectionName, String username, String password) {
        this.uiController = uiController;
        this.connectionName = connectionName;
        this.username = username;
        this.password = password;
    }

    /**
     * Return the selected cells of active spread sheet.
     *
     * @param focusOwner The active spread sheet table
     * @return selected cells
     */
    public Cell[][] getSelectedCells(SpreadsheetTable focusOwner) {
        this.cells = focusOwner.getSelectedCells();
        return cells;
    }

    /**
     * Method that verify if connections is made
     *
     * @return returns true if the connection is made and false otherwise
     */
    public boolean testConnection() {
        boolean resp=false;
        DataBaseManager connection = new DataBaseManager(username, password);
        resp=connection.connectToDatabase(connectionName);
        if(resp==true){
            Connection c=connection.getConnection();
            try {
                c.close();
            } catch (SQLException ex) {
                Logger.getLogger(ImportExportTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resp;
      
    }

    /**
     * Method that verify table passed as parameter exists in database
     *
     * @param tableName Name of table to verify
     * @return returns true if the connection is made and false otherwise
     */
    public boolean checkTable(String tableName) {
        DataBaseManager dataBaseManager = new DataBaseManager(username, password);
        dataBaseManager.connectToDatabase(connectionName);
        Connection connection = dataBaseManager.getConnection();

        try {
            DatabaseMetaData metadata = connection.getMetaData();
            ResultSet table = metadata.getTables(null, null, tableName, null);

            if (table.next()) {
                if (table.getInt(1) >= 1) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportExportTable.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ImportExportTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    /**
     * Method that importTable from the specific database connection
     *
     * @param tableName table name
     * @param focusOwner The active spread sheet table
     * @return true or false
     */
    public boolean importTable(String tableName, SpreadsheetTable focusOwner) {
        //Make database connection
        DataBaseManager dbm = new DataBaseManager(username, password);
        dbm.connectToDatabase(connectionName);
        Connection connection = dbm.getConnection();
        //
        this.cells = this.getSelectedCells(focusOwner);
        Cell cell = cells[0][0];

        Statement statement;
        ResultSet result;
        ResultSetMetaData resultSetMetadata;
        int columnSize = 0;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery("select * from " + tableName.toUpperCase());
            resultSetMetadata = result.getMetaData();
            columnSize = resultSetMetadata.getColumnCount();
            Spreadsheet spreadsheet = this.uiController.getActiveSpreadsheet();

            //Fill the header
            for (int i = 1; i <= columnSize; i++) {
                String contentCell = resultSetMetadata.getColumnName(i);
                spreadsheet.getCell(cell.getAddress().getColumn() + i-1, cell.getAddress().getRow()).setContent(contentCell);
                //changedCell.setContent(contentCell);
            }

            //Fill lines one by one
            int cont = 1;
            while (result.next()) {
                for (int i = 1; i <= columnSize; i++) {
                     spreadsheet.getCell(cell.getAddress().getColumn() + i-1, cell.getAddress().getRow() + cont).setContent((String)result.getObject(i));
                }
                cont++;
            }

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ImportExportTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(ImportExportTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    //--------------------------Export------------------------------------------
     public List<String> getTables(){
        DataBaseManager dbm=new DataBaseManager(username, password);
        dbm.connectToDatabase(connectionName);
        Connection connection=dbm.getConnection();
        List<String> list=new ArrayList<>();
        
        DatabaseMetaData metadata;
        try {
            metadata = connection.getMetaData();
            ResultSet table = metadata.getTables(null, null, "", null);
            if (table.next()) {
               list.add(table.getString("TABLE_NAME"));
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(ImportExportTable.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return list;
    }
    
    /**
     * Add a new table to database
     * 
     * @param tableName Name of table
     * @param focusOwner Content of table
     * @return true if table is created and false otherwise
     */
    public boolean exportNewTable(String tableName,SpreadsheetTable focusOwner) {
        this.cells=this.getSelectedCells(focusOwner);
       
        DataBaseManager dbm=new DataBaseManager(username, password);
        dbm.connectToDatabase(connectionName);//connectExportDB(connectionName);
        Connection connection=dbm.getConnection();
        
        this.cells=this.getSelectedCells(focusOwner);
        //Create table
        String header = "";
        for (int i=0; i < this.cells[0].length; i++) {
                header += this.cells[0][i].getContent(); 
            
           
            if(i!=this.cells[0].length-1){
                header += " varchar(30),";
            }else{
              header += " varchar(30)";  
            }
        }
        
        try {
            Statement statement=connection.createStatement();
            statement.setQueryTimeout(45);//Set the number of seconds that will wait for a statement
            statement.executeUpdate("DROP TABLE IF EXISTS nomeDaTabela" + tableName);
            String createTable="create table " + tableName + "(" + header + ")";
            statement.executeUpdate(createTable);
            
            for (int i = 1; i < this.cells.length; i++) {
                String line = "";
                for (int j = 0; j < this.cells[0].length; j++) {
                    line += "'";
                    line += this.cells[i][j].getContent();
                    line += "'";
                    if (j != this.cells[i].length - 1) {
                        line += " ,";
                    }
                }
                statement.executeUpdate("INSERT INTO " + tableName + " VALUES (" + line + ")");
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ImportExportTable.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;

    }
    
        /**
     * Insert new info on a existing table of database
     * @param tableName Name of table
     * @param focusOwner info to insert
     * @return 
     */
    public boolean setTable(String tableName,SpreadsheetTable focusOwner) {
        this.cells=this.getSelectedCells(focusOwner);
       
        DataBaseManager dbm=new DataBaseManager(username, password);
        dbm.connectToDatabase(connectionName);
        Connection connection=dbm.getConnection();
        
        ResultSet result;
        ResultSetMetaData resultSetMetadata;
        this.cells=this.getSelectedCells(focusOwner);
        try {
            Statement statement=connection.createStatement();
            statement.setQueryTimeout(45);//Set the number of seconds that will wait for a statement
            
//            String [] header = new String[this.cells[0].length];
//            for (int i = 0; i < this.cells[0].length; i++) {
//                header[i]= this.cells[0][i].getContent();
//            }
//            //
            
            result = statement.executeQuery("select * from " + tableName);
            resultSetMetadata = result.getMetaData();
            int columnSize = resultSetMetadata.getColumnCount();
            
            String type = "(";
            for (int k = 1; k <= columnSize; k++) {
                type += resultSetMetadata.getColumnName(k);
                if (k != columnSize) {
                    type += ",";
                }else{
                   type += ")"; 
                }
            }
        
//            String type = "(";
//            for (int k = 0; k < this.cells[0].length; k++) {
//                type += header[k];
//                if (k != this.cells[0].length - 1) {
//                    type += ",";
//                }else{
//                   type += ")"; 
//                }
//            }
           
            
            for (int i = 0; i < this.cells.length; i++) {
                String line = "";
                for (int j = 0; j < this.cells[0].length; j++) {
                    line += "'";
                    line += this.cells[i][j].getContent();
                    line += "'";
                    if (j != this.cells[i].length - 1) {
                        line += " ,";
                    }
                }
                statement.executeUpdate("INSERT INTO " + tableName + type + " VALUES(" + line + ")");
           
            }
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ImportExportTable.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;

    }

}
