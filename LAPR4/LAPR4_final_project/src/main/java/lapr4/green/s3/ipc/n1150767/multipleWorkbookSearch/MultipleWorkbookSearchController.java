/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150767.multipleWorkbookSearch;

import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TimerTask;

/**
 *
 * @author Catarina Sousa 1150767
 */
public class MultipleWorkbookSearchController {
    /**
     * UI controller
     */
    UIController uictrl;
    
    MultipleWorkbookSearch mws;
    
    /**
     * Controller constructor
     * @param uictrl 
     */
    public MultipleWorkbookSearchController(UIController uictrl) {
        this.uictrl = uictrl;
        this.mws = new MultipleWorkbookSearch(uictrl);
    }
    
    public void setActive(){
        boolean verify = mws.getIsActive();
        if (verify == true) {
            mws.setInactive();
        }
        if (verify== false) {
            mws.setActive();
        }
    }

    public boolean getActive(){
        return mws.getIsActive();
    }
    /**
     * Does the preview of a file the user selects. Sees if it is the firts time
     * its selected. If it is imports the file to a binary file and the next time
     * it's selected the program opens the binary file
     * @param file
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public void previewsFirst(String file) throws IOException, ClassNotFoundException{
        mws.previewsFirst(file);
    }
    /**
     * Fills the maps with the files information
     * @param list 
     */
    public void fillsMaps(List<File> list){
        mws.fillMaps(list);
    }
    /**
     * If a file is modified it shows it's preview
     * @param list 
     */
    public void previewFileModified (List<File> list){
        mws.previewFileModified(list);
    }
}
