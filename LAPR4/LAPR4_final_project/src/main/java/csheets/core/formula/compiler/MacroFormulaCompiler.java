/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.compiler;

import csheets.CleanSheets;
import csheets.core.Cell;
import csheets.core.formula.Expression;
import csheets.core.formula.Formula;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariableList;

/**
 *
 * @author Catarina Sousa 1150767
 */
public class MacroFormulaCompiler implements Serializable{
    
    /**
     * The singleton instance
     */
    private static final MacroFormulaCompiler instance = new MacroFormulaCompiler();
    

    /**
     * The name of the file in which compiler properties are stored
     */
    private static final String PROPERTIES_FILENAME = "res/macro_compilers.props";
    
    /**
     * The expression compilers used to compile formulas
     */
    private List<MacroExpressionCompiler> compilers = new ArrayList<>();

    
    /**
     * Creates the formula compiler.
     */
    private MacroFormulaCompiler() {
        // Loads properties
        Properties compilerProps = new Properties();
        InputStream stream = CleanSheets.class.getResourceAsStream(PROPERTIES_FILENAME);
        if (stream != null) {
            try {
                compilerProps.load(stream);
            } catch (IOException e) {
                System.err.println("An I/O error occurred when loading compiler"
                        + " properties file (" + PROPERTIES_FILENAME + ").");
                return;
            } finally {
                try {
                    if (stream != null) {
                        stream.close();
                    }
                } catch (IOException e) {
                }
            }

            // Loads elements
            for (Object className : compilerProps.keySet()) {
                // Loads class and instantiates element
                Class elementClass;
                Object element;
                try {
                    elementClass = Class.forName(getClass().getPackage()
                            .getName() + "." + (String) className);
                    element = elementClass.newInstance();
                } catch (Exception e) {
                    // Skip this element, regardless of what went wrong
                    e.printStackTrace();
                    continue;
                }

                // Stores element
                if (MacroExpressionCompiler.class.isAssignableFrom(elementClass)) {
                    compilers.add(MacroExpressionCompiler.class.cast(element));
                }
            }
        } else {
            System.err.println("Could not find compiler properties file ("
                    + PROPERTIES_FILENAME + ").");
        }
    }
    
    /**
     * Compiles a formula for the given cell from the given string.
     *
     * @param cell the cell for which a formula is to be generated
     * @param source a string representing the formula to be compiled
     * @return a list of lexical tokens
     * @throws FormulaCompilationException if the formula could not be compiled
     */
    public Formula compile(Cell cell, String source,TemporaryVariableList list) throws FormulaCompilationException {
        for (MacroExpressionCompiler compiler : compilers) {            
                Expression expression = compiler.compile(cell, source,list);
                if (expression != null){
                    return new Formula(cell, expression);
                }else{
                    // do nothing. it's a comment
                }
        }    
        return null;
    }
    
    /**
     * Returns the singleton instance.
     *
     * @return the singleton instance
     */
    public static MacroFormulaCompiler getInstance() {
        return instance;
    }
    
}
