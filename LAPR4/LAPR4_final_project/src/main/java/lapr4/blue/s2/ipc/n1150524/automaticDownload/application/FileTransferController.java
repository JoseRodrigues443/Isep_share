/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150524.automaticDownload.application;

import java.util.Set;
import lapr4.blue.s2.ipc.n1150524.automaticDownload.ConnectionManagerFileTransfer;
import lapr4.red.s1.ipc.n1140412.fileShareApplication.FileDataAndTcpPort;
import lapr4.red.s1.ipc.n1140412.fileShareApplication.FileShareController;
import lapr4.red.s1.ipc.network.library.NetworkAddress;
import lapr4.red.s1.ipc.network.library.Utils;

/**
 *
 * @author Filipe Correia <1150524@isep.ipp.pt>
 */
public class FileTransferController {

    private FileShareController otherCtrl;
    private String fileName;
    private NetworkAddress address;
    private Set<NetworkAddress> addressList;
    private int tcpPort;
    private final ConnectionManagerFileTransfer connectionManager;

    public FileTransferController(FileShareController otherCtrl) {
        this.otherCtrl = otherCtrl;
        connectionManager = new ConnectionManagerFileTransfer(this);
    }

    public FileShareController getFileShareController() {
        return otherCtrl;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setDownloadFolder(String path) {
        this.connectionManager.setDownloadFolder(path);
    }

    public void setShareFolder() {
        this.connectionManager.setShareFolder(this.otherCtrl.getShareDirectoryPath());
    }

    public void getFileHost() {

        int temp = 0;

        String tmp[] = fileName.split("\\|\\|");
        for (FileDataAndTcpPort e : otherCtrl.getConnectionManager().getNetworkMachinesAndFileList().allMapMembers().values()) {
            for (String s : e.getFileName()) {
                if (s.split("\\|\\|")[0].equals(tmp[0])) {
                    temp = e.getTcpPort();
                }
            }
        }

        addressList = otherCtrl.getConnectionManager().getNetworkMachinesAndFileList().findAllAdressesByTCP(temp);

    }

    public void sendTransferRequest(Boolean permanent) {

        String p;
    
        if (permanent) {
            p = "permanent";
        } else {
            p = "oneTime";
        }
        String tmp[] = fileName.split("\\|\\|");
        String sendMessage = "@FileTransfer@Request@TCP@"
                + Utils.ownIpAddress().getAddress() + "@" + connectionManager.getDownloadPort()
                + "@File@" + tmp[0] + "@" + p + "@";

        connectionManager.setDownloadedFileName(tmp[0]);

        this.connectionManager.sendTcp(sendMessage, tcpPort, address);

    }

    public void stopRefreshingFile() {
        String tmp[] = fileName.split("\\|\\|");
        String sendMessage = "@FileTransfer@Terminate@TCP@"
                + Utils.ownIpAddress().getAddress() + "@" + tcpPort
                + "@File@" + tmp[0] + "@";
        this.connectionManager.sendTcp(sendMessage, tcpPort, address);
    }

    public Set<NetworkAddress> getAddressList() {
        return addressList;
    }

    public void setAddress(NetworkAddress address) {
        this.address = address;
        tcpPort = connectionManager.getNetworkMachinesList().findTextTCPPortByAddress(address);

    }

}
