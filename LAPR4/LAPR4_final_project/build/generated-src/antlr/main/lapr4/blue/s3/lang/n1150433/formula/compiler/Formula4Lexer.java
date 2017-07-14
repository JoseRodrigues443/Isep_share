// Generated from lapr4/blue/s3/lang/n1150433/formula/compiler/Formula4.g4 by ANTLR 4.7

    package lapr4.blue.s3.lang.n1150433.formula.compiler;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Formula4Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		EVAL=1, DOWHILE=2, WHILEDO=3, FOR=4, FUNCTION=5, CELL_REF=6, VAR=7, STRING=8, 
		QUOT=9, NUMBER=10, EQ=11, NEQ=12, LTEQ=13, GTEQ=14, GT=15, LT=16, AMP=17, 
		PLUS=18, MINUS=19, MULTI=20, DIV=21, POWER=22, PERCENT=23, COLON=24, UNDERSCORE=25, 
		ATSYMBOL=26, COMMA=27, SEMI=28, LPAR=29, RPAR=30, L_CURLY_BRACKET=31, 
		R_CURLY_BRACKET=32, ASSIGN=33, TAGCURRENCY=34, CURRENCY_SYMBOL=35, MONEY_NUM=36, 
		WS=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"EVAL", "DOWHILE", "WHILEDO", "FOR", "LETTER", "FUNCTION", "CELL_REF", 
		"VAR", "STRING", "QUOT", "NUMBER", "DIGIT", "EQ", "NEQ", "LTEQ", "GTEQ", 
		"GT", "LT", "AMP", "PLUS", "MINUS", "MULTI", "DIV", "POWER", "PERCENT", 
		"ABS", "EXCL", "COLON", "UNDERSCORE", "ATSYMBOL", "COMMA", "SEMI", "LPAR", 
		"RPAR", "L_CURLY_BRACKET", "R_CURLY_BRACKET", "ASSIGN", "TAGCURRENCY", 
		"CURRENCY_SYMBOL", "MONEY_NUM", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, "'\"'", null, "'='", 
		"'<>'", "'<='", "'>='", "'>'", "'<'", "'&'", "'+'", "'-'", "'*'", "'/'", 
		"'^'", "'%'", "':'", "'_'", "'@'", "','", "';'", "'('", "')'", "'{'", 
		"'}'", "':='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "EVAL", "DOWHILE", "WHILEDO", "FOR", "FUNCTION", "CELL_REF", "VAR", 
		"STRING", "QUOT", "NUMBER", "EQ", "NEQ", "LTEQ", "GTEQ", "GT", "LT", "AMP", 
		"PLUS", "MINUS", "MULTI", "DIV", "POWER", "PERCENT", "COLON", "UNDERSCORE", 
		"ATSYMBOL", "COMMA", "SEMI", "LPAR", "RPAR", "L_CURLY_BRACKET", "R_CURLY_BRACKET", 
		"ASSIGN", "TAGCURRENCY", "CURRENCY_SYMBOL", "MONEY_NUM", "WS"
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


	public Formula4Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Formula4.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u013e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2b\n\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3y"+
		"\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\5\4\u0090\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5"+
		"\5\u009b\n\5\3\6\3\6\3\7\6\7\u00a0\n\7\r\7\16\7\u00a1\3\b\5\b\u00a5\n"+
		"\b\3\b\3\b\5\b\u00a9\n\b\3\b\5\b\u00ac\n\b\3\b\6\b\u00af\n\b\r\b\16\b"+
		"\u00b0\3\t\3\t\5\t\u00b5\n\t\3\t\3\t\3\t\3\t\7\t\u00bb\n\t\f\t\16\t\u00be"+
		"\13\t\3\n\3\n\3\n\3\n\7\n\u00c4\n\n\f\n\16\n\u00c7\13\n\3\n\3\n\3\13\3"+
		"\13\3\f\6\f\u00ce\n\f\r\f\16\f\u00cf\3\f\3\f\6\f\u00d4\n\f\r\f\16\f\u00d5"+
		"\5\f\u00d8\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3\'\5\'\u0124\n"+
		"\'\3(\3(\3)\6)\u0129\n)\r)\16)\u012a\3)\3)\6)\u012f\n)\r)\16)\u0130\5"+
		")\u0133\n)\3)\3)\3*\3*\3*\3*\5*\u013b\n*\3*\3*\2\2+\3\3\5\4\7\5\t\6\13"+
		"\2\r\7\17\b\21\t\23\n\25\13\27\f\31\2\33\r\35\16\37\17!\20#\21%\22\'\23"+
		")\24+\25-\26/\27\61\30\63\31\65\2\67\29\32;\33=\34?\35A\36C\37E G!I\""+
		"K#M$O%Q&S\'\3\2\5\4\2C\\c|\3\2$$\5\2&&\u00a5\u00a5\u20ae\u20ae\2\u0156"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2"+
		"E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3"+
		"\2\2\2\2S\3\2\2\2\3a\3\2\2\2\5x\3\2\2\2\7\u008f\3\2\2\2\t\u009a\3\2\2"+
		"\2\13\u009c\3\2\2\2\r\u009f\3\2\2\2\17\u00a4\3\2\2\2\21\u00b4\3\2\2\2"+
		"\23\u00bf\3\2\2\2\25\u00ca\3\2\2\2\27\u00cd\3\2\2\2\31\u00d9\3\2\2\2\33"+
		"\u00db\3\2\2\2\35\u00dd\3\2\2\2\37\u00e0\3\2\2\2!\u00e3\3\2\2\2#\u00e6"+
		"\3\2\2\2%\u00e8\3\2\2\2\'\u00ea\3\2\2\2)\u00ec\3\2\2\2+\u00ee\3\2\2\2"+
		"-\u00f0\3\2\2\2/\u00f2\3\2\2\2\61\u00f4\3\2\2\2\63\u00f6\3\2\2\2\65\u00f8"+
		"\3\2\2\2\67\u00fa\3\2\2\29\u00fc\3\2\2\2;\u00fe\3\2\2\2=\u0100\3\2\2\2"+
		"?\u0102\3\2\2\2A\u0104\3\2\2\2C\u0106\3\2\2\2E\u0108\3\2\2\2G\u010a\3"+
		"\2\2\2I\u010c\3\2\2\2K\u010e\3\2\2\2M\u0123\3\2\2\2O\u0125\3\2\2\2Q\u0128"+
		"\3\2\2\2S\u013a\3\2\2\2UV\7G\2\2VW\7X\2\2WX\7C\2\2Xb\7N\2\2YZ\7g\2\2Z"+
		"[\7x\2\2[\\\7c\2\2\\b\7n\2\2]^\7G\2\2^_\7x\2\2_`\7c\2\2`b\7n\2\2aU\3\2"+
		"\2\2aY\3\2\2\2a]\3\2\2\2b\4\3\2\2\2cd\7F\2\2de\7Q\2\2ef\7Y\2\2fg\7J\2"+
		"\2gh\7K\2\2hi\7N\2\2iy\7G\2\2jk\7f\2\2kl\7q\2\2lm\7y\2\2mn\7j\2\2no\7"+
		"k\2\2op\7n\2\2py\7g\2\2qr\7F\2\2rs\7q\2\2st\7Y\2\2tu\7j\2\2uv\7k\2\2v"+
		"w\7n\2\2wy\7g\2\2xc\3\2\2\2xj\3\2\2\2xq\3\2\2\2y\6\3\2\2\2z{\7Y\2\2{|"+
		"\7J\2\2|}\7K\2\2}~\7N\2\2~\177\7G\2\2\177\u0080\7F\2\2\u0080\u0090\7Q"+
		"\2\2\u0081\u0082\7y\2\2\u0082\u0083\7j\2\2\u0083\u0084\7k\2\2\u0084\u0085"+
		"\7n\2\2\u0085\u0086\7g\2\2\u0086\u0087\7f\2\2\u0087\u0090\7q\2\2\u0088"+
		"\u0089\7Y\2\2\u0089\u008a\7j\2\2\u008a\u008b\7k\2\2\u008b\u008c\7n\2\2"+
		"\u008c\u008d\7g\2\2\u008d\u008e\7F\2\2\u008e\u0090\7q\2\2\u008fz\3\2\2"+
		"\2\u008f\u0081\3\2\2\2\u008f\u0088\3\2\2\2\u0090\b\3\2\2\2\u0091\u0092"+
		"\7H\2\2\u0092\u0093\7Q\2\2\u0093\u009b\7T\2\2\u0094\u0095\7h\2\2\u0095"+
		"\u0096\7q\2\2\u0096\u009b\7t\2\2\u0097\u0098\7H\2\2\u0098\u0099\7q\2\2"+
		"\u0099\u009b\7t\2\2\u009a\u0091\3\2\2\2\u009a\u0094\3\2\2\2\u009a\u0097"+
		"\3\2\2\2\u009b\n\3\2\2\2\u009c\u009d\t\2\2\2\u009d\f\3\2\2\2\u009e\u00a0"+
		"\5\13\6\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2"+
		"\u00a1\u00a2\3\2\2\2\u00a2\16\3\2\2\2\u00a3\u00a5\5\65\33\2\u00a4\u00a3"+
		"\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a8\5\13\6\2"+
		"\u00a7\u00a9\5\13\6\2\u00a8\u00a7\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab"+
		"\3\2\2\2\u00aa\u00ac\5\65\33\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2"+
		"\u00ac\u00ae\3\2\2\2\u00ad\u00af\5\31\r\2\u00ae\u00ad\3\2\2\2\u00af\u00b0"+
		"\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\20\3\2\2\2\u00b2"+
		"\u00b5\5;\36\2\u00b3\u00b5\5=\37\2\u00b4\u00b2\3\2\2\2\u00b4\u00b3\3\2"+
		"\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00bc\5\13\6\2\u00b7\u00bb\5\13\6\2\u00b8"+
		"\u00bb\5\31\r\2\u00b9\u00bb\5;\36\2\u00ba\u00b7\3\2\2\2\u00ba\u00b8\3"+
		"\2\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd\22\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c5\5\25\13"+
		"\2\u00c0\u00c1\7^\2\2\u00c1\u00c4\7$\2\2\u00c2\u00c4\n\3\2\2\u00c3\u00c0"+
		"\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9\5\25"+
		"\13\2\u00c9\24\3\2\2\2\u00ca\u00cb\7$\2\2\u00cb\26\3\2\2\2\u00cc\u00ce"+
		"\5\31\r\2\u00cd\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00cd\3\2\2\2"+
		"\u00cf\u00d0\3\2\2\2\u00d0\u00d7\3\2\2\2\u00d1\u00d3\5? \2\u00d2\u00d4"+
		"\5\31\r\2\u00d3\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d3\3\2\2\2"+
		"\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d1\3\2\2\2\u00d7\u00d8"+
		"\3\2\2\2\u00d8\30\3\2\2\2\u00d9\u00da\4\62;\2\u00da\32\3\2\2\2\u00db\u00dc"+
		"\7?\2\2\u00dc\34\3\2\2\2\u00dd\u00de\7>\2\2\u00de\u00df\7@\2\2\u00df\36"+
		"\3\2\2\2\u00e0\u00e1\7>\2\2\u00e1\u00e2\7?\2\2\u00e2 \3\2\2\2\u00e3\u00e4"+
		"\7@\2\2\u00e4\u00e5\7?\2\2\u00e5\"\3\2\2\2\u00e6\u00e7\7@\2\2\u00e7$\3"+
		"\2\2\2\u00e8\u00e9\7>\2\2\u00e9&\3\2\2\2\u00ea\u00eb\7(\2\2\u00eb(\3\2"+
		"\2\2\u00ec\u00ed\7-\2\2\u00ed*\3\2\2\2\u00ee\u00ef\7/\2\2\u00ef,\3\2\2"+
		"\2\u00f0\u00f1\7,\2\2\u00f1.\3\2\2\2\u00f2\u00f3\7\61\2\2\u00f3\60\3\2"+
		"\2\2\u00f4\u00f5\7`\2\2\u00f5\62\3\2\2\2\u00f6\u00f7\7\'\2\2\u00f7\64"+
		"\3\2\2\2\u00f8\u00f9\7&\2\2\u00f9\66\3\2\2\2\u00fa\u00fb\7#\2\2\u00fb"+
		"8\3\2\2\2\u00fc\u00fd\7<\2\2\u00fd:\3\2\2\2\u00fe\u00ff\7a\2\2\u00ff<"+
		"\3\2\2\2\u0100\u0101\7B\2\2\u0101>\3\2\2\2\u0102\u0103\7.\2\2\u0103@\3"+
		"\2\2\2\u0104\u0105\7=\2\2\u0105B\3\2\2\2\u0106\u0107\7*\2\2\u0107D\3\2"+
		"\2\2\u0108\u0109\7+\2\2\u0109F\3\2\2\2\u010a\u010b\7}\2\2\u010bH\3\2\2"+
		"\2\u010c\u010d\7\177\2\2\u010dJ\3\2\2\2\u010e\u010f\7<\2\2\u010f\u0110"+
		"\7?\2\2\u0110L\3\2\2\2\u0111\u0112\7%\2\2\u0112\u0113\7g\2\2\u0113\u0114"+
		"\7w\2\2\u0114\u0115\7t\2\2\u0115\u0124\7q\2\2\u0116\u0117\7%\2\2\u0117"+
		"\u0118\7r\2\2\u0118\u0119\7q\2\2\u0119\u011a\7w\2\2\u011a\u011b\7p\2\2"+
		"\u011b\u0124\7f\2\2\u011c\u011d\7%\2\2\u011d\u011e\7f\2\2\u011e\u011f"+
		"\7q\2\2\u011f\u0120\7n\2\2\u0120\u0121\7n\2\2\u0121\u0122\7c\2\2\u0122"+
		"\u0124\7t\2\2\u0123\u0111\3\2\2\2\u0123\u0116\3\2\2\2\u0123\u011c\3\2"+
		"\2\2\u0124N\3\2\2\2\u0125\u0126\t\4\2\2\u0126P\3\2\2\2\u0127\u0129\5\31"+
		"\r\2\u0128\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012b\u0132\3\2\2\2\u012c\u012e\7\60\2\2\u012d\u012f\5"+
		"\31\r\2\u012e\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u012e\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0133\3\2\2\2\u0132\u012c\3\2\2\2\u0132\u0133\3\2"+
		"\2\2\u0133\u0134\3\2\2\2\u0134\u0135\5O(\2\u0135R\3\2\2\2\u0136\u013b"+
		"\7\"\2\2\u0137\u0138\7\17\2\2\u0138\u013b\7\f\2\2\u0139\u013b\4\13\f\2"+
		"\u013a\u0136\3\2\2\2\u013a\u0137\3\2\2\2\u013a\u0139\3\2\2\2\u013b\u013c"+
		"\3\2\2\2\u013c\u013d\b*\2\2\u013dT\3\2\2\2\31\2ax\u008f\u009a\u00a1\u00a4"+
		"\u00a8\u00ab\u00b0\u00b4\u00ba\u00bc\u00c3\u00c5\u00cf\u00d5\u00d7\u0123"+
		"\u012a\u0130\u0132\u013a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}