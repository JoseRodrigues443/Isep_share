/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1141114.netGames;

import lapr4.red.s1.ipc.network.library.*;
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
public class NetworkMachinesListProfiles {

    /**
     * The map used to store all ips and tcp ports, where the ip is the key
     * value, so you can't have two equal ip adresses.
     */
    private final TreeMap<UserProfile, Integer> networkMachinesMap;

    /**
     * The type of the active extension
     */
    private final NetworkExtensionEnum mapType;

    /**
     * Allows a new map to be created for a specified type
     *
     * @param mapType the type of the extension
     */
    public NetworkMachinesListProfiles(NetworkExtensionEnum mapType) {
        networkMachinesMap = new TreeMap<>();
        this.mapType = mapType;
    }

    /**
     * Returns all the users in the map
     *
     * @return all the users in the map
     */
    public TreeMap<UserProfile, Integer> allMapMembers() {
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
    public boolean addNewMemberToMap(UserProfile profile, int tcpPort) {
        if (profile == null || tcpPort < 1) {
            throw new IllegalStateException();
        }
        return this.networkMachinesMap.put(profile, tcpPort) != null;
    }

    /**
     * Removes a member of the map, if the member is in the map
     *
     * @param address the network address of the member to remove of the map
     * @return true if the member is removed or false if the member doesn't
     * exist in the map
     */
    public boolean removeMapMember(UserProfile profile) {
        if (profile == null) {
            throw new IllegalStateException();
        }
        return this.networkMachinesMap.remove(profile) != null;
    }

    /**
     * Finds the TCP port used by a specific network addess
     *
     * @param address the network adress used to find the tcp port
     * @return the tcp port used by the given network address
     */
    public int findTCPPortByProfile(UserProfile profile) {
        if (profile == null) {
            throw new IllegalStateException();
        }
        return this.networkMachinesMap.get(profile);
    }

    /**
     * Finds all network adresses using a specified tcp port
     *
     * @param tcpPort the tcp port used to find all network addresses using the
     * specified port
     * @return a set of network adreesses that use the specified tcp port
     */
    public Set<UserProfile> findAllProfilesByTCP(int tcpPort) {
        if (tcpPort < 1) {
            throw new IllegalStateException();
        }
        Set<UserProfile> profileSet = new TreeSet<>();
        for (UserProfile profile : networkMachinesMap.keySet()) {
            if (findTCPPortByProfile(profile) == tcpPort) {
                profileSet.add(profile);
            }
        }
        return profileSet;
    }

    /**
     * Finds all network adresses
     *
     *
     * @return a set of network adreesses that use the specified tcp port
     */
    public Set<UserProfile> findAllAdresses() {
        Set<UserProfile> profileSet = new TreeSet<>();
        for (UserProfile profile : networkMachinesMap.keySet()) {
            profileSet.add(profile);
        }
        return profileSet;
    }
    
     /**
     * Method that returns the UserProfile object if the address in the
     * object matches a String passed as argument.
     *
     * @param otherAddress the String containing an address
     * @return the profile if there is an equal address, or null if the address
     * isn't on the map
     */
    public UserProfile findUserProfileByIP(String otherAddress) {
        if (Strings.isNullOrEmpty(otherAddress) || Strings.isNullOrWhiteSpace(otherAddress)) {
            throw new IllegalStateException();
        }
        for (UserProfile profile : networkMachinesMap.keySet()) {
            if (profile.getAddress().equals(otherAddress)) {
                return profile;
            }
        }
        return null;
    }
    
    public String findNetworkAddressByProfile(String name) {
        if (Strings.isNullOrEmpty(name) || Strings.isNullOrWhiteSpace(name)) {
            throw new IllegalStateException();
        }
        for (UserProfile profile : allMapMembers().keySet()) {
            if (profile.getName().equals(name)) {
                return profile.getAddress().getAddress();
            }
        }
        return null;
    }

}
