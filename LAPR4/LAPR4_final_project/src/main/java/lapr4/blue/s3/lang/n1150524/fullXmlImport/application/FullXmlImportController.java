/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1150524.fullXmlImport.application;

import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.io.File;
import lapr4.blue.s3.lang.n1150524.fullXmlImportExport.FullDataImport;

/**
 *
 * @author Filipe Correia <1150524@isep.ipp.pt>
 */
public class FullXmlImportController {

    private final FullDataImport imp;

    public FullXmlImportController(UIController uiController, SpreadsheetTable table) {
        imp = new FullDataImport(uiController, table);
    }

    public void appendXml(File file, int opt) {
        imp.appendXML(file, opt);
    }

    public void replaceXml(File file, int opt) {
        imp.importXML(file, opt);

    }

}
