/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1140412.fileShareApplication;

import java.util.ArrayList;
import lapr4.red.s1.ipc.n1140412.fileSharing.ConnectionManagerFileSharing;
import lapr4.red.s1.ipc.n1140412.fileSharing.FileShare;

/**
 *
 * @author Tiago
 */
public class FileShareController {

    private final ConnectionManagerFileSharing connectionManager;

    private String shareDirectoryPath;
    private String downloadDirectoryPath;

    public FileShareController() {
        shareDirectoryPath = "";
        downloadDirectoryPath = "";
        connectionManager = new ConnectionManagerFileSharing(this);
    }

    public String getShareDirectoryPath() {
        return shareDirectoryPath;
    }

    public void setShareDirectoryPath(String shareDirectoryPath) {
        this.shareDirectoryPath = shareDirectoryPath;
    }

    public String getDownloadDirectoryPath() {
        return downloadDirectoryPath;
    }

    public ConnectionManagerFileSharing getConnectionManager() {
        return connectionManager;
    }
    

    public void setDownloadDirectoryPath(String downloadDirectoryPath) {
        this.downloadDirectoryPath = downloadDirectoryPath;
    }

    public ArrayList<String> shareFileList(String path) {
        if (FileShare.filesNameList(FileShare.filesUnderPath(path)) == null) {
            return new ArrayList<String>();
        }
        return FileShare.filesNameList(FileShare.filesUnderPath(path));

    }

    public String currentSaveDownloadPath() {
        return FileShare.downloadPath();
    }

    public void saveDownloadPath(String path) {
        FileShare.saveDownloadPath(path);
    }

    public ArrayList<String> fileSizeList(String path) {
        return FileShare.fileSizeList(FileShare.filesUnderPath(path));
    }

    public ArrayList<String> fileNamesSizeList(String path) {
        return FileShare.fileListInfo(FileShare.filesUnderPath(path));
    }

    public ArrayList<String> downloadFileList() {
        ArrayList<String> ret = new ArrayList<>();
        this.connectionManager.filesListToDownloadWithData();
        return ret;
    }

}
