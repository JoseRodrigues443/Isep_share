/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150433.networkAnalizer.domain;

/**
 *
 * @author Débora Costa - 1150433
 */
public class TrafficAnalizer {
    /**
     * Increments when a message is decrypted
     */
    private static double secureIncoming = 0;
    private static double totalIncoming = 0;
    /**
     * Increments when a message is encrypted
     */
    private static double secureOutgoing = 0;
    private static double totalOutgoing = 0;
    

    
    public static void totalIncoming(){
        totalIncoming++;
    }
    
    public static void totalOutgoing(){
        totalOutgoing++;
    }    
    
    public static double secureOutgoing(){
        secureOutgoing++;
        return secureOutgoing;
    }
            
    public static double secureIncoming(){
        secureIncoming++;
        return secureIncoming;
    }
    
        public static double insecureIncoming(){
        return (totalIncoming-secureIncoming);
    }
    
    public static double insecureOutgoing(){
        return (totalOutgoing-secureOutgoing);
    }
    
    public static void reset(){
        totalOutgoing = 0;
        totalIncoming = 0;
        secureIncoming = 0;
        secureOutgoing = 0;
    }
    
    
    
}
