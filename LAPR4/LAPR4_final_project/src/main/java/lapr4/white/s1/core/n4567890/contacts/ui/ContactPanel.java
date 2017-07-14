/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.ui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import csheets.ui.ctrl.UIController;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import lapr4.green.s2.core.n1150993.CompanyContact.Company;
import lapr4.green.s2.core.n1150993.CompanyContact.botstrap;
import lapr4.green.s2.core.n1150993.CompanyContactUI.CreateCompanyMenu;
import lapr4.green.s2.core.n1150993.CompanyContactUI.EditCompanyMenu;
import lapr4.green.s2.core.n1150993.CompanyContactUI.RemoveCompanyMenu;
import lapr4.red.s3.core.n1151117.contactstags.ui.ContactsByTagUI;
import lapr4.red.s3.core.n1151117.contactstags.ui.MostUsedTagsUI;
import lapr4.red.s3.core.n1151117.contactstags.utils.Utils;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import lapr4.white.s1.core.n4567890.contacts.ContactsExtension;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;

/**
 * A panel for adding or editing a comment for a cell
 *
 * @author Alexandre Braganca
 *
 * edited by Bruna Teixeira (1150595)
 * 
 * edited by Sebastião Pinto (1150466)
 * edited by José Barros (1151117)
 */
@SuppressWarnings("serial")
public class ContactPanel extends JPanel implements ActionListener {

    private UIController uiController;

    // Controller for Contacts
    private ContactController controller = null;
    
    private botstrap botstrap;

    /**
     * The text field in which the comment of the cell is displayed.
     */
    private JTextArea commentField = new JTextArea();

    // Controls for the contact panel
    private JLabel labelContacts = null;
    private JTextField contactsFilterField = null;
    private JList<Contact> contactsList = null;
    private DefaultListModel<Contact> model = null;
    private JButton contactsAddButton = null;
    private JButton contactsRemoveButton = null;
    private JButton contactsEditButton = null;

    private JPanel contactsPane = null;
    private JPanel filterPane = null;
    private JPanel buttonPane = null;

    // Action commands
    private final static String addAction = "add";
    private final static String removeAction = "remove";
    private final static String editAction = "edit";

    private void setupContactsWidgets() {

        labelContacts = new JLabel("Filtro: ");

        // First Pane: The "filter", FlowLayout (from left to right)
        filterPane = new JPanel(new FlowLayout(FlowLayout.LEADING));
        contactsFilterField = new JTextField();
        contactsFilterField.setColumns(10);

        filterPane.add(labelContacts);
        filterPane.add(contactsFilterField);
        
        model = new DefaultListModel();
        Iterable<Contact> contacts = controller.allContacts();
        for (Contact c : contacts) {
            model.addElement(c);
        }
       

        contactsList = new JList(model);
        contactsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane centerPane = new JScrollPane(contactsList);
         //Last Pane: A row of buttons and the end
        buttonPane = new JPanel(new FlowLayout(FlowLayout.LEADING));
        contactsAddButton = new JButton("Add");
        contactsAddButton.setActionCommand(ContactPanel.addAction);
        contactsAddButton.addActionListener(this);
        contactsRemoveButton = new JButton("Remove");
        contactsRemoveButton.setActionCommand(ContactPanel.removeAction);
        contactsRemoveButton.addActionListener(this);
        contactsEditButton = new JButton("Edit");
        contactsEditButton.setActionCommand(ContactPanel.editAction);
        contactsEditButton.addActionListener(this);
        buttonPane.add(contactsAddButton);
        buttonPane.add(contactsRemoveButton);
        buttonPane.add(contactsEditButton);

        // The parent Pane is of type BorderLayout so that the center list occupies all the "empty" canvas
        contactsPane = new JPanel(new BorderLayout());
        contactsPane.add(filterPane, BorderLayout.PAGE_START);
        contactsPane.add(centerPane, BorderLayout.CENTER);
        contactsPane.add(buttonPane, BorderLayout.EAST);
    }

    private JLabel label;

    private JComboBox jcombo;
    /*
    *Instance companies
    */
    private botstrap b;
    
    private DefaultListModel emodel;
    private JList jlist;

    /**
     * Creates a new comment panel.
     *
     * @param uiController the user interface controller
     */
    public ContactPanel(UIController uiController) {
        // Configures panel
        super(new BorderLayout());
        setName(ContactsExtension.NAME);

        this.uiController = uiController;
        
        // Creates controller
        this.controller = new ContactController(this.uiController.getUserProperties());
       
        setupContactsWidgets();

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));

        JPanel agendaPane = new JPanel(new GridLayout(0, 1));

        // Adds borders
        TitledBorder border = BorderFactory.createTitledBorder("Contacts");
        border.setTitleJustification(TitledBorder.CENTER);
        contactsPane.setBorder(border);

        label = new JLabel("Choose an option");

        String[] typeContact = {"Person", "Company"};
        jcombo = new JComboBox(typeContact);

        contactsPane.add(label, BorderLayout.AFTER_LAST_LINE);
        contactsPane.add(jcombo, BorderLayout.AFTER_LAST_LINE);
        
        JLabel teste = new JLabel("Tag Seach");
        agendaPane.add(teste, BorderLayout.NORTH);
        JButton btnUsedTag = new JButton("Most used tags");
        btnUsedTag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MostUsedTagsUI(controller.allTagsByFrequency());
            }
        });
        JButton btnSearchByTag = new JButton("Search By Tag");
        btnSearchByTag.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utils utils = new Utils();
                new ContactsByTagUI(controller,uiController.getUserProperties(),utils);
                if(utils.isEditable()){
                    if(utils.currentContact() != null){
                        int index = findContactIndex(utils.currentContact());
                        if(index != -1){
                            ContactDialog.showDialog(null, contactsEditButton, controller,
                                    ContactDialog.ContactDialogMode.EDIT, "Edit Contact", utils.currentContact(),
                                    uiController);
                            if (ContactDialog.successResult()) {
                                // Update the model of the JList
                                model.set(index, utils.currentContact());
                            } else {
                                // Maybe the user tried to update but failed and canceled. We need to "refresh" the contact object
                                Contact updatedContact = controller.getContactById(utils.currentContact().id());
                                // Update the model of the JList
                                model.set(index, updatedContact);
                            }
                        }
                    }
                    else if(utils.currentCompany() != null ){
                        EditCompanyMenu menuCreate = new EditCompanyMenu(uiController, b);
                    }
                }
            }
        });
        agendaPane.add(btnUsedTag, BorderLayout.EAST);
        agendaPane.add(btnSearchByTag, BorderLayout.WEST);

//        border = BorderFactory.createTitledBorder("Agenda");
//        border.setTitleJustification(TitledBorder.CENTER);
//        agendaPane.setBorder(border);
//        
//        JLabel agendaLabel=new JLabel("All events of contacts: ");
//        emodel = new DefaultListModel();
//        
//        for (Contact c : controller.allContacts()) {
//            if (c.agenda()!= null) {
//                for (Event e : c.agenda().getAll()) {
//                    emodel.addElement(e);
//                }
//            }
//
//        }
//        jlist = new JList(emodel);
//        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        JScrollPane centerPane1 = new JScrollPane(jlist);
//        agendaPane.add(agendaLabel);
//        agendaPane.add(centerPane1);

        // Creates side bar
        mainPanel.add(contactsPane);

        mainPanel.add(agendaPane);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = -1;

        switch (e.getActionCommand()) {
            case ContactPanel.addAction: {
                 
                if (jcombo.getSelectedItem().toString() == "Person") {
                    Contact c = null;
                    ContactDialog.showDialog(this, contactsAddButton, this.controller,
                            ContactDialog.ContactDialogMode.ADD, "New Contact", this.uiController);
                    if (ContactDialog.successResult()) {
                        c = ContactDialog.contact();
                         //Update the model of the JList
                        model.addElement(c);//Aqui adicionar a companhia criada à lista
                    }
               } else if (jcombo.getSelectedItem().toString() == "Company") {
                    CreateCompanyMenu menuCreate = new CreateCompanyMenu(this.uiController,b);
                }

            }
            break;

            case ContactPanel.removeAction:
                if (jcombo.getSelectedItem().toString() == "Person") {
                    index = contactsList.getSelectedIndex();
                    if (index != -1) {
                        Contact c;
                        //c = (Contact)(contactsList.getModel().getElementAt(index));
                        c = model.getElementAt(index);

                        ContactDialog.showDialog(this, contactsRemoveButton, this.controller,
                                ContactDialog.ContactDialogMode.DELETE, "Delete Contact", c, this.uiController);
                        if (ContactDialog.successResult()) {
                            // Update the model of the JList
                            model.remove(index);
                        }
                    }
                } else if (jcombo.getSelectedItem().toString() == "Company") {
                    RemoveCompanyMenu menuCreate = new RemoveCompanyMenu(this.uiController);
                }
                break;

            case ContactPanel.editAction:

                if (jcombo.getSelectedItem().toString() == "Person") {
                    index = contactsList.getSelectedIndex();
                    if (index != -1) {
                        Contact c;
                        //c = (Contact)(contactsList.getModel().getElementAt(index));
                        c = model.getElementAt(index);

                        ContactDialog.showDialog(this, contactsEditButton, this.controller,
                                ContactDialog.ContactDialogMode.EDIT, "Edit Contact", c, this.uiController);
                        if (ContactDialog.successResult()) {
                            // Update the model of the JList
                            model.set(index, c);
                        } else {
                            // Maybe the user tried to update but failed and canceled. We need to "refresh" the contact object
                            Contact updatedContact = this.controller.getContactById(c.id());
                            // Update the model of the JList
                            model.set(index, updatedContact);
                        }

                    }

                } else if (jcombo.getSelectedItem().toString() == "Company") {
                    EditCompanyMenu menuCreate = new EditCompanyMenu(this.uiController,b);
                }
                break;

        }
    }
    
    private int findContactIndex(Contact currentContact) {
        for(int i = 0; i < contactsList.getModel().getSize(); i++){
            if(contactsList.getModel().getElementAt(i) == currentContact){
                return i;
            }
        }
        return -1;
    }

    public DefaultListModel<Contact> getModel() {
        return model;
    }
    
}
