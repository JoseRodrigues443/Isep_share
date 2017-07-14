package lapr4.blue.s1.core.n1150433.addressEdition.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode.PostalCode;

@Generated(value="EclipseLink-2.6.1.v20150916-rNA", date="2017-06-21T17:37:18")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> country;
    public static volatile SingularAttribute<Address, String> town;
    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, PostalCode> postalCode;
    public static volatile SingularAttribute<Address, Long> id;

}