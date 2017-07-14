/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1151117.chatApplication.application;

import eapli.framework.application.Controller;
import java.util.ArrayList;
import java.util.Set;
import lapr4.green.s3.ipc.n1150759.chatApplication.IObservableChatRoom;
import lapr4.green.s3.ipc.n1150759.chatApplication.IObserverChatRoom;
import lapr4.green.s3.ipc.n1150759.chatApplication.IObserverChatRoomList;
import lapr4.red.s1.ipc.n1151117.chatApplication.ExtensionConnectionManagerChatApplication;
import lapr4.red.s1.ipc.n1151117.chatApplication.domain.Message;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.NetworkMachinesList;

/**
 *
 * @author Barros
 */
public class SendMessageController implements Controller, IObservableChatRoom {

    /**
     * The message to send
     */
    private Message message;

    /**
     * The extension manager responsible for all connections
     */
    private final ExtensionConnectionManagerChatApplication extensionChat;

    private ArrayList observers;
    
    public SendMessageController(Message message, ExtensionConnectionManagerChatApplication extension) {
        this.message = message;
        this.extensionChat = extension;
        this.observers = new ArrayList<>();
    }

    public SendMessageController(ExtensionConnectionManagerChatApplication extension) {
        this.message = null;
        this.extensionChat = extension;
        this.observers = new ArrayList<>();
    }

    public void addMessageToSend(Message message) {
        this.message = message;
    }

    public boolean sendMessage() {
        int tcpPort = extensionChat.returnMapMembers().findTCPPortByAddress(message.messageReceiver());
        return extensionChat.sendTcp(message, tcpPort, message.messageReceiver());
    }
    
    /**
     * Sends a message to all the participants of a chat room
     * 
     * @return True if successfull, false otherwise
     */
    public boolean sendMessageToChatRoom() {
        int tcpPort;
        NetworkMachinesList onlineUsers = this.extensionChat.returnMapMembers();
        Set<NetworkAddress> receivers = this.message.allReceivers();
        
        for (NetworkAddress receiver : receivers) {
            NetworkAddress netAd = onlineUsers.findNetworkAddressByIP(receiver.getAddress());
            tcpPort = onlineUsers.findTCPPortByAddress(netAd);
            this.extensionChat.sendTcp(message, tcpPort, netAd);
        }
        
        return true;
    }
    
     public boolean sendEncryptedMessage(byte[] data) {
        int tcpPort = extensionChat.returnMapMembers().findTCPPortByAddress(message.messageReceiver());
        return extensionChat.sendTcp(data, tcpPort, message.messageReceiver());
    }
     
    public String findProfileNickByIP(String ip){
        return extensionChat.findProfileNickByIP(ip);
    }
    
    public Message createMessage(String msg, NetworkAddress sender,
            Set<NetworkAddress> receivers) {
        return message = new Message(msg, sender, receivers);
    }

    @Override
    public void registNewChatRoomObserver(IObserverChatRoom o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObserversChatRoom() {
        for (int i = 0; i < observers.size(); i++) {
            IObserverChatRoom obs = (IObserverChatRoom) observers.get(i);
            obs.updateChat(message);
        }
    }
}
