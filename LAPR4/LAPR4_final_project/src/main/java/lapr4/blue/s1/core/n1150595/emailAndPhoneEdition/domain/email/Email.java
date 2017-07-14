/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author 1150595
 */
@Entity
public class Email {

    @Id
    @GeneratedValue
    private Long pk;

    private String email;

    private static final String PATTERN = "^[_A-Za-z0-9-\\.]+@" + "[A-Za-z0-9-\\.]+(\\.[A-Za-z]{2,})$";

    public Email(String email) {
        this.email = email;
    }

    public Email() {
        //ORM
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Validates the email using a regular expression
     *
     * @return if the email is valid or not
     */
    public boolean validateEmail() {
        boolean ret = false;
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(PATTERN);
        matcher = pattern.matcher(this.email);
        ret = matcher.matches();
        return ret;
    }

    @Override
    public String toString() {
        return email;
    }

}
