/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1141431.MultipleSharing.ui;

import lapr4.green.s3.ipc.n1141431.MultipleSharing.Areas;
import csheets.core.Cell;
import csheets.core.CellListener;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.border.TitledBorder;
import lapr4.green.s3.ipc.n1141431.MultipleSharing.AutoShareCellExtension;
import lapr4.green.s3.ipc.n1141431.MultipleSharing.CellsSelected;
import lapr4.green.s3.ipc.n1141431.MultipleSharing.DTOCell;

import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 *
 * @author Pedro Oliveira 1141431
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
    private boolean checkListAreas;
    /**
     *
     */
    private Cell[] cellIntervall;

    private final static int NUMBER_OF_CELLS_DEFAULT = 2;

    /**
     * machine list
     */
    private JList machineNetworkList;

    private JList listChosenAreas;
    /**
     *
     */
    private JScrollPane machineNetworkListToShow;
    private JScrollPane chosenAreasListToShow;
    /**
     *
     */
    private DefaultListModel users;
    private DefaultListModel listAreas;
    /**
     *
     */
    private JButton btnShare;

    private JButton btnCancel;
    private JButton btnConfirm;
    private JButton btnRemove;
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
    private Areas area;

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
        area = new Areas();

    }

    public void createComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 2));
        JPanel machineListPanel = createMachineList();
        JPanel listAreasPanel = createListAreas();
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

        border = BorderFactory.createTitledBorder("Chosen Areas");
        border.setTitleJustification(TitledBorder.CENTER);
        listAreasPanel.setBorder(border);

        mainPanel.add(machineListPanel);
        mainPanel.add(cellsSharedSent);
        mainPanel.add(textPanel);
        mainPanel.add(listAreasPanel);
        add(mainPanel);
    }

    /**
     * creates a jList where the chosen areas will be displayed
     *
     * @return
     */
    private JPanel createListAreas() {
        JPanel panel = new JPanel(new BorderLayout());
        createButtonConfirm();
        createButtonRemoveRanges();
        this.listAreas = new DefaultListModel();
        this.listChosenAreas = new JList(this.listAreas);
        this.chosenAreasListToShow = new JScrollPane(listChosenAreas);
        panel.add(this.chosenAreasListToShow, BorderLayout.NORTH);
        panel.add(btnConfirm, BorderLayout.CENTER);
        panel.add(btnRemove, BorderLayout.SOUTH);
        return panel;
    }

    /*
    removes the area from the Jlist 
     */
    private void createButtonRemoveRanges() {
        btnRemove = new JButton("Remove Areas");
        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                removeRange();
                //add the adding of a selected cell in the area class

            }
        });
    }

    /**
     * use to put the area created in the Jlist list chosen areas
     */
    private void createButtonConfirm() {
        btnConfirm = new JButton("Confirm");
        btnConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                confirmRange();
                //add the adding of a selected cell in the area class

            }
        });
    }

    /**
     * cleans the Jlist and the ArrayList<CellsSelected>list of Areas
     */
    private void removeRange() {
        this.checkListAreas = false;
        ArrayList<CellsSelected> list = new ArrayList();
        this.listAreas.clear();
        this.area.setList(list);
    }

    /**
     * sets the setting of the button confirm creates a CellsSelected based on
     * the range chosen and adds it to the arraylist list<CellsSelected> also
     * show in the JList the name of the areas that exist
     */
    public void confirmRange() {
        if (validateCellIntervall() == true) {
            SortedSet<Cell> set = this.controller.getCells(cellIntervall[0].getAddress(), cellIntervall[1].getAddress()); //creates a set with the cells from the range
            CellsSelected c = this.controller.selectedCells(set); //creates a instance of CellsSelected
            c.setFirstCell(cellIntervall[0]);//sets the cell interval for this CellsSelected instance
            c.setLastCell(cellIntervall[1]);
            this.area.getList().add(c); //adds the range of cells to the arraylist of ranges of celss

            //puts things back to normal
            this.btnFirstCell.setText("Select 1º Cell");
            this.btnSecondCell.setText("Select 2º Cell");
            labelCellInfo.setText("Please select \nthe cells first");
            this.listAreas.addElement(c.getNameArea() + ": " + cellIntervall[0].toString() + " - " + cellIntervall[1].toString() + "\n"); //replace for the name of the area created
            this.checkListAreas = true;
        } else {
            JOptionPane.showMessageDialog(null, "select the two cells!!");
        }
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
                if (checkListAreas == true) {
                    if (checkThread == false) {
                        controller.start();
                    }
                    addCellListener();
                    List<String> selectedIndice = machineNetworkList.getSelectedValuesList();
                    if (selectedIndice.size() > 0) {
                        addressToSend = controller.discoverMachineAddress();

                        addressToSend.setAddress(selectedIndice.get(0));
                        tcpPort = controller.returnMapMembers().findTCPPortByAddress(addressToSend);
                        if (tcpPort >= 0) {

                            controller.sendTcp(area, tcpPort, addressToSend); //update to have several areas 
                            btnShare.setEnabled(false);
                            txt.setText("ON");
                            txt.setForeground(Color.GREEN);
                            JOptionPane.showMessageDialog(null, "Cells shared!! Via TCP port: " + tcpPort, "", JOptionPane.INFORMATION_MESSAGE);

                        } else {
                            JOptionPane.showMessageDialog(null, "Error that user have a wrong tcp port!!", "", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Choose at least one area first!");
                }
            }
        });
    }

    /**
     * tests if both cells begining and end are selected
     *
     * @return
     */
    private boolean validateCellIntervall() {
        boolean flag = true;

        if (cellIntervall[0] == null || cellIntervall[1] == null) {

            flag = false;
        }
        return flag;
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
//makes that when a cell it's chose the button names is the column and line of he cell

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

    /*
    gets the first and last cell
     */
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

    public void putOFF() {
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

    /**
     * returns a new area with the values of the sheet
     *
     * @return
     */
    public Areas updateAreaList() {
        Areas a = new Areas();
        for (int i = 0; i < area.getList().size(); i++) {
//            System.out.println(area.getList().get(i).getNameArea());//----------------------test

            SortedSet<Cell> set = this.controller.getCells(area.getList().get(i).getFirstCell().getAddress(), area.getList().get(i).getLastCell().getAddress());

            CellsSelected c = this.controller.selectedCells(set);

            a.getList().add(c);

        }
//          for (int i = 0; i < area.getList().size(); i++) { //testing
//            System.out.println(area.getList().get(i).getNameArea()+": \n");
//              for (int j=0;j<area.getList().get(i).getCellDTOs().size();j++){
//                  System.out.println(area.getList().get(i).getCellDTOs().get(j).toString()+ "\n");
//              }
//          }
        return a;
    }

    public class ChangeCellListener implements CellListener { //repeat the for used in the share button to 

        @Override
        public void valueChanged(Cell cell) {
            controller.sendTcp(updateAreaList(),
                    tcpPort, addressToSend);

        }

        @Override
        public void contentChanged(Cell cell) {

            controller.sendTcp(updateAreaList(),
                    tcpPort, addressToSend);
        }

        @Override
        public void dependentsChanged(Cell cell) {
            controller.sendTcp(updateAreaList(),
                    tcpPort, addressToSend);

        }

        @Override
        public void cellCleared(Cell cell) {
            controller.sendTcp(updateAreaList(),
                    tcpPort, addressToSend);
        }

        @Override
        public void cellCopied(Cell cell, Cell source) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

}
