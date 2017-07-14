/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.PersistenceContext;

/**
 *
 * @author Débora Costa - 1150433
 */
public class ImportPostalCodesController {
    private Properties appProps;
    private final PostalCodesRepository postalCodesRepository;
    private final PersistenceContext persistenceContext;
    private final ExtensionSettings extensionSettings;
    
    public ImportPostalCodesController(Properties props){
        this.appProps = props;
        this.extensionSettings = new ExtensionSettings(appProps);
        this.persistenceContext = new PersistenceContext(extensionSettings);
        this.postalCodesRepository = this.persistenceContext.repositories().postalCodes();
    }
    
    public void importPostalCodes(String file) throws  IOException, FileNotFoundException, DataIntegrityViolationException, DataConcurrencyException{
        PostalCodesReader reader = new PostalCodesReader(file, this.postalCodesRepository);
        reader.readFile();
    }
}



    
