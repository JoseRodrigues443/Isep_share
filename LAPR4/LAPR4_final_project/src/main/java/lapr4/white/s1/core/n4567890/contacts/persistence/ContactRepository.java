/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.persistence;

import eapli.framework.persistence.DataIntegrityViolationException;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import eapli.framework.persistence.repositories.Repository;
import java.util.List;
import lapr4.red.s3.core.n1151117.contactstags.domain.Tag;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;

/**
 * Created by nuno on 21/03/16.
 * 
 * edited by Jorge Campos (1150759)
 * 
 * edited by José Barros (1151117)
 */
public interface ContactRepository extends Repository<Contact, Long> {

    boolean removeContact(Contact c) throws DataIntegrityViolationException;
    
    Iterable<Contact> findAllContacts();

    Contact findByName(String name);

    void addEventToContact(Contact c, Event e);
    
    void removeEventToContact(Contact c,Event e);
    
    void updateContact(Contact c);
    
    List<Object[]> tagsByFrequency();
    
    Iterable<Contact> findByTagValue(String t);
}
