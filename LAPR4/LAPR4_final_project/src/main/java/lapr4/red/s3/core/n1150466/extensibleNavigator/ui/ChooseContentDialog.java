package lapr4.red.s3.core.n1150466.extensibleNavigator.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lapr4.red.s3.core.n1150466.extensibleNavigator.Navigator;

/**
 *
 * @author Sebastiao
 */
public class ChooseContentDialog extends JFrame {
    
    /**
     * The content list
     */
    private final List<String> content;
    
    /**
     * The list withs the checked variables
     */
    private final ArrayList<String> checked;
    
    /**
     * The parent navigator extension
     */
    private final Navigator ext;
    
    /**
     * Creates a new dialog to choose the content to include in the navigator
     * 
     * @param content the content from which the user will choose from
     * @param parent the parent navigator
     */
    public ChooseContentDialog(List<String> content,Navigator parent) {
        super("Content");
        this.content = content;
        this.checked = new ArrayList<>();
        this.ext = parent;
        setLayout(new BorderLayout());
//        setPreferredSize(new Dimension(1000, 1000));
        initComponents();
        pack();
        setVisible(true);
    }
    
    /**
     * Creates the panels and buttons
     */
    private void initComponents() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel checkPanel = new JPanel(new GridLayout(this.content.size(), 1));

        for (String string : content) {
            JCheckBox box = box(string);
            checkPanel.add(box);
//            checkPanel.add(new JLabel("ola"));
        }
        panel.add(new JLabel("Select content:\n"), BorderLayout.PAGE_START);
        panel.add(checkPanel);
        panel.add(buttonPanel(), BorderLayout.PAGE_END);
        
        add(panel);
    }
    /**
     * Builds the individual check boxes
     * @param string
     * @return the box
     */
    private JCheckBox box(String string) {
        JCheckBox box = new JCheckBox(string);
        box.setSelected(false);
        box.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    if (!checked.contains(string)) {
                        checked.add(string);
                    }
                }
                if (e.getStateChange() != 1) {
                    if (checked.contains(string)) {
                        checked.remove(string);
                    }
                }
            }
        });

        return box;
    }
    /**
     * Builds the buttons panel
     * @return the panel
     */
    private JPanel buttonPanel() {
        JPanel btnPanel = new JPanel();
        btnPanel.add(okButton());
        btnPanel.add(cancelButton());
        
        return btnPanel;
    }
    /**
     * Builds the OK button, which saves the content to the navigator
     * @return the button
     */
    private JButton okButton() {
        JButton button = new JButton("OK");
        
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ext.setContent(getChecked());
                dispose();
            }
        });
        
        return button;
    }
    /**
     * Builds the cancel button
     * @return the cancel button
     */
    private JButton cancelButton() {
        JButton button = new JButton("Cancel");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        return button;
    }
    /**
     * Returns the list of checked variables
     * @return 
     */
    public ArrayList<String> getChecked() {
        return checked;
    }
}
