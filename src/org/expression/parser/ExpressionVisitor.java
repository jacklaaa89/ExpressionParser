// Generated from Expression.g4 by ANTLR 4.5.1

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
	 * Visit a parse tree produced by {@link ExpressionParser#ex}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEx(ExpressionParser.ExContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(ExpressionParser.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFile(ExpressionParser.FileContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ExpressionParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpr(ExpressionParser.NewExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(ExpressionParser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code instanceofExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceofExpr(ExpressionParser.InstanceofExprContext ctx);
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
	 * Visit a parse tree produced by the {@code ternaryExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpr(ExpressionParser.TernaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code incDecExpr}
	 * labeled alternative in {@link ExpressionParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncDecExpr(ExpressionParser.IncDecExprContext ctx);
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
	 * Visit a parse tree produced by {@link ExpressionParser#incDecExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncDecExpression(ExpressionParser.IncDecExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#prefixOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOperation(ExpressionParser.PrefixOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#instanceOfExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceOfExpression(ExpressionParser.InstanceOfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#controlStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStatement(ExpressionParser.ControlStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#logicalOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOperation(ExpressionParser.LogicalOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#forcedLogicalOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForcedLogicalOperation(ExpressionParser.ForcedLogicalOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#newStructure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewStructure(ExpressionParser.NewStructureContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#ternary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernary(ExpressionParser.TernaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#forLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(ExpressionParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#whileLoop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(ExpressionParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(ExpressionParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#elseifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseifStatement(ExpressionParser.ElseifStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#elseStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStatement(ExpressionParser.ElseStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#arrayAccess}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccess(ExpressionParser.ArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(ExpressionParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(ExpressionParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#index}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndex(ExpressionParser.IndexContext ctx);
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
	 * Visit a parse tree produced by {@link ExpressionParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(ExpressionParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#procedureParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureParams(ExpressionParser.ProcedureParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#procedure}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedure(ExpressionParser.ProcedureContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpressionParser#procedureReturnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcedureReturnType(ExpressionParser.ProcedureReturnTypeContext ctx);
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