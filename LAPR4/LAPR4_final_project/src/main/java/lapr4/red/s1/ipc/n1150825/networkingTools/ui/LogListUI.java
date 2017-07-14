/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1150825.networkingTools.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import lapr4.red.s1.ipc.n1150825.networkingTools.app.ExtensionLogList;
import lapr4.red.s1.ipc.n1150825.networkingTools.controller.LogListController;

/**
 *
 * @author João Coelho
 * Edited by Débora Costa 1150433
 */
public class LogListUI  extends JPanel{
    
    private final LogListController myController;
    private JList log;
    private DefaultListModel logModel;
    
    public LogListUI(UIController uiController){
        super(new BorderLayout());
        setName(ExtensionLogList.NAME);

        logModel = new DefaultListModel<>();

        this.myController = new LogListController();
        //The observer is added to the extension
        createComponents();
        updateModelTimed(logModel);
    }
    
    public void createComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(1, 1));
        JPanel logPanel = createLogList();
       
        mainPanel.add(log);
        
        add(mainPanel);
    }
    
    private JPanel createLogList() {
        this.log = new JList(logModel);
        updateLogListModel(logModel);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(log, BorderLayout.CENTER);
        return panel;
    }
    
    private void updateLogListModel(DefaultListModel model) {
        model.removeAllElements();
        model.addElement("Traffic Analizer");
        model.addElement("1-Insecure Incoming");
        model.addElement("2-Insecure Outgoing");
        model.addElement("3-Secure Incoming");
        model.addElement("4-Secure Outgoing");
        /*for (String info : myController.showLogList()) {
            if (!model.contains(info)){
                model.addElement(info);
            }
        }*/
        model.addElement("\n");
        model.addElement(myController.getInsecureIncomingColumn());
        model.addElement(myController.getInsecureOutgoingColumn());
        model.addElement(myController.getSecureIncomingColumn());
        model.addElement(myController.getSecureOutgoingColumn());
    }
    
    /**
     * Updates de logModel periodically
     * @param logModel
     * @return 
     */
     public boolean updateModelTimed(DefaultListModel logModel) {
        /*amount of time to the run method be executed again*/
        int timeInterval = 5 * 1000;
        java.util.Timer timerToSendUdp = new java.util.Timer();
        timerToSendUdp.schedule(new TimerTask() {
            @Override
            public void run() {
                updateLogListModel(logModel);
                myController.reset();
            }

        }, 0, timeInterval);

        return true;
    }
}
