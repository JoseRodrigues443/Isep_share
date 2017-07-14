/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150993.CompanyContactUI;

import csheets.ui.ctrl.UIController;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr4.green.s2.core.n1150993.CompanyContact.Company;
import lapr4.green.s2.core.n1150993.CompanyContact.botstrap;

/**
 *
 * @author 1150993
 */
public class RemoveCompanyMenu extends JFrame {
    /*
    *Instance of uiController
    */
    private final UIController uiController;
    
    /*
    *Instance of CompanyContactController
    */
    private final CompanyContactController controller;
    
    /*
    *Main panel
    */
    private JPanel mainPanel;
    
    /*
    *Name of company panel
    */
    private JPanel namePanel;
    
    /*
    *List of companies panel
    */
    private JPanel listPanel;
    
    /*
    *Buttons panel
    */
    private JPanel buttonsPanel;
    
    /*
    *List of companys
    */
    private JList list;
    
    /*
    *Name of company label
    */
    private JLabel nameLabel;
    
    private DefaultListModel model;
   
    /*
    *Remove button
    */
    private JButton removeBTN;
 
    /*
    *Event for remove btn
    */
    private BTNEvent createEvent;
   
    private JComboBox comboBox;
    
    
    GridLayout grid;
    private static final int widthFrame = 400;
    private static final int heightFrame = 150;
    
    public RemoveCompanyMenu(UIController uiController){
        super("Remove Company");
        this.uiController=uiController;
        this.controller=new CompanyContactController(this.uiController.getUserProperties());
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screensize = toolkit.getScreenSize();
        int widthEcra = ((int) screensize.getWidth() / 2);
        int heightEcra = ((int) screensize.getHeight() / 2);
        widthEcra -= (widthFrame / 2);
        heightEcra -= (heightFrame / 2);
        setLocation(widthEcra, heightEcra);
        this.showRemoveMenu();
    }
    
    public void showRemoveMenu(){

        List<Company> list1=controller.getAllCompanys();

        if (!list1.isEmpty()) {
            grid = new GridLayout(3, 1);

            this.mainPanel = new JPanel(grid);
            this.namePanel = new JPanel();
            this.nameLabel = new JLabel("Company");
            this.namePanel.add(nameLabel);
            
            this.listPanel = new JPanel();
            
            this.buttonsPanel = new JPanel();
            
            String[] typeContact=new String[controller.getAllCompanys().size()];
            
            int cont=0;
            for(Company c:controller.getAllCompanys()){
                typeContact[cont]=c.name();
                cont++;
            }
            comboBox= new JComboBox(typeContact);

            this.createEvent = new BTNEvent();
            this.removeBTN = new JButton("Remove");
            this.removeBTN.addActionListener(createEvent);

            this.listPanel.add(comboBox);
            this.buttonsPanel.add(this.removeBTN);
            
            mainPanel.add(namePanel);
            mainPanel.add(listPanel);
            mainPanel.add(buttonsPanel);

            add(mainPanel);
            setResizable(false);
            setSize(widthFrame, heightFrame);
            setVisible(true);

        } else {

            JOptionPane.showMessageDialog(null, "Create an company first");
            dispose();
        }
        
    }
    
    public class BTNEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("Remove".equals(e.getActionCommand())) {
                int confirmation = JOptionPane.showConfirmDialog(null, "To permanently remove this company click Yes");
                if (confirmation == JOptionPane.YES_OPTION) {
                   Company companyToRemove=null;
                        for(Company comp:controller.getAllCompanys()){
                            if(comp.name().equalsIgnoreCase(comboBox.getSelectedItem().toString())){
                               companyToRemove=comp;
                            }
                        }
                        controller.removeCompany(companyToRemove);
                        
                   dispose();

                }

            }

        }
    }
}
