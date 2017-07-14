/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s2.ipc.n1150595.advancedWorkbookSearch.ui;

import csheets.CleanSheets;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Bruna Moreira Teixeira <1150595@isep.ipp.pt>
 */
public class PreviewWorkbookUI {

    /**
     * The size of the table
     */
    private final int SIZE = 5;

    /**
     * Creates a new PreviewWorkbookUI
     */
    public PreviewWorkbookUI() {
    }

    /**
     * Method that creates and shows the table to preview the file
     *
     * @param file the file to preview
     * @param model the preview table model
     * @param columns the columns
     * @param firstColumn the first column
     * @param firstRow the first row
     * @param n the spreadsheet
     */
    public void preview(File file, DefaultTableModel model, String[] columns, int firstColumn, int firstRow, int n) {

        final JFrame frame = new JFrame(file.getName() + " - Sheet " + (n + 1));

        //Create the table
        final Object[][] rowData = {};
        model = new DefaultTableModel(rowData, columns);
        //Disables cell editing in the table
        JTable previewTable = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        ;
        };
        
        //Table configurations
        previewTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 12));
        previewTable.setCellEditor(null);
        previewTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         for (int i = 0; i < previewTable.getColumnCount(); i++) {
            TableColumn c = previewTable.getColumnModel().getColumn(i);
            if (i == 0) {
                c.setPreferredWidth(30);
                c.setMaxWidth(30);
                c.setResizable(false);
            } else {
                c.setResizable(true);
            }
        }
        JScrollPane previewTableScrollPane = new JScrollPane(previewTable);
        previewTableScrollPane.setPreferredSize(new Dimension(408, 103));
        JPanel container = new JPanel();
        container.setLayout(new GridLayout(1, 2));
        container.add(previewTableScrollPane);

        //Display the window.
        frame.add(container);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        CleanSheets csheetsInstance = new CleanSheets();
        Workbook loadedWorkbook = csheetsInstance.getWorkbook(file);

        if (loadedWorkbook == null) {
            try {
                //if workbook isn't open yet
                csheetsInstance.load(file);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(PreviewWorkbookUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        loadedWorkbook = csheetsInstance.getWorkbook(file);
        Spreadsheet spreadsheet = loadedWorkbook.getSpreadsheet(n);

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }

        for (int row = firstRow; row < firstRow + SIZE; row++) {
            Object[] myRow = {row};
            model.addRow(myRow);
            for (int column = firstColumn; column < firstColumn + SIZE; column++) {
                String currentCellContent = spreadsheet.
                        getCell(column, row).
                        getContent();
                model.
                        setValueAt(currentCellContent, row, column + 1);
            }
        }
    }

}
