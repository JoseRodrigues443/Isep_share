/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1140525.AdvancedWizard.ui;

import csheets.ui.ctrl.UIController;
import java.awt.Dimension;
import javax.swing.JButton;
import lapr4.red.s2.lang.n1150825.IntermediateWizard.ui.IntermediateWizardUI;

/**
 *
 * @author MariaJoão
 */
public class AdvancedWizardButton extends JButton{
        UIController uic;
    
    /**
     *
     * Defines the button to launch the User Interface
     * 
     * @param uiController
     */
    public AdvancedWizardButton(UIController uiController) {
     
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
        AdvancedWizardUI ui=new AdvancedWizardUI(uic);
    }

}
