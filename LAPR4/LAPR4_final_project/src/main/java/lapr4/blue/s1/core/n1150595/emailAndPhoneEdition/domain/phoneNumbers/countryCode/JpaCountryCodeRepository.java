/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode;

import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.jpa.CrmJpaRepositoryBase;

/**
 *
 * @author 1150595
 */
public class JpaCountryCodeRepository extends CrmJpaRepositoryBase<CountryCode, Long> implements CountryCodeRepository {

    public JpaCountryCodeRepository(ExtensionSettings settings) {
        super(settings);
    }
    
}
