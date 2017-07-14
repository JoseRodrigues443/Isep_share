/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.application;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode.PostalCodesRepository;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode.CountryCodeRepository;
import lapr4.green.s2.core.n1150993.CompanyContact.Company;
import lapr4.green.s2.core.n1150993.CompanyContact.ImportConfigurationFile;
import lapr4.red.s3.core.n1151117.contactstags.domain.Tag;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;
import lapr4.white.s1.core.n4567890.contacts.persistence.CompanyRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.EventRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.PersistenceContext;

/**
 *
 * @author alexandrebraganca
 */
public class ContactController implements Controller {

    private Properties appProps;
    private final ContactRepository contactsRepository;
    private final CountryCodeRepository ccRepository;
    private final PostalCodesRepository pcRepository;
    private final PersistenceContext persistenceContext;
    private final ExtensionSettings extensionSettings;
    private final CompanyRepository companyRepository;
    private final EventRepository eventRepository;

    public ContactController(Properties props) {
        this.appProps = props;
        this.extensionSettings = new ExtensionSettings(this.appProps);
        this.persistenceContext = new PersistenceContext(this.extensionSettings);
        this.contactsRepository = this.persistenceContext.repositories().contacts();
        this.ccRepository = this.persistenceContext.repositories().countryCodes();
        this.pcRepository = this.persistenceContext.repositories().postalCodes();
        this.companyRepository=this.persistenceContext.repositories().company();
        this.eventRepository=this.persistenceContext.repositories().event();
    }

    public Contact addContact(String name, String firstName, String lastName) throws DataConcurrencyException, DataIntegrityViolationException {
        return this.contactsRepository.save(new Contact(name, firstName, lastName));
    }
    
    public Contact addContact(String name, String firstName, String lastName,Company c,String profession) throws DataConcurrencyException, DataIntegrityViolationException {
        return this.contactsRepository.save(new Contact(name, firstName, lastName,c,profession));
    }

    public Contact addContact(Contact c) throws DataConcurrencyException, DataIntegrityViolationException{
        return this.contactsRepository.save(c);
    }
    
    public boolean removeContact(Contact contact) throws DataConcurrencyException, DataIntegrityViolationException {
        return this.contactsRepository.removeContact(contact);
    }

    public Contact updateContact(Contact contact, String fullName, String firstName, String lastName,Company c,String profession) throws DataConcurrencyException, DataIntegrityViolationException {
        contact.setName(fullName);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setCompany(c);
        contact.setProfession(profession);
        return this.contactsRepository.save(contact);
    }
     public Contact updateContact(Contact contact, String fullName, String firstName, String lastName) throws DataConcurrencyException, DataIntegrityViolationException {
        contact.setName(fullName);
        contact.setFirstName(firstName);
        contact.setLastName(lastName);

        return this.contactsRepository.save(contact);
    }

    public Iterable<Contact> allContacts() {
        return this.contactsRepository.findAllContacts();
    }
    
     public List<Event> allEvents() {
        return this.eventRepository().listAllEvents();
    }

    public Contact getContactById(Long id) {
        Optional<Contact> c = this.contactsRepository.findOne(id);
        if (c.isPresent()) {
            return c.get();
        } else {
            return null;
        }
    }

    public Event addEvent(Contact contact, String eventDescription, String dueDate) throws DataConcurrencyException, DataIntegrityViolationException, ParseException {

        Event ev = new Event(contact, eventDescription, dueDate);
       // this.eventRepository.addEvent(ev);
        contactsRepository.addEventToContact(contact, ev);
        
        return ev;
    }

    public PersistenceContext persistenceContext() {
        return persistenceContext;
    }
    
    public EventRepository eventRepository(){
        return this.eventRepository;
    }
    
    public ContactRepository contactRespository(){
        return this.contactsRepository;
    }
    
    public List<Company> getAllCompanies(){
        return this.companyRepository.getAllCompanys();
    }
    
    public String[] getProfessions(){
        ImportConfigurationFile f=new ImportConfigurationFile();
        return f.getProfissionsList();
    }
    
    public boolean associateTagToContact(Contact c, Tag t){
        return c.associateTag(t);
    }
    
    public List<Object[]> allTagsByFrequency(){
        return contactsRepository.tagsByFrequency();
    }
    
    public Iterable<Contact> contagsByTagValue(String t){
        return contactsRepository.findByTagValue(t);
    }
}
