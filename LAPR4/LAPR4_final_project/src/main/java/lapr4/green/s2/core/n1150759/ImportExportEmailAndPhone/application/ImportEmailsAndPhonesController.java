/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150759.ImportExportEmailAndPhone.application;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.email.Email;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.PhoneNumber;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode.CountryCode;
import lapr4.green.s2.core.n1150759.ImportExportEmailAndPhone.ImportEmails;
import lapr4.green.s2.core.n1150759.ImportExportEmailAndPhone.ImportPhones;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;

/**
 *
 * @author Jorge Campos <1150759@isep.ipp.pt>
 */
public class ImportEmailsAndPhonesController {
    /**
     * User interface controller
     */
    private final UIController uiCtrl;
    
    /**
     * Contact controller
     */
    private final ContactController contactCtrl;
    
    /**
     * Contact repository
     */
    private ContactRepository repository;
    
    /**
     * Instance of ImportEmails
     */
    private ImportEmails importEmails;
    
    /**
     * Instance of ImportPhones
     */
    private ImportPhones importPhones;
    
    /**
     * Number of columns needed for the method to work
     */
    private final static int NUMBER_OF_COLUMNS = 3;
    
    /**
     * Creates an instance of ImportEmailsAndPhonesController
     * 
     * @param uiCtrl User interface controller
     * @param contactCtrl Contact controller
     */
    public ImportEmailsAndPhonesController(UIController uiCtrl, 
            ContactController contactCtrl) {
        this.uiCtrl = uiCtrl;
        this.contactCtrl = contactCtrl;
    }
    
    /**
     * Imports the country codes to validate the phone numbers
     * 
     * @return Country code list
     */
    public Set<CountryCode> importCountryCodes() {
        Iterable<CountryCode> it = this.contactCtrl.persistenceContext().
                repositories().countryCodes().findAll();
        Set<CountryCode> ccList = new HashSet<>();
        for (CountryCode countryCode : it)
            ccList.add(countryCode);
        
        return ccList;
    }
    
    /**
     * Main method that imports the emails and phones to the database
     * 
     * @param spTable Spreadsheet table
     * @return True if successful, false otherwise
     * @throws eapli.framework.persistence.DataConcurrencyException
     * @throws eapli.framework.persistence.DataIntegrityViolationException
     */
    public boolean importData(SpreadsheetTable spTable) throws 
            DataConcurrencyException, DataIntegrityViolationException {
        
        Cell[][] cells = spTable.getSelectedCells();
        if (validateNumberOfArguments(cells)) {
            int nRows = spTable.getSelectedRowCount();
            Cell[] emailCells = new Cell[nRows];
            for(int row = 0; row < nRows; row++)
                emailCells[row] = cells[row][1];
            importEmails = new ImportEmails(emailCells);
            
            Cell[] phoneCells = new Cell[nRows];
            for(int row = 0; row < nRows; row++)
                phoneCells[row] = cells[row][2];
            importPhones = new ImportPhones(this, phoneCells);

            Email[] emails = importEmails.createEmails();
            PhoneNumber[] phones = importPhones.createPhoneNumbers();
            
            repository = this.contactCtrl.persistenceContext().
                    repositories().contacts();
        
            for (int i = 0; i < cells.length; i++) {
                Contact c = repository.findByName(cells[i][0].getContent());
                
                c.setMainEmail(emails[i]);
                c.setWorkPhone(phones[i]);
                
                repository.save(c);
            }
        } else {
            JOptionPane.showMessageDialog(null, "An error has occurred.", "Error", 
                    JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        
        JOptionPane.showMessageDialog(null, "Emails and phones were "
                + "successfully imported!", "Success", JOptionPane.INFORMATION_MESSAGE);
        
        return true;
    }
    
    /**
     * Checks if the number of arguments is correct
     * 
     * @param cells Cells
     * @return True if correct, false otherwise
     */
    private boolean validateNumberOfArguments(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) 
            if (cells[i].length != NUMBER_OF_COLUMNS)
                JOptionPane.showMessageDialog(null, "One or more arguments are "
                        + "missing.", "Error", JOptionPane.ERROR_MESSAGE);
        
        return true;
    }
}
