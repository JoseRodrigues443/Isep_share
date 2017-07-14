/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150433.addressEdition.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode.PostalCode;

/**
 *
 * @author Débora Costa - 1150433
 */
@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String street;
    private String town;
    private PostalCode postalCode;
    private String city;
    private String country;
    
    public Address(String street, String town, PostalCode postalCode, String city, String country){
        if(street == null || town == null || postalCode == null || city == null || country == null){
            throw new IllegalStateException();
        }
        this.street = street;
        this.town = town;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;        
    }
    
    protected Address(){
        //for ORM
    }
    
    public String street(){
        return street;
    }
    
    public String town(){
        return town;
    }
    
    public PostalCode postalCode(){
        return postalCode;
    }
    
    public String city(){
        return city;
    }
    
    public String country(){
        return country;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.postalCode == null && other.postalCode != null) || (this.postalCode != null && !this.postalCode.equals(other.postalCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lapr4.blue.s1.core.n1150433.addressEdition.domain.Address[ id=" + id + " ]";
    }
    
    
}
