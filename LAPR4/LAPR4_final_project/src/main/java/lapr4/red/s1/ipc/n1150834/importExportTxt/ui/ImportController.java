package lapr4.red.s1.ipc.n1150834.importExportTxt.ui;

import csheets.core.Cell;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import lapr4.red.s1.ipc.n1150834.importExportTxt.ImportTxt;

/**
 * A controller for importing text files.
 *
 * @author 1150834
 */
public class ImportController {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * Creates a new import controller
     *
     * @param uiController the user interface controller
     */
    public ImportController(UIController uiController) {
        this.uiController = uiController;

    }

    /**
     * Imports the information from the cell range into a text file
     *
     * @param file name of the input file
     * @param beginning the cell where the range begins
     * @param end the cell where the range ends
     * @param behavior the export row behavior
     * @throws csheets.core.formula.compiler.FormulaCompilationException
     */
    public void importInformationTxt(String file, Cell beginning, Cell end, boolean behavior) throws FormulaCompilationException {
        ImportTxt in = new ImportTxt(uiController, file, beginning, end, behavior);

        in.importInformationTxt();

    }

}
