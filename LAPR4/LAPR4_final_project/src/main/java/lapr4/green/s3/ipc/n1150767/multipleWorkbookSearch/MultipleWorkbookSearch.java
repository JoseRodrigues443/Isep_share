/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150767.multipleWorkbookSearch;

import csheets.core.Workbook;
import csheets.io.Codec;
import csheets.io.CodecFactory;
import csheets.ui.ctrl.UIController;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr4.blue.s2.ipc.n1150595.advancedWorkbookSearch.AdvancedWorkbookSearch;
import lapr4.blue.s2.ipc.n1150595.advancedWorkbookSearch.ui.PreviewWorkbookUI;
import lapr4.red.s1.ipc.n1150466.findWorkbooks.FindWorkbooks;
import lapr4.red.s2.lang.n1150710.BeanShell.Integration.ImportExportUtils;
import org.h2.store.fs.FileUtils;

/**
 *
 * @author Catarina Sousa 1150767
 */
public class MultipleWorkbookSearch extends AdvancedWorkbookSearch{

    boolean isActive;
//    java.util.Timer timer;
    Map<File,Long> mapaData;
    Map<File,Integer> mapaClicks;
    UIController uictrl;
    private final static File dest =  new File("./cache");
    FindWorkbooks cache = new FindWorkbooks(dest.getPath() + "/");

    public MultipleWorkbookSearch(UIController uictrl) {
        super();
        this.uictrl=uictrl;
        this.mapaClicks= new LinkedHashMap<>();
        this.mapaData= new LinkedHashMap<>();
    }
    
    /**
     * Returns the boolean isActive
     * @return 
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * For a active search
     *
     */
    public void setActive() {
        this.isActive = true;
//        newTimer(5);
    }

    /**
     * For a inactive search
     *
     */
    public void setInactive() {
        this.isActive = false;
//        timer.cancel();
    }

    @Override
    public List<File> search() {
        return super.search(); //To change body of generated methods, choose Tools | Templates.
    }
//    
//    /**
//     * Creates the timer
//     * @param seconds
//     * @return 
//     */
//    public boolean newTimer(int seconds) {
//        /*amount of time to the run method be executed again*/
//        int timeInterval = seconds * 1000;
//        
//        timer = new java.util.Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                List<File> list = search();
//                previewFileModified(list);
//                fillMaps(list);
//            }
//        }, 0, timeInterval);
//
//        return true;
//    }
    /**
     * If a file is modified it shows it's preview
     * @param list 
     */
    public void previewFileModified (List<File> list){
        for (File f : list) {
            if (!mapaData.containsKey(f)) {
                mapaData.put(f, f.lastModified());
            }
            if (mapaData.get(f)!=f.lastModified()) {
                try {
                     preview(f,uictrl);
                } catch (IOException ex) {
                    Logger.getLogger(MultipleWorkbookSearch.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(MultipleWorkbookSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * Fille the maps with the information
     */
    public void fillMaps(List<File> list){
        for (File f : list) {
            this.mapaClicks.put(f,0);
            this.mapaData.put(f,f.lastModified());
        }
    }

    @Override
    public void preview(File file, UIController uiController) throws IOException, ClassNotFoundException {
        super.preview(file, uiController); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * The user chooses the file and if it is the first time the user selects 
     * the file it is passed to a binary file and the next time he previews the 
     * file he opens it's the binary file
     * 
     */
    public void previewsFirst(String file) throws IOException, ClassNotFoundException{
        for (File f : mapaClicks.keySet()) {
            if (f.getName().equals(file)) {
                if (mapaClicks.get(f)==0) {
                    preview(f, uictrl);
                    exportCache(f);
                    mapaClicks.put(f,1);
                }else{
                    importCache(file, uictrl);
                }
                
            }
        }
    }
    
    public void exportCache (File f) throws IOException{
        Files.copy(f.toPath(), (new File(dest.getPath() +"/" +f.getName())).toPath(), (CopyOption) StandardCopyOption.REPLACE_EXISTING);
    }
    
    public void importCache (String file, UIController uictrl) throws IOException, ClassNotFoundException{
        List<File> l = cache.search();
            for (File fi : l) {
                if (fi.getName().equals(file)) {
                    preview(fi,uictrl);
                }
            }
    }
    
}
