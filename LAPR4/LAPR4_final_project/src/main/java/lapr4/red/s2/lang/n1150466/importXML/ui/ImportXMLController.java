package lapr4.red.s2.lang.n1150466.importXML.ui;

import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.io.File;
import lapr4.red.s2.lang.n1150466.importXML.ImportData;

/**
 *
 * @author Sebastiao
 */
public class ImportXMLController {

    private final UIController uiController;
    private final SpreadsheetTable table;
    private final ImportData imp;
    
    

    public ImportXMLController(UIController uiController, SpreadsheetTable table) {
        this.uiController = uiController;
        this.table = table;
        this.imp = new ImportData(uiController, table);
    }
    
    public void importXML(File file, int opt){
        imp.importXML(file, opt);
    }
    
}
