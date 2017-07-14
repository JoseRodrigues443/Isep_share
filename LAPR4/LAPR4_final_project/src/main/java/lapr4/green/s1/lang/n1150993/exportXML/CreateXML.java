/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.green.s1.lang.n1150993.exportXML;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Spreadsheet;
import csheets.core.Workbook;
import csheets.core.formula.lang.Macro;
import csheets.ext.CellExtension;
import csheets.ext.ExtensionManager;
import csheets.ui.ctrl.UIController;
import csheets.ui.sheet.SpreadsheetTable;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import lapr4.red.s2.lang.n1141114.globalVariables.domain.GlobalVariable;
import lapr4.red.s2.lang.n1141114.globalVariables.domain.GlobalVariableList;
import lapr4.red.s3.core.n1150834.persistingImages.PersistentImage;
import lapr4.red.s3.core.n1150834.persistingImages.PersistentImageCell;
import lapr4.white.s1.core.n1234567.comments.CommentableCell;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Carlos Neiva
 */
public class CreateXML {

    /**
     * Tags of xml file
     */
    private String[] tags;

    /**
     * Intance of workbook
     */
    private Workbook workbook;

    /**
     * The user interface controller
     */
    private UIController controller;

    /**
     * Path of file
     */
    private String path;

    /**
     * Creates an empty instance of CreateXML
     */
    public CreateXML() {
        this.tags = null;
        this.workbook = null;
        this.controller = null;
        this.path = "";
    }

    /**
     * Creates an instance of CreateXML receiving
     * file,tags,workbook,controller,path as parameter.
     *
     * @param tags The xml file tags
     * @param workbook The workbook
     * @param controller The user interface controller
     * @param path The path of xml file
     */
    public CreateXML(String[] tags, Workbook workbook, UIController controller, String path) {
        this.tags = tags;
        this.workbook = workbook;
        this.controller = controller;
        this.path = path;
    }

    /**
     * Return tags of the elements of xml file
     *
     * @return the tags
     */
    public String[] Tags() {
        return tags;
    }

    /**
     * Set tags of the elements of xml file
     *
     * @param tags the tags to set
     */
    public void selectTags(String[] tags) {
        this.tags = tags;
    }

    /**
     * Return workbook
     *
     * @return the workbook
     */
    public Workbook Workbook() {
        return workbook;
    }

    /**
     * Set workbook
     *
     * @param workbook the workbook to set
     */
    public void selectWorkbook(Workbook workbook) {
        this.workbook = workbook;
    }

    /**
     * Return the user interface controller
     *
     * @return the controller
     */
    public UIController Controller() {
        return controller;
    }

    /**
     * Select the user interface controller
     *
     * @param controller the controller to select
     */
    public void selectController(UIController controller) {
        this.controller = controller;
    }

    /**
     * Return path of xml file
     *
     * @return the path of xml file
     */
    public String Path() {
        return this.path;
    }

    /**
     * Select Path to save xml file
     *
     * @param path the path to set
     */
    public void selectPath(String path) {
        this.path = path;
    }

    public void saveMacros(Element root, Document documentXML) {
        Map<String, Macro> macros = this.workbook.macroMap();
        for (Macro m : macros.values()) {
            Element macro = documentXML.createElement("Macro");
            for (String st : m.parameters()) {
                Element parameter = documentXML.createElement("Macro_Parameter");
                parameter.appendChild(documentXML.createTextNode(st));
                macro.appendChild(parameter);
            }

            for (String str : m.getScript()) {
                Element script = documentXML.createElement("Script");
                script.appendChild(documentXML.createTextNode(str));
                macro.appendChild(script);
            }
            root.appendChild(macro);
        }
    }

    public void saveGlobalVariables(Spreadsheet s, Document documentXML, Element spreadSheet) throws IllegalValueTypeException {
        GlobalVariableList gVList = this.workbook.findGlobalVariables();
        for (GlobalVariable gV : gVList.currentVariables()) {
            if (gV.sheetWhereDefined().equals(s)) {
                Element globalVariable = documentXML.createElement("Global_Variable");
                Element cell;
                if ((cell = documentXML.getElementById(gV.cellWhereDefined().toString())) == null) {
                    cell = documentXML.createElement(this.tags[2]);
                    spreadSheet.appendChild(cell);

                    Element column = documentXML.createElement(this.tags[4]);
                    String v = Integer.toString(gV.cellWhereDefined().getAddress().getColumn() + 1);
                    column.appendChild(documentXML.createTextNode(v));
                    cell.appendChild(column);

                    Element row = documentXML.createElement(this.tags[5]);
                    String v1 = Integer.toString(gV.cellWhereDefined().getAddress().getRow() + 1);
                    row.appendChild(documentXML.createTextNode(v1));
                    cell.appendChild(row);
                }
                cell.appendChild(globalVariable);
                Element name = documentXML.createElement("Global_Variable_Name");
                Element value = documentXML.createElement("Global_Variable_Value");
                name.appendChild(documentXML.createTextNode(gV.currentGlobalVariableName()));
                value.appendChild(documentXML.createTextNode(Double.toString(gV.currentGlobalVariableValue().toDouble())));
                globalVariable.appendChild(name);
                globalVariable.appendChild(value);
            }
        }
    }

    public void saveImages(Cell cell, Document documentXML, Element spreadSheet) throws IOException {
        Element cellElement;

        PersistentImageCell n = (PersistentImageCell) cell.getExtension("Persisting Images");

        if (n.hasImage()) {
            if ((cellElement = documentXML.getElementById(cell.toString())) == null) {
                cellElement = documentXML.createElement(this.tags[2]);
                spreadSheet.appendChild(cellElement);

                Element column = documentXML.createElement(this.tags[4]);
                String v = Integer.toString(n.getAddress().getColumn() + 1);
                column.appendChild(documentXML.createTextNode(v));
                cellElement.appendChild(column);

                Element row = documentXML.createElement(this.tags[5]);
                String v1 = Integer.toString(n.getAddress().getRow() + 1);
                row.appendChild(documentXML.createTextNode(v1));
                cellElement.appendChild(row);
            }

            for (PersistentImage p : n.getList()) {
                Element image = documentXML.createElement("Image");
                image.appendChild(documentXML.createTextNode(p.toString()));
                cellElement.appendChild(image);
            }
        }
    }

    public void saveComments(Cell cell, Document documentXML, Element spreadSheet) {
        Element cellElement;

        CommentableCell n = (CommentableCell) cell.getExtension("Comments");

        if (n.hasComment()) {
            if ((cellElement = documentXML.getElementById(cell.toString())) == null) {
                cellElement = documentXML.createElement(this.tags[2]);
                spreadSheet.appendChild(cellElement);

                Element column = documentXML.createElement(this.tags[4]);
                String v = Integer.toString(n.getAddress().getColumn() + 1);
                column.appendChild(documentXML.createTextNode(v));
                cellElement.appendChild(column);

                Element row = documentXML.createElement(this.tags[5]);
                String v1 = Integer.toString(n.getAddress().getRow() + 1);
                row.appendChild(documentXML.createTextNode(v1));
                cellElement.appendChild(row);
            }

            Element comment = documentXML.createElement("Comment");
            comment.appendChild(documentXML.createTextNode(n.getUserComment()));
            cellElement.appendChild(comment);

        }
    }

    /**
     * Create xml Workbook file
     *
     */
    public void exportWorkbook() {

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documentXML = documentBuilder.newDocument();

            Element root = documentXML.createElement(this.tags[0]);
            documentXML.appendChild(root);
            appendTags(documentXML, root); //added in sprint 2

            int numSpreadsheets = this.Workbook().getSpreadsheetCount();

            for (int i = 0; i < numSpreadsheets; i++) {
                Element spreadSheet = documentXML.createElement(this.tags[1]);
                spreadSheet.setAttribute("number", Integer.toString(i + 1)); //added in sprint 2
                root.appendChild(spreadSheet);

                Spreadsheet s = this.workbook.getSpreadsheet(i);
                //rows deleted in sprint 2
                SpreadsheetTable st = new SpreadsheetTable(s, this.controller);
                st.selectAll();
                Cell[][] list = st.getSelectedCells();
                for (int j = 0; j < list.length; j++) {
                    for (int k = 0; k < list[0].length; k++) {
                        if (!list[j][k].getContent().equalsIgnoreCase("")) {
                            Element cell = documentXML.createElement(this.tags[2]);
                            cell.setAttribute("number", list[j][k].toString());
                            cell.setIdAttribute("number", true);
                            spreadSheet.appendChild(cell);

                            //Sprint 3
                            Element content = documentXML.createElement(this.tags[3]);

                            if (list[j][k].getFormula() != null) {
                                Element formula = documentXML.createElement("Formula");
                                cell.appendChild(formula);

                                Element expression = documentXML.createElement("Expression");
                                String f = (String) list[j][k].getFormula().getExpression().evaluate().toString();
                                expression.appendChild(documentXML.createTextNode(f));
                                formula.appendChild(expression);
                                content.appendChild(formula);
                            } else {
                                content.appendChild(documentXML.createTextNode(list[j][k].getContent()));
                            }
                            cell.appendChild(content);

                            Element column = documentXML.createElement(this.tags[4]);
                            String v = Integer.toString(list[j][k].getAddress().getColumn() + 1);
                            column.appendChild(documentXML.createTextNode(v));
                            cell.appendChild(column);

                            Element row = documentXML.createElement(this.tags[5]);
                            String v1 = Integer.toString(list[j][k].getAddress().getRow() + 1);
                            row.appendChild(documentXML.createTextNode(v1));
                            cell.appendChild(row);

                        }
                        saveImages(list[j][k], documentXML, spreadSheet);
                        saveComments(list[j][k], documentXML, spreadSheet);
                    }
                }

                //Sprint 3
                saveGlobalVariables(s, documentXML, spreadSheet);
            }

            //Sprint 3
            saveMacros(root, documentXML);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");//added in sprint 2
            DOMSource documentFont = new DOMSource(documentXML);

            StreamResult finalDocument = new StreamResult(this.path);

            transformer.transform(documentFont, finalDocument);
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(CreateXML.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IllegalValueTypeException ex) {
            Logger.getLogger(CreateXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreateXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Create xml Worksheets file
     *
     * @param numberWorksheets number of worksheets to export
     */
    public void exportWorksheet(List<Integer> numberWorksheets) {

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documentXML = documentBuilder.newDocument();

            Element root = documentXML.createElement(this.tags[0]);
            documentXML.appendChild(root);
            appendTags(documentXML, root); //added in sprint 2

            for (int i = 0; i < numberWorksheets.size(); i++) {
                Element spreadSheet = documentXML.createElement(this.tags[1]);
                spreadSheet.setAttribute("number", Integer.toString(i + 1)); //added in sprint 2
                root.appendChild(spreadSheet);

                Spreadsheet s = this.workbook.getSpreadsheet(i);

                //rows deleted in sprint 2
                SpreadsheetTable st = new SpreadsheetTable(s, this.controller);
                st.selectAll();
                Cell[][] list = st.getSelectedCells();

                for (int j = 0; j < list.length; j++) {
                    for (int k = 0; k < list[0].length; k++) {
                        if (!list[j][k].getContent().equalsIgnoreCase("")) {
                            Element cell = documentXML.createElement(this.tags[2]);
                            cell.setAttribute("number", list[j][k].toString());
                            cell.setIdAttribute("number", true);
                            spreadSheet.appendChild(cell);

                            //Sprint 3
                            Element content = documentXML.createElement(this.tags[3]);
                            if (list[j][k].getFormula() != null) {
                                Element formula = documentXML.createElement("Formula");
                                cell.appendChild(formula);

                                Element expression = documentXML.createElement("Expression");
                                String f = (String) list[j][k].getFormula().getExpression().evaluate().toString();
                                expression.appendChild(documentXML.createTextNode(f));
                                formula.appendChild(expression);
                                content.appendChild(formula);
                            } else {
                                content.appendChild(documentXML.createTextNode(list[j][k].getContent()));
                            }
                            cell.appendChild(content);

                            Element column = documentXML.createElement(this.tags[4]);
                            String v = Integer.toString(list[j][k].getAddress().getColumn() + 1);
                            column.appendChild(documentXML.createTextNode(v));
                            cell.appendChild(column);

                            Element row = documentXML.createElement(this.tags[5]);
                            String v1 = Integer.toString(list[j][k].getAddress().getRow() + 1);
                            row.appendChild(documentXML.createTextNode(v1));
                            cell.appendChild(row);

                        }
                        saveImages(list[j][k], documentXML, spreadSheet);
                        saveComments(list[j][k], documentXML, spreadSheet);

                    }
                }

                //Sprint 3
                saveGlobalVariables(s, documentXML, spreadSheet);

            }

            //Sprint 3
            saveMacros(root, documentXML);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");//added in sprint 2
            DOMSource documentFont = new DOMSource(documentXML);
            StreamResult finalDocument = new StreamResult(this.path);
            transformer.transform(documentFont, finalDocument);
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(CreateXML.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IllegalValueTypeException ex) {
            Logger.getLogger(CreateXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreateXML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Create xml file of an part of worksheet
     *
     * @param table Spreadsheet where cells will be exported
     * @param numberPag Number of spreadsheet where cells will be exported
     */
    public void exportPartOfWorksheet(SpreadsheetTable table, int numberPag) {

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document documentXML = documentBuilder.newDocument();

            Element root = documentXML.createElement(this.tags[0]);
            documentXML.appendChild(root);
            appendTags(documentXML, root); //added in sprint 2

            Element spreadSheet = documentXML.createElement(this.tags[1]);
            spreadSheet.setAttribute("number", Integer.toString(1)); //added in sprint 2
            root.appendChild(spreadSheet);

            //rows deleted in sprint 2
            Cell[][] list = table.getSelectedCells();
            List<Cell> cellList = new ArrayList<>();

            for (int j = 0; j < list.length; j++) {
                for (int k = 0; k < list[0].length; k++) {
                    if (!list[j][k].getContent().equalsIgnoreCase("")) {
                        Element cell = documentXML.createElement(this.tags[2]);
                        cell.setAttribute("number", list[j][k].toString());
                        cell.setIdAttribute("number", true);
                        spreadSheet.appendChild(cell);

                        //Sprint 3
                        Element content = documentXML.createElement(this.tags[3]);

                        if (list[j][k].getFormula() != null) {
                            Element formula = documentXML.createElement("Formula");
                            cell.appendChild(formula);

                            Element expression = documentXML.createElement("Expression");
                            String f = (String) list[j][k].getFormula().getExpression().evaluate().toString();
                            expression.appendChild(documentXML.createTextNode(f));
                            formula.appendChild(expression);
                            content.appendChild(formula);
                        } else {
                            content.appendChild(documentXML.createTextNode(list[j][k].getContent()));
                        }
                        cell.appendChild(content);

                        Element column = documentXML.createElement(this.tags[4]);
                        String v = Integer.toString(list[j][k].getAddress().getColumn() + 1);
                        column.appendChild(documentXML.createTextNode(v));
                        cell.appendChild(column);

                        Element row = documentXML.createElement(this.tags[5]);
                        String v1 = Integer.toString(list[j][k].getAddress().getRow() + 1);
                        row.appendChild(documentXML.createTextNode(v1));
                        cell.appendChild(row);

                        cellList.add(list[j][k]);

                    }

                    saveImages(list[j][k], documentXML, spreadSheet);
                    saveComments(list[j][k], documentXML, spreadSheet);

                }
            }

            //Sprint 3
            GlobalVariableList gVList = this.workbook.findGlobalVariables();
            for (GlobalVariable gV : gVList.currentVariables()) {
                if (cellList.contains(gV.cellWhereDefined())) {
                    Element globalVariable = documentXML.createElement("Global Variable");
                    Element cell;
                    if ((cell = documentXML.getElementById(gV.cellWhereDefined().toString())) == null) {
                        cell = documentXML.createElement(this.tags[2]);
                        spreadSheet.appendChild(cell);

                        Element column = documentXML.createElement(this.tags[4]);
                        String v = Integer.toString(gV.cellWhereDefined().getAddress().getColumn() + 1);
                        column.appendChild(documentXML.createTextNode(v));
                        cell.appendChild(column);

                        Element row = documentXML.createElement(this.tags[5]);
                        String v1 = Integer.toString(gV.cellWhereDefined().getAddress().getRow() + 1);
                        row.appendChild(documentXML.createTextNode(v1));
                        cell.appendChild(row);
                    }
                    cell.appendChild(globalVariable);
                    Element name = documentXML.createElement("Global Variable Name");
                    Element value = documentXML.createElement("Global Variable Value");
                    name.appendChild(documentXML.createTextNode(gV.currentGlobalVariableName()));
                    value.appendChild(documentXML.createTextNode(Double.toString(gV.currentGlobalVariableValue().toDouble())));
                    globalVariable.appendChild(name);
                    globalVariable.appendChild(value);
                }
            }

            //Sprint 3
            saveMacros(root, documentXML);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //added in sprint 2
            DOMSource documentFont = new DOMSource(documentXML);
            StreamResult finalDocument = new StreamResult(path);
            transformer.transform(documentFont, finalDocument);
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(CreateXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalValueTypeException ex) {
            Logger.getLogger(CreateXML.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreateXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method was added in sprint 2 due to the need of including the tags
     * of the xml document for further import mechanisms. (added by 1150466)
     *
     * @param documentXML the xml document object
     * @param element the element to which will be added the tags
     */
    public void appendTags(Document documentXML, Element element) {
        Element tags = documentXML.createElement("tags");
        tags.setAttribute("tags", "tags");
        Element workbook_tag = documentXML.createElement("workbook_tag");
        workbook_tag.setTextContent(this.tags[0]);
        tags.appendChild(workbook_tag);

        Element worksheet_tag = documentXML.createElement("worksheet_tag");
        worksheet_tag.setTextContent(this.tags[1]);
        tags.appendChild(worksheet_tag);

        Element cell_tag = documentXML.createElement("cell_tag");
        cell_tag.setTextContent(this.tags[2]);
        tags.appendChild(cell_tag);

        Element content_tag = documentXML.createElement("content_tag");
        content_tag.setTextContent(this.tags[3]);
        tags.appendChild(content_tag);

        Element column_tag = documentXML.createElement("column_tag");
        column_tag.setTextContent(this.tags[4]);
        tags.appendChild(column_tag);

        Element row_tag = documentXML.createElement("row_tag");
        row_tag.setTextContent(this.tags[5]);
        tags.appendChild(row_tag);

        Element image_tag = documentXML.createElement("image_tag");
        image_tag.setTextContent("Image");
        tags.appendChild(image_tag);

        Element formula_tag = documentXML.createElement("formula_tag");
        formula_tag.setTextContent("Formula");
        tags.appendChild(formula_tag);

        Element expression_tag = documentXML.createElement("expression_tag");
        expression_tag.setTextContent("Expression");
        tags.appendChild(expression_tag);

        Element macro_tag = documentXML.createElement("macro_tag");
        macro_tag.setTextContent("Macro");
        tags.appendChild(macro_tag);

        Element script_tag = documentXML.createElement("script_tag");
        script_tag.setTextContent("Script");
        tags.appendChild(script_tag);

        Element globalVariable_tag = documentXML.createElement("global_variable_tag");
        globalVariable_tag.setTextContent("Global_Variable");
        tags.appendChild(globalVariable_tag);

        Element globalVariableName_tag = documentXML.createElement("global_variable_name_tag");
        globalVariableName_tag.setTextContent("Global_Variable_Name");
        tags.appendChild(globalVariableName_tag);

        Element globalVariableValue_tag = documentXML.createElement("global_variable_value_tag");
        globalVariableValue_tag.setTextContent("Global_Variable_Value");
        tags.appendChild(globalVariableValue_tag);

        Element macroParameter_tag = documentXML.createElement("macro_parameter_tag");
        macroParameter_tag.setTextContent("Macro_Parameter");
        tags.appendChild(macroParameter_tag);
        
        Element comment_tag = documentXML.createElement("comment_tag");
        comment_tag.setTextContent("Comment");
        tags.appendChild(comment_tag);

        element.appendChild(tags);
    }

}
