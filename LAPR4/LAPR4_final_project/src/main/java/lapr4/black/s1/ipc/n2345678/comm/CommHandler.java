/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lapr4.black.s1.ipc.n2345678.comm;

import java.io.ObjectOutputStream;

/**
 *
 * @author alexandrebraganca
 */
public interface CommHandler {
    /**
     * 
     * @param dto the object received by the socket
     * @param outStream the output stream to be used to send a reply/response to the socket
     */
    public void handleDTO(Object dto, ObjectOutputStream outStream);
    
    public Object getLastReceivedDTO();
}
