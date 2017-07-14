/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150662.navigationWindow.ui;

import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import lapr4.blue.s1.core.n1150662.navigationWindow.NavigationWindowExtension;

/**
 *
 * @author bruno
 */
public class NavigationPanel extends JPanel implements SelectionListener {
    
    private NavigationController controller;
    
    private JButton bNavigate = new JButton("Navigate..");
    
    private JButton bValue = new JButton("Value Navigation");
    
    private JButton bFormula = new JButton("Formula Navigation");
    
    public NavigationPanel(UIController UIcontroller) {
        //Configure Panel
        super(new BorderLayout());
        setName(NavigationWindowExtension.NAME);

        //Create controller
        controller = new NavigationController(UIcontroller, this);
        UIcontroller.addSelectionListener(this);
        
        bNavigate.setPreferredSize(new Dimension(6, 6));
        bNavigate.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        bNavigate.setAlignmentX(Component.CENTER_ALIGNMENT);
        bNavigate.setVisible(true);
        
        bValue.setPreferredSize(new Dimension(6, 6));
        bValue.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        bValue.setAlignmentX(Component.CENTER_ALIGNMENT);
        bValue.setVisible(true);
        
        bFormula.setPreferredSize(new Dimension(6, 6));
        bFormula.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        bFormula.setAlignmentX(Component.CENTER_ALIGNMENT);
        bFormula.setVisible(true);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setPreferredSize(new Dimension(130, 336));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        panel.add(bNavigate);
        panel.add(bValue);
        panel.add(bFormula);
        
        add(panel);
        
        bNavigate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NavigationWindow dialog = new NavigationWindow(UIcontroller, new NavigationPanel(UIcontroller));
            }
        });
        
        bValue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NavigationWindowValue dialog = new NavigationWindowValue(UIcontroller, new NavigationPanel(UIcontroller));
            }
        });
        
        bFormula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                NavigationWindowFormula dialog = new NavigationWindowFormula(UIcontroller, new NavigationPanel(UIcontroller));
            }
        });
        
    }
    
    @Override
    public void selectionChanged(SelectionEvent event) {
        
    }
    
}
