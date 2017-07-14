/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.Properties;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.PersistenceContext;

/**
 *
 * @author 1150595
 */
public class ImportCountryCodesController implements Controller {

    private Properties appProps;
    private final CountryCodeRepository countryCodeRepository;
    private final PersistenceContext persistenceContext;
    private final ExtensionSettings extensionSettings;

    public ImportCountryCodesController(Properties props) {
        this.appProps = props;
        this.extensionSettings = new ExtensionSettings(this.appProps);
        this.persistenceContext = new PersistenceContext(this.extensionSettings);
        this.countryCodeRepository = this.persistenceContext.repositories().countryCodes();
    }

    public void importCountryCodes(String fileName) throws DataConcurrencyException, DataIntegrityViolationException {
        CountryCodesReader ccr = new CountryCodesReader(fileName, this.countryCodeRepository);
        ccr.read();
        for (CountryCode cc : this.countryCodeRepository.findAll()) {
            System.out.println(cc.toString());
        }
    }

}
