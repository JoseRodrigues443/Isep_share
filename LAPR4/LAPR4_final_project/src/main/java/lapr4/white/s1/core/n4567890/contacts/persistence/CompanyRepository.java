/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.persistence;

import eapli.framework.persistence.repositories.Repository;
import java.util.List;
import lapr4.green.s2.core.n1150993.CompanyContact.Company;

/**
 *
 * @author 1150993
 * 
 * Edited by José Barros (1151117)
 */
public interface CompanyRepository extends Repository<Company, Long> {
    boolean validateCompany(Company c);
    boolean saveCompanyContact(Company c);
    List<Company> getAllCompanys();
    void editCompany(Company c, String name);
    boolean removeCompany(Company c);
    Iterable<Company> companysByTagValue(String t);
}
