/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fileNameAndSize, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1140412.fileShareApplication;

import java.util.ArrayList;

/**
 *
 *
 * @author 1150710@isep.ipp.pt
 */
public class FileDataAndTcpPort {

    /**
     * tcp port of client
     */
    private int tcpPort;
    /**
     * file name
     */
    private ArrayList<String> fileNameList;
    /**
     * Sets the TcpPort
     * @param tcpPort 
     */
    public FileDataAndTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }
    /**
     * Sets the TcpPort and list of file names
     * @param tcpPort
     * @param fileNameList
     *  
     */
    public FileDataAndTcpPort(int tcpPort, ArrayList<String> fileNameList) {
        this.tcpPort = tcpPort;
        this.fileNameList = fileNameList;
    }
    
    /**
     * Return the tcpPort
     * @return 
     */
    public int getTcpPort() {
        return tcpPort;
    }
    /**
     * Return the fileNameList
     * @return 
     */
    public ArrayList<String> getFileName() {
        return fileNameList;
    }
    /**
     * Adds an element to the fileNameList
     * @param e
     * @return 
     */
    public boolean add(String e) {
        return fileNameList.add(e);
    }
    
}
