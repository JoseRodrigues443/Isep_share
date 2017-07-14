package lapr4.red.s1.ipc.n1150834.importExportTxt.ui;

import csheets.ui.ctrl.UIController;
import javax.swing.JMenu;

/**
 * A menu that displays import and export option
 *
 * @author 1150834
 */
class ImportExportMenu extends JMenu {

    /**
     * Creates a new ImportExportMenu
     *
     * @param uiController the user interface controller
     */
    public ImportExportMenu(UIController uiController) {
        super("Import/Export text");

        add(new ImportAction(uiController));
        addSeparator();
        add(new ExportAction(uiController));
    }
}
