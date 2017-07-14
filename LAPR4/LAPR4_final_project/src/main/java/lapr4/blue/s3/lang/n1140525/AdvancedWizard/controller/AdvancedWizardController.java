/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr4.blue.s3.lang.n1140525.AdvancedWizard.controller;

import csheets.core.Cell;
import csheets.core.IllegalValueTypeException;
import csheets.core.Value;
import static csheets.core.Value.Type.BOOLEAN;
import static csheets.core.Value.Type.NUMERIC;
import csheets.core.Workbook;
import csheets.core.formula.Formula;
import csheets.core.formula.compiler.FormulaCompilationException;
import lapr4.green.s1.lang.n1150605.functionBasicWizard.ui.FunctionBasicWizardController;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionParameter;
import csheets.core.formula.compiler.FormulaCompiler;
import csheets.core.formula.compiler.FormulaLexer;
import csheets.core.formula.compiler.FormulaParser;
import csheets.core.formula.compiler.MacroFormulaLexer;
import csheets.core.formula.compiler.MacroFormulaParser;
import csheets.core.formula.lang.Language;
import csheets.ui.ctrl.UIController;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import lapr4.blue.s3.lang.n1140525.AdvancedWizard.ui.AdvancedWizardUI;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenSource;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.TokenStream;

/**
 *
 * @author MariaJoão
 */
public class AdvancedWizardController extends FunctionBasicWizardController{
    
    private String baseFunction;    
    private UIController uic;
    private AdvancedWizardUI advancedUI;
    private String formula;
    private String result;
    private String description;
    private String syntax;
    private String[] params;
    private String separator;    
    private FunctionParameter[] parameters;
    private Language lang;
    private Function[] functionsList = Language.getInstance().getFunctions();

    public AdvancedWizardController(AdvancedWizardUI ww, UIController uic){
        super();
        this.advancedUI = ww;
        this.uic = uic;
        this.lang = Language.getInstance();
        this.separator=";";
    }
    
    public Value cellPreview(String str) throws FormulaCompilationException{
        Workbook w=new Workbook(1);
        Cell cell=w.getSpreadsheet(0).getCell(0, 0);
        cell.setContent(str);
        return cell.getValue();
    }
    
    public boolean validateIsOperation(String valueS, FunctionParameter fp) {
        
        if(fp.getValueType().equals(BOOLEAN)){
            if(valueS.equalsIgnoreCase("true")||valueS.equalsIgnoreCase("false")){
                return true;
            }else{
                return false;
            }
           
        }
        
        if(fp.getValueType().equals(NUMERIC)){
         
            if(isNumeric(valueS)){
                return true;
            }else{
            
                String[] splitted = valueS.split("[-+*/]");
                boolean flag =true;
        
                for (String split: splitted) {
                    if(!isNumeric(split)){
                        flag=false;
                        break;
                    }
                }
        
                return flag;
            }
        }
        return false;
     }
        
    
    public boolean isNumeric(String s) {
        return s != null && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public void selectFormula(int index) {
    
        this.baseFunction = getFunctionsList()[index].getIdentifier();
        this.parameters = getFunctionsList()[index].getParameters();
        this.params = new String[getFunctionsList()[index].getParameters().length];
        this.description = getFunctionsList()[index].getDescription();
        this.syntax = getFunctionsList()[index].getSyntax();
        this.updateFormula();
    }
    
     /**
     * Updates the result
     */
    public void updateResult() {
        Value v;
        try {
            FormulaCompiler fc = FormulaCompiler.getInstance();
            Formula formula;
            
//            if(uic == null){
//                formula = fc.compile(null, this.formula);
//            } else {
                formula = fc.compile(uic.getActiveCell(), advancedUI.getJTextFormula().getText());
//            }
            //returns result of formula
            v = formula.evaluate();
            result = v.toString();
        
        } catch (FormulaCompilationException ex) {
            result = ex.toString();
            if (ex.toString().contains("mismatched input ','") || ex.toString().contains("mismatched input ':'") || ex.toString().contains("mismatched input ';'")) {
                result += "";
            }
        } catch (IllegalValueTypeException ex) {
            result = ex.toString();
        }
        if (advancedUI != null) {
            this.advancedUI.updateResult(result);
        }
    }
    
    
    public void updateFormula() {
    
        formula = new String();
        formula = "=" + baseFunction + "(";
        for (int i = 0; i < params.length; i++) {
            formula += params[i];
            if (i != params.length - 1) {
                formula += " " + separator + " ";
            }
        }
        formula += ")";
        if (advancedUI != null) {
            this.advancedUI.setFormula(formula);
        }
        //this.updateResult();
    }
    
    public boolean checkValidPosition(String text, int pos){
         String []c1=text.split("(?!^)");
         String before=c1[pos-1];

        if(before.equals("*")||before.equals("+")||before.equals("-")||before.equals("/")){
            return true;
        }else if(before.equals("(")){
            return true;
        }
        return false;
    }
    
    public Function getFuncByPos(int i){
        return this.functionsList[i];
    }
    
    /**
     * @return the baseFunction
     */
    public String getBaseFunction() {
        return baseFunction;
    }

    /**
     * @param baseFunction the baseFunction to set
     */
    public void setBaseFunction(String baseFunction) {
        this.baseFunction = baseFunction;
    }

    /**
     * @return the uic
     */
    public UIController getUic() {
        return uic;
    }

    /**
     * @param uic the uic to set
     */
    public void setUic(UIController uic) {
        this.uic = uic;
    }

    /**
     * @return the advancedUI
     */
    public AdvancedWizardUI getAdvancedUI() {
        return advancedUI;
    }

    /**
     * @param advancedUI the advancedUI to set
     */
    public void setAdvancedUI(AdvancedWizardUI advancedUI) {
        this.advancedUI = advancedUI;
    }

    /**
     * @return the formula
     */
    public String getFormula() {
        return formula;
    }

    /**
     * @param formula the formula to set
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the syntax
     */
    public String getSyntax() {
        return syntax;
    }

    /**
     * @param syntax the syntax to set
     */
    public void setSyntax(String syntax) {
        this.syntax = syntax;
    }

    /**
     * @return the params
     */
    public String[] getParams() {
        return params;
    }

    /**
     * @param params the params to set
     */
    public void setParams(String[] params) {
        this.params = params;
    }

    /**
     * @return the parameters
     */
    public FunctionParameter[] getParameters() {
        return parameters;
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(FunctionParameter[] parameters) {
        this.parameters = parameters;
    }

    /**
     * @return the lang
     */
    public Language getLang() {
        return lang;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(Language lang) {
        this.lang = lang;
    }

    /**
     * @return the functionsList
     */
    public Function[] getFunctionsList() {
        return functionsList;
    }

    /**
     * @param functionsList the functionsList to set
     */
    public void setFunctionsList(Function[] functionsList) {
        this.functionsList = functionsList;
    }

    public boolean checkIsParameter(String selected, String sintax) {
        //possible options that a parameter can be in a sintax
        String opt1="("+selected+")";
        String opt2="("+selected+",";
        String opt3=", "+selected+")";
        String opt4=", "+selected+",";

        if(sintax.contains(opt1)||sintax.contains(opt2)||
                sintax.contains(opt3)||sintax.contains(opt4)){
            return true;
            
        }
        return false;
    }

    public boolean checkIsOpp(String opp) {

        if(opp.equals("*")||opp.equals("+")||opp.equals("-")||opp.equals("/")){
            
            return true;
        }
        
        return false;
    }

    public boolean checkValidPositionOpp(String s1, int mousePosition) {
         String []c1=s1.split("(?!^)");
         String before=c1[mousePosition-1];
        if(before.equals(")")){
            return true;
        }
        return false;    }

    public CommonTree getTreeSource(String formula) {
        ANTLRStringStream input = new ANTLRStringStream(formula);
        MacroFormulaLexer lexer = new MacroFormulaLexer(input);
        CommonTokenStream token = new CommonTokenStream((TokenSource) lexer);
        MacroFormulaParser parser = new MacroFormulaParser(token);
        try {
            CommonTree ast = (CommonTree) parser.expression().getTree();
            return ast;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        
        return null;
    }

    public void generateTree(CommonTree ctree, JTree tree) {
        
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        walkTree(ctree, root);
        model.nodeStructureChanged(root);    
    }

    private void walkTree(CommonTree ctree, DefaultMutableTreeNode root) {
        if (ctree == null) {
            return;
        }
        DefaultMutableTreeNode tn;
        for (int i = 0; i < ctree.getChildCount(); i++) {
            tn = new DefaultMutableTreeNode(ctree.getChild(i).getText());
            root.add(tn);
            if (ctree.getChild(i).getChildCount() > 0) {
                walkTree((CommonTree) ctree.getChild(i), tn);
            }
        }    }

    
}
