/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 1150595
 */
public class CountryCodesReader {

    private String countryCodesFileName;
    private Set<CountryCode> list;
    private CountryCodeRepository ccr;

    /**
     * Creates a new CountryCodesFileReader
     *
     * @param countryCodesFileName file name
     * @param ccr Country Code Repository
     */
    public CountryCodesReader(String countryCodesFileName, CountryCodeRepository ccr) {
        this.countryCodesFileName = countryCodesFileName;
        this.list = new HashSet<>();
        this.ccr = ccr;
    }

    /**
     * Method that reads and saves the country codes
     */
    public void read() throws DataConcurrencyException, DataIntegrityViolationException {

        String line = "";

        try {
            Scanner ler = new Scanner(new File(this.countryCodesFileName));
            while (ler.hasNextLine()) {
                line = ler.nextLine();
                if (!line.isEmpty()) {
                    String[] s = line.split("/");
                    String[] st = s[1].split("-");
                    String[] ns = st[1].split(";");
                    CountryCode cc = new CountryCode(s[0], st[0]);
                    for (int i = 0; i < ns.length; i++) {
                        cc.addQuantityOfNumbers(Integer.parseInt(ns[i]));
                    }
                    this.list.add(cc);
                    this.ccr.save(cc);
                }
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error reading file that contains the country codes!");
            Logger.getLogger(CountryCodesReader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Set<CountryCode> list() {
        return list;
    }

}
