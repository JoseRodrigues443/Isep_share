/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150993.exportXML.ui;


import csheets.ui.ctrl.FocusOwnerAction;
import csheets.ui.ctrl.UIController;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import javax.swing.KeyStroke;

/**
 *
 * @author 1150993
 */
public class ExportXMLAction extends FocusOwnerAction {

    /**
     * The user interface controller
     */
    private UIController uiController;

     /**
     * Creates a new exportXML action
     *
     * @param uiController the user interface controller
     */
    public ExportXMLAction(UIController uiController) {
        this.uiController = uiController;
    }

    @Override
    protected String getName() {
        return "Export XML";
    }

    @Override
    protected void defineProperties() {
        putValue(MNEMONIC_KEY, KeyEvent.VK_X);
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ExportXMLUI exportUI=new ExportXMLUI(this.uiController);
        exportUI.chooseWhatToExport(this.focusOwner);
    }
    
}
