/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s3.core.n1150466.extensibleNavigator.ui;

import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lapr4.green.s2.core.n1150767.extensionNavigator.ExtensionNavigatorController;
import lapr4.green.s2.core.n1150767.extensionNavigator.ListEnabledDisabledExtensions;
import lapr4.red.s3.core.n1150466.extensibleNavigator.Navigator;

/**
 *
 * @author Sebastiao
 */
public class ExtensibleNavigatorController extends ExtensionNavigatorController {

    private UIController uictrl;

    public ExtensibleNavigatorController(UIController uiController) {
        super(uiController);
        this.uictrl = uiController;
    }

    @Override
    public Map<String, ArrayList<String>> getEnabledExtensions() {
        
        List<UIExtension> listDisabled = ListEnabledDisabledExtensions.getInstance().getListDisabled();

        Map<String, ArrayList<String>> map = new LinkedHashMap<>();
        Integer num = null;
        for (Extension extension : ExtensionManager.getInstance().getExtensions()) {
            if (uictrl.getExtensions() == null) {
                break;
            }
            for (int i = 0; i < uictrl.getExtensions().length; i++) {
                if (uictrl.getExtensions()[i].getExtension().getName().equals(extension.getName())) {
                    //if (uictrl.getExtensions()[i].getExtension().equals(extension)) {
                    num = i;
                }
            }
            if (num == null) {
                throw new IllegalArgumentException();
            }

            String extension_name = uictrl.getExtensions()[num].getExtension().getName();

           ArrayList<String> array = new ArrayList<String>();
            array.add("test");
            
//            UIExtension uiExtension = extension.getUIExtension(uictrl);
            /*if (extension instanceof Navigator) {
                array = ((Navigator) extension).content();
            }*/
            map.put(extension_name, array);
        }

        return map;
    }

    @Override
    public Map<String, ArrayList<String>> getDisabledExtensions() {

        Map<String, ArrayList<String>> map = new LinkedHashMap<>();
        Integer num = null;
        for (UIExtension extension : ListEnabledDisabledExtensions.getInstance().getListDisabled()) {
            if (uictrl.getExtensions() == null) {
                break;
            }
            for (int i = 0; i < uictrl.getExtensions().length; i++) {
                if (uictrl.getExtensions()[i].getExtension().getName().equals(extension.getExtension().getName())) {
                    //if (uictrl.getExtensions()[i].getExtension().equals(extension)) {
                    num = i;
                }
            }
            if (num == null) {
                throw new IllegalArgumentException();
            }

            String extension_name = uictrl.getExtensions()[num].getExtension().getName();

            ArrayList<String> array = new ArrayList<String>();
            if (extension instanceof Navigator) {
                array = ((Navigator) extension).getContent();
            }
            map.put(extension_name, array);
        }
        return map;
    }
}
