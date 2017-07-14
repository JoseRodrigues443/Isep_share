/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150767.macroWindow.ui;

import csheets.CleanSheets;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author Catarina Sousa 1150767
 */
public class MacroWindowUIExtension extends UIExtension {

    public MacroWindowUIExtension(Extension extension, UIController uiController) {
	super(extension, uiController);
	// TODO Auto-generated constructor stub
    }

	/**
	 * Returns an instance of a class that implements JMenu.
	 * In this simple case this class only supplies one menu option.
	 * @see ExampleMenu
	 * @return a JMenu component
	 */
	public JMenu getMenu() { 
            JMenu macrosMenu = new JMenu("Macros");
            macrosMenu.setMnemonic(KeyEvent.VK_M); 
            JMenuItem item = new JMenuItem("Window Macro");
            macrosMenu.add(item);
            ActionListener listener =new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    new MacroWindowUI(uiController.getActiveSpreadsheet(), uiController);
                }
            };
            item.addActionListener(listener);
            return macrosMenu;
	}
}
