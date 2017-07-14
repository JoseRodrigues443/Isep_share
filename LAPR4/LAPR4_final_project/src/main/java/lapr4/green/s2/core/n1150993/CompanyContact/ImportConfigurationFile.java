/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150993.CompanyContact;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 *
 * @author 1150993
 */
public class ImportConfigurationFile {

    public ImportConfigurationFile() {

    }

    /*
    *Return a list of professions of .config file
     */
    public String[] getProfissionsList() {
        String str = "";
        System.out.println("");
        Properties properties = null;
        try {

            FileInputStream configFile = new FileInputStream("/Documents/NetBeansProjects/lapr4-2017-2db/src/main/java/csheets/professions.config");

            properties = new Properties();
            
            // load the properties file
            properties.load(configFile);
            
            // get the value for professions key
            str = properties.getProperty("profissions");
        } catch (IOException ex) {
            str = "carpinteiro;medico;professor;mecanico;";
        }

        String[] prof = str.split(";");
        return prof;

    }

}

