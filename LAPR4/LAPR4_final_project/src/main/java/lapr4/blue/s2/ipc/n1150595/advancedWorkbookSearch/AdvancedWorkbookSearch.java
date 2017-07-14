/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150595.advancedWorkbookSearch;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.io.Codec;
import csheets.io.CodecFactory;
import csheets.ui.ctrl.UIController;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lapr4.blue.s2.ipc.n1150595.advancedWorkbookSearch.ui.PreviewWorkbookUI;
import lapr4.red.s1.ipc.n1150466.findWorkbooks.FindWorkbooks;

/**
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
public class AdvancedWorkbookSearch extends FindWorkbooks {

    /**
     * Model of the preview table
     */
    private DefaultTableModel model;

    /**
     * The Preview Workbook UI
     */
    private PreviewWorkbookUI previewWorkbookUI = new PreviewWorkbookUI();

    /**
     * The set of possible columns
     */
    private static final String[] possibleColumns = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
        "R", "S", "T", "U", "V", "X", "Y", "Z", "AA", "AB", "AC", "AD", "AE", "AF", "AG", "AH", "AI", "AJ", "AK", "AL", "AM",
        "AN", "AO", "AP", "AQ", "AR", "AS", "AT", "AU", "AV", "AX", "AY", "AZ"};

    /**
     * The number of sheets that the workbook has
     */
    private int numSheets;

    /**
     * The column of the first non-empty cell of the workbook
     */
    private int firstColumn;
    /**
     * The row of the first non-empty cell of the workbook
     */
    private int firstRow;

    /**
     * The size of the preview table
     */
    private static final int SIZE = 5;

    /**
     * The columns of the preview table
     */
    private String[] columns;

    /**
     * Creates a new AdvancedWorkbookSearch
     */
    public AdvancedWorkbookSearch() {
        super();
    }

    /**
     * Creates a new AdvancedWorkbookSearch
     *
     * @param userDirectory the directory
     * @param pattern the pattern
     */
    public AdvancedWorkbookSearch(String userDirectory, String pattern) {
        super(userDirectory, pattern);

        this.firstColumn = 0;
        this.firstRow = 0;

    }

    /**
     * Creates a new AdvancedWorkbookSearch
     *
     * @param userDirectory the directory
     */
    public AdvancedWorkbookSearch(String userDirectory) {
        super(userDirectory);
    }

    /**
     * Returns the columns of the preview
     *
     * @return columns of the preview
     */
    public String[] columns() {
        return columns;
    }

    /**
     * Updates the columns of the preview
     */
    public void updateColums() {
        this.columns = new String[SIZE + 1];

        int j = 0;
        this.columns[j] = "";
        j++;
        for (int i = this.firstColumn; i < SIZE; i++) {
            this.columns[j] = possibleColumns[i];
            j++;
        }

    }

    /**
     * Method to preview a chosen file.
     *
     * @param file the chosen file
     * @param uiController user interface controller to access the active
     * workbook
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void preview(File file, UIController uiController) throws IOException, ClassNotFoundException {
        Workbook w = null;
        Codec codec = new CodecFactory().getCodec(file);
        boolean preview = true;
        if (codec != null) {
            FileInputStream stream = null;
            try {
                // Reads workbook data
                stream = new FileInputStream(file);
                setWorkbook(codec.read(stream));
            } catch (EOFException exc) {
                JOptionPane.showMessageDialog(null, "The selected file is empty!", "Empty", JOptionPane.INFORMATION_MESSAGE);
                preview = false;
            } finally {
                try {
                    if (stream != null) {
                        stream.close();
                    }
                } catch (IOException e) {
                }
            }

            if (preview) {
                this.numSheets = workbook().getSpreadsheetCount();
                int n = firstCell();
                updateColums();
                this.previewWorkbookUI = new PreviewWorkbookUI();
                this.previewWorkbookUI.preview(file, model, columns, firstColumn, firstRow, n);
            }

        } else {
            throw new IOException("Codec could not be found");
        }
    }

    /**
     * Method to find the column and row of the first non-empty cell of the
     * workbook
     *
     * @return the number of the sheet that contains the first non-empty cell of
     * the workbook
     */
    public int firstCell() {
        for (int numSheet = 0; numSheet < this.numSheets; numSheet++) {
            Spreadsheet spreadsheet = workbook().getSpreadsheet(numSheet);
            for (int i = 0; i < 128; i++) {
                for (int j = 0; j < 52; j++) {
                    Cell c = spreadsheet.getCell(j, i);
                    if (!c.getContent().equals("")) {
                        this.firstRow = i;
                        this.firstColumn = j;
                        return numSheet;
                    }
                }
            }
        }
        return 0;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public PreviewWorkbookUI getPreviewWorkbookUI() {
        return previewWorkbookUI;
    }

    public void setPreviewWorkbookUI(PreviewWorkbookUI previewWorkbookUI) {
        this.previewWorkbookUI = previewWorkbookUI;
    }

    public int getNumSheets() {
        return numSheets;
    }

    public void setNumSheets(int numSheets) {
        this.numSheets = numSheets;
    }

    public int getFirstColumn() {
        return firstColumn;
    }

    public void setFirstColumn(int firstColumn) {
        this.firstColumn = firstColumn;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    
}
