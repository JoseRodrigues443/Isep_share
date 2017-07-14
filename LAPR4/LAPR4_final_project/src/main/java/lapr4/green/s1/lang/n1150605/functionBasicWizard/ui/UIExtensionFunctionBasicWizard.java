/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150605.functionBasicWizard.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import javax.swing.JMenu;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class UIExtensionFunctionBasicWizard extends UIExtension {

    /**
     * The menu of the extension
     */
    private FunctionBasicWizardMenu menu;
    
    public UIExtensionFunctionBasicWizard(Extension extension, UIController uiController) {
        super(extension, uiController);
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns an instance of a class that implements JMenu. In this simple case
     * this class only supplies one menu option.
     *
     * @see FunctionBasicWizardCellMenu
     * @return a JMenu component
     */
    public JMenu getMenu() {
        if (menu == null) {
            menu = new FunctionBasicWizardMenu(uiController);
        }
        
        return menu;
    }
   }
