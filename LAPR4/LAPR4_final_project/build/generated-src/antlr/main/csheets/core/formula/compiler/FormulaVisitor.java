// Generated from csheets/core/formula/compiler/Formula.g4 by ANTLR 4.7

    package csheets.core.formula.compiler;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FormulaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FormulaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FormulaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(FormulaParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#expression_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_block(FormulaParser.Expression_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(FormulaParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#concatenation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenation(FormulaParser.ConcatenationContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(FormulaParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(FormulaParser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(FormulaParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link FormulaParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(FormulaParser.LiteralContext ctx);
}