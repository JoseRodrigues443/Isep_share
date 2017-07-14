/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150605.networkExplorer;

import csheets.CleanSheets;
import csheets.core.Workbook;
import csheets.ext.Extension;
import csheets.ext.ExtensionManager;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Miguel Morgado 1150605
 */
public class CleanSheetsInstance implements Serializable {
    
    public CleanSheetsInstance() {
     
       /* for (UIExtension e : uiC.getExtensions()) {
            allExtensions.add(e.getExtension());
        }*/
    }
    
    /**
     * Returns workbooks of the current cleansheets application
     * @param c, the cleansheets application
     * @return workbooks
     */
    public Workbook[] getWorkbooks(CleanSheets c) {
        return c.getWorkbooks();
    }

    /**
     * Returns loaded extensions.
     * @return loaded extensions.
     */
    public Extension[] getLoadedExtensions() {
         return ExtensionManager.getInstance().getExtensions();
         
    }

}
