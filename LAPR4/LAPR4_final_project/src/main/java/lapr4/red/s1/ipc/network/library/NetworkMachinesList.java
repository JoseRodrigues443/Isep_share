/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.network.library;

import eapli.util.Strings;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * This class represents a list of machines using the same extension.
 *
 * The class contains a map to store all the network addresses and the network
 * address tcp port. The map's key is the network address, since a network
 * doesn't have two equal ip adresses.
 *
 * It is possible to get the ip address from a tcp port and it is possible to
 * get the tcp port from a ip address.
 *
 * It is also possible to add/remove members to the list, as they enable/disable
 * the extension passes as the 'mapType'.
 *
 * @author Barros
 */
public class NetworkMachinesList {

    /**
     * The map used to store all ips and tcp ports, where the ip is the key
     * value, so you can't have two equal ip adresses.
     */
    private final TreeMap<NetworkAddress, Integer> networkMachinesMap;

    /**
     * The type of the active extension
     */
    private final NetworkExtensionEnum mapType;

    /**
     * Allows a new map to be created for a specified type
     *
     * @param mapType the type of the extension
     */
    public NetworkMachinesList(NetworkExtensionEnum mapType) {
        networkMachinesMap = new TreeMap<>();
        this.mapType = mapType;
    }

    /**
     * Returns all the users in the map
     *
     * @return all the users in the map
     */
    public TreeMap<NetworkAddress, Integer> allMapMembers() {
        return this.networkMachinesMap;
    }

    /**
     * Returns the type of the extension
     *
     * @return the type of the extension
     */
    public NetworkExtensionEnum machineListType() {
        return this.mapType;
    }

    /**
     * Adds a new member to the map
     *
     * @param address the new mebmber's network address
     * @param tcpPort the new member's tcp port
     * @return true if the new member is added, false if not added if the member
     * already exists, the tcp port will be updated
     */
    public boolean addNewMemberToMap(NetworkAddress address, int tcpPort) {
        if (address == null || tcpPort < 1) {
            throw new IllegalStateException();
        }
        return this.networkMachinesMap.put(address, tcpPort) != null;
    }

    /**
     * Removes a member of the map, if the member is in the map
     *
     * @param address the network address of the member to remove of the map
     * @return true if the member is removed or false if the member doesn't
     * exist in the map
     */
    public boolean removeMapMember(NetworkAddress address) {
        if (address == null) {
            throw new IllegalStateException();
        }
        return this.networkMachinesMap.remove(address) != null;
    }

    /**
     * Finds the TCP port used by a specific network addess
     *
     * @param address the network adress used to find the tcp port
     * @return the tcp port used by the given network address
     */
    public int findTCPPortByAddress(NetworkAddress address) {
        if (address == null) {
            throw new IllegalStateException();
        }
        return this.networkMachinesMap.get(address);
    }

    /**
     * Finds all network adresses using a specified tcp port
     *
     * @param tcpPort the tcp port used to find all network addresses using the
     * specified port
     * @return a set of network adreesses that use the specified tcp port
     */
    public Set<NetworkAddress> findAllAdressesByTCP(int tcpPort) {
        if (tcpPort < 1) {
            throw new IllegalStateException();
        }
        Set<NetworkAddress> addressSet = new TreeSet<>();
        for (NetworkAddress address : networkMachinesMap.keySet()) {
            if (findTCPPortByAddress(address) == tcpPort) {
                addressSet.add(address);
            }
        }
        return addressSet;
    }

    /**
     * Finds all network adresses
     *
     *
     * @return a set of network adreesses that use the specified tcp port
     */
    public Set<NetworkAddress> findAllAdresses() {
        Set<NetworkAddress> addressSet = new TreeSet<>();
        for (NetworkAddress address : networkMachinesMap.keySet()) {
            addressSet.add(address);
        }
        return addressSet;
    }
    

    /**
     * Method that returns the NetworkAddress object if the address in the
     * object matches a String passed as argument.
     *
     * @param otherAddress the String containing an address
     * @return the address if there is an equal address, or null if the address
     * isn't on the map
     */
    public NetworkAddress findNetworkAddressByIP(String otherAddress) {
        if (Strings.isNullOrEmpty(otherAddress) || Strings.isNullOrWhiteSpace(otherAddress)) {
            throw new IllegalStateException();
        }
        for (NetworkAddress address : networkMachinesMap.keySet()) {
            if (address.getAddress().equals(otherAddress)) {
                return address;
            }
        }
        return null;
    }
    
}
