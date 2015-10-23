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
		RETURN=1, FUNCTION=2, INCREMENT=3, DECREMENT=4, LBRACE=5, UNDERSCORE=6, 
		RBRACE=7, PLUS=8, MINUS=9, TIMES=10, DIV=11, POW=12, LPAREN=13, RPAREN=14, 
		E=15, SEMI_COLON=16, LOGICAL=17, OPERATOR=18, SYMBOL=19, COMMA=20, GT=21, 
		LT=22, AND=23, OR=24, GTE=25, LTE=26, EQ=27, NEQ=28, ASSIGN=29, DIGIT=30, 
		POINT=31, VAR=32, IF=33, ELSE=34, ELSEIF=35, FOR=36, WHILE=37, LETTER=38, 
		WS=39, MODULO=40, NEW=41, QMARK=42, COLON=43, PRI=44, BLOCKLEFT=45, BLOCKRIGHT=46, 
		COMMENT=47, LINE_COMMENT=48;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"RETURN", "FUNCTION", "INCREMENT", "DECREMENT", "LBRACE", "UNDERSCORE", 
		"RBRACE", "PLUS", "MINUS", "TIMES", "DIV", "POW", "LPAREN", "RPAREN", 
		"E", "SEMI_COLON", "LOGICAL", "OPERATOR", "SYMBOL", "COMMA", "GT", "LT", 
		"AND", "OR", "GTE", "LTE", "EQ", "NEQ", "ASSIGN", "DIGIT", "POINT", "VAR", 
		"IF", "ELSE", "ELSEIF", "FOR", "WHILE", "LETTER", "WS", "MODULO", "NEW", 
		"QMARK", "COLON", "PRI", "BLOCKLEFT", "BLOCKRIGHT", "COMMENT", "LINE_COMMENT"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\62\u011b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u009a\n\22\3\23\3\23\5\23\u009e\n\23\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\5\24\u00a8\n\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3#\3#\3#"+
		"\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3\'\5\'\u00e6"+
		"\n\'\3(\6(\u00e9\n(\r(\16(\u00ea\3(\3(\3)\3)\3*\3*\3*\3*\3+\3+\3,\3,\3"+
		"-\3-\3-\3-\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\7\60\u0107\n\60\f\60"+
		"\16\60\u010a\13\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u0115"+
		"\n\61\f\61\16\61\u0118\13\61\3\61\3\61\3\u0108\2\62\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\61a\62\3\2\5\4\2C\\c|\5\2\13\f\17\17\"\"\4\2\f\f"+
		"\17\17\u012c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2"+
		"S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3"+
		"\2\2\2\2a\3\2\2\2\3c\3\2\2\2\5j\3\2\2\2\7s\3\2\2\2\tv\3\2\2\2\13y\3\2"+
		"\2\2\r{\3\2\2\2\17}\3\2\2\2\21\177\3\2\2\2\23\u0081\3\2\2\2\25\u0083\3"+
		"\2\2\2\27\u0085\3\2\2\2\31\u0087\3\2\2\2\33\u0089\3\2\2\2\35\u008b\3\2"+
		"\2\2\37\u008d\3\2\2\2!\u008f\3\2\2\2#\u0099\3\2\2\2%\u009b\3\2\2\2\'\u00a7"+
		"\3\2\2\2)\u00a9\3\2\2\2+\u00ab\3\2\2\2-\u00ad\3\2\2\2/\u00af\3\2\2\2\61"+
		"\u00b2\3\2\2\2\63\u00b5\3\2\2\2\65\u00b8\3\2\2\2\67\u00bb\3\2\2\29\u00be"+
		"\3\2\2\2;\u00c1\3\2\2\2=\u00c3\3\2\2\2?\u00c5\3\2\2\2A\u00c7\3\2\2\2C"+
		"\u00cb\3\2\2\2E\u00ce\3\2\2\2G\u00d3\3\2\2\2I\u00da\3\2\2\2K\u00de\3\2"+
		"\2\2M\u00e5\3\2\2\2O\u00e8\3\2\2\2Q\u00ee\3\2\2\2S\u00f0\3\2\2\2U\u00f4"+
		"\3\2\2\2W\u00f6\3\2\2\2Y\u00f8\3\2\2\2[\u00fe\3\2\2\2]\u0100\3\2\2\2_"+
		"\u0102\3\2\2\2a\u0110\3\2\2\2cd\7t\2\2de\7g\2\2ef\7v\2\2fg\7w\2\2gh\7"+
		"t\2\2hi\7p\2\2i\4\3\2\2\2jk\7h\2\2kl\7w\2\2lm\7p\2\2mn\7e\2\2no\7v\2\2"+
		"op\7k\2\2pq\7q\2\2qr\7p\2\2r\6\3\2\2\2st\5\21\t\2tu\5\21\t\2u\b\3\2\2"+
		"\2vw\5\23\n\2wx\5\23\n\2x\n\3\2\2\2yz\7]\2\2z\f\3\2\2\2{|\7a\2\2|\16\3"+
		"\2\2\2}~\7_\2\2~\20\3\2\2\2\177\u0080\7-\2\2\u0080\22\3\2\2\2\u0081\u0082"+
		"\7/\2\2\u0082\24\3\2\2\2\u0083\u0084\7,\2\2\u0084\26\3\2\2\2\u0085\u0086"+
		"\7\61\2\2\u0086\30\3\2\2\2\u0087\u0088\7`\2\2\u0088\32\3\2\2\2\u0089\u008a"+
		"\7*\2\2\u008a\34\3\2\2\2\u008b\u008c\7+\2\2\u008c\36\3\2\2\2\u008d\u008e"+
		"\7g\2\2\u008e \3\2\2\2\u008f\u0090\7=\2\2\u0090\"\3\2\2\2\u0091\u009a"+
		"\5/\30\2\u0092\u009a\5\61\31\2\u0093\u009a\5\63\32\2\u0094\u009a\5\65"+
		"\33\2\u0095\u009a\5\67\34\2\u0096\u009a\59\35\2\u0097\u009a\5+\26\2\u0098"+
		"\u009a\5-\27\2\u0099\u0091\3\2\2\2\u0099\u0092\3\2\2\2\u0099\u0093\3\2"+
		"\2\2\u0099\u0094\3\2\2\2\u0099\u0095\3\2\2\2\u0099\u0096\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u0098\3\2\2\2\u009a$\3\2\2\2\u009b\u009d\5\'\24\2"+
		"\u009c\u009e\5\'\24\2\u009d\u009c\3\2\2\2\u009d\u009e\3\2\2\2\u009e&\3"+
		"\2\2\2\u009f\u00a8\5\21\t\2\u00a0\u00a8\5\23\n\2\u00a1\u00a8\5\27\f\2"+
		"\u00a2\u00a8\5Q)\2\u00a3\u00a8\5\31\r\2\u00a4\u00a8\5\25\13\2\u00a5\u00a8"+
		"\5+\26\2\u00a6\u00a8\5-\27\2\u00a7\u009f\3\2\2\2\u00a7\u00a0\3\2\2\2\u00a7"+
		"\u00a1\3\2\2\2\u00a7\u00a2\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a7\u00a4\3\2"+
		"\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8(\3\2\2\2\u00a9\u00aa"+
		"\7.\2\2\u00aa*\3\2\2\2\u00ab\u00ac\7@\2\2\u00ac,\3\2\2\2\u00ad\u00ae\7"+
		">\2\2\u00ae.\3\2\2\2\u00af\u00b0\7(\2\2\u00b0\u00b1\7(\2\2\u00b1\60\3"+
		"\2\2\2\u00b2\u00b3\7~\2\2\u00b3\u00b4\7~\2\2\u00b4\62\3\2\2\2\u00b5\u00b6"+
		"\7@\2\2\u00b6\u00b7\7?\2\2\u00b7\64\3\2\2\2\u00b8\u00b9\7>\2\2\u00b9\u00ba"+
		"\7?\2\2\u00ba\66\3\2\2\2\u00bb\u00bc\7?\2\2\u00bc\u00bd\7?\2\2\u00bd8"+
		"\3\2\2\2\u00be\u00bf\7#\2\2\u00bf\u00c0\7?\2\2\u00c0:\3\2\2\2\u00c1\u00c2"+
		"\7?\2\2\u00c2<\3\2\2\2\u00c3\u00c4\4\62;\2\u00c4>\3\2\2\2\u00c5\u00c6"+
		"\7\60\2\2\u00c6@\3\2\2\2\u00c7\u00c8\7x\2\2\u00c8\u00c9\7c\2\2\u00c9\u00ca"+
		"\7t\2\2\u00caB\3\2\2\2\u00cb\u00cc\7k\2\2\u00cc\u00cd\7h\2\2\u00cdD\3"+
		"\2\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7n\2\2\u00d0\u00d1\7u\2\2\u00d1"+
		"\u00d2\7g\2\2\u00d2F\3\2\2\2\u00d3\u00d4\7g\2\2\u00d4\u00d5\7n\2\2\u00d5"+
		"\u00d6\7u\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7k\2\2\u00d8\u00d9\7h\2\2"+
		"\u00d9H\3\2\2\2\u00da\u00db\7h\2\2\u00db\u00dc\7q\2\2\u00dc\u00dd\7t\2"+
		"\2\u00ddJ\3\2\2\2\u00de\u00df\7y\2\2\u00df\u00e0\7j\2\2\u00e0\u00e1\7"+
		"k\2\2\u00e1\u00e2\7n\2\2\u00e2\u00e3\7g\2\2\u00e3L\3\2\2\2\u00e4\u00e6"+
		"\t\2\2\2\u00e5\u00e4\3\2\2\2\u00e6N\3\2\2\2\u00e7\u00e9\t\3\2\2\u00e8"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\b(\2\2\u00edP\3\2\2\2\u00ee\u00ef"+
		"\7\'\2\2\u00efR\3\2\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3"+
		"\7y\2\2\u00f3T\3\2\2\2\u00f4\u00f5\7A\2\2\u00f5V\3\2\2\2\u00f6\u00f7\7"+
		"<\2\2\u00f7X\3\2\2\2\u00f8\u00f9\7r\2\2\u00f9\u00fa\7t\2\2\u00fa\u00fb"+
		"\7k\2\2\u00fb\u00fc\7p\2\2\u00fc\u00fd\7v\2\2\u00fdZ\3\2\2\2\u00fe\u00ff"+
		"\7}\2\2\u00ff\\\3\2\2\2\u0100\u0101\7\177\2\2\u0101^\3\2\2\2\u0102\u0103"+
		"\7\61\2\2\u0103\u0104\7,\2\2\u0104\u0108\3\2\2\2\u0105\u0107\13\2\2\2"+
		"\u0106\u0105\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0109\3\2\2\2\u0108\u0106"+
		"\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010c\7,\2\2\u010c"+
		"\u010d\7\61\2\2\u010d\u010e\3\2\2\2\u010e\u010f\b\60\2\2\u010f`\3\2\2"+
		"\2\u0110\u0111\7\61\2\2\u0111\u0112\7\61\2\2\u0112\u0116\3\2\2\2\u0113"+
		"\u0115\n\4\2\2\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u0116\3\2\2\2\u0119"+
		"\u011a\b\61\2\2\u011ab\3\2\2\2\n\2\u0099\u009d\u00a7\u00e5\u00ea\u0108"+
		"\u0116\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}