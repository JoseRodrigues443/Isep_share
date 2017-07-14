package lapr4.red.s1.ipc.network.library;

import java.io.Serializable;

/**
 * TODO: Remove comments after rest of library is pushed.
 *
 * @author 1150834
 */
public class NetworkAddress implements Comparable<NetworkAddress>, Serializable{

    /**
     * future enum true for IPV4, and false for IPV6
     */
    private NetworkIpProtocolEnum addressType;
    /**
     *
     * FORMAT
     *
     * e0:db:55:dd:7f:4c OR 192.168.0.69
     */
    private String address;
    /**
     * FORMAT: "/8" OR "/31" etc....
     */
    private String maskAddress;
    /**
     * broadcast address of the network that thr host is located
     */
    private String broadcastAddress;
    private int udpPort;
    private int tcpPort;

    
    
    /**
     *
     * @param addressType
     * @param address
     * @param maskAddress
     * @param broadcastAddress
     * @param udpPort
     * @param tcpPort
     */
    public NetworkAddress(NetworkIpProtocolEnum addressType, String address, String maskAddress, String broadcastAddress, int udpPort, int tcpPort) {
        this.addressType = addressType;
        this.address = address;
        this.maskAddress = maskAddress;
        this.broadcastAddress = broadcastAddress;
        this.udpPort = udpPort;
        this.tcpPort = tcpPort;
    }
    public String getBroadcastAddress() {
        return broadcastAddress;
    }

    public void setBroadcastAddress(String broadcastAddress) {
        this.broadcastAddress = broadcastAddress;
    }

    public NetworkIpProtocolEnum getAddressType() {
        return addressType;
    }

    public void setAddressType(NetworkIpProtocolEnum addressType) {
        this.addressType = addressType;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMaskAddress() {
        return maskAddress;
    }

    public void setMaskAddress(String macAddress) {
        this.maskAddress = macAddress;
    }

    public int getUdpPort() {
        return udpPort;
    }

    public void setUdpPort(int udpPort) {
        this.udpPort = udpPort;
    }

    public int getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    @Override                     
    public String toString() {
        return "Address{" + "addressType=" + addressType + ", address=" + address
                + ", maskAddress=" + maskAddress + ", broadcastAddress="
                + broadcastAddress + ", udpPort=" + udpPort
                + ", tcpPort=" + tcpPort + '}';
    }

    @Override
    public int compareTo(NetworkAddress t) {
        return this.address.compareTo(t.getAddress());

    }

}
