package lapr4.red.s1.ipc.n1150834.importExportTxt;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import java.io.File;
import eapli.util.Strings;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Import from a text file operation.
 *
 * @author 1150834
 */
public class ImportTxt implements Import {

    /**
     * The user interface controller
     */
    private UIController uiController;
    /**
     * Input file
     */
    private File file;
    /**
     * Cell on one end of the range
     */
    private Cell beginning;
    /**
     * Cell on the other end of the range
     */
    private Cell end;
    /**
     * Export row behavior
     */
    private boolean behavior;
    /**
     * Special character
     */
    private String[] charaters = {"|", ";", "#", "."};

    /**
     * Creates a new ImportTxt operation.
     *
     * @param uiController the user interface controller
     * @param file name of the input file
     * @param beginning the cell where the range begins
     * @param end the cell where the range ends
     * @param behavior the export row behavior
     */
    public ImportTxt(UIController uiController, String file, Cell beginning, Cell end, boolean behavior) {
        if (Strings.isNullOrEmpty(file) || Strings.isNullOrWhiteSpace(file) || !file.endsWith(".txt")) {
            throw new IllegalArgumentException("File name can't be null, empty, or white space and has to be .txt!");
        }
        this.file = new File(file);
        this.uiController = uiController;
        this.beginning = beginning;
        this.end = end;
        this.behavior = behavior;
    }

    /**
     * Returns a given number of lines from a text file.
     *
     * @param rowNumber number of lines to read.
     * @return lines read from file
     */
    @Override
    public String[] importInformation(int rowNumber) {
        String[] info = new String[rowNumber];
        int i = 0;
        try {
            Scanner input = new Scanner(new FileReader(file));
            while (i < rowNumber && input.hasNextLine()) {
                info[i] = input.nextLine();
                i++;
            }
            input.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportTxt.class.getName()).log(Level.SEVERE, null, ex);
        }

        return info;
    }

    /**
     * Imports the information from a text file
     *
     * @throws FormulaCompilationException
     */
    public void importInformationTxt() throws FormulaCompilationException {
        int inicio;
        int i, j;

        if (behavior) {
            inicio = 1;
        } else {
            inicio = 0;
        }

        int row = end.getAddress().getRow() /*- beginning.getAddress().getRow()*/ + 1 + inicio;
        int column = end.getAddress().getColumn() /*- beginning.getAddress().getColumn()*/ + 1;
        int beginRow = beginning.getAddress().getRow();
        int beginColumn = beginning.getAddress().getColumn();
        String buffer[] = importInformation(row);

        Spreadsheet sheet = uiController.getActiveSpreadsheet();

        i = 0;
        for (j = inicio; j < buffer.length; j++) {
            if (buffer[j] != null) {
                String content[] = splitLine(buffer[j]);
                while (i < content.length && i < column) {
                    sheet.getCell(beginColumn + i, beginRow).setContent(content[i]);
                    i++;
                }
                if (beginRow == row) {
                    break;
                } else {
                    beginRow++;
                }
                i = 0;
            } else {
                break;
            }
        }
    }

    /**
     * Returns the information from a given line, that is separated by a special
     * character
     *
     * @param line of information
     * @return an array with the information from line
     */
    private String[] splitLine(String line) {
        for (String character : charaters) {
            if (line.contains(character)) {
                if(character.equals("|") || character.equals(".")){
                    character = "\\"+character;
                }
                return line.split(character);
            }
        }
        return null;
    }
}
