/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.white.s1.core.n4567890.contacts.ui;

import csheets.CleanSheets;
import csheets.ui.ctrl.UIController;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import lapr4.blue.s1.core.n1150433.addressEdition.ui.AddressEditionUI;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.ui.EmailAndPhoneEditionUI;
import lapr4.green.s2.core.n1150993.CompanyContact.Company;
import lapr4.green.s2.core.n1150993.CompanyContact.botstrap;
import lapr4.green.s2.core.n1150993.CompanyContactUI.CompanyContactController;
import lapr4.red.s3.core.n1151117.contactstags.ui.AddTagUI;
import lapr4.red.s3.core.n1151117.contactstags.ui.RemoveTagUI;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;
import lapr4.white.s1.core.n4567890.contacts.domain.Contact;

/**
 *
 * @author alexandrebraganca
 *
 * edited by Bruna Teixeira (1150595)
 *
 * edited by Débora Costa (1150433)
 * 
 * edited by José Barros (1151117)
 */
public class ContactDialog extends JDialog implements ActionListener {

    private static ContactDialog dialog;
    private static String value = "";
    private JList list;

    private static Contact _contact = null;
    private static boolean _success = false;
    private static UIController uiController = null;

    public enum ContactDialogMode {
        ADD,
        DELETE,
        EDIT
    }

    public static Contact contact() {
        return _contact;
    }

    public static boolean successResult() {
        return _success;
    }

    private ContactDialogMode mode = ContactDialogMode.ADD;
    private ContactController ctrl = null;

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
            ContactController ctrl,
            ContactDialogMode mode,
            String title, Contact contact, UIController uiController) {
        _success = false;
        Frame frame = JOptionPane.getFrameForComponent(frameComp);
        dialog = new ContactDialog(frame,
                locationComp,
                ctrl,
                mode,
                title, contact, uiController);
        dialog.setVisible(true);
    }

    public static void showDialog(Component frameComp,
            Component locationComp,
            ContactController ctrl,
            ContactDialogMode mode,
            String title, UIController uiController) {

        showDialog(frameComp, locationComp, ctrl, mode, title, null, uiController);
    }

    // Widgets
    private JButton confirmButton = null;
    private JButton cancelButton = null;

    private JButton addressButton = null;
    private JButton emailPhoneButton = null;
    private JButton addTagButton = null;
    private JButton removeTagButton = null;

    private JLabel fullNameLabel = null;
    private JLabel firstNameLabel = null;
    private JLabel lastNameLabel = null;

    private JTextField fullNameField = null;
    private JTextField firstNameField = null;
    private JTextField lastNameField = null;

    private JPanel formPanel = null;
    private JPanel buttonPanel = null;

    private JLabel statusLabel = null;
    private JLabel professionLabel=null;
    private JLabel companyLabel=null;
    private JComboBox professionCombo=null;
    private JComboBox companyCombo=null;
    private CompanyContactController controller;
    

    private void setupContactsWidgets() {

     
            formPanel = new JPanel(new SpringLayout());
            
            
            // FullName
            fullNameLabel = new JLabel(CleanSheets.getString("full_name_label"), JLabel.TRAILING);
            fullNameField = new JTextField(30);
            fullNameLabel.setLabelFor(fullNameField);
            formPanel.add(fullNameLabel);
            formPanel.add(fullNameField);
            
            // FirstName
            firstNameLabel = new JLabel(CleanSheets.getString("first_name_label"), JLabel.TRAILING);
            firstNameField = new JTextField(10);
            firstNameLabel.setLabelFor(firstNameField);
            formPanel.add(firstNameLabel);
            formPanel.add(firstNameField);
            
            // LastName
            lastNameLabel = new JLabel(CleanSheets.getString("last_name_label"), JLabel.TRAILING);
            lastNameField = new JTextField(10);
            lastNameLabel.setLabelFor(lastNameField);
            formPanel.add(lastNameLabel);
            formPanel.add(lastNameField);
            
            //Profession
            String[] typeContact=ctrl.getProfessions();
            professionCombo= new JComboBox(typeContact);
            professionLabel=new JLabel("Profissao: ");
            
            formPanel.add(professionLabel);
            formPanel.add(professionCombo);
            
            //Company
//            botstrap b = new botstrap(uiController);

            int cont = 0, cont1 = 0;

            for (Company cv : controller.getRepository().findAll()) {

                cont1++;
            }
            String[] typeCompany = new String[cont1];
            for (Company cv : controller.getRepository().findAll()) {

                typeCompany[cont] =cv.name();//(Objects.toString(cv.id(), null));
                cont++;
            }

            companyCombo = new JComboBox(typeCompany);
            companyLabel = new JLabel("Empresa: ");
            
            
            formPanel.add(companyLabel);
            formPanel.add(companyCombo);
            
            
            SpringUtilities.makeCompactGrid(formPanel,
                    5, 2, //rows, cols
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
            
            addressButton = new JButton(CleanSheets.getString("address_button"));
            addressButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    try {
                        new AddressEditionUI(uiController, _contact).setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DataConcurrencyException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DataIntegrityViolationException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            emailPhoneButton = new JButton(CleanSheets.getString("emailPhone_button"));
            emailPhoneButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    try {
                        new EmailAndPhoneEditionUI(ctrl, _contact).setVisible(true);
                    } catch (DataIntegrityViolationException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (DataConcurrencyException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            addTagButton = new JButton(CleanSheets.getString("addTag_button"));
            addTagButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new AddTagUI(null, true, ctrl, _contact).setVisible(true);
                }
            });
            
            removeTagButton = new JButton(CleanSheets.getString("removeTag_button"));
            removeTagButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new RemoveTagUI(_contact, ctrl);
                }
            });
            
            buttonPanel.add(confirmButton);
            buttonPanel.add(cancelButton);
            
            // Final Pane: The status label for messages
            statusLabel = new JLabel();
            
            switch (this.mode) {
                case ADD:
                    
                    statusLabel.setText(CleanSheets.getString("status_please_enter_data_for_new_contcat"));
                    break;
                case DELETE:
                    statusLabel.setText(CleanSheets.getString("status_please_confirm_contact_to_delete"));
                    
                    // All fields in read-only mode
                    this.fullNameField.setEditable(false);
                    this.firstNameField.setEditable(false);
                    this.lastNameField.setEditable(false);
                    break;
                case EDIT:
                    this.setModalityType(Dialog.ModalityType.MODELESS);
                    buttonPanel.add(addressButton);
                    buttonPanel.add(emailPhoneButton);
                    buttonPanel.add(addTagButton);
                    buttonPanel.add(removeTagButton);
                    statusLabel.setText(CleanSheets.getString("status_please_update_data_of_contcat"));
                    break;
            }
            
            //Put everything together, using the content pane's BorderLayout.
            Container contentPane = getContentPane();
            contentPane.add(formPanel, BorderLayout.PAGE_START);
            contentPane.add(buttonPanel, BorderLayout.CENTER);
            contentPane.add(statusLabel, BorderLayout.PAGE_END);
       
    }

    private void setupData() {
        if (_contact != null) {
            this.fullNameField.setText(_contact.name());
            this.firstNameField.setText(_contact.firstName());
            this.lastNameField.setText(_contact.lastName());
        }
    }

    private ContactDialog(Frame frame,
            Component locationComp,
            ContactController ctrl,
            ContactDialogMode mode,
            String title, Contact contact, UIController uiController) {
        super(frame, title, true);

        this.mode = mode;
        this.ctrl = ctrl;
        _contact = contact;
        this.uiController = uiController;
        this.controller=new CompanyContactController(this.uiController.getUserProperties());
        setupContactsWidgets();
        setupData();

        pack();
        setLocationRelativeTo(locationComp);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ("confirm".equals(e.getActionCommand())) {
            switch (this.mode) {
                case ADD: {
                    try {
                        Company companyChange=null;
                        for(Company comp: controller.getAllCompanys()){
                            if(comp.name().equalsIgnoreCase(companyCombo.getSelectedItem().toString())){
                               companyChange=comp;
                            }
                        }
                        // The User confirms the creation of a Contact
                        _contact = this.ctrl.addContact(this.fullNameField.getText(), this.firstNameField.getText(), this.lastNameField.getText(),companyChange,this.professionCombo.getSelectedItem().toString());
                      
                        _success = true;
                        // Exit the dialog
                        ContactDialog.dialog.setVisible(false);
                    } catch (DataConcurrencyException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_concurrency_error"));
                    } catch (DataIntegrityViolationException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_integrity_error"));
                    }
                }
                break;

                case DELETE: {
                    try {
                        boolean r;
                        r = this.ctrl.removeContact(_contact);

                        _success = true;
                        // Exit the dialog
                        ContactDialog.dialog.setVisible(false);
                    } catch (DataConcurrencyException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_concurrency_error"));
                    } catch (DataIntegrityViolationException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_integrity_error"));
                    }
                }
                break;

                case EDIT: {
                    try {
                        Company cmp=null;
                        for(Company c:controller.getAllCompanys()){
                            if(c.name().equalsIgnoreCase(companyCombo.getSelectedItem().toString())){
                               cmp=c;
                            }
                        }
                        _contact = this.ctrl.updateContact(_contact, this.fullNameField.getText(), this.firstNameField.getText(), this.lastNameField.getText(),cmp,professionCombo.getSelectedItem().toString());
                        
                        _success = true;
                        // Exit the dialog
                        ContactDialog.dialog.setVisible(false);
                    } catch (DataConcurrencyException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_concurrency_error"));
                    } catch (DataIntegrityViolationException ex) {
                        Logger.getLogger(ContactDialog.class.getName()).log(Level.SEVERE, null, ex);
                        statusLabel.setForeground(Color.red);
                        statusLabel.setText(CleanSheets.getString("status_data_integrity_error"));
                    }
                }
                break;
            }
            //ContactDialog.value = (String)(list.getSelectedValue());
        } else {
            _success = false;
            // Exit the dialog
            ContactDialog.dialog.setVisible(false);
        }
    }

}
