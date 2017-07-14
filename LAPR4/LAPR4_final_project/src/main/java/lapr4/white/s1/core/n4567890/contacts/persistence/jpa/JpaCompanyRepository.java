/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.persistence.jpa;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import lapr4.green.s2.core.n1150993.CompanyContact.Company;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.CompanyRepository;


/**
 *
 * @author 1150993
 * 
 * edited by José Barros (1151117)
 */
class JpaCompanyRepository extends CrmJpaRepositoryBase<Company, Long> implements CompanyRepository {
    
    JpaCompanyRepository(ExtensionSettings settings) {
        super(settings);
    }
    
    @Override
    public boolean validateCompany(Company c){
        for(Company company: this.getAllCompanys()){
            if(company.equals(c)){
                return false;
            }
        }
        return true;

    }
    
    @Override
    public boolean saveCompanyContact(Company c){
        boolean resp=false;
        try {
            save(c);
            resp=true;
        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
            Logger.getLogger(JpaCompanyRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }
    
    @Override
    public List<Company> getAllCompanys() {
        List<Company> returnList=new ArrayList<>();
        for(Company c:findAll()){
            returnList.add(c);
        }
       return returnList;
    }
    
    @Override
    public void editCompany(Company c,String name){
        Company nc=null;
        for(Company c1: this.getAllCompanys()){
            if(Objects.equals(c1.id(), c.id())){
                nc=c1;
            }
        }
        nc.setName(name);
        update(nc);
        Company over = null;
         for(Company c2: this.getAllCompanys()){
            if(Objects.equals(c2.id(), c.id())){
                over=c2;
            }
        }
        try {
            save(over);
        } catch (DataConcurrencyException ex) {
            Logger.getLogger(JpaCompanyRepository.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataIntegrityViolationException ex) {
            Logger.getLogger(JpaCompanyRepository.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    @Override
    public boolean removeCompany(Company c){
       try {
            delete(c);
        }
        catch (Exception ex) {
           try {
               throw new DataIntegrityViolationException(ex);
           } catch (DataIntegrityViolationException ex1) {
               Logger.getLogger(JpaCompanyRepository.class.getName()).log(Level.SEVERE, null, ex1);
           }
        }
        return true;
    }

    @Override
    public Iterable<Company> companysByTagValue(String t) {
        String q = "SELECT c " +
            "FROM Company c INNER JOIN c.tags e " +
            "WHERE e.description LIKE :description";
        TypedQuery<Company> query = entityManager().createQuery(q, Company.class);
        query.setParameter("description", t);
        return query.getResultList();
    }
}
