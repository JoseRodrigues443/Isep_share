/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150767.multipleWorkbookSearch.ui;

import com.itextpdf.text.Font;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.Utils;
import lapr4.blue.s2.ipc.n1150595.advancedWorkbookSearch.application.AdvancedWorkbookSearchController;
import lapr4.green.s3.ipc.n1150767.multipleWorkbookSearch.ExtensionMultipleWorkbookSearch;
import lapr4.green.s3.ipc.n1150767.multipleWorkbookSearch.MultipleWorkbookSearchController;
import lapr4.red.s1.ipc.n1150466.findWorkbooks.FindWorkbooksExtension;
import lapr4.red.s1.ipc.n1150466.findWorkbooks.ui.FindWorkbooksSideBar;

/**
 *
 * @author Catarina Sousa
 */
public class MultipleWorkbookSearchUI extends javax.swing.JFrame {
    
    java.util.Timer timer = new java.util.Timer();
    /**
     * The controller for finding workbooks.
     */
    private AdvancedWorkbookSearchController controller;
    /**
     * The controller for multiple workbooks.
     */
    private MultipleWorkbookSearchController mwsctrl;

    /**
     * JList containing the found workbooks.
     */
    private JList fileJList;

    /**
     * The model for the JList.
     */
    private DefaultListModel fileListModel;

    /**
     * The button for choosing the directory, and therefore launching the seatch
     * for .cls files
     */
    private JButton btnChooseDir;

    /**
     * The text field where the user inserts the folder to start the search.
     */
    private JTextField txtDir;

    /**
     * The text field where the user inserts the pattern - Sprint 2
     */
    private JTextField txtPattern;

    /**
     * List object containing the actual files.
     */
    private List<File> fileList;
    /**
     * Button to set active search
     */
    private JButton btnActive;

    /**
     * Creates a new FindWorkbooksSidebar.
     *
     * @param uiController - the use case controller
     */
    MultipleWorkbookSearchUI(UIController uiController) {
        this.setLayout(new BorderLayout());
        setName(ExtensionMultipleWorkbookSearch.NAME);

        fileListModel = new DefaultListModel();

        controller = new AdvancedWorkbookSearchController(uiController);
        
        mwsctrl = new MultipleWorkbookSearchController(uiController);
        
        initComponents();
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Method to create the UI components.
     */
    private void initComponents() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel patternDirPanel = createPatternDirPanel();
        JScrollPane fileListPanel = createListPanel();
        JPanel activePanel = createActivePanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        // Adds borders
        TitledBorder border = BorderFactory.createTitledBorder("Workbooks");
        border.setTitleJustification(TitledBorder.CENTER);
        mainPanel.setBorder(border);

        // Adds panels
        add(patternDirPanel, BorderLayout.PAGE_START);
        mainPanel.add(fileListPanel, BorderLayout.CENTER);
        add(mainPanel);
        add(activePanel,BorderLayout.SOUTH);

    }

    /**
     * Method to create the scroll pane containing the file JList - Modificated
     * for Sprint 2 and 3
     *
     * @return the scroll pane
     */
    private JScrollPane createListPanel() {
        this.fileJList = new JList(this.fileListModel);
        fileJList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();

                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    File file = (File) fileListModel.get(index);
                    if (JOptionPane.showConfirmDialog(null, "Are you sure you want to load this file? "
                            + "Any unsaved changes will be lost!", "Confirm Load",
                            JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
                        controller.load(file);
                    }
                }

                if (evt.getClickCount() == 1 && list.getSelectedValue() != null) {
                        int index = list.locationToIndex(evt.getPoint());
                        File file = (File) fileListModel.get(index);
                    try {
//                        controller.preview(file);
                        mwsctrl.previewsFirst(file.getName());
                    } catch (IOException ex) {
                        Logger.getLogger(FindWorkbooksSideBar.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(FindWorkbooksSideBar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        this.fileJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane panel = new JScrollPane(fileJList);
        //panel.add(fileJList);

        return panel;
    }

    /**
     * Method that creates the JPanel to insert the directory and the pattern. -
     * Modificated for Sprint 2
     *
     * @return the panel
     */
    private JPanel createPatternDirPanel() {
        JLabel label = new JLabel();
        label.setText("Pattern: ");
        txtPattern = new JTextField();
        txtPattern.setColumns(10);
        txtPattern.setEditable(true);

        createBtnChooseDir();
        txtDir = new JTextField();
        txtDir.setColumns(20);
        txtDir.setEditable(false);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));

        panel.add(label);
        panel.add(txtPattern);
        panel.add(btnChooseDir);
        panel.add(txtDir);
        return panel;
    }
    
    /**
     * Method that creates the JPanel to insert the button to set active search. -
     * Modificated for Sprint 3
     *
     * @return the panel
     */
    private JPanel createActivePanel() {
        JTextField txtONOFF = new JTextField();
        txtONOFF.setColumns(10);
        txtONOFF.setEditable(false);
        txtONOFF.setText("OFF");
        txtONOFF.setSelectedTextColor(Color.red);
        btnActive = new JButton("Active Search");
        btnActive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mwsctrl.setActive();
                boolean verify = mwsctrl.getActive();
                if (verify==true) {
                    txtONOFF.setText("ON");
                    txtONOFF.setSelectedTextColor(Color.green);
                    newTimer(5);
                }else{
                    txtONOFF.setText("OFF");
                    txtONOFF.setSelectedTextColor(Color.red);
                    timer.cancel();
                }
            }
        });
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        panel.add(btnActive);
        panel.add(txtONOFF);
        return panel;
    }
    /**
     * Creates the timer
     * @param seconds
     * @return 
     */
    public boolean newTimer(int seconds) {
        /*amount of time to the run method be executed again*/
        int timeInterval = seconds * 1000;
        
        timer = new java.util.Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                
//                String name = Utils.fileChooser();

//                txtDir.setText(name);
//
//                if (!name.isEmpty()) {
//                    fileListModel.clear();
//                    controller.setPattern(txtPattern.getText());
//                    controller.setDirectory(name);
//                    try {
                        fileList = controller.search();

                        if (!fileList.isEmpty()) {
                            updateList();
                            updateList2();
                            mwsctrl.previewFileModified(fileList);
                            mwsctrl.fillsMaps(fileList);
                        } else {
                            JOptionPane.showMessageDialog(null, "No files found.",
                                    "Empty", JOptionPane.WARNING_MESSAGE);
                        }

//                    } catch (NullPointerException ex) {
//                        JOptionPane.showMessageDialog(null, "Please enter a valid directory!",
//                                "Not a valid directory", JOptionPane.WARNING_MESSAGE);
//                    }
//                } else {
//                    JOptionPane.showMessageDialog(null, "Please enter a directory!",
//                            "No directory inserted", JOptionPane.WARNING_MESSAGE);
//                }
//            
            }
        }, 0, timeInterval); 
        

        return true;
    }
    /**
    * Method that updates the JList
     */
    private void updateList() {
        for (File file : fileList) {
            if (!fileListModel.contains(file)) {
                fileListModel.addElement(file);
            }
        }
    }
    /**
     * Methos that updates the JList if a file has been removed
     */
    private void updateList2(){
        for (Object o: fileListModel.toArray()) {
            if (!fileList.contains((File)o)) {
                fileListModel.removeElement(o);
            }
        }
    }

    /**
     * Method that creates the button and implements the action listener.
     */
    private void createBtnChooseDir() {
        btnChooseDir = new JButton("Choose Directory");

        btnChooseDir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = Utils.fileChooser();

                txtDir.setText(name);

                if (!name.isEmpty()) {
                    fileListModel.clear();
                    controller.setPattern(txtPattern.getText());
                    controller.setDirectory(name);
                    try {
                        fileList = controller.search();
                        
                        if (!fileList.isEmpty()) {
                            updateList();
                            mwsctrl.fillsMaps(fileList);
                        } else {
                            JOptionPane.showMessageDialog(null, "No files found.",
                                    "Empty", JOptionPane.WARNING_MESSAGE);
                        }

                    } catch (NullPointerException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid directory!",
                                "Not a valid directory", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a directory!",
                            "No directory inserted", JOptionPane.WARNING_MESSAGE);
                }
            }

//            /**
//             * Method that updates the JList
//             */
//            private void updateList() {
//                for (File file : fileList) {
//                    if (!fileListModel.contains(file)) {
//                        fileListModel.addElement(file);
//                    }
//                }
//            }
        });
    }
}
