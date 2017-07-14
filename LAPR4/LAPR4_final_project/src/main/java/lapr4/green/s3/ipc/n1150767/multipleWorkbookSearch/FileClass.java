/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s3.ipc.n1150767.multipleWorkbookSearch;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Catarina Sousa
 */
public class FileClass implements Serializable{
    File file;

    public FileClass(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    
}
