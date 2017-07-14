// Generated from lapr4/red/s2/lang/n1151117/formula/compiler/Formula3.g4 by ANTLR 4.7

    package lapr4.red.s2.lang.n1151117.formula.compiler;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Formula3Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FOR=1, FUNCTION=2, CELL_REF=3, VAR=4, STRING=5, QUOT=6, NUMBER=7, EQ=8, 
		NEQ=9, LTEQ=10, GTEQ=11, GT=12, LT=13, AMP=14, PLUS=15, MINUS=16, MULTI=17, 
		DIV=18, POWER=19, PERCENT=20, COLON=21, UNDERSCORE=22, ATSYMBOL=23, COMMA=24, 
		SEMI=25, LPAR=26, RPAR=27, L_CURLY_BRACKET=28, R_CURLY_BRACKET=29, ASSIGN=30, 
		TAGCURRENCY=31, CURRENCY_SYMBOL=32, MONEY_NUM=33, WS=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"FOR", "LETTER", "FUNCTION", "CELL_REF", "VAR", "STRING", "QUOT", "NUMBER", 
		"DIGIT", "EQ", "NEQ", "LTEQ", "GTEQ", "GT", "LT", "AMP", "PLUS", "MINUS", 
		"MULTI", "DIV", "POWER", "PERCENT", "ABS", "EXCL", "COLON", "UNDERSCORE", 
		"ATSYMBOL", "COMMA", "SEMI", "LPAR", "RPAR", "L_CURLY_BRACKET", "R_CURLY_BRACKET", 
		"ASSIGN", "TAGCURRENCY", "CURRENCY_SYMBOL", "MONEY_NUM", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'\"'", null, "'='", "'<>'", "'<='", 
		"'>='", "'>'", "'<'", "'&'", "'+'", "'-'", "'*'", "'/'", "'^'", "'%'", 
		"':'", "'_'", "'@'", "','", "';'", "'('", "')'", "'{'", "'}'", "':='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "FOR", "FUNCTION", "CELL_REF", "VAR", "STRING", "QUOT", "NUMBER", 
		"EQ", "NEQ", "LTEQ", "GTEQ", "GT", "LT", "AMP", "PLUS", "MINUS", "MULTI", 
		"DIV", "POWER", "PERCENT", "COLON", "UNDERSCORE", "ATSYMBOL", "COMMA", 
		"SEMI", "LPAR", "RPAR", "L_CURLY_BRACKET", "R_CURLY_BRACKET", "ASSIGN", 
		"TAGCURRENCY", "CURRENCY_SYMBOL", "MONEY_NUM", "WS"
	};
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


	public Formula3Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Formula3.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00fc\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\5\2Y\n\2\3\3\3\3\3\4\6\4^\n\4\r\4\16\4_\3\5\5\5c\n\5\3\5\3"+
		"\5\5\5g\n\5\3\5\5\5j\n\5\3\5\6\5m\n\5\r\5\16\5n\3\6\3\6\5\6s\n\6\3\6\3"+
		"\6\3\6\3\6\7\6y\n\6\f\6\16\6|\13\6\3\7\3\7\3\7\3\7\7\7\u0082\n\7\f\7\16"+
		"\7\u0085\13\7\3\7\3\7\3\b\3\b\3\t\6\t\u008c\n\t\r\t\16\t\u008d\3\t\3\t"+
		"\6\t\u0092\n\t\r\t\16\t\u0093\5\t\u0096\n\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!"+
		"\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\5$\u00e2\n$\3%\3%\3&\6&\u00e7\n&\r&\16&\u00e8\3&\3&\6&\u00ed\n&\r"+
		"&\16&\u00ee\5&\u00f1\n&\3&\3&\3\'\3\'\3\'\3\'\5\'\u00f9\n\'\3\'\3\'\2"+
		"\2(\3\3\5\2\7\4\t\5\13\6\r\7\17\b\21\t\23\2\25\n\27\13\31\f\33\r\35\16"+
		"\37\17!\20#\21%\22\'\23)\24+\25-\26/\2\61\2\63\27\65\30\67\319\32;\33"+
		"=\34?\35A\36C\37E G!I\"K#M$\3\2\5\4\2C\\c|\3\2$$\5\2&&\u00a5\u00a5\u20ae"+
		"\u20ae\2\u010e\2\3\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\3X\3\2\2\2\5Z\3\2\2\2\7]\3\2\2\2\tb\3\2\2\2\13r\3\2\2\2\r}\3\2\2\2\17"+
		"\u0088\3\2\2\2\21\u008b\3\2\2\2\23\u0097\3\2\2\2\25\u0099\3\2\2\2\27\u009b"+
		"\3\2\2\2\31\u009e\3\2\2\2\33\u00a1\3\2\2\2\35\u00a4\3\2\2\2\37\u00a6\3"+
		"\2\2\2!\u00a8\3\2\2\2#\u00aa\3\2\2\2%\u00ac\3\2\2\2\'\u00ae\3\2\2\2)\u00b0"+
		"\3\2\2\2+\u00b2\3\2\2\2-\u00b4\3\2\2\2/\u00b6\3\2\2\2\61\u00b8\3\2\2\2"+
		"\63\u00ba\3\2\2\2\65\u00bc\3\2\2\2\67\u00be\3\2\2\29\u00c0\3\2\2\2;\u00c2"+
		"\3\2\2\2=\u00c4\3\2\2\2?\u00c6\3\2\2\2A\u00c8\3\2\2\2C\u00ca\3\2\2\2E"+
		"\u00cc\3\2\2\2G\u00e1\3\2\2\2I\u00e3\3\2\2\2K\u00e6\3\2\2\2M\u00f8\3\2"+
		"\2\2OP\7H\2\2PQ\7Q\2\2QY\7T\2\2RS\7h\2\2ST\7q\2\2TY\7t\2\2UV\7H\2\2VW"+
		"\7q\2\2WY\7t\2\2XO\3\2\2\2XR\3\2\2\2XU\3\2\2\2Y\4\3\2\2\2Z[\t\2\2\2[\6"+
		"\3\2\2\2\\^\5\5\3\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\b\3\2\2"+
		"\2ac\5/\30\2ba\3\2\2\2bc\3\2\2\2cd\3\2\2\2df\5\5\3\2eg\5\5\3\2fe\3\2\2"+
		"\2fg\3\2\2\2gi\3\2\2\2hj\5/\30\2ih\3\2\2\2ij\3\2\2\2jl\3\2\2\2km\5\23"+
		"\n\2lk\3\2\2\2mn\3\2\2\2nl\3\2\2\2no\3\2\2\2o\n\3\2\2\2ps\5\65\33\2qs"+
		"\5\67\34\2rp\3\2\2\2rq\3\2\2\2st\3\2\2\2tz\5\5\3\2uy\5\5\3\2vy\5\23\n"+
		"\2wy\5\65\33\2xu\3\2\2\2xv\3\2\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2"+
		"\2\2{\f\3\2\2\2|z\3\2\2\2}\u0083\5\17\b\2~\177\7^\2\2\177\u0082\7$\2\2"+
		"\u0080\u0082\n\3\2\2\u0081~\3\2\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3"+
		"\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0086\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u0087\5\17\b\2\u0087\16\3\2\2\2\u0088\u0089\7$\2"+
		"\2\u0089\20\3\2\2\2\u008a\u008c\5\23\n\2\u008b\u008a\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0095\3\2\2\2\u008f"+
		"\u0091\59\35\2\u0090\u0092\5\23\n\2\u0091\u0090\3\2\2\2\u0092\u0093\3"+
		"\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095"+
		"\u008f\3\2\2\2\u0095\u0096\3\2\2\2\u0096\22\3\2\2\2\u0097\u0098\4\62;"+
		"\2\u0098\24\3\2\2\2\u0099\u009a\7?\2\2\u009a\26\3\2\2\2\u009b\u009c\7"+
		">\2\2\u009c\u009d\7@\2\2\u009d\30\3\2\2\2\u009e\u009f\7>\2\2\u009f\u00a0"+
		"\7?\2\2\u00a0\32\3\2\2\2\u00a1\u00a2\7@\2\2\u00a2\u00a3\7?\2\2\u00a3\34"+
		"\3\2\2\2\u00a4\u00a5\7@\2\2\u00a5\36\3\2\2\2\u00a6\u00a7\7>\2\2\u00a7"+
		" \3\2\2\2\u00a8\u00a9\7(\2\2\u00a9\"\3\2\2\2\u00aa\u00ab\7-\2\2\u00ab"+
		"$\3\2\2\2\u00ac\u00ad\7/\2\2\u00ad&\3\2\2\2\u00ae\u00af\7,\2\2\u00af("+
		"\3\2\2\2\u00b0\u00b1\7\61\2\2\u00b1*\3\2\2\2\u00b2\u00b3\7`\2\2\u00b3"+
		",\3\2\2\2\u00b4\u00b5\7\'\2\2\u00b5.\3\2\2\2\u00b6\u00b7\7&\2\2\u00b7"+
		"\60\3\2\2\2\u00b8\u00b9\7#\2\2\u00b9\62\3\2\2\2\u00ba\u00bb\7<\2\2\u00bb"+
		"\64\3\2\2\2\u00bc\u00bd\7a\2\2\u00bd\66\3\2\2\2\u00be\u00bf\7B\2\2\u00bf"+
		"8\3\2\2\2\u00c0\u00c1\7.\2\2\u00c1:\3\2\2\2\u00c2\u00c3\7=\2\2\u00c3<"+
		"\3\2\2\2\u00c4\u00c5\7*\2\2\u00c5>\3\2\2\2\u00c6\u00c7\7+\2\2\u00c7@\3"+
		"\2\2\2\u00c8\u00c9\7}\2\2\u00c9B\3\2\2\2\u00ca\u00cb\7\177\2\2\u00cbD"+
		"\3\2\2\2\u00cc\u00cd\7<\2\2\u00cd\u00ce\7?\2\2\u00ceF\3\2\2\2\u00cf\u00d0"+
		"\7%\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7w\2\2\u00d2\u00d3\7t\2\2\u00d3"+
		"\u00e2\7q\2\2\u00d4\u00d5\7%\2\2\u00d5\u00d6\7r\2\2\u00d6\u00d7\7q\2\2"+
		"\u00d7\u00d8\7w\2\2\u00d8\u00d9\7p\2\2\u00d9\u00e2\7f\2\2\u00da\u00db"+
		"\7%\2\2\u00db\u00dc\7f\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de\7n\2\2\u00de"+
		"\u00df\7n\2\2\u00df\u00e0\7c\2\2\u00e0\u00e2\7t\2\2\u00e1\u00cf\3\2\2"+
		"\2\u00e1\u00d4\3\2\2\2\u00e1\u00da\3\2\2\2\u00e2H\3\2\2\2\u00e3\u00e4"+
		"\t\4\2\2\u00e4J\3\2\2\2\u00e5\u00e7\5\23\n\2\u00e6\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00f0\3\2"+
		"\2\2\u00ea\u00ec\7\60\2\2\u00eb\u00ed\5\23\n\2\u00ec\u00eb\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\u00f1\3\2"+
		"\2\2\u00f0\u00ea\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f3\5I%\2\u00f3L\3\2\2\2\u00f4\u00f9\7\"\2\2\u00f5\u00f6\7\17\2\2\u00f6"+
		"\u00f9\7\f\2\2\u00f7\u00f9\4\13\f\2\u00f8\u00f4\3\2\2\2\u00f8\u00f5\3"+
		"\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\b\'\2\2\u00fb"+
		"N\3\2\2\2\26\2X_bfinrxz\u0081\u0083\u008d\u0093\u0095\u00e1\u00e8\u00ee"+
		"\u00f0\u00f8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}