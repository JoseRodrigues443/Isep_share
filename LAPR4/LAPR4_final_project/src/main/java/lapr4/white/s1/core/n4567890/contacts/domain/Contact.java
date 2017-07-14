/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.domain;

/**
 *
 * @author alexandrebraganca
 */
import lapr4.blue.s1.core.n1150433.addressEdition.domain.Address;
import eapli.framework.domain.AggregateRoot;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.email.Email;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.PhoneNumber;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode.CountryCode;
import lapr4.green.s2.core.n1150993.CompanyContact.Company;
import lapr4.red.s3.core.n1151117.contactstags.domain.Tag;

/**
 * Contact
 *
 * @author ATB
 *
 * edited by Débora Costa (1150433)
 *
 * edited by Bruna Teixeira (1150595)
 *
 * edited by Carlos Neiva (1150993)
 *
 * edited by José Barros (1151117)
 */
@Entity
public class Contact implements AggregateRoot<Long>, Serializable {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk = null;

    // This should be the Business ID
    @Column(unique = true)
    private String name = null;

    private String firstName = null;

    private String lastName = null;

    private String photo = null;

    @OneToOne(cascade = CascadeType.ALL) //(cascade = CascadeType.MERGE)
    private Agenda agenda = null;

    @OneToOne(orphanRemoval = true)
    private Address mainAddress = null;

    @OneToOne(orphanRemoval = true)
    private Address secondaryAddress = null;

    @OneToOne(orphanRemoval = true)
    private PhoneNumber workPhone = null;
    @OneToOne(orphanRemoval = true)
    private PhoneNumber homePhone = null;
    @OneToOne(orphanRemoval = true)
    private PhoneNumber celular1 = null;
    @OneToOne(orphanRemoval = true)
    private PhoneNumber celular2 = null;

    @OneToOne(orphanRemoval = true)
    private Email mainEmail = null;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Set<Email> secondaryEmails = null;

    @ElementCollection
    private Set<Tag> tags = null;

    /*
    *Company associated to contact
     */
    private Company company;

    /*
    *Profession of contact
     */
    private String profession;

    protected Contact() {
        // for ORM
    }

    public Contact(final String name, final String firstName, final String lastName, final Agenda agenda,
            final Address mainAddress, final Address secondaryAddress, final PhoneNumber workPhone, final PhoneNumber homePhone,
            final PhoneNumber celular1, final PhoneNumber celular2, final Email mainEmail, final Set<Email> secondaryEmails) throws DataConcurrencyException, DataIntegrityViolationException {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        // TODO implement rest of the method

        // Create a the contact Agenda
        this.agenda = agenda;

        this.mainAddress = mainAddress;
        this.secondaryAddress = secondaryAddress;

        this.workPhone = workPhone;
        this.homePhone = homePhone;
        this.celular1 = celular1;
        this.celular2 = celular2;

        this.mainEmail = mainEmail;
        this.secondaryEmails = secondaryEmails;
        this.tags = new TreeSet<>();
    }

    public Contact(final String name, final String firstName, final String lastName, final Agenda agenda,
            final Address mainAddress, final Address secondaryAddress, final PhoneNumber workPhone, final PhoneNumber homePhone,
            final PhoneNumber celular1, final PhoneNumber celular2, final Email mainEmail, final Set<Email> secondaryEmails, Company c, String profession) throws DataConcurrencyException, DataIntegrityViolationException {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        // TODO implement rest of the method

        // Create a the contact Agenda
        this.agenda = agenda;

        this.mainAddress = mainAddress;
        this.secondaryAddress = secondaryAddress;

        this.workPhone = workPhone;
        this.homePhone = homePhone;
        this.celular1 = celular1;
        this.celular2 = celular2;

        this.mainEmail = mainEmail;
        this.secondaryEmails = secondaryEmails;
        this.company = c;
        this.profession = profession;
        this.tags = new TreeSet<>();
    }

    @Override
    public String toString() {
        if (this.name == null) {
            return super.toString();
        } else {
            return this.name() + " (" + this.lastName + ", " + this.firstName + ")";
        }
    }

    public Contact(final String name, final String firstName, final String lastName) throws DataConcurrencyException, DataIntegrityViolationException {

        // create with empty agenda
        this(name, firstName, lastName, new Agenda(), null, null, null, null, null, null, null, null);
    }

    public Contact(final String name, final String firstName, final String lastName, Company c, String profession) throws DataConcurrencyException, DataIntegrityViolationException {

        // create with empty agenda
        this(name, firstName, lastName, new Agenda(), null, null, null, null, null, null, null, null, c, profession);
    }

    public String name() {
        return this.name;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String firstName() {
        return this.firstName;
    }

    public String setFirstName(String firstName) {
        return this.firstName = firstName;
    }

    public String lastName() {
        return this.lastName;
    }

    public String setLastName(String lastName) {
        return this.lastName = lastName;
    }

    public Agenda agenda() {
        return this.agenda;
    }

    @Override
    public boolean sameAs(Object other) {
        // FIXME implement this method
        return false;
    }

    public Address mainAddress() {
        return mainAddress;
    }

    public void setMainAddress(Address mainAddress) {
        this.mainAddress = mainAddress;
    }

    public Address secondaryAddress() {
        return secondaryAddress;
    }

    public void setSecondaryAddress(Address secondaryAddress) {
        this.secondaryAddress = secondaryAddress;
    }

    public PhoneNumber workPhone() {
        return workPhone;
    }

    public void setWorkPhone(PhoneNumber workPhone) {
        this.workPhone = workPhone;
    }

    public PhoneNumber homePhone() {
        return homePhone;
    }

    public void setHomePhone(PhoneNumber homePhone) {
        this.homePhone = homePhone;
    }

    public PhoneNumber celular1() {
        return celular1;
    }

    public void setCelular1(PhoneNumber celular1) {
        this.celular1 = celular1;
    }

    public PhoneNumber celular2() {
        return celular2;
    }

    public void setCelular2(PhoneNumber celular2) {
        this.celular2 = celular2;
    }

    public Email mainEmail() {
        return mainEmail;
    }

    public void setMainEmail(Email mainEmail) {
        this.mainEmail = mainEmail;
    }

    public Set<Email> secondaryEmails() {
        return secondaryEmails;
    }

    public void setSecondaryEmails(Set<Email> secondaryEmails) {
        this.secondaryEmails = secondaryEmails;
    }

    @Override
    public boolean is(Long id) {
        return (this.pk.compareTo(id) == 0);
    }

    @Override
    public Long id() {
        return this.pk;
    }

    /**
     * Updates the contact phone numbers
     *
     * @param workPhoneNum work phone
     * @param homePhoneNum home phone
     * @param celular1Num celular 1
     * @param celular2Num celular 2
     * @param list
     */
    public void updatePhones(String workPhoneNum, String homePhoneNum, String celular1Num, String celular2Num, Set<CountryCode> list) {
        if (workPhoneNum.isEmpty()) {
            this.workPhone = null;
        } else {
            this.workPhone = new PhoneNumber(workPhoneNum);
            if (this.workPhone.phoneValidation(list) == false) {
                this.workPhone = null;
            }
        }

        if (homePhoneNum.isEmpty()) {
            this.homePhone = null;
        } else {
            this.homePhone = new PhoneNumber(homePhoneNum);
            if (this.homePhone.phoneValidation(list) == false) {
                this.homePhone = null;
            }
        }

        if (celular1Num.isEmpty()) {
            this.celular1 = null;
        } else {
            this.celular1 = new PhoneNumber(celular1Num);
            if (this.celular1.phoneValidation(list) == false) {
                this.celular1 = null;
            }
        }

        if (celular2Num.isEmpty()) {
            this.celular2 = null;
        } else {
            this.celular2 = new PhoneNumber(celular2Num);
            if (this.celular2.phoneValidation(list) == false) {
                this.celular2 = null;
            }
        }
    }

    /**
     * Updates the main email
     *
     * @param e the new email
     */
    public void updateMainEmail(String e) {
        Email ema = new Email(e);
        boolean b = addEmail(ema, e);
        if (b == true) {
            this.mainEmail = ema;
        } else {
            this.mainEmail = null;
        }
    }

    /**
     * Creates a new Email and validates it
     *
     * @param email Email that is passed by parameter that will be modified
     * @param e the email itself
     * @return if the new email is valid or not
     */
    public boolean addEmail(Email email, String e) {
        boolean ret = false;
        email = new Email(e);
        ret = email.validateEmail();
        if (ret == false) {
            email = null;
        }
        return ret;
    }

    /**
     * Adds a secondary email to the list of secondary emails
     *
     * @param e the new email
     * @return if the new email was valid or not
     */
    public boolean addSecondaryEmail(String e) {
        if (this.secondaryEmails == null) {
            this.secondaryEmails = new HashSet<>();
        }
        boolean ret = false;
        Email email = new Email(e);
        ret = addEmail(email, e);
        if (ret == true) {
            secondaryEmails.add(email);
        }
        return ret;
    }

    /**
     * Updates a secondary email (edits or removes)
     *
     * @param secondaryEmail the secondary email
     * @param e the new email or an empty String in case of deletion
     * @return if the email that the user updated is valid or not
     */
    public boolean updateSecondaryEmail(Email secondaryEmail, String e) {
        boolean ret = false;
        for (Email ema : this.secondaryEmails) {
            if (ema.equals(secondaryEmail)) {
                if (e.isEmpty()) {
                    this.secondaryEmails.remove(ema);
                    ret = true;
                } else {
                    Email t = ema;
                    t.setEmail(e);
                    if (t.validateEmail() == false) {
                        ret = false;
                    } else {
                        ret = true;
                        ema.setEmail(e);
                    }
                }
            }
        }
        return ret;
    }

    /*
    *Select a new primary key
    *
    *@param pk The new primary key
     */
    public void setContact_PK(Long pk) {
        this.pk = pk;
    }

    /**
     * @return the company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * @return the profession
     */
    public String getProfession() {
        return profession;
    }

    /**
     * @param profession the profession to set
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * Associate a new tag to the user
     *
     * @param t the tag to associate
     * @return true if associated
     */
    public boolean associateTag(Tag t) {
        if(t == null){
            throw new IllegalStateException();
        }
        if (this.tags == null) {
            this.tags = new TreeSet<>();
        }
        if(!verifyTagExists(t)){
            return false;
        }
        return this.tags.add(t);
    }

    /**
     * Returns all the tags associated to the current contact
     *
     * @return all the tags associated to the contact
     */
    public Set<Tag> allAssociatedTags() {
        return this.tags;
    }
    
    private boolean verifyTagExists(Tag t){
        for(Tag tag : tags){
            if(t.tagValue().equals(tag.tagValue())){
                return false;
            }
        }
        return true;
    }

}
