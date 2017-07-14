/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150433.addressEdition.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import lapr4.blue.s1.core.n1150433.addressEdition.domain.Address;
import java.util.Properties;
import java.util.Set;
import lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode.PostalCode;
import lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode.PostalCodesReader;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;

/**
 *
 * @author Débora Costa - 1150433
 */
public class AddressEditionController extends ContactController{
    private Address mainAddress;
    private Address secondaryAddress;
    private Contact contact;
    private ContactRepository contactRepository;
    private Iterable<PostalCode> listCodes;
    
    public AddressEditionController(Properties props) throws IOException, FileNotFoundException, DataConcurrencyException, DataIntegrityViolationException {
        super(props);
        contactRepository = super.persistenceContext().repositories().contacts();
        listCodes = super.persistenceContext().repositories().postalCodes().findAll();
    }
    
    public Address createAddress(String street, String town, String postalCode, String city, String country){
        if(country.equalsIgnoreCase("Portugal")){
            PostalCode code = new PostalCode(postalCode);
            if(code.validatePortugueseCodes(listCodes)){
                return new Address(street, town, code, city, country);
            }
        }
        return new Address(street, town, new PostalCode(postalCode), city, country);
    }
    
    public Address mainAddress(){
        return mainAddress;
    }
    
    public Address secondaryAddress(){
        return secondaryAddress;
    }
    
    public void setMainAddress(Address address){
        mainAddress = address;
    }
    
    public void setSecondaryAddress(Address address){
        secondaryAddress = address;
    }
    
    public void addAddressToContact(Contact contact){
        contact.setMainAddress(mainAddress);
        contact.setSecondaryAddress(secondaryAddress);
    }
    
    public Contact saveContact(Contact contact) throws DataConcurrencyException, DataIntegrityViolationException {
        return this.contactRepository.save(contact);
    }
    
}
