/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lapr4.black.s1.ipc.n2345678.comm;

import java.io.Serializable;

/**
 *
 * @author alexandrebraganca
 */
public class EchoDTO implements Serializable {
    
    public EchoDTO() {
    }

    public EchoDTO(String msg) {
        message=msg;
    }
    
    private String message;

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
