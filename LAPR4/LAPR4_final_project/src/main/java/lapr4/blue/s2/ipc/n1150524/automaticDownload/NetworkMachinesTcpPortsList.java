/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150524.automaticDownload;

import eapli.util.Strings;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkExtensionEnum;

/**
 *
 * @author Filipe Correia <1150524@isep.ipp.pt>
 */
public class NetworkMachinesTcpPortsList {

    private final int TEXT = 0;

    private final int DOWNLOAD = 1;

    private final int OBJECT = 2;

    /**
     * The map used to store all ips and tcp ports, where the ip is the key
     * value, so you can't have two equal ip adresses.
     */
    private final TreeMap<NetworkAddress, Integer[]> networkMachinesMap;

    /**
     * The type of the active extension
     */
    private final NetworkExtensionEnum mapType;

    /**
     * Allows a new map to be created for a specified type
     *
     * @param mapType the type of the extension
     */
    public NetworkMachinesTcpPortsList(NetworkExtensionEnum mapType) {
        networkMachinesMap = new TreeMap<>();
        this.mapType = mapType;
    }

    /**
     * Returns all the users in the map
     *
     * @return all the users in the map
     */
    public TreeMap<NetworkAddress, Integer[]> allMapMembers() {
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
     * @param textTcpPort
     * @param PERMANENT
     * @param objectTcpPort
     * @return true if the new member is added, false if not added if the member
     * already exists, the tcp port will be updated
     */
    public boolean addNewMemberToMap(NetworkAddress address, int textTcpPort, int PERMANENT, int objectTcpPort) {
        if (address == null || textTcpPort < 1 || PERMANENT < 1 || objectTcpPort < 1) {
            throw new IllegalStateException();
        }

        Integer[] tcps = new Integer[3];
        tcps[TEXT] = textTcpPort;
        tcps[this.DOWNLOAD] = PERMANENT;
        tcps[OBJECT] = objectTcpPort;
        return this.networkMachinesMap.put(address, tcps) != null;
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
    public int findTextTCPPortByAddress(NetworkAddress address) {
        if (address == null) {
            throw new IllegalStateException();
        }
        return this.networkMachinesMap.get(address)[TEXT];
    }

    public int downloadTCPPortByAddress(NetworkAddress address) {
        if (address == null) {
            throw new IllegalStateException();
        }
        return this.networkMachinesMap.get(address)[DOWNLOAD];
    }

    public int findObjectTCPPortByAddress(NetworkAddress address) {
        if (address == null) {
            throw new IllegalStateException();
        }
        return this.networkMachinesMap.get(address)[OBJECT];
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
