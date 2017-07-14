/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150993.ImportExportData.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JMenu;

/**
 *
 * @author 1150993
 */
public class ImportExportDatabaseExtension extends UIExtension {

    private ImportExportDatabaseMenu menu;

    /**
     *
     * @param extension
     * @param uiController
     */
    public ImportExportDatabaseExtension(Extension extension,
            UIController uiController) {
        super(extension, uiController);
    }

    @Override
    public JMenu getMenu() {
        if (menu == null) {
            menu = new ImportExportDatabaseMenu(uiController);
        }
        return menu;
    }
}
