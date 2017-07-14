/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1141114.netGames.application;

import java.util.ArrayList;
import lapr4.red.s1.ipc.n1141114.netGames.ExtensionConnectionManagerGameCenter;
import lapr4.red.s1.ipc.n1141114.netGames.NetworkMachinesListProfiles;
import lapr4.red.s1.ipc.n1141114.netGames.UserProfile;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkExtensionEnum;
import lapr4.red.s1.ipc.network.library.NetworkMachinesList;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.red.s1.ipc.network.library.*;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 */
public class GameCenterController {

    private NetworkMachinesListProfiles userProfileList;
    
    private ExtensionConnectionManagerGameCenter connectionManager;

    public GameCenterController() {
        this.userProfileList = new NetworkMachinesListProfiles(NetworkExtensionEnum.GAME_CENTER);
        this.connectionManager = new ExtensionConnectionManagerGameCenter(null);
    }

    public boolean updateProfile(String imageDir) {
        this.connectionManager.defineProfileActive("Active", imageDir);
        return true;
    }

    public ArrayList<UserProfile> showOnlineUsers() {
        return this.connectionManager.getMachineProfiles();
    }

    public NetworkAddress discoverMachineAddress() {
        return connectionManager.discoverMachineAddress();
    }

    public NetworkMachinesListProfiles returnMapMembers() {
        return connectionManager.returnMapProfileMembers();
    }

    public void sendInvitation(NetworkAddress address, int tcpPort, UserProfile profile) {
        String sendMessage = "@GameCenter@TCP@" + Utils.ownIpAddress().getAddress() + "@" + tcpPort + "@InviteToGame@" + profile.getName() + "@";
        
        this.connectionManager.sendTcp(sendMessage, tcpPort, address);
    }
    
    public String usersAnswerInvitation(){
        return this.connectionManager.userAnswer();
    }
    
    public void sendExitStatus(NetworkAddress address, int tcpPort, UserProfile profile){
        String sendMessage = "@GameCenter@TCP@" + Utils.ownIpAddress().getAddress() + "@" + tcpPort + "@ExitStatus@" + profile.getName() + "@";
        
        this.connectionManager.sendTcp(sendMessage, tcpPort, address);
    }
}
