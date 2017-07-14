/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.lang;

import csheets.CleanSheets;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Function;
import csheets.core.formula.Operator;
import csheets.core.formula.UnaryOperator;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author Catarina Sousa 1150767
 */
public class MacroLanguage implements Serializable{
    
    /** The name of the file in which language properties are stored */
    private static final String PROPERTIES_FILENAME = "res/macro_language.props";

    
    /** The singleton instance */
    private static final MacroLanguage instance = new MacroLanguage();
        
    /** The functions that are supported by the language */
    private List<Function> functions = new ArrayList<Function>();
    
    /** The unary operators that are supported by the language */
    private List<UnaryOperator> unaryOperators = new ArrayList<UnaryOperator>();
    
    /** The binary operators that are supported by the language */
    private List<BinaryOperator> binaryOperators = new ArrayList<BinaryOperator>();
    
    /**
     * Creates a new language.
     */
    private MacroLanguage() {
	// Loads properties
	Properties language = new Properties();
	InputStream stream = CleanSheets.class.getResourceAsStream(PROPERTIES_FILENAME);
	if (stream != null) {
		try {
			language.load(stream);
		} catch (IOException e) {
			System.err.println("An I/O error occurred when loading language"
				+ " properties file (" + PROPERTIES_FILENAME + ").");
			return;
		} finally {
			try {
				if (stream != null)
					stream.close();
			} catch (IOException e) {}
		}
		// Loads elements
		for (Object className : language.keySet()) {
			// Loads class and instantiates element
			Class elementClass;
			Object element;
			try {
				elementClass = Class.forName(getClass().getPackage()
					.getName() + "." + (String)className);
				element = elementClass.newInstance();
			} catch (Exception e) {
				// Skip this element, regardless of what went wrong
				continue;
			}

			// Stores element
			if (Function.class.isAssignableFrom(elementClass))
				functions.add(Function.class.cast(element));
			if (BinaryOperator.class.isAssignableFrom(elementClass))
				binaryOperators.add(BinaryOperator.class.cast(element));
			if (UnaryOperator.class.isAssignableFrom(elementClass))
				unaryOperators.add(UnaryOperator.class.cast(element));
			}
		} else
                    System.err.println("Could not find language properties file ("
			+ PROPERTIES_FILENAME + ").");

		// Loads static methods from java.lang.Math that use double precision
		for (Method method : Math.class.getMethods())
			if (Modifier.isStatic(method.getModifiers()) &&
						method.getReturnType() == Double.TYPE)
				functions.add(new NumericFunction(method));
	}
    
    /**
     * Returns the singleton instance.
     * @return the singleton instance
     */
    public static MacroLanguage getInstance() {
        return instance;
    }
    /**
     * 
     * @return 
     */
    public List<Function> functions() {
        return functions;
    }
    /**
     * 
     * @return 
     */
    public List<Operator> operators(){
        List<Operator> retList = new ArrayList<>();
        for (Operator operator : unaryOperators) {
            retList.add(operator);
        }
        for (Operator operator : binaryOperators) {
            retList.add(operator);
        }
        return retList;
    }
    /**
     * Returns the function with the given identifier.
     * @param identifier identifier
     * @return the function with the given identifier
     * @throws csheets.core.formula.lang.UnknownElementException exception
     */
    public Function getFunction(String identifier) throws UnknownElementException {
	for (Function function : functions)
        	if (identifier.equalsIgnoreCase(function.getIdentifier()))
        		return function; // .clone()
		throw new UnknownElementException(identifier);
    }
    /**
     * Returns the binary operator with the given identifier.
     * @param identifier identifier
     * @return the binary operator with the given identifier
     * @throws csheets.core.formula.lang.UnknownElementException exception
     */
    public BinaryOperator getBinaryOperator(String identifier) throws UnknownElementException {
	for (BinaryOperator operator : binaryOperators)
		if (identifier.equalsIgnoreCase(operator.getIdentifier()))
			return operator; // .clone()
	throw new UnknownElementException(identifier);
    }
    
    /**
     * Returns the unary operator with the given identifier.
     * @param identifier identifier
     * @return the unary operator with the given identifier
     * @throws csheets.core.formula.lang.UnknownElementException exception
     */
    public UnaryOperator getUnaryOperator(String identifier) throws UnknownElementException {
	for (UnaryOperator operator : unaryOperators)
		if (identifier.equalsIgnoreCase(operator.getIdentifier()))
			return operator; // .clone()
	throw new UnknownElementException(identifier);
	}
}
