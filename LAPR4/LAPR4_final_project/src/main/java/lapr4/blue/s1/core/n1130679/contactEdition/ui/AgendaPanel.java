/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1130679.contactEdition.ui;

import csheets.ui.ctrl.UIController;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import lapr4.blue.s1.core.n1130679.contactEdition.application.AgendaController;
import lapr4.blue.s1.core.n1150433.addressEdition.domain.Address;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.PhoneNumber;
import lapr4.white.s1.core.n4567890.contacts.ContactsExtension;
import lapr4.white.s1.core.n4567890.contacts.domain.Agenda;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;
import lapr4.white.s1.core.n4567890.contacts.ui.ContactDialog;

/**
 *
 * @author Ana
 */
public class AgendaPanel extends JPanel implements ActionListener {

    private UIController uiController;

    // Controller for Agenda
    private AgendaController controller = null;

    /**
     * The text field in which the comment of the cell is displayed.
     */
    private JTextArea commentField = new JTextArea();

    // Controls for the contact panel
    private JLabel labelContacts = null;
    private JTextField contactsFilterField = null;
    private JList<Contact> contactsList = null;
    private JList<Event> eventsList = null;
    private DefaultListModel<Contact> model = null;
    private DefaultListModel<Event> emodel = null;
    private JButton eventsAddButton = null;
    private JButton eventsRemoveButton = null;
    private JButton eventsEditButton = null;

    private JPanel contactsPane = null;
    private JPanel agendaPane = null;
    private JPanel filterPane = null;
    private JPanel buttonPane = null;

    // Action commands
    private final static String addAction = "add";
    private final static String removeAction = "remove";
    private final static String editAction = "edit";
    
    
    private Contact c1;

    private void setupContactsWidgets() throws DataConcurrencyException, DataIntegrityViolationException {

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
        
        emodel = new DefaultListModel();
        
        for (Contact c : controller.allContacts()) {
            if (c.agenda()!= null) {
                for (Event e : c.agenda().getAll()) {
                    emodel.addElement(e);
                }
            }

        }
      
        contactsList = new JList(model);
        eventsList = new JList(emodel);

        contactsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        eventsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane centerPane = new JScrollPane(contactsList);
        JScrollPane centerPane2 = new JScrollPane(eventsList);

        // Last Pane: A row of buttons and the end
        buttonPane = new JPanel(new FlowLayout(FlowLayout.LEADING));
        eventsAddButton = new JButton("Add Event");
        eventsAddButton.setActionCommand(AgendaPanel.addAction);
        eventsAddButton.addActionListener(this);
        eventsRemoveButton = new JButton("Remove Event");
        eventsRemoveButton.setActionCommand(AgendaPanel.removeAction);
        eventsRemoveButton.addActionListener(this);
        eventsEditButton = new JButton("Edit Event");
        eventsEditButton.setActionCommand(AgendaPanel.editAction);
        eventsEditButton.addActionListener(this);
        buttonPane.add(eventsAddButton);
        buttonPane.add(eventsRemoveButton);
        buttonPane.add(eventsEditButton);

        // The parent Pane is of type BorderLayout so that the center list occupies all the "empty" canvas
        contactsPane = new JPanel(new BorderLayout());
        contactsPane.add(filterPane, BorderLayout.PAGE_START);
        contactsPane.add(centerPane, BorderLayout.CENTER);
        contactsPane.add(buttonPane, BorderLayout.PAGE_END);
        
        agendaPane = new JPanel(new BorderLayout());
        agendaPane.add(centerPane2, BorderLayout.SOUTH);
        
        add(contactsPane,BorderLayout.NORTH);
        add(agendaPane, BorderLayout.SOUTH);
    }

    /**
     * Creates a new comment panel.
     *
     * @param uiController the user interface controller
     */
    public AgendaPanel(UIController uiController) throws DataConcurrencyException, DataIntegrityViolationException {
        // Configures panel
        super(new BorderLayout());
        
        setName(ContactsExtension.NAME);

        this.uiController = uiController;

        // Creates controller
        this.controller = new AgendaController(this.uiController.getUserProperties());

        setupContactsWidgets();

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));

        JPanel agendaPane = new JPanel(new GridLayout(1, 1));

        // Adds borders
        TitledBorder border = BorderFactory.createTitledBorder("Contacts");
        border.setTitleJustification(TitledBorder.CENTER);
        contactsPane.setBorder(border);

        border = BorderFactory.createTitledBorder("Agenda");
        border.setTitleJustification(TitledBorder.CENTER);
        agendaPane.setBorder(border);

        // Creates side bar
        mainPanel.add(contactsPane);
        mainPanel.add(agendaPane);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int index = -1;
        int index1=-1;

        switch (e.getActionCommand()) {
            case AgendaPanel.addAction: {
                if(contactsList.getSelectedValue()!=null){
                      Event ev = null;
                CreateDialog.showDialog(this, eventsAddButton, this.controller,
                        CreateDialog.CreateDialogMode.ADD, "New Agenda", this.uiController,contactsList.getSelectedValue(),eventsList.getSelectedValue());
                if (CreateDialog.successResult()) {
                    ev = CreateDialog.event();
                    // Update the model of the JList
                   emodel.addElement(ev);
                }
                }
              
            }
            break;

            case AgendaPanel.removeAction:
                index = eventsList.getSelectedIndex();
                index1=contactsList.getSelectedIndex();
                if (index != -1 && index1!=-1) {
                    Event ev;
                    ev = emodel.getElementAt(index);

                    CreateDialog.showDialog(this, eventsRemoveButton, this.controller,
                            CreateDialog.CreateDialogMode.DELETE, "Delete Agenda", ev, this.uiController,contactsList.getSelectedValue(),eventsList.getSelectedValue());
                    if (CreateDialog.successResult()) {
                        // Update the model of the JList
                        emodel.remove(index);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Select an person and a event!");
                }
                break;

            case AgendaPanel.editAction:
                index = eventsList.getSelectedIndex();
                if (index != -1) {
                    Event ev;
                    //c = (Contact)(contactsList.getModel().getElementAt(index));
                   
                    ev = emodel.getElementAt(index);

                    CreateDialog.showDialog(this, eventsEditButton, this.controller,
                            CreateDialog.CreateDialogMode.EDIT, "Edit Agenda", ev, this.uiController, contactsList.getSelectedValue(),eventsList.getSelectedValue());
                    if (CreateDialog.successResult()) {
                        // Update the model of the JList
                        emodel.set(index, ev);
                    } else {
                        // Maybe the user tried to update but failed and canceled. We need to "refresh" the contact object
                        Event updatedEvent = this.controller.getEvent(ev, c1);
                        // Update the model of the JList
                        emodel.set(index, updatedEvent);
                    }

                }
                break;
        }
    }

}
