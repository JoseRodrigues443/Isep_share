/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.red.s2.lang.n1150710.BeanShell.Integration;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 1150710@isep.ipp.pt
 */
public class BeanShellScriptList implements Serializable {

    /**
     * list with all scripts created
     */
    private ArrayList<BeanShellScript> beanShellScripts;

    private static final String PATH_OF_SAVED_LIST_DEFAULT = "./beanShellScript.bin";
    private final static String NAME_REGEX_DEFAULT = "[a-zA-Z_-]*";

    /**
     * default constructor
     */
    public BeanShellScriptList() {
        beanShellScripts = new ArrayList<>();
        importObject();
        if (beanShellScripts.isEmpty()) {
            fillData();
        }
    }

    public BeanShellScriptList(ArrayList<BeanShellScript> beanShellScripts) {
        this.beanShellScripts = beanShellScripts;
    }

    public ArrayList<BeanShellScript> getBeanShellScripts() {
        return beanShellScripts;
    }

    public void setBeanShellScripts(ArrayList<BeanShellScript> beanShellScripts) {
        this.beanShellScripts = beanShellScripts;
    }

    /**
     * add if does not exist
     *
     * @param e
     * @return
     */
    public boolean add(BeanShellScript e) {
        if (this.beanShellScripts.contains(e)) {
            return false;
        }
        if (!e.getScriptName().matches(NAME_REGEX_DEFAULT)) {
            throw new IllegalArgumentException("Script name does not meet the regex requirements");
        }
        return beanShellScripts.add(e);
    }

    public BeanShellScript get(int i) {
        return beanShellScripts.get(i);
    }

    /**
     * saves this object to an serializable/bin file
     *
     * @return
     */
    public boolean saveThisObject() {
        return ImportExportUtils.saveFile(PATH_OF_SAVED_LIST_DEFAULT, this);
    }

    /**
     * import the serializable file to the beanShellScripts variable
     */
    public void importObject() {
        BeanShellScriptList bssl = (BeanShellScriptList) ImportExportUtils.importFile(PATH_OF_SAVED_LIST_DEFAULT);
        if (bssl != null) {
            this.beanShellScripts = bssl.getBeanShellScripts();
        }
    }

    /**
     * deletes the serializable file
     */
    public void removeFile() {
        File f = new File(PATH_OF_SAVED_LIST_DEFAULT);
        ImportExportUtils.deleteFile(f.toPath());
    }

    private void removeAll() {
        for (BeanShellScript beanShellScript : this.beanShellScripts) {
            this.beanShellScripts.remove(beanShellScript);
        }
    }

    /**
     * generates scripts and adds to the list of scripts
     */
    public void fillData() {

        add(new BeanShellScript("macroFivePlusFive",
                "Example to create  macro that sums two numbers",
                "import csheets.core.Address;\n"
                + "import csheets.core.Value;\n"
                + "import csheets.core.Workbook;\n"
                + "import csheets.core.formula.lang.Macro;\n"
                + "\n"
                + "Workbook workbookParameter = new Workbook(1);\n"
                + "Macro macroParameter = new Macro(workbookParameter.getSpreadsheet(0).getCell(new Address(0, 0)),\"5+5\");\n"
                + "String result = macroParameter.execute();\n"
                + "Value v = new Value(result);\n"
                + "return v;"));
        add(new BeanShellScript("simpleSystemOut",
                "Example to create a simples system out",
                "System.out.println(\"--> Simple system out example\");"));
        add(new BeanShellScript("simpleFactorilMacro",
                "Generates the macro tahat calculates factorial of 5",
                "import csheets.core.Address;\n"
                + "import csheets.core.Value;\n"
                + "import csheets.core.Workbook;\n"
                + "import csheets.core.formula.lang.Macro;\n"
                + "\n"
                + "Workbook workbookParameter = new Workbook(1);\n"
                + "Macro macroParameter = new Macro(workbookParameter.getSpreadsheet(0).getCell(new Address(0, 0)),\"=fact(5)\");\n"
                + "String result = macroParameter.execute();\n"
                + "Value v = new Value(result);\n"
                + "return v;"));
        add(new BeanShellScript("TestAPI", "Example that it is not necessary to create objects because they are already created",
                "import csheets.core.Address;\n"
                + "import csheets.core.Value;\n"
                + "import csheets.core.Workbook;\n"
                + "import csheets.core.Spreadsheets;\n"
                + "import csheets.core.Cell;\n"
                + "import csheets.core.formula.lang.Macro;\n"
                + "\n"
                + "macro = new Macro(workbook.getSpreadsheet(0).getCell(new Address(0, 0)),\"5+5*5\");\n"
                + "JOptionPane.showMessageDialog(null, \"Cell: \"+cell.toString());\n"
                + "JOptionPane.showMessageDialog(null, \"Spreadsheet:\"+ spreadsheet.toString());\n"
                + "JOptionPane.showMessageDialog(null, \"Workbook:\"+ workbook.toString());\n"
                + "JOptionPane.showMessageDialog(null, \"Macro:\"+ macro);\n"
                + "String result = macro.execute();\n"
                + "Value v = new Value(result);\n"
                + "return v;"));
    }

    public BeanShellScript remove(int i) {
        return beanShellScripts.remove(i);
    }

    public boolean remove(BeanShellScript o) {
        return beanShellScripts.remove(o);
    }

    public static boolean validateName(String name) {
        return name.matches(NAME_REGEX_DEFAULT);
    }

}
