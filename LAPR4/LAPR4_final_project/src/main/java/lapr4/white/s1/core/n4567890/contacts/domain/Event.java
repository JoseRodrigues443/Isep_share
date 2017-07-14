/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author alexandrebraganca edited by Ana Pacheco (1130697)
 */
@Entity
public class Event {

    // ORM primary key
    @Id
    @GeneratedValue
    private Long pk;

    private String description;
    private Contact c;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dueDate;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    
    private Contact contact;

    protected Event() {
        // for ORM
    }

    public Event(Contact c,final String description, final String dueDate) throws ParseException {
        this.description = description;
        this.contact=c;
        convertDate(dueDate);
        
//        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//       this.dueDate = isValid(dueDate);
////        Date date = formatter.parse(dueDate);
////        this.dueDate.setTime(date);
    }
    
    public void convertDate(String date){
        String[] d=date.split("/");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, Integer.parseInt(d[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(d[1]));
        cal.set(Calendar.YEAR, Integer.parseInt(d[2]));
        this.date = cal.getTime();
    }
    
    public void setDate(String date){
        this.convertDate(date);
    }

    public String description() {
        return this.description;
    }

    public void newDescription(String description) {
        this.description = description;
    }

    
    /**
     * @return the dueDate
     */
    public Calendar dueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

   

    public Calendar isValid(String date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            Date auxDate = sdf.parse(date);
            if (auxDate.after(new Date(9999, 12, 30))) {
                return null;
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(auxDate);
            Calendar now = Calendar.getInstance();
            if (cal.get(cal.DAY_OF_WEEK) == now.get(now.DAY_OF_WEEK)
                    && cal.get(cal.DAY_OF_MONTH) == now.get(now.DAY_OF_MONTH)
                    && cal.get(cal.DAY_OF_YEAR) == now.get(now.DAY_OF_YEAR)) {
                return cal;
            }
            if (cal.after(now)) {
                return cal;
            } else {
                return null;
            }
        } catch (ParseException e) {
            return null;
        }
    }
    
    public String toStringDate(){
        return this.date.toString();
    }
    
    @Override
    public String toString(){
        return this.description + "(" + toStringDate() + ")" + this.contact.name();
    }

    /**
     * @return the contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    /**
     * @return the pk
     */
    public Long getPk() {
        return pk;
    }
}
