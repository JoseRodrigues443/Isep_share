/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150710.BeanShell.Integration;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public class BeanShellScript implements Serializable {

    /**
     * name identifier of the script
     */
    private final String scriptName;
    /**
     * objective of the script
     */
    private String scriptDescription;

    /**
     * java script for bean shell
     */
    private String beanShellScript;

    

    public BeanShellScript(String scriptName, String scriptDescription, String beanShellScript) {
            this.scriptName = scriptName;
            this.scriptDescription = scriptDescription;
            this.beanShellScript = beanShellScript;
    }

    public String getScriptName() {
        return scriptName;
    }

    public String getBeanShellScript() {
        return beanShellScript;
    }

    public void setBeanShellScript(String beanShellScript) {
        this.beanShellScript = beanShellScript;
    }

    public String getScriptDescription() {
        return scriptDescription;
    }

    public void setScriptDescription(String scriptDescription) {
        this.scriptDescription = scriptDescription;
    }

    @Override
    public boolean equals(Object o) {
//        if (o.equals(this)) {
//            return true;
//        }
        if (!o.getClass().equals(this.getClass())) {
            return false;
        }
        BeanShellScript beanShellScriptTmp = (BeanShellScript) o;
        if (beanShellScriptTmp.scriptName.equalsIgnoreCase(this.scriptName)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.scriptName);
        return hash;
    }

}
