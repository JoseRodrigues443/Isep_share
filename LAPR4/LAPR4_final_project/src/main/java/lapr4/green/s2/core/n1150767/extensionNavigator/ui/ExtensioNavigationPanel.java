/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150767.extensionNavigator.ui;

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
import lapr4.blue.s1.core.n1150662.navigationWindow.ui.NavigationController;
import lapr4.blue.s1.core.n1150662.navigationWindow.ui.NavigationPanel;
import lapr4.blue.s1.core.n1150662.navigationWindow.ui.NavigationWindow;
import lapr4.blue.s1.core.n1150662.navigationWindow.ui.NavigationWindowFormula;
import lapr4.blue.s1.core.n1150662.navigationWindow.ui.NavigationWindowValue;
import lapr4.green.s2.core.n1150767.extensionNavigator.ExtensionNavigatorController;

/**
 *
 * @author Catarina Sousa 1150767
 */
public class ExtensioNavigationPanel extends JPanel implements SelectionListener {
    
    private ExtensionNavigatorController ctrl;
    
    private JButton bDisabled = new JButton("Disabled Extensions");
    
    private JButton bEnabled = new JButton("Enabled Extensions");
    
    public ExtensioNavigationPanel(UIController UIcontroller) {
        //Configure Panel
        super(new BorderLayout());
        setName(NavigationWindowExtension.NAME);

        //Create controller
        ctrl = new ExtensionNavigatorController(UIcontroller);
        UIcontroller.addSelectionListener(this);
        
        add(panel());
        
        bDisabled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DisabledExtensionsPanel dialog = new DisabledExtensionsPanel(UIcontroller, new ExtensioNavigationPanel(UIcontroller) ,ctrl);
            }
        });
        
        bEnabled.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                EnabledExtensionsPanel dialog = new EnabledExtensionsPanel(UIcontroller, new ExtensioNavigationPanel(UIcontroller),ctrl);
            }
        });
        
        
    }
    
    @Override
    public void selectionChanged(SelectionEvent event) {
        
    }
    
    public JPanel panel(){
        bDisabled.setPreferredSize(new Dimension(6, 6));
        bDisabled.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        bDisabled.setAlignmentX(Component.CENTER_ALIGNMENT);
        bDisabled.setVisible(true);
        
        bEnabled.setPreferredSize(new Dimension(6, 6));
        bEnabled.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        bEnabled.setAlignmentX(Component.CENTER_ALIGNMENT);
        bEnabled.setVisible(true);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setPreferredSize(new Dimension(130, 336));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        panel.add(bDisabled);
        panel.add(bEnabled);
        return panel;
    }
}
