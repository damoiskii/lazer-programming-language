// Generated from /home/damoiskii/VSCodeProjects/lazer-programming-language/server/src/main/antlr4/com/antlr/code/Lazer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LazerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, OPAREN=2, CPAREN=3, LAMBDA=4, VARIABLE=5, NUMBER=6, WHITESPACE=7, 
		COMMENT=8, COMMENT_MULTI=9;
	public static final int
		RULE_start = 0, RULE_expression = 1;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "'('", "')'", "'#'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOT", "OPAREN", "CPAREN", "LAMBDA", "VARIABLE", "NUMBER", "WHITESPACE", 
			"COMMENT", "COMMENT_MULTI"
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
	public String getGrammarFileName() { return "Lazer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LazerParser(TokenStream input) {
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
		public TerminalNode EOF() { return getToken(LazerParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			setState(10);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPAREN:
			case LAMBDA:
			case VARIABLE:
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(5); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(4);
					expression(0);
					}
					}
					setState(7); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 116L) != 0) );
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(9);
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
		public TerminalNode OPAREN() { return getToken(LazerParser.OPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CPAREN() { return getToken(LazerParser.CPAREN, 0); }
		public ParenthesisContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ExpressionContext {
		public TerminalNode VARIABLE() { return getToken(LazerParser.VARIABLE, 0); }
		public VariableContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ExpressionContext {
		public TerminalNode NUMBER() { return getToken(LazerParser.NUMBER, 0); }
		public NumberContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AbstractionContext extends ExpressionContext {
		public TerminalNode LAMBDA() { return getToken(LazerParser.LAMBDA, 0); }
		public TerminalNode VARIABLE() { return getToken(LazerParser.VARIABLE, 0); }
		public TerminalNode DOT() { return getToken(LazerParser.DOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AbstractionContext(ExpressionContext ctx) { copyFrom(ctx); }
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
			setState(23);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARIABLE:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(13);
				match(VARIABLE);
				}
				break;
			case NUMBER:
				{
				_localctx = new NumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(14);
				match(NUMBER);
				}
				break;
			case LAMBDA:
				{
				_localctx = new AbstractionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15);
				match(LAMBDA);
				setState(16);
				match(VARIABLE);
				setState(17);
				match(DOT);
				setState(18);
				expression(3);
				}
				break;
			case OPAREN:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19);
				match(OPAREN);
				setState(20);
				expression(0);
				setState(21);
				match(CPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(29);
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
					setState(25);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(26);
					expression(3);
					}
					} 
				}
				setState(31);
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
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\t!\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0001"+
		"\u0000\u0004\u0000\u0006\b\u0000\u000b\u0000\f\u0000\u0007\u0001\u0000"+
		"\u0003\u0000\u000b\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u0018\b\u0001\u0001\u0001\u0001\u0001\u0005\u0001"+
		"\u001c\b\u0001\n\u0001\f\u0001\u001f\t\u0001\u0001\u0001\u0000\u0001\u0002"+
		"\u0002\u0000\u0002\u0000\u0000$\u0000\n\u0001\u0000\u0000\u0000\u0002"+
		"\u0017\u0001\u0000\u0000\u0000\u0004\u0006\u0003\u0002\u0001\u0000\u0005"+
		"\u0004\u0001\u0000\u0000\u0000\u0006\u0007\u0001\u0000\u0000\u0000\u0007"+
		"\u0005\u0001\u0000\u0000\u0000\u0007\b\u0001\u0000\u0000\u0000\b\u000b"+
		"\u0001\u0000\u0000\u0000\t\u000b\u0005\u0000\u0000\u0001\n\u0005\u0001"+
		"\u0000\u0000\u0000\n\t\u0001\u0000\u0000\u0000\u000b\u0001\u0001\u0000"+
		"\u0000\u0000\f\r\u0006\u0001\uffff\uffff\u0000\r\u0018\u0005\u0005\u0000"+
		"\u0000\u000e\u0018\u0005\u0006\u0000\u0000\u000f\u0010\u0005\u0004\u0000"+
		"\u0000\u0010\u0011\u0005\u0005\u0000\u0000\u0011\u0012\u0005\u0001\u0000"+
		"\u0000\u0012\u0018\u0003\u0002\u0001\u0003\u0013\u0014\u0005\u0002\u0000"+
		"\u0000\u0014\u0015\u0003\u0002\u0001\u0000\u0015\u0016\u0005\u0003\u0000"+
		"\u0000\u0016\u0018\u0001\u0000\u0000\u0000\u0017\f\u0001\u0000\u0000\u0000"+
		"\u0017\u000e\u0001\u0000\u0000\u0000\u0017\u000f\u0001\u0000\u0000\u0000"+
		"\u0017\u0013\u0001\u0000\u0000\u0000\u0018\u001d\u0001\u0000\u0000\u0000"+
		"\u0019\u001a\n\u0002\u0000\u0000\u001a\u001c\u0003\u0002\u0001\u0003\u001b"+
		"\u0019\u0001\u0000\u0000\u0000\u001c\u001f\u0001\u0000\u0000\u0000\u001d"+
		"\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000\u0000\u001e"+
		"\u0003\u0001\u0000\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u0004"+
		"\u0007\n\u0017\u001d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}