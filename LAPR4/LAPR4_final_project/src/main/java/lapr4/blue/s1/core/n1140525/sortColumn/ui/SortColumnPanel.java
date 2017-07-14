package lapr4.blue.s1.core.n1140525.sortColumn.ui;

import csheets.ui.ctrl.SelectionEvent;
import csheets.ui.ctrl.SelectionListener;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import lapr4.blue.s1.core.n1140525.sortColumn.application.SortColumnController;
import lapr4.blue.s1.core.n1140525.sortColumn.domain.SortCellsExtension;
import lapr4.blue.s1.core.n1140525.sortColumn.ui.AscendingSortColumnAction;

/**
 *
 * @author MariaJoão
 */
public class SortColumnPanel extends JPanel implements SelectionListener{
 
    private SortColumnController controller;
    private JButton bAscending = new JButton("Sort Column Ascending Order");
    private JButton bDescending = new JButton("Sort Column Descending Order");


    SortColumnPanel(UIController uiController) {
        super();
        BorderLayout lay= new BorderLayout();
        lay.setHgap(1);
        lay.setVgap(1);
        setLayout(lay);
        setName(SortCellsExtension.NAME);
        
        
        bAscending.setPreferredSize(new Dimension(6, 3));
        bAscending.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        bAscending.setAlignmentX(Component.CENTER_ALIGNMENT);
        bAscending.setVisible(true);
        bAscending.setAction(new AscendingSortColumnAction(uiController));

        bDescending.setPreferredSize(new Dimension(6, 3));
        bDescending.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        bDescending.setAlignmentX(Component.CENTER_ALIGNMENT);
        bDescending.setVisible(true);
        bDescending.setAction(new DescendingSortColumnAction(uiController));  
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setPreferredSize(new Dimension(130, 336));
        panel.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));		// width, height
        panel.add(bAscending);
        panel.add(bDescending);
        this.add(panel);
        setVisible(true);
    }
    
    

    @Override
    public void selectionChanged(SelectionEvent event) {
    }


    
}

