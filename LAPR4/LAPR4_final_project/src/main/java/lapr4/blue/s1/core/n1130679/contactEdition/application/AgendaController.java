/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1130679.contactEdition.application;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.jpa.JpaEventRepository;


/**
 *
 * @author Ana Pacheco (1130679)
 */
public class AgendaController extends lapr4.white.s1.core.n4567890.contacts.application.ContactController {

    public AgendaController(Properties props) {
        super(props);
    }

    public Iterable<Contact> getContacts() {
        return super.allContacts();
    }

    public Calendar isDateValid(String date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            Date auxDate = sdf.parse(date);
            if (auxDate.after(new Date(9999, 12, 30))) {
                return null;
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(auxDate);
            Calendar now = Calendar.getInstance();
            if (cal.get(cal.DAY_OF_WEEK) == now.get(now.DAY_OF_WEEK)
                    && cal.get(cal.DAY_OF_MONTH) == now.get(now.DAY_OF_MONTH)
                    && cal.get(cal.DAY_OF_YEAR) == now.get(now.DAY_OF_YEAR)) {
                return cal;
            }
            if (cal.after(now)) {
                return cal;
            } else {
                return null;
            }
        } catch (ParseException e) {
            return null;
        }
    }

    public boolean createEvent(String description, String date, Contact contact) throws ParseException {

        Event event = new Event(contact,description, date);
        contact.agenda().add(event);
        return true;
    }

    
    public Event changeEvent(String description, String date, Event event, Contact contact) throws DataConcurrencyException, DataIntegrityViolationException, ParseException {
        Contact nc = null;
        nc=event.getContact();
                
        
        Iterator<Event> iterator=nc.agenda().getAll().iterator();
        while(iterator.hasNext()){
            if(iterator.next().getPk().equals(event.getPk())){
                iterator.remove();
            }
        }
       
        event.newDescription(description);
        event.setDate(date);
        nc.agenda().add(event);
        contactRespository().updateContact(nc);
        Contact over = null;
        over=event.getContact();
        try {
            contactRespository().save(over);
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(ContactRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return event;
    }

    public void deleteEvent(Event e, Contact c) {
        this.contactRespository().removeEventToContact(c, e);
    }

    public void saveContact(Contact c) throws DataConcurrencyException, DataIntegrityViolationException {
        super.persistenceContext().repositories().contacts().save(c);
    }

    public Iterable<Event> allEvents(Contact c) {
        return c.agenda().getAll();
    }

    public Event getEvent(Event e, Contact c) {
        Iterable<Event> lst = c.agenda().getAll();
        for (Event event : lst) {
            if (event.equals(e)) {
                return event;
            }
        }
        return null;
    }
}
