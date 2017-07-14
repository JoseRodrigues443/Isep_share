/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csheets.core.formula.compiler;

import csheets.core.Cell;
import csheets.core.Value;
import csheets.core.formula.BinaryOperation;
import csheets.core.formula.BinaryOperator;
import csheets.core.formula.Expression;
import csheets.core.formula.Function;
import csheets.core.formula.FunctionCall;
import csheets.core.formula.Literal;
import csheets.core.formula.Reference;
import csheets.core.formula.UnaryOperation;
import csheets.core.formula.lang.CellReference;
import csheets.core.formula.lang.MacroLanguage;
import csheets.core.formula.lang.RangeReference;
import csheets.core.formula.lang.ReferenceOperation;
import lapr4.green.s1.lang.n1150835.temporaryVariables.domain.TemporaryVariableRepository;
import csheets.core.formula.lang.UnknownElementException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariable;
import lapr4.red.s2.lang.n1141114.temporaryVariables.domain.TemporaryVariableList;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

/**
 *
 * @author Catarina Sousa 1150767
 */
public class MacroExpressionCompiler implements Serializable{
    
        /** The character that signals that a cell's content is a formula ('=') */
	public static final char FORMULA_STARTER = '=';
        
        
        TemporaryVariableRepository repo = new TemporaryVariableRepository();

	/**
	 * Creates the Excel expression compiler.
	 */
	public MacroExpressionCompiler() {}

	public char getStarter() {
		return FORMULA_STARTER;
	}

	public Expression compile(Cell cell, String source,TemporaryVariableList list) throws FormulaCompilationException {                
		// Creates the lexer and parser
		ANTLRStringStream input = new ANTLRStringStream(source);
		
		// create the buffer of tokens between the lexer and parser 
		MacroFormulaLexer lexer=new MacroFormulaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		MacroFormulaParser parser = new MacroFormulaParser(tokens);
		
		CommonTree tree = null;	
	
		try {
			// Attempts to match an expression
			tree=(CommonTree)parser.expression().getTree();
		}
		catch (RecognitionException e) {
	    	//String message="Fatal recognition exception " + e.getClass().getName()+ " : " + e;
	    	String message=parser.getErrorMessage(e, parser.tokenNames);
	    	throw new FormulaCompilationException("At ("+e.line+";"+e.charPositionInLine+"): "+message);
	    } catch (Exception e) {
	    	String message="Other exception : " + e.getMessage();
	    	throw new FormulaCompilationException(message);
	    } 
		
		// Converts the expression and returns it
		return convert(cell, tree,list);
	}

	/**
	 * Converts the given ANTLR AST to an expression.
         * @param cell cell
	 * @param node the abstract syntax tree node to convert
	 * @return the result of the conversion
         * @throws csheets.core.formula.compiler.FormulaCompilationException exception
	 */
	protected Expression convert(Cell cell, Tree node,TemporaryVariableList list) throws FormulaCompilationException {
		// System.out.println("Converting node '" + node.getText() + "' of tree '" + node.toStringTree() + "' with " + node.getNumberOfChildren() + " children.");
		if (node.getChildCount() == 0) {
			try {
				switch (node.getType()) {
					case MacroFormulaLexer.NUMBER:
						return new Literal(Value.parseNumericValue(node.getText()));
					case MacroFormulaLexer.STRING:
						return new Literal(Value.parseValue(node.getText(), Value.Type.BOOLEAN, Value.Type.DATE));
					case MacroFormulaLexer.CELL_REF:
						return new CellReference(cell.getSpreadsheet(), node.getText());
                                        case MacroFormulaLexer.TEMPVAR:
                                            TemporaryVariable temp = list.returnVariable(node.getText());
                                            return new Literal(temp.currentVariableValue());
                                            
                                        case MacroFormulaLexer.COMMENT:
                                                return null;
				}
			} catch (ParseException e) {
				throw new FormulaCompilationException(e);
			}
		}
                
		// Convert function call
		Function function = null;
		try {
			function = MacroLanguage.getInstance().getFunction(node.getText());
		} catch (UnknownElementException e) {}

		if (function != null) {
			List<Expression> args = new ArrayList<Expression>();
			Tree child = node.getChild(0);
			if (child != null) {
				for (int nChild=0; nChild<node.getChildCount(); ++nChild) {
					child = node.getChild(nChild);
					args.add(convert(cell, child,list));
				}
			}
			Expression[] argArray = args.toArray(new Expression[args.size()]);
			return new FunctionCall(function, argArray);
		}

		if (node.getChildCount() == 1)
			// Convert unary operation
			return new UnaryOperation(
				MacroLanguage.getInstance().getUnaryOperator(node.getText()),
				convert(cell, node.getChild(0),list)
			);
		else if (node.getChildCount() == 2) {
			// Convert binary operation
			BinaryOperator operator = MacroLanguage.getInstance().getBinaryOperator(node.getText());
			if (operator instanceof RangeReference)
				return new ReferenceOperation(
					(Reference)convert(cell, node.getChild(0),list),
					(RangeReference)operator,
					(Reference)convert(cell, node.getChild(1),list)
				);
			else 
				return new BinaryOperation(
					convert(cell, node.getChild(0),list),
					operator,
					convert(cell, node.getChild(1),list)
				);
		}  else
			// Shouldn't happen
			throw new FormulaCompilationException();
        }
}
