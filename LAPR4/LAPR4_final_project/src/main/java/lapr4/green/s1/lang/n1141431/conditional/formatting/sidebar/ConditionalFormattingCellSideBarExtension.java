/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1141431.conditional.formatting.sidebar;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;

/**
 * this class is to show the option conditinal formatted in VIEW->SIDEBAR
 *
 * @author Pedro Oliveira 1141431
 */
public class ConditionalFormattingCellSideBarExtension extends Extension {

    public static final String NAME_OF_EXTENSION = "Conditional Formatted";

    /**
     * Creates a new Conditional Formatting Cell SideBar extension.
     */
    public ConditionalFormattingCellSideBarExtension() {
        super(NAME_OF_EXTENSION, "Description of Conditional Formatted", "1.0");
    }

    @Override
    public UIExtension getUIExtension(UIController uiController) {

        if (this.uiExtension == null) {
            this.uiExtension = new UIConditionalFormattingCellSideBarExtension(this, uiController);
        }
        return this.uiExtension;
    }

    /**
     * refreshes the info in the sidebar with the last condition used in the
     * Conditional Formatted Cell option
     */
    public void refreshInfo() {
        UIConditionalFormattingCellSideBarExtension ui = (UIConditionalFormattingCellSideBarExtension) this.uiExtension;
        ui.setConditionText();

    }
}
