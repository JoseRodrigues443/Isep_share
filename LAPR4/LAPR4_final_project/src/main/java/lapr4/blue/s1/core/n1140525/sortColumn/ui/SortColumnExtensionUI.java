/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1140525.sortColumn.ui;

import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;
import javax.swing.JMenu;
import lapr4.blue.s1.core.n1140525.sortColumn.domain.SortCellsExtension;

/**
 *
 * @author MariaJoão
 */
public class SortColumnExtensionUI extends UIExtension{

    private SortColumnPanel menu;
    
    public SortColumnExtensionUI(SortCellsExtension ext, UIController uiController) {
        super(ext, uiController);
    }
    @Override
    public JComponent getSideBar(){
        if (menu == null) {
            menu = new SortColumnPanel(uiController);
        }
        return menu;
    }
}
