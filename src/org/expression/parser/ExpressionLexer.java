// Generated from Expression.g4 by ANTLR 4.5.1

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
		INSTANCE_OF=1, SCALAR_TYPE=2, MATRIX_TYPE=3, ARRAY_TYPE=4, RETURN=5, FUNCTION=6, 
		INCREMENT=7, THROWS=8, EXCEPTION=9, DECREMENT=10, LBRACE=11, UNDERSCORE=12, 
		RBRACE=13, RIGHT_ARROW=14, PLUS=15, MINUS=16, TIMES=17, DIV=18, POW=19, 
		LPAREN=20, RPAREN=21, E=22, SEMI_COLON=23, LOGICAL=24, OPERATOR=25, SYMBOL=26, 
		COMMA=27, GT=28, LT=29, AND=30, OR=31, GTE=32, LTE=33, EQ=34, NEQ=35, 
		ASSIGN=36, DIGIT=37, POINT=38, VAR=39, IF=40, IMPORT=41, ELSE=42, ELSEIF=43, 
		FOR=44, WHILE=45, LETTER=46, WS=47, MODULO=48, NEW=49, QMARK=50, COLON=51, 
		PRI=52, NOT=53, BLOCKLEFT=54, QUOTE=55, BLOCKRIGHT=56, COMMENT=57, LINE_COMMENT=58;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INSTANCE_OF", "SCALAR_TYPE", "MATRIX_TYPE", "ARRAY_TYPE", "RETURN", "FUNCTION", 
		"INCREMENT", "THROWS", "EXCEPTION", "DECREMENT", "LBRACE", "UNDERSCORE", 
		"RBRACE", "RIGHT_ARROW", "PLUS", "MINUS", "TIMES", "DIV", "POW", "LPAREN", 
		"RPAREN", "E", "SEMI_COLON", "LOGICAL", "OPERATOR", "SYMBOL", "COMMA", 
		"GT", "LT", "AND", "OR", "GTE", "LTE", "EQ", "NEQ", "ASSIGN", "DIGIT", 
		"POINT", "VAR", "IF", "IMPORT", "ELSE", "ELSEIF", "FOR", "WHILE", "LETTER", 
		"WS", "MODULO", "NEW", "QMARK", "COLON", "PRI", "NOT", "BLOCKLEFT", "QUOTE", 
		"BLOCKRIGHT", "COMMENT", "LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2<\u016e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\5\31\u00e2\n\31\3\32\3\32\5\32\u00e6\n\32"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\5\33\u00f0\n\33\3\34\3\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#"+
		"\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3*\3*\3"+
		"*\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3"+
		"/\5/\u0135\n/\3\60\6\60\u0138\n\60\r\60\16\60\u0139\3\60\3\60\3\61\3\61"+
		"\3\62\3\62\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3:\3:\7:\u015a\n:\f:\16:\u015d"+
		"\13:\3:\3:\3:\3:\3:\3;\3;\3;\3;\7;\u0168\n;\f;\16;\u016b\13;\3;\3;\3\u015b"+
		"\2<\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67"+
		"m8o9q:s;u<\3\2\5\4\2C\\c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u017f\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2"+
		"\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o"+
		"\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\3w\3\2\2\2\5\u0082\3\2\2\2\7"+
		"\u0089\3\2\2\2\t\u0090\3\2\2\2\13\u0097\3\2\2\2\r\u009e\3\2\2\2\17\u00a7"+
		"\3\2\2\2\21\u00aa\3\2\2\2\23\u00b1\3\2\2\2\25\u00bb\3\2\2\2\27\u00be\3"+
		"\2\2\2\31\u00c0\3\2\2\2\33\u00c2\3\2\2\2\35\u00c4\3\2\2\2\37\u00c7\3\2"+
		"\2\2!\u00c9\3\2\2\2#\u00cb\3\2\2\2%\u00cd\3\2\2\2\'\u00cf\3\2\2\2)\u00d1"+
		"\3\2\2\2+\u00d3\3\2\2\2-\u00d5\3\2\2\2/\u00d7\3\2\2\2\61\u00e1\3\2\2\2"+
		"\63\u00e3\3\2\2\2\65\u00ef\3\2\2\2\67\u00f1\3\2\2\29\u00f3\3\2\2\2;\u00f5"+
		"\3\2\2\2=\u00f7\3\2\2\2?\u00fa\3\2\2\2A\u00fd\3\2\2\2C\u0100\3\2\2\2E"+
		"\u0103\3\2\2\2G\u0106\3\2\2\2I\u0109\3\2\2\2K\u010b\3\2\2\2M\u010d\3\2"+
		"\2\2O\u010f\3\2\2\2Q\u0113\3\2\2\2S\u0116\3\2\2\2U\u011d\3\2\2\2W\u0122"+
		"\3\2\2\2Y\u0129\3\2\2\2[\u012d\3\2\2\2]\u0134\3\2\2\2_\u0137\3\2\2\2a"+
		"\u013d\3\2\2\2c\u013f\3\2\2\2e\u0143\3\2\2\2g\u0145\3\2\2\2i\u0147\3\2"+
		"\2\2k\u014d\3\2\2\2m\u014f\3\2\2\2o\u0151\3\2\2\2q\u0153\3\2\2\2s\u0155"+
		"\3\2\2\2u\u0163\3\2\2\2wx\7k\2\2xy\7p\2\2yz\7u\2\2z{\7v\2\2{|\7c\2\2|"+
		"}\7p\2\2}~\7e\2\2~\177\7g\2\2\177\u0080\7q\2\2\u0080\u0081\7h\2\2\u0081"+
		"\4\3\2\2\2\u0082\u0083\7U\2\2\u0083\u0084\7e\2\2\u0084\u0085\7c\2\2\u0085"+
		"\u0086\7n\2\2\u0086\u0087\7c\2\2\u0087\u0088\7t\2\2\u0088\6\3\2\2\2\u0089"+
		"\u008a\7O\2\2\u008a\u008b\7c\2\2\u008b\u008c\7v\2\2\u008c\u008d\7t\2\2"+
		"\u008d\u008e\7k\2\2\u008e\u008f\7z\2\2\u008f\b\3\2\2\2\u0090\u0091\7X"+
		"\2\2\u0091\u0092\7g\2\2\u0092\u0093\7e\2\2\u0093\u0094\7v\2\2\u0094\u0095"+
		"\7q\2\2\u0095\u0096\7t\2\2\u0096\n\3\2\2\2\u0097\u0098\7t\2\2\u0098\u0099"+
		"\7g\2\2\u0099\u009a\7v\2\2\u009a\u009b\7w\2\2\u009b\u009c\7t\2\2\u009c"+
		"\u009d\7p\2\2\u009d\f\3\2\2\2\u009e\u009f\7h\2\2\u009f\u00a0\7w\2\2\u00a0"+
		"\u00a1\7p\2\2\u00a1\u00a2\7e\2\2\u00a2\u00a3\7v\2\2\u00a3\u00a4\7k\2\2"+
		"\u00a4\u00a5\7q\2\2\u00a5\u00a6\7p\2\2\u00a6\16\3\2\2\2\u00a7\u00a8\5"+
		"\37\20\2\u00a8\u00a9\5\37\20\2\u00a9\20\3\2\2\2\u00aa\u00ab\7v\2\2\u00ab"+
		"\u00ac\7j\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7y\2\2"+
		"\u00af\u00b0\7u\2\2\u00b0\22\3\2\2\2\u00b1\u00b2\7g\2\2\u00b2\u00b3\7"+
		"z\2\2\u00b3\u00b4\7e\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7r\2\2\u00b6\u00b7"+
		"\7v\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7q\2\2\u00b9\u00ba\7p\2\2\u00ba"+
		"\24\3\2\2\2\u00bb\u00bc\5!\21\2\u00bc\u00bd\5!\21\2\u00bd\26\3\2\2\2\u00be"+
		"\u00bf\7]\2\2\u00bf\30\3\2\2\2\u00c0\u00c1\7a\2\2\u00c1\32\3\2\2\2\u00c2"+
		"\u00c3\7_\2\2\u00c3\34\3\2\2\2\u00c4\u00c5\7/\2\2\u00c5\u00c6\7@\2\2\u00c6"+
		"\36\3\2\2\2\u00c7\u00c8\7-\2\2\u00c8 \3\2\2\2\u00c9\u00ca\7/\2\2\u00ca"+
		"\"\3\2\2\2\u00cb\u00cc\7,\2\2\u00cc$\3\2\2\2\u00cd\u00ce\7\61\2\2\u00ce"+
		"&\3\2\2\2\u00cf\u00d0\7`\2\2\u00d0(\3\2\2\2\u00d1\u00d2\7*\2\2\u00d2*"+
		"\3\2\2\2\u00d3\u00d4\7+\2\2\u00d4,\3\2\2\2\u00d5\u00d6\7g\2\2\u00d6.\3"+
		"\2\2\2\u00d7\u00d8\7=\2\2\u00d8\60\3\2\2\2\u00d9\u00e2\5=\37\2\u00da\u00e2"+
		"\5? \2\u00db\u00e2\5A!\2\u00dc\u00e2\5C\"\2\u00dd\u00e2\5E#\2\u00de\u00e2"+
		"\5G$\2\u00df\u00e2\59\35\2\u00e0\u00e2\5;\36\2\u00e1\u00d9\3\2\2\2\u00e1"+
		"\u00da\3\2\2\2\u00e1\u00db\3\2\2\2\u00e1\u00dc\3\2\2\2\u00e1\u00dd\3\2"+
		"\2\2\u00e1\u00de\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e0\3\2\2\2\u00e2"+
		"\62\3\2\2\2\u00e3\u00e5\5\65\33\2\u00e4\u00e6\5\65\33\2\u00e5\u00e4\3"+
		"\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\64\3\2\2\2\u00e7\u00f0\5\37\20\2\u00e8"+
		"\u00f0\5!\21\2\u00e9\u00f0\5%\23\2\u00ea\u00f0\5a\61\2\u00eb\u00f0\5\'"+
		"\24\2\u00ec\u00f0\5#\22\2\u00ed\u00f0\59\35\2\u00ee\u00f0\5;\36\2\u00ef"+
		"\u00e7\3\2\2\2\u00ef\u00e8\3\2\2\2\u00ef\u00e9\3\2\2\2\u00ef\u00ea\3\2"+
		"\2\2\u00ef\u00eb\3\2\2\2\u00ef\u00ec\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef"+
		"\u00ee\3\2\2\2\u00f0\66\3\2\2\2\u00f1\u00f2\7.\2\2\u00f28\3\2\2\2\u00f3"+
		"\u00f4\7@\2\2\u00f4:\3\2\2\2\u00f5\u00f6\7>\2\2\u00f6<\3\2\2\2\u00f7\u00f8"+
		"\7(\2\2\u00f8\u00f9\7(\2\2\u00f9>\3\2\2\2\u00fa\u00fb\7~\2\2\u00fb\u00fc"+
		"\7~\2\2\u00fc@\3\2\2\2\u00fd\u00fe\7@\2\2\u00fe\u00ff\7?\2\2\u00ffB\3"+
		"\2\2\2\u0100\u0101\7>\2\2\u0101\u0102\7?\2\2\u0102D\3\2\2\2\u0103\u0104"+
		"\7?\2\2\u0104\u0105\7?\2\2\u0105F\3\2\2\2\u0106\u0107\7#\2\2\u0107\u0108"+
		"\7?\2\2\u0108H\3\2\2\2\u0109\u010a\7?\2\2\u010aJ\3\2\2\2\u010b\u010c\4"+
		"\62;\2\u010cL\3\2\2\2\u010d\u010e\7\60\2\2\u010eN\3\2\2\2\u010f\u0110"+
		"\7x\2\2\u0110\u0111\7c\2\2\u0111\u0112\7t\2\2\u0112P\3\2\2\2\u0113\u0114"+
		"\7k\2\2\u0114\u0115\7h\2\2\u0115R\3\2\2\2\u0116\u0117\7k\2\2\u0117\u0118"+
		"\7o\2\2\u0118\u0119\7r\2\2\u0119\u011a\7q\2\2\u011a\u011b\7t\2\2\u011b"+
		"\u011c\7v\2\2\u011cT\3\2\2\2\u011d\u011e\7g\2\2\u011e\u011f\7n\2\2\u011f"+
		"\u0120\7u\2\2\u0120\u0121\7g\2\2\u0121V\3\2\2\2\u0122\u0123\7g\2\2\u0123"+
		"\u0124\7n\2\2\u0124\u0125\7u\2\2\u0125\u0126\7g\2\2\u0126\u0127\7k\2\2"+
		"\u0127\u0128\7h\2\2\u0128X\3\2\2\2\u0129\u012a\7h\2\2\u012a\u012b\7q\2"+
		"\2\u012b\u012c\7t\2\2\u012cZ\3\2\2\2\u012d\u012e\7y\2\2\u012e\u012f\7"+
		"j\2\2\u012f\u0130\7k\2\2\u0130\u0131\7n\2\2\u0131\u0132\7g\2\2\u0132\\"+
		"\3\2\2\2\u0133\u0135\t\2\2\2\u0134\u0133\3\2\2\2\u0135^\3\2\2\2\u0136"+
		"\u0138\t\3\2\2\u0137\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u0137\3\2"+
		"\2\2\u0139\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\b\60\2\2\u013c"+
		"`\3\2\2\2\u013d\u013e\7\'\2\2\u013eb\3\2\2\2\u013f\u0140\7p\2\2\u0140"+
		"\u0141\7g\2\2\u0141\u0142\7y\2\2\u0142d\3\2\2\2\u0143\u0144\7A\2\2\u0144"+
		"f\3\2\2\2\u0145\u0146\7<\2\2\u0146h\3\2\2\2\u0147\u0148\7r\2\2\u0148\u0149"+
		"\7t\2\2\u0149\u014a\7k\2\2\u014a\u014b\7p\2\2\u014b\u014c\7v\2\2\u014c"+
		"j\3\2\2\2\u014d\u014e\7#\2\2\u014el\3\2\2\2\u014f\u0150\7}\2\2\u0150n"+
		"\3\2\2\2\u0151\u0152\7$\2\2\u0152p\3\2\2\2\u0153\u0154\7\177\2\2\u0154"+
		"r\3\2\2\2\u0155\u0156\7\61\2\2\u0156\u0157\7,\2\2\u0157\u015b\3\2\2\2"+
		"\u0158\u015a\13\2\2\2\u0159\u0158\3\2\2\2\u015a\u015d\3\2\2\2\u015b\u015c"+
		"\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e"+
		"\u015f\7,\2\2\u015f\u0160\7\61\2\2\u0160\u0161\3\2\2\2\u0161\u0162\b:"+
		"\2\2\u0162t\3\2\2\2\u0163\u0164\7\61\2\2\u0164\u0165\7\61\2\2\u0165\u0169"+
		"\3\2\2\2\u0166\u0168\n\4\2\2\u0167\u0166\3\2\2\2\u0168\u016b\3\2\2\2\u0169"+
		"\u0167\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016c\3\2\2\2\u016b\u0169\3\2"+
		"\2\2\u016c\u016d\b;\2\2\u016dv\3\2\2\2\n\2\u00e1\u00e5\u00ef\u0134\u0139"+
		"\u015b\u0169\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}