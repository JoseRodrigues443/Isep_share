/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1150524.fullXmlImportExport;

import csheets.core.Cell;
import csheets.core.Spreadsheet;
import csheets.core.Value;
import csheets.core.Value.Type;
import csheets.core.Workbook;
import csheets.core.formula.Expression;
import csheets.core.formula.Formula;
import csheets.core.formula.compiler.FormulaCompilationException;
import csheets.core.formula.lang.Macro;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr4.red.s3.core.n1150834.persistingImages.PersistentImageCell;
import lapr4.white.s1.core.n1234567.comments.CommentableCell;
import lapr4.white.s1.core.n1234567.comments.CommentableCellListener;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Filipe Correia <1150524@isep.ipp.pt>
 */
public class FullDataImport {

    /**
     * Static variables for comparing the importing option specified by the
     * user.
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
     * Static variables representing the tags of the element containing the user
     * defined tags when exporting to XML. (see method "appendTags()" in
     * CreateXML)
     */
    private static final String WB_TAG_ELEMENT = "workbook_tag";
    private static final String WS_TAG_ELEMENT = "worksheet_tag";
    private static final String CELL_TAG_ELEMENT = "cell_tag";
    private static final String CONTENT_TAG_ELEMENT = "content_tag";
    private static final String ROW_TAG_ELEMENT = "row_tag";
    private static final String COLUMN_TAG_ELEMENT = "column_tag";
    private static final String IMAGE_TAG_ELEMENT = "image_tag";
    private static final String FORMULA_TAG_ELEMENT = "formula_tag";
    private static final String EXPRESSION_TAG_ELEMENT = "expression_tag";
    private static final String MACRO_TAG_ELEMENT = "macro_tag";
    private static final String SCRIPT_TAG_ELEMENT = "script_tag";
    private static final String GV_TAG_ELEMENT = "global_variable_tag";
    private static final String GV_NAME_TAG_ELEMENT = "global_variable_name_tag";
    private static final String GV_VALUE_TAG_ELEMENT = "global_variable_value_tag";
    private static final String MACRO_PARAMS_TAG_ELEMENT = "macro_parameter_tag";
    private static final String COMMENT_TAG_ELEMENT = "comment_tag";

    /**
     * The user defined tags for each type of element.
     */
    private String workbook_tag;
    private String worksheet_tag;
    private String cell_tag;
    private String content_tag;
    private String row_tag;
    private String column_tag;
    private String image_tag;
    private String formula_tag;
    private String expression_tag;
    private String macro_tag;
    private String script_tag;
    private String gv_tag;
    private String gv_name_tag;
    private String gv_value_tag;
    private String macro_params_tag;
    private String comment_tag;

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
     * @param table the spreadsheet table
     */
    public FullDataImport(UIController uiController, SpreadsheetTable table) {
        this.uiController = uiController;
        this.table = table;

    }

    /**
     * The core method of the use case. Receiving a file and an option (whether
     * to import the whole workbook, worksheet or a range of cells), it starts
     * to create a parsable document through the file and proceeds to get the
     * tags used in the file through an element contained in the actual XML
     * file. Then according to the option selected the specified method is
     * invoked to parse the file and either load a fresh workbook, add a
     * spreadsheet to the active workbook or replace the selected cells with the
     * corresponding cells on the document. More on this later on the method
     * specific javadoc.
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
                    int sheetNum = uiController.getActiveWorkbook().getSpreadsheetCount() - 1;
                     {
                        worksheet(uiController.getActiveWorkbook(), doc.getElementsByTagName(worksheet_tag).item(0),
                                sheetNum, uiController.getActiveWorkbook().getSpreadsheet(sheetNum));

                    }
                    break;
                case RANGE_OPTION:
                    range();
                    break;
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(FullDataImport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void appendXML(File file, int opt) {
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
                    int sheetNum = uiController.getActiveWorkbook().getSpreadsheetCount() - 1;
                     {
                        worksheet(uiController.getActiveWorkbook(), doc.getElementsByTagName(worksheet_tag).item(0),
                                sheetNum, uiController.getActiveWorkbook().getSpreadsheet(sheetNum));

                    }
                    break;
                case RANGE_OPTION:
                    range();
                    break;
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
        } catch (FormulaCompilationException ex) {
            Logger.getLogger(FullDataImport.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Method to replace the active workbook with a brand new workbook parsed
     * from the XML file. In this method, the method worksheet() is invoked to
     * reduce code duplication, since a workbook is a group of worksheets the
     * same method can be used. Parsing an individual worksheet at a time using
     * the method worksheet() and adding it to a new workbook object
     * (new_workbook), a new workbook is created and then set as the active one.
     * The workbook is replaced with user consent through a confirmation dialog
     * in the UI.
     */
    private void workbook() {
        Workbook new_workbook = new Workbook();

        NodeList worksheets = doc.getElementsByTagName(worksheet_tag);

        for (int i = 0; i < worksheets.getLength(); i++) {
            try {
                String[][] content = buildContentMatrix();
                worksheet(worksheets.item(i), content);
                new_workbook.addSpreadsheet(content);
                worksheet(new_workbook, worksheets.item(i), i, new_workbook.getSpreadsheet(i));
            } catch (FormulaCompilationException ex) {
                Logger.getLogger(FullDataImport.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        uiController.setActiveWorkbook(new_workbook);
    }

    /**
     * Method to parse a worksheet node contained in the root element (workbook)
     * of the XML file. This method extracts all the cells present in the
     * worksheet node as child nodes (cell), and through these nodes the
     * information about the cells is accessed through more child nodes
     * (content, row, column). Since the method to add a new spreadsheet to a
     * workbook uses a String matrix, only the content is used to represent the
     * cell on this stage. Then the implemented code will address the addresses
     * to each individual cell object.
     *
     * @param worksheet the worksheet node previously parsed
     * @param content the content matrix to be filled
     */
    private void worksheet(Node worksheet, String[][] content) {
        NodeList cells = worksheet.getChildNodes();
        for (int i = 0; i < cells.getLength(); i++) {
            Node cell = cells.item(i);
            if (cell.getNodeType() == Node.ELEMENT_NODE && cell.getNodeName().equals(cell_tag)) {
                Element cellElement = (Element) cell;

                Element cell_content = (Element) cellElement.
                        getElementsByTagName(content_tag).item(0); //we know there's only 1 content
                String textContent = "";

                if (cell_content.getElementsByTagName(formula_tag).item(0) != null) {
                    Element formula = (Element) cell_content.getElementsByTagName(formula_tag).item(0);
                    if (formula.hasChildNodes()) {
                        Element expression = (Element) cell_content.getElementsByTagName(expression_tag).item(0);
                        textContent = "=" + expression.getTextContent();
                    }
                } else {
                    textContent = cell_content.getTextContent();
                }

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
     * Method to parse a worksheet node contained in the root element (workbook)
     * of the XML file. This method extracts all the cells present in the
     * worksheet node as child nodes (cell), and through these nodes the
     * information about the cells is accessed through more child nodes
     * (content, row, column). Since the method to add a new spreadsheet to a
     * workbook uses a String matrix, only the content is used to represent the
     * cell on this stage. Then the implemented code will address the addresses
     * to each individual cell object.
     *
     * @param worksheet the worksheet node previously parsed
     * @param content the content matrix to be filled
     */
    private void worksheet(Workbook workbook, Node worksheet, int sheetNum, Spreadsheet s) throws FormulaCompilationException {
        NodeList nodes = worksheet.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) item;

                if (element.getTagName().equals(cell_tag)) {

                    Element colElement = (Element) element.
                            getElementsByTagName(column_tag).item(0); //we know there's only 1 col

                    int col = Integer.parseInt(colElement.getTextContent());

                    Element rowElement = (Element) element.
                            getElementsByTagName(row_tag).item(0); //we know there's only 1 row

                    int row = Integer.parseInt(rowElement.getTextContent());

                    if (element.getElementsByTagName(comment_tag).item(0) != null) {
                        Element comment = (Element) element.getElementsByTagName(comment_tag).item(0);
                        Cell c = s.getCell(col - 1, row - 1);
                        CommentableCell cc = (CommentableCell) c.getExtension("Comments");
                        cc.setUserComment(comment.getTextContent());
                    }

//                    if (element.getElementsByTagName(image_tag).item(0) != null) {
//                        Element image = (Element) element.getElementsByTagName(image_tag).item(0);
//                        PersistentImageCell c = (PersistentImageCell) workbook.getSpreadsheet(sheetNum).getCell(col, row);
//                        c.addImage();
//                    }
                    if (element.getElementsByTagName(gv_tag).item(0) != null) {
                        Element globalVariable = (Element) element.getElementsByTagName(gv_tag).item(0);
                        Element variableName = (Element) globalVariable.getElementsByTagName(gv_name_tag).item(0);
                        Element variableValue = (Element) globalVariable.getElementsByTagName(gv_value_tag).item(0);
                        Value v = Value.parseValue(variableValue.getTextContent().replace(".0", ""), Type.NUMERIC);
                        workbook.findGlobalVariables().addGlobalVariable(s.getCell(col - 1, row - 1),
                                s, variableName.getTextContent(), v);
                    }

                } else if (element.getTagName().equals(macro_tag)) {

                    NodeList script = element.getChildNodes();
                    List<String> lines = new ArrayList<>();
                    ArrayList<String> parameter = new ArrayList<>();

                    for (int j = 0; j < script.getLength(); j++) {
                        Element e = (Element) script.item(j);

                        if (e.getTagName().equals(script_tag)) {
                            lines.add(e.getTextContent());
                        } else {
                            parameter.add(e.getTextContent());
                        }

                    }

                    Macro m = new Macro(s.getCell(0, 0), lines, parameter);

                }
            }
        }

    }

    /**
     * Method to parse a document in search for a specific range of cells. This
     * range of cells corresponds to the previously selected cells in
     * CleanSheets. Comparing each cell address of the document to the selected
     * cell address, the method replaces the active cell if the address is in
     * fact the same.
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
                            Element cell_content = (Element) cellElement.
                                    getElementsByTagName(content_tag).item(0); //we know there's only 1 content
                            String textContent = "";

                            if (cell_content.getElementsByTagName(formula_tag).item(0) != null) {
                                Element formula = (Element) cell_content.getElementsByTagName(formula_tag).item(0);
                                if (formula.hasChildNodes()) {
                                    Element expression = (Element) cell_content.getElementsByTagName(expression_tag).item(0);
                                    textContent = "=" + expression.getTextContent();
                                }
                            } else {
                                textContent = cell_content.getTextContent();
                            }

                            Node rowNode = cellElement.getElementsByTagName(row_tag).item(0);
                            Node colNode = cellElement.getElementsByTagName(column_tag).item(0);

                            int rowtext = Integer.parseInt(rowNode.getTextContent()) - 1; //export mechanism does not use indexes as a reference
                            int coltext = Integer.parseInt(colNode.getTextContent()) - 1;
                            if (rowtext == row && coltext == column) {
                                selectedCells[row][column].setContent(textContent);
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
     *
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
     *
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
                    case EXPRESSION_TAG_ELEMENT:
                        expression_tag = item.getTextContent();
                        break;
                    case FORMULA_TAG_ELEMENT:
                        formula_tag = item.getTextContent();
                        break;
                    case GV_NAME_TAG_ELEMENT:
                        gv_name_tag = item.getTextContent();
                        break;
                    case GV_TAG_ELEMENT:
                        gv_tag = item.getTextContent();
                        break;
                    case GV_VALUE_TAG_ELEMENT:
                        gv_value_tag = item.getTextContent();
                        break;
                    case IMAGE_TAG_ELEMENT:
                        image_tag = item.getTextContent();
                        break;
                    case MACRO_PARAMS_TAG_ELEMENT:
                        macro_params_tag = item.getTextContent();
                        break;
                    case MACRO_TAG_ELEMENT:
                        macro_tag = item.getTextContent();
                        break;
                    case SCRIPT_TAG_ELEMENT:
                        script_tag = item.getTextContent();
                        break;
                    case COMMENT_TAG_ELEMENT:
                        comment_tag = item.getTextContent();
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
