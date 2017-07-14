/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.ImportExportLink;

import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import lapr4.blue.s2.ipc.n1130679.importExportLink.LinkFileExport;
import lapr4.blue.s2.ipc.n1130679.importExportLink.ExportTxtLink;

/**
 *
 * @author Ana Pacheco (1130679)
 */
public class TextFileController {

    protected UIController uiController;
    private String fileName;

    public TextFileController() {
    }

    public TextFileController(UIController ui) {
        uiController = ui;
    }

    public void exportTxt(File ficheiro, String separator, boolean headerLine,
            String header) {
        ExportTxtLink exptxt = new ExportTxtLink();
        Spreadsheet sheet = uiController.getActiveSpreadsheet();
        boolean result = exptxt.
                exportTxt(sheet, ficheiro, headerLine, separator, header);

        if (result) {
            JOptionPane.showMessageDialog(null, "File created successfully.",
                    "Export to TXT", JOptionPane.DEFAULT_OPTION);
        } else {
            JOptionPane.showMessageDialog(null, "Error creating the file.",
                    "Export to TXT", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean exportTxt(Spreadsheet sheet, File f, String separator,
            boolean headerLine,
            boolean linked, String header) {
        return LinkFileExport.
                findFileExport(sheet, f, headerLine, separator, header);
    }

    public void importTxt(Spreadsheet sheet, File f, String separator,
            boolean headerLine) {
        ImportTxtLink imp = new ImportTxtLink(sheet);
        FileLink fl = new FileLink(sheet, f, headerLine, separator, "");
        try {
            imp.fileImport(fl);
        } catch (IOException ex) {
        }
    }

    public boolean checkSheetExportationLink(Spreadsheet sheet) {
        List<FileLink> files = LinkFileExport.getExportFile();
        for (FileLink fl : files) {
            if (fl.getSheet() == sheet) {
                fileName = fl.getFile().getName();
                return true;
            }
        }
        return false;
    }

    public boolean checkSheetImportationLink(Spreadsheet sheet) {
        if (LinkFileImport.findFile(sheet)) {
            List<FileLink> files = LinkFileImport.getFileImport();
            for (FileLink fl : files) {
                if (fl.getSheet() == sheet) {
                    fileName = fl.getFile().getName();
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean checkFile(Spreadsheet sheet) {
        return LinkFileImport.findFile(sheet);
    }

    public String getFileName() {
        return fileName;
    }

    public void removeExportationLink(Spreadsheet sheet) {
        LinkFileExport.removeFile(sheet);
    }

    public void removeImportationLink(Spreadsheet sheet) {
        LinkFileImport.removeFileLink(sheet);
    }

    public boolean importTxt(Spreadsheet sheet, File f, String separator,
            boolean headerLine, boolean b) {
        return LinkFileImport.importFile(f, sheet, headerLine, separator);
    }
}
