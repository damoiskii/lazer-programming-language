// Generated from /home/damoiskii/VSCodeProjects/lazer-programming-language/server/src/main/antlr4/com/antlr/code/LTSLazer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LTSLazerParser}.
 */
public interface LTSLazerListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LTSLazerParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(LTSLazerParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LTSLazerParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(LTSLazerParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link LTSLazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(LTSLazerParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link LTSLazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(LTSLazerParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link LTSLazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVariable(LTSLazerParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link LTSLazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVariable(LTSLazerParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Number}
	 * labeled alternative in {@link LTSLazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(LTSLazerParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Number}
	 * labeled alternative in {@link LTSLazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(LTSLazerParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link LTSLazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOperation(LTSLazerParser.OperationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Operation}
	 * labeled alternative in {@link LTSLazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOperation(LTSLazerParser.OperationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Abstraction}
	 * labeled alternative in {@link LTSLazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAbstraction(LTSLazerParser.AbstractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Abstraction}
	 * labeled alternative in {@link LTSLazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAbstraction(LTSLazerParser.AbstractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Application}
	 * labeled alternative in {@link LTSLazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterApplication(LTSLazerParser.ApplicationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Application}
	 * labeled alternative in {@link LTSLazerParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitApplication(LTSLazerParser.ApplicationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LTSLazerParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(LTSLazerParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LTSLazerParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(LTSLazerParser.OperatorContext ctx);
}