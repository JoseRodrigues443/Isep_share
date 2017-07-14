/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.network.library;

import java.util.Set;
import java.util.TreeMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public class NetworkMachinesListTest {
    
    public NetworkMachinesListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of allMapMembers method, of class NetworkMachinesList.
     */
    @Test
    public void testAllMapMembers() {
        System.out.println("allMapMembers");
        NetworkMachinesList instance = new NetworkMachinesList(NetworkExtensionEnum.CHAT);
        TreeMap<NetworkAddress, Integer> expResult = new TreeMap<>();
        TreeMap<NetworkAddress, Integer> result = instance.allMapMembers();
        assertEquals(expResult, result);
    }

    /**
     * Test of machineListType method, of class NetworkMachinesList.
     */
    @Test
    public void testMachineListType() {
        System.out.println("machineListType");
        NetworkMachinesList instance = new NetworkMachinesList(NetworkExtensionEnum.CHAT);
        NetworkExtensionEnum expResult = NetworkExtensionEnum.CHAT;
        NetworkExtensionEnum result = instance.machineListType();
        assertEquals(expResult, result);
    }

    /**
     * Test of addNewMemberToMap method, of class NetworkMachinesList.
     */
    @Test
    public void testAddNewMemberToMap() {
        System.out.println("addNewMemberToMap");
        String addressString = "192.168.0.1";
        NetworkAddress address = new NetworkAddress(NetworkIpProtocolEnum.IPV4, addressString, addressString, addressString, 0, 0);
        int tcpPort = 22;
        NetworkMachinesList instance = new NetworkMachinesList(NetworkExtensionEnum.CHAT);
        boolean expResult = false;
        boolean result = instance.addNewMemberToMap(address, tcpPort);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeMapMember method, of class NetworkMachinesList.
     */
    @Test
    public void testRemoveMapMember() {
        System.out.println("removeMapMember");
        String addressString = "192.168.0.1";
        NetworkAddress address = new NetworkAddress(NetworkIpProtocolEnum.IPV4, addressString, addressString, addressString, 0, 0);
        NetworkMachinesList instance = new NetworkMachinesList(NetworkExtensionEnum.CHAT);
        boolean expResult = false;
        boolean result = instance.removeMapMember(address);
        assertEquals(expResult, result);
    }

    /**
     * Test of findTCPPortByAddress method, of class NetworkMachinesList.
     */
    @Ignore
    @Test
    public void testFindTCPPortByAddress() {
        System.out.println("findTCPPortByAddress");
        String addressString = "192.168.0.1";        
        NetworkAddress address = new NetworkAddress(NetworkIpProtocolEnum.IPV4, addressString, addressString, addressString, 0, 0);
        NetworkMachinesList instance = new NetworkMachinesList(NetworkExtensionEnum.CHAT);
        Integer expResult = new Integer(0);
        Integer result = instance.findTCPPortByAddress(address);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAllAdressesByTCP method, of class NetworkMachinesList.
     */
    @Test
    public void testFindAllAdressesByTCP() {
        System.out.println("findAllAdressesByTCP");
        int tcpPort = 999;
        NetworkMachinesList instance = new NetworkMachinesList(NetworkExtensionEnum.CHAT);
        Set<NetworkAddress> expResult = instance.findAllAdressesByTCP(tcpPort);;
        Set<NetworkAddress> result = instance.findAllAdressesByTCP(tcpPort);
        assertEquals(expResult, result);
    }

    /**
     * Test of findAllAdresses method, of class NetworkMachinesList.
     */
    @Test
    public void testFindAllAdresses() {
        System.out.println("findAllAdresses");
        NetworkMachinesList instance = new NetworkMachinesList(NetworkExtensionEnum.CHAT);
        Set<NetworkAddress> expResult = instance.findAllAdresses();;
        Set<NetworkAddress> result = instance.findAllAdresses();
        assertEquals(expResult, result);
    }

    /**
     * Test of findNetworkAddressByIP method, of class NetworkMachinesList.
     */
    @Test
    public void testFindNetworkAddressByIP() {
        System.out.println("findNetworkAddressByIP");
        String otherAddress = "192.168.0.1";
        NetworkMachinesList instance = new NetworkMachinesList(NetworkExtensionEnum.CHAT);
        NetworkAddress expResult = instance.findNetworkAddressByIP(otherAddress);;
        NetworkAddress result = instance.findNetworkAddressByIP(otherAddress);
        assertEquals(expResult, result);
    }
    
}