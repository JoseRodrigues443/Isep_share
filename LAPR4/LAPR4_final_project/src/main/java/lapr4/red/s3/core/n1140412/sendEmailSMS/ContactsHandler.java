/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1140412.sendEmailSMS;

import java.util.ArrayList;
import java.util.List;
import lapr4.red.s3.core.n1151117.contactstags.domain.Tag;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author Tiago
 */
public class ContactsHandler {

    /**
     * Current contacts list
     */
    private final List<Contact> contactList;

    /**
     * ContactsHandler constructor
     *
     * @param list
     */
    public ContactsHandler(List<Contact> list) {
        this.contactList = list;
    }

    /**
     * Returns every email from the contacts list
     *
     * @return List
     */
    public List<String> allContactsEmail() {
        List<String> ret = new ArrayList<>();
        for (Contact c : contactList) {
            ret.add(c.mainEmail().email() + " " + c.firstName() + " " + c.lastName());
        }
        return ret;
    }

    public List<String> allContactsPhone() {
        List<String> ret = new ArrayList<>();
        for (Contact c : contactList) {
            if (c.workPhone() != null) {
                ret.add(c.workPhone().phoneNumber() + " " + c.firstName() + " " + c.lastName());
            } else if (c.celular1() != null) {
                ret.add(c.celular1().phoneNumber() + " " + c.firstName() + " " + c.lastName());
            } else if (c.celular2() != null) {
                ret.add(c.celular2().phoneNumber() + " " + c.firstName() + " " + c.lastName());
            } else if (c.homePhone() != null) {
                ret.add(c.homePhone().phoneNumber() + " " + c.firstName() + " " + c.lastName());
            } else {

            }
        }

        return ret;
    }

    /**
     * Returns all emails from the contacts with the same profession
     *
     * @param profession
     * @return List
     */
    public List<String> emailsByProfession(List<String> profession) {
        List<String> ret = new ArrayList<>();
        for (Contact c : contactList) {
            for (String s : profession) {
                if (c.getProfession().equals(s)) {
                    ret.add(c.mainEmail().email());
                }
            }
        }

        return ret;
    }

    public List<String> phonesByProfession(List<String> profession) {
        List<String> ret = new ArrayList<>();
        for (Contact c : contactList) {
            for (String s : profession) {
                if (c.getProfession().equals(s)) {
                    if (c.workPhone() != null) {
                        ret.add(c.workPhone().phoneNumber() + " " + c.firstName() + " " + c.lastName());
                    } else if (c.celular1() != null) {
                        ret.add(c.celular1().phoneNumber() + " " + c.firstName() + " " + c.lastName());
                    } else if (c.celular2() != null) {
                        ret.add(c.celular2().phoneNumber() + " " + c.firstName() + " " + c.lastName());
                    } else if (c.homePhone() != null) {
                        ret.add(c.homePhone().phoneNumber() + " " + c.firstName() + " " + c.lastName());
                    } else {

                    }
                }
            }

        }

        return ret;
    }

    /**
     * Returns all emails from the contacts with the same tags
     *
     * @param tagDescription
     * @return List
     */
    public List<String> emailsByTag(List<String> tagDescription) {
        //Tag tag = new Tag(tagDescription);
        List<String> ret = new ArrayList<>();
        for (Contact c : contactList) {
            for (Tag t : c.allAssociatedTags()) {
                for (String s : tagDescription) {
                    if (t.tagValue().equalsIgnoreCase(s)) {
                        ret.add(c.mainEmail().email());
                    }
                }

            }
        }

        return ret;
    }

    public List<String> phonesByTag(List<String> tagDescription) {
//        Tag tag = new Tag(tagDescription);
        List<String> ret = new ArrayList<>();
        for (Contact c : contactList) {
            for (Tag t : c.allAssociatedTags()) {
                for (String s : tagDescription) {
                    if (t.tagValue().equalsIgnoreCase(s)) {
                        if (c.workPhone() != null) {
                            ret.add(c.workPhone().phoneNumber() + " " + c.firstName() + " " + c.lastName());
                        } else if (c.celular1() != null) {
                            ret.add(c.celular1().phoneNumber() + " " + c.firstName() + " " + c.lastName());
                        } else if (c.celular2() != null) {
                            ret.add(c.celular2().phoneNumber() + " " + c.firstName() + " " + c.lastName());
                        } else if (c.homePhone() != null) {
                            ret.add(c.homePhone().phoneNumber() + " " + c.firstName() + " " + c.lastName());
                        } else {

                        }
                    }
                }
            }
        }

        return ret;
    }

    /**
     * Lists all available professions
     *
     * @return List
     */
    public List<String> listAllAvailbleProfessions() {
        List<String> ret = new ArrayList<>();

        for (Contact c : contactList) {
            if (!ret.contains(c.getProfession())) {
                ret.add(c.getProfession());
            }
        }
        return ret;
    }

    /**
     * Lists all available tags
     *
     * @return List
     */
    public List<String> listAllAvailbleTags() {
        List<String> ret = new ArrayList<>();

        for (Contact c : contactList) {
            for (Tag t : c.allAssociatedTags()) {

                if (!ret.contains(t.tagValue())) {
                    ret.add(t.tagValue());
                }
            }
        }
        return ret;
    }
}
