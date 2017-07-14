package lapr4.white.s1.core.n4567890.contacts.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lapr4.blue.s1.core.n1150433.addressEdition.domain.Address;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.email.Email;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.PhoneNumber;
import lapr4.green.s2.core.n1150993.CompanyContact.Company;
import lapr4.red.s3.core.n1151117.contactstags.domain.Tag;
import lapr4.white.s1.core.n4567890.contacts.domain.Agenda;

@Generated(value="EclipseLink-2.6.1.v20150916-rNA", date="2017-06-21T17:37:18")
@StaticMetamodel(Contact.class)
public class Contact_ { 

    public static volatile SingularAttribute<Contact, String> profession;
    public static volatile SingularAttribute<Contact, String> lastName;
    public static volatile SetAttribute<Contact, Email> secondaryEmails;
    public static volatile SingularAttribute<Contact, Address> secondaryAddress;
    public static volatile SingularAttribute<Contact, PhoneNumber> homePhone;
    public static volatile SingularAttribute<Contact, PhoneNumber> celular1;
    public static volatile SingularAttribute<Contact, String> photo;
    public static volatile SingularAttribute<Contact, Agenda> agenda;
    public static volatile SingularAttribute<Contact, Address> mainAddress;
    public static volatile SetAttribute<Contact, Tag> tags;
    public static volatile SingularAttribute<Contact, String> firstName;
    public static volatile SingularAttribute<Contact, String> name;
    public static volatile SingularAttribute<Contact, PhoneNumber> celular2;
    public static volatile SingularAttribute<Contact, PhoneNumber> workPhone;
    public static volatile SingularAttribute<Contact, Company> company;
    public static volatile SingularAttribute<Contact, Long> pk;
    public static volatile SingularAttribute<Contact, Email> mainEmail;

}