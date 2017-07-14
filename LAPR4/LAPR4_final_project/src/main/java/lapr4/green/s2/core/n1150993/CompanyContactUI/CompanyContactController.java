/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150993.CompanyContactUI;

import eapli.framework.application.Controller;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import lapr4.green.s2.core.n1150993.CompanyContact.Company;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.CompanyRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.PersistenceContext;

/**
 *
 * @author 1150993
 * 
 * Edited by José Barros (1151117)
 */
public class CompanyContactController implements Controller{
    
    private final Properties appProps;
    private final CompanyRepository companyRepository;
    private final ExtensionSettings extensionSettings;
    private final PersistenceContext persistanceContext;
    
    /*
    *Creates an instance of CompanyContactController.
    *
    *@param appProps
    */
    public CompanyContactController(Properties appProps){
        this.appProps=appProps;
        this.extensionSettings=new ExtensionSettings(this.appProps);
        this.persistanceContext=new PersistenceContext(this.extensionSettings);
        this.companyRepository=this.persistanceContext.repositories().company();
    }
    
    /*
    *Create an instance of Company.
    *
    *@param nameOfCompany The name of company created
    *@return company The company created
    */
    public Company newCompanyContact(String nameOfCompany){
        return new Company(nameOfCompany);  
    }
    
    /*
    *Save the company received as parameter on database.
    *
    *@param c The company to save
    */
    public void save(Company c) throws DataConcurrencyException, DataIntegrityViolationException{
      if(this.companyRepository.validateCompany(c)==true){
           this.companyRepository.save(c);
      }  
    }
    
    /*
    *Get all companys of database.
    *
    *@return companysList List of all companys of database
    */
    public List<Company> getAllCompanys(){
        return this.companyRepository.getAllCompanys();
    }
    
    /*
    *Edit a company received as parameter.
    *
    *@param c Company to edit
    *@param nameOfCompany The new name of company
    */
    public void editCompany(Company c, String nameOfCompany){
       this.companyRepository.editCompany(c, nameOfCompany);
    }
    
    /*
    *Remove a company of database.
    *
    *@param c Company to remove
    *@return true if company is removed
    */
    public boolean removeCompany(Company c){
        return this.companyRepository.removeCompany(c);
    }
    
    public CompanyRepository getRepository(){
        return this.companyRepository;
    }
    
    public Company getCompanyById(Long id) {
        Optional<Company> c = this.companyRepository.findOne(id);
        if (c.isPresent()) {
            return c.get();
        } else {
            return null;
        }
    }
     
    public Iterable<Company> companysByTagValue(String t){
        return companyRepository.companysByTagValue(t);
    }
    
}
