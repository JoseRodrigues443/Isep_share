/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s1.ipc.n1140412.fileSharing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileSystemView;
import lapr4.red.s1.ipc.network.library.Utils;

/**
 *  Class that finds and deals with the paths and fileLists
 *  @author Tiago
 */
public class FileShare {
    /**
     * Retuns an ArrayList with all files under the given path
     * @param path
     * @return 
     */
    public static ArrayList<File> filesUnderPath(String path) {
        File directory = new File(path);
        ArrayList<File> ret = new ArrayList<>();
        File[] s = directory.listFiles();
        if (s == null){
            return ret;
        }
        for (File f : s) {
            ret.add(f);
        }
        return ret;
    }
    /**
     * Returns a ArrayList with all the file names in the given fileList
     * @param fileList
     * @return 
     */
    public static ArrayList<String> filesNameList(ArrayList<File> fileList) {
        ArrayList<String> ret = new ArrayList<>();
        for (File f : fileList) {
            ret.add(f.getName());
        }
        return ret;
    }
    /**
     * Return an ArrayList with all the sizes of the given fileList
     * @param fileList
     * @return 
     */
    public static ArrayList<String> fileSizeList(ArrayList<File> fileList) {
        return Utils.sizeOfEachFile(fileList);
    }
    /**
     * Searches for the downloadPath file and return the download path saved in it
     * @return 
     */
    public static String downloadPath() {
        String path = "";
        try {
            String defaultpath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            Scanner file = new Scanner(new FileReader(defaultpath + "/downloadPath.txt"));
            path = file.next();
            file.close();
        } catch (FileNotFoundException ex) {
            path = "";
        }
        return path;
    }
    /**
     * Saves the download path in a file names downloadPath in the system default directory
     * @param pathToSave 
     */
    public static void saveDownloadPath(String pathToSave) {
        try {
            String defaultpath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();

            FileWriter file = new FileWriter(new File(defaultpath + "/downloadPath.txt"));

            file.write(pathToSave);

            file.close();
        } catch (IOException ex) {
            Logger.getLogger(FileShare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Returns an ArrayList with the name and its correspondente size
     * @param fileList
     * @return 
     */
    public static ArrayList<String> fileListInfo(ArrayList<File> fileList) {
        ArrayList<String> ret = new ArrayList<>();
        ArrayList<String> fileNames = filesNameList(fileList);
        ArrayList<String> fileSizes = fileSizeList(fileList);

        for (int i = 0; i < fileList.size(); i++) {
            String str = fileNames.get(i) + " Size: " + fileSizes.get(i);
            ret.add(str);
        }
        return ret;
    }
}
