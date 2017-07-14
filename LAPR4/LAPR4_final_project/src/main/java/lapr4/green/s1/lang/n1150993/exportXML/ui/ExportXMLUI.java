/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150993.exportXML.ui;

import csheets.ui.FileChooser;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author 1150993
 */
public class ExportXMLUI extends JFrame {

    /**
     * Controller for exporting files
     */
    private ExportXMLController controller;
    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * Export options for xml files
     */
    private final String[] exportList = {"Workbook", "Worksheets", "Selected cells", "Cancel"};

    /**
     * Tags of xml file.
     */
    private final String[] tags = {"workbook", "Worksheet", "cell", "content", "column", "row"};

    /**
     * Creates a instance of ExportXMLUI
     *
     * @param uiController the user interface controller
     */
    public ExportXMLUI(UIController uiController) {
        this.uiController = uiController;
        this.controller = new ExportXMLController(this.uiController);
    }

    public void chooseWhatToExport(SpreadsheetTable focusOwner)  {
        int choose = JOptionPane.showOptionDialog(null, "Choose what you want export", "Export XML", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, exportList, exportList[0]);

        if (choose == 3) {
            return;
        } else {
            chooseTags();
            FileChooser fileChoose = new FileChooser(null, null);
           
            fileChoose.setAcceptAllFileFilterUsed(false);
            fileChoose.addChoosableFileFilter(new FileNameExtensionFilter(".xml", "xml"));
            String path = fileChoose.getFileToSave().getAbsolutePath();
            
            this.controller.changeDataFile(this.tags, path);
            switch (choose) {
                case 0:
                    this.controller.exportWorkbook();
                    break;
                case 1:

                    List<Integer> numberWorksheets = new ArrayList<>();
                    int aux = 0;

                    int numWorksheet = Integer.parseInt(JOptionPane.showInputDialog("Enter the worksheet number: ")) - 1;
                    numberWorksheets.add(numWorksheet);
                    do {
                        aux = 0;
                        numWorksheet = Integer.parseInt(JOptionPane.showInputDialog("Enter the worksheet number(Press -1 to finish): ")) - 1;
                        if (numWorksheet >= 0) {
                            numberWorksheets.add(numWorksheet);
                        } else {
                            aux = -1;
                        }

                    } while (aux >= 0);
                    this.controller.exportWorksheet(numberWorksheets);

                    break;
                case 2:
                    int numberWorksheet = Integer.parseInt(JOptionPane.showInputDialog("Enter the worksheet number: "));
                    this.controller.exportWorksheet(focusOwner, numberWorksheet);
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Choose and validate the tags for xml file
     */
    private void chooseTags() {
        int resp;
        do {
            this.tags[0] = JOptionPane.showInputDialog("workbook tag: ", this.tags[0]);
            this.tags[1] = JOptionPane.showInputDialog("worksheet tag: ", this.tags[1]);
            this.tags[2] = JOptionPane.showInputDialog("cell tag: ", this.tags[2]);
            this.tags[3] = JOptionPane.showInputDialog("content tag: ", this.tags[3]);
            this.tags[4] = JOptionPane.showInputDialog("column tag: ", this.tags[4]);
            this.tags[5] = JOptionPane.showInputDialog("row tag: ", this.tags[5]);
            resp = -1;

            if (this.tags[0].isEmpty() || this.tags[1].isEmpty() || this.tags[2].isEmpty()
                    || this.tags[3].isEmpty() || this.tags[4].isEmpty() || this.tags[5].isEmpty()) {
                JOptionPane.showMessageDialog(null, "Invalid tag, re-enter!");
                resp = 0;
            }
        } while (resp == 0);
    }
  
}
