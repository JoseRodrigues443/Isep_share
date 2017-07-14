// Generated from lapr4/blue/s3/lang/n1150433/formula/compiler/Formula4.g4 by ANTLR 4.7

    package lapr4.blue.s3.lang.n1150433.formula.compiler;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Formula4Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Formula4Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Formula4Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#money_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoney_expression(Formula4Parser.Money_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#moneys}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoneys(Formula4Parser.MoneysContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#money_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoney_operation(Formula4Parser.Money_operationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(Formula4Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(Formula4Parser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#concatenation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenation(Formula4Parser.ConcatenationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#for_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_loop(Formula4Parser.For_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#while_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_loop(Formula4Parser.While_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#eval}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEval(Formula4Parser.EvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(Formula4Parser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(Formula4Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(Formula4Parser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(Formula4Parser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula4Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(Formula4Parser.LiteralContext ctx);
}