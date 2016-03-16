// Generated from Expression.g4 by ANTLR 4.5.1

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
		RULE_prefixOperation = 8, RULE_instanceOfExpression = 9, RULE_controlStatement = 10, 
		RULE_logicalOperation = 11, RULE_forcedLogicalOperation = 12, RULE_newStructure = 13, 
		RULE_ternary = 14, RULE_forLoop = 15, RULE_whileLoop = 16, RULE_ifStatement = 17, 
		RULE_elseifStatement = 18, RULE_elseStatement = 19, RULE_arrayAccess = 20, 
		RULE_type = 21, RULE_print = 22, RULE_index = 23, RULE_assignment = 24, 
		RULE_number = 25, RULE_scientific = 26, RULE_func = 27, RULE_funcParams = 28, 
		RULE_returnStatement = 29, RULE_procedureParams = 30, RULE_procedure = 31, 
		RULE_procedureReturnType = 32, RULE_array = 33, RULE_column = 34, RULE_arrayInner = 35, 
		RULE_matrix = 36, RULE_funcName = 37, RULE_variable = 38;
	public static final String[] ruleNames = {
		"start", "ex", "importStatement", "file", "expression", "expr", "atom", 
		"incDecExpression", "prefixOperation", "instanceOfExpression", "controlStatement", 
		"logicalOperation", "forcedLogicalOperation", "newStructure", "ternary", 
		"forLoop", "whileLoop", "ifStatement", "elseifStatement", "elseStatement", 
		"arrayAccess", "type", "print", "index", "assignment", "number", "scientific", 
		"func", "funcParams", "returnStatement", "procedureParams", "procedure", 
		"procedureReturnType", "array", "column", "arrayInner", "matrix", "funcName", 
		"variable"
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
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(78);
				importStatement();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << OPERATOR) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(84);
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
			setState(93);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(87);
				expression();
				}
				break;
			case 2:
				{
				setState(88);
				print();
				}
				break;
			case 3:
				{
				setState(89);
				assignment();
				}
				break;
			case 4:
				{
				setState(90);
				controlStatement();
				}
				break;
			case 5:
				{
				setState(91);
				procedure();
				}
				break;
			case 6:
				{
				setState(92);
				returnStatement();
				}
				break;
			}
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << OPERATOR) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(101);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(95);
					expression();
					}
					break;
				case 2:
					{
					setState(96);
					print();
					}
					break;
				case 3:
					{
					setState(97);
					assignment();
					}
					break;
				case 4:
					{
					setState(98);
					controlStatement();
					}
					break;
				case 5:
					{
					setState(99);
					procedure();
					}
					break;
				case 6:
					{
					setState(100);
					returnStatement();
					}
					break;
				}
				}
				setState(105);
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
			setState(106);
			match(IMPORT);
			setState(107);
			file();
			setState(108);
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
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << MINUS) | (1L << DIV) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				{
				setState(110);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << MINUS) | (1L << DIV) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(115);
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
			setState(116);
			expr(0);
			setState(117);
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
	public static class PrefixExprContext extends ExprContext {
		public PrefixOperationContext prefixOperation() {
			return getRuleContext(PrefixOperationContext.class,0);
		}
		public PrefixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterPrefixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitPrefixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitPrefixExpr(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new IncDecExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(120);
				incDecExpression();
				}
				break;
			case 2:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				prefixOperation();
				}
				break;
			case 3:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				newStructure();
				}
				break;
			case 4:
				{
				_localctx = new ArrayAccessExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				arrayAccess();
				}
				break;
			case 5:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(LPAREN);
				setState(125);
				expr(0);
				setState(126);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new InstanceofExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				instanceOfExpression();
				}
				break;
			case 7:
				{
				_localctx = new TernaryExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				ternary();
				}
				break;
			case 8:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(130);
				func();
				}
				break;
			case 9:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(131);
				atom();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(152);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new BoolExprContext(new ExprContext(_parentctx, _parentState));
						((BoolExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(135);
						((BoolExprContext)_localctx).op = match(LOGICAL);
						setState(136);
						((BoolExprContext)_localctx).right = expr(10);
						}
						break;
					case 2:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(138);
						((OpExprContext)_localctx).op = match(POW);
						setState(139);
						((OpExprContext)_localctx).right = expr(9);
						}
						break;
					case 3:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(141);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIV) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(142);
						((OpExprContext)_localctx).right = expr(8);
						}
						break;
					case 4:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(144);
						((OpExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((OpExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(145);
						((OpExprContext)_localctx).right = expr(7);
						}
						break;
					case 5:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(147);
						((OpExprContext)_localctx).op = match(OPERATOR);
						setState(148);
						((OpExprContext)_localctx).right = expr(6);
						}
						break;
					case 6:
						{
						_localctx = new OpExprContext(new ExprContext(_parentctx, _parentState));
						((OpExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(149);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(150);
						((OpExprContext)_localctx).op = match(POINT);
						setState(151);
						((OpExprContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(156);
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
			setState(161);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				scientific();
				}
				break;
			case 2:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(158);
				variable();
				}
				break;
			case 3:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(159);
				array();
				}
				break;
			case 4:
				_localctx = new AtomValueContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
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
		public TerminalNode OPERATOR() { return getToken(ExpressionParser.OPERATOR, 0); }
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
			setState(169);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				atom();
				setState(164);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INCREMENT) | (1L << DECREMENT) | (1L << OPERATOR))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				func();
				setState(167);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INCREMENT) | (1L << DECREMENT) | (1L << OPERATOR))) != 0)) ) {
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

	public static class PrefixOperationContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode INCREMENT() { return getToken(ExpressionParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(ExpressionParser.DECREMENT, 0); }
		public TerminalNode OPERATOR() { return getToken(ExpressionParser.OPERATOR, 0); }
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public PrefixOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).enterPrefixOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpressionListener ) ((ExpressionListener)listener).exitPrefixOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpressionVisitor ) return ((ExpressionVisitor<? extends T>)visitor).visitPrefixOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixOperationContext prefixOperation() throws RecognitionException {
		PrefixOperationContext _localctx = new PrefixOperationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_prefixOperation);
		int _la;
		try {
			setState(175);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INCREMENT) | (1L << DECREMENT) | (1L << OPERATOR))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(172);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INCREMENT) | (1L << DECREMENT) | (1L << OPERATOR))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				setState(174);
				func();
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
		enterRule(_localctx, 18, RULE_instanceOfExpression);
		try {
			setState(188);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(NOT);
				setState(178);
				match(LPAREN);
				setState(179);
				variable();
				setState(180);
				match(INSTANCE_OF);
				setState(181);
				type();
				setState(182);
				match(RPAREN);
				}
				break;
			case MINUS:
			case E:
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				variable();
				setState(185);
				match(INSTANCE_OF);
				setState(186);
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
		enterRule(_localctx, 20, RULE_controlStatement);
		try {
			setState(193);
			switch (_input.LA(1)) {
			case IF:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				ifStatement();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(191);
				forLoop();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
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
		enterRule(_localctx, 22, RULE_logicalOperation);
		try {
			setState(200);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				((LogicalOperationContext)_localctx).left = expr(0);
				setState(196);
				((LogicalOperationContext)_localctx).op = match(LOGICAL);
				setState(197);
				((LogicalOperationContext)_localctx).right = expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
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
		enterRule(_localctx, 24, RULE_forcedLogicalOperation);
		try {
			setState(211);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				variable();
				setState(203);
				match(LOGICAL);
				setState(204);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(206);
				expr(0);
				setState(207);
				match(LOGICAL);
				setState(208);
				variable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
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
		enterRule(_localctx, 26, RULE_newStructure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(NEW);
			setState(214);
			type();
			setState(215);
			match(LPAREN);
			setState(216);
			index();
			setState(219);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(217);
				match(COMMA);
				setState(218);
				index();
				}
			}

			setState(221);
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
		enterRule(_localctx, 28, RULE_ternary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(LPAREN);
			setState(224);
			logicalOperation();
			setState(225);
			match(RPAREN);
			setState(226);
			match(QMARK);
			setState(227);
			expr(0);
			setState(228);
			match(COLON);
			setState(229);
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
		enterRule(_localctx, 30, RULE_forLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(FOR);
			setState(232);
			match(LPAREN);
			setState(233);
			assignment();
			setState(234);
			forcedLogicalOperation();
			setState(235);
			match(SEMI_COLON);
			{
			setState(236);
			variable();
			setState(237);
			_la = _input.LA(1);
			if ( !(_la==INCREMENT || _la==DECREMENT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
			setState(239);
			match(RPAREN);
			setState(240);
			match(BLOCKLEFT);
			setState(242);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << OPERATOR) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(241);
				ex();
				}
			}

			setState(244);
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
		enterRule(_localctx, 32, RULE_whileLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(WHILE);
			setState(247);
			match(LPAREN);
			setState(248);
			forcedLogicalOperation();
			setState(249);
			match(RPAREN);
			setState(250);
			match(BLOCKLEFT);
			setState(252);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << OPERATOR) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(251);
				ex();
				}
			}

			setState(254);
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
		enterRule(_localctx, 34, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(IF);
			setState(257);
			match(LPAREN);
			setState(258);
			logicalOperation();
			setState(259);
			match(RPAREN);
			setState(260);
			match(BLOCKLEFT);
			setState(262);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << OPERATOR) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(261);
				ex();
				}
			}

			setState(264);
			match(BLOCKRIGHT);
			setState(268);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELSEIF) {
				{
				{
				setState(265);
				elseifStatement();
				}
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(272);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(271);
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
		enterRule(_localctx, 36, RULE_elseifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(ELSEIF);
			setState(275);
			match(LPAREN);
			setState(276);
			logicalOperation();
			setState(277);
			match(RPAREN);
			setState(278);
			match(BLOCKLEFT);
			setState(280);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << OPERATOR) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(279);
				ex();
				}
			}

			setState(282);
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
		enterRule(_localctx, 38, RULE_elseStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(ELSE);
			setState(285);
			match(BLOCKLEFT);
			setState(287);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << OPERATOR) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(286);
				ex();
				}
			}

			setState(289);
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
		enterRule(_localctx, 40, RULE_arrayAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(291);
				func();
				}
				break;
			case 2:
				{
				setState(292);
				atom();
				}
				break;
			}
			setState(295);
			match(LBRACE);
			{
			setState(296);
			index();
			setState(299);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(297);
				match(COMMA);
				setState(298);
				index();
				}
			}

			}
			setState(301);
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
		enterRule(_localctx, 42, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
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
		enterRule(_localctx, 44, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(PRI);
			setState(306);
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
		enterRule(_localctx, 46, RULE_index);
		try {
			setState(310);
			switch (_input.LA(1)) {
			case DIGIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				match(DIGIT);
				}
				break;
			case MINUS:
			case E:
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
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
		enterRule(_localctx, 48, RULE_assignment);
		int _la;
		try {
			setState(331);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				match(VAR);
				setState(313);
				variable();
				setState(314);
				match(ASSIGN);
				setState(315);
				expression();
				}
				break;
			case MINUS:
			case E:
			case LETTER:
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				((AssignmentContext)_localctx).varName = variable();
				setState(326);
				_la = _input.LA(1);
				if (_la==LBRACE) {
					{
					setState(318);
					match(LBRACE);
					{
					{
					setState(319);
					index();
					}
					setState(322);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(320);
						match(COMMA);
						setState(321);
						index();
						}
					}

					}
					setState(324);
					match(RBRACE);
					}
				}

				setState(328);
				match(ASSIGN);
				setState(329);
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
		enterRule(_localctx, 50, RULE_number);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(333);
				match(MINUS);
				}
			}

			setState(337); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(336);
					match(DIGIT);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(339); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(347);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(341);
				match(POINT);
				setState(343); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(342);
						match(DIGIT);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(345); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		enterRule(_localctx, 52, RULE_scientific);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			number();
			setState(352);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(350);
				match(E);
				setState(351);
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
		enterRule(_localctx, 54, RULE_func);
		int _la;
		try {
			_localctx = new FuncDefinitionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			funcName();
			setState(355);
			match(LPAREN);
			setState(357);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INCREMENT) | (1L << DECREMENT) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << OPERATOR) | (1L << DIGIT) | (1L << LETTER) | (1L << NEW) | (1L << NOT))) != 0)) {
				{
				setState(356);
				funcParams();
				}
			}

			setState(359);
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
		enterRule(_localctx, 56, RULE_funcParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(361);
			expr(0);
			}
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(362);
				match(COMMA);
				{
				setState(363);
				expr(0);
				}
				}
				}
				setState(368);
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
		enterRule(_localctx, 58, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(RETURN);
			setState(370);
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
		enterRule(_localctx, 60, RULE_procedureParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(372);
			variable();
			}
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(373);
				match(COMMA);
				{
				setState(374);
				variable();
				}
				}
				}
				setState(379);
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
		enterRule(_localctx, 62, RULE_procedure);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(FUNCTION);
			setState(381);
			funcName();
			setState(382);
			match(LPAREN);
			setState(384);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MINUS) | (1L << E) | (1L << LETTER))) != 0)) {
				{
				setState(383);
				procedureParams();
				}
			}

			setState(386);
			match(RPAREN);
			setState(388);
			_la = _input.LA(1);
			if (_la==RIGHT_ARROW) {
				{
				setState(387);
				procedureReturnType();
				}
			}

			setState(390);
			match(BLOCKLEFT);
			setState(392);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << RETURN) | (1L << FUNCTION) | (1L << INCREMENT) | (1L << DECREMENT) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << OPERATOR) | (1L << DIGIT) | (1L << VAR) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << LETTER) | (1L << NEW) | (1L << PRI) | (1L << NOT))) != 0)) {
				{
				setState(391);
				ex();
				}
			}

			setState(394);
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
		enterRule(_localctx, 64, RULE_procedureReturnType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(RIGHT_ARROW);
			setState(397);
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
		enterRule(_localctx, 66, RULE_array);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(399);
				match(MINUS);
				}
			}

			setState(402);
			match(LBRACE);
			setState(411);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INCREMENT) | (1L << DECREMENT) | (1L << LBRACE) | (1L << MINUS) | (1L << LPAREN) | (1L << E) | (1L << OPERATOR) | (1L << DIGIT) | (1L << LETTER) | (1L << NEW) | (1L << NOT))) != 0)) {
				{
				{
				setState(403);
				expr(0);
				}
				setState(408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(404);
					match(COMMA);
					{
					setState(405);
					expr(0);
					}
					}
					}
					setState(410);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(413);
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
		enterRule(_localctx, 68, RULE_column);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			arrayInner();
			setState(416);
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
		enterRule(_localctx, 70, RULE_arrayInner);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(418);
			expr(0);
			}
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(419);
				match(COMMA);
				{
				setState(420);
				expr(0);
				}
				}
				}
				setState(425);
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
		enterRule(_localctx, 72, RULE_matrix);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(426);
				match(MINUS);
				}
			}

			setState(429);
			match(LBRACE);
			setState(440);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				{
				setState(430);
				column();
				setState(434);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(431);
						column();
						}
						} 
					}
					setState(436);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				}
				setState(437);
				arrayInner();
				}
				}
				break;
			case 2:
				{
				setState(439);
				arrayInner();
				}
				break;
			}
			setState(442);
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
		enterRule(_localctx, 74, RULE_funcName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			_la = _input.LA(1);
			if ( !(_la==E || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) {
				{
				{
				setState(445);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << UNDERSCORE) | (1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
				_errHandler.recoverInline(this);
				} else {
					consume();
				}
				}
				}
				setState(450);
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
		enterRule(_localctx, 76, RULE_variable);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(451);
				match(MINUS);
				}
			}

			setState(454);
			_la = _input.LA(1);
			if ( !(_la==E || _la==LETTER) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			setState(458);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(455);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << E) | (1L << DIGIT) | (1L << LETTER))) != 0)) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					}
					} 
				}
				setState(460);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3<\u01d0\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\7\2R\n\2\f\2\16"+
		"\2U\13\2\3\2\5\2X\n\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3`\n\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3h\n\3\f\3\16\3k\13\3\3\4\3\4\3\4\3\4\3\5\7\5r\n\5\f\5\16\5"+
		"u\13\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7\u0087\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\7\7\u009b\n\7\f\7\16\7\u009e\13\7\3\b\3\b\3\b\3\b\5\b"+
		"\u00a4\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00ac\n\t\3\n\3\n\3\n\3\n\5\n\u00b2"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00bf"+
		"\n\13\3\f\3\f\3\f\5\f\u00c4\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u00cb\n\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00d6\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00de\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21"+
		"\u00f5\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00ff\n\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0109\n\23\3\23\3\23\7\23"+
		"\u010d\n\23\f\23\16\23\u0110\13\23\3\23\5\23\u0113\n\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u011b\n\24\3\24\3\24\3\25\3\25\3\25\5\25\u0122\n"+
		"\25\3\25\3\25\3\26\3\26\5\26\u0128\n\26\3\26\3\26\3\26\3\26\5\26\u012e"+
		"\n\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\5\31\u0139\n\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0145\n\32\3\32\3\32"+
		"\5\32\u0149\n\32\3\32\3\32\3\32\5\32\u014e\n\32\3\33\5\33\u0151\n\33\3"+
		"\33\6\33\u0154\n\33\r\33\16\33\u0155\3\33\3\33\6\33\u015a\n\33\r\33\16"+
		"\33\u015b\5\33\u015e\n\33\3\34\3\34\3\34\5\34\u0163\n\34\3\35\3\35\3\35"+
		"\5\35\u0168\n\35\3\35\3\35\3\36\3\36\3\36\7\36\u016f\n\36\f\36\16\36\u0172"+
		"\13\36\3\37\3\37\3\37\3 \3 \3 \7 \u017a\n \f \16 \u017d\13 \3!\3!\3!\3"+
		"!\5!\u0183\n!\3!\3!\5!\u0187\n!\3!\3!\5!\u018b\n!\3!\3!\3\"\3\"\3\"\3"+
		"#\5#\u0193\n#\3#\3#\3#\3#\7#\u0199\n#\f#\16#\u019c\13#\5#\u019e\n#\3#"+
		"\3#\3$\3$\3$\3%\3%\3%\7%\u01a8\n%\f%\16%\u01ab\13%\3&\5&\u01ae\n&\3&\3"+
		"&\3&\7&\u01b3\n&\f&\16&\u01b6\13&\3&\3&\3&\5&\u01bb\n&\3&\3&\3\'\3\'\7"+
		"\'\u01c1\n\'\f\'\16\'\u01c4\13\'\3(\5(\u01c7\n(\3(\3(\7(\u01cb\n(\f(\16"+
		"(\u01ce\13(\3(\2\3\f)\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,."+
		"\60\62\64\668:<>@BDFHJLN\2\13\b\2\16\16\22\22\24\24\30\30\'\'\60\60\3"+
		"\2\23\24\3\2\21\22\5\2\t\t\f\f\33\33\4\2\t\t\f\f\3\2\4\6\4\2\30\30\60"+
		"\60\6\2\16\16\30\30\'\'\60\60\5\2\30\30\'\'\60\60\u01f2\2S\3\2\2\2\4_"+
		"\3\2\2\2\6l\3\2\2\2\bs\3\2\2\2\nv\3\2\2\2\f\u0086\3\2\2\2\16\u00a3\3\2"+
		"\2\2\20\u00ab\3\2\2\2\22\u00b1\3\2\2\2\24\u00be\3\2\2\2\26\u00c3\3\2\2"+
		"\2\30\u00ca\3\2\2\2\32\u00d5\3\2\2\2\34\u00d7\3\2\2\2\36\u00e1\3\2\2\2"+
		" \u00e9\3\2\2\2\"\u00f8\3\2\2\2$\u0102\3\2\2\2&\u0114\3\2\2\2(\u011e\3"+
		"\2\2\2*\u0127\3\2\2\2,\u0131\3\2\2\2.\u0133\3\2\2\2\60\u0138\3\2\2\2\62"+
		"\u014d\3\2\2\2\64\u0150\3\2\2\2\66\u015f\3\2\2\28\u0164\3\2\2\2:\u016b"+
		"\3\2\2\2<\u0173\3\2\2\2>\u0176\3\2\2\2@\u017e\3\2\2\2B\u018e\3\2\2\2D"+
		"\u0192\3\2\2\2F\u01a1\3\2\2\2H\u01a4\3\2\2\2J\u01ad\3\2\2\2L\u01be\3\2"+
		"\2\2N\u01c6\3\2\2\2PR\5\6\4\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2"+
		"TW\3\2\2\2US\3\2\2\2VX\5\4\3\2WV\3\2\2\2WX\3\2\2\2X\3\3\2\2\2Y`\5\n\6"+
		"\2Z`\5.\30\2[`\5\62\32\2\\`\5\26\f\2]`\5@!\2^`\5<\37\2_Y\3\2\2\2_Z\3\2"+
		"\2\2_[\3\2\2\2_\\\3\2\2\2_]\3\2\2\2_^\3\2\2\2`i\3\2\2\2ah\5\n\6\2bh\5"+
		".\30\2ch\5\62\32\2dh\5\26\f\2eh\5@!\2fh\5<\37\2ga\3\2\2\2gb\3\2\2\2gc"+
		"\3\2\2\2gd\3\2\2\2ge\3\2\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j"+
		"\5\3\2\2\2ki\3\2\2\2lm\7+\2\2mn\5\b\5\2no\7\31\2\2o\7\3\2\2\2pr\t\2\2"+
		"\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\t\3\2\2\2us\3\2\2\2vw\5\f"+
		"\7\2wx\7\31\2\2x\13\3\2\2\2yz\b\7\1\2z\u0087\5\20\t\2{\u0087\5\22\n\2"+
		"|\u0087\5\34\17\2}\u0087\5*\26\2~\177\7\26\2\2\177\u0080\5\f\7\2\u0080"+
		"\u0081\7\27\2\2\u0081\u0087\3\2\2\2\u0082\u0087\5\24\13\2\u0083\u0087"+
		"\5\36\20\2\u0084\u0087\58\35\2\u0085\u0087\5\16\b\2\u0086y\3\2\2\2\u0086"+
		"{\3\2\2\2\u0086|\3\2\2\2\u0086}\3\2\2\2\u0086~\3\2\2\2\u0086\u0082\3\2"+
		"\2\2\u0086\u0083\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087"+
		"\u009c\3\2\2\2\u0088\u0089\f\13\2\2\u0089\u008a\7\32\2\2\u008a\u009b\5"+
		"\f\7\f\u008b\u008c\f\n\2\2\u008c\u008d\7\25\2\2\u008d\u009b\5\f\7\13\u008e"+
		"\u008f\f\t\2\2\u008f\u0090\t\3\2\2\u0090\u009b\5\f\7\n\u0091\u0092\f\b"+
		"\2\2\u0092\u0093\t\4\2\2\u0093\u009b\5\f\7\t\u0094\u0095\f\7\2\2\u0095"+
		"\u0096\7\33\2\2\u0096\u009b\5\f\7\b\u0097\u0098\f\3\2\2\u0098\u0099\7"+
		"(\2\2\u0099\u009b\5\f\7\4\u009a\u0088\3\2\2\2\u009a\u008b\3\2\2\2\u009a"+
		"\u008e\3\2\2\2\u009a\u0091\3\2\2\2\u009a\u0094\3\2\2\2\u009a\u0097\3\2"+
		"\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\r\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a4\5\66\34\2\u00a0\u00a4\5N(\2"+
		"\u00a1\u00a4\5D#\2\u00a2\u00a4\5J&\2\u00a3\u009f\3\2\2\2\u00a3\u00a0\3"+
		"\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\17\3\2\2\2\u00a5"+
		"\u00a6\5\16\b\2\u00a6\u00a7\t\5\2\2\u00a7\u00ac\3\2\2\2\u00a8\u00a9\5"+
		"8\35\2\u00a9\u00aa\t\5\2\2\u00aa\u00ac\3\2\2\2\u00ab\u00a5\3\2\2\2\u00ab"+
		"\u00a8\3\2\2\2\u00ac\21\3\2\2\2\u00ad\u00ae\t\5\2\2\u00ae\u00b2\5\16\b"+
		"\2\u00af\u00b0\t\5\2\2\u00b0\u00b2\58\35\2\u00b1\u00ad\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b2\23\3\2\2\2\u00b3\u00b4\7\67\2\2\u00b4\u00b5\7\26\2\2\u00b5"+
		"\u00b6\5N(\2\u00b6\u00b7\7\3\2\2\u00b7\u00b8\5,\27\2\u00b8\u00b9\7\27"+
		"\2\2\u00b9\u00bf\3\2\2\2\u00ba\u00bb\5N(\2\u00bb\u00bc\7\3\2\2\u00bc\u00bd"+
		"\5,\27\2\u00bd\u00bf\3\2\2\2\u00be\u00b3\3\2\2\2\u00be\u00ba\3\2\2\2\u00bf"+
		"\25\3\2\2\2\u00c0\u00c4\5$\23\2\u00c1\u00c4\5 \21\2\u00c2\u00c4\5\"\22"+
		"\2\u00c3\u00c0\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\27"+
		"\3\2\2\2\u00c5\u00c6\5\f\7\2\u00c6\u00c7\7\32\2\2\u00c7\u00c8\5\f\7\2"+
		"\u00c8\u00cb\3\2\2\2\u00c9\u00cb\5\24\13\2\u00ca\u00c5\3\2\2\2\u00ca\u00c9"+
		"\3\2\2\2\u00cb\31\3\2\2\2\u00cc\u00cd\5N(\2\u00cd\u00ce\7\32\2\2\u00ce"+
		"\u00cf\5\f\7\2\u00cf\u00d6\3\2\2\2\u00d0\u00d1\5\f\7\2\u00d1\u00d2\7\32"+
		"\2\2\u00d2\u00d3\5N(\2\u00d3\u00d6\3\2\2\2\u00d4\u00d6\5\24\13\2\u00d5"+
		"\u00cc\3\2\2\2\u00d5\u00d0\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\33\3\2\2"+
		"\2\u00d7\u00d8\7\63\2\2\u00d8\u00d9\5,\27\2\u00d9\u00da\7\26\2\2\u00da"+
		"\u00dd\5\60\31\2\u00db\u00dc\7\35\2\2\u00dc\u00de\5\60\31\2\u00dd\u00db"+
		"\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\7\27\2\2"+
		"\u00e0\35\3\2\2\2\u00e1\u00e2\7\26\2\2\u00e2\u00e3\5\30\r\2\u00e3\u00e4"+
		"\7\27\2\2\u00e4\u00e5\7\64\2\2\u00e5\u00e6\5\f\7\2\u00e6\u00e7\7\65\2"+
		"\2\u00e7\u00e8\5\f\7\2\u00e8\37\3\2\2\2\u00e9\u00ea\7.\2\2\u00ea\u00eb"+
		"\7\26\2\2\u00eb\u00ec\5\62\32\2\u00ec\u00ed\5\32\16\2\u00ed\u00ee\7\31"+
		"\2\2\u00ee\u00ef\5N(\2\u00ef\u00f0\t\6\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00f2"+
		"\7\27\2\2\u00f2\u00f4\78\2\2\u00f3\u00f5\5\4\3\2\u00f4\u00f3\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\7:\2\2\u00f7!\3\2\2\2\u00f8"+
		"\u00f9\7/\2\2\u00f9\u00fa\7\26\2\2\u00fa\u00fb\5\32\16\2\u00fb\u00fc\7"+
		"\27\2\2\u00fc\u00fe\78\2\2\u00fd\u00ff\5\4\3\2\u00fe\u00fd\3\2\2\2\u00fe"+
		"\u00ff\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\7:\2\2\u0101#\3\2\2\2\u0102"+
		"\u0103\7*\2\2\u0103\u0104\7\26\2\2\u0104\u0105\5\30\r\2\u0105\u0106\7"+
		"\27\2\2\u0106\u0108\78\2\2\u0107\u0109\5\4\3\2\u0108\u0107\3\2\2\2\u0108"+
		"\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010e\7:\2\2\u010b\u010d\5&\24"+
		"\2\u010c\u010b\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0113\5(\25\2\u0112"+
		"\u0111\3\2\2\2\u0112\u0113\3\2\2\2\u0113%\3\2\2\2\u0114\u0115\7-\2\2\u0115"+
		"\u0116\7\26\2\2\u0116\u0117\5\30\r\2\u0117\u0118\7\27\2\2\u0118\u011a"+
		"\78\2\2\u0119\u011b\5\4\3\2\u011a\u0119\3\2\2\2\u011a\u011b\3\2\2\2\u011b"+
		"\u011c\3\2\2\2\u011c\u011d\7:\2\2\u011d\'\3\2\2\2\u011e\u011f\7,\2\2\u011f"+
		"\u0121\78\2\2\u0120\u0122\5\4\3\2\u0121\u0120\3\2\2\2\u0121\u0122\3\2"+
		"\2\2\u0122\u0123\3\2\2\2\u0123\u0124\7:\2\2\u0124)\3\2\2\2\u0125\u0128"+
		"\58\35\2\u0126\u0128\5\16\b\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2"+
		"\u0128\u0129\3\2\2\2\u0129\u012a\7\r\2\2\u012a\u012d\5\60\31\2\u012b\u012c"+
		"\7\35\2\2\u012c\u012e\5\60\31\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2"+
		"\2\u012e\u012f\3\2\2\2\u012f\u0130\7\17\2\2\u0130+\3\2\2\2\u0131\u0132"+
		"\t\7\2\2\u0132-\3\2\2\2\u0133\u0134\7\66\2\2\u0134\u0135\5\n\6\2\u0135"+
		"/\3\2\2\2\u0136\u0139\7\'\2\2\u0137\u0139\5N(\2\u0138\u0136\3\2\2\2\u0138"+
		"\u0137\3\2\2\2\u0139\61\3\2\2\2\u013a\u013b\7)\2\2\u013b\u013c\5N(\2\u013c"+
		"\u013d\7&\2\2\u013d\u013e\5\n\6\2\u013e\u014e\3\2\2\2\u013f\u0148\5N("+
		"\2\u0140\u0141\7\r\2\2\u0141\u0144\5\60\31\2\u0142\u0143\7\35\2\2\u0143"+
		"\u0145\5\60\31\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146\3"+
		"\2\2\2\u0146\u0147\7\17\2\2\u0147\u0149\3\2\2\2\u0148\u0140\3\2\2\2\u0148"+
		"\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014b\7&\2\2\u014b\u014c\5\n"+
		"\6\2\u014c\u014e\3\2\2\2\u014d\u013a\3\2\2\2\u014d\u013f\3\2\2\2\u014e"+
		"\63\3\2\2\2\u014f\u0151\7\22\2\2\u0150\u014f\3\2\2\2\u0150\u0151\3\2\2"+
		"\2\u0151\u0153\3\2\2\2\u0152\u0154\7\'\2\2\u0153\u0152\3\2\2\2\u0154\u0155"+
		"\3\2\2\2\u0155\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u015d\3\2\2\2\u0157"+
		"\u0159\7(\2\2\u0158\u015a\7\'\2\2\u0159\u0158\3\2\2\2\u015a\u015b\3\2"+
		"\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\3\2\2\2\u015d"+
		"\u0157\3\2\2\2\u015d\u015e\3\2\2\2\u015e\65\3\2\2\2\u015f\u0162\5\64\33"+
		"\2\u0160\u0161\7\30\2\2\u0161\u0163\5\64\33\2\u0162\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\67\3\2\2\2\u0164\u0165\5L\'\2\u0165\u0167\7\26\2"+
		"\2\u0166\u0168\5:\36\2\u0167\u0166\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0169"+
		"\3\2\2\2\u0169\u016a\7\27\2\2\u016a9\3\2\2\2\u016b\u0170\5\f\7\2\u016c"+
		"\u016d\7\35\2\2\u016d\u016f\5\f\7\2\u016e\u016c\3\2\2\2\u016f\u0172\3"+
		"\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171;\3\2\2\2\u0172\u0170"+
		"\3\2\2\2\u0173\u0174\7\7\2\2\u0174\u0175\5\n\6\2\u0175=\3\2\2\2\u0176"+
		"\u017b\5N(\2\u0177\u0178\7\35\2\2\u0178\u017a\5N(\2\u0179\u0177\3\2\2"+
		"\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c?"+
		"\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u017f\7\b\2\2\u017f\u0180\5L\'\2\u0180"+
		"\u0182\7\26\2\2\u0181\u0183\5> \2\u0182\u0181\3\2\2\2\u0182\u0183\3\2"+
		"\2\2\u0183\u0184\3\2\2\2\u0184\u0186\7\27\2\2\u0185\u0187\5B\"\2\u0186"+
		"\u0185\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u018a\78"+
		"\2\2\u0189\u018b\5\4\3\2\u018a\u0189\3\2\2\2\u018a\u018b\3\2\2\2\u018b"+
		"\u018c\3\2\2\2\u018c\u018d\7:\2\2\u018dA\3\2\2\2\u018e\u018f\7\20\2\2"+
		"\u018f\u0190\5,\27\2\u0190C\3\2\2\2\u0191\u0193\7\22\2\2\u0192\u0191\3"+
		"\2\2\2\u0192\u0193\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u019d\7\r\2\2\u0195"+
		"\u019a\5\f\7\2\u0196\u0197\7\35\2\2\u0197\u0199\5\f\7\2\u0198\u0196\3"+
		"\2\2\2\u0199\u019c\3\2\2\2\u019a\u0198\3\2\2\2\u019a\u019b\3\2\2\2\u019b"+
		"\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019d\u0195\3\2\2\2\u019d\u019e\3\2"+
		"\2\2\u019e\u019f\3\2\2\2\u019f\u01a0\7\17\2\2\u01a0E\3\2\2\2\u01a1\u01a2"+
		"\5H%\2\u01a2\u01a3\7\31\2\2\u01a3G\3\2\2\2\u01a4\u01a9\5\f\7\2\u01a5\u01a6"+
		"\7\35\2\2\u01a6\u01a8\5\f\7\2\u01a7\u01a5\3\2\2\2\u01a8\u01ab\3\2\2\2"+
		"\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aaI\3\2\2\2\u01ab\u01a9\3"+
		"\2\2\2\u01ac\u01ae\7\22\2\2\u01ad\u01ac\3\2\2\2\u01ad\u01ae\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01af\u01ba\7\r\2\2\u01b0\u01b4\5F$\2\u01b1\u01b3\5F$\2"+
		"\u01b2\u01b1\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5"+
		"\3\2\2\2\u01b5\u01b7\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01b8\5H%\2\u01b8"+
		"\u01bb\3\2\2\2\u01b9\u01bb\5H%\2\u01ba\u01b0\3\2\2\2\u01ba\u01b9\3\2\2"+
		"\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd\7\17\2\2\u01bdK\3\2\2\2\u01be\u01c2"+
		"\t\b\2\2\u01bf\u01c1\t\t\2\2\u01c0\u01bf\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2"+
		"\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3M\3\2\2\2\u01c4\u01c2\3\2\2\2"+
		"\u01c5\u01c7\7\22\2\2\u01c6\u01c5\3\2\2\2\u01c6\u01c7\3\2\2\2\u01c7\u01c8"+
		"\3\2\2\2\u01c8\u01cc\t\b\2\2\u01c9\u01cb\t\n\2\2\u01ca\u01c9\3\2\2\2\u01cb"+
		"\u01ce\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cd\3\2\2\2\u01cdO\3\2\2\2"+
		"\u01ce\u01cc\3\2\2\2\65SW_gis\u0086\u009a\u009c\u00a3\u00ab\u00b1\u00be"+
		"\u00c3\u00ca\u00d5\u00dd\u00f4\u00fe\u0108\u010e\u0112\u011a\u0121\u0127"+
		"\u012d\u0138\u0144\u0148\u014d\u0150\u0155\u015b\u015d\u0162\u0167\u0170"+
		"\u017b\u0182\u0186\u018a\u0192\u019a\u019d\u01a9\u01ad\u01b4\u01ba\u01c2"+
		"\u01c6\u01cc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}