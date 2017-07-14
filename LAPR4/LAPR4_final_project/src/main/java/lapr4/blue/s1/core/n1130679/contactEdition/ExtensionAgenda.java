/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s1.core.n1130679.contactEdition;

import csheets.ext.Extension;
import csheets.ui.ctrl.UIController;
import csheets.ui.ext.UIExtension;
import lapr4.blue.s1.core.n1130679.contactEdition.ui.UIAgendaExtension;

/**
 *
 * @author Ana Pacheco (11305679)
 */
public class ExtensionAgenda extends Extension {

    /**
     * The name of the extension
     */
    public static final String NAME = "Agenda";

    /**
     * Creates a new GameCenter extension.
     */
    public ExtensionAgenda() {
        super(NAME, "Description of Agenda", "1.0");
    }

    /**
     * Returns the user interface extension of this extension (an instance of
     * the class {@link  csheets.ext.simple.ui.UIGameCenterExtension}).
     *
     * @param uiController the user interface controller
     * @return a user interface extension, or null if none is provided
     */
    @Override
    public UIExtension getUIExtension(UIController uiController) {
        return new UIAgendaExtension(this, uiController);
    }

}
