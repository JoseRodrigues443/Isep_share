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
import java.util.ArrayList;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import lapr4.blue.s1.core.n1150662.navigationWindow.NavigationComment;
import lapr4.blue.s1.core.n1150662.navigationWindow.NavigationWindowExtension;
import lapr4.blue.s1.core.n1150662.navigationWindow.ui.NavigationPanel;
import lapr4.blue.s1.core.n1150662.navigationWindow.ui.NavigationWindow;
import lapr4.blue.s1.core.n1150662.navigationWindow.ui.NavigationWindowFormula;
import lapr4.blue.s1.core.n1150662.navigationWindow.ui.NavigationWindowValue;
import lapr4.green.s2.core.n1150767.extensionNavigator.ExtensionNavigatorController;

/**
 *
 * @author Catarina Sousa 1150767
 */
public class ExtensionNavPanel extends JPanel implements SelectionListener{
    /**
     * The ui's controller
     */
    private ExtensionNavigatorController controller;
    /**
     * The tree dimensions
     */
    private final Dimension dimTree = new Dimension(300, 400);
    /**
     * 
     * @param UIcontroller 
     */
    public ExtensionNavPanel(UIController UIcontroller) {
        //Configure Panel
        super(new BorderLayout());
        setName(NavigationWindowExtension.NAME);

        //Create controller
        controller = new ExtensionNavigatorController(UIcontroller);
        UIcontroller.addSelectionListener(this);
        this.add(new JLabel("Enabled Extensions"));
        this.add(panelEnabled());
        this.add(new JLabel("Disabled Extensions"));
        this.add(panelDisabled());
    }
    /**
     * 
     * @param event 
     */
    @Override
    public void selectionChanged(SelectionEvent event) {
    }
    
    /**
     * Creates the panel with the list of disabled extensions
     * @return 
     */
    public JScrollPane panelDisabled(){
        	JTree tree = new JTree(buildTreeDisabled());
		tree.setPreferredSize(dimTree);
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
		Map<String, ArrayList<String>> data = controller.getDisabledExtensions();
		for (String extension : data.keySet()) {
			DefaultMutableTreeNode sheetNode = new DefaultMutableTreeNode(extension);
			for (String dto : data.get(extension)) {
				System.out.println(dto);
				sheetNode.add(new DefaultMutableTreeNode(dto));
			}
			tree.add(sheetNode);
		}
		return tree;
    }
    /**
     * Creates the panel with the list of enabled extensions
     * @return 
     */
    public JScrollPane panelEnabled(){
        	JTree tree = new JTree(buildTreeEnabled());
		tree.setPreferredSize(dimTree);
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
     * Creates a tree with the enabled extensions and it's properties
     * @return 
     */
    private DefaultMutableTreeNode buildTreeEnabled(){
        	DefaultMutableTreeNode tree = new DefaultMutableTreeNode();
		Map<String, ArrayList<String>> data = controller.getEnabledExtensions();
		for (String extension : data.keySet()) {
			DefaultMutableTreeNode sheetNode = new DefaultMutableTreeNode(extension);
			for (String dto : data.get(extension)) {
				System.out.println(dto);
				sheetNode.add(new DefaultMutableTreeNode(dto));
			}
			tree.add(sheetNode);
		}
		return tree;
    }
}
