/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150710.chartWizard.extension.list;

import csheets.core.Address;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public class ChartObject {

    private JPanel jPanel;

    private String[][] cellSelectedContent;
    private Address address1;
    private Address address2;

    private String nameDescription;

    /**
     *
     * @param jPanel
     * @param cellSelectedContent
     * @param address1
     * @param address2
     * @param nameDescription
     */
    public ChartObject(JPanel jPanel, String[][] cellSelectedContent,
            Address address1, Address address2, String nameDescription) {
        this.jPanel = jPanel;
        this.cellSelectedContent = cellSelectedContent;
        this.address1 = address1;
        this.address2 = address2;
        this.nameDescription = nameDescription;
    }

    public String[][] getCellSelectedContent() {
        return cellSelectedContent;
    }

    public void setCellSelectedContent(String[][] cellSelectedContent) {
        this.cellSelectedContent = cellSelectedContent;
    }

    public Address getAddress1() {
        return address1;
    }

    public void setAddress1(Address address1) {
        this.address1 = address1;
    }

    public Address getAddress2() {
        return address2;
    }

    public void setAddress2(Address address2) {
        this.address2 = address2;
    }

    public JPanel getjPanel() {
        return jPanel;
    }

    public void setjPanel(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public String getNameDescription() {
        return nameDescription;
    }

    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }

    /**
     * @TODO
     */
    public void putInWindow() {
        JFrame f = new JFrame(this.nameDescription);
        f.setSize(this.jPanel.getSize().width, this.jPanel.getSize().height);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
        f.setAlwaysOnTop(true);
        f.getContentPane().add(this.jPanel);
        f.pack();
    }

    @Override
    public String toString() {
        return nameDescription;
    }

}
