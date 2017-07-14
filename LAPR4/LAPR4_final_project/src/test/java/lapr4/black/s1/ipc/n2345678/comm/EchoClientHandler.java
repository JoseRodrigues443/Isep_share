/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.black.s1.ipc.n2345678.comm;

import csheets.CleanSheets;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandrebraganca
 */
public class EchoClientHandler implements CommHandler {

    private Object lastReceivedDTO=null;
    
    public EchoClientHandler() {
        
    }
    
    @Override
    public void handleDTO(Object dto, ObjectOutputStream outStream) {
        Logger.getLogger(EchoClientHandler.class.getName()).log(Level.INFO, CleanSheets.getString("received_object"), dto.getClass().toString());
       
        EchoDTO hello=(EchoDTO)dto;
        lastReceivedDTO=hello;
        Logger.getLogger(EchoClientHandler.class.getName()).log(Level.INFO, CleanSheets.getString("message_received"), hello.getMessage());    
    }

    @Override
    public Object getLastReceivedDTO() {
        return lastReceivedDTO;
    }   
}
