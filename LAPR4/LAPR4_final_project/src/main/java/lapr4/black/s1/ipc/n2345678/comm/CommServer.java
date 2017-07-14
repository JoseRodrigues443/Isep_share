/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.black.s1.ipc.n2345678.comm;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class should be a singleton.
 *
 * @author alexandrebraganca
 */
public class CommServer extends Thread {

    private final int commServerPort = 15000;

    private static CommServer theCommServer = null;

    private static Map<Class, CommHandler> handlers = new HashMap<Class, CommHandler>();

    private CommServer() {

    }

    public static CommServer getCommServer() {
        if (theCommServer == null) {
            theCommServer = new CommServer();

            theCommServer.start();

            // To test the server we are going to create a simple handler
            //CommHandler aHandler = new HelloHandler();
            //theCommServer.addHandler(HelloRequestDTO.class, aHandler);
        }
        return theCommServer;
    }

    public void addHandler(Class dto, CommHandler handler) {
        handlers.put(dto, handler);
    }

    public CommHandler getHandler(Class dto) {
        return handlers.get(dto);
    }

    /**
     * Starts the server
     *
     */
    @Override
    public void run() {

        ServerSocket aServerSocket=null;
        
        try {

            // We need to make the server execute an "endless" loop accepting clients...
            aServerSocket = new ServerSocket(commServerPort);

            for (;;) {

                Socket aSocket = aServerSocket.accept();

                Logger.getLogger(CommServer.class.getName()).log(Level.INFO, "New client. Socket={0}", aSocket.getPort());
                
                // Here we should create a CommServerWorker to take care of the communication with the client...
                CommServerWorker aWorker = new CommServerWorker(aSocket, this);

                aWorker.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(CommServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                aServerSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(CommServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
