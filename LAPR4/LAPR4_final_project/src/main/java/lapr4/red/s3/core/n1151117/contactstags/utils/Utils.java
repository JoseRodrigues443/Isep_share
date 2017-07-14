/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1151117.contactstags.utils;

import lapr4.green.s2.core.n1150993.CompanyContact.Company;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 * Class to help with contact filtered by tag edition
 *
 * @author Barros
 */
public class Utils {

    private Contact contact;
    
    private Company company;
    
    private boolean edit;
    
    public Utils(){
        contact = null;
        company = null;
        edit = false;
    }
    
    public Contact currentContact(){
        return this.contact;
    }
    
    public Company currentCompany(){
        return this.company;
    }
    
    public boolean isEditable(){
        return edit;
    }
    
    public void changeContact(Contact c){
        this.contact = c;
    }
    
    public void changeCompany(Company c){
        this.company = c;
    }
    
    public void changeActive(){
        edit = true;
    }
    
}
