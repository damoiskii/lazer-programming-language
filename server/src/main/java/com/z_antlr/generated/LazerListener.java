package com.z_antlr.generated;


// Generated from /home/damoiskii/VSCodeProjects/lazer-programming-language/server/src/main/antlr4/com/antlr/code//Lazer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LazerParser}.
 */
public interface LazerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LazerParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(LazerParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LazerParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(LazerParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(LazerParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(LazerParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(LazerParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(LazerParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(LazerParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(LazerParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Abstraction}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAbstraction(LazerParser.AbstractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Abstraction}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAbstraction(LazerParser.AbstractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Application}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterApplication(LazerParser.ApplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Application}
	 * labeled alternative in {@link LazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitApplication(LazerParser.ApplicationContext ctx);
}
