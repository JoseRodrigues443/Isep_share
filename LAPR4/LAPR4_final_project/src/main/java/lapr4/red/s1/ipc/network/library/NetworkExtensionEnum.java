/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.network.library;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public enum NetworkExtensionEnum {
    /**
     *
     * ENUM support and are encouraged by oracle to store extra information just
     * like UDP port, or in their documentation the example of Planet MASS
     * https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
     *
     *
     * this enum will store the udp port that each extension will use
     *
     */
    SHARE_CELL(15101),
    FIND_WORKBOOK(15102),
    SEARCH_WORKBOOK(15103),
    IMPRT_EXPORT(15104),
    CHAT(15105),
    NETWORK_TOOLS(15106),
    FILE_SHARING(15107),
    GAME_CENTER(15108),
    SHARE_CELL_AUTO(15109),
    FILE_TRANSFER(15110),
    TIC_TAC_TOE(15111),
    SHARE_CELL_V3(15112),
    NETWORK_EXPLORER(15113),
    EXAMPLE_UDP_PORT(1599);
    
    private final int udpPort;

    NetworkExtensionEnum(int udpPort) {
        this.udpPort = udpPort;
    }

    public int udpPort() {
        return udpPort;
    }

}
