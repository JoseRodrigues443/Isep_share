/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Débora Costa - 1150433
 */
@Entity
public class PostalCode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String postalCode;
    
    protected PostalCode(){
        //for orm
    }
    
    public PostalCode(String postalCode){
        this.postalCode = postalCode;
    }
    
    public String postalCode(){
        return postalCode;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean validatePortugueseCodes(Iterable<PostalCode>list){
        for (PostalCode code : list) {
            if (code.postalCode().equals(code)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PostalCode)) {
            return false;
        }
        PostalCode other = (PostalCode) object;
        if ((this.postalCode == null && other.postalCode != null) || (this.postalCode != null && !this.postalCode.equals(other.postalCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lapr4.blue.s1.core.n1150433.addressEdition.domain.PostalCode[ id=" + id + " ]";
    }
    
}
