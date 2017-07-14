package lapr4.red.s1.ipc.n1150834.importExportTxt.ui;

import csheets.core.Cell;
import csheets.ui.ctrl.UIController;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * A user interface for exporting text files
 *
 * @author 1150834
 */
class ExportUI extends JFrame {

    /**
     * Controller for exporting files
     */
    private ExportController controller;
    /**
     * The user interface controller
     */
    private UIController uiController;
    /**
     * The output directory
     */
    private String directory;
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
     * The special character that will be used to separate columns
     */
    private char specialChar;
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
     * JTextField with the output file name
     */
    private JTextField fileName;
    /**
     * Combo Box with character options
     */
    private JComboBox<String> comboBox;
    /**
     * Special character options
     */
    private String[] charaters = {"|", ";", "#", "."};

    /**
     * Creates a new ExportUI
     *
     * @param uiController the user interface controller
     */
    public ExportUI(UIController uiController) {
        this.uiController = uiController;
        setTitle("Export text");
        
        setPreferredSize(new Dimension(350, 320));
        setLayout(new GridLayout(5, 1));
        
        JPanel fileChooser = fileChooserPanel();
        JPanel cellRange = cellRangePanel();
        JPanel charSelection = charSelectionPanel();
        JPanel rowBehavior = rowBehaviorPanel();
        JPanel exportBtn = exportBtnPanel();
        
        add(fileChooser);
        add(cellRange);
        add(charSelection);
        add(rowBehavior);
        add(exportBtn);
        
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    
    private JPanel fileChooserPanel() {
        JPanel panel = new JPanel();
        JButton btnChooser = new JButton("Choose file");
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        btnChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = chooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    directory = chooser.getSelectedFile().getPath();
                }
            }
        });
        
        JLabel nameLabel = new JLabel("File Name:");
        fileName = new JTextField(10);
        fileName.setToolTipText("Insert name of output file");
        
        panel.add(btnChooser);
        panel.add(nameLabel);
        panel.add(fileName);
        
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
    
    private JPanel charSelectionPanel() {
        JPanel panel = new JPanel();
        TitledBorder title = BorderFactory.createTitledBorder("Character Selection");
        panel.setBorder(title);
        comboBox = new JComboBox(charaters);
        
        panel.add(comboBox);
        
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
    
    private JPanel exportBtnPanel() {
        JPanel panel = new JPanel();
        JButton btnExport = new JButton("Export");
        
        btnExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (readyParameters()) {
                    controller = new ExportController(uiController);
                    
                    controller.exportInformation(directory, beginning, end, specialChar, behavior);
                    dispose();
                }
            }
            
        });
        panel.add(btnExport);
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
        try {
            String name = fileName.getText();
            if (name == null || directory == null) {
                throw new NullPointerException();
            }
            
            directory = directory + "\\" + name + ".txt";
            
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Indicate output file name and directory",
                    "Missing output file", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        
        try {
            int index = comboBox.getSelectedIndex();
            
            char temp = charaters[index].charAt(0);
            
            specialChar = temp;
            
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(this, "Indicate output file name", "No output file name",
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
