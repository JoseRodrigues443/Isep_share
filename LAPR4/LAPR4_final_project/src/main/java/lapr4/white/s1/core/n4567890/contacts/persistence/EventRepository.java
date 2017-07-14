/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.persistence;

import eapli.framework.persistence.repositories.Repository;
import java.util.List;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;

/**
 *
 * @author cdsn_
 */
public interface EventRepository extends Repository<Event, Long> {

    public void addEvent(Event e);

    public void updateEvents(Event e);

    public void deleteEvents(Event e);

    public List<Event> listAllEvents();

    public List<Event> AllEventsByContact(Contact c);
}
