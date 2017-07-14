// Generated from lapr4/red/s2/lang/n1151117/formula/compiler/Formula3.g4 by ANTLR 4.7

    package lapr4.red.s2.lang.n1151117.formula.compiler;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Formula3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Formula3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Formula3Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#money_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoney_expression(Formula3Parser.Money_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#moneys}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoneys(Formula3Parser.MoneysContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#money_operation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMoney_operation(Formula3Parser.Money_operationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(Formula3Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(Formula3Parser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#concatenation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcatenation(Formula3Parser.ConcatenationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#for_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_loop(Formula3Parser.For_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(Formula3Parser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(Formula3Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(Formula3Parser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(Formula3Parser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link Formula3Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(Formula3Parser.LiteralContext ctx);
}