/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150595.emailAndPhoneEdition.domain.phoneNumbers.countryCode;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author 1150595
 */
public class ImportCountryCodesAction extends BaseAction {

    /**
     * The user interface controller
     */
    protected UIController uiController;

    /**
     * Creates a new import action
     *
     * @param uiController the user interface controller
     */
    public ImportCountryCodesAction(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Import Country Codes";
    }

    @Override
    protected void defineProperties() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImportCountryCodesUI ui = new ImportCountryCodesUI(uiController);
    }

}
