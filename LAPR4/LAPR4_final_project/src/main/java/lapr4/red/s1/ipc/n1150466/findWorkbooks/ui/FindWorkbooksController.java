package lapr4.red.s1.ipc.n1150466.findWorkbooks.ui;

import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr4.blue.s2.ipc.n1150595.advancedWorkbookSearch.AdvancedWorkbookSearch;

/**
 * Edited by Bruna Moreira Teixeira <1150595@isep.ipp.pt> - Sprint 2
 */
public class FindWorkbooksController {

    /**
     * The list of found files.
     */
    private List<File> files;

    /**
     * The extension object. - Modificated for Sprint 2
     */
    private AdvancedWorkbookSearch extension;
//    private FindWorkbooks extension;

    /**
     * The user interface controller.
     */
    private UIController uiController;

    /**
     * Creates a new FindWorbooksController - Modificated for Sprint 2
     *
     * @param uiController the user interface controller.
     */
    public FindWorkbooksController(UIController uiController) {
        this.extension = new AdvancedWorkbookSearch();
//        this.extension = new FindWorkbooks();
        this.files = new ArrayList<>();
        this.uiController = uiController;
    }

    /**
     * Sets the root directory to start the search.
     *
     * @param directory
     */
    public void setDirectory(String directory) {
        this.extension.setUserDirectory(directory);
    }

    /**
     * Invokes the search method contained in the extension object.
     *
     * @return found file list
     */
    public List<File> search() {
        return extension.search();
    }

    /**
     * Loads a given file to the current spreadsheet
     *
     * @param file the chosen file
     */
    public void load(File file) {
        try {
            extension.load(file, uiController);
        } catch (IOException ex) {
            /* ignore exceptions for now */
            Logger.getLogger(FindWorkbooksController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FindWorkbooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sets the pattern to search. - Sprint 2
     *
     * @param pattern
     */
    public void setPattern(String pattern) {
        this.extension.setPattern(pattern);
    }

    public AdvancedWorkbookSearch extension() {
        return this.extension;
    }

    public UIController uiController() {
        return this.uiController;
    }

}
