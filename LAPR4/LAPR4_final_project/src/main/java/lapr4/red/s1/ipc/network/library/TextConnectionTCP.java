/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.network.library;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.blue.s2.ipc.n1150433.networkAnalizer.domain.TrafficAnalizer;

/**
 * TODO: Remove comments after rest of library is pushed.
 *
 * @author 1150710@isep.ipp.pt 1150710 Edited by Débora Costa 1150433
 * @author 1150710@isep.ipp.pt 1150710
 * Edited by Débora Costa 1150433
 */
public class TextConnectionTCP {

    private int tcpPort;
    private ServerSocket s;
    

    /**
     *
     * @param tcpPort
     */
    public TextConnectionTCP(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public int getTcpPort() {
        return tcpPort;
    }

    /**
     * starts
     *
     * @param server
     * @return
     */
    public ReceiverTCP tcpListener(MessageReceiverInterface server) {
        ReceiverTCP a = null;

        try {
            s = new ServerSocket(0);
            tcpPort = s.getLocalPort();    // returns the port the system selected
            a = new ReceiverTCP(s, server);
            a.start();
        } catch (IOException ex) {
            Logger.getLogger(TextConnectionTCP.class.getName()).log(Level.SEVERE, null, ex);
        }

       

        return a;
    }

    

    /**
     * starts
     *
     * @param messageToSend
     * @param addresToSend
     * @return 
     */
    public boolean tcpSenderSendMessage(String messageToSend, NetworkAddress addresToSend) {
        SenderTCP b = new SenderTCP(messageToSend);
        return b.sendMessage(addresToSend);
    }

    /**
     * EDITED by Débora Costa (1150433) added the incoming traffic counter
     * receives a message from the client
     */
    public class ReceiverTCP extends Thread {

        private String message;
        private final MessageReceiverInterface server;

        public ReceiverTCP(ServerSocket s, MessageReceiverInterface server) {
            this.server = server;
            message = "";
            tcpPort = s.getLocalPort();
        }

        public String getMessage() {
            return message;
        }

        public int getTcpPort() {
            return tcpPort;
        }

        /**
         *
         */
        @Override
        public void run() {
            try {

                while (true) {
                    Socket connectionSocket = s.accept();
                    BufferedReader inFromClient
                            = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                    message = inFromClient.readLine();
                    System.out.println("»»» Received: " + message);
                    /**
                     * make something in the code
                     */
                    server.messageReceivedTrigger(message);
                    TrafficAnalizer.totalIncoming();
                }
            } catch (IOException ex) {
                Logger.getLogger(TextConnectionTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * EDITED by Débora Costa (1150433) added the outgoing traffic counter sends
     * a message to server
     */
    public class SenderTCP {

        private final String messageToSend;

        public SenderTCP(String messageToSend) {
            this.messageToSend = messageToSend;
        }

        public boolean sendMessage(NetworkAddress addressToSend) {
            try {
                /**
                 * open socket
                 */
                Socket clientSocket = new Socket(addressToSend.getAddress(), tcpPort);
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

                outToServer.writeBytes(messageToSend + '\n');
                TrafficAnalizer.totalOutgoing();
                clientSocket.close();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(TextConnectionTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

}
