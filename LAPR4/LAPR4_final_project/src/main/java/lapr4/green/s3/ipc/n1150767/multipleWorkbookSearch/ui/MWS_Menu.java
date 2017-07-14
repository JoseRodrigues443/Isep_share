/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150767.multipleWorkbookSearch.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 *
 * @author Catarina Sousa
 */
public class MWS_Menu extends JMenu{
    
    /**
     * Creates a new ImportExportMenu
     *
     * @param uiController the user interface controller
     */
    public MWS_Menu(UIController uiController) {
        super("Workbook Search");

        add(new MultipleWorkbookSearch_Action(uiController));
    }
    
}
