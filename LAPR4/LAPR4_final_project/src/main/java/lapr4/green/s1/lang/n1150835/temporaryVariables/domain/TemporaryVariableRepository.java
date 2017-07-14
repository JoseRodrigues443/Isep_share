/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150835.temporaryVariables.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository for TemporaryVariables
 * 
 * @author Rui Braga
 */
public class TemporaryVariableRepository implements Serializable{
    
    /**
     * Temporary list
     */
    private List<TemporaryVariable> tempList;
    
    /**
     * Constructor 
     */
    public TemporaryVariableRepository() {
       this.tempList=new ArrayList<>();
    }

    /**
     * If it exists on the list it does not add it it only returns it 
     * otherwise it creates the newtemp and adds it to the list
     * @param tempvarName name of the temporary variable to searched or created
     * @return temporaryVariable
     */
    public TemporaryVariable getTemporaryVariable(String tempvarName) {
        TemporaryVariable newtemp = new TemporaryVariable();
        
        for (TemporaryVariable temp : tempList) {
            if (temp.getName().equalsIgnoreCase(tempvarName)) {
                return temp;
            } 
        }
        
        newtemp = new TemporaryVariable(tempvarName);
        this.tempList.add(newtemp);
        
        return newtemp;
    }
    
    /**
     * Cleans the Temporary Repository list
     */
    public void clearRepo() {
        this.tempList.clear();
    }
    /**
     * @return the tempList 
     */
    public List<TemporaryVariable> getTempList() {
        return tempList;
    }
    /**
     * @param tempList the tempList to set
     */
    public void setTempList(List<TemporaryVariable> tempList) {
        this.tempList = tempList;
    }

}
