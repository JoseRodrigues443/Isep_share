/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode;

import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.jpa.CrmJpaRepositoryBase;

/**
 *
 * @author Débora Costa - 1150433
 */
public class JpaPostalCodeRepository extends CrmJpaRepositoryBase<PostalCode, Long> implements PostalCodesRepository{
    
    public JpaPostalCodeRepository(ExtensionSettings settings){
        super(settings);
    }
}

