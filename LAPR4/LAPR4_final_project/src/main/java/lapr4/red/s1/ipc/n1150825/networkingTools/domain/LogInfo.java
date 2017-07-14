/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1150825.networkingTools.domain;

import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 *
 * @author João Coelho
 */
public class LogInfo {

    private NetworkAddress ip;
    private Object sent;

    public LogInfo(NetworkAddress ip, Object sent) {
        this.ip = ip;
        this.sent = sent;
    }

    public NetworkAddress getIp() {
        return ip;
    }

    public Object getSent() {
        return sent;
    }
}
