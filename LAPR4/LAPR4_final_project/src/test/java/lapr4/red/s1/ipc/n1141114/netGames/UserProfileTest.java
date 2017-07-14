/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1141114.netGames;

import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkIpProtocolEnum;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class UserProfileTest {

    public UserProfileTest() {
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

    @Test(expected = IllegalArgumentException.class)
    public void userProfileNameCannotBeNull() {
        System.out.println("UserProfileNameCannotBeNull");
        NetworkAddress address = new NetworkAddress(NetworkIpProtocolEnum.IPV4, "128.10.10.0", "/8", "128.10.10.255", 0, 0);
        UserProfile profile = new UserProfile(null, "C:\\Users\\Joao\\Desktop\\test.png", address);
    }

    @Test(expected = IllegalArgumentException.class)
    public void userProfileAddressCannotBeNull() {
        System.out.println("userProfileAddressCannotBeNull");
        UserProfile profile = new UserProfile("JoaoPC", "C:\\Users\\Joao\\Desktop\\test.png", null);
    }

    /**
     * Test of getName method, of class UserProfile.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        NetworkAddress address = new NetworkAddress(NetworkIpProtocolEnum.IPV4, "128.10.10.0", "/8", "128.10.10.255", 0, 0);
        UserProfile profile = new UserProfile("JoaoPC", "C:\\Users\\Joao\\Desktop\\test.png", address);
        assertEquals("JoaoPC", profile.getName());
    }

    /**
     * Test of getImageDir method, of class UserProfile.
     */
    @Test
    public void testGetImageDir() {
        System.out.println("getImageDir");
        NetworkAddress address = new NetworkAddress(NetworkIpProtocolEnum.IPV4, "128.10.10.0", "/8", "128.10.10.255", 0, 0);
        UserProfile profile = new UserProfile("JoaoPC", "C:\\Users\\Joao\\Desktop\\test.png", address);
        assertEquals("C:\\Users\\Joao\\Desktop\\test.png", profile.getImageDir());
    }

    /**
     * Test of getAddress method, of class UserProfile.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        NetworkAddress address = new NetworkAddress(NetworkIpProtocolEnum.IPV4, "128.10.10.0", "/8", "128.10.10.255", 0, 0);
        UserProfile profile = new UserProfile("JoaoPC", "C:\\Users\\Joao\\Desktop\\test.png", address);
        assertEquals(address, profile.getAddress());
    }

    /**
     * Test of compareTo method, of class UserProfile.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        NetworkAddress address = new NetworkAddress(NetworkIpProtocolEnum.IPV4, "128.10.10.0", "/8", "128.10.10.255", 0, 0);
        UserProfile profile = new UserProfile("JoaoPC", "C:\\Users\\Joao\\Desktop\\test.png", address);
        UserProfile profileT = new UserProfile("Joao", "C:\\Users\\Joao\\Desktop\\test.png", address);
        assertEquals(0, profile.compareTo(profileT)); // Should be 0 because both of the address are the same
        NetworkAddress address2 = new NetworkAddress(NetworkIpProtocolEnum.IPV4, "195.10.10.0", "/8", "195.10.10.255", 0, 0);
        UserProfile profileA = new UserProfile("Joao", "C:\\Users\\Joao\\Desktop\\test2.png", address2);
        assertNotEquals(0, profile.compareTo(profileA)); // Should not be 0 since they have differente address and images
        
    }

}
