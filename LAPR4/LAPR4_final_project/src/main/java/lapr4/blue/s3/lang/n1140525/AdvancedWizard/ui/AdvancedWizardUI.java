/* * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1140525.AdvancedWizard.ui;

import lapr4.red.s2.lang.n1150825.IntermediateWizard.ui.*;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.Language;
import csheets.ui.ctrl.UIController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.tree.DefaultMutableTreeNode;
import lapr4.blue.s3.lang.n1140525.AdvancedWizard.controller.AdvancedWizardController;
import org.antlr.runtime.tree.CommonTree;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class AdvancedWizardUI extends javax.swing.JFrame {

    private UIController uiC;
    private AdvancedWizardController controller;
    private int mousePosition;
    private Language lang;
    private String formula;
    private Function activeFunction;
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    private boolean flagCanAddToFunction;
    Function[] functionsCombo;
    private int funcionCount;
    private ArrayList<Function> funcionsUsed;
    private ArrayList<FunctionParameter> parametersUsed;
    private ArrayList<String> parametersUsedString;
    private int parameterCountReplaced=0;
    //keeps the number of parameters from the selected function
    //and it's also used to know if all the parameters have been inputted
    private int parameters=0;
    //these three variables bellow are responsible for keeping notion if a parameter
    //has been passed through the parameter boxes
    private int parameter1=0;
    private int parameter2=0;
    private int parameter3=0;
    
    /**
     * Creates new form FunctionBasicWizardUI
     * @param uiC
     */
    public AdvancedWizardUI(UIController uiC) {

        this.uiC = uiC;
        this.controller = new AdvancedWizardController(this, uiC);
        this.lang= Language.getInstance();

        initComponents();
        this.funcionsUsed= new ArrayList<>();
        this.parametersUsedString= new ArrayList<>();
        this.parametersUsed= new ArrayList<>();
        
        jPanel2.setLayout(new BorderLayout());
        jPanel2.setVisible(false);
        this.jPanel2.validate();
        
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.validate();
        funcionCount=0;
        updateComboBox();
        
        txtCaretListener();
        txtDocListener();

        setVisible(true);

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonApply = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldFormula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonSelect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescription = new javax.swing.JTextArea();
        jTextFieldValue = new javax.swing.JTextField();
        jButtonValueAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldOperation = new javax.swing.JTextField();
        jButtonAddOpp = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldSintax = new javax.swing.JTextField();
        jButtonAddFunc = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaResult = new javax.swing.JTextArea();
        jButtonGenerate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonApply.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonApply.setText("Apply");
        jButtonApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApplyActionPerformed(evt);
            }
        });

        jButtonCancel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Advanced Wizard");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Function:");

        jComboBox1.setAutoscrolls(true);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Formula:");

        jTextFieldFormula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFormulaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Description:");

        jButtonSelect.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonSelect.setText("Select");
        jButtonSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectActionPerformed(evt);
            }
        });

        jTextAreaDescription.setEditable(false);
        jTextAreaDescription.setColumns(20);
        jTextAreaDescription.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescription);

        jTextFieldValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValueActionPerformed(evt);
            }
        });

        jButtonValueAdd.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonValueAdd.setText("Add");
        jButtonValueAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonValueAddActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel5.setText("Select a parameter from function above and insert the value you would like to relplace it with by clicking add");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel6.setText("Select a function you would like to add to the formula. It can be inserted in a parameter or empty space");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Operation:");

        jTextFieldOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOperationActionPerformed(evt);
            }
        });

        jButtonAddOpp.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAddOpp.setText("Add");
        jButtonAddOpp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddOppActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel8.setText("Insert a operation between two functions. The operation will be inserted where mouse is placed");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Result:");

        jButtonAddFunc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonAddFunc.setText("Add Funcion to Formula");
        jButtonAddFunc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddFuncActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Value:");

        jTextAreaResult.setColumns(20);
        jTextAreaResult.setRows(5);
        jScrollPane2.setViewportView(jTextAreaResult);

        jButtonGenerate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonGenerate.setText("Generate Tree");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 153, 255)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 187, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButtonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jButtonAddFunc)
                                            .addComponent(jLabel5)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jButtonApply, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(271, 271, 271)
                                                    .addComponent(jButtonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jTextFieldOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonAddOpp, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jTextFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(186, 186, 186)
                                                        .addComponent(jButtonValueAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jTextFieldFormula, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(49, 49, 49)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonGenerate)
                                .addGap(42, 42, 42))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSintax, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldSintax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel4)))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jButtonValueAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAddFunc)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldOperation, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jButtonAddOpp))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFormula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonApply)
                            .addComponent(jButtonCancel))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButtonGenerate)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApplyActionPerformed
         int i = jComboBox1.getSelectedIndex();
//        if (i > 0) {
            String formula = jTextFieldFormula.getText();
            try {
                uiC.getActiveCell().setContent(formula);

            } catch (FormulaCompilationException ex) {
                //Logger.getLogger(InsertFunctionIntermediateWizard.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
           }
            dispose();

//        } else {
//            JOptionPane.showMessageDialog(null, "You have to select a function in order to apply one.", "Warning", JOptionPane.WARNING_MESSAGE);
//        }
    }//GEN-LAST:event_jButtonApplyActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonValueAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonValueAddActionPerformed
        String valueS= jTextFieldValue.getText();
        String selected=jTextFieldSintax.getSelectedText();
        FunctionParameter fp = null;
        boolean flag=false;


            for (FunctionParameter functionParameter : activeFunction.getParameters()) {
                fp=functionParameter;
                if(controller.checkIsParameter(selected, jTextFieldSintax.getText())){
                    flag=true;
                }
            }
            
            //if user selects something that isnt a parameter
            if(flag==false){
            
                JOptionPane.showMessageDialog(rootPane, "Please select only one of the parameters in its totality.","Error Invalid Selection", JOptionPane.ERROR_MESSAGE);
                
            //if user doesnt insert number or operation
            }else if(!controller.validateIsOperation(valueS, fp)){
                
                JOptionPane.showMessageDialog(rootPane, "Please insert the type of operation in selected parameter: "+fp.getValueType(),"Error Invalid Parameter", JOptionPane.ERROR_MESSAGE);
            
            }else if(flag==true){
                this.jTextFieldSintax.setEditable(true);                
                jTextFieldSintax.replaceSelection(valueS);
                this.jTextFieldSintax.setEditable(false);

                                                
                //adds to the count of replaced parameters
                parameterCountReplaced--;
                if(parameterCountReplaced==0){
                    flagCanAddToFunction=true;
                }else{
                    //here goes result code
                }
                
                
                
            }
                
            
            
        
    }//GEN-LAST:event_jButtonValueAddActionPerformed

    private void jTextFieldValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValueActionPerformed

    private void jTextFieldFormulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFormulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFormulaActionPerformed

    private void jButtonSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectActionPerformed
        int i = jComboBox1.getSelectedIndex();
        if (i >= 0) {
            formula = new String();
            this.controller.selectFormula(i);
            activeFunction=controller.getFuncByPos(i);
            parameterCountReplaced=activeFunction.getParameters().length;
            flagCanAddToFunction=false;
            this.jTextFieldSintax.setEditable(false);
            selectFunction();
        }
    }//GEN-LAST:event_jButtonSelectActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextFieldOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOperationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOperationActionPerformed

    private void jButtonAddOppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddOppActionPerformed
        String opp= jTextFieldOperation.getText();
        
        if(!controller.checkIsOpp(opp)){
            JOptionPane.showMessageDialog(rootPane, "Please insert an opperation (+ * / -)","Error Invalid Opperation", JOptionPane.ERROR_MESSAGE);    
        }else{
   
        if (mousePosition != 0) {
                String formula2= jTextFieldFormula.getText();

                //JOptionPane.showMessageDialog(rootPane, s1);
                
                //checks if isercion is valid
                if(!controller.checkValidPositionOpp(formula2,mousePosition )){
                    
                  JOptionPane.showMessageDialog(rootPane, "Please place cursor in a valid position. "
                          + "Allowed positions are:\n"
                          + "- After parentheses\n"
                          + "","Error Invalid Cursor Placement", JOptionPane.ERROR_MESSAGE);

                }else{
                    try{   
                        this.jTextFieldFormula.getDocument().insertString(mousePosition, opp, null);
                    }catch(BadLocationException ex) {
                        Logger.getLogger(AdvancedWizardUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }    
        }else{
            JOptionPane.showMessageDialog(rootPane, "You cant insert empty opperations"
                          + "","Error Invalid Cursor Placement", JOptionPane.ERROR_MESSAGE);
            }
          
        }
    }//GEN-LAST:event_jButtonAddOppActionPerformed

    private void jButtonAddFuncActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddFuncActionPerformed
        formula= jTextFieldSintax.getText();
        if(flagCanAddToFunction==true){
        insertFuntionPos();            
        controller.updateResult();
        }else{
        JOptionPane.showMessageDialog(rootPane, "Please replace all of the paramethers first.\nThere are still "
                          +parameterCountReplaced+ " paramethers missing","Error Paramethers missing", JOptionPane.ERROR_MESSAGE);
        }    
        
      
    }//GEN-LAST:event_jButtonAddFuncActionPerformed

    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        jPanel2.removeAll();
        jPanel2.revalidate();
        JTree t = createTree();
        jPanel2.add(t, BorderLayout.CENTER);
        jPanel2.setVisible(true);
      }//GEN-LAST:event_jButtonGenerateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddFunc;
    private javax.swing.JButton jButtonAddOpp;
    private javax.swing.JButton jButtonApply;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JButton jButtonValueAdd;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaDescription;
    private javax.swing.JTextArea jTextAreaResult;
    private javax.swing.JTextField jTextFieldFormula;
    private javax.swing.JTextField jTextFieldOperation;
    private javax.swing.JTextField jTextFieldSintax;
    private javax.swing.JTextField jTextFieldValue;
    // End of variables declaration//GEN-END:variables
   
    private void updateComboBox() {
        functionsCombo = controller.functions();

        for (Function f : functionsCombo) {
            jComboBox1.addItem(controller.getFunctionIdentifier(f));
        }

    }
    private void txtCaretListener() {
        this.jTextFieldFormula.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                mousePosition = jTextFieldFormula.getCaretPosition();
            }
        });
    }
    public void txtDocListener() {
        jTextFieldFormula.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                warn();
            }

            public void removeUpdate(DocumentEvent e) {
                warn();
            }

            public void insertUpdate(DocumentEvent e) {
                warn();
            }

            public void warn() {
                controller.updateResult();
            }
            
        });
    }
     /**
     * Insert the selected function in the cursor position
     */
    private void insertFuntionPos() {
        if (mousePosition != 0) {
                String formula2= jTextFieldFormula.getText();
                String[] s = formula.split("=");
                String s1 = s[1];
                //JOptionPane.showMessageDialog(rootPane, s1);
                
                //checks if isercion is valid
                if(!controller.checkValidPosition(formula2,mousePosition )){
                    
                  JOptionPane.showMessageDialog(rootPane, "Please place cursor in a valid position. "
                          + "Allowed positions are:\n"
                          + "- Before or after operation symbol\n"
                          + "- Between two parentheses","Error Invalid Cursor Placement", JOptionPane.ERROR_MESSAGE);

                }else{
                    try{   
                        this.jTextFieldFormula.getDocument().insertString(mousePosition, s1, null);
                    }catch(BadLocationException ex) {
                        Logger.getLogger(AdvancedWizardUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }    
        }else{
            try {
                this.jTextFieldFormula.getDocument().insertString(mousePosition, formula, null);
            } catch (BadLocationException ex) {
                Logger.getLogger(AdvancedWizardUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                    
    }

   
    public void setFormula(String formula) {
        this.formula = formula;
    }

    public void updateResult(String result) {
        jTextAreaResult.setText(result);
    }

    public JTextField getJTextFormula() {
        return this.jTextFieldFormula;
    }

    private void selectFunction() {
        this.jTextAreaDescription.setText(this.controller.getDescription());
        this.jTextAreaDescription.setToolTipText(this.controller.getDescription());
        this.jTextFieldSintax.setText(this.controller.getSyntax());
        this.jTextFieldSintax.setToolTipText(this.controller.getSyntax());
    }

    private JTree createTree() {
        CommonTree ctree = controller.getTreeSource(jTextFieldFormula.getText());
        JTree tree = new JTree(new DefaultMutableTreeNode(ctree));
        controller.generateTree(ctree, tree);
        treeAction(tree);
        return tree; 
    }

    private void treeAction(JTree tree) {
       tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                resetHighlighter();
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                //  System.out.println("Node " + selectedNode.toString());
                String text = jTextFieldFormula.getText();
                if (text.contains(selectedNode.toString())) {
                    int i = text.indexOf(selectedNode.toString());
                    int cn = selectedNode.getChildCount();
                    
                        String s = "";
                        s = selectedNode.toString() + "(";
                        if (cn>0){
                        for (int x = 0; x < cn - 1; x++) {
                            if (selectedNode.getChildCount()>0){
                                
                            }
                            s += selectedNode.getChildAt(x) + " ; ";
                        }
                        s += selectedNode.getChildAt(cn - 1);
                        }
                        s += ")";
                  //    walkTree(selectedNode, s, v);
                        if (text.contains(s)) {
                            i = text.indexOf(s);
                            try {
                                jTextFieldFormula.getHighlighter().addHighlight(i, s.length() + i, new DefaultHighlighter.DefaultHighlightPainter(Color.lightGray));
                            } catch (BadLocationException ex) {
                                Logger.getLogger(AdvancedWizardUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
                }


        });  
    }
    private void resetHighlighter() {
         jTextFieldFormula.getHighlighter().removeAllHighlights();
    }

}