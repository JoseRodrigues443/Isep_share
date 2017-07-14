/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.importExportLink.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Ana
 */
public class ExportFileLinkAction extends BaseAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    public ExportFileLinkAction(UIController uiController) {
        this.uiController = uiController;
    }

    protected String getName() {
        return "Export Text File";
    }

    protected void defineProperties() {
    }

    public void actionPerformed(ActionEvent event) {
        try {

            ExportTxtPanel i = new ExportTxtPanel(uiController);
        } catch (Exception ex) {
            System.out.println(ex.getCause());
        }

    }
}
