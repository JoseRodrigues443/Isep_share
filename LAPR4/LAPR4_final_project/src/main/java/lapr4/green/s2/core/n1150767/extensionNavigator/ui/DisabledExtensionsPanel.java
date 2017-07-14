/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150767.extensionNavigator.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.tree.DefaultMutableTreeNode;
import lapr4.green.s2.core.n1150767.extensionNavigator.ExtensionNavigatorController;

/**
 *
 * @author Catarina Sousa
 */
public class DisabledExtensionsPanel extends JDialog{

    UIController uictrl;
    
    ExtensioNavigationPanel panel;
    
    ExtensionNavigatorController ctrl;
    
    private final Dimension dimTree = new Dimension(300, 400);
    
    public DisabledExtensionsPanel(UIController uictrl, ExtensioNavigationPanel panel, ExtensionNavigatorController ctrl) {
        this.ctrl = ctrl;
	this.setTitle("Disabled Extensions");
	this.setLayout(new BorderLayout());
	this.add(panelDisabled(), BorderLayout.CENTER);
	this.pack();
	this.setLocationRelativeTo(this);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setVisible(true);
    }
    
    
    
    /**
     * Creates the panel with the list of disabled extensions
     * @return 
     */
    public JScrollPane panelDisabled(){
        	JTree tree = new JTree(buildTreeDisabled());
//		tree.setPreferredSize(dimTree); edited by Sebastião Pinto - to enable scrolling
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
		JScrollPane scroll = new JScrollPane(tree);
		scroll.setPreferredSize(dimTree);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		return scroll;
        
    }
    /**
     * Creates a tree with the disabled extensions and it's properties 
     * @return 
     */
    private DefaultMutableTreeNode buildTreeDisabled(){
        	DefaultMutableTreeNode tree = new DefaultMutableTreeNode();
		Map<String, ArrayList<String>> data = ctrl.getDisabledExtensions();
		for (String extension : data.keySet()) {
			DefaultMutableTreeNode sheetNode = new DefaultMutableTreeNode(extension);
			for (String dto : data.get(extension)) {
				sheetNode.add(new DefaultMutableTreeNode(dto));
			}
			tree.add(sheetNode);
		}
		return tree;
    }
    
}
