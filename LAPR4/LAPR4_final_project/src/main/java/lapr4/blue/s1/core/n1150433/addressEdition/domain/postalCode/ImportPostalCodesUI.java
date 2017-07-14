/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode;

import csheets.ui.ctrl.UIController;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Débora Costa - 1150433
 */
public class ImportPostalCodesUI extends JFrame {
    private ImportPostalCodesController controller;

    private UIController uiController;

    private String fileName;
    
    public ImportPostalCodesUI(UIController uiController){
        this.uiController = uiController;
        setTitle("Import Postal Codes");
        
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
    
    private JPanel fileChooserPanel(){
        JPanel panel = new JPanel();
        JButton btnChooser = new JButton("Choose file");
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter(new FileNameExtensionFilter(".txt", "txt"));
        
        btnChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = chooser.showOpenDialog(null);
                if(option == JFileChooser.APPROVE_OPTION){
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
                    controller = new ImportPostalCodesController(uiController.getUserProperties());
                    controller.importPostalCodes(fileName);
                    dispose();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, "Postal Codes weren't imported!",
                            "Error", JOptionPane.WARNING_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(ImportPostalCodesUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DataIntegrityViolationException ex) {
                    Logger.getLogger(ImportPostalCodesUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (DataConcurrencyException ex) {
                    Logger.getLogger(ImportPostalCodesUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        panel.add(btnImport);
        return panel;
    }
}
