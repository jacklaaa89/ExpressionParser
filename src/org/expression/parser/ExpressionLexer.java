// Generated from /Users/jacktimblin/ExpressionParser/Expression.g4 by ANTLR 4.5.1

package org.expression.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExpressionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LBRACE=1, UNDERSCORE=2, RBRACE=3, PLUS=4, MINUS=5, TIMES=6, DIV=7, POW=8, 
		LPAREN=9, RPAREN=10, E=11, SEMI_COLON=12, LOGICAL=13, OPERATOR=14, SYMBOL=15, 
		COMMA=16, GT=17, LT=18, AND=19, OR=20, GTE=21, LTE=22, EQ=23, NEQ=24, 
		ASSIGN=25, DIGIT=26, POINT=27, VAR=28, LETTER=29, WS=30, MODULO=31, PRI=32, 
		COMMENT=33, LINE_COMMENT=34;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LBRACE", "UNDERSCORE", "RBRACE", "PLUS", "MINUS", "TIMES", "DIV", "POW", 
		"LPAREN", "RPAREN", "E", "SEMI_COLON", "LOGICAL", "OPERATOR", "SYMBOL", 
		"COMMA", "GT", "LT", "AND", "OR", "GTE", "LTE", "EQ", "NEQ", "ASSIGN", 
		"DIGIT", "POINT", "VAR", "LETTER", "WS", "MODULO", "PRI", "COMMENT", "LINE_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "'_'", "']'", "'+'", "'-'", "'*'", "'/'", "'^'", "'('", "')'", 
		"'e'", "';'", null, null, null, "','", "'>'", "'<'", "'&&'", "'||'", "'>='", 
		"'<='", "'=='", "'!='", "'='", null, "'.'", "'var'", null, null, "'%'", 
		"'print'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LBRACE", "UNDERSCORE", "RBRACE", "PLUS", "MINUS", "TIMES", "DIV", 
		"POW", "LPAREN", "RPAREN", "E", "SEMI_COLON", "LOGICAL", "OPERATOR", "SYMBOL", 
		"COMMA", "GT", "LT", "AND", "OR", "GTE", "LTE", "EQ", "NEQ", "ASSIGN", 
		"DIGIT", "POINT", "VAR", "LETTER", "WS", "MODULO", "PRI", "COMMENT", "LINE_COMMENT"
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


	public ExpressionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Expression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2$\u00c4\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\5\16h\n\16\3\17\3\17\5\17l\n\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\5\20v\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\36\5\36"+
		"\u009b\n\36\3\37\6\37\u009e\n\37\r\37\16\37\u009f\3\37\3\37\3 \3 \3!\3"+
		"!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\7\"\u00b0\n\"\f\"\16\"\u00b3\13\"\3\"\3"+
		"\"\3\"\3\"\3\"\3#\3#\3#\3#\7#\u00be\n#\f#\16#\u00c1\13#\3#\3#\3\u00b1"+
		"\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$\3\2\5\4\2C\\c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u00d5"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2"+
		"\2\5I\3\2\2\2\7K\3\2\2\2\tM\3\2\2\2\13O\3\2\2\2\rQ\3\2\2\2\17S\3\2\2\2"+
		"\21U\3\2\2\2\23W\3\2\2\2\25Y\3\2\2\2\27[\3\2\2\2\31]\3\2\2\2\33g\3\2\2"+
		"\2\35i\3\2\2\2\37u\3\2\2\2!w\3\2\2\2#y\3\2\2\2%{\3\2\2\2\'}\3\2\2\2)\u0080"+
		"\3\2\2\2+\u0083\3\2\2\2-\u0086\3\2\2\2/\u0089\3\2\2\2\61\u008c\3\2\2\2"+
		"\63\u008f\3\2\2\2\65\u0091\3\2\2\2\67\u0093\3\2\2\29\u0095\3\2\2\2;\u009a"+
		"\3\2\2\2=\u009d\3\2\2\2?\u00a3\3\2\2\2A\u00a5\3\2\2\2C\u00ab\3\2\2\2E"+
		"\u00b9\3\2\2\2GH\7]\2\2H\4\3\2\2\2IJ\7a\2\2J\6\3\2\2\2KL\7_\2\2L\b\3\2"+
		"\2\2MN\7-\2\2N\n\3\2\2\2OP\7/\2\2P\f\3\2\2\2QR\7,\2\2R\16\3\2\2\2ST\7"+
		"\61\2\2T\20\3\2\2\2UV\7`\2\2V\22\3\2\2\2WX\7*\2\2X\24\3\2\2\2YZ\7+\2\2"+
		"Z\26\3\2\2\2[\\\7g\2\2\\\30\3\2\2\2]^\7=\2\2^\32\3\2\2\2_h\5\'\24\2`h"+
		"\5)\25\2ah\5+\26\2bh\5-\27\2ch\5/\30\2dh\5\61\31\2eh\5#\22\2fh\5%\23\2"+
		"g_\3\2\2\2g`\3\2\2\2ga\3\2\2\2gb\3\2\2\2gc\3\2\2\2gd\3\2\2\2ge\3\2\2\2"+
		"gf\3\2\2\2h\34\3\2\2\2ik\5\37\20\2jl\5\37\20\2kj\3\2\2\2kl\3\2\2\2l\36"+
		"\3\2\2\2mv\5\t\5\2nv\5\13\6\2ov\5\17\b\2pv\5? \2qv\5\21\t\2rv\5\r\7\2"+
		"sv\5#\22\2tv\5%\23\2um\3\2\2\2un\3\2\2\2uo\3\2\2\2up\3\2\2\2uq\3\2\2\2"+
		"ur\3\2\2\2us\3\2\2\2ut\3\2\2\2v \3\2\2\2wx\7.\2\2x\"\3\2\2\2yz\7@\2\2"+
		"z$\3\2\2\2{|\7>\2\2|&\3\2\2\2}~\7(\2\2~\177\7(\2\2\177(\3\2\2\2\u0080"+
		"\u0081\7~\2\2\u0081\u0082\7~\2\2\u0082*\3\2\2\2\u0083\u0084\7@\2\2\u0084"+
		"\u0085\7?\2\2\u0085,\3\2\2\2\u0086\u0087\7>\2\2\u0087\u0088\7?\2\2\u0088"+
		".\3\2\2\2\u0089\u008a\7?\2\2\u008a\u008b\7?\2\2\u008b\60\3\2\2\2\u008c"+
		"\u008d\7#\2\2\u008d\u008e\7?\2\2\u008e\62\3\2\2\2\u008f\u0090\7?\2\2\u0090"+
		"\64\3\2\2\2\u0091\u0092\4\62;\2\u0092\66\3\2\2\2\u0093\u0094\7\60\2\2"+
		"\u00948\3\2\2\2\u0095\u0096\7x\2\2\u0096\u0097\7c\2\2\u0097\u0098\7t\2"+
		"\2\u0098:\3\2\2\2\u0099\u009b\t\2\2\2\u009a\u0099\3\2\2\2\u009b<\3\2\2"+
		"\2\u009c\u009e\t\3\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\b\37\2\2"+
		"\u00a2>\3\2\2\2\u00a3\u00a4\7\'\2\2\u00a4@\3\2\2\2\u00a5\u00a6\7r\2\2"+
		"\u00a6\u00a7\7t\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa"+
		"\7v\2\2\u00aaB\3\2\2\2\u00ab\u00ac\7\61\2\2\u00ac\u00ad\7,\2\2\u00ad\u00b1"+
		"\3\2\2\2\u00ae\u00b0\13\2\2\2\u00af\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2"+
		"\u00b1\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1"+
		"\3\2\2\2\u00b4\u00b5\7,\2\2\u00b5\u00b6\7\61\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\u00b8\b\"\2\2\u00b8D\3\2\2\2\u00b9\u00ba\7\61\2\2\u00ba\u00bb\7\61\2"+
		"\2\u00bb\u00bf\3\2\2\2\u00bc\u00be\n\4\2\2\u00bd\u00bc\3\2\2\2\u00be\u00c1"+
		"\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c2\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c2\u00c3\b#\2\2\u00c3F\3\2\2\2\n\2gku\u009a\u009f\u00b1"+
		"\u00bf\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}