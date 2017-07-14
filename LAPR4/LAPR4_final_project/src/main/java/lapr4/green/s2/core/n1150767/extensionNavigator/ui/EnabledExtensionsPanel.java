/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150767.extensionNavigator.ui;

import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import lapr4.green.s1.lang.n1150767.macroWindow.MacroExtension;
import lapr4.green.s2.core.n1150767.extensionNavigator.ExtensionNavigatorController;

/**
 *
 * @author Catarina Sousa
 */
public class EnabledExtensionsPanel extends JDialog{

    UIController uictrl;
    
    ExtensioNavigationPanel panel;
    
    ExtensionNavigatorController ctrl;
    
    private final Dimension dimTree = new Dimension(300, 400);
    
    public EnabledExtensionsPanel(UIController uictrl, ExtensioNavigationPanel panel, ExtensionNavigatorController ctrl) {
        this.uictrl=uictrl;
        this.ctrl = ctrl;
	this.setTitle("Enabled Extensions");
	this.setLayout(new BorderLayout());
	this.add(panelEnabled(), BorderLayout.CENTER);
	this.pack();
	this.setLocationRelativeTo(this);
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setVisible(true);
    }
    
    
    
    /**
     * Creates the panel with the list of enabled extensions
     * @return 
     */
    public JScrollPane panelEnabled(){
        	JTree tree = new JTree(buildTreeEnabled());
		//tree.setPreferredSize(dimTree); edited by Sebastião Pinto - to enable scrolling
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
                tree.setCellRenderer(new CustomDefaultTreeCellRenderer());
                
                treeAction(tree);
                
		JScrollPane scroll = new JScrollPane(tree);
		scroll.setPreferredSize(dimTree);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		return scroll;
        
    }
    
    public void treeAction (JTree tree){
        tree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            JTree aux = (JTree)evt.getSource();
            if (evt.getClickCount() == 2) {
                tree.addTreeSelectionListener(new TreeSelectionListener() {
                @Override
                public void valueChanged(TreeSelectionEvent e) {
                    try{
                    DefaultMutableTreeNode selectedElement=(DefaultMutableTreeNode)tree.getSelectionPath().getLastPathComponent();
//                    ExtensionManager.getInstance().unload("Macro", "1.0");
//                    ExtensionManager.getInstance().load(MacroExtension.class);
//                    ctrl.runExtension((String)selectedElement);
//                    if (selectedElement.toString().toLowerCase().contains("macros")) {
//                       Extension ext = ExtensionManager.getInstance().load("Macros");
//                       ctrl.runExtension(ext.getName());
//                    }
//                    Extension ext = ctrl.runExtension((String)selectedElement.getUserObject());


//                    try {
//                        UIExtension uiext = ext.getUIExtension(uictrl);
//                        uiext.getExtension().getClass().newInstance();
////                new DisabledExtensionsPanel(uictrl,panel,ctrl);
//                    } catch (InstantiationException ex) {
//                        Logger.getLogger(EnabledExtensionsPanel.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (IllegalAccessException ex) {
//                        Logger.getLogger(EnabledExtensionsPanel.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    }catch(IllegalArgumentException ex){
                            
                    }
                }
                });
            }
        }
    });   
    }
    
    /**
     * Creates a tree with the enabled extensions and it's properties 
     * @return 
     */
    private DefaultMutableTreeNode buildTreeEnabled(){
        	DefaultMutableTreeNode tree = new DefaultMutableTreeNode();
		Map<String, ArrayList<String>> data = ctrl.getEnabledExtensions();
		for (String extension : data.keySet()) {
			DefaultMutableTreeNode sheetNode = new DefaultMutableTreeNode(extension);
			for (String dto : data.get(extension)) {
				sheetNode.add(new DefaultMutableTreeNode(dto));
			}
			tree.add(sheetNode);
		}
		return tree;
    }
    
    class CustomDefaultTreeCellRenderer extends DefaultTreeCellRenderer {
        /**
         * Disables the properties part
         * @param tree
         * @param value
         * @param sel
         * @param expanded
         * @param leaf
         * @param row
         * @param hasFocus
         * @return 
         */
        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            boolean enabled = false; // <-- here is your logic for enable/disable cell

//            sel = enabled;
//            hasFocus = enabled;

//            Component treeCellRendererComponent = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
//            treeCellRendererComponent.setEnabled(enabled);

            String name="";
            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
            name = (String)node.getUserObject();
            if(name!=null){
            Map<String, ArrayList<String>> data = ctrl.getEnabledExtensions();
		for (String extension : data.keySet()) {
                    for (String dto : data.get(extension)) {
                        //Sees if it's the name of propertie and not of a extension
			if(name.equals(dto)) {
                            this.setEnabled(enabled);
                        }
                    }
		}
            }
            return this;
        }
    }
    
}
