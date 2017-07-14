package lapr4.red.s2.lang.n1150466.importXML;

import csheets.core.Cell;
import csheets.core.Workbook;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Sebastiao
 */
public class ImportData {
    /**
     * Static variables for comparing the importing option specified by the user.
     */
    private static final int WB_OPTION = 0;
    private static final int WS_OPTION = 1;
    private static final int RANGE_OPTION = 2;
    /**
     * Static variables for a spreadsheet's maximum size.
     */
    private static final int MAX_ROWS = 128;
    private static final int MAX_COLS = 52;
    
    /**
     * Static variables representing the tags of the element containing the
     * user defined tags when exporting to XML. (see method "appendTags()" in CreateXML)
     */
    private static final String WB_TAG_ELEMENT = "workbook_tag";
    private static final String WS_TAG_ELEMENT = "worksheet_tag";
    private static final String CELL_TAG_ELEMENT = "cell_tag";
    private static final String CONTENT_TAG_ELEMENT = "content_tag";
    private static final String ROW_TAG_ELEMENT = "row_tag";
    private static final String COLUMN_TAG_ELEMENT = "column_tag";
    
    /**
     * The user defined tags for each type of element.
     */
    private String workbook_tag;
    private String worksheet_tag;
    private String cell_tag;
    private String content_tag;
    private String row_tag;
    private String column_tag;
    
    /**
     * The user interface controller.
     */
    private UIController uiController;
    
    /**
     * The XML document object.
     */
    private Document doc;
    
    /**
     * The spreadsheet table.
     */
    private final SpreadsheetTable table;
    
    /**
     * Creates a new ImportData object with the given parameters.
     * 
     * @param uiController the user interface controller
     * @param table  the spreadsheet table
     */
    public ImportData(UIController uiController, SpreadsheetTable table) {
        this.uiController = uiController;
        this.table = table;

    }
    
    /**
     * The core method of the use case. Receiving a file and an option (whether 
     * to import the whole workbook, worksheet or a range of cells), 
     * it starts to create a parsable document through the file and proceeds to 
     * get the tags used in the file through an element contained in the actual XML file.
     * Then according to the option selected the specified method is invoked to parse the file and 
     * either load a fresh workbook, add a spreadsheet to the active workbook or replace the 
     * selected cells with the corresponding cells on the document.
     * More on this later on the method specific javadoc.
     * 
     * @param file the file chosen by the user
     * @param opt the option specified by the user
     */
    public void importXML(File file, int opt) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            doc = documentBuilder.parse(file);

            NodeList tags_nl = doc.getElementsByTagName("tags");
            Node tags = tags_nl.item(0);
            tags(tags);

            switch (opt) {
                case WB_OPTION:
                    workbook();
                    break;
                case WS_OPTION:
                    String[][] content = buildContentMatrix();
                    worksheet(doc.getElementsByTagName(worksheet_tag).item(0), content);
                    uiController.getActiveWorkbook().addSpreadsheet(content);
                    break;
                case RANGE_OPTION:
                    range();
                    break;
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
        }
    }
    /**
     * Method to replace the active workbook with a brand new workbook parsed from the 
     * XML file.
     * In this method, the method worksheet() is invoked to reduce code duplication,
     * since a workbook is a group of worksheets the same method can be used.
     * Parsing an individual worksheet at a time using the method worksheet() and adding it
     * to a new workbook object (new_workbook), a new workbook is created and then set
     * as the active one. The workbook is replaced with user consent through a confirmation
     * dialog in the UI.
     */
    private void workbook() {
        Workbook new_workbook = new Workbook();

        NodeList worksheets = doc.getElementsByTagName(worksheet_tag);

        for (int i = 0; i < worksheets.getLength(); i++) {
            String[][] content = buildContentMatrix();
            worksheet(worksheets.item(i), content);
            new_workbook.addSpreadsheet(content);
        }

        uiController.setActiveWorkbook(new_workbook);
    }
    
    /**
     * Method to parse a worksheet node contained in the root element (workbook) 
     * of the XML file.
     * This method extracts all the cells present in the worksheet node as child nodes (cell),
     * and through these nodes the information about the cells is accessed through
     * more child nodes (content, row, column). 
     * Since the method to add a new spreadsheet to a workbook uses a String matrix,
     * only the content is used to represent the cell on this stage. Then the implemented
     * code will address the addresses to each individual cell object.
     * 
     * @param worksheet the worksheet node previously parsed
     * @param content the content matrix to be filled
     */
    private void worksheet(Node worksheet, String[][] content) {
        NodeList cells = worksheet.getChildNodes();
        for (int i = 0; i < cells.getLength(); i++) {
            Node cell = cells.item(i);
            if (cell.getNodeType() == Node.ELEMENT_NODE) {
                Element cellElement = (Element) cell;

                Element cell_content = (Element) cellElement.
                        getElementsByTagName(content_tag).item(0); //we know there's only 1 content
                String textContent = cell_content.getTextContent();

                Element colElement = (Element) cellElement.
                        getElementsByTagName(column_tag).item(0); //we know there's only 1 col
                
                int col = Integer.parseInt(colElement.getTextContent());

                Element rowElement = (Element) cellElement.
                        getElementsByTagName(row_tag).item(0); //we know there's only 1 row
                
                int row = Integer.parseInt(rowElement.getTextContent());

                content[row - 1][col - 1] = textContent;
            }
        }

    }
    /**
     * Method to parse a document in search for a specific range of cells.
     * This range of cells corresponds to the previously selected cells in 
     * CleanSheets.
     * Comparing each cell address of the document to the selected cell address,
     * the method replaces the active cell if the address is in fact the same.
     * 
     */
    private void range() {

        NodeList cells = doc.getElementsByTagName(cell_tag);
        Cell[][] selectedCells = table.getSelectedCells();
        
        for (int row = 0; row < selectedCells.length; row++) {
            int cols = selectedCells[row].length;
            for (int column = 0; column < cols; column++) {
                try {
                    for (int i = 0; i < cells.getLength(); i++) {
                        Node cell = cells.item(i);
                        if (cell.getNodeType() == Node.ELEMENT_NODE) {
                            Element cellElement = (Element) cell;
                            Node contentNode = cellElement.getElementsByTagName(content_tag).item(0);
                            Node rowNode = cellElement.getElementsByTagName(row_tag).item(0);
                            Node colNode = cellElement.getElementsByTagName(column_tag).item(0);

                            int rowtext = Integer.parseInt(rowNode.getTextContent()) - 1; //export mechanism does not use indexes as a reference
                            int coltext = Integer.parseInt(colNode.getTextContent()) - 1;
                            if (rowtext == row && coltext == column) {
                                selectedCells[row][column].setContent(contentNode.getTextContent());
                            }
                        }
                    }

                } catch (FormulaCompilationException e) {
                }
            }
        }

    }
    /**
     * Initializes the content matrix.
     * @return the content matrix
     */
    private String[][] buildContentMatrix() {
        String[][] content = new String[MAX_ROWS][MAX_COLS];
        for (int j = 0; j < content.length; j++) {
            for (int k = 0; k < content[j].length; k++) {
                content[j][k] = "";
            }
        }
        return content;
    }

    /*private Node findCell(int row, int column) {

        Node cell = null;
        try {
            XPathFactory xPathfactory = XPathFactory.newInstance();
            XPath xpath = xPathfactory.newXPath();
            String expression = String.format("//cell[%s='%s' and %s='%s']", column_tag, row, row_tag, column);
            XPathExpression expr = xpath.compile("//cell[column='1' and row='1']");
            cell = (Node) expr.evaluate(doc, XPathConstants.NODE);

        } catch (XPathExpressionException e) {
        }
        return null;
    }*/
    /**
     * Parses the tags used in the file.
     * @param tags the node containing the information about the tags
     */
    private void tags(Node tags) {
        NodeList children = tags.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node item = children.item(i);
            String element_name = item.getNodeName();
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                switch (element_name) {
                    case WB_TAG_ELEMENT:
                        workbook_tag = item.getTextContent();
                        break;
                    case WS_TAG_ELEMENT:
                        worksheet_tag = item.getTextContent();
                        break;
                    case CELL_TAG_ELEMENT:
                        cell_tag = item.getTextContent();
                        break;
                    case CONTENT_TAG_ELEMENT:
                        content_tag = item.getTextContent();
                        break;
                    case ROW_TAG_ELEMENT:
                        row_tag = item.getTextContent();
                        break;
                    case COLUMN_TAG_ELEMENT:
                        column_tag = item.getTextContent();
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
