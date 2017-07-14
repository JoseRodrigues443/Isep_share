package lapr4.red.s3.core.n1150710.chartWizard.extension.ui;

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
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import csheets.ui.ctrl.UIController;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import lapr4.red.s3.core.n1150710.chartWizard.ChartWizardController;
import lapr4.red.s3.core.n1150710.chartWizard.extension.ChartExtension;
import lapr4.red.s3.core.n1150710.chartWizard.extension.list.ChartObject;

/**
 *
 *
 * @author 1150710@isep.ipp.pt
 */
@SuppressWarnings("serial")
public class ChartWizardPanel extends JPanel implements ActionListener {

    /**
     * machine list
     */
    private JList chartList;

    /**
     *
     */
    private JScrollPane machineNetworkListToShow;
    /**
     *
     */
    private DefaultListModel charts;

    /**
     *
     */
    private JButton btnNewChart;

    /**
     *
     */
    private JButton btnOpenChart;
    /**
     *
     */
    private JButton btnDeleteChart;
    /**
     *
     */
    private JButton btnEditChart;

    private final UIController uic;

    private final ChartWizardController chartWizardController;

    /**
     * Creates a new comment panel.
     *
     * @param uiController the user interface controller
     */
    public ChartWizardPanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        this.uic = uiController;
        this.chartWizardController = new ChartWizardController(uic);
        setName(ChartExtension.NAME);
        updateListTimed();
        createComponents();

    }

    public void createComponents() {
        JPanel mainPanel = new JPanel(new GridLayout(1, 1));
        JPanel machineListPanel = createMachineList();

        TitledBorder border = BorderFactory.createTitledBorder("Created Charts");
        border.setTitleJustification(TitledBorder.CENTER);
        machineListPanel.setBorder(border);

        mainPanel.add(machineListPanel);

        add(mainPanel);
    }

    private JPanel createMachineList() {
        JPanel panel = new JPanel(new BorderLayout());
        createButtonShareList();
        charts = new DefaultListModel();

        this.chartList = new JList(charts);
        this.machineNetworkListToShow = new JScrollPane(chartList);

        panel.add(this.machineNetworkListToShow, BorderLayout.CENTER);

        JPanel panelTmp = new JPanel(new GridLayout(4, 1));
        panelTmp.add(btnNewChart);
        panelTmp.add(btnOpenChart);
        panelTmp.add(btnDeleteChart);
        panelTmp.add(btnEditChart);

        panel.add(panelTmp, BorderLayout.SOUTH);
        return panel;
    }

    private void createButtonShareList() {
        btnNewChart = new JButton("New Chart");
        btnOpenChart = new JButton("Open");
        btnDeleteChart = new JButton("Delete");
        btnEditChart = new JButton("Edit");
        btnNewChart.addActionListener((ActionEvent ae) -> {
            //System.out.println("asfdafaaw");
            ChartUI chartUI = new ChartUI(chartWizardController, uic);
        });

        btnOpenChart.addActionListener((ActionEvent ae) -> {
            //System.out.println("asfdafaaw");
            Object obj = this.chartList.getSelectedValue();
            if (obj != null && obj.getClass().equals(ChartObject.class)) {
                ChartObject chartObject = (ChartObject) obj;
                chartObject.putInWindow();
            }
        });

        btnDeleteChart.addActionListener((ActionEvent ae) -> {
            //System.out.println("asfdafaaw");
            Object obj = this.chartList.getSelectedValue();
            if (obj != null && obj.getClass().equals(ChartObject.class)) {
                ChartObject chartObject = (ChartObject) obj;
                this.chartWizardController.getChartCreatorList().getChartCreators().remove(chartObject);
                this.charts.removeElement(chartObject);
            }
        });
        btnEditChart.addActionListener((ActionEvent ae) -> {
            //System.out.println("asfdafaaw");
            Object obj = this.chartList.getSelectedValue();
            if (obj != null && obj.getClass().equals(ChartObject.class)) {
                ChartObject chartObject = (ChartObject) obj;
                ChartUI chartUI = new ChartUI(chartWizardController, uic, 
                        chartObject.getCellSelectedContent(),
                        chartObject.getAddress1(),
                        chartObject.getAddress2()
                ,chartObject.getNameDescription());
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    /**
     * updates de machine list
     */
    public void updateChartList() {
        ArrayList<ChartObject> chartListTmp = this.chartWizardController.getChartCreatorList().getChartCreators();
//        if (charts != null || !charts.isEmpty()){
//            charts.clear();
//        }
        if (chartListTmp != null) {
            for (ChartObject s : chartListTmp) {
                if (!charts.contains(s)) {
                    this.charts.addElement(s);
                }
            }
        }
    }

    public boolean updateListTimed() {
        /*amount of time to the run method be executed again*/
        int timeInterval = 3 * 1000;
        java.util.Timer timerToSendUdp = new java.util.Timer();
        timerToSendUdp.schedule(new TimerTask() {
            @Override
            public void run() {
                updateChartList();
            }

        }, 0, timeInterval);

        return true;
    }

}
