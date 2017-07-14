/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1130679.contactEdition.ui;

import csheets.CleanSheets;
import csheets.ui.ctrl.UIController;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import lapr4.blue.s1.core.n1130679.contactEdition.application.AgendaController;
import lapr4.blue.s1.core.n1150433.addressEdition.ui.AddressEditionUI;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.ui.EmailAndPhoneEditionUI;
import lapr4.green.s2.core.n1150993.CompanyContactUI.CompanyContactController;
import lapr4.green.s2.core.n1150993.CompanyContactUI.CreateCompanyMenu;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;
import lapr4.white.s1.core.n4567890.contacts.domain.Event;
import lapr4.white.s1.core.n4567890.contacts.persistence.ContactRepository;
import lapr4.white.s1.core.n4567890.contacts.persistence.EventRepository;
import lapr4.white.s1.core.n4567890.contacts.ui.SpringUtilities;

/**
 *
 * @author Ana
 */
public class CreateDialog extends JDialog implements ActionListener {

    private static CreateDialog dialog;
    private static String value = "";
    private JList list;

    private static Event _event = null;
    private static Contact contact = null;
    private static boolean _success = false;
    private static UIController uiController = null;

    public enum CreateDialogMode {
        ADD,
        DELETE,
        EDIT
    }

    public static Event event() {
        return _event;
    }

    public static boolean successResult() {
        return _success;
    }

    private CreateDialogMode mode = CreateDialogMode.ADD;
    private AgendaController ctrl = null;

    /**
     * Set up and show the dialog. The first Component argument determines which
     * frame the dialog depends on; it should be a component in the dialog's
     * controlling frame. The second Component argument should be null if you
     * want the dialog to come up with its left corner in the center of the
     * screen; otherwise, it should be the component on top of which the dialog
     * should appear.
     */
    public static void showDialog(Component frameComp,
            Component locationComp,
            AgendaController ctrl,
            CreateDialogMode mode,
            String title, Event ev, UIController uiController, Contact c,Event e) {
        contact = c;
        _event=e;
        _success = false;
        Frame frame = JOptionPane.getFrameForComponent(frameComp);
        dialog = new CreateDialog(frame,
                locationComp,
                ctrl,
                mode,
                title, contact, uiController);
        dialog.setVisible(true);
    }

    public static void showDialog(Component frameComp,
            Component locationComp,
            AgendaController ctrl,
            CreateDialogMode mode,
            String title, UIController uiController, Contact c,Event e) {

        showDialog(frameComp, locationComp, ctrl, mode, title, null, uiController, c,e);
    }

    // Widgets
    private JButton confirmButton = null;
    private JButton cancelButton = null;

    private JLabel descriptionLabel = null;
    private JLabel dateLabel = null;

    private JTextField descriptionField = null;
    private JTextField dateField = null;

    private JPanel formPanel = null;
    private JPanel buttonPanel = null;

    private JLabel statusLabel = null;
    private JComboBox dayCombo=null;
    private JComboBox monthCombo=null;
    private JComboBox yearCombo=null;
    private JLabel dayLabel=null;
    private JLabel yearLabel=null;
    private JLabel monthLabel=null;
    private String data;

    private void setupAgendaWidgets() {

        formPanel = new JPanel(new SpringLayout());

        // FullName
        descriptionLabel = new JLabel("Description of event: ", JLabel.TRAILING);
        descriptionField = new JTextField(30);
        descriptionLabel.setLabelFor(descriptionField);
        formPanel.add(descriptionLabel);
        formPanel.add(descriptionField);
        
        String[] day=new String[31];
        for(int i=1;i<=31;i++){
            day[i-1]=Integer.toString(i);
        }
    
        dayCombo = new JComboBox(day);
        dayLabel = new JLabel("Day: ");

        formPanel.add(dayLabel);
        formPanel.add(dayCombo);
        
        String[] month={"01","02","03","04","05","06","07","08","09","10","11","12"};
    
        monthCombo = new JComboBox(month);
        monthLabel = new JLabel("Month: ");

        formPanel.add(monthLabel);
        formPanel.add(monthCombo);
        
        String[] year={"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
        
        yearCombo = new JComboBox(year);
        yearLabel = new JLabel("Year: ");

        formPanel.add(yearLabel);
        formPanel.add(yearCombo);

        SpringUtilities.makeCompactGrid(formPanel,
                4, 2, //rows, cols
                6, 6, //initX, initY
                6, 6);       //xPad, yPad

        // Last Pane: A row of buttons and the end
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        confirmButton = new JButton(CleanSheets.getString("confirm_button"));
        confirmButton.setActionCommand("confirm");
        confirmButton.addActionListener(this);
        cancelButton = new JButton(CleanSheets.getString("cancel_button"));
        cancelButton.setActionCommand("cancel");
        cancelButton.addActionListener(this);

        buttonPanel.add(confirmButton);
        buttonPanel.add(cancelButton);

        // Final Pane: The status label for messages
//        statusLabel = new JLabel();
//
//        switch (this.mode) {
//            case ADD:
//
//                statusLabel.setText(CleanSheets.getString("status_please_enter_data_for_new_contact"));
//                break;
//            case DELETE:
//                statusLabel.setText(CleanSheets.getString("status_please_confirm_contact_to_delete"));
//
//                // All fields in read-only mode
//                this.descriptionField.setEditable(false);
//                this.dateField.setEditable(false);
//                break;
//            case EDIT:
//                this.setModalityType(Dialog.ModalityType.MODELESS);
//                statusLabel.setText(CleanSheets.getString("status_please_update_data_of_event"));
//                break;
//        }

        //Put everything together, using the content pane's BorderLayout.
        Container contentPane = getContentPane();
        contentPane.add(formPanel, BorderLayout.PAGE_START);
        contentPane.add(buttonPanel, BorderLayout.CENTER);
    }

    private void setupData() {
        if (_event != null) {
            this.descriptionField.setText(_event.description());
        }
    }

    private CreateDialog(Frame frame,
            Component locationComp,
            AgendaController ctrl,
            CreateDialogMode mode,
            String title, Contact contact, UIController uiController) {
        super(frame, title, true);
        
        this.mode = mode;
        this.ctrl = ctrl;
        this.contact = contact;
        this.uiController = uiController;

        setupAgendaWidgets();
        setupData();

        pack();
        setLocationRelativeTo(locationComp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("confirm".equals(e.getActionCommand())) {
            switch (this.mode) {
                case ADD:    {
                try {
                    this.data=dayCombo.getSelectedItem().toString() + "/" + monthCombo.getSelectedItem().toString() + "/" +yearCombo.getSelectedItem().toString();
                    // The User confirms the creation of a Event
                    _event = this.ctrl.addEvent(contact ,this.descriptionField.getText(),data);
                } catch (DataConcurrencyException ex) {
                    Logger.getLogger(CreateDialog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DataIntegrityViolationException ex) {
                    Logger.getLogger(CreateDialog.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(CreateDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
                    _success = true;
                    // Exit the dialog
                    CreateDialog.dialog.setVisible(false);
                }
                break;

                case DELETE:  {
                  
                    this.ctrl.deleteEvent(_event, contact);
                    _success = true;
                   
                    // Exit the dialog
                    CreateDialog.dialog.setVisible(false);
                }
                break;

                case EDIT: {
                    try {
                        this.data=dayCombo.getSelectedItem().toString() + "/" + monthCombo.getSelectedItem().toString() + "/" +yearCombo.getSelectedItem().toString();
                        _event = this.ctrl.changeEvent(descriptionField.getText(), data, _event, contact);

                        _success = true;
                        // Exit the dialog
                        CreateDialog.dialog.setVisible(false);
                    } catch (DataConcurrencyException ex) {
                        Logger.getLogger(CreateDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_concurrency_error"));
                    } catch (DataIntegrityViolationException ex) {
                        Logger.getLogger(CreateDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_integrity_error"));
                    } catch (ParseException ex) {
                    Logger.getLogger(CreateDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                break;
            }
            //ContactDialog.value = (String)(list.getSelectedValue());
        } else {
            _success = false;
            // Exit the dialog
            CreateDialog.dialog.setVisible(false);
        }
    }

}
