/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150825.IntermediateWizard.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * Solely created to initializa the keyListener
 * 
 * @author João Coelho
 */
public class IntermediateWizardListener implements KeyListener{

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KEY TYPED: "+e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KEY RELEASED: "+e.getKeyChar());
    }
    
}
