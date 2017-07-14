/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150767.extensionNavigator;

import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ui.ext.UIExtension;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Catarina Sousa 1150767
 */
public class ListEnabledDisabledExtensions {
    /**
     * List of the enabled extensions
     * It's filled in the class EnableDisableExtensionController and used in the ExtensionNavigatorController
     */
    private List<UIExtension> listEnabled= new ArrayList<UIExtension>();
    /**
     * List of disabled extnsions
     * It's filled in the class EnableDisableExtensionController and used in the ExtensionNavigatorController
     */
    private List<UIExtension> listDisabled= new ArrayList<UIExtension>();
    /**
     * Instance of the class
     */
    private static final ListEnabledDisabledExtensions instance = new ListEnabledDisabledExtensions();
    
    /**
     * Class's constructor
     */
    public ListEnabledDisabledExtensions() {
    }
    
    /**
     * In the controller EnableDisableExtensionController the method changeExtensionState
     * uses as a parameter a boolean (true->enable)(false->disable)
     * @param option (true->enable)(false->disable)
     * @param extension
     * @return 
     */
    public boolean addExtension(boolean option,UIExtension extension){
        if(option==true){
            addEnabledExtension(extension);
        }else{
            addDisabledExtension(extension);
        }
        return true;
    }
    
    /**
     * Method to add a disabled extension to the array listEnabled and removes
     * from the array listDisabled
     * It's mainly used in the controller EnableDisableExtensionController
     * @param extension 
     */
    public void addEnabledExtension(UIExtension extension){
//        if(this.listDisabled.contains(extension)){
//            this.listDisabled.remove(extension);
//        }
        for (UIExtension uiext : this.listDisabled) {
            if (uiext.getExtension().getName().equals(extension.getExtension().getName())) {
                this.listDisabled.remove(extension);
            }
        }
        this.listEnabled.add(extension);
    }
    
    /**
     * Method to add a disabled extension to the array listDisabled and removes
     * from the array listEnabled
     * It's mainly used in the controller EnableDisableExtensionController
     * @param extension 
     */
    public void addDisabledExtension(UIExtension extension){
//        if(this.listEnabled.contains(extension)){
//            this.listEnabled.remove(extension);
//        }
        for (UIExtension uiext : this.listEnabled) {
            if (uiext.getExtension().getName().equals(extension.getExtension().getName())) {
                this.listEnabled.remove(extension);
            }
        }
        this.listDisabled.add(extension);
    }
    
    /**
     * Returns the list of enabled extensions
     * @return 
     */
    public List<UIExtension> getListEnabled(){
        return listEnabled;
    }
    /**
     * Returns the list of enabled extensions
     * @return 
     */
    public List<UIExtension> getListDisabled(){
        return listDisabled;
    }
    
    /**
     * Returns class's instance
     * @return 
     */
    public static ListEnabledDisabledExtensions getInstance() {
        return instance;
    }
    
    
}
