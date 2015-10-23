// Generated from /Users/jacktimblin/ExpressionParser/Expression.g4 by ANTLR 4.5.1

package org.expression.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		RETURN=1, FUNCTION=2, INCREMENT=3, DECREMENT=4, LBRACE=5, UNDERSCORE=6, 
		RBRACE=7, PLUS=8, MINUS=9, TIMES=10, DIV=11, POW=12, LPAREN=13, RPAREN=14, 
		E=15, SEMI_COLON=16, LOGICAL=17, OPERATOR=18, SYMBOL=19, COMMA=20, GT=21, 
		LT=22, AND=23, OR=24, GTE=25, LTE=26, EQ=27, NEQ=28, ASSIGN=29, DIGIT=30, 
		POINT=31, VAR=32, IF=33, ELSE=34, ELSEIF=35, FOR=36, WHILE=37, LETTER=38, 
		WS=39, MODULO=40, NEW=41, QMARK=42, COLON=43, PRI=44, BLOCKLEFT=45, BLOCKRIGHT=46, 
		COMMENT=47, LINE_COMMENT=48;
	public static final int
		RULE_start = 0, RULE_expression = 1, RULE_expr = 2, RULE_atom = 3, RULE_incDecExpression = 4, 
		RULE_controlStatement = 5, RULE_logicalOperation = 6, RULE_forcedLogicalOperation = 7, 
		RULE_newStructure = 8, RULE_ternary = 9, RULE_forLoop = 10, RULE_whileLoop = 11, 
		RULE_ifStatement = 12, RULE_elseifStatement = 13, RULE_elseStatement = 14, 
		RULE_arrayAccess = 15, RULE_print = 16, RULE_index = 17, RULE_assignment = 18, 
		RULE_number = 19, RULE_scientific = 20, RULE_func = 21, RULE_funcParams = 22, 
		RULE_returnStatement = 23, RULE_procedureParams = 24, RULE_procedure = 25, 
		RULE_array = 26, RULE_column = 27, RULE_arrayInner = 28, RULE_matrix = 29, 
		RULE_funcName = 30, RULE_variable = 31;
	public static final String[] ruleNames = {
		"start", "expression", "expr", "atom", "incDecExpression", "controlStatement", 
		"logicalOperation", "forcedLogicalOperation", "newStructure", "ternary", 
		"forLoop", "whileLoop", "ifStatement", "elseifStatement", "elseStatement", 
		"arrayAccess", "print", "index", "assignment", "number", "scientific", 
		"func", "funcParams", "returnStatement", "procedureParams", "procedure", 
		"array", "column", "arrayInner", "matrix", "funcName", "variable"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'return'", "'function'", null, null, "'['", "'_'", "']'", "'+'", 
		"'-'", "'*'", "'/'", "'^'", "'('", "')'", "'e'", "';'", null, null, null, 
		"','", "'>'", "'<'", "'&&'", "'||'", "'>='", "'<='", "'=='", "'!='", "'='", 
		null, "'.'", "'var'", "'if'", "'else'", "'elseif'", "'for'", "'while'", 
		null, null, "'%'", "'new'", "'?'", "':'", "'print'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "RETURN", "FUNCTION", "INCREMENT", "DECREMENT", "LBRACE", "UNDERSCORE", 
		"RBRACE", "PLUS", "MINUS", "TIMES", "DIV", "POW", "LPAREN", "RPAREN", 
		"E", "SEMI_COLON", "LOGICAL", "OPERATOR", "SYMBOL", "COMMA", "GT", "LT", 
		"AND", "OR", "GTE", "LTE", "EQ", "NEQ", "ASSIGN", "DIGIT", "POINT", "VAR", 
		"IF", "ELSE", "ELSEIF", "FOR", "WHILE", "LETTER", "WS", "MODULO", "NEW", 
		"QMARK", "COLON", "PRI", "BLOCKLEFT", "BLOCKRIGHT", "COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<PrintContext> print() {
			return getRuleContexts(PrintContext.class);
		}
		public PrintContext print(int i) {
			return getRuleContext(PrintContext.class,i);
		}
		public List<AssignmentContext> assignment() {
			return getRuleContexts(AssignmentContext.class);
		}
		public AssignmentContext assignment(int i) {
			return getRuleContext(AssignmentContext.class,i);
		}
		public List<ControlStatementContext> controlStatement() {
			return getRuleContexts(ControlStatementContext.class);
		}
		public ControlStatementContext controlStatement(int i) {
			return getRuleContext(ControlStatementContext.class,i);
		}
		public List<ProcedureContext> procedure() {
			return getRuleContexts(ProcedureContext.class);
		}
		public ProcedureContext procedure(int i) {
			return getRuleContext(ProcedureContext.class,i);
		}
		public List<ReturnStatementContext> returnStatement() {
			return getRuleContexts(ReturnStatementContext.class);
		}
		public ReturnStatementContext returnStatement(int i) {
			return getRuleContext(ReturnStatementContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(64);
				expression();
				}
				break;
			case 2:
				{
				setState(65);
				print();
				}
				break;
			case 3:
				{
				setState(66);
				assignment();
				}
				break;
			case 4:
				{
				setState(67);
				controlStatement();
				}
				break;
			case 5:
				{
				setState(68);
				procedure();
				}
				break;
			case 6:
				{
				setState(69);
				returnStatement();
				}
				break;
			}
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI))) != 0)) {
				{
				setState(78);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(72);
					expression();
					}
					break;
				case 2:
					{
					setState(73);
					print();
					}
					break;
				case 3:
					{
					setState(74);
					assignment();
					}
					break;
				case 4:
					{
					setState(75);
					controlStatement();
					}
					break;
				case 5:
					{
					setState(76);
					procedure();
					}
					break;
				case 6:
					{
					setState(77);
					returnStatement();
					}
					break;
				}
				}
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(ExpressionParser.SEMI_COLON, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			expr(0);
			setState(84);
			match(SEMI_COLON);
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewExprContext extends ExprContext {
		public NewStructureContext newStructure() {
			return getRuleContext(NewStructureContext.class,0);
		}
		public NewExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitNewExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayAccessExprContext extends ExprContext {
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public ArrayAccessExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterArrayAccessExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitArrayAccessExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitArrayAccessExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncExprContext extends ExprContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public FuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFuncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFuncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OpExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode POW() { return getToken(ExpressionParser.POW, 0); }
		public TerminalNode TIMES() { return getToken(ExpressionParser.TIMES, 0); }
		public TerminalNode DIV() { return getToken(ExpressionParser.DIV, 0); }
		public TerminalNode PLUS() { return getToken(ExpressionParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(ExpressionParser.MINUS, 0); }
		public TerminalNode OPERATOR() { return getToken(ExpressionParser.OPERATOR, 0); }
		public TerminalNode POINT() { return getToken(ExpressionParser.POINT, 0); }
		public OpExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterOpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitOpExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TernaryExprContext extends ExprContext {
		public TernaryContext ternary() {
			return getRuleContext(TernaryContext.class,0);
		}
		public TernaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterTernaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitTernaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitTernaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IncDecExprContext extends ExprContext {
		public IncDecExpressionContext incDecExpression() {
			return getRuleContext(IncDecExpressionContext.class,0);
		}
		public IncDecExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterIncDecExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitIncDecExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitIncDecExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExprContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOGICAL() { return getToken(ExpressionParser.LOGICAL, 0); }
		public BoolExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(ExpressionParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(87);
				newStructure();
				}
				break;
			case 2:
				{
				_localctx = new IncDecExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				incDecExpression();
				}
				break;
			case 3:
				{
				_localctx = new ArrayAccessExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				arrayAccess();
				}
				break;
			case 4:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(LPAREN);
				setState(91);
				expr(0);
				setState(92);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new TernaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(94);
				ternary();
				}
				break;
			case 6:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(95);
				func();
				}
				break;
			case 7:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(117);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						((BoolExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(99);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(100);
						((BoolExprContext)_localctx).op = match(LOGICAL);
						setState(101);
						((BoolExprContext)_localctx).right = expr(10);
						}
						break;
					case 2:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(102);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(103);
						((OpExprContext)_localctx).op = match(POW);
						setState(104);
						((OpExprContext)_localctx).right = expr(9);
						}
						break;
					case 3:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(105);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(106);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIV) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(107);
						((OpExprContext)_localctx).right = expr(8);
						}
						break;
					case 4:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(108);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(109);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(110);
						((OpExprContext)_localctx).right = expr(7);
						}
						break;
					case 5:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(111);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(112);
						((OpExprContext)_localctx).op = match(OPERATOR);
						setState(113);
						((OpExprContext)_localctx).right = expr(6);
						}
						break;
					case 6:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(114);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(115);
						((OpExprContext)_localctx).op = match(POINT);
						setState(116);
						((OpExprContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtomValueContext extends AtomContext {
		public ScientificContext scientific() {
			return getRuleContext(ScientificContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
		}
		public AtomValueContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAtomValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAtomValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAtomValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atom);
		try {
			setState(126);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				scientific();
				}
				break;
			case 2:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				variable();
				}
				break;
			case 3:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				array();
				}
				break;
			case 4:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(125);
				matrix();
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

	public static class IncDecExpressionContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode INCREMENT() { return getToken(ExpressionParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(ExpressionParser.DECREMENT, 0); }
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public IncDecExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incDecExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterIncDecExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitIncDecExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitIncDecExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncDecExpressionContext incDecExpression() throws RecognitionException {
		IncDecExpressionContext _localctx = new IncDecExpressionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_incDecExpression);
		int _la;
		try {
			setState(134);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				atom();
				setState(129);
				_la = _input.LA(1);
				if ( !(_la==INCREMENT || _la==DECREMENT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				func();
				setState(132);
				_la = _input.LA(1);
				if ( !(_la==INCREMENT || _la==DECREMENT) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
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

	public static class ControlStatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public ControlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterControlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitControlStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitControlStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlStatementContext controlStatement() throws RecognitionException {
		ControlStatementContext _localctx = new ControlStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_controlStatement);
		try {
			setState(139);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				ifStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				forLoop();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(138);
				whileLoop();
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

	public static class LogicalOperationContext extends ParserRuleContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOGICAL() { return getToken(ExpressionParser.LOGICAL, 0); }
		public LogicalOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterLogicalOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitLogicalOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitLogicalOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalOperationContext logicalOperation() throws RecognitionException {
		LogicalOperationContext _localctx = new LogicalOperationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_logicalOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			((LogicalOperationContext)_localctx).left = expr(0);
			setState(142);
			((LogicalOperationContext)_localctx).op = match(LOGICAL);
			setState(143);
			((LogicalOperationContext)_localctx).right = expr(0);
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

	public static class ForcedLogicalOperationContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode LOGICAL() { return getToken(ExpressionParser.LOGICAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForcedLogicalOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forcedLogicalOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterForcedLogicalOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitForcedLogicalOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitForcedLogicalOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForcedLogicalOperationContext forcedLogicalOperation() throws RecognitionException {
		ForcedLogicalOperationContext _localctx = new ForcedLogicalOperationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_forcedLogicalOperation);
		try {
			setState(153);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				variable();
				setState(146);
				match(LOGICAL);
				setState(147);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				expr(0);
				setState(150);
				match(LOGICAL);
				setState(151);
				variable();
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

	public static class NewStructureContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(ExpressionParser.NEW, 0); }
		public TerminalNode LBRACE() { return getToken(ExpressionParser.LBRACE, 0); }
		public List<IndexContext> index() {
			return getRuleContexts(IndexContext.class);
		}
		public IndexContext index(int i) {
			return getRuleContext(IndexContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(ExpressionParser.RBRACE, 0); }
		public TerminalNode COMMA() { return getToken(ExpressionParser.COMMA, 0); }
		public NewStructureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newStructure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterNewStructure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitNewStructure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitNewStructure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewStructureContext newStructure() throws RecognitionException {
		NewStructureContext _localctx = new NewStructureContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_newStructure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(NEW);
			setState(156);
			match(LBRACE);
			setState(157);
			index();
			setState(160);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(158);
				match(COMMA);
				setState(159);
				index();
				}
			}

			setState(162);
			match(RBRACE);
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

	public static class TernaryContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(ExpressionParser.LPAREN, 0); }
		public LogicalOperationContext logicalOperation() {
			return getRuleContext(LogicalOperationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
		public TerminalNode QMARK() { return getToken(ExpressionParser.QMARK, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COLON() { return getToken(ExpressionParser.COLON, 0); }
		public TernaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterTernary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitTernary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitTernary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TernaryContext ternary() throws RecognitionException {
		TernaryContext _localctx = new TernaryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ternary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(LPAREN);
			setState(165);
			logicalOperation();
			setState(166);
			match(RPAREN);
			setState(167);
			match(QMARK);
			setState(168);
			expr(0);
			setState(169);
			match(COLON);
			setState(170);
			expr(0);
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

	public static class ForLoopContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(ExpressionParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(ExpressionParser.LPAREN, 0); }
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ForcedLogicalOperationContext forcedLogicalOperation() {
			return getRuleContext(ForcedLogicalOperationContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(ExpressionParser.SEMI_COLON, 0); }
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
		public TerminalNode BLOCKLEFT() { return getToken(ExpressionParser.BLOCKLEFT, 0); }
		public TerminalNode BLOCKRIGHT() { return getToken(ExpressionParser.BLOCKRIGHT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode INCREMENT() { return getToken(ExpressionParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(ExpressionParser.DECREMENT, 0); }
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(FOR);
			setState(173);
			match(LPAREN);
			setState(174);
			assignment();
			setState(175);
			forcedLogicalOperation();
			setState(176);
			match(SEMI_COLON);
			{
			setState(177);
			variable();
			setState(178);
			_la = _input.LA(1);
			if ( !(_la==INCREMENT || _la==DECREMENT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
			setState(180);
			match(RPAREN);
			setState(181);
			match(BLOCKLEFT);
			setState(183);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI))) != 0)) {
				{
				setState(182);
				start();
				}
			}

			setState(185);
			match(BLOCKRIGHT);
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

	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ExpressionParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(ExpressionParser.LPAREN, 0); }
		public ForcedLogicalOperationContext forcedLogicalOperation() {
			return getRuleContext(ForcedLogicalOperationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
		public TerminalNode BLOCKLEFT() { return getToken(ExpressionParser.BLOCKLEFT, 0); }
		public TerminalNode BLOCKRIGHT() { return getToken(ExpressionParser.BLOCKRIGHT, 0); }
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_whileLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(WHILE);
			setState(188);
			match(LPAREN);
			setState(189);
			forcedLogicalOperation();
			setState(190);
			match(RPAREN);
			setState(191);
			match(BLOCKLEFT);
			setState(193);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI))) != 0)) {
				{
				setState(192);
				start();
				}
			}

			setState(195);
			match(BLOCKRIGHT);
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(ExpressionParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(ExpressionParser.LPAREN, 0); }
		public LogicalOperationContext logicalOperation() {
			return getRuleContext(LogicalOperationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
		public TerminalNode BLOCKLEFT() { return getToken(ExpressionParser.BLOCKLEFT, 0); }
		public TerminalNode BLOCKRIGHT() { return getToken(ExpressionParser.BLOCKRIGHT, 0); }
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public List<ElseifStatementContext> elseifStatement() {
			return getRuleContexts(ElseifStatementContext.class);
		}
		public ElseifStatementContext elseifStatement(int i) {
			return getRuleContext(ElseifStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(IF);
			setState(198);
			match(LPAREN);
			setState(199);
			logicalOperation();
			setState(200);
			match(RPAREN);
			setState(201);
			match(BLOCKLEFT);
			setState(203);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI))) != 0)) {
				{
				setState(202);
				start();
				}
			}

			setState(205);
			match(BLOCKRIGHT);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(206);
				elseifStatement();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(213);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(212);
				elseStatement();
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

	public static class ElseifStatementContext extends ParserRuleContext {
		public TerminalNode ELSEIF() { return getToken(ExpressionParser.ELSEIF, 0); }
		public TerminalNode LPAREN() { return getToken(ExpressionParser.LPAREN, 0); }
		public LogicalOperationContext logicalOperation() {
			return getRuleContext(LogicalOperationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
		public TerminalNode BLOCKLEFT() { return getToken(ExpressionParser.BLOCKLEFT, 0); }
		public TerminalNode BLOCKRIGHT() { return getToken(ExpressionParser.BLOCKRIGHT, 0); }
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public ElseifStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterElseifStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitElseifStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitElseifStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseifStatementContext elseifStatement() throws RecognitionException {
		ElseifStatementContext _localctx = new ElseifStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_elseifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(ELSEIF);
			setState(216);
			match(LPAREN);
			setState(217);
			logicalOperation();
			setState(218);
			match(RPAREN);
			setState(219);
			match(BLOCKLEFT);
			setState(221);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI))) != 0)) {
				{
				setState(220);
				start();
				}
			}

			setState(223);
			match(BLOCKRIGHT);
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

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(ExpressionParser.ELSE, 0); }
		public TerminalNode BLOCKLEFT() { return getToken(ExpressionParser.BLOCKLEFT, 0); }
		public TerminalNode BLOCKRIGHT() { return getToken(ExpressionParser.BLOCKRIGHT, 0); }
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitElseStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitElseStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(ELSE);
			setState(226);
			match(BLOCKLEFT);
			setState(228);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI))) != 0)) {
				{
				setState(227);
				start();
				}
			}

			setState(230);
			match(BLOCKRIGHT);
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

	public static class ArrayAccessContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ExpressionParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ExpressionParser.RBRACE, 0); }
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<IndexContext> index() {
			return getRuleContexts(IndexContext.class);
		}
		public IndexContext index(int i) {
			return getRuleContext(IndexContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(ExpressionParser.COMMA, 0); }
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_arrayAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(232);
				func();
				}
				break;
			case 2:
				{
				setState(233);
				atom();
				}
				break;
			}
			setState(236);
			match(LBRACE);
			{
			setState(237);
			index();
			setState(240);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(238);
				match(COMMA);
				setState(239);
				index();
				}
			}

			}
			setState(242);
			match(RBRACE);
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

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRI() { return getToken(ExpressionParser.PRI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(PRI);
			setState(245);
			expression();
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

	public static class IndexContext extends ParserRuleContext {
		public TerminalNode DIGIT() { return getToken(ExpressionParser.DIGIT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitIndex(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_index);
		try {
			setState(249);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				match(DIGIT);
				}
				break;
			case MINUS:
			case E:
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				variable();
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

	public static class AssignmentContext extends ParserRuleContext {
		public VariableContext varName;
		public TerminalNode VAR() { return getToken(ExpressionParser.VAR, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(ExpressionParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(ExpressionParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ExpressionParser.RBRACE, 0); }
		public List<IndexContext> index() {
			return getRuleContexts(IndexContext.class);
		}
		public IndexContext index(int i) {
			return getRuleContext(IndexContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(ExpressionParser.COMMA, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_assignment);
		int _la;
		try {
			setState(270);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(VAR);
				setState(252);
				variable();
				setState(253);
				match(ASSIGN);
				setState(254);
				expression();
				}
				break;
			case MINUS:
			case E:
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				((AssignmentContext)_localctx).varName = variable();
				setState(265);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(257);
					match(LBRACE);
					{
					{
					setState(258);
					index();
					}
					setState(261);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(259);
						match(COMMA);
						setState(260);
						index();
						}
					}

					}
					setState(263);
					match(RBRACE);
					}
				}

				setState(267);
				match(ASSIGN);
				setState(268);
				expression();
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(ExpressionParser.MINUS, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(ExpressionParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(ExpressionParser.DIGIT, i);
		}
		public TerminalNode POINT() { return getToken(ExpressionParser.POINT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_number);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(272);
				match(MINUS);
				}
			}

			setState(276); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(275);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(278); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(286);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(280);
				match(POINT);
				setState(282); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(281);
						match(DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(284); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ScientificContext extends ParserRuleContext {
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public TerminalNode E() { return getToken(ExpressionParser.E, 0); }
		public ScientificContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scientific; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterScientific(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitScientific(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitScientific(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScientificContext scientific() throws RecognitionException {
		ScientificContext _localctx = new ScientificContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_scientific);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			number();
			setState(291);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(289);
				match(E);
				setState(290);
				number();
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

	public static class FuncContext extends ParserRuleContext {
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	 
		public FuncContext() { }
		public void copyFrom(FuncContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FuncDefinitionContext extends FuncContext {
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ExpressionParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
		public FuncParamsContext funcParams() {
			return getRuleContext(FuncParamsContext.class,0);
		}
		public FuncDefinitionContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFuncDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFuncDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFuncDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_func);
		int _la;
		try {
			_localctx = new FuncDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			funcName();
			setState(294);
			match(LPAREN);
			setState(296);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << LETTER) | (1L << NEW))) != 0)) {
				{
				setState(295);
				funcParams();
				}
			}

			setState(298);
			match(RPAREN);
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

	public static class FuncParamsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExpressionParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExpressionParser.COMMA, i);
		}
		public FuncParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFuncParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFuncParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFuncParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncParamsContext funcParams() throws RecognitionException {
		FuncParamsContext _localctx = new FuncParamsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_funcParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(300);
			expr(0);
			}
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(301);
				match(COMMA);
				{
				setState(302);
				expr(0);
				}
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(ExpressionParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(RETURN);
			setState(309);
			expression();
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

	public static class ProcedureParamsContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExpressionParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExpressionParser.COMMA, i);
		}
		public ProcedureParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterProcedureParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitProcedureParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitProcedureParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureParamsContext procedureParams() throws RecognitionException {
		ProcedureParamsContext _localctx = new ProcedureParamsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_procedureParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(311);
			variable();
			}
			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(312);
				match(COMMA);
				{
				setState(313);
				variable();
				}
				}
				}
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ProcedureContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(ExpressionParser.FUNCTION, 0); }
		public FuncNameContext funcName() {
			return getRuleContext(FuncNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ExpressionParser.LPAREN, 0); }
		public ProcedureParamsContext procedureParams() {
			return getRuleContext(ProcedureParamsContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
		public TerminalNode BLOCKLEFT() { return getToken(ExpressionParser.BLOCKLEFT, 0); }
		public TerminalNode BLOCKRIGHT() { return getToken(ExpressionParser.BLOCKRIGHT, 0); }
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public ProcedureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedure; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterProcedure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitProcedure(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitProcedure(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureContext procedure() throws RecognitionException {
		ProcedureContext _localctx = new ProcedureContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(FUNCTION);
			setState(320);
			funcName();
			setState(321);
			match(LPAREN);
			setState(322);
			procedureParams();
			setState(323);
			match(RPAREN);
			setState(324);
			match(BLOCKLEFT);
			setState(326);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI))) != 0)) {
				{
				setState(325);
				start();
				}
			}

			setState(328);
			match(BLOCKRIGHT);
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

	public static class ArrayContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ExpressionParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ExpressionParser.RBRACE, 0); }
		public TerminalNode MINUS() { return getToken(ExpressionParser.MINUS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExpressionParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExpressionParser.COMMA, i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(330);
				match(MINUS);
				}
			}

			setState(333);
			match(LBRACE);
			setState(342);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << LETTER) | (1L << NEW))) != 0)) {
				{
				{
				setState(334);
				expr(0);
				}
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(335);
					match(COMMA);
					{
					setState(336);
					expr(0);
					}
					}
					}
					setState(341);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(344);
			match(RBRACE);
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

	public static class ColumnContext extends ParserRuleContext {
		public ArrayInnerContext arrayInner() {
			return getRuleContext(ArrayInnerContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(ExpressionParser.SEMI_COLON, 0); }
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			arrayInner();
			setState(347);
			match(SEMI_COLON);
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

	public static class ArrayInnerContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ExpressionParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ExpressionParser.COMMA, i);
		}
		public ArrayInnerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInner; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterArrayInner(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitArrayInner(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitArrayInner(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayInnerContext arrayInner() throws RecognitionException {
		ArrayInnerContext _localctx = new ArrayInnerContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arrayInner);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(349);
			expr(0);
			}
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(350);
				match(COMMA);
				{
				setState(351);
				expr(0);
				}
				}
				}
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class MatrixContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ExpressionParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ExpressionParser.RBRACE, 0); }
		public ArrayInnerContext arrayInner() {
			return getRuleContext(ArrayInnerContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(ExpressionParser.MINUS, 0); }
		public List<ColumnContext> column() {
			return getRuleContexts(ColumnContext.class);
		}
		public ColumnContext column(int i) {
			return getRuleContext(ColumnContext.class,i);
		}
		public MatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitMatrix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitMatrix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_matrix);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(357);
				match(MINUS);
				}
			}

			setState(360);
			match(LBRACE);
			setState(371);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				{
				setState(361);
				column();
				setState(365);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(362);
						column();
						}
						} 
					}
					setState(367);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				setState(368);
				arrayInner();
				}
				}
				break;
			case 2:
				{
				setState(370);
				arrayInner();
				}
				break;
			}
			setState(373);
			match(RBRACE);
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

	public static class FuncNameContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(ExpressionParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(ExpressionParser.LETTER, i);
		}
		public List<TerminalNode> E() { return getTokens(ExpressionParser.E); }
		public TerminalNode E(int i) {
			return getToken(ExpressionParser.E, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(ExpressionParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(ExpressionParser.DIGIT, i);
		}
		public List<TerminalNode> UNDERSCORE() { return getTokens(ExpressionParser.UNDERSCORE); }
		public TerminalNode UNDERSCORE(int i) {
			return getToken(ExpressionParser.UNDERSCORE, i);
		}
		public FuncNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFuncName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFuncName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFuncName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncNameContext funcName() throws RecognitionException {
		FuncNameContext _localctx = new FuncNameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_funcName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			_la = _input.LA(1);
			if ( !(_la==E || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				{
				setState(376);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class VariableContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(ExpressionParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(ExpressionParser.LETTER, i);
		}
		public List<TerminalNode> E() { return getTokens(ExpressionParser.E); }
		public TerminalNode E(int i) {
			return getToken(ExpressionParser.E, i);
		}
		public TerminalNode MINUS() { return getToken(ExpressionParser.MINUS, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(ExpressionParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(ExpressionParser.DIGIT, i);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_variable);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(382);
				match(MINUS);
				}
			}

			setState(385);
			_la = _input.LA(1);
			if ( !(_la==E || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(389);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(386);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(391);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
		case 2:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u018b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\3\2\3\2\3\2\3\2\5\2I\n\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2Q\n\2"+
		"\f\2\16\2T\13\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\5\4d\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\7\4x\n\4\f\4\16\4{\13\4\3\5\3\5\3\5\3\5\5\5\u0081\n\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6\u0089\n\6\3\7\3\7\3\7\5\7\u008e\n\7\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u009c\n\t\3\n\3\n\3\n\3\n"+
		"\3\n\5\n\u00a3\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ba\n\f\3\f\3\f\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u00c4\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\5"+
		"\16\u00ce\n\16\3\16\3\16\7\16\u00d2\n\16\f\16\16\16\u00d5\13\16\3\16\5"+
		"\16\u00d8\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00e0\n\17\3\17\3\17"+
		"\3\20\3\20\3\20\5\20\u00e7\n\20\3\20\3\20\3\21\3\21\5\21\u00ed\n\21\3"+
		"\21\3\21\3\21\3\21\5\21\u00f3\n\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\5\23\u00fc\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24"+
		"\u0108\n\24\3\24\3\24\5\24\u010c\n\24\3\24\3\24\3\24\5\24\u0111\n\24\3"+
		"\25\5\25\u0114\n\25\3\25\6\25\u0117\n\25\r\25\16\25\u0118\3\25\3\25\6"+
		"\25\u011d\n\25\r\25\16\25\u011e\5\25\u0121\n\25\3\26\3\26\3\26\5\26\u0126"+
		"\n\26\3\27\3\27\3\27\5\27\u012b\n\27\3\27\3\27\3\30\3\30\3\30\7\30\u0132"+
		"\n\30\f\30\16\30\u0135\13\30\3\31\3\31\3\31\3\32\3\32\3\32\7\32\u013d"+
		"\n\32\f\32\16\32\u0140\13\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u0149"+
		"\n\33\3\33\3\33\3\34\5\34\u014e\n\34\3\34\3\34\3\34\3\34\7\34\u0154\n"+
		"\34\f\34\16\34\u0157\13\34\5\34\u0159\n\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\36\3\36\3\36\7\36\u0163\n\36\f\36\16\36\u0166\13\36\3\37\5\37\u0169\n"+
		"\37\3\37\3\37\3\37\7\37\u016e\n\37\f\37\16\37\u0171\13\37\3\37\3\37\3"+
		"\37\5\37\u0176\n\37\3\37\3\37\3 \3 \7 \u017c\n \f \16 \u017f\13 \3!\5"+
		"!\u0182\n!\3!\3!\7!\u0186\n!\f!\16!\u0189\13!\3!\2\3\6\"\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\b\3\2\f\r\3\2\n\13"+
		"\3\2\5\6\4\2\21\21((\6\2\b\b\21\21  ((\5\2\21\21  ((\u01a9\2H\3\2\2\2"+
		"\4U\3\2\2\2\6c\3\2\2\2\b\u0080\3\2\2\2\n\u0088\3\2\2\2\f\u008d\3\2\2\2"+
		"\16\u008f\3\2\2\2\20\u009b\3\2\2\2\22\u009d\3\2\2\2\24\u00a6\3\2\2\2\26"+
		"\u00ae\3\2\2\2\30\u00bd\3\2\2\2\32\u00c7\3\2\2\2\34\u00d9\3\2\2\2\36\u00e3"+
		"\3\2\2\2 \u00ec\3\2\2\2\"\u00f6\3\2\2\2$\u00fb\3\2\2\2&\u0110\3\2\2\2"+
		"(\u0113\3\2\2\2*\u0122\3\2\2\2,\u0127\3\2\2\2.\u012e\3\2\2\2\60\u0136"+
		"\3\2\2\2\62\u0139\3\2\2\2\64\u0141\3\2\2\2\66\u014d\3\2\2\28\u015c\3\2"+
		"\2\2:\u015f\3\2\2\2<\u0168\3\2\2\2>\u0179\3\2\2\2@\u0181\3\2\2\2BI\5\4"+
		"\3\2CI\5\"\22\2DI\5&\24\2EI\5\f\7\2FI\5\64\33\2GI\5\60\31\2HB\3\2\2\2"+
		"HC\3\2\2\2HD\3\2\2\2HE\3\2\2\2HF\3\2\2\2HG\3\2\2\2IR\3\2\2\2JQ\5\4\3\2"+
		"KQ\5\"\22\2LQ\5&\24\2MQ\5\f\7\2NQ\5\64\33\2OQ\5\60\31\2PJ\3\2\2\2PK\3"+
		"\2\2\2PL\3\2\2\2PM\3\2\2\2PN\3\2\2\2PO\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3"+
		"\2\2\2S\3\3\2\2\2TR\3\2\2\2UV\5\6\4\2VW\7\22\2\2W\5\3\2\2\2XY\b\4\1\2"+
		"Yd\5\22\n\2Zd\5\n\6\2[d\5 \21\2\\]\7\17\2\2]^\5\6\4\2^_\7\20\2\2_d\3\2"+
		"\2\2`d\5\24\13\2ad\5,\27\2bd\5\b\5\2cX\3\2\2\2cZ\3\2\2\2c[\3\2\2\2c\\"+
		"\3\2\2\2c`\3\2\2\2ca\3\2\2\2cb\3\2\2\2dy\3\2\2\2ef\f\13\2\2fg\7\23\2\2"+
		"gx\5\6\4\fhi\f\n\2\2ij\7\16\2\2jx\5\6\4\13kl\f\t\2\2lm\t\2\2\2mx\5\6\4"+
		"\nno\f\b\2\2op\t\3\2\2px\5\6\4\tqr\f\7\2\2rs\7\24\2\2sx\5\6\4\btu\f\3"+
		"\2\2uv\7!\2\2vx\5\6\4\4we\3\2\2\2wh\3\2\2\2wk\3\2\2\2wn\3\2\2\2wq\3\2"+
		"\2\2wt\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z\7\3\2\2\2{y\3\2\2\2|\u0081"+
		"\5*\26\2}\u0081\5@!\2~\u0081\5\66\34\2\177\u0081\5<\37\2\u0080|\3\2\2"+
		"\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081\t\3\2\2\2\u0082"+
		"\u0083\5\b\5\2\u0083\u0084\t\4\2\2\u0084\u0089\3\2\2\2\u0085\u0086\5,"+
		"\27\2\u0086\u0087\t\4\2\2\u0087\u0089\3\2\2\2\u0088\u0082\3\2\2\2\u0088"+
		"\u0085\3\2\2\2\u0089\13\3\2\2\2\u008a\u008e\5\32\16\2\u008b\u008e\5\26"+
		"\f\2\u008c\u008e\5\30\r\2\u008d\u008a\3\2\2\2\u008d\u008b\3\2\2\2\u008d"+
		"\u008c\3\2\2\2\u008e\r\3\2\2\2\u008f\u0090\5\6\4\2\u0090\u0091\7\23\2"+
		"\2\u0091\u0092\5\6\4\2\u0092\17\3\2\2\2\u0093\u0094\5@!\2\u0094\u0095"+
		"\7\23\2\2\u0095\u0096\5\6\4\2\u0096\u009c\3\2\2\2\u0097\u0098\5\6\4\2"+
		"\u0098\u0099\7\23\2\2\u0099\u009a\5@!\2\u009a\u009c\3\2\2\2\u009b\u0093"+
		"\3\2\2\2\u009b\u0097\3\2\2\2\u009c\21\3\2\2\2\u009d\u009e\7+\2\2\u009e"+
		"\u009f\7\7\2\2\u009f\u00a2\5$\23\2\u00a0\u00a1\7\26\2\2\u00a1\u00a3\5"+
		"$\23\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a5\7\t\2\2\u00a5\23\3\2\2\2\u00a6\u00a7\7\17\2\2\u00a7\u00a8\5\16"+
		"\b\2\u00a8\u00a9\7\20\2\2\u00a9\u00aa\7,\2\2\u00aa\u00ab\5\6\4\2\u00ab"+
		"\u00ac\7-\2\2\u00ac\u00ad\5\6\4\2\u00ad\25\3\2\2\2\u00ae\u00af\7&\2\2"+
		"\u00af\u00b0\7\17\2\2\u00b0\u00b1\5&\24\2\u00b1\u00b2\5\20\t\2\u00b2\u00b3"+
		"\7\22\2\2\u00b3\u00b4\5@!\2\u00b4\u00b5\t\4\2\2\u00b5\u00b6\3\2\2\2\u00b6"+
		"\u00b7\7\20\2\2\u00b7\u00b9\7/\2\2\u00b8\u00ba\5\2\2\2\u00b9\u00b8\3\2"+
		"\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc\7\60\2\2\u00bc"+
		"\27\3\2\2\2\u00bd\u00be\7\'\2\2\u00be\u00bf\7\17\2\2\u00bf\u00c0\5\20"+
		"\t\2\u00c0\u00c1\7\20\2\2\u00c1\u00c3\7/\2\2\u00c2\u00c4\5\2\2\2\u00c3"+
		"\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\7\60"+
		"\2\2\u00c6\31\3\2\2\2\u00c7\u00c8\7#\2\2\u00c8\u00c9\7\17\2\2\u00c9\u00ca"+
		"\5\16\b\2\u00ca\u00cb\7\20\2\2\u00cb\u00cd\7/\2\2\u00cc\u00ce\5\2\2\2"+
		"\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d3"+
		"\7\60\2\2\u00d0\u00d2\5\34\17\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2"+
		"\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d3"+
		"\3\2\2\2\u00d6\u00d8\5\36\20\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2"+
		"\u00d8\33\3\2\2\2\u00d9\u00da\7%\2\2\u00da\u00db\7\17\2\2\u00db\u00dc"+
		"\5\16\b\2\u00dc\u00dd\7\20\2\2\u00dd\u00df\7/\2\2\u00de\u00e0\5\2\2\2"+
		"\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2"+
		"\7\60\2\2\u00e2\35\3\2\2\2\u00e3\u00e4\7$\2\2\u00e4\u00e6\7/\2\2\u00e5"+
		"\u00e7\5\2\2\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00e9\7\60\2\2\u00e9\37\3\2\2\2\u00ea\u00ed\5,\27\2\u00eb\u00ed"+
		"\5\b\5\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee"+
		"\u00ef\7\7\2\2\u00ef\u00f2\5$\23\2\u00f0\u00f1\7\26\2\2\u00f1\u00f3\5"+
		"$\23\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4"+
		"\u00f5\7\t\2\2\u00f5!\3\2\2\2\u00f6\u00f7\7.\2\2\u00f7\u00f8\5\4\3\2\u00f8"+
		"#\3\2\2\2\u00f9\u00fc\7 \2\2\u00fa\u00fc\5@!\2\u00fb\u00f9\3\2\2\2\u00fb"+
		"\u00fa\3\2\2\2\u00fc%\3\2\2\2\u00fd\u00fe\7\"\2\2\u00fe\u00ff\5@!\2\u00ff"+
		"\u0100\7\37\2\2\u0100\u0101\5\4\3\2\u0101\u0111\3\2\2\2\u0102\u010b\5"+
		"@!\2\u0103\u0104\7\7\2\2\u0104\u0107\5$\23\2\u0105\u0106\7\26\2\2\u0106"+
		"\u0108\5$\23\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u0109\3\2"+
		"\2\2\u0109\u010a\7\t\2\2\u010a\u010c\3\2\2\2\u010b\u0103\3\2\2\2\u010b"+
		"\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\7\37\2\2\u010e\u010f\5"+
		"\4\3\2\u010f\u0111\3\2\2\2\u0110\u00fd\3\2\2\2\u0110\u0102\3\2\2\2\u0111"+
		"\'\3\2\2\2\u0112\u0114\7\13\2\2\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2"+
		"\2\u0114\u0116\3\2\2\2\u0115\u0117\7 \2\2\u0116\u0115\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u0120\3\2\2\2\u011a"+
		"\u011c\7!\2\2\u011b\u011d\7 \2\2\u011c\u011b\3\2\2\2\u011d\u011e\3\2\2"+
		"\2\u011e\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011a"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121)\3\2\2\2\u0122\u0125\5(\25\2\u0123"+
		"\u0124\7\21\2\2\u0124\u0126\5(\25\2\u0125\u0123\3\2\2\2\u0125\u0126\3"+
		"\2\2\2\u0126+\3\2\2\2\u0127\u0128\5> \2\u0128\u012a\7\17\2\2\u0129\u012b"+
		"\5.\30\2\u012a\u0129\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"\u012d\7\20\2\2\u012d-\3\2\2\2\u012e\u0133\5\6\4\2\u012f\u0130\7\26\2"+
		"\2\u0130\u0132\5\6\4\2\u0131\u012f\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131"+
		"\3\2\2\2\u0133\u0134\3\2\2\2\u0134/\3\2\2\2\u0135\u0133\3\2\2\2\u0136"+
		"\u0137\7\3\2\2\u0137\u0138\5\4\3\2\u0138\61\3\2\2\2\u0139\u013e\5@!\2"+
		"\u013a\u013b\7\26\2\2\u013b\u013d\5@!\2\u013c\u013a\3\2\2\2\u013d\u0140"+
		"\3\2\2\2\u013e\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013f\63\3\2\2\2\u0140"+
		"\u013e\3\2\2\2\u0141\u0142\7\4\2\2\u0142\u0143\5> \2\u0143\u0144\7\17"+
		"\2\2\u0144\u0145\5\62\32\2\u0145\u0146\7\20\2\2\u0146\u0148\7/\2\2\u0147"+
		"\u0149\5\2\2\2\u0148\u0147\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\3\2"+
		"\2\2\u014a\u014b\7\60\2\2\u014b\65\3\2\2\2\u014c\u014e\7\13\2\2\u014d"+
		"\u014c\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\3\2\2\2\u014f\u0158\7\7"+
		"\2\2\u0150\u0155\5\6\4\2\u0151\u0152\7\26\2\2\u0152\u0154\5\6\4\2\u0153"+
		"\u0151\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2"+
		"\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0158\u0150\3\2\2\2\u0158"+
		"\u0159\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015b\7\t\2\2\u015b\67\3\2\2"+
		"\2\u015c\u015d\5:\36\2\u015d\u015e\7\22\2\2\u015e9\3\2\2\2\u015f\u0164"+
		"\5\6\4\2\u0160\u0161\7\26\2\2\u0161\u0163\5\6\4\2\u0162\u0160\3\2\2\2"+
		"\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165;\3"+
		"\2\2\2\u0166\u0164\3\2\2\2\u0167\u0169\7\13\2\2\u0168\u0167\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u0175\7\7\2\2\u016b\u016f\58"+
		"\35\2\u016c\u016e\58\35\2\u016d\u016c\3\2\2\2\u016e\u0171\3\2\2\2\u016f"+
		"\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u016f\3\2"+
		"\2\2\u0172\u0173\5:\36\2\u0173\u0176\3\2\2\2\u0174\u0176\5:\36\2\u0175"+
		"\u016b\3\2\2\2\u0175\u0174\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\7\t"+
		"\2\2\u0178=\3\2\2\2\u0179\u017d\t\5\2\2\u017a\u017c\t\6\2\2\u017b\u017a"+
		"\3\2\2\2\u017c\u017f\3\2\2\2\u017d\u017b\3\2\2\2\u017d\u017e\3\2\2\2\u017e"+
		"?\3\2\2\2\u017f\u017d\3\2\2\2\u0180\u0182\7\13\2\2\u0181\u0180\3\2\2\2"+
		"\u0181\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0187\t\5\2\2\u0184\u0186"+
		"\t\7\2\2\u0185\u0184\3\2\2\2\u0186\u0189\3\2\2\2\u0187\u0185\3\2\2\2\u0187"+
		"\u0188\3\2\2\2\u0188A\3\2\2\2\u0189\u0187\3\2\2\2-HPRcwy\u0080\u0088\u008d"+
		"\u009b\u00a2\u00b9\u00c3\u00cd\u00d3\u00d7\u00df\u00e6\u00ec\u00f2\u00fb"+
		"\u0107\u010b\u0110\u0113\u0118\u011e\u0120\u0125\u012a\u0133\u013e\u0148"+
		"\u014d\u0155\u0158\u0164\u0168\u016f\u0175\u017d\u0181\u0187";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}