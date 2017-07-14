/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150595.advancedWorkbookSearch.application;

import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.IOException;
import lapr4.red.s1.ipc.n1150466.findWorkbooks.ui.FindWorkbooksController;

/**
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
public class AdvancedWorkbookSearchController extends FindWorkbooksController {

    /**
     * Creates a new AdvancedWorkbookSearchController
     *
     * @param uiController the user interface controller.
     */
    public AdvancedWorkbookSearchController(UIController uiController) {
        super(uiController);
    }

    /**
     * Method to preview a file
     *
     * @param file the file
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void preview(File file) throws IOException, ClassNotFoundException {
        extension().preview(file, uiController());
    }

}
