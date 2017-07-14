package lapr4.red.s1.ipc.n1150834.importExportTxt;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.ui.ctrl.UIController;
import eapli.util.Files;
import java.io.File;
import eapli.util.Strings;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Export to text file opeartion.
 *
 * @author 1150834
 */
public class ExportTxt implements Export {

    /**
     * The user interface controller
     */
    private UIController uiController;
    /**
     * Output file
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
     * The special character
     */
    private char specialChar;
    /**
     * Export row behavior
     */
    private boolean behavior;

    /**
     * Creates a new ExportTxt operation
     *
     * @param uiController the user interface controller
     * @param file the name of the output file
     * @param beginning the cell where the range begins
     * @param end the cell where the range ends
     * @param specialChar the special character that seperates columns
     * @param behavior the export row behavior
     */
    public ExportTxt(UIController uiController, String file, Cell beginning, Cell end, char specialChar, boolean behavior) {
        if (Strings.isNullOrEmpty(file) || Strings.isNullOrWhiteSpace(file)) {
            throw new IllegalArgumentException("File name can't be null, empty, or white space!");
        }
        this.file = new File(Files.ensureExtension(file, ".txt"));
        this.uiController = uiController;
        this.beginning = beginning;
        this.end = end;
        this.specialChar = specialChar;
        this.behavior = behavior;
    }

    /**
     * Exports the given information, into a text file.
     *
     * @param information information to write into the file
     * @return true if succesfull, false otherwise
     */
    @Override
    public boolean exportInformation(String[][] information) {
        try {
            FileWriter output = new FileWriter(file);
            for (String[] line : information) {
                for (int i = 0; i < line.length; i++) {
                    output.write(String.format("%s", line[i]));
                    if (i != line.length - 1) {
                        output.write(String.format("%c", specialChar));
                    }
                }
                output.write(String.format("\n"));
            }
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(ExportTxt.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * Exports the information from the cell range into a text file
     */
    public void exportInformationTxt() {
        Spreadsheet sheet = uiController.getActiveSpreadsheet();
        int row = end.getAddress().getRow() - beginning.getAddress().getRow() + 1;
        int column = end.getAddress().getColumn() - beginning.getAddress().getColumn() + 1;
        int beginRow = beginning.getAddress().getRow();
        int beginColumn = beginning.getAddress().getColumn();
        int i, j, inicio;
        String[][] information;

        if (behavior) {

            inicio = 1;
            information = new String[row + 1][column];
            for (j = 0; j < column; j++) {
                information[0][j] = getCellColumn(sheet.getCell(beginColumn + j, 0).getAddress().toString());
            }
        } else {
            inicio = 0;
            information = new String[row][column];
        }

        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                information[inicio + i][j] = sheet.getCell(beginColumn + j, beginRow + i).getContent();
            }
        }

        exportInformation(information);
    }

    /**
     * Returns the column of a given cell
     *
     * @param cell
     * @return String representing the cell colunn
     */
    private String getCellColumn(String cell) {
        String[] split = cell.split("[0-9]+");

        return split[0];
    }

}
