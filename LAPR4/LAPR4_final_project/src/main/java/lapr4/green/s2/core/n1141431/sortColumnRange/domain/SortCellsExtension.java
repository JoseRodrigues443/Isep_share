package lapr4.green.s2.core.n1141431.sortColumnRange.domain;

import lapr4.green.s2.core.n1141431.sortColumnRange.ui.UISortCellsExtension;
import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 *
 * @author Pedro Oliveira 1141431
 */
public class SortCellsExtension extends Extension {

    /*The name of this extension*/
    public static final String NAME = "Cells Sort v2";

    
    /**
     * Creates a new instance of SortCellsExtension
     */
    public SortCellsExtension() {
        super(NAME, "Description of Cells Sort", "2.0");
    }

    /**
     * Returns the user interface extension of this extension.
     *
     * @param uiController user interface controller
     * @return user interface extension
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
   
        if (this.uiExtension == null) {
            this.uiExtension = new UISortCellsExtension(this, uiController);
        }
        return this.uiExtension;
    }

  

}
