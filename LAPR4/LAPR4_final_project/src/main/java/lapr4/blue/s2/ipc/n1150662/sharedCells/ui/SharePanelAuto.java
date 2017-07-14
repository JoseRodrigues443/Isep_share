/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150662.sharedCells.ui;

import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import lapr4.blue.s2.ipc.n1150662.sharedCells.AutoShareCellExtension;
import lapr4.blue.s2.ipc.n1150662.sharedCells.DTOCell;
import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 *
 * @author bruno
 */
public class SharePanelAuto extends JPanel {

    /**
     * The assertion controller
     */
    private ShareAutoController controller;

    private UIController uiController;

    private NetworkAddress addressToSend;

    private int tcpPort;
    
    private boolean checkThread;
    /**
     *
     */
    private Cell[] cellIntervall;

    private final static int NUMBER_OF_CELLS_DEFAULT = 2;

    /**
     * machine list
     */
    private JList machineNetworkList;

    /**
     *
     */
    private JScrollPane machineNetworkListToShow;
    /**
     *
     */
    private DefaultListModel users;

    /**
     *
     */
    private JButton btnShare;

    private JButton btnCancel;

    private JLabel txt;

    /**
     *
     */
    private JButton btnSelectCells;
    /**
     *
     */
    private JLabel labelCellInfo;

    /**
     *
     */
    private JButton btnFirstCell;

    /**
     *
     */
    private JButton btnSecondCell;

    public SharePanelAuto(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        setName(AutoShareCellExtension.NAME);
        this.uiController = uiController;
        controller = new ShareAutoController(uiController, this);
        cellIntervall = new Cell[NUMBER_OF_CELLS_DEFAULT];
        checkThread = true;
        createComponents();
        updateListTimed();

    }

    public void createComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        JPanel machineListPanel = createMachineList();
        JPanel cellsSharedSent = createCellSelector();
        JPanel textPanel = createTextPanel();

        TitledBorder border = BorderFactory.createTitledBorder("Online users");
        border.setTitleJustification(TitledBorder.CENTER);
        machineListPanel.setBorder(border);

        border = BorderFactory.createTitledBorder("Cells to Share");
        border.setTitleJustification(TitledBorder.CENTER);
        cellsSharedSent.setBorder(border);

        border = BorderFactory.createTitledBorder("Connection info");
        border.setTitleJustification(TitledBorder.CENTER);
        textPanel.setBorder(border);

        mainPanel.add(machineListPanel);
        mainPanel.add(cellsSharedSent);
        mainPanel.add(textPanel);

        add(mainPanel);
    }

    private JPanel createMachineList() {
        JPanel panel = new JPanel(new BorderLayout());
        createButtonShareList();
        createButtonCancel();
        users = new DefaultListModel();

        this.machineNetworkList = new JList(users);
        this.machineNetworkListToShow = new JScrollPane(machineNetworkList);

        panel.add(this.machineNetworkListToShow, BorderLayout.NORTH);
        panel.add(btnShare, BorderLayout.CENTER);
        panel.add(btnCancel, BorderLayout.SOUTH);
        return panel;
    }

    private void createButtonCancel() {
        btnCancel = new JButton("Cancel");

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (txt.getText().equals("ON")) {
                    txt.setText("OFF");
                    txt.setForeground(Color.RED);
                    btnShare.setEnabled(true);
                    controller.putOFF();
                    controller.sendTcp(controller.selectedCells(
                                    controller.getCells(cellIntervall[0].getAddress(),
                                            cellIntervall[1].getAddress())),
                                    tcpPort, addressToSend);
                    controller.stopThread();
                    checkThread = false;
                } else {
                    JOptionPane.showMessageDialog(null, "No active sharing!!", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    private void createButtonShareList() {
        btnShare = new JButton("Share Cells");

        btnShare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(checkThread == false){
                    controller.start();
                }
                addCellListener();
                List<String> selectedIndice = machineNetworkList.getSelectedValuesList();
                if (selectedIndice.size() > 0) {
                    addressToSend = controller.discoverMachineAddress();
                    addressToSend.setAddress(selectedIndice.get(0));
                    tcpPort = controller.returnMapMembers().findTCPPortByAddress(addressToSend);
                    if (tcpPort >= 0) {

                        if (cellIntervall[0] != null
                                && cellIntervall[1] != null) {
                            controller.sendTcp(controller.selectedCells(
                                    controller.getCells(cellIntervall[0].getAddress(),
                                            cellIntervall[1].getAddress())),
                                    tcpPort, addressToSend);
                        } else {
                            validateCellIntervall();
                        }
                        btnShare.setEnabled(false);
                        txt.setText("ON");
                        txt.setForeground(Color.GREEN);
                        JOptionPane.showMessageDialog(null, "Cells shared!! Via TCP port: " + tcpPort, "", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error that user have a wrong tcp port!!", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }

    private void validateCellIntervall() {
        String indexMissing;
        if (cellIntervall[0] == null && cellIntervall[1] != null) {
            indexMissing = "Select 1º Cells";
        } else if (cellIntervall[1] == null && cellIntervall[0] != null) {
            indexMissing = "Select 2º Cells";
        } else {
            /**
             * all missing
             */
            indexMissing = "Select 1º Cells AND Select 2º Cells";
        }
        JOptionPane.showMessageDialog(null, "Please select on more cell, using the button: "
                + indexMissing + ".", "", JOptionPane.INFORMATION_MESSAGE);
    }

    private JPanel createCellSelector() {
        JPanel panel = new JPanel();
        this.btnFirstCell = new JButton("Select 1º Cell");
        this.btnFirstCell.setToolTipText("Select a cell, and then press this button,"
                + "\nand the first cell in the intervall to share will be selected. ");
        this.btnSecondCell = new JButton("Select 2º Cell");
        this.btnSecondCell.setToolTipText("Select a cell, and then press this button,"
                + "\nand the last cell in the intervall to share will be selected.");
        this.labelCellInfo = new JLabel("Please select \nthe cells first");
        createButtonCellSelectorList();
        panel.add(this.btnFirstCell, BorderLayout.NORTH);
        panel.add(this.btnSecondCell, BorderLayout.CENTER);
        panel.add(this.labelCellInfo, BorderLayout.SOUTH);
        return panel;
    }

    private void createButtonCellSelectorList() {

        btnFirstCell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                addSelectedCell(0);
            }
        });
        btnSecondCell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                addSelectedCell(1);
            }
        });
    }

    private void addSelectedCell(int intervalIndex) {

        if (intervalIndex < NUMBER_OF_CELLS_DEFAULT) {
            /**
             * first
             */
            Cell c = controller.getSelectedCell();
            DTOCell cdto;
            if (intervalIndex == 0) {
                cellIntervall[0] = c;
                cdto = DTOCell.createFromCell(c);
                btnFirstCell.setText("" + cdto.cellIdentificationToHumanFormat());
            } else if (intervalIndex == 1) {
                cdto = DTOCell.createFromCell(c);
                cellIntervall[1] = c;
                btnSecondCell.setText("" + cdto.cellIdentificationToHumanFormat());
            }
        }
        if (cellIntervall[0] != null
                && cellIntervall[1] != null) {
            labelCellInfo.setText("All the \ncells were\nSelected ");
        }

    }

    public boolean updateListTimed() {
        /*amount of time to the run method be executed again*/
        int timeInterval = 5 * 1000;
        java.util.Timer timerToSendUdp = new java.util.Timer();
        timerToSendUdp.schedule(new TimerTask() {
            @Override
            public void run() {
                updateMachineList();
            }

        }, 0, timeInterval);

        return true;
    }

    public void updateMachineList() {
        ArrayList<String> machineList = controller.getMachineList();
        this.users.removeAllElements();
        if (machineList != null) {
            for (String s : machineList) {
                if (!users.contains(s)) {
                    this.users.addElement(s);
                }
            }
        }
    }

    private JPanel createTextPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        txt = new JLabel("OFF");
        txt.setForeground(Color.RED);
        panel.add(txt);
        txt.setVisible(true);

        return panel;

    }

    public void putON() {
        txt.setText("ON");
        txt.setForeground(Color.GREEN);
        btnShare.setEnabled(false);
    }
    
    public void putOFF(){
        txt.setText("OFF");
        txt.setForeground(Color.RED);
        btnShare.setEnabled(true);  
    }

    public void addCellListener() {
        int value = uiController.getActiveWorkbook().getSpreadsheetCount();
        for (int i = 0; i < value; i++) {
            uiController.getActiveWorkbook().getSpreadsheet(i).addCellListener(new ChangeCellListener());

        }

    }

    public class ChangeCellListener implements CellListener {

        @Override
        public void valueChanged(Cell cell) {

            controller.sendTcp(controller.selectedCells(
                    controller.getCells(cellIntervall[0].getAddress(),
                            cellIntervall[1].getAddress())),
                    tcpPort, addressToSend);

        }

        @Override
        public void contentChanged(Cell cell) {
            controller.sendTcp(controller.selectedCells(
                    controller.getCells(cellIntervall[0].getAddress(),
                            cellIntervall[1].getAddress())),
                    tcpPort, addressToSend);

        }

        @Override
        public void dependentsChanged(Cell cell) {
            controller.sendTcp(controller.selectedCells(
                    controller.getCells(cellIntervall[0].getAddress(),
                            cellIntervall[1].getAddress())),
                    tcpPort, addressToSend);

        }

        @Override
        public void cellCleared(Cell cell) {
            controller.sendTcp(controller.selectedCells(
                    controller.getCells(cellIntervall[0].getAddress(),
                            cellIntervall[1].getAddress())),
                    tcpPort, addressToSend);

        }

        @Override
        public void cellCopied(Cell cell, Cell source) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
