// Generated from lapr4/red/s2/lang/n1151117/formula/compiler/Formula3.g4 by ANTLR 4.7

    package lapr4.red.s2.lang.n1151117.formula.compiler;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Formula3Parser}.
 */
public interface Formula3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Formula3Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Formula3Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#money_expression}.
	 * @param ctx the parse tree
	 */
	void enterMoney_expression(Formula3Parser.Money_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#money_expression}.
	 * @param ctx the parse tree
	 */
	void exitMoney_expression(Formula3Parser.Money_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#moneys}.
	 * @param ctx the parse tree
	 */
	void enterMoneys(Formula3Parser.MoneysContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#moneys}.
	 * @param ctx the parse tree
	 */
	void exitMoneys(Formula3Parser.MoneysContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#money_operation}.
	 * @param ctx the parse tree
	 */
	void enterMoney_operation(Formula3Parser.Money_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#money_operation}.
	 * @param ctx the parse tree
	 */
	void exitMoney_operation(Formula3Parser.Money_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Formula3Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Formula3Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(Formula3Parser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(Formula3Parser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#concatenation}.
	 * @param ctx the parse tree
	 */
	void enterConcatenation(Formula3Parser.ConcatenationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#concatenation}.
	 * @param ctx the parse tree
	 */
	void exitConcatenation(Formula3Parser.ConcatenationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#for_loop}.
	 * @param ctx the parse tree
	 */
	void enterFor_loop(Formula3Parser.For_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#for_loop}.
	 * @param ctx the parse tree
	 */
	void exitFor_loop(Formula3Parser.For_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(Formula3Parser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(Formula3Parser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(Formula3Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(Formula3Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(Formula3Parser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(Formula3Parser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(Formula3Parser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(Formula3Parser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula3Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(Formula3Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula3Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(Formula3Parser.LiteralContext ctx);
}