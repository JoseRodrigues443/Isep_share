package lapr4.white.s1.core.n4567890.contacts.domain;

import java.util.Calendar;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

@Generated(value="EclipseLink-2.6.1.v20150916-rNA", date="2017-06-21T17:37:18")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Date> date;
    public static volatile SingularAttribute<Event, Contact> c;
    public static volatile SingularAttribute<Event, Calendar> dueDate;
    public static volatile SingularAttribute<Event, Contact> contact;
    public static volatile SingularAttribute<Event, String> description;
    public static volatile SingularAttribute<Event, Long> pk;

}