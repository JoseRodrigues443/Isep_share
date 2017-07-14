// Generated from lapr4/blue/s3/lang/n1150433/formula/compiler/Formula4.g4 by ANTLR 4.7

    package lapr4.blue.s3.lang.n1150433.formula.compiler;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Formula4Parser}.
 */
public interface Formula4Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Formula4Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Formula4Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#money_expression}.
	 * @param ctx the parse tree
	 */
	void enterMoney_expression(Formula4Parser.Money_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#money_expression}.
	 * @param ctx the parse tree
	 */
	void exitMoney_expression(Formula4Parser.Money_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#moneys}.
	 * @param ctx the parse tree
	 */
	void enterMoneys(Formula4Parser.MoneysContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#moneys}.
	 * @param ctx the parse tree
	 */
	void exitMoneys(Formula4Parser.MoneysContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#money_operation}.
	 * @param ctx the parse tree
	 */
	void enterMoney_operation(Formula4Parser.Money_operationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#money_operation}.
	 * @param ctx the parse tree
	 */
	void exitMoney_operation(Formula4Parser.Money_operationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Formula4Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Formula4Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(Formula4Parser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(Formula4Parser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#concatenation}.
	 * @param ctx the parse tree
	 */
	void enterConcatenation(Formula4Parser.ConcatenationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#concatenation}.
	 * @param ctx the parse tree
	 */
	void exitConcatenation(Formula4Parser.ConcatenationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#for_loop}.
	 * @param ctx the parse tree
	 */
	void enterFor_loop(Formula4Parser.For_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#for_loop}.
	 * @param ctx the parse tree
	 */
	void exitFor_loop(Formula4Parser.For_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#while_loop}.
	 * @param ctx the parse tree
	 */
	void enterWhile_loop(Formula4Parser.While_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#while_loop}.
	 * @param ctx the parse tree
	 */
	void exitWhile_loop(Formula4Parser.While_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(Formula4Parser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(Formula4Parser.EvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(Formula4Parser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(Formula4Parser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(Formula4Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(Formula4Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(Formula4Parser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(Formula4Parser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(Formula4Parser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(Formula4Parser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Formula4Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(Formula4Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Formula4Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(Formula4Parser.LiteralContext ctx);
}