/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150993.CompanyContactUI;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
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
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import lapr4.green.s2.core.n1150993.CompanyContact.Company;
import lapr4.green.s2.core.n1150993.CompanyContact.botstrap;
import lapr4.red.s3.core.n1151117.contactstags.ui.AddTagUI;
import lapr4.red.s3.core.n1151117.contactstags.ui.RemoveTagUI;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;

/**
 *
 * @author 1150993
 * 
 * Edited by José Barros 1151117
 */
public class EditCompanyMenu extends JFrame {

    /*
    *Instance of UIController
     */
    private UIController uiController;

    /*
    *Instance of CompanyContactController
     */
    private CompanyContactController controller;

    /*
    *Main panel
     */
    private JPanel mainPanel;

    /*
    *Companys panel
     */
    private JPanel companyPanel;

    /*
    *Buttons panel
     */
    private JPanel buttonsPanel;

    /*
    *Name of company label
     */
    private JLabel nameLabel;

    /*
    *Companies label
     */
    private JLabel companyLabel;

    /*
    *Name of company text field
     */
    private JTextField nameTXT;

    /*
    *Combo with all companies
     */
    private JComboBox comboBox;

    /*
    *Instance of botstrap(just for tests)
     */
    private botstrap b;

    /*
    *Edit company button
     */
    private JButton editBTN;
    
    /*
    *Add tag button
     */
    private JButton tagBTN;
    
    /*
    *Remove tag button
     */
    private JButton removeTagBTN;

    /*
    *Event of edit button
     */
    private ButtonEvent editEvent;

    /*
    *Lable of people related
     */
    private JLabel peopleRelatedLabel;

    /*
    *People related with company list
     */
    private JList<Contact> peopleList = null;
    private DefaultListModel<Contact> model = null;
    private ContactController contactController;
    private JLabel eventLabel=null;
    private JList<Event> eventList = null;
    private DefaultListModel<Event> emodel = null;
    private JPanel namePanel;
    private JPanel peoplePanel;
    private JPanel eventPanel;
    
    /**
     * Selected contact
     */
    private Contact contact;

    JScrollPane scroll;
    GridLayout grid;
    GridLayout grid1;
    private static final int widthFrame = 400;
    private static final int heightFrame = 400;

    public EditCompanyMenu(UIController uiController, botstrap b) {
        super("Edit Company");
        this.uiController = uiController;
        this.b = b;
        this.controller = new CompanyContactController(this.uiController.getUserProperties());
        this.contactController = new ContactController(this.uiController.getUserProperties());

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screensize = toolkit.getScreenSize();
        int widthEcra = ((int) screensize.getWidth() / 2);
        int heightEcra = ((int) screensize.getHeight() / 2);
        widthEcra -= (widthFrame / 2);
        heightEcra -= (heightFrame / 2);
        setLocation(widthEcra, heightEcra);

        this.showEditMenu();
    }

    protected void showEditMenu() {

        List<Company> list = controller.getAllCompanys();

        //Case exists companies
        if (!list.isEmpty()) {
            grid = new GridLayout(5, 1);
            grid1=new GridLayout(1,2);

            mainPanel = new JPanel(grid);
            companyPanel = new JPanel();
            buttonsPanel = new JPanel();
            namePanel=new JPanel(grid1);
            peoplePanel=new JPanel(grid1);
            eventPanel=new JPanel(grid1);
            
            //Name
            nameLabel = new JLabel("Name of company:");
            nameTXT = new JTextField();
            nameTXT.setColumns(10);
            
            
            companyLabel = new JLabel("Company: ");
            peopleRelatedLabel = new JLabel("People related: ");
            eventLabel=new JLabel("Agenda of each person of company: ");
            
            

            String[] typeContact = new String[controller.getAllCompanys().size()];

            int cont = 0;
            for (Company c : controller.getAllCompanys()) {
                typeContact[cont] = c.name();
                cont++;
            }
            comboBox = new JComboBox(typeContact);
            editEvent = new ButtonEvent();

            editBTN = new JButton("Edit");
            editBTN.addActionListener(editEvent);
            
            tagBTN = new JButton("Add tag");
            tagBTN.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int idx = comboBox.getSelectedIndex();
                    contact = controller.getAllCompanys().get(idx);
                    new AddTagUI(null, true, contactController, contact).setVisible(true);
                }
            });
            
            removeTagBTN = new JButton("Remove tag");
            removeTagBTN.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int idx = comboBox.getSelectedIndex();
                    contact = controller.getAllCompanys().get(idx);
                    new RemoveTagUI(contact, contactController);
                }
            });

            model = new DefaultListModel();
            for (Contact contact : contactController.allContacts()) {
                if (contact.getCompany() != null) {
                    if (contact.getCompany().name().equalsIgnoreCase(comboBox.getSelectedItem().toString())) {
                        model.addElement(contact);
                    }
                }

            }
       
            peopleList = new JList(model);
            peopleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane centerPane = new JScrollPane(peopleList);
//            centerPane.setBounds(0, 0, 100, 100);
            
            emodel = new DefaultListModel();
            int index = -1;
            index = peopleList.getSelectedIndex();
            if (index != -1) {
                if (peopleList.getSelectedValue().agenda() != null) {
                    for (Event e : peopleList.getSelectedValue().agenda().getAll()) {
                        emodel.addElement(e);
                    }
                }
            }
            
            eventList=new JList(emodel);
            eventList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            JScrollPane centerPane2 = new JScrollPane(eventList);
//            centerPane2.setBounds(0, 0, 100, 100);
            
           
            companyPanel.add(companyLabel);
            companyPanel.add(comboBox, BorderLayout.PAGE_START);
            namePanel.add(nameLabel);
            namePanel.add(nameTXT);
            peoplePanel.add(peopleRelatedLabel);
            peoplePanel.add(centerPane);
            eventPanel.add(eventLabel);
            eventPanel.add(centerPane2);
            
            buttonsPanel.add(editBTN);
            buttonsPanel.add(tagBTN);

            mainPanel.add(companyPanel);
            mainPanel.add(namePanel,BorderLayout.AFTER_LAST_LINE);
            mainPanel.add(peoplePanel,BorderLayout.AFTER_LAST_LINE);
            mainPanel.add(eventPanel,BorderLayout.AFTER_LAST_LINE);
            mainPanel.add(buttonsPanel,BorderLayout.AFTER_LAST_LINE);

            add(mainPanel);
            setResizable(false);
            setSize(widthFrame, heightFrame);
            setVisible(true);
            comboBox.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    model.clear();
                    for (Contact contact : contactController.allContacts()) {
                        if (contact.getCompany() != null) {
                            if (contact.getCompany().name().equalsIgnoreCase(comboBox.getSelectedItem().toString())) {
                                model.addElement(contact);
                            }
                        }

                    }
                }
            });
          
            peopleList.addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    emodel.clear();
                    int index = -1;
                    index = peopleList.getSelectedIndex();
                    if (index != -1) {
                        if (peopleList.getSelectedValue().agenda() != null) {
                            for (Event ev : peopleList.getSelectedValue().agenda().getAll()) {
                                emodel.addElement(ev);
                            }
                        }
                    }

                }
            });

        } else {
            JOptionPane.showMessageDialog(null, "First create a company!");
            dispose();
        }
    }

    public class ButtonEvent implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!nameTXT.getText().isEmpty()) {
                int confirmAction = JOptionPane.showConfirmDialog(null, "To permanently edit this company click Yes");
                if (confirmAction == JOptionPane.YES_OPTION) {
                    Company companyToEdit = null;

                    for (Company comp : controller.getAllCompanys()) {
                        if (comp.name().equalsIgnoreCase(comboBox.getSelectedItem().toString())) {
                            companyToEdit = comp;
                            
                        }
                    }

                    controller.editCompany(companyToEdit, nameTXT.getText());
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            }
        }

    }

}
