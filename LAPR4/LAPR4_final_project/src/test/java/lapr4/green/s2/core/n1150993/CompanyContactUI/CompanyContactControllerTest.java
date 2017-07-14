/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150993.CompanyContactUI;

import csheets.CleanSheets;
import csheets.ui.ctrl.UIController;
import java.util.List;
import lapr4.green.s2.core.n1150993.CompanyContact.Company;
import lapr4.white.s1.core.n4567890.contacts.persistence.CompanyRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Catarina Sousa
 */
public class CompanyContactControllerTest {
    
    CompanyContactController instance;
    UIController uictrl;
    CompanyRepository rep;
    
    public CompanyContactControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        CleanSheets app = new CleanSheets();
        uictrl = new UIController(app);
        instance = new CompanyContactController(uictrl.getUserProperties());
        rep = instance.getRepository();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of newCompanyContact method, of class CompanyContactController.
     */
    @Ignore
    @Test
    public void testNewCompanyContact() {
        System.out.println("newCompanyContact");
        String nameOfCompany = "ACompany";
        Company expResult = new Company(nameOfCompany);
        Company result = instance.newCompanyContact(nameOfCompany);
        assertEquals(expResult, result);
    }

    /**
     * Test of save method, of class CompanyContactController.
     */
    @Ignore
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Company c = new Company("ACompany");
        instance.save(c);
        boolean verify=false;
        for (Company aux :instance.getRepository().getAllCompanys()) {
            if (aux.name().equals(c.name())) {
                verify=true;
            }
        }
        assertTrue(verify);
    }

    /**
     * Test of getAllCompanys method, of class CompanyContactController.
     */
    @Ignore
    @Test
    public void testGetAllCompanys() {
        System.out.println("getAllCompanys");
        List<Company> expResult = null;
        List<Company> result = instance.getAllCompanys();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editCompany method, of class CompanyContactController.
     */
    @Ignore
    @Test
    public void testEditCompany() {
        System.out.println("editCompany");
        Company c = new Company("ACompany");
        String nameOfCompany = "CCompany";
        instance.editCompany(c, nameOfCompany);
        assertEquals(nameOfCompany,c.name());
    }

    /**
     * Test of removeCompany method, of class CompanyContactController.
     */
    @Ignore
    @Test
    public void testRemoveCompany() {
        System.out.println("removeCompany");
        Company c = null;
        boolean expResult = false;
        boolean result = instance.removeCompany(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRepository method, of class CompanyContactController.
     */
    @Ignore
    @Test
    public void testGetRepository() {
        System.out.println("getRepository");
        CompanyRepository expResult = null;
        CompanyRepository result = instance.getRepository();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompanyById method, of class CompanyContactController.
     */
    @Ignore
    @Test
    public void testGetCompanyById() {
        System.out.println("getCompanyById");
        Long id = null;
        Company expResult = null;
        Company result = instance.getCompanyById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
