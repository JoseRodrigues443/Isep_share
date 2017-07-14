/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150595.emailAndPhoneEdition;

import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.email.Email;

/**
 *
 * @author 1150595
 */
public class Utils {

    public static DefaultComboBoxModel comboBoxModelEmails(Set<Email> emails) {
        DefaultComboBoxModel model = new DefaultComboBoxModel<>();
        for (Email e : emails) {
            model.addElement(e);
        }
        return model;
    }

    public static String fileChooser() {
        JFileChooser file = new JFileChooser();
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res = file.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(file, "Directory selected!", "Information message", JOptionPane.INFORMATION_MESSAGE);
        }
        return String.valueOf(file.getSelectedFile());
    }

}
