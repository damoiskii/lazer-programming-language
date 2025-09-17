package com.z_antlr.generated;


// Generated from /home/damoiskii/VSCodeProjects/lazer-programming-language/server/src/main/antlr4/com/antlr/code//Lazer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LazerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LazerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LazerParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(LazerParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(LazerParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(LazerParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(LazerParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Abstraction}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstraction(LazerParser.AbstractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Application}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplication(LazerParser.ApplicationContext ctx);
}
