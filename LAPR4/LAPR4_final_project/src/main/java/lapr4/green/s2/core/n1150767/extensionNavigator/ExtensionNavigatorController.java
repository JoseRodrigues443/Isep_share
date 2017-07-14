/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150767.extensionNavigator;

import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import lapr4.green.s2.core.n1150767.extensionNavigator.ui.ExtensionNavPanel;

/**
 *
 * @author Catarina Sousa 1150767
 */
public class ExtensionNavigatorController{
    
    /**
     * The project's ui controller
     */
    private UIController uictrl;
    
    /**
     * The class's constructor
     * @param uictrl 
     */
    public ExtensionNavigatorController(UIController uictrl) {
        this.uictrl = uictrl;
//        for (UIExtension extension : uictrl.getExtensions()) {
//            ListEnabledDisabledExtensions.getInstance().addEnabledExtension(extension);
//        }
    }
    
    
    /**
     * Method that shows the Extensions that are enabled and it's properties
     */
    public Map<String, ArrayList<String>> getEnabledExtensions(){
        /*
        ENABLED EXTENSIONS
        */
        Map<String, ArrayList<String>> map = new LinkedHashMap<>();
        Integer num = null;
            for (Extension extension : ExtensionManager.getInstance().getExtensions()) {
            if(uictrl.getExtensions() == null){
                break;
            }
            for (int i = 0; i < uictrl.getExtensions().length; i++) {
                if(uictrl.getExtensions()[i].getExtension().getName().equals(extension.getName())){
                    //if (uictrl.getExtensions()[i].getExtension().equals(extension)) {
                    num = i;
                }
            }
            if (num == null) {
                throw new IllegalArgumentException();
            }
            /*
            NOME DA EXTENSÃO
            
            System.out.println("Extension: " + uictrl.getExtensions()[num].getExtension().getName());
            
            */
            String s =uictrl.getExtensions()[num].getExtension().getName();
            
            ArrayList<String> array = new ArrayList<String>();
            if (uictrl.getExtensions()[num].getCellDecorator() != null) {
                /*
                CELL DECORATOR
                System.out.println("Cell Decorator");
                */
                array.add("Cell Decorator");
            }
            
            if (uictrl.getExtensions()[num].getTableDecorator() != null) {
                /*
                TABLE DECORATOR
                System.out.println("Table Decorator");
                */
                array.add("Table Decorator");
            }
            if (uictrl.getExtensions()[num].getToolBar() != null) {
                /*
                TOLLBAR
                System.out.println("Toolbar "+ uictrl.getExtensions()[num].getToolBar().getName());
                */
                array.add("Toolbar "+ uictrl.getExtensions()[num].getToolBar().getName());
            }
            if (uictrl.getExtensions()[num].getSideBar() != null) {
                /*
                SIDEBAR
                System.out.println("Sidebar "+ uictrl.getExtensions()[num].getSideBar().getName());
                */
                array.add("Sidebar "+ uictrl.getExtensions()[num].getSideBar().getName());
            }
            if (uictrl.getExtensions()[num].getMenu() != null) {
                /*
                MENU
                System.out.println("Menu "+ uictrl.getExtensions()[num].getMenu().getName());
                */
                array.add("Menu "+ uictrl.getExtensions()[num].getMenu().getName());
            }
            
            map.put(s, array);
        }
        
        return map;
    }
    /**
     * Method that shows the Extensions that are disabled and it's properties
     */
    public Map<String, ArrayList<String>> getDisabledExtensions(){
        /*
        DISABLED EXTENSIONS
        */
        //depois este fica igual ao de cima
        Map<String, ArrayList<String>> map = new LinkedHashMap<>();
        Integer num = null;
        for (UIExtension extension : ListEnabledDisabledExtensions.getInstance().getListDisabled()) {
            if(uictrl.getExtensions() == null){
                break;
            }
            for (int i = 0; i < uictrl.getExtensions().length; i++) {
                if(uictrl.getExtensions()[i].getExtension().getName().equals(extension.getExtension().getName())){
                    //if (uictrl.getExtensions()[i].getExtension().equals(extension)) {
                    num = i;
                }
            }
            if (num == null) {
                throw new IllegalArgumentException();
            }
            /*
            NOME DA EXTENSÃO
            
            System.out.println("Extension: " + uictrl.getExtensions()[num].getExtension().getName());
            
            */
            String s =uictrl.getExtensions()[num].getExtension().getName();
            
            ArrayList<String> array = new ArrayList<String>();
            if (uictrl.getExtensions()[num].getCellDecorator() != null) {
                /*
                CELL DECORATOR
                System.out.println("Cell Decorator");
                */
                array.add("Cell Decorator");
            }
            
            if (uictrl.getExtensions()[num].getTableDecorator() != null) {
                /*
                TABLE DECORATOR
                System.out.println("Table Decorator");
                */
                array.add("Table Decorator");
            }
            if (uictrl.getExtensions()[num].getToolBar() != null) {
                /*
                TOLLBAR
                System.out.println("Toolbar "+ uictrl.getExtensions()[num].getToolBar().getName());
                */
                array.add("Toolbar "+ uictrl.getExtensions()[num].getToolBar().getName());
            }
            if (uictrl.getExtensions()[num].getSideBar() != null) {
                /*
                SIDEBAR
                System.out.println("Sidebar "+ uictrl.getExtensions()[num].getSideBar().getName());
                */
                array.add("Sidebar "+ uictrl.getExtensions()[num].getSideBar().getName());
            }
            if (uictrl.getExtensions()[num].getMenu() != null) {
                /*
                MENU
                System.out.println("Menu "+ uictrl.getExtensions()[num].getMenu().getName());
                */
                array.add("Menu "+ uictrl.getExtensions()[num].getMenu().getName());
            }
            
            map.put(s, array);
        }
        return map;
    }
    /**
     * Method that runs the clicked extension from the list of enabled extensions
     * @param extension the string returned by double clicking in the extension
     * from the list of enabled extensions
     * @return the uiextension that corresponds to the extension clicked
     */
    public Extension runExtension(String extension){
        Integer num=null;
        for (int i = 0; i < uictrl.getExtensions().length; i++) {
                if (uictrl.getExtensions()[i].getExtension().getName().equals(extension)) {
                    num = i;
                }
        }
        if (num == null) {
            throw new IllegalArgumentException();
        }
        /**
         * Verifys if the extension is disabled and if so it doesn't run
         */
        for (UIExtension uiext : ListEnabledDisabledExtensions.getInstance().getListDisabled()) {
            if (uiext.getExtension().getName().equals(extension)) {
                JOptionPane.showMessageDialog(null,"Extension Disabled");
            }
        }
        
        return uictrl.getExtensions()[num].getExtension();
        
//        return ExtensionManager.getInstance().load(uictrl.getExtensions()[num].getExtension().getClass());
//        return uictrl.getExtensions()[num].getExtension().getUIExtension(uictrl);
        
    }
}
