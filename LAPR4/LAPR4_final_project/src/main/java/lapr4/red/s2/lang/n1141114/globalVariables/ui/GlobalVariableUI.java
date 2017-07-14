/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1141114.globalVariables.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import lapr4.blue.s3.lang.n1130679.arrayVariableEditor.ui.EditGlobalVariableUI;
import lapr4.red.s1.ipc.n1141114.netGames.ExtensionGameCenter;
import lapr4.red.s2.lang.n1141114.globalVariables.domain.GlobalVariable;

/**
 *
 * @author Joao Fernandes 1141114@isep.ipp.pt edited by Ana Pacheco
 * 1130679@isep.ipp.pt
 */
public class GlobalVariableUI extends JPanel {

    private UIController uiController;

    private JList<String> positionList;
    private JList<String> variableNameList;
    private JList<String> variableValueList;

    private DefaultListModel positionDefaultListModel;
    private DefaultListModel variableNameDefaultListModel;
    private DefaultListModel variableValueDefaultListModel;

    private int controlTimerVariable;

    public GlobalVariableUI(UIController uiController) {
        super(new GridLayout(3, 4));
        setName(ExtensionGameCenter.NAME);

        this.uiController = uiController;
        controlTimerVariable = 0;

        positionDefaultListModel = new DefaultListModel();
        variableNameDefaultListModel = new DefaultListModel();
        variableValueDefaultListModel = new DefaultListModel();

        createComponents();
        updateLists();
    }

    public void createComponents() {
        JPanel posPanel = createPositionPanel();
        JPanel namePanel = createVariableNamePanel();
        JPanel valuePanel = createVariableValuePanel();

        add(posPanel);
        add(namePanel);
        add(valuePanel);
    }

    public JPanel createPositionPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel posLabel = new JLabel("Cell");
        positionList = new JList(positionDefaultListModel);

        panel.add(posLabel, BorderLayout.NORTH);
        panel.add(positionList, BorderLayout.CENTER);
        panel.add(new JScrollPane(positionList));

        return panel;
    }

    public JPanel createVariableNamePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel namePanel = new JLabel("Name");
        variableNameList = new JList(variableNameDefaultListModel);

        variableNameList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();

                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    String variableName = (String) variableNameDefaultListModel.get(index);
                    new EditGlobalVariableUI(variableName, uiController.getActiveCell(), uiController.getActiveSpreadsheet()).setVisible(true);
                }
            }
        });

        panel.add(namePanel, BorderLayout.NORTH);
        panel.add(variableNameList, BorderLayout.CENTER);
        panel.add(new JScrollPane(variableNameList));

        return panel;
    }

    public JPanel createVariableValuePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel valuePanel = new JLabel("Value");
        variableValueList = new JList(variableValueDefaultListModel);

        panel.add(valuePanel, BorderLayout.NORTH);
        panel.add(variableValueList, BorderLayout.CENTER);
        panel.add(new JScrollPane(variableValueList));

        return panel;
    }

    public boolean updateLists() {
        /*amount of time to the run method be executed again*/
        int timeInterval = 10 * 1000;
        java.util.Timer timerToSendUdp = new java.util.Timer();
        timerToSendUdp.schedule(new TimerTask() {
            @Override
            public void run() {
                updateListsTimed();
            }

        }, 0, timeInterval);

        return true;
    }

    public void updateListsTimed() {
        if (controlTimerVariable > 0) {
            Set<GlobalVariable> globalVariables = new HashSet<>();
            positionDefaultListModel.removeAllElements();
            variableNameDefaultListModel.removeAllElements();
            variableValueDefaultListModel.removeAllElements();
            if (uiController.getActiveWorkbook().findGlobalVariables().currentVariables().size() > 0) {
                globalVariables = uiController.getActiveWorkbook().findGlobalVariables().currentVariables();
                for (GlobalVariable globalVariable : globalVariables) {
                    if (!globalVariable.currentGlobalVariableValue().toString().equalsIgnoreCase("")) {
                        String pos = globalVariable.cellWhereDefined().getAddress().toString() + " - " + globalVariable.sheetWhereDefined().getTitle();
                        String variableName = globalVariable.currentGlobalVariableName();
                        String variableValue = globalVariable.currentGlobalVariableValue().toString();

                        positionDefaultListModel.addElement(pos);
                        variableNameDefaultListModel.addElement(variableName);
                        variableValueDefaultListModel.addElement(variableValue);
                    }
                }
            }
        }
        controlTimerVariable++;
    }
}
