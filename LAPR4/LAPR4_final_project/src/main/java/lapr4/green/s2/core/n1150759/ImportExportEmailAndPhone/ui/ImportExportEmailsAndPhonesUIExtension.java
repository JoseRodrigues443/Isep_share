/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150759.ImportExportEmailAndPhone.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JMenu;

/**
 *
 * @author Jorge Campos <1150759@isep.ipp.pt>
 */
public class ImportExportEmailsAndPhonesUIExtension extends UIExtension {
    private ImportExportEmailsAndPhonesMenu menu;
    /**
     *
     * @param extension
     * @param uiController
     */
    public ImportExportEmailsAndPhonesUIExtension(Extension extension, 
            UIController uiController) {
        super(extension, uiController);
    }
    
    @Override
    public JMenu getMenu() {
        if (menu == null) 
            menu = new ImportExportEmailsAndPhonesMenu(uiController);
        
        return menu;
    }
}
