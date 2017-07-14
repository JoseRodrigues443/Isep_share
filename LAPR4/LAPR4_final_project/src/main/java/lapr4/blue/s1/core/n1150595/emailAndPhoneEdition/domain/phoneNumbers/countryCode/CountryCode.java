/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode;

import eapli.framework.domain.AggregateRoot;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 1150595
 */
@Entity
public class CountryCode implements AggregateRoot, Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String country;
    private String code;
    private List<Integer> quant;

    public CountryCode(String country, String code) {
        this.country = country;
        this.code = code;
        this.quant = new ArrayList<>();
    }

    protected CountryCode() {
        //ORM
    }

    public String country() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String code() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Integer> quantityOfNumbers() {
        return quant;
    }

    public void setQuantityOfNumbers(List<Integer> quant) {
        this.quant = quant;
    }

    public void addQuantityOfNumbers(int n) {
        this.quant.add(n);
    }

    @Override
    public String toString() {
        return "CountryCode{" + "country=" + country + ", code=" + code + '}';
    }

    @Override
    public boolean sameAs(Object other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean is(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object id() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
