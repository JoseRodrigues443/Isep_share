// Generated from lapr4/gray/s1/lang/n3456789/formula/compiler/Formula2.g4 by ANTLR 4.7

    package lapr4.gray.s1.lang.n3456789.formula.compiler;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Formula2Parser}.
 */
public interface Formula2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Formula2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Formula2Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Formula2Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula2Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Formula2Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula2Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Formula2Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula2Parser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(Formula2Parser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula2Parser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(Formula2Parser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula2Parser#concatenation}.
	 * @param ctx the parse tree
	 */
	void enterConcatenation(Formula2Parser.ConcatenationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula2Parser#concatenation}.
	 * @param ctx the parse tree
	 */
	void exitConcatenation(Formula2Parser.ConcatenationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula2Parser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(Formula2Parser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula2Parser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(Formula2Parser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(Formula2Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(Formula2Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula2Parser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(Formula2Parser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula2Parser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(Formula2Parser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula2Parser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(Formula2Parser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula2Parser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(Formula2Parser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(Formula2Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(Formula2Parser.LiteralContext ctx);
}