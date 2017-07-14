package lapr4.red.s1.ipc.n1150834.importExportTxt.ui;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import lapr4.red.s1.ipc.n1150834.importExportTxt.ExportTxt;

/**
 * A controller for exporting text files.
 *
 * @author 1150834
 */
public class ExportController {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * Creates a new export controller
     *
     * @param uiController the user interface controller
     */
    public ExportController(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     * Exports the information from the cell range into a text file
     */
    public void exportInformation(String file, Cell beginning, Cell end, char specialChar, boolean behavior) {
        ExportTxt out = new ExportTxt(uiController, file, beginning, end, specialChar, behavior);

        out.exportInformationTxt();
    }
}
