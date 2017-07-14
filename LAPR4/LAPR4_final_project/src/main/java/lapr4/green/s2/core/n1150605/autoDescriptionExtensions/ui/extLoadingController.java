/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150605.autoDescriptionExtensions.ui;

import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ui.ctrl.UIController;
import java.util.ArrayList;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class extLoadingController {
    
    /**
     * The singleton instance.
     */
    private ExtensionManager em;
    
    /**
     * The user interface controller.
     */
    private UIController uiC;
    
    /**
     * Constructor.
     * @param uiC, the user interface controller
     */
    public extLoadingController(UIController uiC) {
        this.uiC = uiC;
        getEM();
    }
    
    /**
     * Gets the singleton instance of ExtensionManager.
     */
    public void getEM() {
        this.em = ExtensionManager.getInstance();
    }
    
    /**
     * Returns all loaded extensions.
     * @return loaded extensions
     */
    public Extension[] getExtensions() {
        return em.getExtensions();
    }
    
    /**
     * Unloads an extension, given her name and version.
     * @param name, the name of the extension
     * @param version, the version of the extension
     * @param index, the index of the extension
     */
    public void unloadExtension(String name, String version, int index) {
       
        if (uiC.getExtensions()[index].getMenu() != null) {
            uiC.getExtensions()[index].getMenu().setEnabled(false);
            uiC.getExtensions()[index].getMenu().setVisible(false);
        }
        
        em.unload(name, version); 
    }
    
    /**
     * Loads an extension, given her class name.
     * @param s, the class name of the extension
     * @param index, the index of the extension
     */
    public void loadExtension(String s, int index) {     
        Extension e = em.load(s);
        
        if (uiC.getExtensions()[index].getMenu() != null) {
            uiC.getExtensions()[index].getMenu().setEnabled(true);
            uiC.getExtensions()[index].getMenu().setVisible(true);
        }
    }
    
    /**
     * Returns the name of an extension.
     * @param e, the given extension.
     * @return the name of the the extension
     */
    public String getExtensionName(Extension e) {
        return e.getName();
    }
    
    /**
     * Returns the description of an extension.
     * @param e, the given extension.
     * @return the description of the extension
     */
    public String getExtensionDescription(Extension e) {
       return e.getDescription();
    }
    
    /**
     * Returns the versions of an extension.
     * @param extName, the name of the given extension.
     * @return all versions of a given extension
     */
    public ArrayList<Extension> getExtensionVersions(String extName) {
        return em.getExtensionVersions(extName);
    }
    
}
