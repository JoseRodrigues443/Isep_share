/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150825.workbookSearch.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lapr4.red.s3.core.n1150825.workbookSearch.app.ExtensionWorkbookSearch;
import lapr4.red.s3.core.n1150825.workbookSearch.controller.WorkbookSearchController;

/**
 *
 * @author João Coelho
 */
public class WorkbookSearchUI extends JPanel implements ActionListener {

    private UIController uiController;
    private WorkbookSearchController myController;
    private JList resultJList;
    private JTextField searchInput;
    private JButton btnExecuteSearch;
    private DefaultListModel resultListModel;

    /**
     *
     * @param uiController
     */
    public WorkbookSearchUI(UIController uiController) {
        super(new BorderLayout());
        this.uiController = uiController;
        setName(ExtensionWorkbookSearch.NAME);
        resultListModel = new DefaultListModel();
        this.myController = new WorkbookSearchController();
        createComponents();

    }

    /**
     *
     */
    public void createComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchInput = new JTextField();
        searchInput.setMinimumSize(new Dimension(200, 20));
        searchPanel.add(searchInput, BorderLayout.CENTER);
        createButtonExecuteSearch();
        searchPanel.add(btnExecuteSearch, BorderLayout.EAST);
        resultJList = new JList(resultListModel);
        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(resultJList, BorderLayout.CENTER);
        add(mainPanel);
    }

    private void createButtonExecuteSearch() {
        btnExecuteSearch = new JButton("Search");

        btnExecuteSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                updateSearchResult();
            }
        });
    }

    private void updateSearchResult() {
        if (!(searchInput.getText().isEmpty() || searchInput.getText().matches("[ ]+"))) {
            myController.searchSpreadsheet(uiController.getActiveSpreadsheet(), searchInput.getText());
            resultListModel.removeAllElements();
            if(myController.searchResults()!=null){
            for (String string : myController.searchResults()) {
                resultListModel.addElement(string);
            }
            }else{
                resultListModel.addElement("THERE IS NO SUCH ELEMENT IN THE CELLS");
            }
        } else {
            JOptionPane.showMessageDialog(null, "The input field is empty.");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
