/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1140412.sendEmailSMS.Controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import lapr4.red.s3.core.n1140412.sendEmailSMS.ContactsHandler;
import lapr4.red.s3.core.n1140412.sendEmailSMS.EmailSMSHandler;
import lapr4.white.s1.core.n4567890.contacts.ExtensionSettings;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.PersistenceContext;

/**
 *
 * @author Tiago
 */
public class EmailSMSController {

    private Properties appProps;
    private final ExtensionSettings extensionSettings;
    private final PersistenceContext persistenceContext;
    private final ContactRepository contactsRepository;
    private final ContactsHandler contactHandler;
    private List<String> recipientsList = new ArrayList<>();

    public EmailSMSController(Properties props) {
        this.appProps = props;
        this.extensionSettings = new ExtensionSettings(this.appProps);
        this.persistenceContext = new PersistenceContext(this.extensionSettings);
        this.contactsRepository = this.persistenceContext.repositories().contacts();
        this.contactHandler = new ContactsHandler((List) contactsRepository.findAllContacts());
    }

    public List<String> listAllEmails() {
        return contactHandler.allContactsEmail();
    }

    public List<String> listEmailsByProfession(List<String> profession) {
        return contactHandler.emailsByProfession(profession);
    }

    public List<String> listEmailsByTags(List<String> tag) {

        return contactHandler.emailsByTag(tag);
    }

    public List<String> listallPhones() {
        return contactHandler.allContactsPhone();
    }

    public List<String> listPhonesByProfession(List<String> professions) {
        return contactHandler.phonesByProfession(professions);
    }

    public List<String> listPhonesByTag(List<String> tags) {
        return contactHandler.phonesByTag(tags);
    }

    public boolean sendEmail(String subject, String body) throws IOException, URISyntaxException {
        List<String> list = new ArrayList<>();
        for (String s : this.recipientsList) {
            s = s.split(" ")[0];
            list.add(s);
        }
        return EmailSMSHandler.sendMail(list, subject, body);
    }

    public boolean sendSMS(String body) {
        //theres no method to send a sms because its a simulated operation
        return true;
    }

    public void setRecipientsList(List<String> recipientsList) {
        this.recipientsList = recipientsList;
    }

    public DefaultListModel listForUI(List<String> list) {

        DefaultListModel ret = new DefaultListModel();
        for (String s : list) {
            ret.addElement(s);
        }
        return ret;
    }

    public List<String> listProfessions() {
        return contactHandler.listAllAvailbleProfessions();
    }

    public List<String> listTags() {
        return contactHandler.listAllAvailbleTags();
    }

    public void saveSMS(String body) {
        List<String> list = new ArrayList<>();
        for (String s : this.recipientsList) {
            s = s.split(" ")[0];
            list.add(s);
        }
        try {
            EmailSMSHandler.saveEmailSMS("SMS", list, "", body);
        } catch (IOException ex) {
            Logger.getLogger(EmailSMSController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> getSentMessages() {
        List<String> ret = new ArrayList<>();
        for (String s : EmailSMSHandler.getSentMessages()) {
            String[] aux = s.split(";");
            if (aux[0].equalsIgnoreCase("Email")) {
                aux[0] = "Type:" + aux[0];
                ret.add(aux[0]);
                aux[1] = "Recipients:" + aux[1];
                ret.add(aux[1]);
                aux[2] = "Subject:" + aux[2];
                ret.add(aux[2]);
                aux[3] = "Body:" + aux[3];
                ret.add(aux[3]);
            } else if(aux[0].equalsIgnoreCase("SMS")){
                aux[0] = "Type:" + aux[0];
                ret.add(aux[0]);
                aux[1] = "Recipients:" + aux[1];
                ret.add(aux[1]);
                aux[2] = "Body:" + aux[2];
                ret.add(aux[2]);

            }
        }
        return ret;
    }
}
