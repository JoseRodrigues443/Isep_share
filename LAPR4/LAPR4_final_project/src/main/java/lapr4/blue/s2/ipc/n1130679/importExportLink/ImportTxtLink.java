/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1130679.ImportExportLink;

import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ConcurrentModificationException;

/**
 *
 * @author Ana Pacheco (1130679)
 */
public class ImportTxtLink {

    private final Spreadsheet sheet;

    public ImportTxtLink(Spreadsheet sheet) {
        this.sheet = sheet;
    }

    public void fileImport(FileLink fileLink) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(fileLink.getFile());
        Reader streamReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(streamReader);

        Spreadsheet sheet = fileLink.getSheet();

        String line;
        int columns = 0;
        if (!fileLink.getHeaderOption()) {
            reader.readLine();
        }
        while ((line = reader.readLine()) != null) {
            String[] row = line.split(fileLink.getSeparator());
            for (int i = 0; i < row.length; i++) {
                try {
                    synchronized (sheet.getCell(i, columns)) {
                        sheet.getCell(i, columns).setContent(row[i]);
                    }
                } catch (FormulaCompilationException ex) {

                } catch (ConcurrentModificationException e) {
                    synchronized (sheet.getCell(i, columns)) {
                        try {
                            sheet.getCell(i, columns).setContent(row[i]);
                        } catch (FormulaCompilationException ex) {
                        }
                    }
                }
            }
            columns++;
        }
        reader.close();
    }
}
