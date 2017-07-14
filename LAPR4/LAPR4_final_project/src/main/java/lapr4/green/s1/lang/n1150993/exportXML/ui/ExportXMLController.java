/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150993.exportXML.ui;

import csheets.core.Workbook;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.util.List;
import lapr4.green.s1.lang.n1150993.exportXML.CreateXML;

/**
 *
 * @author 1150993
 */
public class ExportXMLController {

    /**
     * The user interface controller
     */
    private UIController uiController;

    /**
     * The class to create the xml file
     */
    private CreateXML crtXML;

    /**
     * Creates a instance of ExportXMLController
     *
     * @param uiController the user interface controller
     */
    public ExportXMLController(UIController uiController) {
        this.uiController = uiController;
    }

    /**
     * Returns the active workbook
     *
     * @return workbook the active workbook
     */
    public Workbook activeWorkbook() {
        return this.uiController.getActiveWorkbook();
    }

    /**
     * Create a instance of CreateXML and  changes the data required for export
     *
     * @param tags the tags of elements of xml file
     * @param filePath the path of file to export
     */
    public void changeDataFile(String[] tags,String filePath) {
        this.crtXML=new CreateXML();
        this.crtXML.selectWorkbook(activeWorkbook());
        this.crtXML.selectPath(filePath);
        this.crtXML.selectTags(tags);
        this.crtXML.selectController(uiController);
    }

    /**
     * Creates an xml file of workbook
     * 
     */
    public void exportWorkbook(){
        this.crtXML.exportWorkbook();
    }

    /**
     * Create an xml file of worksheets passed as parameter
     * 
     * @param numberWorksheets Number of worksheets to export
     */
    public void exportWorksheet(List<Integer> numberWorksheets){
        this.crtXML.exportWorksheet(numberWorksheets);
    }

    /**
     * Create an xml file of part of worksheet passed as parameter
     * 
     * @param table Table where cells will be exported
     * @param numberPag Number of worksheet
     */
    public void exportWorksheet(SpreadsheetTable table, int numberPag){
        this.crtXML.exportPartOfWorksheet(table, numberPag);
    }

}
