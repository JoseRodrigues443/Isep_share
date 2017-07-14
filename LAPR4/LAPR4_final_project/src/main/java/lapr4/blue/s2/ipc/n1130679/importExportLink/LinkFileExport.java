/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.importExportLink;

import csheets.core.Spreadsheet;
import java.io.File;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import lapr4.blue.s2.ipc.n1130679.ImportExportLink.FileLink;

/**
 * similar to the class made for the import part
 *
 * @author Ana
 */
public class LinkFileExport {

    /**
     * List to save the files
     */
    public static List<FileLink> fileExport = new ArrayList<FileLink>();

    /**
     * List to save the threads
     */
    public static List<Thread> ThreadExport = new ArrayList<Thread>();

    /**
     *
     * @param sheet
     * @param fileName
     * @param headerOption
     * @param separator
     * @param header
     */
    public static void addFile(Spreadsheet sheet, File fileName,
            boolean headerOption,
            String separator, String header) {
        FileLink fl = new FileLink(sheet, fileName, headerOption, separator, header);
        fileExport.add(fl);
        ExportThread ex = new ExportThread(fl);
        Thread t1 = new Thread(ex);
        t1.start();
        ThreadExport.add(t1);
    }

    /**
     * Removes the exportation link
     *
     * @param sheet current spreadsheet
     */
    public static void removeFile(Spreadsheet sheet) {
        int index;
        Thread t;
        try {
            for (FileLink fl : fileExport) {
                if (fl.getSheet() == sheet) {
                    index = fileExport.indexOf(fl);
                    fileExport.remove(index);
                    t = ThreadExport.get(index);

                    t.interrupt();
                    ThreadExport.remove(index);
                }
            }
        } catch (ConcurrentModificationException ce) {
            removeFile(sheet);
        }
    }

    /**
     * Checks if there's already a link and if so it removes that link and
     * creates a new one
     */
    public static boolean findFileExport(Spreadsheet sheet, File fileName,
            boolean headerOption, String separator,
            String header) {
        boolean validate = false;
        for (FileLink f : fileExport) {
            if (f.getFile().getName().equals(fileName.getName())) {
                return false;
            } else {
                if (f.getSheet() == sheet) {
                    validate = true;
                }
            }
        }
        if (validate) {
            removeFile(sheet);
        }
        addFile(sheet, fileName, headerOption, separator, header);
        return true;
    }

    /**
     *
     */
    public static boolean isLinked(Spreadsheet spreadsheet) {
        for (FileLink f : fileExport) {
            if (spreadsheet == f.getSheet()) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @return the FileLink list
     */
    public static List<FileLink> getExportFile() {
        return fileExport;
    }

    /**
     *
     * @return the Thread list
     */
    public static List<Thread> getThread() {
        return ThreadExport;
    }
}
