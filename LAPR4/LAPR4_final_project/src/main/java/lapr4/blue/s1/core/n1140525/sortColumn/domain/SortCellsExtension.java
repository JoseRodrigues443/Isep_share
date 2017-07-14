/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1140525.sortColumn.domain;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.blue.s1.core.n1140525.sortColumn.ui.SortColumnExtensionUI;

/**
 *
 * @author MariaJoão
 */
public class SortCellsExtension extends Extension{

    public static final String NAME = "Sort Cells";
    
    public SortCellsExtension() {
        super(NAME, "Description of Sort Cells", "1.0");
    }
    
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new SortColumnExtensionUI(this, uiController);
    }
}
