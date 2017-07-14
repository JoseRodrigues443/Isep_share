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
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexandrebraganca
 */
public class CommClientWorker extends Thread {
  
    private final Socket socket;

    private ObjectInputStream inStream;
    private ObjectOutputStream outStream; 
    
    private static final Map<Class, CommHandler> handlers = new HashMap<Class, CommHandler>();
        
    public CommClientWorker (Socket theSocket) {
        socket=theSocket;
        inStream=null;
        outStream=null;
    }
    
    public synchronized ObjectOutputStream getObjectOutputStream() throws IOException {
        if (outStream!=null) return outStream;
        else {
            outStream = new ObjectOutputStream(socket.getOutputStream()); 
            
            return outStream;
        }
    }
    
    public synchronized ObjectInputStream getObjectInputStream() throws IOException {
        if (inStream!=null) return inStream;
        else {
            inStream = new ObjectInputStream(socket.getInputStream());
            
            return inStream;
        }
    }
    
    
    public void addHandler(Class dto, CommHandler handler) {
        handlers.put(dto, handler);
    }

    public CommHandler getHandler(Class dto) {
        return handlers.get(dto);
    }  
    
    /**
     * Will close the socket which will result in the thread being terminated  
     */
    public synchronized void terminateExecution() {
        try {
            if (inStream!=null) {
                inStream.close();
                inStream=null;
            }
            if (outStream!=null) {
                outStream.close();
                outStream=null;
            }
            if (socket!=null) { 
                socket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(CommClientWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param inDTO inDTO
     */
    private void processIncommingDTO(Object inDTO) {
        CommHandler handler=getHandler(inDTO.getClass());
        
        if (handler!=null) {
            handler.handleDTO(inDTO, outStream);
        }
    }    
   
    @Override
    public void run() {
        // A loop receiving and processing DTOs...
        try {
            
            getObjectOutputStream();
            getObjectInputStream();

            
            for (;;) {
                Object dto  = inStream.readObject();
            
                processIncommingDTO(dto);
            }
            
        } catch (EOFException ex) {
            Logger.getLogger(CommClientWorker.class.getName()).log(Level.WARNING, "EOF. The server seems to have closed the connection. Will terminate the worker thread.");            
        } catch (java.net.SocketException ex) {
            Logger.getLogger(CommClientWorker.class.getName()).log(Level.WARNING, "The server seems to have closed the connection. Will terminate the worker thread.");                        
        } catch (IOException ex) {
            Logger.getLogger(CommClientWorker.class.getName()).log(Level.WARNING, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CommClientWorker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (inStream!=null) inStream.close();
                if (outStream!=null) outStream.close();
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(CommClientWorker.class.getName()).log(Level.WARNING, null, ex);
            }
        }
    }    
}
