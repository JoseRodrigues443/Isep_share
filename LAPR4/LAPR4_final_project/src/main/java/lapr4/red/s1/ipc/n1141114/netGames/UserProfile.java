/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1141114.netGames;

import java.io.Serializable;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.Utils;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt
 * Edited by David Aguiar <1150630> 
 */
public class UserProfile implements Comparable<UserProfile>, Serializable{

    private String name;

    private String imageDir;

    private NetworkAddress address;

    private String nickname;
    
    private String status;
    
    private final String NAME_DEFAULT = System.getProperty("user.name");
    
    private final NetworkAddress ADDRESS_DEFAULT = Utils.ownIpAddress();
    
    private final String NICKNAME_DEFAULT = System.getProperty("user.name");
    
    private final String IMAGEDIR_DEFAULT = System.getProperty("user.dir")+"\\src\\main\\java\\lapr4\\blue\\s2\\ipc\\n1150630\\chatApplication\\icon.png";
    
    private final String STATUS_DEFAULT = "Online";
    
    public UserProfile(String name, String imageDir, NetworkAddress address) {
        if(name == null)
        {
            throw new IllegalArgumentException("User cannot have a null name");
        }
        if(address == null){
            throw new IllegalArgumentException("User cannot have a null address");
        }
        this.name = name;
        this.imageDir = imageDir;
        this.address = address;
    }
    
    public UserProfile(String name, String imageDir, NetworkAddress address, String nickname, String status) {
        if(name == null)
        {
            throw new IllegalArgumentException("User cannot have a null name");
        }
        if(address == null){
            throw new IllegalArgumentException("User cannot have a null address");
        }
        this.name = name;
        this.imageDir = imageDir;
        this.address = address;
        this.nickname = nickname;
        this.status = status;
    }
    
    public UserProfile(){
        this.name = NAME_DEFAULT;
        this.imageDir = IMAGEDIR_DEFAULT;
        this.address = ADDRESS_DEFAULT;
        this.nickname = NICKNAME_DEFAULT;
        this.status = STATUS_DEFAULT;
    }

    
    public String getName() {
        return name;
    }

    public String getImageDir() {
        return imageDir;
    }

    public NetworkAddress getAddress() {
        return address;
    }

    public String getNickname() {
        return nickname;
    }
    
    public String getStatus(){
        return status;
    }

    public void setImageDir(String imageDir) {
        this.imageDir = imageDir;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public int compareTo(UserProfile t) {
        if(this.address.compareTo(t.address) == 0){
            return this.imageDir.compareTo(t.imageDir);
        }
        return this.address.compareTo(t.address);
    }

    @Override
    public String toString() {
        return "UserProfile{" + "address=" + address.getAddress() + ", nickname=" + nickname + '}';
    }   
}
