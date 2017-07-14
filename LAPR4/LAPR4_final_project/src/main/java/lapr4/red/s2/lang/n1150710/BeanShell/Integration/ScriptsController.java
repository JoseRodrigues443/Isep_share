/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150710.BeanShell.Integration;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * 
 * used for the MacroWindowUI tabbed pane to save/delete/edit scripts
 *
 * @author 1150710@isep.ipp.pt
 */
public class ScriptsController {

    private final BeanShellScriptList beanShellScriptList;

    public ScriptsController() {
        this.beanShellScriptList = new BeanShellScriptList();
    }

    public boolean add(BeanShellScript e) {
        return beanShellScriptList.add(e);
    }

    
    public DefaultListModel listForUI(){
        return returnModelForJListStringFormat(scriptsNameList());
    }
    
    public ArrayList<String> scriptsNameList(){
        ArrayList<String>  toReturn = new ArrayList<>();
        for (BeanShellScript s : this.beanShellScriptList.getBeanShellScripts()) {
            toReturn.add(s.getScriptName());
        }      
        
        return toReturn;
    }
    
    private static DefaultListModel returnModelForJListStringFormat(ArrayList<String> string) {
        DefaultListModel model = new DefaultListModel<>();
        for (String s : string) {
            model.addElement(s);
        }

        return model;
    }

    public BeanShellScript get(int i) {
        return beanShellScriptList.get(i);
    }

    public BeanShellScript remove(int i) {
        return beanShellScriptList.remove(i);
    }

    public boolean saveList() {
        return beanShellScriptList.saveThisObject();
    }

    public void fillData() {
        beanShellScriptList.fillData();
    }
    
    
    

    
}
