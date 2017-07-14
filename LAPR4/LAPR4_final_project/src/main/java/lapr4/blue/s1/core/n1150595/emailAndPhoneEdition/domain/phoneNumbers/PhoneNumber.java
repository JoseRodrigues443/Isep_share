/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers;

import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode.CountryCodeRepository;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode.CountryCode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
public class PhoneNumber implements Serializable {

    @Id
    @GeneratedValue
    private Long pk;

    private String phoneNumber;

    /**
     * Creates a new phone number
     *
     * @param phoneNumber
     */
    public PhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    protected PhoneNumber() {
        //ORM
    }

    public String phoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Validates the phone number using regex
     *
     * @param list
     * @return if the phone number is valid or not
     */
    public boolean phoneValidation(Set<CountryCode> list) {
        Pattern pattern;
        Matcher matcher;
        boolean ret = false;

        for (CountryCode cc : list) {
            int n = cc.code().length() + 1;
            if (cc.code().equals(this.phoneNumber.substring(1, n))) {
                List<String> patterns = patterns(cc);

                for (int i = 0; i < patterns.size(); i++) {
                    pattern = Pattern.compile(patterns.get(i));
                    matcher = pattern.matcher(this.phoneNumber);
                    ret = matcher.matches();
                    if (ret == true) {
                        return ret;
                    }
                }

            }
        }
        return ret;
    }

    /**
     * Returns the possible number patterns for a specific Country Code
     *
     * @param cc Country Code
     * @return the patterns
     */
    public List<String> patterns(CountryCode cc) {
        List<String> patterns = new ArrayList<>();
        String p = "";
        List<Integer> quants = cc.quantityOfNumbers();
        for (int i = 0; i < quants.size(); i++) {
            if (quants.get(i) == 0) {
                p = "\\+" + cc.code() + "[1-9][0-9]{3,11}";
            } else {
                p = "\\+" + cc.code() + "[1-9][0-9]{" + (quants.get(i) - 1) + "}";
            }
            patterns.add(p);
        }
        return patterns;
    }

}
