package lapr4.red.s2.lang.n1150466.importXML.ui;

import csheets.SpreadsheetAppEvent;
import csheets.ui.FileChooser;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import lapr4.blue.s3.lang.n1150524.fullXmlImportExport.ui.FullImportUI;
import lapr4.red.s2.lang.n1150466.importXML.ImportData;
import org.w3c.dom.Document;

/**
 *
 * @author Sebastiao
 */
public class ImportXMLUI extends JFrame {

    /**
     * The use case controller
     */
    private ImportXMLController controller;
    /**
     * The user interface controller
     */
    private UIController uiController;

    private SpreadsheetTable table;
    /**
     * Options for importing
     */
    private final String[] importList = {"Workbook", "Worksheets", "Selected cells", "Cancel"};

    /**
     * Creates a new ImportXML user interface
     *
     * @param uiController the user interface controller
     * @param table the spreadhsheet table
     */
    public ImportXMLUI(UIController uiController, SpreadsheetTable table) {
        this.uiController = uiController;
        this.table = table;
        this.controller = new ImportXMLController(this.uiController, this.table);

        initComponents();
    }

    private void initComponents() {
        FileChooser filechooser = new FileChooser(null, null);
        filechooser.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getAbsolutePath().endsWith(".xml") || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "*.xml";
            }
        });

        File file = filechooser.getFileToOpen();

//        if (file != null) {
//            int save = JOptionPane.showConfirmDialog(null, "Are you sure you want to load the file? Any unsaved changes will be lost.", "Confirmed",
//                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
//            if (save == JOptionPane.OK_OPTION) {
        int opt = JOptionPane.showOptionDialog(null, "Select what to import...", "Import Option", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, importList, importList[0]);

        FullImportUI ui = new FullImportUI(file, opt, uiController, table);

//
//                if (opt != 3) {
//                    /*if (opt != 0) {
//                        uiController.workbookUnloaded(new SpreadsheetAppEvent(this, uiController.getActiveWorkbook(), null, SpreadsheetAppEvent.Type.UNLOADED));
//                    }*/
//                    controller.importXML(file, opt);
//                }
//            }
//        }
    }
}
