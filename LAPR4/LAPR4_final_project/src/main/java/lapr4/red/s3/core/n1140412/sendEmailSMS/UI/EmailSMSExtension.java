/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1140412.sendEmailSMS.UI;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import lapr4.red.s3.core.n1140412.sendEmailSMS.Controller.EmailSMSController;

/**
 *
 * @author Tiago
 */
public class EmailSMSExtension extends UIExtension {

    private final EmailSMSController controller;

    public EmailSMSExtension(Extension extension, UIController uiController) {
        super(extension, uiController);
        
        controller = new EmailSMSController(this.uiController.getUserProperties());
    }

    @Override
    public JMenu getMenu() {
        JMenu macrosMenu = new JMenu("Email/SMS");

        JMenuItem item = new JMenuItem("Email/SMS");
        macrosMenu.add(item);

        ActionListener listener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                new EmailSMSUI(controller);
            }
        };
        item.addActionListener(listener);
        return macrosMenu;
    }
}
