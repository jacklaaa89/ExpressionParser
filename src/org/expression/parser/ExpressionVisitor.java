// Generated from /Users/jacktimblin/ExpressionParser/Expression.g4 by ANTLR 4.5.1

package org.expression.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ExpressionParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ExpressionParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAccessExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccessExpr(ExpressionParser.ArrayAccessExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(ExpressionParser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code opExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpExpr(ExpressionParser.OpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(ExpressionParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(ExpressionParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(ExpressionParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(ExpressionParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomValue}
	 * labeled alternative in {@link ExpressionParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomValue(ExpressionParser.AtomValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(ExpressionParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(ExpressionParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(ExpressionParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#scientific}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScientific(ExpressionParser.ScientificContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcDefinition}
	 * labeled alternative in {@link ExpressionParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDefinition(ExpressionParser.FuncDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#funcParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncParams(ExpressionParser.FuncParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(ExpressionParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(ExpressionParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#arrayInner}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayInner(ExpressionParser.ArrayInnerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#matrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrix(ExpressionParser.MatrixContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#funcName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncName(ExpressionParser.FuncNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ExpressionParser.VariableContext ctx);
}