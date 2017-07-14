/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150993.CompanyContact;

import csheets.ui.ctrl.UIController;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.util.ArrayList;
import java.util.List;
import lapr4.green.s2.core.n1150993.CompanyContactUI.CompanyContactController;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author
 */
public class botstrap {

    public botstrap(UIController uiController) throws DataConcurrencyException, DataIntegrityViolationException {
        CompanyContactController controller = new CompanyContactController(uiController.getUserProperties());
        ContactController contactController = new ContactController(uiController.getUserProperties());

        Company comp = new Company("Company1");
        Company comp2 = new Company("Company2");
        controller.save(comp);
        controller.save(comp2);

        Contact p1 = new Contact("Jose Alves", "Jose", "Alves", comp, "professor");
        contactController.addContact(p1);

        Contact p2 = new Contact("Miguel Alves", "Miguel", "Alves", comp2, "carpinteiro");
        contactController.addContact(p2);

    }

}
