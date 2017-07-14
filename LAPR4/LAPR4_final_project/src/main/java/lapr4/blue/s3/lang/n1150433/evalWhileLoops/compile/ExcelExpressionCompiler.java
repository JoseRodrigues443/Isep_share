/*
 * Copyright (c) 2005 Einar Pehrson <einar@pehrson.nu>.
 *
 * This file is part of
 * CleanSheets - a spreadsheet application for the Java platform.
 *
 * CleanSheets is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * CleanSheets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CleanSheets; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 * ATB (April, 2014): Updated to use antlr3 generated parser and lexer
 * JRT (May, 2017): Uptated to use antlr4
 */
package lapr4.blue.s3.lang.n1150433.evalWhileLoops.compile;

import lapr4.red.s2.lang.n1151117.formula.compiler.*;
import lapr4.gray.s1.lang.n3456789.formula.compiler.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;

import csheets.core.Cell;
import csheets.core.formula.Expression;
import csheets.core.formula.compiler.ExpressionCompiler;
import csheets.core.formula.compiler.FormulaCompilationException;
import java.util.Collections;
import java.util.List;
import lapr4.blue.s3.lang.n1150433.formula.compiler.Formula4Lexer;
import lapr4.blue.s3.lang.n1150433.formula.compiler.Formula4Parser;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Recognizer;

/**
 * A compiler that generates Excel-style formulas from strings.
 *
 * @author Débora Costa - 1150433
 */
public class ExcelExpressionCompiler implements ExpressionCompiler {

    /**
     * The character that signals that a cell's content is a formula ('=')
     */
    public static final char FORMULA_STARTER = '=';
    public static final char MONEY_STARTER = '#';

    /**
     * Creates the Excel expression compiler.
     */
    public ExcelExpressionCompiler() {
    }

    @Override
    public char getStarter() {
        return FORMULA_STARTER;
    }

    @Override
    public char getMoneyStarter() {
        return MONEY_STARTER;
    }


    @Override
    public Expression compile(Cell cell, String source) throws FormulaCompilationException {
        // Creates the lexer and parser
        ANTLRInputStream input = new ANTLRInputStream(source);

        // create the buffer of tokens between the lexer and parser 
        Formula4Lexer lexer = new Formula4Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        Formula4Parser parser = new Formula4Parser(tokens);

        FormulaErrorListener formulaErrorListener = new FormulaErrorListener();
        parser.removeErrorListeners(); // remove default ConsoleErrorListener
        parser.addErrorListener(formulaErrorListener); // add ours

        // Attempts to match an expression
        ParseTree tree = parser.expression();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            throw new FormulaCompilationException(formulaErrorListener.getErrorMessage());
        }

        // Visit the expression and returns it
        FormulaEvalVisitor eval = new FormulaEvalVisitor(cell);
        Expression result = eval.visit(tree);
        if (eval.getNumberOfErrors() > 0) {
            throw new FormulaCompilationException(eval.getErrorsMessage());
        }

        return result;
    }
    
    public static class FormulaErrorListener extends BaseErrorListener {

        private StringBuilder buf;

        public String getErrorMessage() {
            return buf.toString();
        }

        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                Object offendingSymbol,
                int line, int charPositionInLine,
                String msg,
                RecognitionException e) {
            List<String> stack = ((Parser) recognizer).getRuleInvocationStack();
            Collections.reverse(stack);

            buf = new StringBuilder();
            buf.append("line ").append(line).append(":").append(charPositionInLine).append(": ").append(msg);
        }
    }
}
