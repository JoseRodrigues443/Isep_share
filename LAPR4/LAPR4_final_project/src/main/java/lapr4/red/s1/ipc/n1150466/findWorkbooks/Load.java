package lapr4.red.s1.ipc.n1150466.findWorkbooks;

import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.IOException;

public interface Load {
    /**
     * Method to load a file
     * 
     * @param file file to be loaded
     * @param uiController user interface controller
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void load(File file, UIController uiController) throws IOException, ClassNotFoundException;
    
}
