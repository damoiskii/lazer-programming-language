// Generated from /home/damoiskii/VSCodeProjects/lazer-programming-language/server/src/main/antlr4/com/antlr/code/LTSLazer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LTSLazerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, OPAREN=2, CPAREN=3, LAMBDA=4, PLUS=5, MINUS=6, MULTIPLY=7, DIVIDE=8, 
		VARIABLE=9, NUMBER=10, WHITESPACE=11, COMMENT=12, COMMENT_MULTI=13;
	public static final int
		RULE_start = 0, RULE_expression = 1, RULE_operator = 2;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "expression", "operator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'('", "')'", "'#'", "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOT", "OPAREN", "CPAREN", "LAMBDA", "PLUS", "MINUS", "MULTIPLY", 
			"DIVIDE", "VARIABLE", "NUMBER", "WHITESPACE", "COMMENT", "COMMENT_MULTI"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LTSLazer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LTSLazerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EOF() { return getToken(LTSLazerParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			setState(12);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
			case LAMBDA:
			case PLUS:
			case MINUS:
			case MULTIPLY:
			case DIVIDE:
			case VARIABLE:
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(7); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(6);
					expression(0);
					}
					}
					setState(9); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2036L) != 0) );
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(11);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisContext extends ExpressionContext {
		public TerminalNode OPAREN() { return getToken(LTSLazerParser.OPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CPAREN() { return getToken(LTSLazerParser.CPAREN, 0); }
		public ParenthesisContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).exitParenthesis(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ExpressionContext {
		public TerminalNode VARIABLE() { return getToken(LTSLazerParser.VARIABLE, 0); }
		public VariableContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).exitVariable(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(LTSLazerParser.NUMBER, 0); }
		public NumberContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).exitNumber(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OperationContext extends ExpressionContext {
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public OperationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).exitOperation(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AbstractionContext extends ExpressionContext {
		public TerminalNode LAMBDA() { return getToken(LTSLazerParser.LAMBDA, 0); }
		public TerminalNode VARIABLE() { return getToken(LTSLazerParser.VARIABLE, 0); }
		public TerminalNode DOT() { return getToken(LTSLazerParser.DOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AbstractionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).enterAbstraction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).exitAbstraction(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ApplicationContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ApplicationContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).enterApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).exitApplication(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(15);
				match(VARIABLE);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(16);
				match(NUMBER);
				}
				break;
			case LAMBDA:
				{
				_localctx = new AbstractionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(17);
				match(LAMBDA);
				setState(18);
				match(VARIABLE);
				setState(19);
				match(DOT);
				setState(20);
				expression(4);
				}
				break;
			case OPAREN:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(21);
				match(OPAREN);
				setState(22);
				expression(0);
				setState(23);
				match(CPAREN);
				}
				break;
			case PLUS:
			case MINUS:
			case MULTIPLY:
			case DIVIDE:
				{
				_localctx = new OperationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				operator();
				setState(26);
				expression(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(34);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ApplicationContext(new ExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(30);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(31);
					expression(4);
					}
					} 
				}
				setState(36);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(LTSLazerParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(LTSLazerParser.MINUS, 0); }
		public TerminalNode DIVIDE() { return getToken(LTSLazerParser.DIVIDE, 0); }
		public TerminalNode MULTIPLY() { return getToken(LTSLazerParser.MULTIPLY, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LTSLazerListener ) ((LTSLazerListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\r(\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0001\u0000\u0004\u0000\b\b\u0000\u000b\u0000\f\u0000"+
		"\t\u0001\u0000\u0003\u0000\r\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u001d\b\u0001\u0001\u0001\u0001\u0001\u0005\u0001!\b\u0001\n\u0001\f"+
		"\u0001$\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0000\u0001\u0002"+
		"\u0003\u0000\u0002\u0004\u0000\u0001\u0001\u0000\u0005\b+\u0000\f\u0001"+
		"\u0000\u0000\u0000\u0002\u001c\u0001\u0000\u0000\u0000\u0004%\u0001\u0000"+
		"\u0000\u0000\u0006\b\u0003\u0002\u0001\u0000\u0007\u0006\u0001\u0000\u0000"+
		"\u0000\b\t\u0001\u0000\u0000\u0000\t\u0007\u0001\u0000\u0000\u0000\t\n"+
		"\u0001\u0000\u0000\u0000\n\r\u0001\u0000\u0000\u0000\u000b\r\u0005\u0000"+
		"\u0000\u0001\f\u0007\u0001\u0000\u0000\u0000\f\u000b\u0001\u0000\u0000"+
		"\u0000\r\u0001\u0001\u0000\u0000\u0000\u000e\u000f\u0006\u0001\uffff\uffff"+
		"\u0000\u000f\u001d\u0005\t\u0000\u0000\u0010\u001d\u0005\n\u0000\u0000"+
		"\u0011\u0012\u0005\u0004\u0000\u0000\u0012\u0013\u0005\t\u0000\u0000\u0013"+
		"\u0014\u0005\u0001\u0000\u0000\u0014\u001d\u0003\u0002\u0001\u0004\u0015"+
		"\u0016\u0005\u0002\u0000\u0000\u0016\u0017\u0003\u0002\u0001\u0000\u0017"+
		"\u0018\u0005\u0003\u0000\u0000\u0018\u001d\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0003\u0004\u0002\u0000\u001a\u001b\u0003\u0002\u0001\u0001\u001b"+
		"\u001d\u0001\u0000\u0000\u0000\u001c\u000e\u0001\u0000\u0000\u0000\u001c"+
		"\u0010\u0001\u0000\u0000\u0000\u001c\u0011\u0001\u0000\u0000\u0000\u001c"+
		"\u0015\u0001\u0000\u0000\u0000\u001c\u0019\u0001\u0000\u0000\u0000\u001d"+
		"\"\u0001\u0000\u0000\u0000\u001e\u001f\n\u0003\u0000\u0000\u001f!\u0003"+
		"\u0002\u0001\u0004 \u001e\u0001\u0000\u0000\u0000!$\u0001\u0000\u0000"+
		"\u0000\" \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#\u0003\u0001"+
		"\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%&\u0007\u0000\u0000\u0000"+
		"&\u0005\u0001\u0000\u0000\u0000\u0004\t\f\u001c\"";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}