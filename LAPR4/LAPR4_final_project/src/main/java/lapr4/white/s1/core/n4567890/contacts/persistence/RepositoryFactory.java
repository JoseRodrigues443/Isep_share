/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.persistence;

import lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode.PostalCodesRepository;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode.CountryCodeRepository;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;

/**
 * @author Paulo Gandra Sousa
 *
 * edited by Bruna Teixeira (1150595)
 * 
 * edited by Carlos Neiva (1150993)
 */
public interface RepositoryFactory {

    ExtensionSettings setSettings(ExtensionSettings settings);

    ContactRepository contacts();

    CountryCodeRepository countryCodes();
    
    PostalCodesRepository postalCodes();
    
    CompanyRepository company();
    
    EventRepository event();
}
