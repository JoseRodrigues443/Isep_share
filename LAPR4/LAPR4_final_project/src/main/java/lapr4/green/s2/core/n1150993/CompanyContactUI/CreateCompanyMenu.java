/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150993.CompanyContactUI;

import csheets.ui.ctrl.UIController;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lapr4.green.s2.core.n1150993.CompanyContact.Company;
import lapr4.green.s2.core.n1150993.CompanyContact.botstrap;


/**
 *
 * @author 1150993
 */
public class CreateCompanyMenu extends JFrame {
    
    /*
    *Instance of uiController
    */
    private UIController uiController;
    
    /*
    *Intance of CompanyContactController
    */
    private CompanyContactController controller;
    
    GridLayout grid;
    
    /*
    *Main panel
    */
    private final JPanel mainPanel;
    
    /*
    *Name of company panel
    */
    private final JPanel namePanel;
    
    /*
    *Buttons panel
    */
    private final JPanel buttonsPanel;
    
    /*
    *Name of company label
    */
    private final JLabel nameLabel;
    
    /*
    *Name of company Text Field
    */
    private final JTextField nameTXT;
    
    /*
    *Create company button
    */
    private JButton createBTN;
   
    /*
    *Intance of ButtonEvent
    */
    private final ButtonEvent createEvent;
    private static final int widthFrame = 500;
    private static final int heightFrame = 200;
    /*
    *Instance of botstrap(just for tests)
    */
    private botstrap b;
   
    /*
    *Create an instance of CompanyMenu receiving a uiController as parameter
    *
    *@param uiController
    */
    public CreateCompanyMenu(UIController uiController,botstrap b){
        super("Create Company");
        this.uiController=uiController;
        this.b=b;
        this.controller=new CompanyContactController(this.uiController.getUserProperties());
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screensize = toolkit.getScreenSize();
        int widthEcra = ((int) screensize.getWidth() / 2);
        int heightEcra = ((int) screensize.getHeight() / 2);
        widthEcra -= (widthFrame / 2);
        heightEcra -= (heightFrame / 2);
        setLocation(widthEcra, heightEcra);
        
        grid = new GridLayout(3, 1);
        
        mainPanel = new JPanel(grid);
        namePanel = new JPanel();
        buttonsPanel = new JPanel();

        nameLabel = new JLabel("Name of company:");

        nameTXT = new JTextField();

        nameTXT.setColumns(30);

        createEvent = new ButtonEvent();

        createBTN = new JButton("Create");

        createBTN.addActionListener(createEvent);

        namePanel.add(nameLabel);
        namePanel.add(nameTXT);

        buttonsPanel.add(createBTN);

        mainPanel.add(namePanel,BorderLayout.LINE_START);
        mainPanel.add(buttonsPanel,BorderLayout.LINE_END);

        add(mainPanel);
        setResizable(false);
        setSize(widthFrame, heightFrame);
        setVisible(true);
    }
    
    private class ButtonEvent implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if ("Create".equals(e.getActionCommand())) {
                if (!nameTXT.getText().isEmpty()) {
                    int result = JOptionPane.
                            showConfirmDialog(null, "You have selected the create company option. Do you want to insert the company contact?");

                    if (result == JOptionPane.YES_OPTION) {
                        try {
                            controller.save(controller.newCompanyContact(nameTXT.getText()));

                        } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
                            Logger.getLogger(CreateCompanyMenu.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dispose();

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Fill the name field");
                }

            }
        }

    }
}
