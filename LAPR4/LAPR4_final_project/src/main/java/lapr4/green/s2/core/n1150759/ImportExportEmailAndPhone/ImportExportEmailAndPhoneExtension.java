/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s2.core.n1150759.ImportExportEmailAndPhone;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.green.s2.core.n1150759.ImportExportEmailAndPhone.ui.ImportExportEmailsAndPhonesUIExtension;

/**
 *
 * @author Jorge Campos <1150759@isep.ipp.pt>
 */
public class ImportExportEmailAndPhoneExtension extends Extension {
    /**
     * Extension's name
     */
    public static final String NAME = "Import and Export emails and phones";
    
    /**
     * Creates a new extension
     */
    public ImportExportEmailAndPhoneExtension() {
        super(NAME, "Description of Import/Export emails and phones", "1.0");
    }
    
    /**
    * Returns the user interface extension of this extension 
    * 
    * @param uiController the user interface controller
    * @return a user interface extension, or null if none is provided
    */
   @Override
   public UIExtension getUIExtension(UIController uiController) {
       return new ImportExportEmailsAndPhonesUIExtension(this, uiController);
   }
}
