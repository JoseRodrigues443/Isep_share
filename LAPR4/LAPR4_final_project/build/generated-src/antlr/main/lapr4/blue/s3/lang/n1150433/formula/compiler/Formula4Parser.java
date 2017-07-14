// Generated from lapr4/blue/s3/lang/n1150433/formula/compiler/Formula4.g4 by ANTLR 4.7

    package lapr4.blue.s3.lang.n1150433.formula.compiler;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Formula4Parser extends Parser {
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
	public static final int
		RULE_expression = 0, RULE_money_expression = 1, RULE_moneys = 2, RULE_money_operation = 3, 
		RULE_block = 4, RULE_comparison = 5, RULE_concatenation = 6, RULE_for_loop = 7, 
		RULE_while_loop = 8, RULE_eval = 9, RULE_atom = 10, RULE_assignment = 11, 
		RULE_function_call = 12, RULE_reference = 13, RULE_literal = 14;
	public static final String[] ruleNames = {
		"expression", "money_expression", "moneys", "money_operation", "block", 
		"comparison", "concatenation", "for_loop", "while_loop", "eval", "atom", 
		"assignment", "function_call", "reference", "literal"
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

	@Override
	public String getGrammarFileName() { return "Formula4.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Formula4Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(Formula4Parser.EQ, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Formula4Parser.EOF, 0); }
		public Money_expressionContext money_expression() {
			return getRuleContext(Money_expressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(EQ);
				setState(31);
				comparison();
				setState(32);
				match(EOF);
				}
				break;
			case TAGCURRENCY:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				money_expression();
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

	public static class Money_expressionContext extends ParserRuleContext {
		public TerminalNode TAGCURRENCY() { return getToken(Formula4Parser.TAGCURRENCY, 0); }
		public TerminalNode L_CURLY_BRACKET() { return getToken(Formula4Parser.L_CURLY_BRACKET, 0); }
		public MoneysContext moneys() {
			return getRuleContext(MoneysContext.class,0);
		}
		public TerminalNode R_CURLY_BRACKET() { return getToken(Formula4Parser.R_CURLY_BRACKET, 0); }
		public Money_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_money_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterMoney_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitMoney_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitMoney_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Money_expressionContext money_expression() throws RecognitionException {
		Money_expressionContext _localctx = new Money_expressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_money_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(TAGCURRENCY);
			setState(38);
			match(L_CURLY_BRACKET);
			setState(39);
			moneys();
			setState(40);
			match(R_CURLY_BRACKET);
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

	public static class MoneysContext extends ParserRuleContext {
		public List<TerminalNode> MONEY_NUM() { return getTokens(Formula4Parser.MONEY_NUM); }
		public TerminalNode MONEY_NUM(int i) {
			return getToken(Formula4Parser.MONEY_NUM, i);
		}
		public List<Money_operationContext> money_operation() {
			return getRuleContexts(Money_operationContext.class);
		}
		public Money_operationContext money_operation(int i) {
			return getRuleContext(Money_operationContext.class,i);
		}
		public MoneysContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moneys; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterMoneys(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitMoneys(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitMoneys(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MoneysContext moneys() throws RecognitionException {
		MoneysContext _localctx = new MoneysContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_moneys);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(MONEY_NUM);
			setState(46); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43);
				money_operation();
				setState(44);
				match(MONEY_NUM);
				}
				}
				setState(48); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULTI) | (1L << DIV))) != 0) );
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

	public static class Money_operationContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(Formula4Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(Formula4Parser.MINUS, 0); }
		public TerminalNode MULTI() { return getToken(Formula4Parser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(Formula4Parser.DIV, 0); }
		public Money_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_money_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterMoney_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitMoney_operation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitMoney_operation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Money_operationContext money_operation() throws RecognitionException {
		Money_operationContext _localctx = new Money_operationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_money_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULTI) | (1L << DIV))) != 0)) ) {
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode L_CURLY_BRACKET() { return getToken(Formula4Parser.L_CURLY_BRACKET, 0); }
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public TerminalNode R_CURLY_BRACKET() { return getToken(Formula4Parser.R_CURLY_BRACKET, 0); }
		public List<TerminalNode> SEMI() { return getTokens(Formula4Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Formula4Parser.SEMI, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(L_CURLY_BRACKET);
			setState(53);
			comparison();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(54);
				match(SEMI);
				setState(55);
				comparison();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
			match(R_CURLY_BRACKET);
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

	public static class ComparisonContext extends ParserRuleContext {
		public List<ConcatenationContext> concatenation() {
			return getRuleContexts(ConcatenationContext.class);
		}
		public ConcatenationContext concatenation(int i) {
			return getRuleContext(ConcatenationContext.class,i);
		}
		public TerminalNode EQ() { return getToken(Formula4Parser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(Formula4Parser.NEQ, 0); }
		public TerminalNode GT() { return getToken(Formula4Parser.GT, 0); }
		public TerminalNode LT() { return getToken(Formula4Parser.LT, 0); }
		public TerminalNode LTEQ() { return getToken(Formula4Parser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(Formula4Parser.GTEQ, 0); }
		public TerminalNode ASSIGN() { return getToken(Formula4Parser.ASSIGN, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			concatenation(0);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT) | (1L << ASSIGN))) != 0)) {
				{
				setState(64);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT) | (1L << ASSIGN))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(65);
				concatenation(0);
				}
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

	public static class ConcatenationContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(Formula4Parser.MINUS, 0); }
		public For_loopContext for_loop() {
			return getRuleContext(For_loopContext.class,0);
		}
		public While_loopContext while_loop() {
			return getRuleContext(While_loopContext.class,0);
		}
		public EvalContext eval() {
			return getRuleContext(EvalContext.class,0);
		}
		public List<ConcatenationContext> concatenation() {
			return getRuleContexts(ConcatenationContext.class);
		}
		public ConcatenationContext concatenation(int i) {
			return getRuleContext(ConcatenationContext.class,i);
		}
		public TerminalNode POWER() { return getToken(Formula4Parser.POWER, 0); }
		public TerminalNode MULTI() { return getToken(Formula4Parser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(Formula4Parser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(Formula4Parser.PLUS, 0); }
		public TerminalNode AMP() { return getToken(Formula4Parser.AMP, 0); }
		public TerminalNode PERCENT() { return getToken(Formula4Parser.PERCENT, 0); }
		public ConcatenationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatenation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterConcatenation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitConcatenation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitConcatenation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcatenationContext concatenation() throws RecognitionException {
		return concatenation(0);
	}

	private ConcatenationContext concatenation(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConcatenationContext _localctx = new ConcatenationContext(_ctx, _parentState);
		ConcatenationContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_concatenation, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FUNCTION:
			case CELL_REF:
			case VAR:
			case STRING:
			case NUMBER:
			case MINUS:
			case LPAR:
			case L_CURLY_BRACKET:
				{
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(69);
					match(MINUS);
					}
				}

				setState(72);
				atom();
				}
				break;
			case FOR:
				{
				setState(73);
				for_loop();
				}
				break;
			case DOWHILE:
			case WHILEDO:
				{
				setState(74);
				while_loop();
				}
				break;
			case EVAL:
				{
				setState(75);
				eval();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(92);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(78);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(79);
						match(POWER);
						setState(80);
						concatenation(7);
						}
						break;
					case 2:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(81);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(82);
						_la = _input.LA(1);
						if ( !(_la==MULTI || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(83);
						concatenation(7);
						}
						break;
					case 3:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(84);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(85);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(86);
						concatenation(6);
						}
						break;
					case 4:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(87);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(88);
						match(AMP);
						setState(89);
						concatenation(5);
						}
						break;
					case 5:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(90);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(91);
						match(PERCENT);
						}
						break;
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public static class For_loopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Formula4Parser.FOR, 0); }
		public TerminalNode L_CURLY_BRACKET() { return getToken(Formula4Parser.L_CURLY_BRACKET, 0); }
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public TerminalNode R_CURLY_BRACKET() { return getToken(Formula4Parser.R_CURLY_BRACKET, 0); }
		public List<TerminalNode> SEMI() { return getTokens(Formula4Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Formula4Parser.SEMI, i);
		}
		public For_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterFor_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitFor_loop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitFor_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_loopContext for_loop() throws RecognitionException {
		For_loopContext _localctx = new For_loopContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_for_loop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(FOR);
			setState(98);
			match(L_CURLY_BRACKET);
			setState(99);
			comparison();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(100);
				match(SEMI);
				setState(101);
				comparison();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(R_CURLY_BRACKET);
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

	public static class While_loopContext extends ParserRuleContext {
		public TerminalNode DOWHILE() { return getToken(Formula4Parser.DOWHILE, 0); }
		public TerminalNode LPAR() { return getToken(Formula4Parser.LPAR, 0); }
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(Formula4Parser.RPAR, 0); }
		public List<TerminalNode> SEMI() { return getTokens(Formula4Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Formula4Parser.SEMI, i);
		}
		public TerminalNode WHILEDO() { return getToken(Formula4Parser.WHILEDO, 0); }
		public While_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterWhile_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitWhile_loop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitWhile_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_loopContext while_loop() throws RecognitionException {
		While_loopContext _localctx = new While_loopContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_while_loop);
		int _la;
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOWHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				match(DOWHILE);
				setState(110);
				match(LPAR);
				setState(111);
				comparison();
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMI) {
					{
					{
					setState(112);
					match(SEMI);
					setState(113);
					comparison();
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119);
				match(RPAR);
				}
				break;
			case WHILEDO:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(WHILEDO);
				setState(122);
				match(LPAR);
				setState(123);
				comparison();
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMI) {
					{
					{
					setState(124);
					match(SEMI);
					setState(125);
					comparison();
					}
					}
					setState(130);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(131);
				match(RPAR);
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

	public static class EvalContext extends ParserRuleContext {
		public TerminalNode EVAL() { return getToken(Formula4Parser.EVAL, 0); }
		public TerminalNode LPAR() { return getToken(Formula4Parser.LPAR, 0); }
		public List<TerminalNode> QUOT() { return getTokens(Formula4Parser.QUOT); }
		public TerminalNode QUOT(int i) {
			return getToken(Formula4Parser.QUOT, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(Formula4Parser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(Formula4Parser.NUMBER, i);
		}
		public TerminalNode RPAR() { return getToken(Formula4Parser.RPAR, 0); }
		public List<TerminalNode> PLUS() { return getTokens(Formula4Parser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(Formula4Parser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(Formula4Parser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(Formula4Parser.MINUS, i);
		}
		public List<TerminalNode> MULTI() { return getTokens(Formula4Parser.MULTI); }
		public TerminalNode MULTI(int i) {
			return getToken(Formula4Parser.MULTI, i);
		}
		public List<TerminalNode> DIV() { return getTokens(Formula4Parser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(Formula4Parser.DIV, i);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitEval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitEval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_eval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(EVAL);
			setState(136);
			match(LPAR);
			setState(137);
			match(QUOT);
			setState(138);
			match(NUMBER);
			setState(141); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(139);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULTI) | (1L << DIV))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(140);
				match(NUMBER);
				}
				}
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << MULTI) | (1L << DIV))) != 0) );
			setState(145);
			match(QUOT);
			setState(146);
			match(RPAR);
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

	public static class AtomContext extends ParserRuleContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(Formula4Parser.LPAR, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(Formula4Parser.RPAR, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atom);
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
				match(LPAR);
				setState(152);
				comparison();
				setState(153);
				match(RPAR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(155);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(156);
				assignment();
				}
				break;
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

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(Formula4Parser.LPAR, 0); }
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Formula4Parser.ASSIGN, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(Formula4Parser.RPAR, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(LPAR);
			setState(160);
			reference();
			setState(161);
			match(ASSIGN);
			setState(162);
			comparison();
			setState(163);
			match(RPAR);
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(Formula4Parser.FUNCTION, 0); }
		public TerminalNode LPAR() { return getToken(Formula4Parser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(Formula4Parser.RPAR, 0); }
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(Formula4Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Formula4Parser.SEMI, i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(FUNCTION);
			setState(166);
			match(LPAR);
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EVAL) | (1L << DOWHILE) | (1L << WHILEDO) | (1L << FOR) | (1L << FUNCTION) | (1L << CELL_REF) | (1L << VAR) | (1L << STRING) | (1L << NUMBER) | (1L << MINUS) | (1L << LPAR) | (1L << L_CURLY_BRACKET))) != 0)) {
				{
				setState(167);
				comparison();
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMI) {
					{
					{
					setState(168);
					match(SEMI);
					setState(169);
					comparison();
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(177);
			match(RPAR);
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

	public static class ReferenceContext extends ParserRuleContext {
		public List<TerminalNode> CELL_REF() { return getTokens(Formula4Parser.CELL_REF); }
		public TerminalNode CELL_REF(int i) {
			return getToken(Formula4Parser.CELL_REF, i);
		}
		public TerminalNode COLON() { return getToken(Formula4Parser.COLON, 0); }
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(CELL_REF);
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				{
				setState(180);
				match(COLON);
				}
				setState(181);
				match(CELL_REF);
				}
				break;
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(Formula4Parser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(Formula4Parser.STRING, 0); }
		public TerminalNode VAR() { return getToken(Formula4Parser.VAR, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula4Listener ) ((Formula4Listener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula4Visitor ) return ((Formula4Visitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VAR) | (1L << STRING) | (1L << NUMBER))) != 0)) ) {
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
		case 6:
			return concatenation_sempred((ConcatenationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean concatenation_sempred(ConcatenationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 8);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u00bd\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2"+
		"\5\2&\n\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\6\4\61\n\4\r\4\16\4\62\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\7\6;\n\6\f\6\16\6>\13\6\3\6\3\6\3\7\3\7\3\7\5\7"+
		"E\n\7\3\b\3\b\5\bI\n\b\3\b\3\b\3\b\3\b\5\bO\n\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b_\n\b\f\b\16\bb\13\b\3\t\3\t\3\t"+
		"\3\t\3\t\7\ti\n\t\f\t\16\tl\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\7\nu\n\n"+
		"\f\n\16\nx\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0081\n\n\f\n\16\n\u0084"+
		"\13\n\3\n\3\n\5\n\u0088\n\n\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u0090\n"+
		"\13\r\13\16\13\u0091\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\5\f\u00a0\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16"+
		"\u00ad\n\16\f\16\16\16\u00b0\13\16\5\16\u00b2\n\16\3\16\3\16\3\17\3\17"+
		"\3\17\5\17\u00b9\n\17\3\20\3\20\3\20\2\3\16\21\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36\2\7\3\2\24\27\4\2\r\22##\3\2\26\27\3\2\24\25\4\2\t\n\f"+
		"\f\2\u00c7\2%\3\2\2\2\4\'\3\2\2\2\6,\3\2\2\2\b\64\3\2\2\2\n\66\3\2\2\2"+
		"\fA\3\2\2\2\16N\3\2\2\2\20c\3\2\2\2\22\u0087\3\2\2\2\24\u0089\3\2\2\2"+
		"\26\u009f\3\2\2\2\30\u00a1\3\2\2\2\32\u00a7\3\2\2\2\34\u00b5\3\2\2\2\36"+
		"\u00ba\3\2\2\2 !\7\r\2\2!\"\5\f\7\2\"#\7\2\2\3#&\3\2\2\2$&\5\4\3\2% \3"+
		"\2\2\2%$\3\2\2\2&\3\3\2\2\2\'(\7$\2\2()\7!\2\2)*\5\6\4\2*+\7\"\2\2+\5"+
		"\3\2\2\2,\60\7&\2\2-.\5\b\5\2./\7&\2\2/\61\3\2\2\2\60-\3\2\2\2\61\62\3"+
		"\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\7\3\2\2\2\64\65\t\2\2\2\65\t\3\2"+
		"\2\2\66\67\7!\2\2\67<\5\f\7\289\7\36\2\29;\5\f\7\2:8\3\2\2\2;>\3\2\2\2"+
		"<:\3\2\2\2<=\3\2\2\2=?\3\2\2\2><\3\2\2\2?@\7\"\2\2@\13\3\2\2\2AD\5\16"+
		"\b\2BC\t\3\2\2CE\5\16\b\2DB\3\2\2\2DE\3\2\2\2E\r\3\2\2\2FH\b\b\1\2GI\7"+
		"\25\2\2HG\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JO\5\26\f\2KO\5\20\t\2LO\5\22\n\2"+
		"MO\5\24\13\2NF\3\2\2\2NK\3\2\2\2NL\3\2\2\2NM\3\2\2\2O`\3\2\2\2PQ\f\t\2"+
		"\2QR\7\30\2\2R_\5\16\b\tST\f\b\2\2TU\t\4\2\2U_\5\16\b\tVW\f\7\2\2WX\t"+
		"\5\2\2X_\5\16\b\bYZ\f\6\2\2Z[\7\23\2\2[_\5\16\b\7\\]\f\n\2\2]_\7\31\2"+
		"\2^P\3\2\2\2^S\3\2\2\2^V\3\2\2\2^Y\3\2\2\2^\\\3\2\2\2_b\3\2\2\2`^\3\2"+
		"\2\2`a\3\2\2\2a\17\3\2\2\2b`\3\2\2\2cd\7\6\2\2de\7!\2\2ej\5\f\7\2fg\7"+
		"\36\2\2gi\5\f\7\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj"+
		"\3\2\2\2mn\7\"\2\2n\21\3\2\2\2op\7\4\2\2pq\7\37\2\2qv\5\f\7\2rs\7\36\2"+
		"\2su\5\f\7\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2"+
		"\2yz\7 \2\2z\u0088\3\2\2\2{|\7\5\2\2|}\7\37\2\2}\u0082\5\f\7\2~\177\7"+
		"\36\2\2\177\u0081\5\f\7\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0086\7 \2\2\u0086\u0088\3\2\2\2\u0087o\3\2\2\2\u0087{\3\2\2\2\u0088"+
		"\23\3\2\2\2\u0089\u008a\7\3\2\2\u008a\u008b\7\37\2\2\u008b\u008c\7\13"+
		"\2\2\u008c\u008f\7\f\2\2\u008d\u008e\t\2\2\2\u008e\u0090\7\f\2\2\u008f"+
		"\u008d\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2"+
		"\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7\13\2\2\u0094\u0095\7 \2\2\u0095"+
		"\25\3\2\2\2\u0096\u00a0\5\32\16\2\u0097\u00a0\5\34\17\2\u0098\u00a0\5"+
		"\36\20\2\u0099\u009a\7\37\2\2\u009a\u009b\5\f\7\2\u009b\u009c\7 \2\2\u009c"+
		"\u00a0\3\2\2\2\u009d\u00a0\5\n\6\2\u009e\u00a0\5\30\r\2\u009f\u0096\3"+
		"\2\2\2\u009f\u0097\3\2\2\2\u009f\u0098\3\2\2\2\u009f\u0099\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\27\3\2\2\2\u00a1\u00a2\7\37\2"+
		"\2\u00a2\u00a3\5\34\17\2\u00a3\u00a4\7#\2\2\u00a4\u00a5\5\f\7\2\u00a5"+
		"\u00a6\7 \2\2\u00a6\31\3\2\2\2\u00a7\u00a8\7\7\2\2\u00a8\u00b1\7\37\2"+
		"\2\u00a9\u00ae\5\f\7\2\u00aa\u00ab\7\36\2\2\u00ab\u00ad\5\f\7\2\u00ac"+
		"\u00aa\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2"+
		"\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00a9\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\7 \2\2\u00b4\33\3\2\2\2"+
		"\u00b5\u00b8\7\b\2\2\u00b6\u00b7\7\32\2\2\u00b7\u00b9\7\b\2\2\u00b8\u00b6"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\35\3\2\2\2\u00ba\u00bb\t\6\2\2\u00bb"+
		"\37\3\2\2\2\23%\62<DHN^`jv\u0082\u0087\u0091\u009f\u00ae\u00b1\u00b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}