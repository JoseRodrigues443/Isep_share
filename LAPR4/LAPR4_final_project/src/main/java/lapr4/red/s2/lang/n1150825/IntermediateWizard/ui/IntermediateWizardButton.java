/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150825.IntermediateWizard.ui;

import csheets.ui.ctrl.UIController;
import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author João Coelho
 */
public class IntermediateWizardButton extends JButton {

    UIController uic;
    
    /**
     *
     * Defines the button to launch the User Interface
     * 
     * @param uiController
     */
    public IntermediateWizardButton(UIController uiController) {
        uic=uiController;
        setPreferredSize(new Dimension(80, 20));
        setText("Wizard");
        addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActionPerformed(evt);
            }
        });
    }

    private void jButtonActionPerformed(java.awt.event.ActionEvent evt) {
        IntermediateWizardUI ui=new IntermediateWizardUI(uic);
    }

}
