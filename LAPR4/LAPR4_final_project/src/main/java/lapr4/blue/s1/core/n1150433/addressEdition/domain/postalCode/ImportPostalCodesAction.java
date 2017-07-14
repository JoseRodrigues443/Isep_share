/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150433.addressEdition.domain.postalCode;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 *
 * @author Débora Costa - 1150433
 */
public class ImportPostalCodesAction extends BaseAction {

    protected UIController uiController;

    public ImportPostalCodesAction(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Import Portuguese Postal Codes";
    }

    @Override
    protected void defineProperties() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImportPostalCodesUI importPostalCodeUI = new ImportPostalCodesUI(uiController);
    }

}
