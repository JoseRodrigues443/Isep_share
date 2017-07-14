/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.ui;

import csheets.ui.ctrl.BaseAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;

/**
 * @author Filipe
 */
public class EnableAndDisableExtensionsAction extends BaseAction {

    protected UIController uiController;

    EnableAndDisableExtensionsAction(UIController uiCtrl) {
        this.uiController = uiCtrl;
    }

    @Override
    protected String getName() {
        return "Toggle Extensions";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new EnableDisableExtensionUI(uiController);
    }

}
