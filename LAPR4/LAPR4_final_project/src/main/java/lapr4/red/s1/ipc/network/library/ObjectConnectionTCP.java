/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.network.library;

import csheets.core.Address;
import csheets.core.Cell;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.blue.s2.ipc.n1150433.networkAnalizer.domain.TrafficAnalizer;
import lapr4.blue.s2.ipc.n1150662.sharedCells.CellsSelected;
import lapr4.red.s1.ipc.n1150710.network.shareCell.SelectedCells;

/**
 * TODO: Remove comments after rest of library is pushed.
 *
 * @author 1150710@isep.ipp.pt 1150710 Edited by Débora Costa 1150433
 */
public class ObjectConnectionTCP {

    private int tcpPort;
    private ServerSocket s;
    private ReceiverTCP a;

    /**
     *
     * @param tcpPort
     */
    public ObjectConnectionTCP(int tcpPort) {
        this.tcpPort = tcpPort;
        //System.out.println("Entrei no sendTcp(construtor)");
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
        a = null;

        try {
            s = new ServerSocket(0);
            tcpPort = s.getLocalPort();    // returns the port the system selected
            a = new ReceiverTCP(s, server);
            a.start();
        } catch (IOException ex) {
            Logger.getLogger(ObjectConnectionTCP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return a;
    }

    public void stopThread() {
        a.interrupt();
    }

    /**
     * starts
     *
     * @param messageToSend
     * @param addresToSend
     * @return
     */
    public boolean tcpSenderSendMessage(Object messageToSend, NetworkAddress addresToSend) {

        SenderTCP a = new SenderTCP(messageToSend);

        return a.sendMessage(addresToSend);
    }

    /**
     * EDITED by Débora Costa (1150433) added the incoming traffic counter
     * receives a objectReceived from the client
     */
    public class ReceiverTCP extends Thread {

        private Object objectReceived;
        private final MessageReceiverInterface server;

        public ReceiverTCP(ServerSocket s, MessageReceiverInterface server) {
            this.server = server;
            objectReceived = new Object();
            tcpPort = s.getLocalPort();
        }

        public Object getMessage() {
            return objectReceived;
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
                    ObjectInputStream in = new ObjectInputStream(connectionSocket.getInputStream());
                    objectReceived = in.readObject();

                    server.messageReceivedTrigger(objectReceived);
                    TrafficAnalizer.totalIncoming();
                }
            } catch (IOException ex) {
                Logger.getLogger(ObjectConnectionTCP.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ObjectConnectionTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /**
     * EDITED by Débora Costa (1150433) added the outgoing traffic counter sends
     * a objectReceived to server
     */
    public class SenderTCP {

        private final Object objectToSend;

        public SenderTCP(Object messageToSend) {
            this.objectToSend = messageToSend;

        }

        public boolean sendMessage(NetworkAddress addressToSend) {
            try {

                /**
                 * open socket
                 */
                Socket clientSocket = new Socket(addressToSend.getAddress(), tcpPort);
                //DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());

                outToServer.writeObject(objectToSend);
                /**
                 * send object
                 */
                outToServer.flush();
                //System.out.println("▓▓▓▓▓▓ » --> --> Sent Object via TCP (serializable)");
//                CellsSelected test = (CellsSelected) objectToSend;
//
//                System.out.println(test.getCellDTOs().get(0).getContent());
                TrafficAnalizer.totalOutgoing();
                clientSocket.close();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(ObjectConnectionTCP.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        }
    }

}
