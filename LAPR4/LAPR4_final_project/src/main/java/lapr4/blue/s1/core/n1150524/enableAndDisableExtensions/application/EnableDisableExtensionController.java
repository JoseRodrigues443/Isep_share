/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150524.enableAndDisableExtensions.application;

import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JToolBar;
import lapr4.green.s2.core.n1150767.extensionNavigator.ExtensionNavigatorController;
import lapr4.green.s2.core.n1150767.extensionNavigator.ListEnabledDisabledExtensions;

/**
 *
 * @author Filipe
 * Catarina Sousa 1150767
 */
public class EnableDisableExtensionController{
    
    
    /**
     * The extension selected by the user to be enabled/disabled
     */
    Extension extension;
    /**
     * The extension name
     */
    String extName;
    /**
     * The project's ui controller
     */
    UIController uiCtrl;
    /**
     * The list of extensions loaded by the app
     */
    List<String> extNames;
    /**
     * Boolean that verifies if the extension is enabled or disabled
     */
    boolean enabled;
    
    /**
     * The base builder for this class
     * @param uiCtrl The project's ui controller
     */
    public EnableDisableExtensionController(UIController uiCtrl) {
        this.uiCtrl = uiCtrl;
    }

    /**
     * Method that gets the list of loaded extensions and places their names
     * on a list for the UI usage
     * @return 
     */
    public Iterable<String> getExtensions() {

        extNames = new ArrayList<>();

        for (Extension ext : ExtensionManager.getInstance().getExtensions()) {
            extNames.add(ext.getName());
        }
        return extNames;
    }

    /**
     * Method that sets the extName based on what the user selected.
     * This method also gets the extension which has the selected name
     * @param extName The name of the extension to select
     */
    public void setUIExtension(String extName) {
        this.extName = extName;
        this.extension = ExtensionManager.getInstance().getExtension(extName);
    }

    /**
     * Method that verifies the state of an extension and enables/disables it.
     * The method returns true if the state was changed and fals if the extension's 
     * state was already the same as the user tried to change it to.
     * @param option boolean that defines if the extension is gonna be enabled or disabled
     * @return true or false, depending on the success of the operation
     */
    public boolean changeExtensionState(boolean option) {
        Integer num = null;

        for (int i = 0; i < uiCtrl.getExtensions().length; i++) {
            if (uiCtrl.getExtensions()[i].getExtension().equals(extension)) {
                num = i;
                break;
            }
        }

        if (num == null) {
            return false;
        }
        /*
            For the use case core04.2 - Entension Navigator
        */
        ListEnabledDisabledExtensions.getInstance().addExtension(option,uiCtrl.getExtensions()[num]);

        if (uiCtrl.getExtensions()[num].getCellDecorator() != null) {
//            enabled = uiCtrl.getExtensions()[num].getEnabledProperty("celldecorator");
//            if (enabled == option) {
//                return false;
//            }
            uiCtrl.getExtensions()[num].getCellDecorator().setEnabled(option);
//            uiCtrl.getExtensions()[num].setEnabledProperty("celldecorator", option);
        }
        if (uiCtrl.getExtensions()[num].getTableDecorator() != null) {
            enabled = uiCtrl.getExtensions()[num].getEnabledProperty("tabledecorator");
            if (enabled == option) {
                return false;
            }
            uiCtrl.getExtensions()[num].getTableDecorator().setEnabled(option);
            uiCtrl.getExtensions()[num].setEnabledProperty("tabledecorator", option);
        }
        if (uiCtrl.getExtensions()[num].getToolBar() != null) {
            enabled = uiCtrl.getExtensions()[num].getEnabledProperty("toolbar");
            if (enabled == option) {
                return false;
            }
            JToolBar toolBar = uiCtrl.getExtensions()[num].getToolBar();
            if (!toolBar.isEnabled()) {
                toolBar.setVisible(option);
            }
            for (int j = 0; j < toolBar.getComponents().length; j++) {
                toolBar.getComponents()[j].setEnabled(option);
                toolBar.getComponents()[j].setVisible(option);
            }
            uiCtrl.getExtensions()[num].setEnabledProperty("toolbar", option);
        }
        if (uiCtrl.getExtensions()[num].getSideBar() != null) {
            enabled = uiCtrl.getExtensions()[num].getEnabledProperty("sidebar");
            if (enabled == option) {
                return false;
            }
            JComponent sidebar = this.uiCtrl.getExtensions()[num].getSideBar();
            for (int j = 0; j < sidebar.getComponents().length; j++) {
                sidebar.getComponents()[j].setEnabled(option);
                sidebar.getComponents()[j].setVisible(option);
            }
            uiCtrl.getExtensions()[num].getSideBar().setEnabled(option);
            uiCtrl.getExtensions()[num].getSideBar().setVisible(option);
            uiCtrl.getExtensions()[num].setEnabledProperty("sidebar", option);
        }
        if (uiCtrl.getExtensions()[num].getMenu() != null) {
            uiCtrl.getExtensions()[num].getMenu().setEnabled(option);
            uiCtrl.getExtensions()[num].getMenu().setVisible(option);
        }

        return true;
    }
}
