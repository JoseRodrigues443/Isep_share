/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lapr4.black.s1.ipc.n2345678.comm;

import csheets.CleanSheets;
import lapr4.black.s1.ipc.n2345678.comm.CommHandler;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandrebraganca
 */
public class EchoServerHandler implements CommHandler {
    
    private Object lastReceivedDTO=null;
    
    public EchoServerHandler() {
        
    }

    @Override
    public void handleDTO(Object dto, ObjectOutputStream outStream) {
        
        Logger.getLogger(EchoServerHandler.class.getName()).log(Level.INFO, CleanSheets.getString("received_object"), dto.getClass().toString());
       
        EchoDTO hello=(EchoDTO)dto;
        lastReceivedDTO=hello;
        Logger.getLogger(EchoServerHandler.class.getName()).log(Level.INFO, CleanSheets.getString("message_received"), hello.getMessage());
    
        // Lets reply
        EchoDTO reply=new EchoDTO("Reply to "+hello.getMessage());
        try {
            outStream.writeObject(reply);
        } catch (IOException ex) {
            Logger.getLogger(EchoServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Object getLastReceivedDTO() {
        return lastReceivedDTO;
    }
    
}
