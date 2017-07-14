/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.persistence.jpa;

/**
 *
 * @author alexandrebraganca
 *
 * edited by Jorge Campos (1150759)
 * 
 * edited by José Barros (1151117)
 */

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.TypedQuery;
import lapr4.red.s3.core.n1151117.contactstags.domain.Tag;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;

/**
 *
 * Created by nuno on 20/03/16.
 *
 * edited by José Barros (1151117)
 */
class JpaContactRepository extends CrmJpaRepositoryBase<Contact, Long> implements ContactRepository {

    JpaContactRepository(ExtensionSettings settings) {
        super(settings);
    }

    @Override
    public boolean removeContact(Contact c) throws DataIntegrityViolationException {
        try {
            delete(c);
        }
        catch (Exception ex) {
            throw new DataIntegrityViolationException(ex);
        }
        return true;
    }

    @Override
    public Iterable<Contact> findAllContacts(){
        return findAll();
    }

    @Override
    public Contact findByName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        return matchOne("e.name=:name", params);
    }

    @Override
    public void addEventToContact(Contact c,Event e){
        Contact nc=null;
        for(Contact c1: findAllContacts()){
            if(Objects.equals(c1.id(), c.id())){
                nc=c1;
            }
        }
        nc.agenda().add(e);
        update(nc);
        Contact over = null;
         for(Contact c2: this.findAllContacts()){
            if(Objects.equals(c2.id(), c.id())){
                over=c2;
            }
        }
        try {
            save(over);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(JpaCompanyRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeEventToContact(Contact c,Event e){
        Contact nc=null;
        nc=e.getContact();
        Iterator<Event> iterator=nc.agenda().getAll().iterator();
        while(iterator.hasNext()){
            if(iterator.next().getPk().equals(e.getPk())){
                iterator.remove();
            }
        }
        update(nc);
        Contact over = null;
        over=e.getContact();
        try {
            save(over);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(JpaCompanyRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateContact(Contact c){
        update(c);
    }

    @Override
    public List<Object[]> tagsByFrequency() {
        String q = "SELECT DISTINCT e.description, COUNT(e.description) AS cont " +
                "FROM Contact c INNER JOIN c.tags e " +
                "GROUP BY e.description " +
                "ORDER BY cont DESC";
        TypedQuery<Object[]> query = entityManager().createQuery( q, Object[].class);
        List<Object[]> results = query.getResultList();
        return results;
    }

    @Override
    public Iterable<Contact> findByTagValue(String tag) {
        String q = "SELECT c " +
            "FROM Contact c INNER JOIN c.tags e " +
            "WHERE e.description LIKE :description";
        TypedQuery<Contact> query = entityManager().createQuery(q, Contact.class);
        query.setParameter("description", tag);
        return query.getResultList();
    }
}
