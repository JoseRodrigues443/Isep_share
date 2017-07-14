/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.domain;

import java.util.HashSet;
import java.util.Set;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.email.Email;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode.CountryCode;
import lapr4.red.s3.core.n1151117.contactstags.domain.Tag;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1150595
 */
public class ContactTest {

    public ContactTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of updatePhones method, of class Contact.
     */
    @Test
    public void testUpdatePhones() {
        System.out.println("updatePhones");
        String workPhoneNum = "+351910920749";
        String homePhoneNum = "";
        String celular1Num = "";
        String celular2Num = "";
        Set<CountryCode> list = new HashSet<>();
        CountryCode cc = new CountryCode("Portugal", "351");
        cc.addQuantityOfNumbers(9);
        list.add(cc);
        Contact instance = new Contact();
        instance.updatePhones(workPhoneNum, homePhoneNum, celular1Num, celular2Num, list);
        String expResult = workPhoneNum;
        String result = instance.workPhone().phoneNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of updateMainEmail method, of class Contact.
     */
    @Test
    public void testUpdateMainEmail() {
        System.out.println("updateMainEmail");
        String e = "1150595@isep.ipp.pt";
        Contact instance = new Contact();
        instance.updateMainEmail(e);
        String expResult = e;
        String result = instance.mainEmail().email();
        assertEquals(expResult, result);
    }

    /**
     * Test of addEmail method, of class Contact.
     */
    @Test
    public void testAddEmail() {
        System.out.println("addEmail");
        Email email = null;
        String e = "1150595@isep.ipp.pt";
        Contact instance = new Contact();
        boolean expResult = true;
        boolean result = instance.addEmail(email, e);
        assertEquals(expResult, result);
    }

    /**
     * Test of addSecondaryEmail method, of class Contact.
     */
    @Test
    public void testAddSecondaryEmail() {
        System.out.println("addSecondaryEmail");
        String e = "1150595@isep.ipp.pt";
        Contact instance = new Contact();
        boolean expResult = true;
        boolean result = instance.addSecondaryEmail(e);
        assertEquals(expResult, result);
    }

    //Edited by José Barros 1151117
    @Test(expected = IllegalStateException.class)
    public void testTagMustNotBeNullToAdd(){
        System.out.println("test tag to add must not be null");
        Contact c = new Contact();
        c.associateTag(new Tag(null));
    }
    
    @Test
    public void testTagCantBeAddedTwice(){
        System.out.println("test tag can't be added twice");
        Contact c = new Contact();
        Tag t = new Tag("testTag");
        boolean r = c.associateTag(t);
        //tag added successfully
        assertTrue(r);
        r = c.associateTag(t);
        assertTrue(!r);
        //tag not added since already exists
        assertTrue(c.allAssociatedTags().size() == 1);
    }
    
}
