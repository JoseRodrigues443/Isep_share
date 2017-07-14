/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lapr4.black.s1.ipc.n2345678.comm;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandrebraganca
 */
public class CommServerWorker extends Thread {

    private Socket socket;
    private CommServer server;
    
    private ObjectInputStream inStream;
    private ObjectOutputStream outStream; 
    
    private Map<Class, CommHandler> handlers = new HashMap<Class, CommHandler>();
    
    public CommServerWorker(Socket theSocket, CommServer theServer) {
        socket=theSocket;
        server=theServer;
        inStream=null;
        outStream=null;
    }
        
    /**
     * 
     * @param inDTO inDTO
     */
    private void processIncommingDTO(Object inDTO) {
        CommHandler handler=server.getHandler(inDTO.getClass());
        
        if (handler!=null) {
            handler.handleDTO(inDTO, outStream);
        }
    }
    
    @Override
    public void run() {
        // A loop receiving and processing DTOs...
        try {

            outStream = new ObjectOutputStream(socket.getOutputStream());
            inStream = new ObjectInputStream(socket.getInputStream());

            for (;;) {
            
                Object dto  = inStream.readObject();
                
            
                processIncommingDTO(dto);
        
            }
            
        } catch (EOFException ex) {
            Logger.getLogger(CommServerWorker.class.getName()).log(Level.WARNING, "The client seems to have closed the connection. Will terminate the worker thread.");
        } catch (IOException ex) {
            Logger.getLogger(CommServerWorker.class.getName()).log(Level.WARNING, "Erro no loop da worker thread", ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommServerWorker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (inStream!=null) {
                    inStream.close();
                    inStream=null;
                }
                if (outStream!=null) {
                    outStream.close();
                    outStream=null;
                }
                if (socket!=null) socket.close();
            } catch (IOException ex) {
                Logger.getLogger(CommServerWorker.class.getName()).log(Level.WARNING, null, ex);
            }
        }
        
        
    }
}
