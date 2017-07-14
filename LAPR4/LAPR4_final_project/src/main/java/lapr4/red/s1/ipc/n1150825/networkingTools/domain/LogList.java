/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1150825.networkingTools.domain;

import java.util.ArrayList;

/**
 *
 * @author João Coelho
 */
public class LogList {

    private ArrayList<LogInfo> LogList;

    public LogList() {
        LogList = new ArrayList<>();
    }

    public LogList(ArrayList<LogInfo> LogList) {
        this.LogList = LogList;
    }

    public ArrayList<LogInfo> getLogList() {
        return LogList;
    }

    /**
     * 
     * @param e
     */
    public void add(LogInfo e) {
        LogList.add(e);
    }

    /**
     * May be used to export to csv
     *
     * @return
     */
    public Object[][] logMatrix() {
        /**
         * private Address ip; private Object sent;
         */
        int defaultParametersNumber = 2;
        Object[][] objectMatrix = new Object[LogList.size()][defaultParametersNumber];
        /**
         * objectMatrix[0][0] = "IP Address";
         * objectMatrix[0][2] = "Object Sent";
         */
        for (int i = 0; i < LogList.size(); i++) {
            objectMatrix[i][0] = "" + LogList.get(i).getIp();
            objectMatrix[i][1] = LogList.get(i).getSent();
        }
        return objectMatrix;
    }

    public String[] tableColumnNames() {
        String[] toReturn = {"IP Address", "Sent"};
        return toReturn;
    }

    public ArrayList<String> logLines() {
        ArrayList<String> list = new ArrayList<>();
        for (LogInfo cl : LogList) {
            list.add("Ip: " + cl.getIp() + " | " + cl.getSent());
        }
        return list;
    }
}
