package lapr4.red.s1.ipc.n1150710.network.shareCell.ui;

/*
 * Copyright (c) 2013 Alexandre Braganca, Einar Pehrson
 *
 * This file is part of
 * CleanSheets Extension for Comments
 *
 * CleanSheets Extension for Assertions is free software; you can
 * redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either version 2 of
 * the License, or (at your option) any later version.
 *
 * CleanSheets Extension for Assertions is distributed in the hope that
 * it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets Extension for Assertions; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 */
import csheets.core.Cell;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import csheets.ui.ctrl.UIController;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import lapr4.black.s1.ipc.n2345678.comm.sharecells.CellDTO;
import lapr4.red.s1.ipc.n1150710.network.shareCell.ShareExtension;
import lapr4.red.s1.ipc.network.library.NetworkAddress;

/**
 * A panel for adding or editing a comment for a cell
 *
 * @author 1150710@isep.ipp.pt
 */
@SuppressWarnings("serial")
public class SharePanel extends JPanel implements ActionListener {

    /**
     * The assertion controller
     */
    private ShareController controller;

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

    /**
     * Creates a new comment panel.
     *
     * @param uiController the user interface controller
     * @param cs
     * @param controller
     */
    public SharePanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        setName(ShareExtension.NAME);
        controller = new ShareController(uiController, this);
        cellIntervall = new Cell[NUMBER_OF_CELLS_DEFAULT];
        createComponents();
        updateListTimed();

    }

    public void createComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        JPanel machineListPanel = createMachineList();
        JPanel cellsSharedSent = createCellSelector();

        TitledBorder border = BorderFactory.createTitledBorder("Online users");
        border.setTitleJustification(TitledBorder.CENTER);
        machineListPanel.setBorder(border);

        border = BorderFactory.createTitledBorder("Cells to Share");
        border.setTitleJustification(TitledBorder.CENTER);
        cellsSharedSent.setBorder(border);

        mainPanel.add(machineListPanel);
        mainPanel.add(cellsSharedSent);

        add(mainPanel);
    }

    /**
     * updates de machine list
     */
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

    private JPanel createMachineList() {
        JPanel panel = new JPanel(new BorderLayout());
        createButtonShareList();
        users = new DefaultListModel();

        this.machineNetworkList = new JList(users);
        this.machineNetworkListToShow = new JScrollPane(machineNetworkList);

        panel.add(this.machineNetworkListToShow, BorderLayout.CENTER);
        panel.add(btnShare, BorderLayout.SOUTH);
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

    private void validateCellIntervall() {
        String indexMissing;
        if (cellIntervall[0] == null && cellIntervall[1] != null) {
            indexMissing = "Select 1st Cells";
        } else if (cellIntervall[1] == null && cellIntervall[0] != null) {
            indexMissing = "Select 2st Cells";
        } else {
            /**
             * all missing
             */
            indexMissing = "Select 1st Cells AND Select 2st Cells";
        }
        JOptionPane.showMessageDialog(null, "Please select on more cell, using the button: "
                + indexMissing + ".", "", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * For the selecting of cells interval button one is index = 0 button two =
     * index 1
     *
     * @param intervalIndex
     */
    private void addSelectedCell(int intervalIndex) {

        if (intervalIndex < NUMBER_OF_CELLS_DEFAULT) {
            /**
             * first
             */
            Cell c = controller.getSelectedCell();
            CellDTO cdto;
            if (intervalIndex == 0) {
                cellIntervall[0] = c;
                cdto = new CellDTO(c);
                btnFirstCell.setText("" + cdto.cellIdentificationToHumanFormat());
            } else if (intervalIndex == 1) {
                cdto = new CellDTO(c);
                cellIntervall[1] = c;
                btnSecondCell.setText("" + cdto.cellIdentificationToHumanFormat());
            }
        }
        if (cellIntervall[0] != null
                && cellIntervall[1] != null) {
            labelCellInfo.setText("All the \ncells were\nSelected ");
        }

    }

    private void createButtonShareList() {
        btnShare = new JButton("Share Cells");

        btnShare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                List<String> selectedIndice = machineNetworkList.getSelectedValuesList();
                if (selectedIndice.size() > 0) {
                    NetworkAddress addressToSend = controller.discoverMachineAddress();
                    addressToSend.setAddress(selectedIndice.get(0));
                    int tcpPort = controller.returnMapMembers().findTCPPortByAddress(addressToSend);
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
                        JOptionPane.showMessageDialog(null, "Cells shared!! Via TCP port: " + tcpPort, "", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error that user have a wrong tcp port!!", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

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

}
