// Generated from /Users/jacktimblin/Desktop/Expression.g4 by ANTLR 4.5.1

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
		LBRACE=1, RBRACE=2, PLUS=3, MINUS=4, TIMES=5, DIV=6, POW=7, LPAREN=8, 
		RPAREN=9, E=10, SEMI_COLON=11, LOGICAL=12, OPERATOR=13, SYMBOL=14, COMMA=15, 
		GT=16, LT=17, AND=18, OR=19, GTE=20, LTE=21, EQ=22, NEQ=23, DIGIT=24, 
		POINT=25, LETTER=26, WS=27, MODULO=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LBRACE", "RBRACE", "PLUS", "MINUS", "TIMES", "DIV", "POW", "LPAREN", 
		"RPAREN", "E", "SEMI_COLON", "LOGICAL", "OPERATOR", "SYMBOL", "COMMA", 
		"GT", "LT", "AND", "OR", "GTE", "LTE", "EQ", "NEQ", "DIGIT", "POINT", 
		"LETTER", "WS", "MODULO"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "']'", "'+'", "'-'", "'*'", "'/'", "'^'", "'('", "')'", "'e'", 
		"';'", null, null, null, "','", "'>'", "'<'", "'&&'", "'||'", "'>='", 
		"'<='", "'=='", "'!='", null, "'.'", null, null, "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LBRACE", "RBRACE", "PLUS", "MINUS", "TIMES", "DIV", "POW", "LPAREN", 
		"RPAREN", "E", "SEMI_COLON", "LOGICAL", "OPERATOR", "SYMBOL", "COMMA", 
		"GT", "LT", "AND", "OR", "GTE", "LTE", "EQ", "NEQ", "DIGIT", "POINT", 
		"LETTER", "WS", "MODULO"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u0091\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\rZ\n\r\3\16\3\16\5\16^\n\16\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\5\17h\n\17\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\5\33\u0087\n\33\3\34\6\34"+
		"\u008a\n\34\r\34\16\34\u008b\3\34\3\34\3\35\3\35\2\2\36\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36\3\2\4\4\2C\\c|\5"+
		"\2\13\f\17\17\"\"\u00a0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\3;\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tA\3\2\2\2\13C\3\2"+
		"\2\2\rE\3\2\2\2\17G\3\2\2\2\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27O\3"+
		"\2\2\2\31Y\3\2\2\2\33[\3\2\2\2\35g\3\2\2\2\37i\3\2\2\2!k\3\2\2\2#m\3\2"+
		"\2\2%o\3\2\2\2\'r\3\2\2\2)u\3\2\2\2+x\3\2\2\2-{\3\2\2\2/~\3\2\2\2\61\u0081"+
		"\3\2\2\2\63\u0083\3\2\2\2\65\u0086\3\2\2\2\67\u0089\3\2\2\29\u008f\3\2"+
		"\2\2;<\7]\2\2<\4\3\2\2\2=>\7_\2\2>\6\3\2\2\2?@\7-\2\2@\b\3\2\2\2AB\7/"+
		"\2\2B\n\3\2\2\2CD\7,\2\2D\f\3\2\2\2EF\7\61\2\2F\16\3\2\2\2GH\7`\2\2H\20"+
		"\3\2\2\2IJ\7*\2\2J\22\3\2\2\2KL\7+\2\2L\24\3\2\2\2MN\7g\2\2N\26\3\2\2"+
		"\2OP\7=\2\2P\30\3\2\2\2QZ\5%\23\2RZ\5\'\24\2SZ\5)\25\2TZ\5+\26\2UZ\5-"+
		"\27\2VZ\5/\30\2WZ\5!\21\2XZ\5#\22\2YQ\3\2\2\2YR\3\2\2\2YS\3\2\2\2YT\3"+
		"\2\2\2YU\3\2\2\2YV\3\2\2\2YW\3\2\2\2YX\3\2\2\2Z\32\3\2\2\2[]\5\35\17\2"+
		"\\^\5\35\17\2]\\\3\2\2\2]^\3\2\2\2^\34\3\2\2\2_h\5\7\4\2`h\5\t\5\2ah\5"+
		"\r\7\2bh\59\35\2ch\5\17\b\2dh\5\13\6\2eh\5!\21\2fh\5#\22\2g_\3\2\2\2g"+
		"`\3\2\2\2ga\3\2\2\2gb\3\2\2\2gc\3\2\2\2gd\3\2\2\2ge\3\2\2\2gf\3\2\2\2"+
		"h\36\3\2\2\2ij\7.\2\2j \3\2\2\2kl\7@\2\2l\"\3\2\2\2mn\7>\2\2n$\3\2\2\2"+
		"op\7(\2\2pq\7(\2\2q&\3\2\2\2rs\7~\2\2st\7~\2\2t(\3\2\2\2uv\7@\2\2vw\7"+
		"?\2\2w*\3\2\2\2xy\7>\2\2yz\7?\2\2z,\3\2\2\2{|\7?\2\2|}\7?\2\2}.\3\2\2"+
		"\2~\177\7#\2\2\177\u0080\7?\2\2\u0080\60\3\2\2\2\u0081\u0082\4\62;\2\u0082"+
		"\62\3\2\2\2\u0083\u0084\7\60\2\2\u0084\64\3\2\2\2\u0085\u0087\t\2\2\2"+
		"\u0086\u0085\3\2\2\2\u0087\66\3\2\2\2\u0088\u008a\t\3\2\2\u0089\u0088"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008e\b\34\2\2\u008e8\3\2\2\2\u008f\u0090\7\'\2\2"+
		"\u0090:\3\2\2\2\b\2Y]g\u0086\u008b\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}