// Generated from lapr4/red/s2/lang/n1151117/formula/compiler/Formula3.g4 by ANTLR 4.7

    package lapr4.red.s2.lang.n1151117.formula.compiler;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Formula3Parser extends Parser {
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
	public static final int
		RULE_expression = 0, RULE_money_expression = 1, RULE_moneys = 2, RULE_money_operation = 3, 
		RULE_block = 4, RULE_comparison = 5, RULE_concatenation = 6, RULE_for_loop = 7, 
		RULE_atom = 8, RULE_assignment = 9, RULE_function_call = 10, RULE_reference = 11, 
		RULE_literal = 12;
	public static final String[] ruleNames = {
		"expression", "money_expression", "moneys", "money_operation", "block", 
		"comparison", "concatenation", "for_loop", "atom", "assignment", "function_call", 
		"reference", "literal"
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

	@Override
	public String getGrammarFileName() { return "Formula3.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Formula3Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(Formula3Parser.EQ, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Formula3Parser.EOF, 0); }
		public Money_expressionContext money_expression() {
			return getRuleContext(Money_expressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			setState(31);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EQ:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				match(EQ);
				setState(27);
				comparison();
				setState(28);
				match(EOF);
				}
				break;
			case TAGCURRENCY:
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
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
		public TerminalNode TAGCURRENCY() { return getToken(Formula3Parser.TAGCURRENCY, 0); }
		public TerminalNode L_CURLY_BRACKET() { return getToken(Formula3Parser.L_CURLY_BRACKET, 0); }
		public MoneysContext moneys() {
			return getRuleContext(MoneysContext.class,0);
		}
		public TerminalNode R_CURLY_BRACKET() { return getToken(Formula3Parser.R_CURLY_BRACKET, 0); }
		public Money_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_money_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterMoney_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitMoney_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitMoney_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Money_expressionContext money_expression() throws RecognitionException {
		Money_expressionContext _localctx = new Money_expressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_money_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(TAGCURRENCY);
			setState(34);
			match(L_CURLY_BRACKET);
			setState(35);
			moneys();
			setState(36);
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
		public List<TerminalNode> MONEY_NUM() { return getTokens(Formula3Parser.MONEY_NUM); }
		public TerminalNode MONEY_NUM(int i) {
			return getToken(Formula3Parser.MONEY_NUM, i);
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
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterMoneys(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitMoneys(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitMoneys(this);
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
			setState(38);
			match(MONEY_NUM);
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(39);
				money_operation();
				setState(40);
				match(MONEY_NUM);
				}
				}
				setState(44); 
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
		public TerminalNode PLUS() { return getToken(Formula3Parser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(Formula3Parser.MINUS, 0); }
		public TerminalNode MULTI() { return getToken(Formula3Parser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(Formula3Parser.DIV, 0); }
		public Money_operationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_money_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterMoney_operation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitMoney_operation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitMoney_operation(this);
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
			setState(46);
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
		public TerminalNode L_CURLY_BRACKET() { return getToken(Formula3Parser.L_CURLY_BRACKET, 0); }
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public TerminalNode R_CURLY_BRACKET() { return getToken(Formula3Parser.R_CURLY_BRACKET, 0); }
		public List<TerminalNode> SEMI() { return getTokens(Formula3Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Formula3Parser.SEMI, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitBlock(this);
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
			setState(48);
			match(L_CURLY_BRACKET);
			setState(49);
			comparison();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(50);
				match(SEMI);
				setState(51);
				comparison();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
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
		public TerminalNode EQ() { return getToken(Formula3Parser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(Formula3Parser.NEQ, 0); }
		public TerminalNode GT() { return getToken(Formula3Parser.GT, 0); }
		public TerminalNode LT() { return getToken(Formula3Parser.LT, 0); }
		public TerminalNode LTEQ() { return getToken(Formula3Parser.LTEQ, 0); }
		public TerminalNode GTEQ() { return getToken(Formula3Parser.GTEQ, 0); }
		public TerminalNode ASSIGN() { return getToken(Formula3Parser.ASSIGN, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitComparison(this);
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
			setState(59);
			concatenation(0);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT) | (1L << ASSIGN))) != 0)) {
				{
				setState(60);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQ) | (1L << NEQ) | (1L << LTEQ) | (1L << GTEQ) | (1L << GT) | (1L << LT) | (1L << ASSIGN))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(61);
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
		public TerminalNode MINUS() { return getToken(Formula3Parser.MINUS, 0); }
		public For_loopContext for_loop() {
			return getRuleContext(For_loopContext.class,0);
		}
		public List<ConcatenationContext> concatenation() {
			return getRuleContexts(ConcatenationContext.class);
		}
		public ConcatenationContext concatenation(int i) {
			return getRuleContext(ConcatenationContext.class,i);
		}
		public TerminalNode POWER() { return getToken(Formula3Parser.POWER, 0); }
		public TerminalNode MULTI() { return getToken(Formula3Parser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(Formula3Parser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(Formula3Parser.PLUS, 0); }
		public TerminalNode AMP() { return getToken(Formula3Parser.AMP, 0); }
		public TerminalNode PERCENT() { return getToken(Formula3Parser.PERCENT, 0); }
		public ConcatenationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatenation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterConcatenation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitConcatenation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitConcatenation(this);
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
			setState(70);
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
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MINUS) {
					{
					setState(65);
					match(MINUS);
					}
				}

				setState(68);
				atom();
				}
				break;
			case FOR:
				{
				setState(69);
				for_loop();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(86);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(72);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(73);
						match(POWER);
						setState(74);
						concatenation(5);
						}
						break;
					case 2:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(75);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(76);
						_la = _input.LA(1);
						if ( !(_la==MULTI || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(77);
						concatenation(5);
						}
						break;
					case 3:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(78);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(79);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(80);
						concatenation(4);
						}
						break;
					case 4:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(81);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(82);
						match(AMP);
						setState(83);
						concatenation(3);
						}
						break;
					case 5:
						{
						_localctx = new ConcatenationContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_concatenation);
						setState(84);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(85);
						match(PERCENT);
						}
						break;
					}
					} 
				}
				setState(90);
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
		public TerminalNode FOR() { return getToken(Formula3Parser.FOR, 0); }
		public TerminalNode L_CURLY_BRACKET() { return getToken(Formula3Parser.L_CURLY_BRACKET, 0); }
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public TerminalNode R_CURLY_BRACKET() { return getToken(Formula3Parser.R_CURLY_BRACKET, 0); }
		public List<TerminalNode> SEMI() { return getTokens(Formula3Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Formula3Parser.SEMI, i);
		}
		public For_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterFor_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitFor_loop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitFor_loop(this);
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
			setState(91);
			match(FOR);
			setState(92);
			match(L_CURLY_BRACKET);
			setState(93);
			comparison();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SEMI) {
				{
				{
				setState(94);
				match(SEMI);
				setState(95);
				comparison();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
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
		public TerminalNode LPAR() { return getToken(Formula3Parser.LPAR, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(Formula3Parser.RPAR, 0); }
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
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_atom);
		try {
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				reference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				literal();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				match(LPAR);
				setState(107);
				comparison();
				setState(108);
				match(RPAR);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(110);
				block();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(111);
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
		public TerminalNode LPAR() { return getToken(Formula3Parser.LPAR, 0); }
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Formula3Parser.ASSIGN, 0); }
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(Formula3Parser.RPAR, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(LPAR);
			setState(115);
			reference();
			setState(116);
			match(ASSIGN);
			setState(117);
			comparison();
			setState(118);
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
		public TerminalNode FUNCTION() { return getToken(Formula3Parser.FUNCTION, 0); }
		public TerminalNode LPAR() { return getToken(Formula3Parser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(Formula3Parser.RPAR, 0); }
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(Formula3Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Formula3Parser.SEMI, i);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(FUNCTION);
			setState(121);
			match(LPAR);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << FOR) | (1L << FUNCTION) | (1L << CELL_REF) | (1L << VAR) | (1L << STRING) | (1L << NUMBER) | (1L << MINUS) | (1L << LPAR) | (1L << L_CURLY_BRACKET))) != 0)) {
				{
				setState(122);
				comparison();
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SEMI) {
					{
					{
					setState(123);
					match(SEMI);
					setState(124);
					comparison();
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(132);
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
		public List<TerminalNode> CELL_REF() { return getTokens(Formula3Parser.CELL_REF); }
		public TerminalNode CELL_REF(int i) {
			return getToken(Formula3Parser.CELL_REF, i);
		}
		public TerminalNode COLON() { return getToken(Formula3Parser.COLON, 0); }
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(CELL_REF);
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				{
				setState(135);
				match(COLON);
				}
				setState(136);
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
		public TerminalNode NUMBER() { return getToken(Formula3Parser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(Formula3Parser.STRING, 0); }
		public TerminalNode VAR() { return getToken(Formula3Parser.VAR, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Formula3Listener ) ((Formula3Listener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Formula3Visitor ) return ((Formula3Visitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
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
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 6);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u0090\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\5\2\"\n\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\6\4-\n\4\r\4\16\4.\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\7\6\67\n\6\f\6\16\6:\13\6\3\6\3\6\3\7\3\7\3\7\5\7A\n\7\3\b\3\b\5\bE\n"+
		"\b\3\b\3\b\5\bI\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\7\bY\n\b\f\b\16\b\\\13\b\3\t\3\t\3\t\3\t\3\t\7\tc\n\t\f\t\16\t"+
		"f\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\ns\n\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\7\f\u0080\n\f\f\f\16\f\u0083"+
		"\13\f\5\f\u0085\n\f\3\f\3\f\3\r\3\r\3\r\5\r\u008c\n\r\3\16\3\16\3\16\2"+
		"\3\16\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\7\3\2\21\24\4\2\n\17  \3\2"+
		"\23\24\3\2\21\22\4\2\6\7\t\t\2\u0096\2!\3\2\2\2\4#\3\2\2\2\6(\3\2\2\2"+
		"\b\60\3\2\2\2\n\62\3\2\2\2\f=\3\2\2\2\16H\3\2\2\2\20]\3\2\2\2\22r\3\2"+
		"\2\2\24t\3\2\2\2\26z\3\2\2\2\30\u0088\3\2\2\2\32\u008d\3\2\2\2\34\35\7"+
		"\n\2\2\35\36\5\f\7\2\36\37\7\2\2\3\37\"\3\2\2\2 \"\5\4\3\2!\34\3\2\2\2"+
		"! \3\2\2\2\"\3\3\2\2\2#$\7!\2\2$%\7\36\2\2%&\5\6\4\2&\'\7\37\2\2\'\5\3"+
		"\2\2\2(,\7#\2\2)*\5\b\5\2*+\7#\2\2+-\3\2\2\2,)\3\2\2\2-.\3\2\2\2.,\3\2"+
		"\2\2./\3\2\2\2/\7\3\2\2\2\60\61\t\2\2\2\61\t\3\2\2\2\62\63\7\36\2\2\63"+
		"8\5\f\7\2\64\65\7\33\2\2\65\67\5\f\7\2\66\64\3\2\2\2\67:\3\2\2\28\66\3"+
		"\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\37\2\2<\13\3\2\2\2=@\5\16\b\2"+
		">?\t\3\2\2?A\5\16\b\2@>\3\2\2\2@A\3\2\2\2A\r\3\2\2\2BD\b\b\1\2CE\7\22"+
		"\2\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2FI\5\22\n\2GI\5\20\t\2HB\3\2\2\2HG\3"+
		"\2\2\2IZ\3\2\2\2JK\f\7\2\2KL\7\25\2\2LY\5\16\b\7MN\f\6\2\2NO\t\4\2\2O"+
		"Y\5\16\b\7PQ\f\5\2\2QR\t\5\2\2RY\5\16\b\6ST\f\4\2\2TU\7\20\2\2UY\5\16"+
		"\b\5VW\f\b\2\2WY\7\26\2\2XJ\3\2\2\2XM\3\2\2\2XP\3\2\2\2XS\3\2\2\2XV\3"+
		"\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\17\3\2\2\2\\Z\3\2\2\2]^\7\3\2\2"+
		"^_\7\36\2\2_d\5\f\7\2`a\7\33\2\2ac\5\f\7\2b`\3\2\2\2cf\3\2\2\2db\3\2\2"+
		"\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7\37\2\2h\21\3\2\2\2is\5\26\f\2js\5"+
		"\30\r\2ks\5\32\16\2lm\7\34\2\2mn\5\f\7\2no\7\35\2\2os\3\2\2\2ps\5\n\6"+
		"\2qs\5\24\13\2ri\3\2\2\2rj\3\2\2\2rk\3\2\2\2rl\3\2\2\2rp\3\2\2\2rq\3\2"+
		"\2\2s\23\3\2\2\2tu\7\34\2\2uv\5\30\r\2vw\7 \2\2wx\5\f\7\2xy\7\35\2\2y"+
		"\25\3\2\2\2z{\7\4\2\2{\u0084\7\34\2\2|\u0081\5\f\7\2}~\7\33\2\2~\u0080"+
		"\5\f\7\2\177}\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0084|\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\35\2\2\u0087\27\3\2\2"+
		"\2\u0088\u008b\7\5\2\2\u0089\u008a\7\27\2\2\u008a\u008c\7\5\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\31\3\2\2\2\u008d\u008e\t\6\2"+
		"\2\u008e\33\3\2\2\2\17!.8@DHXZdr\u0081\u0084\u008b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}