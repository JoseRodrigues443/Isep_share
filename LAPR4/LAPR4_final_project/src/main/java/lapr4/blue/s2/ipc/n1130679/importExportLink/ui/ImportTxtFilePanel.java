/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.ImportExportLink.ui;

import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import lapr4.blue.s2.ipc.n1130679.ImportExportLink.TextFileController;

/**
 *
 * @author Ana Pacheco (1130679)
 */
public class ImportTxtFilePanel extends JDialog {

    private static final String DIALOG_TITLE = "Import TXT File";
    private final Spreadsheet sheet;
    private JTextField pathField;
    private File f;
    private boolean headerLine;
    private String separator;
    private String path;
    private JTextField sep;
    private JCheckBox header;
    private JCheckBox linked;
    private JPanel pathP;
    private final TextFileController controller;

    public ImportTxtFilePanel(UIController uiController) {

        controller = new TextFileController(uiController);
        sheet = uiController.getActiveSpreadsheet();

        if (controller.checkSheetImportationLink(sheet)) {
            int option = JOptionPane.
                    showConfirmDialog(new JFrame(), "The current sheet is linked to the file " + controller.
                            getFileName() + ". Do you want to remove the link?", "Import TXT File",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

            if (option == 0) {
                if (controller.checkFile(sheet)) {
                    controller.removeImportationLink(sheet);
                    option = JOptionPane.
                            showConfirmDialog(new JFrame(), "No linked file. Do you want create a link?", "Export to TXT File",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE);
                    if (option == 1) {
                        dispose();
                    } else {
                        setTitle(DIALOG_TITLE);
                        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                        setResizable(false);
                        setLayout(new GridLayout(6, 1));

                        add(createSeparatorPanel());
                        add(createHeaderPanel());
                        add(createLinkedPanel());
                        add(createFilePanel());
                        add(createPathPanel());
                        add(createButtonsPanel());

                        pack();
                        setLocationRelativeTo(null);
                        setVisible(true);
                    }
                }
            } else {
                dispose();
            }
        } else {
            setTitle(DIALOG_TITLE);
            setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            setResizable(false);
            setLayout(new GridLayout(6, 1));

            add(createSeparatorPanel());
            add(createHeaderPanel());
            add(createLinkedPanel());
            add(createFilePanel());
            add(createPathPanel());
            add(createButtonsPanel());

            pack();
            setLocationRelativeTo(null);
            setVisible(true);
        }

    }

    private JPanel createSeparatorPanel() {
        JPanel separatorPanel = new JPanel();
        JLabel label = new JLabel("Separator");
        int largura = 5;
        sep = new JTextField(largura);
       // sep.setDocument();
        sep.setText(";");
        separatorPanel.add(label);
        separatorPanel.add(sep);

        return separatorPanel;
    }

    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        header = new JCheckBox("Header Line");
        headerPanel.add(header);

        return headerPanel;
    }

    private JPanel createLinkedPanel() {
        JPanel linkedPanel = new JPanel();
        linked = new JCheckBox("Linked");
        linkedPanel.add(linked);

        return linkedPanel;
    }

    private JPanel createFilePanel() {
        JPanel fileP = new JPanel();
        JButton chooseBt = new JButton("Choose path");
        chooseBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser chooser;
                chooser = new JFileChooser();
                chooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("TXT File", "txt");
                chooser.setFileFilter(fileFilter);
                int success = chooser.showOpenDialog(null);
                if (success == JFileChooser.APPROVE_OPTION) {
                    f = chooser.getSelectedFile();
                    path = f.getAbsolutePath();
                    pathField.setText(path);
                    pathP.setVisible(true);
                }
            }
        }
        );
        fileP.add(chooseBt);
        return fileP;
    }

    private JPanel createPathPanel() {
        pathP = new JPanel();
        pathField = new JTextField(30);
        pathField.setEditable(false);
        pathP.add(pathField);
        pathP.setVisible(false);
        return pathP;
    }

    private JPanel createButtonsPanel() {
        JPanel buttons = new JPanel();

        JButton importB = new JButton("IMPORT");

        importB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (f != null) {
                    if (sep.getText().length() == 1) {
                        separator = sep.getText();
                        headerLine = header.isSelected();
                        if (linked.isSelected()) {
                            if (!controller.
                                    importTxt(sheet, f, separator, headerLine, true)) {
                                JOptionPane.
                                        showMessageDialog(null, "File already linked", "Import TXT File",
                                                JOptionPane.ERROR_MESSAGE);
                                dispose();
                            } else {
                                JOptionPane.
                                        showMessageDialog(null, "File is Linked", "Import TXT File", JOptionPane.DEFAULT_OPTION);
                                dispose();
                            }
                        } 
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Please, insert the separator.",
                                "Import TXT File",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Please, choose a TXT file to import.",
                            "Import TXT File",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        );

        JButton cancel = new JButton("CANCEL");

        cancel.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                dispose();
            }
        }
        );

        buttons.add(importB);

        buttons.add(cancel);

        return buttons;

    }
}
