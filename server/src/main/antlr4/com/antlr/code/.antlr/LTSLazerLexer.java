// Generated from /home/damoiskii/VSCodeProjects/lazer-programming-language/server/src/main/antlr4/com/antlr/code/LTSLazer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LTSLazerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, OPAREN=2, CPAREN=3, LAMBDA=4, PLUS=5, MINUS=6, MULTIPLY=7, DIVIDE=8, 
		VARIABLE=9, NUMBER=10, WHITESPACE=11, COMMENT=12, COMMENT_MULTI=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DOT", "OPAREN", "CPAREN", "LAMBDA", "PLUS", "MINUS", "MULTIPLY", "DIVIDE", 
			"VARIABLE", "NUMBER", "WHITESPACE", "COMMENT", "COMMENT_MULTI"
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


	public LTSLazerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LTSLazer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\rR\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0004\t/\b\t\u000b\t\f\t0\u0001\n\u0004"+
		"\n4\b\n\u000b\n\f\n5\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b>\b\u000b\n\u000b\f\u000bA\t\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005\fI\b\f\n\f\f\fL\t\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001J\u0000\r\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u0001\u0000\u0004\u0001\u0000a"+
		"z\u0001\u000009\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\rU\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0001\u001b\u0001\u0000\u0000\u0000\u0003\u001d\u0001\u0000"+
		"\u0000\u0000\u0005\u001f\u0001\u0000\u0000\u0000\u0007!\u0001\u0000\u0000"+
		"\u0000\t#\u0001\u0000\u0000\u0000\u000b%\u0001\u0000\u0000\u0000\r\'\u0001"+
		"\u0000\u0000\u0000\u000f)\u0001\u0000\u0000\u0000\u0011+\u0001\u0000\u0000"+
		"\u0000\u0013.\u0001\u0000\u0000\u0000\u00153\u0001\u0000\u0000\u0000\u0017"+
		"9\u0001\u0000\u0000\u0000\u0019D\u0001\u0000\u0000\u0000\u001b\u001c\u0005"+
		".\u0000\u0000\u001c\u0002\u0001\u0000\u0000\u0000\u001d\u001e\u0005(\u0000"+
		"\u0000\u001e\u0004\u0001\u0000\u0000\u0000\u001f \u0005)\u0000\u0000 "+
		"\u0006\u0001\u0000\u0000\u0000!\"\u0005#\u0000\u0000\"\b\u0001\u0000\u0000"+
		"\u0000#$\u0005+\u0000\u0000$\n\u0001\u0000\u0000\u0000%&\u0005-\u0000"+
		"\u0000&\f\u0001\u0000\u0000\u0000\'(\u0005*\u0000\u0000(\u000e\u0001\u0000"+
		"\u0000\u0000)*\u0005/\u0000\u0000*\u0010\u0001\u0000\u0000\u0000+,\u0007"+
		"\u0000\u0000\u0000,\u0012\u0001\u0000\u0000\u0000-/\u0007\u0001\u0000"+
		"\u0000.-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000.\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u00001\u0014\u0001\u0000\u0000\u0000"+
		"24\u0007\u0002\u0000\u000032\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0001\u0000"+
		"\u0000\u000078\u0006\n\u0000\u00008\u0016\u0001\u0000\u0000\u00009:\u0005"+
		"/\u0000\u0000:;\u0005/\u0000\u0000;?\u0001\u0000\u0000\u0000<>\b\u0003"+
		"\u0000\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001"+
		"\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0001\u0000\u0000\u0000"+
		"A?\u0001\u0000\u0000\u0000BC\u0006\u000b\u0000\u0000C\u0018\u0001\u0000"+
		"\u0000\u0000DE\u0005/\u0000\u0000EF\u0005*\u0000\u0000FJ\u0001\u0000\u0000"+
		"\u0000GI\t\u0000\u0000\u0000HG\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000"+
		"\u0000JK\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KM\u0001\u0000"+
		"\u0000\u0000LJ\u0001\u0000\u0000\u0000MN\u0005*\u0000\u0000NO\u0005/\u0000"+
		"\u0000OP\u0001\u0000\u0000\u0000PQ\u0006\f\u0000\u0000Q\u001a\u0001\u0000"+
		"\u0000\u0000\u0005\u000005?J\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}