/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.network.library;

import java.util.ArrayList;

/**
 *
 * USED to all the startup extensions on IPC
 *
 * @author 1150710
 */
public interface ConnectionManagerInterface extends MessageReceiverInterface {

    /**
     * all the machines in the network that use these extension
     *
     * TO CREATE:
     *
     * NetworkMachinesList networkMachinesList = new
     * NetworkMachinesList(NetworkExtensionEnum.EXTENSION oF EXTENSION);
     *
     */
    /**
     * where the listeners and sender will be implemented
     *
     * @return
     */
    boolean start();

    /**
     * LIST for UI
     *
     * @return
     */
    ArrayList<String> getMachineList();
    
    
    
// EXAMPLE:
//   boolean sendAnnouncementTimedUDP(int seconds){
//    int timeInterval = seconds * 1000;   // to miliseconds
//        Timer timerToSendUdp = new Timer();
//        timerToSendUdp.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                        //DO YOUR CODE HERE
//    
//                }
//
//            }
//
//        }, 0, timeInterval);
    /**
     * timer that will send UDP annoucements
     *
     * @param seconds
     * @return
     */
    boolean sendAnnouncementTimedUDP(int seconds);
    
    

    /**
     * creates a new socket to send, and send to a tcp port
     *
     * @param object
     * @param tcpPort
     * @param addressToSend
     * @return  true if sucess to send
     */
    boolean sendTcp(Object object, int tcpPort, NetworkAddress addressToSend);

    
    
    /**
     * starts tge udp listener
     *
     * 
     * 
     */
    void udpListener();
    
    

    /**
     * creates an TCP lister
     *
     * @param mri
     * @return the tcp listener
     */
    ObjectConnectionTCP.ReceiverTCP newTcpListener(MessageReceiverInterface mri);
    
    

    /**
     * when a UDP is received to its port, this mothod should be run to manage
     * the string udp and then add to machine
     *
     * @param udpAnnoucement
     * @return
     */
    boolean addMachineToMap(String udpAnnoucement);

}
