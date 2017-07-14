/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.ImportExportLink.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Ana Pacheco (1130679)
 */
public class ImportFileLinkAction extends BaseAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

   
    public ImportFileLinkAction(UIController uiController) {
        this.uiController = uiController;
    }

    protected String getName() {
        return "Import Text File";
    }

    protected void defineProperties() {
    }

    
    public void actionPerformed(ActionEvent event) {
        try {

            ImportTxtFilePanel i = new ImportTxtFilePanel(uiController);
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }

    }

}
