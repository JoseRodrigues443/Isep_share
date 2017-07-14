// Generated from lapr4/gray/s1/lang/n3456789/formula/compiler/Formula2.g4 by ANTLR 4.7

    package lapr4.gray.s1.lang.n3456789.formula.compiler;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Formula2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Formula2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Formula2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Formula2Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula2Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(Formula2Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula2Parser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(Formula2Parser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula2Parser#concatenation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenation(Formula2Parser.ConcatenationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula2Parser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(Formula2Parser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula2Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(Formula2Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula2Parser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(Formula2Parser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula2Parser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(Formula2Parser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula2Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(Formula2Parser.LiteralContext ctx);
}