/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode;

import csheets.ui.ctrl.UIController;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author 1150595
 */
public class ImportCountryCodesUI extends JFrame {

    private ImportCountryCodesController controller;

    private UIController uiController;

    private String fileName;

    public ImportCountryCodesUI(UIController uiController) {

        this.uiController = uiController;
        setTitle("Import Country Codes");

        setPreferredSize(new Dimension(320, 240));
        setLayout(new GridLayout(4, 1));

        JPanel fileChooser = fileChooserPanel();
        JPanel importBtn = importBtnPanel();

        add(fileChooser);
        add(importBtn);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private JPanel fileChooserPanel() {
        JPanel panel = new JPanel();
        JButton btnChooser = new JButton("Choose file");
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(".txt", "txt"));

        btnChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = chooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    fileName = chooser.getSelectedFile().getPath();
                }
            }
        });
        panel.add(btnChooser);
        return panel;
    }

    private JPanel importBtnPanel() {
        JPanel panel = new JPanel();
        JButton btnImport = new JButton("Import");

        btnImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    controller = new ImportCountryCodesController(uiController.getUserProperties());
                    try {
                        controller.importCountryCodes(fileName);
                    } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
                        JOptionPane.showMessageDialog(null, "Country Codes weren't imported!",
                                "Error", JOptionPane.WARNING_MESSAGE);
                    }
                    dispose();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Country Codes weren't imported!",
                            "Error", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        panel.add(btnImport);
        return panel;
    }

}
