// Generated from ExpressionParser/Expression.g4 by ANTLR 4.5.1

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
		INSTANCE_OF=1, SCALAR_TYPE=2, MATRIX_TYPE=3, ARRAY_TYPE=4, RETURN=5, FUNCTION=6, 
		INCREMENT=7, THROWS=8, EXCEPTION=9, DECREMENT=10, LBRACE=11, UNDERSCORE=12, 
		RBRACE=13, PLUS=14, MINUS=15, TIMES=16, DIV=17, POW=18, LPAREN=19, RPAREN=20, 
		E=21, SEMI_COLON=22, LOGICAL=23, OPERATOR=24, SYMBOL=25, COMMA=26, GT=27, 
		LT=28, AND=29, OR=30, GTE=31, LTE=32, EQ=33, NEQ=34, ASSIGN=35, DIGIT=36, 
		POINT=37, VAR=38, IF=39, IMPORT=40, ELSE=41, ELSEIF=42, FOR=43, WHILE=44, 
		LETTER=45, WS=46, MODULO=47, NEW=48, QMARK=49, COLON=50, PRI=51, NOT=52, 
		BLOCKLEFT=53, QUOTE=54, BLOCKRIGHT=55, COMMENT=56, LINE_COMMENT=57;
	public static final int
		RULE_start = 0, RULE_ex = 1, RULE_importStatement = 2, RULE_file = 3, 
		RULE_expression = 4, RULE_expr = 5, RULE_atom = 6, RULE_incDecExpression = 7, 
		RULE_instanceOfExpression = 8, RULE_controlStatement = 9, RULE_logicalOperation = 10, 
		RULE_forcedLogicalOperation = 11, RULE_newStructure = 12, RULE_ternary = 13, 
		RULE_forLoop = 14, RULE_whileLoop = 15, RULE_ifStatement = 16, RULE_elseifStatement = 17, 
		RULE_elseStatement = 18, RULE_arrayAccess = 19, RULE_print = 20, RULE_index = 21, 
		RULE_assignment = 22, RULE_number = 23, RULE_scientific = 24, RULE_func = 25, 
		RULE_funcParams = 26, RULE_returnStatement = 27, RULE_procedureParams = 28, 
		RULE_procedure = 29, RULE_array = 30, RULE_column = 31, RULE_arrayInner = 32, 
		RULE_matrix = 33, RULE_funcName = 34, RULE_variable = 35;
	public static final String[] ruleNames = {
		"start", "ex", "importStatement", "file", "expression", "expr", "atom", 
		"incDecExpression", "instanceOfExpression", "controlStatement", "logicalOperation", 
		"forcedLogicalOperation", "newStructure", "ternary", "forLoop", "whileLoop", 
		"ifStatement", "elseifStatement", "elseStatement", "arrayAccess", "print", 
		"index", "assignment", "number", "scientific", "func", "funcParams", "returnStatement", 
		"procedureParams", "procedure", "array", "column", "arrayInner", "matrix", 
		"funcName", "variable"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'instanceof'", "'Scalar'", "'Matrix'", "'Vector'", "'return'", 
		"'function'", null, "'throws'", "'exception'", null, "'['", "'_'", "']'", 
		"'+'", "'-'", "'*'", "'/'", "'^'", "'('", "')'", "'e'", "';'", null, null, 
		null, "','", "'>'", "'<'", "'&&'", "'||'", "'>='", "'<='", "'=='", "'!='", 
		"'='", null, "'.'", "'var'", "'if'", "'import'", "'else'", "'elseif'", 
		"'for'", "'while'", null, null, "'%'", "'new'", "'?'", "':'", "'print'", 
		"'!'", "'{'", "'\"'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INSTANCE_OF", "SCALAR_TYPE", "MATRIX_TYPE", "ARRAY_TYPE", "RETURN", 
		"FUNCTION", "INCREMENT", "THROWS", "EXCEPTION", "DECREMENT", "LBRACE", 
		"UNDERSCORE", "RBRACE", "PLUS", "MINUS", "TIMES", "DIV", "POW", "LPAREN", 
		"RPAREN", "E", "SEMI_COLON", "LOGICAL", "OPERATOR", "SYMBOL", "COMMA", 
		"GT", "LT", "AND", "OR", "GTE", "LTE", "EQ", "NEQ", "ASSIGN", "DIGIT", 
		"POINT", "VAR", "IF", "IMPORT", "ELSE", "ELSEIF", "FOR", "WHILE", "LETTER", 
		"WS", "MODULO", "NEW", "QMARK", "COLON", "PRI", "NOT", "BLOCKLEFT", "QUOTE", 
		"BLOCKRIGHT", "COMMENT", "LINE_COMMENT"
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
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public ExContext ex() {
			return getRuleContext(ExContext.class,0);
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
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(72);
				importStatement();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(78);
				ex();
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

	public static class ExContext extends ParserRuleContext {
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
		public ExContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterEx(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitEx(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitEx(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExContext ex() throws RecognitionException {
		ExContext _localctx = new ExContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_ex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(81);
				expression();
				}
				break;
			case 2:
				{
				setState(82);
				print();
				}
				break;
			case 3:
				{
				setState(83);
				assignment();
				}
				break;
			case 4:
				{
				setState(84);
				controlStatement();
				}
				break;
			case 5:
				{
				setState(85);
				procedure();
				}
				break;
			case 6:
				{
				setState(86);
				returnStatement();
				}
				break;
			}
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(95);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(89);
					expression();
					}
					break;
				case 2:
					{
					setState(90);
					print();
					}
					break;
				case 3:
					{
					setState(91);
					assignment();
					}
					break;
				case 4:
					{
					setState(92);
					controlStatement();
					}
					break;
				case 5:
					{
					setState(93);
					procedure();
					}
					break;
				case 6:
					{
					setState(94);
					returnStatement();
					}
					break;
				}
				}
				setState(99);
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

	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(ExpressionParser.IMPORT, 0); }
		public FileContext file() {
			return getRuleContext(FileContext.class,0);
		}
		public TerminalNode SEMI_COLON() { return getToken(ExpressionParser.SEMI_COLON, 0); }
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitImportStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitImportStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(IMPORT);
			setState(101);
			file();
			setState(102);
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

	public static class FileContext extends ParserRuleContext {
		public List<TerminalNode> LETTER() { return getTokens(ExpressionParser.LETTER); }
		public TerminalNode LETTER(int i) {
			return getToken(ExpressionParser.LETTER, i);
		}
		public List<TerminalNode> DIGIT() { return getTokens(ExpressionParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(ExpressionParser.DIGIT, i);
		}
		public List<TerminalNode> E() { return getTokens(ExpressionParser.E); }
		public TerminalNode E(int i) {
			return getToken(ExpressionParser.E, i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << MINUS) | (1L << DIV) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				{
				setState(104);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << MINUS) | (1L << DIV) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(109);
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
		enterRule(_localctx, 8, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			expr(0);
			setState(111);
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
	public static class InstanceofExprContext extends ExprContext {
		public InstanceOfExpressionContext instanceOfExpression() {
			return getRuleContext(InstanceOfExpressionContext.class,0);
		}
		public InstanceofExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterInstanceofExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitInstanceofExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitInstanceofExpr(this);
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

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(114);
				newStructure();
				}
				break;
			case 2:
				{
				_localctx = new IncDecExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(115);
				incDecExpression();
				}
				break;
			case 3:
				{
				_localctx = new ArrayAccessExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				arrayAccess();
				}
				break;
			case 4:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(LPAREN);
				setState(118);
				expr(0);
				setState(119);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new InstanceofExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				instanceOfExpression();
				}
				break;
			case 6:
				{
				_localctx = new TernaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				ternary();
				}
				break;
			case 7:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				func();
				}
				break;
			case 8:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(145);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						((BoolExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(127);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(128);
						((BoolExprContext)_localctx).op = match(LOGICAL);
						setState(129);
						((BoolExprContext)_localctx).right = expr(10);
						}
						break;
					case 2:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(131);
						((OpExprContext)_localctx).op = match(POW);
						setState(132);
						((OpExprContext)_localctx).right = expr(9);
						}
						break;
					case 3:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(133);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(134);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIV) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(135);
						((OpExprContext)_localctx).right = expr(8);
						}
						break;
					case 4:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(136);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(137);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(138);
						((OpExprContext)_localctx).right = expr(7);
						}
						break;
					case 5:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(140);
						((OpExprContext)_localctx).op = match(OPERATOR);
						setState(141);
						((OpExprContext)_localctx).right = expr(6);
						}
						break;
					case 6:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(142);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(143);
						((OpExprContext)_localctx).op = match(POINT);
						setState(144);
						((OpExprContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		enterRule(_localctx, 12, RULE_atom);
		try {
			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				scientific();
				}
				break;
			case 2:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				variable();
				}
				break;
			case 3:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				array();
				}
				break;
			case 4:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(153);
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
		enterRule(_localctx, 14, RULE_incDecExpression);
		int _la;
		try {
			setState(162);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				atom();
				setState(157);
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
				setState(159);
				func();
				setState(160);
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

	public static class InstanceOfExpressionContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(ExpressionParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(ExpressionParser.LPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode INSTANCE_OF() { return getToken(ExpressionParser.INSTANCE_OF, 0); }
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
		public TerminalNode SCALAR_TYPE() { return getToken(ExpressionParser.SCALAR_TYPE, 0); }
		public TerminalNode MATRIX_TYPE() { return getToken(ExpressionParser.MATRIX_TYPE, 0); }
		public TerminalNode ARRAY_TYPE() { return getToken(ExpressionParser.ARRAY_TYPE, 0); }
		public InstanceOfExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceOfExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterInstanceOfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitInstanceOfExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitInstanceOfExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstanceOfExpressionContext instanceOfExpression() throws RecognitionException {
		InstanceOfExpressionContext _localctx = new InstanceOfExpressionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instanceOfExpression);
		int _la;
		try {
			setState(175);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(NOT);
				setState(165);
				match(LPAREN);
				setState(166);
				variable();
				setState(167);
				match(INSTANCE_OF);
				setState(168);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCALAR_TYPE) | (1L << MATRIX_TYPE) | (1L << ARRAY_TYPE))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(169);
				match(RPAREN);
				}
				break;
			case MINUS:
			case E:
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				variable();
				setState(172);
				match(INSTANCE_OF);
				setState(173);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCALAR_TYPE) | (1L << MATRIX_TYPE) | (1L << ARRAY_TYPE))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
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
		enterRule(_localctx, 18, RULE_controlStatement);
		try {
			setState(180);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				ifStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				forLoop();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
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
		public InstanceOfExpressionContext instanceOfExpression() {
			return getRuleContext(InstanceOfExpressionContext.class,0);
		}
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
		enterRule(_localctx, 20, RULE_logicalOperation);
		try {
			setState(187);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				((LogicalOperationContext)_localctx).left = expr(0);
				setState(183);
				((LogicalOperationContext)_localctx).op = match(LOGICAL);
				setState(184);
				((LogicalOperationContext)_localctx).right = expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186);
				instanceOfExpression();
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

	public static class ForcedLogicalOperationContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode LOGICAL() { return getToken(ExpressionParser.LOGICAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InstanceOfExpressionContext instanceOfExpression() {
			return getRuleContext(InstanceOfExpressionContext.class,0);
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
		enterRule(_localctx, 22, RULE_forcedLogicalOperation);
		try {
			setState(198);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				variable();
				setState(190);
				match(LOGICAL);
				setState(191);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				expr(0);
				setState(194);
				match(LOGICAL);
				setState(195);
				variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(197);
				instanceOfExpression();
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
		enterRule(_localctx, 24, RULE_newStructure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(NEW);
			setState(201);
			match(LBRACE);
			setState(202);
			index();
			setState(205);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(203);
				match(COMMA);
				setState(204);
				index();
				}
			}

			setState(207);
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
		enterRule(_localctx, 26, RULE_ternary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(LPAREN);
			setState(210);
			logicalOperation();
			setState(211);
			match(RPAREN);
			setState(212);
			match(QMARK);
			setState(213);
			expr(0);
			setState(214);
			match(COLON);
			setState(215);
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
		public ExContext ex() {
			return getRuleContext(ExContext.class,0);
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
		enterRule(_localctx, 28, RULE_forLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(FOR);
			setState(218);
			match(LPAREN);
			setState(219);
			assignment();
			setState(220);
			forcedLogicalOperation();
			setState(221);
			match(SEMI_COLON);
			{
			setState(222);
			variable();
			setState(223);
			_la = _input.LA(1);
			if ( !(_la==INCREMENT || _la==DECREMENT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
			setState(225);
			match(RPAREN);
			setState(226);
			match(BLOCKLEFT);
			setState(228);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(227);
				ex();
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

	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(ExpressionParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(ExpressionParser.LPAREN, 0); }
		public ForcedLogicalOperationContext forcedLogicalOperation() {
			return getRuleContext(ForcedLogicalOperationContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
		public TerminalNode BLOCKLEFT() { return getToken(ExpressionParser.BLOCKLEFT, 0); }
		public TerminalNode BLOCKRIGHT() { return getToken(ExpressionParser.BLOCKRIGHT, 0); }
		public ExContext ex() {
			return getRuleContext(ExContext.class,0);
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
		enterRule(_localctx, 30, RULE_whileLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(WHILE);
			setState(233);
			match(LPAREN);
			setState(234);
			forcedLogicalOperation();
			setState(235);
			match(RPAREN);
			setState(236);
			match(BLOCKLEFT);
			setState(238);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(237);
				ex();
				}
			}

			setState(240);
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
		public ExContext ex() {
			return getRuleContext(ExContext.class,0);
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
		enterRule(_localctx, 32, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(IF);
			setState(243);
			match(LPAREN);
			setState(244);
			logicalOperation();
			setState(245);
			match(RPAREN);
			setState(246);
			match(BLOCKLEFT);
			setState(248);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(247);
				ex();
				}
			}

			setState(250);
			match(BLOCKRIGHT);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(251);
				elseifStatement();
				}
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(258);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(257);
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
		public ExContext ex() {
			return getRuleContext(ExContext.class,0);
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
		enterRule(_localctx, 34, RULE_elseifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(ELSEIF);
			setState(261);
			match(LPAREN);
			setState(262);
			logicalOperation();
			setState(263);
			match(RPAREN);
			setState(264);
			match(BLOCKLEFT);
			setState(266);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(265);
				ex();
				}
			}

			setState(268);
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
		public ExContext ex() {
			return getRuleContext(ExContext.class,0);
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
		enterRule(_localctx, 36, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(ELSE);
			setState(271);
			match(BLOCKLEFT);
			setState(273);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(272);
				ex();
				}
			}

			setState(275);
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
		enterRule(_localctx, 38, RULE_arrayAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(277);
				func();
				}
				break;
			case 2:
				{
				setState(278);
				atom();
				}
				break;
			}
			setState(281);
			match(LBRACE);
			{
			setState(282);
			index();
			setState(285);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(283);
				match(COMMA);
				setState(284);
				index();
				}
			}

			}
			setState(287);
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
		enterRule(_localctx, 40, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(PRI);
			setState(290);
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
		enterRule(_localctx, 42, RULE_index);
		try {
			setState(294);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(292);
				match(DIGIT);
				}
				break;
			case MINUS:
			case E:
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
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
		enterRule(_localctx, 44, RULE_assignment);
		int _la;
		try {
			setState(315);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(VAR);
				setState(297);
				variable();
				setState(298);
				match(ASSIGN);
				setState(299);
				expression();
				}
				break;
			case MINUS:
			case E:
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				((AssignmentContext)_localctx).varName = variable();
				setState(310);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(302);
					match(LBRACE);
					{
					{
					setState(303);
					index();
					}
					setState(306);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(304);
						match(COMMA);
						setState(305);
						index();
						}
					}

					}
					setState(308);
					match(RBRACE);
					}
				}

				setState(312);
				match(ASSIGN);
				setState(313);
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
		enterRule(_localctx, 46, RULE_number);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(317);
				match(MINUS);
				}
			}

			setState(321); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(320);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(323); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(331);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(325);
				match(POINT);
				setState(327); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(326);
						match(DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(329); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		enterRule(_localctx, 48, RULE_scientific);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			number();
			setState(336);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(334);
				match(E);
				setState(335);
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
		enterRule(_localctx, 50, RULE_func);
		int _la;
		try {
			_localctx = new FuncDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			funcName();
			setState(339);
			match(LPAREN);
			setState(341);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << LETTER) | (1L << NEW) | (1L << NOT))) != 0)) {
				{
				setState(340);
				funcParams();
				}
			}

			setState(343);
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
		enterRule(_localctx, 52, RULE_funcParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(345);
			expr(0);
			}
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(346);
				match(COMMA);
				{
				setState(347);
				expr(0);
				}
				}
				}
				setState(352);
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
		enterRule(_localctx, 54, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(RETURN);
			setState(354);
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
		enterRule(_localctx, 56, RULE_procedureParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(356);
			variable();
			}
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(357);
				match(COMMA);
				{
				setState(358);
				variable();
				}
				}
				}
				setState(363);
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
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
		public TerminalNode BLOCKLEFT() { return getToken(ExpressionParser.BLOCKLEFT, 0); }
		public TerminalNode BLOCKRIGHT() { return getToken(ExpressionParser.BLOCKRIGHT, 0); }
		public ProcedureParamsContext procedureParams() {
			return getRuleContext(ProcedureParamsContext.class,0);
		}
		public ExContext ex() {
			return getRuleContext(ExContext.class,0);
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
		enterRule(_localctx, 58, RULE_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(FUNCTION);
			setState(365);
			funcName();
			setState(366);
			match(LPAREN);
			setState(368);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << E) | (1L << LETTER))) != 0)) {
				{
				setState(367);
				procedureParams();
				}
			}

			setState(370);
			match(RPAREN);
			setState(371);
			match(BLOCKLEFT);
			setState(373);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(372);
				ex();
				}
			}

			setState(375);
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
		enterRule(_localctx, 60, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(377);
				match(MINUS);
				}
			}

			setState(380);
			match(LBRACE);
			setState(389);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << LETTER) | (1L << NEW) | (1L << NOT))) != 0)) {
				{
				{
				setState(381);
				expr(0);
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(382);
					match(COMMA);
					{
					setState(383);
					expr(0);
					}
					}
					}
					setState(388);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(391);
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
		enterRule(_localctx, 62, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			arrayInner();
			setState(394);
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
		enterRule(_localctx, 64, RULE_arrayInner);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(396);
			expr(0);
			}
			setState(401);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(397);
				match(COMMA);
				{
				setState(398);
				expr(0);
				}
				}
				}
				setState(403);
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
		enterRule(_localctx, 66, RULE_matrix);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(404);
				match(MINUS);
				}
			}

			setState(407);
			match(LBRACE);
			setState(418);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				{
				{
				setState(408);
				column();
				setState(412);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(409);
						column();
						}
						} 
					}
					setState(414);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
				}
				setState(415);
				arrayInner();
				}
				}
				break;
			case 2:
				{
				setState(417);
				arrayInner();
				}
				break;
			}
			setState(420);
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
		enterRule(_localctx, 68, RULE_funcName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			_la = _input.LA(1);
			if ( !(_la==E || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				{
				setState(423);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(428);
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
		enterRule(_localctx, 70, RULE_variable);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(429);
				match(MINUS);
				}
			}

			setState(432);
			_la = _input.LA(1);
			if ( !(_la==E || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(436);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(433);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(438);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
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
		case 5:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3;\u01ba\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\7\2L\n\2\f\2\16\2O\13\2\3\2\5\2R\n\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\5\3Z\n\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3b\n\3\f\3"+
		"\16\3e\13\3\3\4\3\4\3\4\3\4\3\5\7\5l\n\5\f\5\16\5o\13\5\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0080\n\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u0094"+
		"\n\7\f\7\16\7\u0097\13\7\3\b\3\b\3\b\3\b\5\b\u009d\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\t\u00a5\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n"+
		"\u00b2\n\n\3\13\3\13\3\13\5\13\u00b7\n\13\3\f\3\f\3\f\3\f\3\f\5\f\u00be"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c9\n\r\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00d0\n\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00e7"+
		"\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00f1\n\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00fb\n\22\3\22\3\22\7\22\u00ff\n"+
		"\22\f\22\16\22\u0102\13\22\3\22\5\22\u0105\n\22\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\5\23\u010d\n\23\3\23\3\23\3\24\3\24\3\24\5\24\u0114\n\24\3\24"+
		"\3\24\3\25\3\25\5\25\u011a\n\25\3\25\3\25\3\25\3\25\5\25\u0120\n\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\27\3\27\5\27\u0129\n\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0135\n\30\3\30\3\30\5\30\u0139\n"+
		"\30\3\30\3\30\3\30\5\30\u013e\n\30\3\31\5\31\u0141\n\31\3\31\6\31\u0144"+
		"\n\31\r\31\16\31\u0145\3\31\3\31\6\31\u014a\n\31\r\31\16\31\u014b\5\31"+
		"\u014e\n\31\3\32\3\32\3\32\5\32\u0153\n\32\3\33\3\33\3\33\5\33\u0158\n"+
		"\33\3\33\3\33\3\34\3\34\3\34\7\34\u015f\n\34\f\34\16\34\u0162\13\34\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\7\36\u016a\n\36\f\36\16\36\u016d\13\36\3"+
		"\37\3\37\3\37\3\37\5\37\u0173\n\37\3\37\3\37\3\37\5\37\u0178\n\37\3\37"+
		"\3\37\3 \5 \u017d\n \3 \3 \3 \3 \7 \u0183\n \f \16 \u0186\13 \5 \u0188"+
		"\n \3 \3 \3!\3!\3!\3\"\3\"\3\"\7\"\u0192\n\"\f\"\16\"\u0195\13\"\3#\5"+
		"#\u0198\n#\3#\3#\3#\7#\u019d\n#\f#\16#\u01a0\13#\3#\3#\3#\5#\u01a5\n#"+
		"\3#\3#\3$\3$\7$\u01ab\n$\f$\16$\u01ae\13$\3%\5%\u01b1\n%\3%\3%\7%\u01b5"+
		"\n%\f%\16%\u01b8\13%\3%\2\3\f&\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<>@BDFH\2\n\b\2\16\16\21\21\23\23\27\27&&//\3\2"+
		"\22\23\3\2\20\21\4\2\t\t\f\f\3\2\4\6\4\2\27\27//\6\2\16\16\27\27&&//\5"+
		"\2\27\27&&//\u01dc\2M\3\2\2\2\4Y\3\2\2\2\6f\3\2\2\2\bm\3\2\2\2\np\3\2"+
		"\2\2\f\177\3\2\2\2\16\u009c\3\2\2\2\20\u00a4\3\2\2\2\22\u00b1\3\2\2\2"+
		"\24\u00b6\3\2\2\2\26\u00bd\3\2\2\2\30\u00c8\3\2\2\2\32\u00ca\3\2\2\2\34"+
		"\u00d3\3\2\2\2\36\u00db\3\2\2\2 \u00ea\3\2\2\2\"\u00f4\3\2\2\2$\u0106"+
		"\3\2\2\2&\u0110\3\2\2\2(\u0119\3\2\2\2*\u0123\3\2\2\2,\u0128\3\2\2\2."+
		"\u013d\3\2\2\2\60\u0140\3\2\2\2\62\u014f\3\2\2\2\64\u0154\3\2\2\2\66\u015b"+
		"\3\2\2\28\u0163\3\2\2\2:\u0166\3\2\2\2<\u016e\3\2\2\2>\u017c\3\2\2\2@"+
		"\u018b\3\2\2\2B\u018e\3\2\2\2D\u0197\3\2\2\2F\u01a8\3\2\2\2H\u01b0\3\2"+
		"\2\2JL\5\6\4\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NQ\3\2\2\2OM\3\2"+
		"\2\2PR\5\4\3\2QP\3\2\2\2QR\3\2\2\2R\3\3\2\2\2SZ\5\n\6\2TZ\5*\26\2UZ\5"+
		".\30\2VZ\5\24\13\2WZ\5<\37\2XZ\58\35\2YS\3\2\2\2YT\3\2\2\2YU\3\2\2\2Y"+
		"V\3\2\2\2YW\3\2\2\2YX\3\2\2\2Zc\3\2\2\2[b\5\n\6\2\\b\5*\26\2]b\5.\30\2"+
		"^b\5\24\13\2_b\5<\37\2`b\58\35\2a[\3\2\2\2a\\\3\2\2\2a]\3\2\2\2a^\3\2"+
		"\2\2a_\3\2\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\5\3\2\2\2ec\3"+
		"\2\2\2fg\7*\2\2gh\5\b\5\2hi\7\30\2\2i\7\3\2\2\2jl\t\2\2\2kj\3\2\2\2lo"+
		"\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\t\3\2\2\2om\3\2\2\2pq\5\f\7\2qr\7\30\2\2"+
		"r\13\3\2\2\2st\b\7\1\2t\u0080\5\32\16\2u\u0080\5\20\t\2v\u0080\5(\25\2"+
		"wx\7\25\2\2xy\5\f\7\2yz\7\26\2\2z\u0080\3\2\2\2{\u0080\5\22\n\2|\u0080"+
		"\5\34\17\2}\u0080\5\64\33\2~\u0080\5\16\b\2\177s\3\2\2\2\177u\3\2\2\2"+
		"\177v\3\2\2\2\177w\3\2\2\2\177{\3\2\2\2\177|\3\2\2\2\177}\3\2\2\2\177"+
		"~\3\2\2\2\u0080\u0095\3\2\2\2\u0081\u0082\f\13\2\2\u0082\u0083\7\31\2"+
		"\2\u0083\u0094\5\f\7\f\u0084\u0085\f\n\2\2\u0085\u0086\7\24\2\2\u0086"+
		"\u0094\5\f\7\13\u0087\u0088\f\t\2\2\u0088\u0089\t\3\2\2\u0089\u0094\5"+
		"\f\7\n\u008a\u008b\f\b\2\2\u008b\u008c\t\4\2\2\u008c\u0094\5\f\7\t\u008d"+
		"\u008e\f\7\2\2\u008e\u008f\7\32\2\2\u008f\u0094\5\f\7\b\u0090\u0091\f"+
		"\3\2\2\u0091\u0092\7\'\2\2\u0092\u0094\5\f\7\4\u0093\u0081\3\2\2\2\u0093"+
		"\u0084\3\2\2\2\u0093\u0087\3\2\2\2\u0093\u008a\3\2\2\2\u0093\u008d\3\2"+
		"\2\2\u0093\u0090\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\r\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009d\5\62\32"+
		"\2\u0099\u009d\5H%\2\u009a\u009d\5> \2\u009b\u009d\5D#\2\u009c\u0098\3"+
		"\2\2\2\u009c\u0099\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009d"+
		"\17\3\2\2\2\u009e\u009f\5\16\b\2\u009f\u00a0\t\5\2\2\u00a0\u00a5\3\2\2"+
		"\2\u00a1\u00a2\5\64\33\2\u00a2\u00a3\t\5\2\2\u00a3\u00a5\3\2\2\2\u00a4"+
		"\u009e\3\2\2\2\u00a4\u00a1\3\2\2\2\u00a5\21\3\2\2\2\u00a6\u00a7\7\66\2"+
		"\2\u00a7\u00a8\7\25\2\2\u00a8\u00a9\5H%\2\u00a9\u00aa\7\3\2\2\u00aa\u00ab"+
		"\t\6\2\2\u00ab\u00ac\7\26\2\2\u00ac\u00b2\3\2\2\2\u00ad\u00ae\5H%\2\u00ae"+
		"\u00af\7\3\2\2\u00af\u00b0\t\6\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00a6\3\2"+
		"\2\2\u00b1\u00ad\3\2\2\2\u00b2\23\3\2\2\2\u00b3\u00b7\5\"\22\2\u00b4\u00b7"+
		"\5\36\20\2\u00b5\u00b7\5 \21\2\u00b6\u00b3\3\2\2\2\u00b6\u00b4\3\2\2\2"+
		"\u00b6\u00b5\3\2\2\2\u00b7\25\3\2\2\2\u00b8\u00b9\5\f\7\2\u00b9\u00ba"+
		"\7\31\2\2\u00ba\u00bb\5\f\7\2\u00bb\u00be\3\2\2\2\u00bc\u00be\5\22\n\2"+
		"\u00bd\u00b8\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\27\3\2\2\2\u00bf\u00c0"+
		"\5H%\2\u00c0\u00c1\7\31\2\2\u00c1\u00c2\5\f\7\2\u00c2\u00c9\3\2\2\2\u00c3"+
		"\u00c4\5\f\7\2\u00c4\u00c5\7\31\2\2\u00c5\u00c6\5H%\2\u00c6\u00c9\3\2"+
		"\2\2\u00c7\u00c9\5\22\n\2\u00c8\u00bf\3\2\2\2\u00c8\u00c3\3\2\2\2\u00c8"+
		"\u00c7\3\2\2\2\u00c9\31\3\2\2\2\u00ca\u00cb\7\62\2\2\u00cb\u00cc\7\r\2"+
		"\2\u00cc\u00cf\5,\27\2\u00cd\u00ce\7\34\2\2\u00ce\u00d0\5,\27\2\u00cf"+
		"\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\7\17"+
		"\2\2\u00d2\33\3\2\2\2\u00d3\u00d4\7\25\2\2\u00d4\u00d5\5\26\f\2\u00d5"+
		"\u00d6\7\26\2\2\u00d6\u00d7\7\63\2\2\u00d7\u00d8\5\f\7\2\u00d8\u00d9\7"+
		"\64\2\2\u00d9\u00da\5\f\7\2\u00da\35\3\2\2\2\u00db\u00dc\7-\2\2\u00dc"+
		"\u00dd\7\25\2\2\u00dd\u00de\5.\30\2\u00de\u00df\5\30\r\2\u00df\u00e0\7"+
		"\30\2\2\u00e0\u00e1\5H%\2\u00e1\u00e2\t\5\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"\u00e4\7\26\2\2\u00e4\u00e6\7\67\2\2\u00e5\u00e7\5\4\3\2\u00e6\u00e5\3"+
		"\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\79\2\2\u00e9"+
		"\37\3\2\2\2\u00ea\u00eb\7.\2\2\u00eb\u00ec\7\25\2\2\u00ec\u00ed\5\30\r"+
		"\2\u00ed\u00ee\7\26\2\2\u00ee\u00f0\7\67\2\2\u00ef\u00f1\5\4\3\2\u00f0"+
		"\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\79"+
		"\2\2\u00f3!\3\2\2\2\u00f4\u00f5\7)\2\2\u00f5\u00f6\7\25\2\2\u00f6\u00f7"+
		"\5\26\f\2\u00f7\u00f8\7\26\2\2\u00f8\u00fa\7\67\2\2\u00f9\u00fb\5\4\3"+
		"\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u0100"+
		"\79\2\2\u00fd\u00ff\5$\23\2\u00fe\u00fd\3\2\2\2\u00ff\u0102\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2"+
		"\2\2\u0103\u0105\5&\24\2\u0104\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105"+
		"#\3\2\2\2\u0106\u0107\7,\2\2\u0107\u0108\7\25\2\2\u0108\u0109\5\26\f\2"+
		"\u0109\u010a\7\26\2\2\u010a\u010c\7\67\2\2\u010b\u010d\5\4\3\2\u010c\u010b"+
		"\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\79\2\2\u010f"+
		"%\3\2\2\2\u0110\u0111\7+\2\2\u0111\u0113\7\67\2\2\u0112\u0114\5\4\3\2"+
		"\u0113\u0112\3\2\2\2\u0113\u0114\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0116"+
		"\79\2\2\u0116\'\3\2\2\2\u0117\u011a\5\64\33\2\u0118\u011a\5\16\b\2\u0119"+
		"\u0117\3\2\2\2\u0119\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011c\7\r"+
		"\2\2\u011c\u011f\5,\27\2\u011d\u011e\7\34\2\2\u011e\u0120\5,\27\2\u011f"+
		"\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\7\17"+
		"\2\2\u0122)\3\2\2\2\u0123\u0124\7\65\2\2\u0124\u0125\5\n\6\2\u0125+\3"+
		"\2\2\2\u0126\u0129\7&\2\2\u0127\u0129\5H%\2\u0128\u0126\3\2\2\2\u0128"+
		"\u0127\3\2\2\2\u0129-\3\2\2\2\u012a\u012b\7(\2\2\u012b\u012c\5H%\2\u012c"+
		"\u012d\7%\2\2\u012d\u012e\5\n\6\2\u012e\u013e\3\2\2\2\u012f\u0138\5H%"+
		"\2\u0130\u0131\7\r\2\2\u0131\u0134\5,\27\2\u0132\u0133\7\34\2\2\u0133"+
		"\u0135\5,\27\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0136\3\2"+
		"\2\2\u0136\u0137\7\17\2\2\u0137\u0139\3\2\2\2\u0138\u0130\3\2\2\2\u0138"+
		"\u0139\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\7%\2\2\u013b\u013c\5\n"+
		"\6\2\u013c\u013e\3\2\2\2\u013d\u012a\3\2\2\2\u013d\u012f\3\2\2\2\u013e"+
		"/\3\2\2\2\u013f\u0141\7\21\2\2\u0140\u013f\3\2\2\2\u0140\u0141\3\2\2\2"+
		"\u0141\u0143\3\2\2\2\u0142\u0144\7&\2\2\u0143\u0142\3\2\2\2\u0144\u0145"+
		"\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u014d\3\2\2\2\u0147"+
		"\u0149\7\'\2\2\u0148\u014a\7&\2\2\u0149\u0148\3\2\2\2\u014a\u014b\3\2"+
		"\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014e\3\2\2\2\u014d"+
		"\u0147\3\2\2\2\u014d\u014e\3\2\2\2\u014e\61\3\2\2\2\u014f\u0152\5\60\31"+
		"\2\u0150\u0151\7\27\2\2\u0151\u0153\5\60\31\2\u0152\u0150\3\2\2\2\u0152"+
		"\u0153\3\2\2\2\u0153\63\3\2\2\2\u0154\u0155\5F$\2\u0155\u0157\7\25\2\2"+
		"\u0156\u0158\5\66\34\2\u0157\u0156\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u0159"+
		"\3\2\2\2\u0159\u015a\7\26\2\2\u015a\65\3\2\2\2\u015b\u0160\5\f\7\2\u015c"+
		"\u015d\7\34\2\2\u015d\u015f\5\f\7\2\u015e\u015c\3\2\2\2\u015f\u0162\3"+
		"\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161\67\3\2\2\2\u0162"+
		"\u0160\3\2\2\2\u0163\u0164\7\7\2\2\u0164\u0165\5\n\6\2\u01659\3\2\2\2"+
		"\u0166\u016b\5H%\2\u0167\u0168\7\34\2\2\u0168\u016a\5H%\2\u0169\u0167"+
		"\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		";\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u016f\7\b\2\2\u016f\u0170\5F$\2\u0170"+
		"\u0172\7\25\2\2\u0171\u0173\5:\36\2\u0172\u0171\3\2\2\2\u0172\u0173\3"+
		"\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\7\26\2\2\u0175\u0177\7\67\2\2\u0176"+
		"\u0178\5\4\3\2\u0177\u0176\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\3\2"+
		"\2\2\u0179\u017a\79\2\2\u017a=\3\2\2\2\u017b\u017d\7\21\2\2\u017c\u017b"+
		"\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u0187\7\r\2\2\u017f"+
		"\u0184\5\f\7\2\u0180\u0181\7\34\2\2\u0181\u0183\5\f\7\2\u0182\u0180\3"+
		"\2\2\2\u0183\u0186\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185"+
		"\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0187\u017f\3\2\2\2\u0187\u0188\3\2"+
		"\2\2\u0188\u0189\3\2\2\2\u0189\u018a\7\17\2\2\u018a?\3\2\2\2\u018b\u018c"+
		"\5B\"\2\u018c\u018d\7\30\2\2\u018dA\3\2\2\2\u018e\u0193\5\f\7\2\u018f"+
		"\u0190\7\34\2\2\u0190\u0192\5\f\7\2\u0191\u018f\3\2\2\2\u0192\u0195\3"+
		"\2\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194C\3\2\2\2\u0195\u0193"+
		"\3\2\2\2\u0196\u0198\7\21\2\2\u0197\u0196\3\2\2\2\u0197\u0198\3\2\2\2"+
		"\u0198\u0199\3\2\2\2\u0199\u01a4\7\r\2\2\u019a\u019e\5@!\2\u019b\u019d"+
		"\5@!\2\u019c\u019b\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c\3\2\2\2\u019e"+
		"\u019f\3\2\2\2\u019f\u01a1\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a2\5B"+
		"\"\2\u01a2\u01a5\3\2\2\2\u01a3\u01a5\5B\"\2\u01a4\u019a\3\2\2\2\u01a4"+
		"\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7\7\17\2\2\u01a7E\3\2\2\2"+
		"\u01a8\u01ac\t\7\2\2\u01a9\u01ab\t\b\2\2\u01aa\u01a9\3\2\2\2\u01ab\u01ae"+
		"\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01adG\3\2\2\2\u01ae"+
		"\u01ac\3\2\2\2\u01af\u01b1\7\21\2\2\u01b0\u01af\3\2\2\2\u01b0\u01b1\3"+
		"\2\2\2\u01b1\u01b2\3\2\2\2\u01b2\u01b6\t\7\2\2\u01b3\u01b5\t\t\2\2\u01b4"+
		"\u01b3\3\2\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b6\u01b7\3\2"+
		"\2\2\u01b7I\3\2\2\2\u01b8\u01b6\3\2\2\2\63MQYacm\177\u0093\u0095\u009c"+
		"\u00a4\u00b1\u00b6\u00bd\u00c8\u00cf\u00e6\u00f0\u00fa\u0100\u0104\u010c"+
		"\u0113\u0119\u011f\u0128\u0134\u0138\u013d\u0140\u0145\u014b\u014d\u0152"+
		"\u0157\u0160\u016b\u0172\u0177\u017c\u0184\u0187\u0193\u0197\u019e\u01a4"+
		"\u01ac\u01b0\u01b6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}