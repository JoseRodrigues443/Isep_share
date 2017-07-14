/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150759.ImportExportEmailAndPhone;

import csheets.core.Cell;
import javax.swing.JOptionPane;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.email.Email;

/**
 *
 * @author Jorge Campos <1150759@isep.ipp.pt>
 */
public class ImportEmails {
    /**
     * Cells containing the emails
     */
    private final Cell[] emailCells;
    
    /**
     * Array that will store the emails
     */
    private final Email[] emails;
    
    /**
     * Creates an instance of ImportEmails
     * 
     * @param emailCells Cells containing the emails
     */
    public ImportEmails(Cell[] emailCells) {
        this.emailCells = emailCells;
        this.emails = new Email[emailCells.length];
    }
    
    /**
     * Creates the emails and puts them in the email array if 
     * successfully validated
     * 
     * @return Email array
     */
    public Email[] createEmails() {
        for (int line = 0; line < this.emailCells.length; line++) {
            Email email = new Email(this.emailCells[line].getContent());
                if (email.validateEmail())
                    this.emails[line] = email;
        }
        
        return this.emails;
    }
}
