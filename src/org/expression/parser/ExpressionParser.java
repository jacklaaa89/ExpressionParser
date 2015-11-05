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
		RBRACE=13, RIGHT_ARROW=14, PLUS=15, MINUS=16, TIMES=17, DIV=18, POW=19, 
		LPAREN=20, RPAREN=21, E=22, SEMI_COLON=23, LOGICAL=24, OPERATOR=25, SYMBOL=26, 
		COMMA=27, GT=28, LT=29, AND=30, OR=31, GTE=32, LTE=33, EQ=34, NEQ=35, 
		ASSIGN=36, DIGIT=37, POINT=38, VAR=39, IF=40, IMPORT=41, ELSE=42, ELSEIF=43, 
		FOR=44, WHILE=45, LETTER=46, WS=47, MODULO=48, NEW=49, QMARK=50, COLON=51, 
		PRI=52, NOT=53, BLOCKLEFT=54, QUOTE=55, BLOCKRIGHT=56, COMMENT=57, LINE_COMMENT=58;
	public static final int
		RULE_start = 0, RULE_ex = 1, RULE_importStatement = 2, RULE_file = 3, 
		RULE_expression = 4, RULE_expr = 5, RULE_atom = 6, RULE_incDecExpression = 7, 
		RULE_instanceOfExpression = 8, RULE_controlStatement = 9, RULE_logicalOperation = 10, 
		RULE_forcedLogicalOperation = 11, RULE_newStructure = 12, RULE_ternary = 13, 
		RULE_forLoop = 14, RULE_whileLoop = 15, RULE_ifStatement = 16, RULE_elseifStatement = 17, 
		RULE_elseStatement = 18, RULE_arrayAccess = 19, RULE_type = 20, RULE_print = 21, 
		RULE_index = 22, RULE_assignment = 23, RULE_number = 24, RULE_scientific = 25, 
		RULE_func = 26, RULE_funcParams = 27, RULE_returnStatement = 28, RULE_procedureParams = 29, 
		RULE_procedure = 30, RULE_procedureReturnType = 31, RULE_array = 32, RULE_column = 33, 
		RULE_arrayInner = 34, RULE_matrix = 35, RULE_funcName = 36, RULE_variable = 37;
	public static final String[] ruleNames = {
		"start", "ex", "importStatement", "file", "expression", "expr", "atom", 
		"incDecExpression", "instanceOfExpression", "controlStatement", "logicalOperation", 
		"forcedLogicalOperation", "newStructure", "ternary", "forLoop", "whileLoop", 
		"ifStatement", "elseifStatement", "elseStatement", "arrayAccess", "type", 
		"print", "index", "assignment", "number", "scientific", "func", "funcParams", 
		"returnStatement", "procedureParams", "procedure", "procedureReturnType", 
		"array", "column", "arrayInner", "matrix", "funcName", "variable"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'instanceof'", "'Scalar'", "'Matrix'", "'Vector'", "'return'", 
		"'function'", null, "'throws'", "'exception'", null, "'['", "'_'", "']'", 
		"'->'", "'+'", "'-'", "'*'", "'/'", "'^'", "'('", "')'", "'e'", "';'", 
		null, null, null, "','", "'>'", "'<'", "'&&'", "'||'", "'>='", "'<='", 
		"'=='", "'!='", "'='", null, "'.'", "'var'", "'if'", "'import'", "'else'", 
		"'elseif'", "'for'", "'while'", null, null, "'%'", "'new'", "'?'", "':'", 
		"'print'", "'!'", "'{'", "'\"'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INSTANCE_OF", "SCALAR_TYPE", "MATRIX_TYPE", "ARRAY_TYPE", "RETURN", 
		"FUNCTION", "INCREMENT", "THROWS", "EXCEPTION", "DECREMENT", "LBRACE", 
		"UNDERSCORE", "RBRACE", "RIGHT_ARROW", "PLUS", "MINUS", "TIMES", "DIV", 
		"POW", "LPAREN", "RPAREN", "E", "SEMI_COLON", "LOGICAL", "OPERATOR", "SYMBOL", 
		"COMMA", "GT", "LT", "AND", "OR", "GTE", "LTE", "EQ", "NEQ", "ASSIGN", 
		"DIGIT", "POINT", "VAR", "IF", "IMPORT", "ELSE", "ELSEIF", "FOR", "WHILE", 
		"LETTER", "WS", "MODULO", "NEW", "QMARK", "COLON", "PRI", "NOT", "BLOCKLEFT", 
		"QUOTE", "BLOCKRIGHT", "COMMENT", "LINE_COMMENT"
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
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(76);
				importStatement();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(83);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(82);
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
			setState(91);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(85);
				expression();
				}
				break;
			case 2:
				{
				setState(86);
				print();
				}
				break;
			case 3:
				{
				setState(87);
				assignment();
				}
				break;
			case 4:
				{
				setState(88);
				controlStatement();
				}
				break;
			case 5:
				{
				setState(89);
				procedure();
				}
				break;
			case 6:
				{
				setState(90);
				returnStatement();
				}
				break;
			}
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(99);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(93);
					expression();
					}
					break;
				case 2:
					{
					setState(94);
					print();
					}
					break;
				case 3:
					{
					setState(95);
					assignment();
					}
					break;
				case 4:
					{
					setState(96);
					controlStatement();
					}
					break;
				case 5:
					{
					setState(97);
					procedure();
					}
					break;
				case 6:
					{
					setState(98);
					returnStatement();
					}
					break;
				}
				}
				setState(103);
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
			setState(104);
			match(IMPORT);
			setState(105);
			file();
			setState(106);
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
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << MINUS) | (1L << DIV) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				{
				setState(108);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << MINUS) | (1L << DIV) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(113);
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
			setState(114);
			expr(0);
			setState(115);
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
			setState(129);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(118);
				newStructure();
				}
				break;
			case 2:
				{
				_localctx = new IncDecExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(119);
				incDecExpression();
				}
				break;
			case 3:
				{
				_localctx = new ArrayAccessExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120);
				arrayAccess();
				}
				break;
			case 4:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(LPAREN);
				setState(122);
				expr(0);
				setState(123);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new InstanceofExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				instanceOfExpression();
				}
				break;
			case 6:
				{
				_localctx = new TernaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				ternary();
				}
				break;
			case 7:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				func();
				}
				break;
			case 8:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(149);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						((BoolExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(131);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(132);
						((BoolExprContext)_localctx).op = match(LOGICAL);
						setState(133);
						((BoolExprContext)_localctx).right = expr(10);
						}
						break;
					case 2:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(135);
						((OpExprContext)_localctx).op = match(POW);
						setState(136);
						((OpExprContext)_localctx).right = expr(9);
						}
						break;
					case 3:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(138);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIV) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(139);
						((OpExprContext)_localctx).right = expr(8);
						}
						break;
					case 4:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(141);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(142);
						((OpExprContext)_localctx).right = expr(7);
						}
						break;
					case 5:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(144);
						((OpExprContext)_localctx).op = match(OPERATOR);
						setState(145);
						((OpExprContext)_localctx).right = expr(6);
						}
						break;
					case 6:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(147);
						((OpExprContext)_localctx).op = match(POINT);
						setState(148);
						((OpExprContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(153);
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
			setState(158);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				scientific();
				}
				break;
			case 2:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				variable();
				}
				break;
			case 3:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(156);
				array();
				}
				break;
			case 4:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(157);
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
			setState(166);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				atom();
				setState(161);
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
				setState(163);
				func();
				setState(164);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
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
		try {
			setState(179);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				match(NOT);
				setState(169);
				match(LPAREN);
				setState(170);
				variable();
				setState(171);
				match(INSTANCE_OF);
				setState(172);
				type();
				setState(173);
				match(RPAREN);
				}
				break;
			case MINUS:
			case E:
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				variable();
				setState(176);
				match(INSTANCE_OF);
				setState(177);
				type();
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
			setState(184);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				ifStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(182);
				forLoop();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
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
			setState(191);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				((LogicalOperationContext)_localctx).left = expr(0);
				setState(187);
				((LogicalOperationContext)_localctx).op = match(LOGICAL);
				setState(188);
				((LogicalOperationContext)_localctx).right = expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
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
			setState(202);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				variable();
				setState(194);
				match(LOGICAL);
				setState(195);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				expr(0);
				setState(198);
				match(LOGICAL);
				setState(199);
				variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(201);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(ExpressionParser.LPAREN, 0); }
		public List<IndexContext> index() {
			return getRuleContexts(IndexContext.class);
		}
		public IndexContext index(int i) {
			return getRuleContext(IndexContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(ExpressionParser.RPAREN, 0); }
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
			setState(204);
			match(NEW);
			setState(205);
			type();
			setState(206);
			match(LPAREN);
			setState(207);
			index();
			setState(210);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(208);
				match(COMMA);
				setState(209);
				index();
				}
			}

			setState(212);
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
			setState(214);
			match(LPAREN);
			setState(215);
			logicalOperation();
			setState(216);
			match(RPAREN);
			setState(217);
			match(QMARK);
			setState(218);
			expr(0);
			setState(219);
			match(COLON);
			setState(220);
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
			setState(222);
			match(FOR);
			setState(223);
			match(LPAREN);
			setState(224);
			assignment();
			setState(225);
			forcedLogicalOperation();
			setState(226);
			match(SEMI_COLON);
			{
			setState(227);
			variable();
			setState(228);
			_la = _input.LA(1);
			if ( !(_la==INCREMENT || _la==DECREMENT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
			setState(230);
			match(RPAREN);
			setState(231);
			match(BLOCKLEFT);
			setState(233);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(232);
				ex();
				}
			}

			setState(235);
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
			setState(237);
			match(WHILE);
			setState(238);
			match(LPAREN);
			setState(239);
			forcedLogicalOperation();
			setState(240);
			match(RPAREN);
			setState(241);
			match(BLOCKLEFT);
			setState(243);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(242);
				ex();
				}
			}

			setState(245);
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
			setState(247);
			match(IF);
			setState(248);
			match(LPAREN);
			setState(249);
			logicalOperation();
			setState(250);
			match(RPAREN);
			setState(251);
			match(BLOCKLEFT);
			setState(253);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(252);
				ex();
				}
			}

			setState(255);
			match(BLOCKRIGHT);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(256);
				elseifStatement();
				}
				}
				setState(261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(263);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(262);
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
			setState(265);
			match(ELSEIF);
			setState(266);
			match(LPAREN);
			setState(267);
			logicalOperation();
			setState(268);
			match(RPAREN);
			setState(269);
			match(BLOCKLEFT);
			setState(271);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(270);
				ex();
				}
			}

			setState(273);
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
			setState(275);
			match(ELSE);
			setState(276);
			match(BLOCKLEFT);
			setState(278);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(277);
				ex();
				}
			}

			setState(280);
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
			setState(284);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(282);
				func();
				}
				break;
			case 2:
				{
				setState(283);
				atom();
				}
				break;
			}
			setState(286);
			match(LBRACE);
			{
			setState(287);
			index();
			setState(290);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(288);
				match(COMMA);
				setState(289);
				index();
				}
			}

			}
			setState(292);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode SCALAR_TYPE() { return getToken(ExpressionParser.SCALAR_TYPE, 0); }
		public TerminalNode MATRIX_TYPE() { return getToken(ExpressionParser.MATRIX_TYPE, 0); }
		public TerminalNode ARRAY_TYPE() { return getToken(ExpressionParser.ARRAY_TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SCALAR_TYPE) | (1L << MATRIX_TYPE) | (1L << ARRAY_TYPE))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
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
		enterRule(_localctx, 42, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(PRI);
			setState(297);
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
		enterRule(_localctx, 44, RULE_index);
		try {
			setState(301);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				match(DIGIT);
				}
				break;
			case MINUS:
			case E:
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
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
		enterRule(_localctx, 46, RULE_assignment);
		int _la;
		try {
			setState(322);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				match(VAR);
				setState(304);
				variable();
				setState(305);
				match(ASSIGN);
				setState(306);
				expression();
				}
				break;
			case MINUS:
			case E:
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				((AssignmentContext)_localctx).varName = variable();
				setState(317);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(309);
					match(LBRACE);
					{
					{
					setState(310);
					index();
					}
					setState(313);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(311);
						match(COMMA);
						setState(312);
						index();
						}
					}

					}
					setState(315);
					match(RBRACE);
					}
				}

				setState(319);
				match(ASSIGN);
				setState(320);
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
		enterRule(_localctx, 48, RULE_number);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(324);
				match(MINUS);
				}
			}

			setState(328); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(327);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(330); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(338);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(332);
				match(POINT);
				setState(334); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(333);
						match(DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(336); 
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
		enterRule(_localctx, 50, RULE_scientific);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			number();
			setState(343);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(341);
				match(E);
				setState(342);
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
		enterRule(_localctx, 52, RULE_func);
		int _la;
		try {
			_localctx = new FuncDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			funcName();
			setState(346);
			match(LPAREN);
			setState(348);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << LETTER) | (1L << NEW) | (1L << NOT))) != 0)) {
				{
				setState(347);
				funcParams();
				}
			}

			setState(350);
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
		enterRule(_localctx, 54, RULE_funcParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(352);
			expr(0);
			}
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(353);
				match(COMMA);
				{
				setState(354);
				expr(0);
				}
				}
				}
				setState(359);
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
		enterRule(_localctx, 56, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(RETURN);
			setState(361);
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
		enterRule(_localctx, 58, RULE_procedureParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(363);
			variable();
			}
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(364);
				match(COMMA);
				{
				setState(365);
				variable();
				}
				}
				}
				setState(370);
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
		public ProcedureReturnTypeContext procedureReturnType() {
			return getRuleContext(ProcedureReturnTypeContext.class,0);
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
		enterRule(_localctx, 60, RULE_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(FUNCTION);
			setState(372);
			funcName();
			setState(373);
			match(LPAREN);
			setState(375);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << E) | (1L << LETTER))) != 0)) {
				{
				setState(374);
				procedureParams();
				}
			}

			setState(377);
			match(RPAREN);
			setState(379);
			_la = _input.LA(1);
			if (_la==RIGHT_ARROW) {
				{
				setState(378);
				procedureReturnType();
				}
			}

			setState(381);
			match(BLOCKLEFT);
			setState(383);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(382);
				ex();
				}
			}

			setState(385);
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

	public static class ProcedureReturnTypeContext extends ParserRuleContext {
		public TerminalNode RIGHT_ARROW() { return getToken(ExpressionParser.RIGHT_ARROW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ProcedureReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_procedureReturnType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterProcedureReturnType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitProcedureReturnType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitProcedureReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcedureReturnTypeContext procedureReturnType() throws RecognitionException {
		ProcedureReturnTypeContext _localctx = new ProcedureReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_procedureReturnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(RIGHT_ARROW);
			setState(388);
			type();
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
		enterRule(_localctx, 64, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(390);
				match(MINUS);
				}
			}

			setState(393);
			match(LBRACE);
			setState(402);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << DIGIT) | (1L << LETTER) | (1L << NEW) | (1L << NOT))) != 0)) {
				{
				{
				setState(394);
				expr(0);
				}
				setState(399);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(395);
					match(COMMA);
					{
					setState(396);
					expr(0);
					}
					}
					}
					setState(401);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(404);
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
		enterRule(_localctx, 66, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			arrayInner();
			setState(407);
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
		enterRule(_localctx, 68, RULE_arrayInner);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(409);
			expr(0);
			}
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(410);
				match(COMMA);
				{
				setState(411);
				expr(0);
				}
				}
				}
				setState(416);
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
		enterRule(_localctx, 70, RULE_matrix);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(417);
				match(MINUS);
				}
			}

			setState(420);
			match(LBRACE);
			setState(431);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				{
				{
				setState(421);
				column();
				setState(425);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(422);
						column();
						}
						} 
					}
					setState(427);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
				}
				setState(428);
				arrayInner();
				}
				}
				break;
			case 2:
				{
				setState(430);
				arrayInner();
				}
				break;
			}
			setState(433);
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
		enterRule(_localctx, 72, RULE_funcName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			_la = _input.LA(1);
			if ( !(_la==E || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(439);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				{
				setState(436);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(441);
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
		enterRule(_localctx, 74, RULE_variable);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(442);
				match(MINUS);
				}
			}

			setState(445);
			_la = _input.LA(1);
			if ( !(_la==E || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(449);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(446);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(451);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u01c7\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\7\2P\n\2\f\2\16\2S\13"+
		"\2\3\2\5\2V\n\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3^\n\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\7\3f\n\3\f\3\16\3i\13\3\3\4\3\4\3\4\3\4\3\5\7\5p\n\5\f\5\16\5s\13\5"+
		"\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u0084"+
		"\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\7\7\u0098\n\7\f\7\16\7\u009b\13\7\3\b\3\b\3\b\3\b\5\b\u00a1\n\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00a9\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u00b6\n\n\3\13\3\13\3\13\5\13\u00bb\n\13\3\f\3\f\3\f"+
		"\3\f\3\f\5\f\u00c2\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00cd\n"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00d5\n\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\5\20\u00ec\n\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00f6\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0100\n"+
		"\22\3\22\3\22\7\22\u0104\n\22\f\22\16\22\u0107\13\22\3\22\5\22\u010a\n"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0112\n\23\3\23\3\23\3\24\3\24"+
		"\3\24\5\24\u0119\n\24\3\24\3\24\3\25\3\25\5\25\u011f\n\25\3\25\3\25\3"+
		"\25\3\25\5\25\u0125\n\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30"+
		"\5\30\u0130\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31"+
		"\u013c\n\31\3\31\3\31\5\31\u0140\n\31\3\31\3\31\3\31\5\31\u0145\n\31\3"+
		"\32\5\32\u0148\n\32\3\32\6\32\u014b\n\32\r\32\16\32\u014c\3\32\3\32\6"+
		"\32\u0151\n\32\r\32\16\32\u0152\5\32\u0155\n\32\3\33\3\33\3\33\5\33\u015a"+
		"\n\33\3\34\3\34\3\34\5\34\u015f\n\34\3\34\3\34\3\35\3\35\3\35\7\35\u0166"+
		"\n\35\f\35\16\35\u0169\13\35\3\36\3\36\3\36\3\37\3\37\3\37\7\37\u0171"+
		"\n\37\f\37\16\37\u0174\13\37\3 \3 \3 \3 \5 \u017a\n \3 \3 \5 \u017e\n"+
		" \3 \3 \5 \u0182\n \3 \3 \3!\3!\3!\3\"\5\"\u018a\n\"\3\"\3\"\3\"\3\"\7"+
		"\"\u0190\n\"\f\"\16\"\u0193\13\"\5\"\u0195\n\"\3\"\3\"\3#\3#\3#\3$\3$"+
		"\3$\7$\u019f\n$\f$\16$\u01a2\13$\3%\5%\u01a5\n%\3%\3%\3%\7%\u01aa\n%\f"+
		"%\16%\u01ad\13%\3%\3%\3%\5%\u01b2\n%\3%\3%\3&\3&\7&\u01b8\n&\f&\16&\u01bb"+
		"\13&\3\'\5\'\u01be\n\'\3\'\3\'\7\'\u01c2\n\'\f\'\16\'\u01c5\13\'\3\'\2"+
		"\3\f(\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>"+
		"@BDFHJL\2\n\b\2\16\16\22\22\24\24\30\30\'\'\60\60\3\2\23\24\3\2\21\22"+
		"\4\2\t\t\f\f\3\2\4\6\4\2\30\30\60\60\6\2\16\16\30\30\'\'\60\60\5\2\30"+
		"\30\'\'\60\60\u01e8\2Q\3\2\2\2\4]\3\2\2\2\6j\3\2\2\2\bq\3\2\2\2\nt\3\2"+
		"\2\2\f\u0083\3\2\2\2\16\u00a0\3\2\2\2\20\u00a8\3\2\2\2\22\u00b5\3\2\2"+
		"\2\24\u00ba\3\2\2\2\26\u00c1\3\2\2\2\30\u00cc\3\2\2\2\32\u00ce\3\2\2\2"+
		"\34\u00d8\3\2\2\2\36\u00e0\3\2\2\2 \u00ef\3\2\2\2\"\u00f9\3\2\2\2$\u010b"+
		"\3\2\2\2&\u0115\3\2\2\2(\u011e\3\2\2\2*\u0128\3\2\2\2,\u012a\3\2\2\2."+
		"\u012f\3\2\2\2\60\u0144\3\2\2\2\62\u0147\3\2\2\2\64\u0156\3\2\2\2\66\u015b"+
		"\3\2\2\28\u0162\3\2\2\2:\u016a\3\2\2\2<\u016d\3\2\2\2>\u0175\3\2\2\2@"+
		"\u0185\3\2\2\2B\u0189\3\2\2\2D\u0198\3\2\2\2F\u019b\3\2\2\2H\u01a4\3\2"+
		"\2\2J\u01b5\3\2\2\2L\u01bd\3\2\2\2NP\5\6\4\2ON\3\2\2\2PS\3\2\2\2QO\3\2"+
		"\2\2QR\3\2\2\2RU\3\2\2\2SQ\3\2\2\2TV\5\4\3\2UT\3\2\2\2UV\3\2\2\2V\3\3"+
		"\2\2\2W^\5\n\6\2X^\5,\27\2Y^\5\60\31\2Z^\5\24\13\2[^\5> \2\\^\5:\36\2"+
		"]W\3\2\2\2]X\3\2\2\2]Y\3\2\2\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2\2^g\3\2\2"+
		"\2_f\5\n\6\2`f\5,\27\2af\5\60\31\2bf\5\24\13\2cf\5> \2df\5:\36\2e_\3\2"+
		"\2\2e`\3\2\2\2ea\3\2\2\2eb\3\2\2\2ec\3\2\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2"+
		"\2\2gh\3\2\2\2h\5\3\2\2\2ig\3\2\2\2jk\7+\2\2kl\5\b\5\2lm\7\31\2\2m\7\3"+
		"\2\2\2np\t\2\2\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\t\3\2\2\2sq"+
		"\3\2\2\2tu\5\f\7\2uv\7\31\2\2v\13\3\2\2\2wx\b\7\1\2x\u0084\5\32\16\2y"+
		"\u0084\5\20\t\2z\u0084\5(\25\2{|\7\26\2\2|}\5\f\7\2}~\7\27\2\2~\u0084"+
		"\3\2\2\2\177\u0084\5\22\n\2\u0080\u0084\5\34\17\2\u0081\u0084\5\66\34"+
		"\2\u0082\u0084\5\16\b\2\u0083w\3\2\2\2\u0083y\3\2\2\2\u0083z\3\2\2\2\u0083"+
		"{\3\2\2\2\u0083\177\3\2\2\2\u0083\u0080\3\2\2\2\u0083\u0081\3\2\2\2\u0083"+
		"\u0082\3\2\2\2\u0084\u0099\3\2\2\2\u0085\u0086\f\13\2\2\u0086\u0087\7"+
		"\32\2\2\u0087\u0098\5\f\7\f\u0088\u0089\f\n\2\2\u0089\u008a\7\25\2\2\u008a"+
		"\u0098\5\f\7\13\u008b\u008c\f\t\2\2\u008c\u008d\t\3\2\2\u008d\u0098\5"+
		"\f\7\n\u008e\u008f\f\b\2\2\u008f\u0090\t\4\2\2\u0090\u0098\5\f\7\t\u0091"+
		"\u0092\f\7\2\2\u0092\u0093\7\33\2\2\u0093\u0098\5\f\7\b\u0094\u0095\f"+
		"\3\2\2\u0095\u0096\7(\2\2\u0096\u0098\5\f\7\4\u0097\u0085\3\2\2\2\u0097"+
		"\u0088\3\2\2\2\u0097\u008b\3\2\2\2\u0097\u008e\3\2\2\2\u0097\u0091\3\2"+
		"\2\2\u0097\u0094\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\r\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u00a1\5\64\33"+
		"\2\u009d\u00a1\5L\'\2\u009e\u00a1\5B\"\2\u009f\u00a1\5H%\2\u00a0\u009c"+
		"\3\2\2\2\u00a0\u009d\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u009f\3\2\2\2\u00a1"+
		"\17\3\2\2\2\u00a2\u00a3\5\16\b\2\u00a3\u00a4\t\5\2\2\u00a4\u00a9\3\2\2"+
		"\2\u00a5\u00a6\5\66\34\2\u00a6\u00a7\t\5\2\2\u00a7\u00a9\3\2\2\2\u00a8"+
		"\u00a2\3\2\2\2\u00a8\u00a5\3\2\2\2\u00a9\21\3\2\2\2\u00aa\u00ab\7\67\2"+
		"\2\u00ab\u00ac\7\26\2\2\u00ac\u00ad\5L\'\2\u00ad\u00ae\7\3\2\2\u00ae\u00af"+
		"\5*\26\2\u00af\u00b0\7\27\2\2\u00b0\u00b6\3\2\2\2\u00b1\u00b2\5L\'\2\u00b2"+
		"\u00b3\7\3\2\2\u00b3\u00b4\5*\26\2\u00b4\u00b6\3\2\2\2\u00b5\u00aa\3\2"+
		"\2\2\u00b5\u00b1\3\2\2\2\u00b6\23\3\2\2\2\u00b7\u00bb\5\"\22\2\u00b8\u00bb"+
		"\5\36\20\2\u00b9\u00bb\5 \21\2\u00ba\u00b7\3\2\2\2\u00ba\u00b8\3\2\2\2"+
		"\u00ba\u00b9\3\2\2\2\u00bb\25\3\2\2\2\u00bc\u00bd\5\f\7\2\u00bd\u00be"+
		"\7\32\2\2\u00be\u00bf\5\f\7\2\u00bf\u00c2\3\2\2\2\u00c0\u00c2\5\22\n\2"+
		"\u00c1\u00bc\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\27\3\2\2\2\u00c3\u00c4"+
		"\5L\'\2\u00c4\u00c5\7\32\2\2\u00c5\u00c6\5\f\7\2\u00c6\u00cd\3\2\2\2\u00c7"+
		"\u00c8\5\f\7\2\u00c8\u00c9\7\32\2\2\u00c9\u00ca\5L\'\2\u00ca\u00cd\3\2"+
		"\2\2\u00cb\u00cd\5\22\n\2\u00cc\u00c3\3\2\2\2\u00cc\u00c7\3\2\2\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd\31\3\2\2\2\u00ce\u00cf\7\63\2\2\u00cf\u00d0\5*\26"+
		"\2\u00d0\u00d1\7\26\2\2\u00d1\u00d4\5.\30\2\u00d2\u00d3\7\35\2\2\u00d3"+
		"\u00d5\5.\30\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2"+
		"\2\2\u00d6\u00d7\7\27\2\2\u00d7\33\3\2\2\2\u00d8\u00d9\7\26\2\2\u00d9"+
		"\u00da\5\26\f\2\u00da\u00db\7\27\2\2\u00db\u00dc\7\64\2\2\u00dc\u00dd"+
		"\5\f\7\2\u00dd\u00de\7\65\2\2\u00de\u00df\5\f\7\2\u00df\35\3\2\2\2\u00e0"+
		"\u00e1\7.\2\2\u00e1\u00e2\7\26\2\2\u00e2\u00e3\5\60\31\2\u00e3\u00e4\5"+
		"\30\r\2\u00e4\u00e5\7\31\2\2\u00e5\u00e6\5L\'\2\u00e6\u00e7\t\5\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e9\7\27\2\2\u00e9\u00eb\78\2\2\u00ea\u00ec\5\4"+
		"\3\2\u00eb\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ee\7:\2\2\u00ee\37\3\2\2\2\u00ef\u00f0\7/\2\2\u00f0\u00f1\7\26\2\2"+
		"\u00f1\u00f2\5\30\r\2\u00f2\u00f3\7\27\2\2\u00f3\u00f5\78\2\2\u00f4\u00f6"+
		"\5\4\3\2\u00f5\u00f4\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7"+
		"\u00f8\7:\2\2\u00f8!\3\2\2\2\u00f9\u00fa\7*\2\2\u00fa\u00fb\7\26\2\2\u00fb"+
		"\u00fc\5\26\f\2\u00fc\u00fd\7\27\2\2\u00fd\u00ff\78\2\2\u00fe\u0100\5"+
		"\4\3\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101"+
		"\u0105\7:\2\2\u0102\u0104\5$\23\2\u0103\u0102\3\2\2\2\u0104\u0107\3\2"+
		"\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0109\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0108\u010a\5&\24\2\u0109\u0108\3\2\2\2\u0109\u010a\3\2"+
		"\2\2\u010a#\3\2\2\2\u010b\u010c\7-\2\2\u010c\u010d\7\26\2\2\u010d\u010e"+
		"\5\26\f\2\u010e\u010f\7\27\2\2\u010f\u0111\78\2\2\u0110\u0112\5\4\3\2"+
		"\u0111\u0110\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114"+
		"\7:\2\2\u0114%\3\2\2\2\u0115\u0116\7,\2\2\u0116\u0118\78\2\2\u0117\u0119"+
		"\5\4\3\2\u0118\u0117\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011b\7:\2\2\u011b\'\3\2\2\2\u011c\u011f\5\66\34\2\u011d\u011f\5\16\b"+
		"\2\u011e\u011c\3\2\2\2\u011e\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121"+
		"\7\r\2\2\u0121\u0124\5.\30\2\u0122\u0123\7\35\2\2\u0123\u0125\5.\30\2"+
		"\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127"+
		"\7\17\2\2\u0127)\3\2\2\2\u0128\u0129\t\6\2\2\u0129+\3\2\2\2\u012a\u012b"+
		"\7\66\2\2\u012b\u012c\5\n\6\2\u012c-\3\2\2\2\u012d\u0130\7\'\2\2\u012e"+
		"\u0130\5L\'\2\u012f\u012d\3\2\2\2\u012f\u012e\3\2\2\2\u0130/\3\2\2\2\u0131"+
		"\u0132\7)\2\2\u0132\u0133\5L\'\2\u0133\u0134\7&\2\2\u0134\u0135\5\n\6"+
		"\2\u0135\u0145\3\2\2\2\u0136\u013f\5L\'\2\u0137\u0138\7\r\2\2\u0138\u013b"+
		"\5.\30\2\u0139\u013a\7\35\2\2\u013a\u013c\5.\30\2\u013b\u0139\3\2\2\2"+
		"\u013b\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013e\7\17\2\2\u013e\u0140"+
		"\3\2\2\2\u013f\u0137\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u0142\7&\2\2\u0142\u0143\5\n\6\2\u0143\u0145\3\2\2\2\u0144\u0131\3\2"+
		"\2\2\u0144\u0136\3\2\2\2\u0145\61\3\2\2\2\u0146\u0148\7\22\2\2\u0147\u0146"+
		"\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u014b\7\'\2\2\u014a"+
		"\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2"+
		"\2\2\u014d\u0154\3\2\2\2\u014e\u0150\7(\2\2\u014f\u0151\7\'\2\2\u0150"+
		"\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2"+
		"\2\2\u0153\u0155\3\2\2\2\u0154\u014e\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"\63\3\2\2\2\u0156\u0159\5\62\32\2\u0157\u0158\7\30\2\2\u0158\u015a\5\62"+
		"\32\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\65\3\2\2\2\u015b\u015c"+
		"\5J&\2\u015c\u015e\7\26\2\2\u015d\u015f\58\35\2\u015e\u015d\3\2\2\2\u015e"+
		"\u015f\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0161\7\27\2\2\u0161\67\3\2\2"+
		"\2\u0162\u0167\5\f\7\2\u0163\u0164\7\35\2\2\u0164\u0166\5\f\7\2\u0165"+
		"\u0163\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2"+
		"\2\2\u01689\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016b\7\7\2\2\u016b\u016c"+
		"\5\n\6\2\u016c;\3\2\2\2\u016d\u0172\5L\'\2\u016e\u016f\7\35\2\2\u016f"+
		"\u0171\5L\'\2\u0170\u016e\3\2\2\2\u0171\u0174\3\2\2\2\u0172\u0170\3\2"+
		"\2\2\u0172\u0173\3\2\2\2\u0173=\3\2\2\2\u0174\u0172\3\2\2\2\u0175\u0176"+
		"\7\b\2\2\u0176\u0177\5J&\2\u0177\u0179\7\26\2\2\u0178\u017a\5<\37\2\u0179"+
		"\u0178\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017d\7\27"+
		"\2\2\u017c\u017e\5@!\2\u017d\u017c\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017f"+
		"\3\2\2\2\u017f\u0181\78\2\2\u0180\u0182\5\4\3\2\u0181\u0180\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0184\7:\2\2\u0184?\3\2\2\2\u0185"+
		"\u0186\7\20\2\2\u0186\u0187\5*\26\2\u0187A\3\2\2\2\u0188\u018a\7\22\2"+
		"\2\u0189\u0188\3\2\2\2\u0189\u018a\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u0194"+
		"\7\r\2\2\u018c\u0191\5\f\7\2\u018d\u018e\7\35\2\2\u018e\u0190\5\f\7\2"+
		"\u018f\u018d\3\2\2\2\u0190\u0193\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0192"+
		"\3\2\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2\2\u0194\u018c\3\2\2\2\u0194"+
		"\u0195\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\7\17\2\2\u0197C\3\2\2\2"+
		"\u0198\u0199\5F$\2\u0199\u019a\7\31\2\2\u019aE\3\2\2\2\u019b\u01a0\5\f"+
		"\7\2\u019c\u019d\7\35\2\2\u019d\u019f\5\f\7\2\u019e\u019c\3\2\2\2\u019f"+
		"\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1G\3\2\2\2"+
		"\u01a2\u01a0\3\2\2\2\u01a3\u01a5\7\22\2\2\u01a4\u01a3\3\2\2\2\u01a4\u01a5"+
		"\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01b1\7\r\2\2\u01a7\u01ab\5D#\2\u01a8"+
		"\u01aa\5D#\2\u01a9\u01a8\3\2\2\2\u01aa\u01ad\3\2\2\2\u01ab\u01a9\3\2\2"+
		"\2\u01ab\u01ac\3\2\2\2\u01ac\u01ae\3\2\2\2\u01ad\u01ab\3\2\2\2\u01ae\u01af"+
		"\5F$\2\u01af\u01b2\3\2\2\2\u01b0\u01b2\5F$\2\u01b1\u01a7\3\2\2\2\u01b1"+
		"\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\7\17\2\2\u01b4I\3\2\2\2"+
		"\u01b5\u01b9\t\7\2\2\u01b6\u01b8\t\b\2\2\u01b7\u01b6\3\2\2\2\u01b8\u01bb"+
		"\3\2\2\2\u01b9\u01b7\3\2\2\2\u01b9\u01ba\3\2\2\2\u01baK\3\2\2\2\u01bb"+
		"\u01b9\3\2\2\2\u01bc\u01be\7\22\2\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3"+
		"\2\2\2\u01be\u01bf\3\2\2\2\u01bf\u01c3\t\7\2\2\u01c0\u01c2\t\t\2\2\u01c1"+
		"\u01c0\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2"+
		"\2\2\u01c4M\3\2\2\2\u01c5\u01c3\3\2\2\2\64QU]egq\u0083\u0097\u0099\u00a0"+
		"\u00a8\u00b5\u00ba\u00c1\u00cc\u00d4\u00eb\u00f5\u00ff\u0105\u0109\u0111"+
		"\u0118\u011e\u0124\u012f\u013b\u013f\u0144\u0147\u014c\u0152\u0154\u0159"+
		"\u015e\u0167\u0172\u0179\u017d\u0181\u0189\u0191\u0194\u01a0\u01a4\u01ab"+
		"\u01b1\u01b9\u01bd\u01c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}