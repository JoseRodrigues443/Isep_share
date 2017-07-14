/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150662.navigationWindow.ui;

import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import lapr4.blue.s1.core.n1150662.navigationWindow.NavigationComment;


/**
 *
 * @author bruno
 */
public class NavigationWindow extends JDialog{
    
    private final NavigationController controller;
    private final Dimension dimTree = new Dimension(300, 400);
    
    public NavigationWindow(UIController uiController,NavigationPanel panel) {
		this.controller = new NavigationController(uiController,panel);
		this.setTitle("Navigation Window");
		this.setLayout(new BorderLayout());
		this.add(panel(), BorderLayout.CENTER);
		this.pack();
		this.setLocationRelativeTo(this);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
    
    public JScrollPane panel(){
        	JTree tree = new JTree(buildTree());
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
    
    private DefaultMutableTreeNode buildTree(){
        	DefaultMutableTreeNode tree = new DefaultMutableTreeNode();
		Map<String, ArrayList<NavigationComment>> data = controller.
			getCommentsFromCells();
		for (String sheet : data.keySet()) {
			DefaultMutableTreeNode sheetNode = new DefaultMutableTreeNode(sheet);
			for (NavigationComment dto : data.get(sheet)) {
				System.out.println(dto.getText());
				sheetNode.add(new DefaultMutableTreeNode(dto.getText()));
                                
			}
			tree.add(sheetNode);
		}
		return tree;
    }
} 
    
  
