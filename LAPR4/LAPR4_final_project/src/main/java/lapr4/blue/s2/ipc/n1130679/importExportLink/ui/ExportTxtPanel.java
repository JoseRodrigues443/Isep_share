/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.importExportLink.ui;

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
import lapr4.blue.s2.ipc.n1130679.ImportExportLink.TextFileController;

/**
 *
 * @author Ana
 */
public class ExportTxtPanel extends JDialog {

    private static final String DIALOG_TITLE = "Export to text file";
    private JTextField pathField;
    private final TextFileController controller;
    private final Spreadsheet sheet;
    private String dir;
    private String separator;
    private String headerText = "";
    private boolean headerLine;
    private JTextField sep;
    private JCheckBox header;
    private JCheckBox linked;
    private JPanel pathP;
    private File f;
    private JPanel headerPanel;
    private JTextField hed;
    private JPanel p;
    private JPanel aux;

    public ExportTxtPanel(UIController uiController) {

        controller = new TextFileController(uiController);
        sheet = uiController.getActiveSpreadsheet();
        aux = new JPanel();
        if (controller.checkSheetExportationLink(sheet)) {
            int option = JOptionPane.
                    showConfirmDialog(new JFrame(), "The current sheet is linked to the file " + controller.
                            getFileName() + ". Do you want to remove the link?", "Export to TXT File",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
            if (option == 0) {
                controller.removeExportationLink(sheet);
                option = JOptionPane.
                        showConfirmDialog(new JFrame(), "No linked file. Do you want create a link?", "Export to TXT File",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);;
                if (option == 1) {
                    this.dispose();
                } else {
                    setTitle(DIALOG_TITLE);
                    setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                    setResizable(false);
                    setLayout(new GridLayout(9, 1));

                    add(new JPanel());
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
            } else {
                dispose();
            }
        } else {

            setTitle(DIALOG_TITLE);
            setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
            setResizable(false);
            setLayout(new GridLayout(9, 1));

            add(new JPanel());
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
//        sep.setDocument(new JTextFieldLimit(1));

        sep.setText(";");
        separatorPanel.add(label);
        separatorPanel.add(sep);

        return separatorPanel;
    }

    private JPanel createHeaderPanel() {
        headerPanel = new JPanel();
        header = new JCheckBox("Header Line");
        headerPanel.add(header);

        header.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (header.isSelected()) {
                    add(createTextHeaderPanel(), 3);
                    pack();
                    add(aux, 8);
                    pack();
                } else {
                    remove(p);
                    pack();
                    remove(aux);
                    pack();
                }
            }
        });

        return headerPanel;
    }

    private JPanel createTextHeaderPanel() {
        JLabel label = new JLabel("Header");
        int largura = 24;
        hed = new JTextField(largura);
        p = new JPanel();
        p.add(label);
        p.add(hed);
        return p;
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
                int success = chooser.showSaveDialog(null);
                if (success == JFileChooser.APPROVE_OPTION) {
                    f = chooser.getSelectedFile();
                    dir = chooser.getSelectedFile().getAbsolutePath() + ".txt";
                    pathField.setText(dir);
                    pathP.setVisible(true);
                }
            }
        });
        fileP.add(chooseBt);
        return fileP;
    }

    private JPanel createPathPanel() {
        pathP = new JPanel();
        int largura = 30;
        pathField = new JTextField(largura);
        pathField.setEditable(false);
        pathP.add(pathField);
        pathP.setVisible(false);
        return pathP;

    }

    private JPanel createButtonsPanel() {

        JPanel buttons = new JPanel();

        JButton export = new JButton("EXPORT");

        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (dir != null) {
                    if (sep.getText().length() == 1) {
                        File f = new File(dir);
                        separator = sep.getText();
                        if (headerLine = header.isSelected()) {
                            headerText = hed.getText();
                            if (headerText.length() != 0) {
                                if (linked.isSelected()) {
                                    if (!controller.
                                            exportTxt(sheet, f, separator, headerLine, true, headerText)) {
                                        JOptionPane.
                                                showMessageDialog(null, "File already linked", "Export to TXT File",
                                                        JOptionPane.ERROR_MESSAGE);
                                        dispose();
                                    } else {
                                        JOptionPane.
                                                showMessageDialog(null, "File is linked", "Export to TXT File", JOptionPane.DEFAULT_OPTION);
                                        dispose();
                                    }
                                } else {
                                    try {
                                        controller.
                                                exportTxt(f, separator, headerLine, headerText);
                                        dispose();
                                    } catch (IllegalArgumentException e) {
                                        JOptionPane.
                                                showMessageDialog(rootPane, e.
                                                        getMessage(), "Export to TXT File", JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Please, insert the header.",
                                        "Export to TXT File",
                                        JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            if (linked.isSelected()) {
                                if (!controller.
                                        exportTxt(sheet, f, separator, headerLine, true, headerText)) {
                                    JOptionPane.
                                            showMessageDialog(null, "File already linked", "Export to TXT File",
                                                    JOptionPane.ERROR_MESSAGE);
                                    dispose();
                                } else {
                                    JOptionPane.
                                            showMessageDialog(null, "File is linked", "Export to TXT File", JOptionPane.DEFAULT_OPTION);
                                    dispose();
                                }
                            } else {
                                try {
                                    controller.
                                            exportTxt(f, separator, headerLine, headerText);
                                    dispose();
                                } catch (IllegalArgumentException e) {
                                    JOptionPane.
                                            showMessageDialog(rootPane, e.
                                                    getMessage(), "Export to TXT File", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Please, insert the separator.",
                                "Export to TXT File",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Please, choose a path.",
                            "Export to TXT File",
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
        buttons.add(export);
        buttons.add(cancel);

        return buttons;

    }
}
