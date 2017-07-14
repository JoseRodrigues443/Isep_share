package lapr4.blue.s3.lang.n1150595.tablesAndFilters.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import lapr4.blue.s3.lang.n1150595.tablesAndFilters.TablesAndFilters;
import lapr4.blue.s3.lang.n1150595.tablesAndFilters.controller.TablesAndFiltersController;

/**
 * A side bar for the Tables and Filters extension
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
public class TablesAndFiltersSideBar extends JPanel {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * Controller for formatting cell ranges
     */
    private TablesAndFiltersController controller;

    private JButton btnChooseTable;

    private JList list;

    private DefaultListModel listModel;

    private TablesAndFilters actualTable;

    /**
     * Creates a new TablesAndFiltersSideBar
     *
     * @param uiController the user interface controller
     */
    public TablesAndFiltersSideBar(UIController uiController) {
        super();
        this.uiController = uiController;
        this.controller = TablesAndFiltersController.controller();
        this.controller.setSideBar(this);
        this.controller.updateFunctions();
        setName("Tables and Filters");
        setLayout(new GridLayout(4, 1));

        JPanel tablePanel = tablePanel();
        JPanel tablesPanel = tablesPanel();
        JPanel filterPanel = filterPanel();
        JPanel removeFiltersPanel = removeFiltersPanel();

        add(tablePanel);
        add(tablesPanel);
        add(filterPanel);
        add(removeFiltersPanel);
    }

    /**
     * Panel to create a new table
     *
     * @return new table panel
     */
    private JPanel tablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        TitledBorder title = BorderFactory.createTitledBorder("New table");
        panel.setBorder(title);
        JPanel chooseTable = chooseTablePanel();

        panel.add(chooseTable, BorderLayout.CENTER);

        return panel;
    }

    /**
     * Panel to create new table
     *
     * @return create new table panel
     */
    private JPanel chooseTablePanel() {
        JPanel panel = new JPanel();

        btnChooseTable = new JButton("Create new table");

        btnChooseTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checkTable = controller.validateSelectedCells();
                if (checkTable) {
                    boolean checkName;
                    String name;
                    do {
                        checkName = true;
                        name = JOptionPane.showInputDialog(null, "Which name would you like to give to the table?", "Table Name", JOptionPane.QUESTION_MESSAGE);
                        for (TablesAndFilters t : controller.tablesAndFilters()) {
                            if (t.name() != null) {
                                if (t.name().equals(name)) {
                                    checkName = false;
                                }
                            }
                        }
                    } while (checkName == false);
                    controller.updateContent(name, null);
                } else {
                    JOptionPane.showMessageDialog(null, "ERROR: Table not defined!");
                }
            }
        });

        panel.add(btnChooseTable);

        return panel;
    }

    /**
     * Panel with the list of tables
     *
     * @return list of tables panel
     */
    private JPanel tablesPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setPreferredSize(new Dimension(130, 336));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        TitledBorder title = BorderFactory.createTitledBorder("Tables");
        panel.setBorder(title);

        listModel = new DefaultListModel<>();
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane pane = new JScrollPane(list);
        pane.setPreferredSize(new Dimension(120, 240));
        pane.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        pane.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(pane);

        return panel;
    }

    /**
     * Panel to apply a new filter
     *
     * @return panel to apply filter
     */
    private JPanel filterPanel() {
        JPanel panel = new NewFilterJPanel(this.controller, this);
        TitledBorder title = BorderFactory.createTitledBorder("New Filter");
        panel.setBorder(title);

        return panel;
    }

    /**
     * Panel to remove a filter
     *
     * @return remove filter panel
     */
    private JPanel removeFiltersPanel() {
        JPanel panel = new RemoveFilterJPanel(this.controller, this);
        TitledBorder title = BorderFactory.createTitledBorder("Remove Filter");
        panel.setBorder(title);

        return panel;
    }

    /**
     * Returns the selected table name
     *
     * @return table name
     */
    public String getSelectedName() {
        return this.list.getSelectedValue().toString();
    }

    /**
     * Adds a table to the list of tables
     *
     * @param table the new table
     */
    public void addTable(TablesAndFilters table) {
        listModel.addElement(table.name());
    }

}
