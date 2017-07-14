/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.ImportExportLink;

import csheets.core.Spreadsheet;
import java.io.File;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/**
 *
 * @author Ana Pacheco (1130679)
 */
public class LinkFileImport {

    /**
     * List to save the file linked to the sheet
     */
    public static List<FileLink> fileImport = new ArrayList<FileLink>();

    /**
     * List to save the threads to connect the file to the sheet
     */
    public static List<Thread> ThreadImport = new ArrayList<Thread>();

    /**
     *
     * Adds the file link and the thread to the list
     *
     */
    public static void addFile(FileLink fileLink, Thread t) {
        fileImport.add(fileLink);
        ThreadImport.add(t);

    }

    public static List<FileLink> getFileImport() {
        return fileImport;
    }

    /**
     * 
     * Method that given a sheet removes the link between the thread and the
     * file, it also removes them from the list
     * 
     */
    public static void removeFileLink(Spreadsheet sheet) {
        int i;
        Thread thread;
        try {
            for (FileLink fileLink : fileImport) {
                if (fileLink.getSheet() == sheet) {
                    i = fileImport.indexOf(fileLink);
                    fileImport.remove(i);
                    thread = ThreadImport.get(i);
                    thread.interrupt();
                    ThreadImport.remove(i);
                }
            }
        } catch (ConcurrentModificationException ce) {
            removeFileLink(sheet);
        }

    }

    /**
     *
     * Method that searches for a file given a sheet *
     *
     */
    public static boolean findFile(Spreadsheet sheet) {
        for (FileLink fl : fileImport) {
            if (fl.getSheet() == sheet) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * Creates the link between a file and a thread
     *
     */
    public static boolean importFile(File file, Spreadsheet sheet,
            boolean header,
            String separator) {
        FileLink fileLink = new FileLink(sheet, file, header, separator, "");
        ImportThread it = new ImportThread(fileLink);
        Thread t = new Thread(it);
        addFile(fileLink, t);
        t.start();
        return true;
    }

}
