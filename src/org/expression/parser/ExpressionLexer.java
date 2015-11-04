// Generated from ExpressionParser/Expression.g4 by ANTLR 4.5.1

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
		RBRACE=13, PLUS=14, MINUS=15, TIMES=16, DIV=17, POW=18, LPAREN=19, RPAREN=20, 
		E=21, SEMI_COLON=22, LOGICAL=23, OPERATOR=24, SYMBOL=25, COMMA=26, GT=27, 
		LT=28, AND=29, OR=30, GTE=31, LTE=32, EQ=33, NEQ=34, ASSIGN=35, DIGIT=36, 
		POINT=37, VAR=38, IF=39, IMPORT=40, ELSE=41, ELSEIF=42, FOR=43, WHILE=44, 
		LETTER=45, WS=46, MODULO=47, NEW=48, QMARK=49, COLON=50, PRI=51, NOT=52, 
		BLOCKLEFT=53, QUOTE=54, BLOCKRIGHT=55, COMMENT=56, LINE_COMMENT=57;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INSTANCE_OF", "SCALAR_TYPE", "MATRIX_TYPE", "ARRAY_TYPE", "RETURN", "FUNCTION", 
		"INCREMENT", "THROWS", "EXCEPTION", "DECREMENT", "LBRACE", "UNDERSCORE", 
		"RBRACE", "PLUS", "MINUS", "TIMES", "DIV", "POW", "LPAREN", "RPAREN", 
		"E", "SEMI_COLON", "LOGICAL", "OPERATOR", "SYMBOL", "COMMA", "GT", "LT", 
		"AND", "OR", "GTE", "LTE", "EQ", "NEQ", "ASSIGN", "DIGIT", "POINT", "VAR", 
		"IF", "IMPORT", "ELSE", "ELSEIF", "FOR", "WHILE", "LETTER", "WS", "MODULO", 
		"NEW", "QMARK", "COLON", "PRI", "NOT", "BLOCKLEFT", "QUOTE", "BLOCKRIGHT", 
		"COMMENT", "LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2;\u0169\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u00dd\n\30\3\31\3\31\5\31\u00e1\n\31\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\5\32\u00eb\n\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36"+
		"\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3"+
		"$\3%\3%\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3"+
		"*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\5.\u0130\n"+
		".\3/\6/\u0133\n/\r/\16/\u0134\3/\3/\3\60\3\60\3\61\3\61\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\65\3\65\3\66\3\66\3\67"+
		"\3\67\38\38\39\39\39\39\79\u0155\n9\f9\169\u0158\139\39\39\39\39\39\3"+
		":\3:\3:\3:\7:\u0163\n:\f:\16:\u0166\13:\3:\3:\3\u0156\2;\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;\3\2\5\4"+
		"\2C\\c|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\u017a\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2"+
		"\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2"+
		"\2s\3\2\2\2\3u\3\2\2\2\5\u0080\3\2\2\2\7\u0087\3\2\2\2\t\u008e\3\2\2\2"+
		"\13\u0095\3\2\2\2\r\u009c\3\2\2\2\17\u00a5\3\2\2\2\21\u00a8\3\2\2\2\23"+
		"\u00af\3\2\2\2\25\u00b9\3\2\2\2\27\u00bc\3\2\2\2\31\u00be\3\2\2\2\33\u00c0"+
		"\3\2\2\2\35\u00c2\3\2\2\2\37\u00c4\3\2\2\2!\u00c6\3\2\2\2#\u00c8\3\2\2"+
		"\2%\u00ca\3\2\2\2\'\u00cc\3\2\2\2)\u00ce\3\2\2\2+\u00d0\3\2\2\2-\u00d2"+
		"\3\2\2\2/\u00dc\3\2\2\2\61\u00de\3\2\2\2\63\u00ea\3\2\2\2\65\u00ec\3\2"+
		"\2\2\67\u00ee\3\2\2\29\u00f0\3\2\2\2;\u00f2\3\2\2\2=\u00f5\3\2\2\2?\u00f8"+
		"\3\2\2\2A\u00fb\3\2\2\2C\u00fe\3\2\2\2E\u0101\3\2\2\2G\u0104\3\2\2\2I"+
		"\u0106\3\2\2\2K\u0108\3\2\2\2M\u010a\3\2\2\2O\u010e\3\2\2\2Q\u0111\3\2"+
		"\2\2S\u0118\3\2\2\2U\u011d\3\2\2\2W\u0124\3\2\2\2Y\u0128\3\2\2\2[\u012f"+
		"\3\2\2\2]\u0132\3\2\2\2_\u0138\3\2\2\2a\u013a\3\2\2\2c\u013e\3\2\2\2e"+
		"\u0140\3\2\2\2g\u0142\3\2\2\2i\u0148\3\2\2\2k\u014a\3\2\2\2m\u014c\3\2"+
		"\2\2o\u014e\3\2\2\2q\u0150\3\2\2\2s\u015e\3\2\2\2uv\7k\2\2vw\7p\2\2wx"+
		"\7u\2\2xy\7v\2\2yz\7c\2\2z{\7p\2\2{|\7e\2\2|}\7g\2\2}~\7q\2\2~\177\7h"+
		"\2\2\177\4\3\2\2\2\u0080\u0081\7U\2\2\u0081\u0082\7e\2\2\u0082\u0083\7"+
		"c\2\2\u0083\u0084\7n\2\2\u0084\u0085\7c\2\2\u0085\u0086\7t\2\2\u0086\6"+
		"\3\2\2\2\u0087\u0088\7O\2\2\u0088\u0089\7c\2\2\u0089\u008a\7v\2\2\u008a"+
		"\u008b\7t\2\2\u008b\u008c\7k\2\2\u008c\u008d\7z\2\2\u008d\b\3\2\2\2\u008e"+
		"\u008f\7X\2\2\u008f\u0090\7g\2\2\u0090\u0091\7e\2\2\u0091\u0092\7v\2\2"+
		"\u0092\u0093\7q\2\2\u0093\u0094\7t\2\2\u0094\n\3\2\2\2\u0095\u0096\7t"+
		"\2\2\u0096\u0097\7g\2\2\u0097\u0098\7v\2\2\u0098\u0099\7w\2\2\u0099\u009a"+
		"\7t\2\2\u009a\u009b\7p\2\2\u009b\f\3\2\2\2\u009c\u009d\7h\2\2\u009d\u009e"+
		"\7w\2\2\u009e\u009f\7p\2\2\u009f\u00a0\7e\2\2\u00a0\u00a1\7v\2\2\u00a1"+
		"\u00a2\7k\2\2\u00a2\u00a3\7q\2\2\u00a3\u00a4\7p\2\2\u00a4\16\3\2\2\2\u00a5"+
		"\u00a6\5\35\17\2\u00a6\u00a7\5\35\17\2\u00a7\20\3\2\2\2\u00a8\u00a9\7"+
		"v\2\2\u00a9\u00aa\7j\2\2\u00aa\u00ab\7t\2\2\u00ab\u00ac\7q\2\2\u00ac\u00ad"+
		"\7y\2\2\u00ad\u00ae\7u\2\2\u00ae\22\3\2\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1"+
		"\7z\2\2\u00b1\u00b2\7e\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7r\2\2\u00b4"+
		"\u00b5\7v\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7q\2\2\u00b7\u00b8\7p\2\2"+
		"\u00b8\24\3\2\2\2\u00b9\u00ba\5\37\20\2\u00ba\u00bb\5\37\20\2\u00bb\26"+
		"\3\2\2\2\u00bc\u00bd\7]\2\2\u00bd\30\3\2\2\2\u00be\u00bf\7a\2\2\u00bf"+
		"\32\3\2\2\2\u00c0\u00c1\7_\2\2\u00c1\34\3\2\2\2\u00c2\u00c3\7-\2\2\u00c3"+
		"\36\3\2\2\2\u00c4\u00c5\7/\2\2\u00c5 \3\2\2\2\u00c6\u00c7\7,\2\2\u00c7"+
		"\"\3\2\2\2\u00c8\u00c9\7\61\2\2\u00c9$\3\2\2\2\u00ca\u00cb\7`\2\2\u00cb"+
		"&\3\2\2\2\u00cc\u00cd\7*\2\2\u00cd(\3\2\2\2\u00ce\u00cf\7+\2\2\u00cf*"+
		"\3\2\2\2\u00d0\u00d1\7g\2\2\u00d1,\3\2\2\2\u00d2\u00d3\7=\2\2\u00d3.\3"+
		"\2\2\2\u00d4\u00dd\5;\36\2\u00d5\u00dd\5=\37\2\u00d6\u00dd\5? \2\u00d7"+
		"\u00dd\5A!\2\u00d8\u00dd\5C\"\2\u00d9\u00dd\5E#\2\u00da\u00dd\5\67\34"+
		"\2\u00db\u00dd\59\35\2\u00dc\u00d4\3\2\2\2\u00dc\u00d5\3\2\2\2\u00dc\u00d6"+
		"\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00d9\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\60\3\2\2\2\u00de\u00e0\5\63\32"+
		"\2\u00df\u00e1\5\63\32\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\62\3\2\2\2\u00e2\u00eb\5\35\17\2\u00e3\u00eb\5\37\20\2\u00e4\u00eb\5"+
		"#\22\2\u00e5\u00eb\5_\60\2\u00e6\u00eb\5%\23\2\u00e7\u00eb\5!\21\2\u00e8"+
		"\u00eb\5\67\34\2\u00e9\u00eb\59\35\2\u00ea\u00e2\3\2\2\2\u00ea\u00e3\3"+
		"\2\2\2\u00ea\u00e4\3\2\2\2\u00ea\u00e5\3\2\2\2\u00ea\u00e6\3\2\2\2\u00ea"+
		"\u00e7\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\64\3\2\2"+
		"\2\u00ec\u00ed\7.\2\2\u00ed\66\3\2\2\2\u00ee\u00ef\7@\2\2\u00ef8\3\2\2"+
		"\2\u00f0\u00f1\7>\2\2\u00f1:\3\2\2\2\u00f2\u00f3\7(\2\2\u00f3\u00f4\7"+
		"(\2\2\u00f4<\3\2\2\2\u00f5\u00f6\7~\2\2\u00f6\u00f7\7~\2\2\u00f7>\3\2"+
		"\2\2\u00f8\u00f9\7@\2\2\u00f9\u00fa\7?\2\2\u00fa@\3\2\2\2\u00fb\u00fc"+
		"\7>\2\2\u00fc\u00fd\7?\2\2\u00fdB\3\2\2\2\u00fe\u00ff\7?\2\2\u00ff\u0100"+
		"\7?\2\2\u0100D\3\2\2\2\u0101\u0102\7#\2\2\u0102\u0103\7?\2\2\u0103F\3"+
		"\2\2\2\u0104\u0105\7?\2\2\u0105H\3\2\2\2\u0106\u0107\4\62;\2\u0107J\3"+
		"\2\2\2\u0108\u0109\7\60\2\2\u0109L\3\2\2\2\u010a\u010b\7x\2\2\u010b\u010c"+
		"\7c\2\2\u010c\u010d\7t\2\2\u010dN\3\2\2\2\u010e\u010f\7k\2\2\u010f\u0110"+
		"\7h\2\2\u0110P\3\2\2\2\u0111\u0112\7k\2\2\u0112\u0113\7o\2\2\u0113\u0114"+
		"\7r\2\2\u0114\u0115\7q\2\2\u0115\u0116\7t\2\2\u0116\u0117\7v\2\2\u0117"+
		"R\3\2\2\2\u0118\u0119\7g\2\2\u0119\u011a\7n\2\2\u011a\u011b\7u\2\2\u011b"+
		"\u011c\7g\2\2\u011cT\3\2\2\2\u011d\u011e\7g\2\2\u011e\u011f\7n\2\2\u011f"+
		"\u0120\7u\2\2\u0120\u0121\7g\2\2\u0121\u0122\7k\2\2\u0122\u0123\7h\2\2"+
		"\u0123V\3\2\2\2\u0124\u0125\7h\2\2\u0125\u0126\7q\2\2\u0126\u0127\7t\2"+
		"\2\u0127X\3\2\2\2\u0128\u0129\7y\2\2\u0129\u012a\7j\2\2\u012a\u012b\7"+
		"k\2\2\u012b\u012c\7n\2\2\u012c\u012d\7g\2\2\u012dZ\3\2\2\2\u012e\u0130"+
		"\t\2\2\2\u012f\u012e\3\2\2\2\u0130\\\3\2\2\2\u0131\u0133\t\3\2\2\u0132"+
		"\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2"+
		"\2\2\u0135\u0136\3\2\2\2\u0136\u0137\b/\2\2\u0137^\3\2\2\2\u0138\u0139"+
		"\7\'\2\2\u0139`\3\2\2\2\u013a\u013b\7p\2\2\u013b\u013c\7g\2\2\u013c\u013d"+
		"\7y\2\2\u013db\3\2\2\2\u013e\u013f\7A\2\2\u013fd\3\2\2\2\u0140\u0141\7"+
		"<\2\2\u0141f\3\2\2\2\u0142\u0143\7r\2\2\u0143\u0144\7t\2\2\u0144\u0145"+
		"\7k\2\2\u0145\u0146\7p\2\2\u0146\u0147\7v\2\2\u0147h\3\2\2\2\u0148\u0149"+
		"\7#\2\2\u0149j\3\2\2\2\u014a\u014b\7}\2\2\u014bl\3\2\2\2\u014c\u014d\7"+
		"$\2\2\u014dn\3\2\2\2\u014e\u014f\7\177\2\2\u014fp\3\2\2\2\u0150\u0151"+
		"\7\61\2\2\u0151\u0152\7,\2\2\u0152\u0156\3\2\2\2\u0153\u0155\13\2\2\2"+
		"\u0154\u0153\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0157\3\2\2\2\u0156\u0154"+
		"\3\2\2\2\u0157\u0159\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015a\7,\2\2\u015a"+
		"\u015b\7\61\2\2\u015b\u015c\3\2\2\2\u015c\u015d\b9\2\2\u015dr\3\2\2\2"+
		"\u015e\u015f\7\61\2\2\u015f\u0160\7\61\2\2\u0160\u0164\3\2\2\2\u0161\u0163"+
		"\n\4\2\2\u0162\u0161\3\2\2\2\u0163\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164"+
		"\u0165\3\2\2\2\u0165\u0167\3\2\2\2\u0166\u0164\3\2\2\2\u0167\u0168\b:"+
		"\2\2\u0168t\3\2\2\2\n\2\u00dc\u00e0\u00ea\u012f\u0134\u0156\u0164\3\2"+
		"\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}