// Generated from csheets/core/formula/compiler/Formula.g4 by ANTLR 4.7

    package csheets.core.formula.compiler;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FormulaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FUNCTION=1, CELL_REF=2, VAR=3, STRING=4, QUOT=5, NUMBER=6, EQ=7, NEQ=8, 
		LTEQ=9, GTEQ=10, GT=11, LT=12, ASSIGN=13, AMP=14, PLUS=15, MINUS=16, MULTI=17, 
		DIV=18, POWER=19, PERCENT=20, COLON=21, UNDERSCORE=22, COMMA=23, SEMI=24, 
		LPAR=25, RPAR=26, LCURL=27, RCURL=28, WS=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LETTER", "FUNCTION", "CELL_REF", "VAR", "STRING", "QUOT", "NUMBER", "DIGIT", 
		"EQ", "NEQ", "LTEQ", "GTEQ", "GT", "LT", "ASSIGN", "AMP", "PLUS", "MINUS", 
		"MULTI", "DIV", "POWER", "PERCENT", "ABS", "EXCL", "COLON", "UNDERSCORE", 
		"COMMA", "SEMI", "LPAR", "RPAR", "LCURL", "RCURL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'\"'", null, "'='", "'<>'", "'<='", "'>='", 
		"'>'", "'<'", "':='", "'&'", "'+'", "'-'", "'*'", "'/'", "'^'", "'%'", 
		"':'", "'_'", "','", "';'", "'('", "')'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "FUNCTION", "CELL_REF", "VAR", "STRING", "QUOT", "NUMBER", "EQ", 
		"NEQ", "LTEQ", "GTEQ", "GT", "LT", "ASSIGN", "AMP", "PLUS", "MINUS", "MULTI", 
		"DIV", "POWER", "PERCENT", "COLON", "UNDERSCORE", "COMMA", "SEMI", "LPAR", 
		"RPAR", "LCURL", "RCURL", "WS"
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


	public FormulaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Formula.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\37\u00bd\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\3\2\3\2\3\3\6\3I\n\3\r\3\16\3J\3\4\5\4N\n\4\3\4\3\4\5"+
		"\4R\n\4\3\4\5\4U\n\4\3\4\6\4X\n\4\r\4\16\4Y\3\5\3\5\3\5\3\5\3\5\7\5a\n"+
		"\5\f\5\16\5d\13\5\3\6\3\6\3\6\3\6\7\6j\n\6\f\6\16\6m\13\6\3\6\3\6\3\7"+
		"\3\7\3\b\6\bt\n\b\r\b\16\bu\3\b\3\b\6\bz\n\b\r\b\16\b{\5\b~\n\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\5\"\u00ba\n\"\3"+
		"\"\3\"\2\2#\3\2\5\3\7\4\t\5\13\6\r\7\17\b\21\2\23\t\25\n\27\13\31\f\33"+
		"\r\35\16\37\17!\20#\21%\22\'\23)\24+\25-\26/\2\61\2\63\27\65\30\67\31"+
		"9\32;\33=\34?\35A\36C\37\3\2\4\4\2C\\c|\3\2$$\2\u00c7\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2"+
		"\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\3E\3\2\2\2\5H"+
		"\3\2\2\2\7M\3\2\2\2\t[\3\2\2\2\13e\3\2\2\2\rp\3\2\2\2\17s\3\2\2\2\21\177"+
		"\3\2\2\2\23\u0081\3\2\2\2\25\u0083\3\2\2\2\27\u0086\3\2\2\2\31\u0089\3"+
		"\2\2\2\33\u008c\3\2\2\2\35\u008e\3\2\2\2\37\u0090\3\2\2\2!\u0093\3\2\2"+
		"\2#\u0095\3\2\2\2%\u0097\3\2\2\2\'\u0099\3\2\2\2)\u009b\3\2\2\2+\u009d"+
		"\3\2\2\2-\u009f\3\2\2\2/\u00a1\3\2\2\2\61\u00a3\3\2\2\2\63\u00a5\3\2\2"+
		"\2\65\u00a7\3\2\2\2\67\u00a9\3\2\2\29\u00ab\3\2\2\2;\u00ad\3\2\2\2=\u00af"+
		"\3\2\2\2?\u00b1\3\2\2\2A\u00b3\3\2\2\2C\u00b9\3\2\2\2EF\t\2\2\2F\4\3\2"+
		"\2\2GI\5\3\2\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3\2\2\2K\6\3\2\2\2LN\5"+
		"/\30\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2OQ\5\3\2\2PR\5\3\2\2QP\3\2\2\2QR\3"+
		"\2\2\2RT\3\2\2\2SU\5/\30\2TS\3\2\2\2TU\3\2\2\2UW\3\2\2\2VX\5\21\t\2WV"+
		"\3\2\2\2XY\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\b\3\2\2\2[\\\5\65\33\2\\b\5\3"+
		"\2\2]a\5\3\2\2^a\5\21\t\2_a\5\65\33\2`]\3\2\2\2`^\3\2\2\2`_\3\2\2\2ad"+
		"\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\n\3\2\2\2db\3\2\2\2ek\5\r\7\2fg\7^\2\2g"+
		"j\7$\2\2hj\n\3\2\2if\3\2\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l"+
		"n\3\2\2\2mk\3\2\2\2no\5\r\7\2o\f\3\2\2\2pq\7$\2\2q\16\3\2\2\2rt\5\21\t"+
		"\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2v}\3\2\2\2wy\5\67\34\2xz\5\21"+
		"\t\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}w\3\2\2\2}~\3\2"+
		"\2\2~\20\3\2\2\2\177\u0080\4\62;\2\u0080\22\3\2\2\2\u0081\u0082\7?\2\2"+
		"\u0082\24\3\2\2\2\u0083\u0084\7>\2\2\u0084\u0085\7@\2\2\u0085\26\3\2\2"+
		"\2\u0086\u0087\7>\2\2\u0087\u0088\7?\2\2\u0088\30\3\2\2\2\u0089\u008a"+
		"\7@\2\2\u008a\u008b\7?\2\2\u008b\32\3\2\2\2\u008c\u008d\7@\2\2\u008d\34"+
		"\3\2\2\2\u008e\u008f\7>\2\2\u008f\36\3\2\2\2\u0090\u0091\7<\2\2\u0091"+
		"\u0092\7?\2\2\u0092 \3\2\2\2\u0093\u0094\7(\2\2\u0094\"\3\2\2\2\u0095"+
		"\u0096\7-\2\2\u0096$\3\2\2\2\u0097\u0098\7/\2\2\u0098&\3\2\2\2\u0099\u009a"+
		"\7,\2\2\u009a(\3\2\2\2\u009b\u009c\7\61\2\2\u009c*\3\2\2\2\u009d\u009e"+
		"\7`\2\2\u009e,\3\2\2\2\u009f\u00a0\7\'\2\2\u00a0.\3\2\2\2\u00a1\u00a2"+
		"\7&\2\2\u00a2\60\3\2\2\2\u00a3\u00a4\7#\2\2\u00a4\62\3\2\2\2\u00a5\u00a6"+
		"\7<\2\2\u00a6\64\3\2\2\2\u00a7\u00a8\7a\2\2\u00a8\66\3\2\2\2\u00a9\u00aa"+
		"\7.\2\2\u00aa8\3\2\2\2\u00ab\u00ac\7=\2\2\u00ac:\3\2\2\2\u00ad\u00ae\7"+
		"*\2\2\u00ae<\3\2\2\2\u00af\u00b0\7+\2\2\u00b0>\3\2\2\2\u00b1\u00b2\7}"+
		"\2\2\u00b2@\3\2\2\2\u00b3\u00b4\7\177\2\2\u00b4B\3\2\2\2\u00b5\u00ba\7"+
		"\"\2\2\u00b6\u00b7\7\17\2\2\u00b7\u00ba\7\f\2\2\u00b8\u00ba\4\13\f\2\u00b9"+
		"\u00b5\3\2\2\2\u00b9\u00b6\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\u00bc\b\"\2\2\u00bcD\3\2\2\2\20\2JMQTY`biku{}\u00b9\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}