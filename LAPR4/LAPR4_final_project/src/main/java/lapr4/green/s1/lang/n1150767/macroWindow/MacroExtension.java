/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150767.macroWindow;

import csheets.ext.Extension;
import lapr4.green.s1.lang.n1150767.macroWindow.ui.MacroWindowUIExtension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s1.lang.n1150767.macroWindow.ui.MacroWindowUIExtension;

/**
 *
 * @author Catarina Sousa 1150767
 */
public class MacroExtension extends Extension{
    /** The name of the extension */
	public static final String NAME = "Macros";
        
    public MacroExtension() {
        super(NAME, "Description of Macros", "1.0");
    }

    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new MacroWindowUIExtension( this, uiController);
    }
}
