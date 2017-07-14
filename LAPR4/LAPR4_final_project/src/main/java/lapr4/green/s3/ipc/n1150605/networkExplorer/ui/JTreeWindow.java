/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150605.networkExplorer.ui;

import csheets.CleanSheets;
import csheets.core.Workbook;
import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import lapr4.green.s3.ipc.n1150605.networkExplorer.CleanSheetsInstance;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class JTreeWindow extends JFrame {
    private CleanSheetsInstance c;
    private JTree tree;
    private Extension[] exts;
    private UIController uiC;
    
    /**
     * Creates new form JTreeWindow
     * @param c, cleanSheets application
     * @param exts, all existing extensions
     * @param uiC, the user interface
     */
    public JTreeWindow(CleanSheetsInstance c, Extension[] exts, UIController uiC) {
        this.c = c;
        this.exts = exts;
        this.uiC = uiC;
        
        initComponents();
        
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("JTree");
        pack();
        setLocationRelativeTo(null);
        setSize(500, 600);
        
    }

    private void initComponents() {
       DefaultMutableTreeNode top = new DefaultMutableTreeNode("JTree");
       createNodes(top);
       tree = new JTree(top);
       add(tree);
       add(new JScrollPane(tree));
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode cs = new DefaultMutableTreeNode("Cleansheets");
        top.add(cs);
        
        DefaultMutableTreeNode wb = new DefaultMutableTreeNode("Workbooks");
        cs.add(wb);
        
        // workbooks branch
        Workbook[] wbs = c.getWorkbooks(uiC.getCleanSheets());
        for (int i=0; i<wbs.length; i++) {
            DefaultMutableTreeNode wbb = new DefaultMutableTreeNode("Workbook"+i);
            wb.add(wbb);
            
            //worksheets branch
            for (int j=0; j<wbs[i].getSpreadsheetCount(); j++) {
                DefaultMutableTreeNode spreadSheet = new DefaultMutableTreeNode(wbs[i].getSpreadsheet(j).getTitle());
                wbb.add(spreadSheet);
            }
        }
        
        // extensions branch
        DefaultMutableTreeNode ex = new DefaultMutableTreeNode("Extensions");
        cs.add(ex);
        
        // loaded extensions branch
        DefaultMutableTreeNode loaded = new DefaultMutableTreeNode("Active Extensions");
        ex.add(loaded);
        for (Extension e : c.getLoadedExtensions()) {
            DefaultMutableTreeNode name = new DefaultMutableTreeNode(e.getName());
            loaded.add(name);
            DefaultMutableTreeNode description = new DefaultMutableTreeNode(e.getDescription());
            name.add(description);
            DefaultMutableTreeNode version = new DefaultMutableTreeNode("Version "+e.getVersion());
            name.add(version);
        }
        
        // unloaded extensions branch
        DefaultMutableTreeNode unloaded = new DefaultMutableTreeNode("Inactive Extensions");
        ex.add(unloaded);
        for (Extension e : exts) {
            int ret = 0;
            for (Extension ext : c.getLoadedExtensions()) {
                if (e.getName().equals(ext.getName()) && e.getVersion().equals(ext.getVersion())) {
                    ret = 1;
                }
            }
            
            if (ret == 0) {
                DefaultMutableTreeNode name = new DefaultMutableTreeNode(e.getName());
                unloaded.add(name);
                DefaultMutableTreeNode description = new DefaultMutableTreeNode(e.getDescription());
                name.add(description);
                DefaultMutableTreeNode version = new DefaultMutableTreeNode("Version "+e.getVersion());
                name.add(version);
            }
        }
    }
    
}
