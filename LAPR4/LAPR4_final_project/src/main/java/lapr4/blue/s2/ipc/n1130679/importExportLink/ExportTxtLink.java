/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.importExportLink;

import csheets.core.Spreadsheet;
import java.io.File;
import java.util.Formatter;

/**
 *
 * @author Ana Pacheco (1130679)
 */
public class ExportTxtLink {

    public ExportTxtLink() {

    }

    public boolean exportTxt(Spreadsheet sheet, File ficheiro,
            boolean headerLine, String separator,
            String header) {
        try {
            Formatter formatter = new Formatter(ficheiro);
            int row = 0;
            if (headerLine) {
                formatter.format(header);
                formatter.format("%n");
            }
            for (; row < sheet.getRowCount(); row++) {
                for (int column = 0; column < sheet.getColumnCount() + 1; column++) {
                    synchronized (sheet.getCell(column, row)) {
                        formatter.format(sheet.getCell(column, row).getContent()
                                + separator);
                    }
                }
                formatter.format("%n");
            }

            formatter.close();
            return true;
        } catch (Exception ex) {
        }
        return false;
    }
}
