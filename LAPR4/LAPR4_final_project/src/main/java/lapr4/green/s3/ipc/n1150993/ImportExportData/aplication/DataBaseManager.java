/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150993.ImportExportData.aplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 1150993
 */
public class DataBaseManager {
    /**
     * The username of the session in the oracle SQL database.
     */
    private final String username;

    /**
     * The password of the session in the oracle SQL database.
     */
    private final String password;
    
    /**
     * Connection whith database
     */
    private Connection connection;
    
    public DataBaseManager(String username, String password){
        this.username=username;
        this.password=password;
    }
    
    
    /**
     * Make connection with database
     * 
     * @param connectionName Name of database
     * @return true if connection is made and false otherwise
     */ 
    public boolean connectToDatabase(String connectionName){
        try {
            Class.forName("org.h2.Driver");
            this.connection=DriverManager.getConnection("jdbc:h2:..\\db\\" + connectionName + ";MV_STORE=FALSE",this.username,this.password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBaseManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * Return connection whith database
     * 
     * @return connection
     */
    public Connection getConnection(){
        return this.connection;
    }

}
