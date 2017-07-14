/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1151117.contactstags.domain;

import eapli.util.Strings;
import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * The class will represent a tag associated to a contact
 *
 * @author Barros
 */
@Embeddable
public class Tag implements Comparable<Tag>, Serializable{

    /**
     * the tag value
     */
    private String description;

    /**
     * A constructor only for database purposes
     */
    protected Tag() {
        //for orm
    }

    /**
     * Constructs a new tag with a description as parameter
     *
     * @param description
     */
    public Tag(String description) {
        if (Strings.isNullOrEmpty(description) || Strings.isNullOrWhiteSpace(description)) {
            throw new IllegalStateException();
        }
        if (description.contains(" ")) {
            throw new IllegalStateException();
        }
        this.description = description;
    }

    /**
     * Returns the tag value
     *
     * @return the tag value
     */
    public String tagValue() {
        return this.description;
    }

    @Override
    public int compareTo(Tag o) {
        return tagValue().compareTo(o.tagValue());
    }

}
