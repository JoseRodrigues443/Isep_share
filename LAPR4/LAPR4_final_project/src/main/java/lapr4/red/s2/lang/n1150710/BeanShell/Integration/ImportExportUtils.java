/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150710.BeanShell.Integration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * basic methods to delete file, create serializable file, import serializable
 * file
 *
 *
 * @author 1150710@isep.ipp.pt
 */
public class ImportExportUtils {

    /**
     *
     * @param path path of file to delete
     * @return
     */
    public static boolean deleteFile(Path path) {
        boolean toReturn = false;
        try {
            Files.delete(path);
            toReturn = true;
        } catch (DirectoryNotEmptyException x) {
        } catch (IOException ex) {
        }
        return toReturn;
    }

    /**
     *
     * @param path
     * @param serializableObj
     * @return
     */
    public static boolean saveFile(String path, Object serializableObj) {

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(serializableObj);
            oos.close();
            fos.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BeanShellScriptList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BeanShellScriptList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(BeanShellScriptList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    /**
     * imports file
     *
     * @param path
     * @return
     */
    public static Object importFile(String path) {
        File f = new File(path);
        Object toReturn = null;
        if (f.exists()) {
            FileInputStream fis = null;

            try {
                fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                toReturn = (Object) ois.readObject();
                ois.close();
                fis.close();
                return toReturn;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(BeanShellScriptList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BeanShellScriptList.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BeanShellScriptList.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(BeanShellScriptList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return toReturn;
    }

}
