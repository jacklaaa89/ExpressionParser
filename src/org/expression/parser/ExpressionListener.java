// Generated from /Users/jacktimblin/ExpressionParser/Expression.g4 by ANTLR 4.5.1

package org.expression.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpressionParser}.
 */
public interface ExpressionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ExpressionParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ExpressionParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ExpressionParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ExpressionParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAccessExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpr(ExpressionParser.ArrayAccessExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAccessExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpr(ExpressionParser.ArrayAccessExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(ExpressionParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(ExpressionParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOpExpr(ExpressionParser.OpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOpExpr(ExpressionParser.OpExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code incDecExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIncDecExpr(ExpressionParser.IncDecExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code incDecExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIncDecExpr(ExpressionParser.IncDecExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(ExpressionParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(ExpressionParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(ExpressionParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(ExpressionParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(ExpressionParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(ExpressionParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomValue}
	 * labeled alternative in {@link ExpressionParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtomValue(ExpressionParser.AtomValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomValue}
	 * labeled alternative in {@link ExpressionParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtomValue(ExpressionParser.AtomValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#incDecExpression}.
	 * @param ctx the parse tree
	 */
	void enterIncDecExpression(ExpressionParser.IncDecExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#incDecExpression}.
	 * @param ctx the parse tree
	 */
	void exitIncDecExpression(ExpressionParser.IncDecExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void enterControlStatement(ExpressionParser.ControlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#controlStatement}.
	 * @param ctx the parse tree
	 */
	void exitControlStatement(ExpressionParser.ControlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void enterUpdateStatement(ExpressionParser.UpdateStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#updateStatement}.
	 * @param ctx the parse tree
	 */
	void exitUpdateStatement(ExpressionParser.UpdateStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(ExpressionParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(ExpressionParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(ExpressionParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(ExpressionParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(ExpressionParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(ExpressionParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#elseifStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseifStatement(ExpressionParser.ElseifStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#elseifStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseifStatement(ExpressionParser.ElseifStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(ExpressionParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(ExpressionParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(ExpressionParser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(ExpressionParser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(ExpressionParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(ExpressionParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(ExpressionParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(ExpressionParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(ExpressionParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(ExpressionParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#scientific}.
	 * @param ctx the parse tree
	 */
	void enterScientific(ExpressionParser.ScientificContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#scientific}.
	 * @param ctx the parse tree
	 */
	void exitScientific(ExpressionParser.ScientificContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcDefinition}
	 * labeled alternative in {@link ExpressionParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFuncDefinition(ExpressionParser.FuncDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcDefinition}
	 * labeled alternative in {@link ExpressionParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFuncDefinition(ExpressionParser.FuncDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#funcParams}.
	 * @param ctx the parse tree
	 */
	void enterFuncParams(ExpressionParser.FuncParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#funcParams}.
	 * @param ctx the parse tree
	 */
	void exitFuncParams(ExpressionParser.FuncParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(ExpressionParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(ExpressionParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(ExpressionParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(ExpressionParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#arrayInner}.
	 * @param ctx the parse tree
	 */
	void enterArrayInner(ExpressionParser.ArrayInnerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#arrayInner}.
	 * @param ctx the parse tree
	 */
	void exitArrayInner(ExpressionParser.ArrayInnerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#matrix}.
	 * @param ctx the parse tree
	 */
	void enterMatrix(ExpressionParser.MatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#matrix}.
	 * @param ctx the parse tree
	 */
	void exitMatrix(ExpressionParser.MatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#funcName}.
	 * @param ctx the parse tree
	 */
	void enterFuncName(ExpressionParser.FuncNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#funcName}.
	 * @param ctx the parse tree
	 */
	void exitFuncName(ExpressionParser.FuncNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpressionParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ExpressionParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpressionParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ExpressionParser.VariableContext ctx);
}