/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.network.library;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import lapr4.blue.s2.ipc.n1150433.networkAnalizer.domain.TrafficAnalizer;

/**
 *
 * @author Barros
 * Edited by Débora Costa 1150433
 */
public class ConnectionUDP {

    private final int portNumber;

    /**
     * when a error in the IP detector is detected it returns a Strigng
     * 172.0.0.2
     */
    private static final String ERROR_RETURN_DEFAULT = "127.0.0.2";
    private static final String LOCALHOST_DEFAULT = "127.0.0.1";

    public ConnectionUDP(int portNumber) {
        this.portNumber = portNumber;
    }

    /**
     *
     * @param message
     * @param addres
     * @return
     */
    public boolean sendMessageUDP(String message, NetworkAddress addres) {
        UDPSenderManager udpStringManager = new UDPSenderManager(message, addres);
        return udpStringManager.send();
    }

    /**
     *
     * @param c
     * @return
     */
    public UDPReceiverManager startReceiveMessage(MessageReceiverInterface c) {
        UDPReceiverManager dPReceiverManager = new UDPReceiverManager(c);
        dPReceiverManager.start();
        return dPReceiverManager;
    }

    /**
     * EDITED by Débora Costa (1150433) added the outgoing traffic counter
     */
    protected class UDPSenderManager {

        /**
         * client address to send , or broadcast address
         */
        private final NetworkAddress addressToSend;
        private final String messageToSend;
        private static final String MESSAGE_TO_SEND_DEFAULT = "No message inserted";

        /**
         *
         * @param messageToSend
         * @param addressToSend
         *
         */
        public UDPSenderManager(String messageToSend, NetworkAddress addressToSend) {
            if (!messageToSend.isEmpty()) {
                this.messageToSend = messageToSend;
            } else {
                this.messageToSend = MESSAGE_TO_SEND_DEFAULT;
            }
            this.addressToSend = addressToSend;
        }

        public boolean send() {
            try {
                String host = addressToSend.getAddress();
                if (host.equals(ERROR_RETURN_DEFAULT)) {
                    host = LOCALHOST_DEFAULT;
                }

                //String to send
                byte[] message = messageToSend.getBytes();

                // Get the internet address of the specified host
                InetAddress address = InetAddress.getByName(host);

                // Initialize a datagram packet with data and address
                DatagramPacket packet = new DatagramPacket(message, message.length, address, portNumber);

                try {
                    // Create a datagram socket, send the packet through it and close it.
                    DatagramSocket dsocket = new DatagramSocket();
                    dsocket.send(packet);
                    /**
                     * @TODO: Remove print when the method is tested
                     */
                    //System.out.println("--> Port: " + portNumber + "--> To address" + host + " -->To send " + messageToSend);
                    TrafficAnalizer.totalOutgoing();
                    //TODO: ADD log here
                } catch (IOException e) {
                    //TODO: ADD log here
                    System.out.println(e.toString());
                    return false;
                }
            } catch (IOException e) {
                //TODO: ADD log here
                System.err.println(e);
                return false;
            }

            return true;
        }
    }

    /**
     * EDITED by Débora Costa (1150433) added the outgoing traffic counter
     */
    public class UDPReceiverManager extends Thread {

        private String messageUDP;
        private final MessageReceiverInterface messageReceiver;
        private static final int BYTE_SIZE_DEFAULT = 2048;
        public UDPReceiverManager(MessageReceiverInterface messageReceiver) {
            this.messageReceiver = messageReceiver;
            messageUDP = "";
        }

        public String receivedString() {
            return messageUDP;
        }

        /**
         * this will work in a different tread IS enabled by the "start()"
         * command
         */
        @Override
        public void run() {
            try {
                // Create a socket to listen on the specified port.
                DatagramSocket dsocket = new DatagramSocket(portNumber);

                // Create a buffer to read datagrams into. If a
                // packet is larger than this buffer, the
                // excess will simply be discarded!
                byte[] buffer = new byte[BYTE_SIZE_DEFAULT];

                // Create a packet to receive data into the buffer
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Now, an infinite loop, waiting to receive packets and printing them.
                while (true) {
                    //TODO: Should be removed after properly tested
                    //System.out.println("--> UDP Thread PORT: " + portNumber + " --> Waiting for UDP package...");
                    // Wait to receive a datagram
                    dsocket.receive(packet);

                    // Convert the contents to a string, and display them
                    messageUDP = new String(buffer, 0, packet.getLength());
                    //TODO: Should be removed after properly tested
                    //System.out.println("#####--> UDP Thread --> RECEIVED!!!!!!!!!  -->  " + messageUDP);
                    messageReceiver.messageReceivedTrigger(messageUDP);
                    TrafficAnalizer.totalIncoming();
                    //TODO: ADD log here
                    // Reset the length of the packet before reusing it.
                    packet.setLength(buffer.length);
                }
            } catch (IOException e) {
                //TODO: ADD log here
                System.err.println(e);
            }
            this.interrupt();
        }
    }
}
