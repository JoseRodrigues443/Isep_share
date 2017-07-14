/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1150662.navigationWindow;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.blue.s1.core.n1150662.navigationWindow.ui.UIExtensionNavigation;

/**
 *
 * @author bruno
 */
public class NavigationWindowExtension extends Extension {
  
     //The name of the extension
        public static final String NAME = "Navigation Window";
        
        
        public NavigationWindowExtension(){
            super(NAME, "Description of Navigation Window", "1.0");
        }
        
        public UIExtension getUIExtension(UIController controller){
            return new UIExtensionNavigation(this,controller);
        }
}
