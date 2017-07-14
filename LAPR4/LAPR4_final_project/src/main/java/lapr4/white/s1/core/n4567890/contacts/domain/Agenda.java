/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author alexandrebraganca
 * edited by Ana Pacheco (1130697)
 */
@Entity
public class Agenda implements Serializable {

    // TODO: Devia ser um value object?
    
    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk; 
    
    // Deve conter uma lista de eventos
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Event> events = new HashSet<>();    
    
    protected Agenda() {
        // for ORM
    }
    
    public Long id() {
        return this.pk;
    }

    public boolean add(Event ev) {
        if (ev == null) {
            throw new IllegalStateException();
        }
        // FIXME validations are missing, e.g., add events in the past?
        return this.events.add(ev);
    } 
    
    public Iterable<Event> getAll(){
        return this.events;
    }
    
    public boolean remove(Event ev){
       return this.events.remove(ev);
    }
}