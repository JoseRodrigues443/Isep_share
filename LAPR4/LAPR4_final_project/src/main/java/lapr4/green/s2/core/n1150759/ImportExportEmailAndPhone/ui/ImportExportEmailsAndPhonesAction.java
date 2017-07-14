/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150759.ImportExportEmailAndPhone.ui;

import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.green.s2.core.n1150759.ImportExportEmailAndPhone.application.ImportEmailsAndPhonesController;
import lapr4.white.s1.core.n4567890.contacts.application.ContactController;

/**
 *
 * @author Jorge Campos <1150759@isep.ipp.pt>
 */
public class ImportExportEmailsAndPhonesAction extends FocusOwnerAction {
    /**
     * User interface controller
     */
    private final UIController uiController;
    
    /**
     * Creates a new ImportEmailsAndPhonesAction
     * 
     * @param uiController User interface controller
     */
    public ImportExportEmailsAndPhonesAction(UIController uiController) {
        this.uiController = uiController;
    }
    
    @Override
    protected String getName() {
        return "Import emails and phones";
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like "
                + "to import the selected cells?");
        if (dialogResult == JOptionPane.YES_OPTION) {
            ImportEmailsAndPhonesController ctrl = 
                    new ImportEmailsAndPhonesController(this.uiController, new
                    ContactController(this.uiController.getUserProperties()));
            try {
                ctrl.importData(this.focusOwner);
            } catch (DataConcurrencyException | DataIntegrityViolationException ex) {
                Logger.getLogger(ImportExportEmailsAndPhonesAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
