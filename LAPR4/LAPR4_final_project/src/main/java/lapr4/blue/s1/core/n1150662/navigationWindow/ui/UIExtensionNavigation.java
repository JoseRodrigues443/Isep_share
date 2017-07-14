/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150662.navigationWindow.ui;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.CellDecorator;
import csheets.ui.ext.UIExtension;
import javax.swing.JComponent;

/**
 *
 * @author bruno
 */
public class UIExtensionNavigation extends UIExtension {
    
    //private Icon icon
    
    private CellDecorator decorator;
    
    private JComponent component;
    
    public UIExtensionNavigation(Extension extension,UIController controller){
        super(extension,controller);
    }
    
    public CellDecorator getCellDecorator(){
        if(decorator == null){
            decorator = new NavigationCellDecorator();
        }
        return decorator;
    }
    
    public JComponent getSideBar() {
		if (component == null)
			component = new NavigationPanel(uiController);
		return component;
	}
    
    
    
    
}
