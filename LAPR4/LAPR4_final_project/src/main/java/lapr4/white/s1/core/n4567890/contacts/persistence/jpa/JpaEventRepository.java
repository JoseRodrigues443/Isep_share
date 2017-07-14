/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.persistence.jpa;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.domain.Agenda;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.EventRepository;

/**
 *
 * @author cdsn_
 */
public class JpaEventRepository extends CrmJpaRepositoryBase<Event, Long> implements EventRepository {

    JpaEventRepository(ExtensionSettings settings) {
        super(settings);
    }

    @Override
    public void addEvent(Event e) {
        try {
            save(e);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(JpaEventRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateEvents(Event e) {
        update(e);
        try {
            save(e);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(JpaEventRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(JpaEventRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteEvents(Event e) {
        delete(e);
    }

    @Override
    public List<Event> listAllEvents() {
        List<Event> l = new ArrayList<>();
        for (Event e : findAll()) {
            l.add(e);
        }
        return l;
    }

    @Override
    public List<Event> AllEventsByContact(Contact c) {
        List<Event> eventlist = listAllEvents();
        List<Event> events_result = new ArrayList<>();

        for (Event el : eventlist) {
            for (Event e : c.agenda().getAll()) {
                if (e.equals(el)) {
                    events_result.add(el);
                }
            }
        }
        return events_result;

    }
  
}
