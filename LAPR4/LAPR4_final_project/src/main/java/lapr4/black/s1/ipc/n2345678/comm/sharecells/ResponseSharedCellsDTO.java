/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.black.s1.ipc.n2345678.comm.sharecells;

import csheets.core.Address;
import java.io.Serializable;

/**
 *
 * @author alexandrebraganca
 */
public class ResponseSharedCellsDTO implements Serializable {
    
    private String spreadsheetName;
    private Address address1;
    private Address address2;
    private SharedCellsStatusResponse status;
    
    public ResponseSharedCellsDTO(String name, Address addr1, Address addr2, SharedCellsStatusResponse stat) {
        spreadsheetName=name;
        address1=addr1;
        address2=addr2;
        stat=status;
    }
    
    public enum SharedCellsStatusResponse {
        OK, ERROR 
    }
    
    public String getSpreadsheetName() {
        return spreadsheetName;
    }
    
    public Address getAddress1() {
        return address1;
    }
    
    public Address getAddress2() {
        return address2;
    }

    public SharedCellsStatusResponse getStatus() {
        return status;
    }
}
