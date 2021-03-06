/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150993.ImportExportData.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import lapr4.green.s3.ipc.n1150993.ImportExportData.ctrl.ImportExportDatabaseController;

/**
 *
 * @author cdsn_
 */
public class ExportDatabaseUI extends javax.swing.JFrame {
     private ImportExportDatabaseController controller;
    /**
     * Creates new form ImportDatabaseUI
     * @param controller
     */
    /**
     * Creates new form ExportDatabaseUI
     */
    public ExportDatabaseUI(ImportExportDatabaseController controller) {
        this.controller=controller;
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public ExportDatabaseUI(){
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exportBTN = new javax.swing.JButton();
        existingRadio = new javax.swing.JRadioButton();
        newRadio = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        nameTXT = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Export");

        exportBTN.setText("Export");
        exportBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportBTNActionPerformed(evt);
            }
        });

        existingRadio.setText("Existing table");
        existingRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existingRadioActionPerformed(evt);
            }
        });

        newRadio.setText("New table");

        jLabel3.setText("Name of table:");

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Select one option:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(exportBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(nameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(newRadio)
                        .addComponent(existingRadio)
                        .addComponent(jLabel4)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(existingRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportBTN)
                    .addComponent(jButton1))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportBTNActionPerformed
       JFrame frame = new JFrame("JOptionPane showMessageDialog exemple");
        int flag = 0;
        int op = -1;

        if (existingRadio.isSelected() && newRadio.isSelected() == false) {
            op = 0;
        } else if (existingRadio.isSelected() == false && newRadio.isSelected()) {
            op = 1;
        } else {
            JOptionPane.showMessageDialog(frame, "Select just one option!");
            flag++;
        }
        
        if(flag==0){
            if(op==0){
               
                if(this.controller.insertOnExistingTable(nameTXT.getText())){
                  JOptionPane.showMessageDialog(frame, "Success!");
                  dispose();
                }
                    
            }else  if(op==1){
                if(!nameTXT.getText().isEmpty()){
                    controller.exportTable(nameTXT.getText());
                    JOptionPane.showMessageDialog(frame, "Success!");
                    dispose();
                }
            }
        }
    }//GEN-LAST:event_exportBTNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void existingRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existingRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_existingRadioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExportDatabaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExportDatabaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExportDatabaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExportDatabaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExportDatabaseUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton existingRadio;
    private javax.swing.JButton exportBTN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nameTXT;
    private javax.swing.JRadioButton newRadio;
    // End of variables declaration//GEN-END:variables
}
