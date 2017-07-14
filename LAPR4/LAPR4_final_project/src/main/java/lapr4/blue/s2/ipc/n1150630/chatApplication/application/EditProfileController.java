/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150630.chatApplication.application;

import lapr4.red.s1.ipc.n1141114.netGames.UserProfile;
import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 *
 * @author David
 */
public class EditProfileController {
    
    
    private UserProfile profile;

    public EditProfileController() {
        profile = new UserProfile();
        
    }
    
    public String getName() {
        return profile.getName();
    }

    public String getImageDir() {
        return profile.getImageDir();
    }

    public NetworkAddress getAddress() {
        return profile.getAddress();
    }
    
    public String getNickname(){
        return profile.getNickname();
    }
    
    public String getStatus(){
        return profile.getStatus();
    }
    
    public void setNickname(String nickname) {
        profile.setNickname(nickname);
    }
    
    public void setImageDir(String imagePath){
        profile.setImageDir(imagePath);
    }
    
    public void setStatus(String status){
        profile.setStatus(status);
    }
    
    public void changeProfile(UserProfile profile){
        this.profile = profile;
    }
}
