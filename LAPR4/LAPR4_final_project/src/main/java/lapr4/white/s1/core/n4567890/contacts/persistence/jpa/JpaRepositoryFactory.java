/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.persistence.jpa;

/**
 *
 * @author alexandrebraganca
 */
import lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode.JpaPostalCodeRepository;
import lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode.PostalCodesRepository;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode.CountryCodeRepository;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode.JpaCountryCodeRepository;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.CompanyRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.EventRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.RepositoryFactory;

/**
 *
 * Created by nuno on 21/03/16.
 */
public class JpaRepositoryFactory implements RepositoryFactory {

    private ExtensionSettings settings = null;

    @Override
    public ExtensionSettings setSettings(ExtensionSettings settings) {
        return this.settings = settings;
    }

    @Override
    public ContactRepository contacts() {
        return new JpaContactRepository(this.settings);
    }

    @Override
    public CountryCodeRepository countryCodes() {
        return new JpaCountryCodeRepository(this.settings);
    }

    @Override
    public PostalCodesRepository postalCodes() {
        return new JpaPostalCodeRepository(this.settings);
    }
    
    @Override
    public CompanyRepository company(){
        return new JpaCompanyRepository(this.settings);
    }
    
    @Override 
    public EventRepository event(){
        return new JpaEventRepository(settings);
    }


}
