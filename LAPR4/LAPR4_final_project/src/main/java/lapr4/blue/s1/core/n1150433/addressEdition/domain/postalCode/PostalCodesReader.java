/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author Débora Costa - 1150433
 */
public class PostalCodesReader {
    private String postalCodesFile;
    private final String FILE_NAME = "todos_cp.txt";
    
    private PostalCodesRepository pcRepository;
    
    public PostalCodesReader(String postalCodesFile, PostalCodesRepository pcRepository){
        this.postalCodesFile = postalCodesFile;
        this.pcRepository = pcRepository;
    }
    
    public PostalCodesReader(){
        this.postalCodesFile = FILE_NAME;
    }
        
    public void readFile() throws FileNotFoundException, IOException, DataConcurrencyException, DataIntegrityViolationException{
        String[]array;
        Scanner file = new Scanner(new File(postalCodesFile));
        String line = null;
        while(file.hasNext()){
            line = file.nextLine();
            if(line.length() > 0){
                array = line.split(";");
                PostalCode validCode = new PostalCode(array[array.length-3]+"-"+array[array.length-2]);
                pcRepository.save(validCode);
            }
            
        }
    }
    
    
    
}
