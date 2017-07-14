/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150993.CompanyContact;

import csheets.core.Address;
import java.io.Serializable;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author 1150993
 */
@Entity
public class Company extends Contact implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long pk;
    private String name;
    private Address mainAddress;
    private Address secAddress;

   /*
    *Creates an instance of Company receiving a name
    *
    *@param name Name of company
    */
    public Company(String name) {
        this.name=name;
        setName(name);
        setContact_PK(pk);
    }
    
    /*
    *Creates an empty instance of Company
    */
    public Company(){
        setContact_PK(pk);
    }
    
    /*
    *Select a name for the company.
    *
    *@param name The new name of company
    */
    public void selectName(String name){
        this.name=name;
    }
    
    /*
    *Return the name of company
    *
    *@return name The name of company
    */
    public String name(){
        return super.name();
    }
    
    /*
    *Select a main address.
    *
    *@param mainAddress The new main address
    */
    public void selectMainAddress(Address mainAddress){
        this.mainAddress=mainAddress;
    }
    
    /*
    *Select a secundary address.
    *
    *@param secundaryAddress The new secundary address
    */
    public void selectSecundaryAddress(Address secundaryAddress){
        this.secAddress=secundaryAddress;
    }
    
    /*
    *Return the main address.
    *
    *@return mainAddress
    */
    public Address maiAddress(){
        return this.mainAddress;
    }
    
    /*
    *Return the secundary address
    *
    *@return secAddress 
    */
    public Address secundaryAddress(){
        return this.secAddress;
    }
   
    
    /**
     * @return a string with the name of company
     */
    @Override
    public String toString() {
       return name;
    }

    
}
