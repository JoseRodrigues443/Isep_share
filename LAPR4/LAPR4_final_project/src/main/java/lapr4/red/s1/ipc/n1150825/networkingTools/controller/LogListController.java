/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1150825.networkingTools.controller;

import java.util.ArrayList;
import lapr4.blue.s2.ipc.n1150433.networkAnalizer.domain.TrafficAnalizer;
import lapr4.red.s1.ipc.n1150825.networkingTools.domain.LogList;

/**
 *
 * @author João Coelho Edited by Débora Costa 1150433
 */
public class LogListController {

    private LogList log = new LogList();

    private final static String DOT_SIMBOL_DEFAULT = "=";

    public ArrayList<String> showLogList() {
        return log.logLines();
    }

    public String getInsecureIncomingColumn() {
        String column = "1- ";
        double size = TrafficAnalizer.insecureIncoming();
        size = size >= 0 ? size : 0;
        for (int i = 0; i < size; i++) {
            column = column + DOT_SIMBOL_DEFAULT;
        }
        return column;
    }

    public String getInsecureOutgoingColumn() {
        String column = "2- ";
        double size = TrafficAnalizer.insecureOutgoing();
        size = size >= 0 ? size : 0;
        for (int i = 0; i < size; i++) {
            column = column + DOT_SIMBOL_DEFAULT;
        }
        return column;
    }

    public String getSecureIncomingColumn() {
        String column = "3- ";
        double size = TrafficAnalizer.secureIncoming();
        size = size >= 0 ? size : 0;
        for (int i = 0; i < size; i++) {
            column = column + DOT_SIMBOL_DEFAULT;
        }
        return column;
    }

    public String getSecureOutgoingColumn() {
        String column = "4- ";
        double size = TrafficAnalizer.secureOutgoing();
        size = size >= 0 ? size : 0;
        for (int i = 0; i < size; i++) {
            column = column + DOT_SIMBOL_DEFAULT;
        }
        return column;
    }
    
    public void reset(){
        TrafficAnalizer.reset();
    }
}
