/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150759.ImportExportEmailAndPhone;

import csheets.core.Cell;
import java.util.Set;
import javax.swing.JOptionPane;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.PhoneNumber;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode.CountryCode;
import lapr4.green.s2.core.n1150759.ImportExportEmailAndPhone.application.ImportEmailsAndPhonesController;

/**
 *
 * @author Jorge Campos <1150759@isep.ipp.pt>
 */
public class ImportPhones {
    
    /**
     * Instance of ImportEmailsAndPhonesController
     */
    private final ImportEmailsAndPhonesController ctrl;
    
    /**
     * Cells containing the phones
     */
    private final Cell[] phoneCells;
    
    /**
     * Array that will store the phones
     */
    private final PhoneNumber[] phones;
    
    /**
     * Creates an instance of ImportPhones
     * 
     * @param ctrl Controller
     * @param phoneCells Cells containing the phones
     */
    public ImportPhones(ImportEmailsAndPhonesController ctrl, 
            Cell[] phoneCells) {
        this.ctrl = ctrl;
        this.phoneCells = phoneCells;
        this.phones = new PhoneNumber[phoneCells.length];
    }
    
    /**
     * Creates the phone numbers and puts them in the phone number array if 
     * successfully validated
     * 
     * @return Phone number array
     */
    public PhoneNumber[] createPhoneNumbers() {
        //Set<CountryCode> ccList = ctrl.importCountryCodes();
        for (int line = 0; line < this.phoneCells.length; line++) {
            PhoneNumber phone = new PhoneNumber(this.phoneCells[line].getContent());
                //if (phone.phoneValidation(ccList))
                    this.phones[line] = phone;
        }
        
        return this.phones;
    }
}
