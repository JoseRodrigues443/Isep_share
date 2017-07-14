package lapr4.red.s1.ipc.n1150834.importExportTxt.ui;

import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * A user interface for importing text files
 *
 * @author 1150834
 */
public class ImportUI extends JFrame {

    /**
     * Controller for importing files
     */
    private ImportController controller;
    /**
     * The user interface controller
     */
    private UIController uiController;
    /**
     * The input file
     */
    private String file;
    /**
     * Cell on one end of the range
     */
    private Cell beginning;
    /**
     * Cell on the other end of the range
     */
    private Cell end;
    /**
     * Export row behavior
     */
    private boolean behavior;
    /**
     * JTextField with the information for the first cell
     */
    private JTextField firstCellName;
    /**
     * JTextField with the information for the final cell
     */
    private JTextField finalCellName;
    /**
     * Buttons with the options for the first line behavior
     */
    private ButtonGroup options;
    /**
     * Button that says that first line is column header
     */
    private JRadioButton btnYes;
    /**
     * Button that says that first line is regular row
     */
    private JRadioButton btnNo;

    /**
     * Creates a new ImportUI
     *
     * @param uiController the user interface controller
     */
    public ImportUI(UIController uiController) {
        this.uiController = uiController;
        setTitle("Import text");

        setPreferredSize(new Dimension(320, 240));
        setLayout(new GridLayout(4, 1));

        JPanel fileChooser = fileChooserPanel();
        JPanel cellRange = cellRangePanel();
        JPanel rowBehavior = rowBehaviorPanel();
        JPanel importBtn = importBtnPanel();

        add(fileChooser);
        add(cellRange);
        add(rowBehavior);
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
                    file = chooser.getSelectedFile().getPath();
                }
            }
        });
        panel.add(btnChooser);
        return panel;
    }

    private JPanel cellRangePanel() {
        JPanel panel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder("Cell Range");
        panel.setBorder(title);

        JLabel beginLabel = new JLabel("First Cell:");
        JLabel endLabel = new JLabel("Last Cell:");
        firstCellName = new JTextField(5);
        firstCellName.setToolTipText("Insert row-column of the cell");
        finalCellName = new JTextField(5);
        finalCellName.setToolTipText("Insert row-column of the cell");

        panel.add(beginLabel);
        panel.add(firstCellName);
        panel.add(endLabel);
        panel.add(finalCellName);

        return panel;
    }

    private JPanel rowBehaviorPanel() {
        JPanel panel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder("First line of file is");
        panel.setBorder(title);

        options = new ButtonGroup();
        btnYes = new JRadioButton("Column Header");
        btnNo = new JRadioButton("Regular Row");
        options.add(btnYes);
        options.add(btnNo);

        panel.add(btnYes);
        panel.add(btnNo);

        return panel;
    }

    private JPanel importBtnPanel() {
        JPanel panel = new JPanel();
        JButton btnImport = new JButton("Import");

        btnImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (readyParameters()) {
                    try {
                        controller = new ImportController(uiController);

                        controller.importInformationTxt(file, beginning, end, behavior);
                        dispose();
                    } catch (FormulaCompilationException ex) {
                        Logger.getLogger(ImportUI.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, "Select an input file",
                                "No input file selected", JOptionPane.WARNING_MESSAGE);

                    }
                }
            }

        });
        panel.add(btnImport);
        return panel;
    }

    private boolean readyParameters() {
        try {
            ButtonModel model = options.getSelection();

            if (model.equals(btnYes.getModel())) {
                behavior = true;
            }
            if (model.equals(btnNo.getModel())) {
                behavior = false;
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Choose an option for the first line "
                    + "of the file", "No option selected", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            String firstCell = firstCellName.getText();
            String finalCell = finalCellName.getText();

            beginning = getCellFromRange(firstCell);

            end = getCellFromRange(finalCell);

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Indicate cell range", "No cell range given",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private Cell getCellFromRange(String range) {
        String[] split = range.trim().split("-");
        int row = Integer.parseInt(split[0]) - 1;
        int column = Integer.parseInt(split[1]) - 1;

        return uiController.getActiveSpreadsheet().getCell(column, row);
    }

}
