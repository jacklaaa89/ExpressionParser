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
		DIGIT=25, POINT=26, LETTER=27, WS=28, MODULO=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"LBRACE", "UNDERSCORE", "RBRACE", "PLUS", "MINUS", "TIMES", "DIV", "POW", 
		"LPAREN", "RPAREN", "E", "SEMI_COLON", "LOGICAL", "OPERATOR", "SYMBOL", 
		"COMMA", "GT", "LT", "AND", "OR", "GTE", "LTE", "EQ", "NEQ", "DIGIT", 
		"POINT", "LETTER", "WS", "MODULO"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "'_'", "']'", "'+'", "'-'", "'*'", "'/'", "'^'", "'('", "')'", 
		"'e'", "';'", null, null, null, "','", "'>'", "'<'", "'&&'", "'||'", "'>='", 
		"'<='", "'=='", "'!='", null, "'.'", null, null, "'%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LBRACE", "UNDERSCORE", "RBRACE", "PLUS", "MINUS", "TIMES", "DIV", 
		"POW", "LPAREN", "RPAREN", "E", "SEMI_COLON", "LOGICAL", "OPERATOR", "SYMBOL", 
		"COMMA", "GT", "LT", "AND", "OR", "GTE", "LTE", "EQ", "NEQ", "DIGIT", 
		"POINT", "LETTER", "WS", "MODULO"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u0095\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16^\n\16\3\17"+
		"\3\17\5\17b\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20l\n\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\34\5\34\u008b\n\34\3\35\6\35\u008e\n\35\r\35\16\35\u008f\3\35\3\35\3"+
		"\36\3\36\2\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37\3\2\4\4\2C\\c|\5\2\13\f\17\17\"\"\u00a4\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2"+
		"\2\2\5?\3\2\2\2\7A\3\2\2\2\tC\3\2\2\2\13E\3\2\2\2\rG\3\2\2\2\17I\3\2\2"+
		"\2\21K\3\2\2\2\23M\3\2\2\2\25O\3\2\2\2\27Q\3\2\2\2\31S\3\2\2\2\33]\3\2"+
		"\2\2\35_\3\2\2\2\37k\3\2\2\2!m\3\2\2\2#o\3\2\2\2%q\3\2\2\2\'s\3\2\2\2"+
		")v\3\2\2\2+y\3\2\2\2-|\3\2\2\2/\177\3\2\2\2\61\u0082\3\2\2\2\63\u0085"+
		"\3\2\2\2\65\u0087\3\2\2\2\67\u008a\3\2\2\29\u008d\3\2\2\2;\u0093\3\2\2"+
		"\2=>\7]\2\2>\4\3\2\2\2?@\7a\2\2@\6\3\2\2\2AB\7_\2\2B\b\3\2\2\2CD\7-\2"+
		"\2D\n\3\2\2\2EF\7/\2\2F\f\3\2\2\2GH\7,\2\2H\16\3\2\2\2IJ\7\61\2\2J\20"+
		"\3\2\2\2KL\7`\2\2L\22\3\2\2\2MN\7*\2\2N\24\3\2\2\2OP\7+\2\2P\26\3\2\2"+
		"\2QR\7g\2\2R\30\3\2\2\2ST\7=\2\2T\32\3\2\2\2U^\5\'\24\2V^\5)\25\2W^\5"+
		"+\26\2X^\5-\27\2Y^\5/\30\2Z^\5\61\31\2[^\5#\22\2\\^\5%\23\2]U\3\2\2\2"+
		"]V\3\2\2\2]W\3\2\2\2]X\3\2\2\2]Y\3\2\2\2]Z\3\2\2\2][\3\2\2\2]\\\3\2\2"+
		"\2^\34\3\2\2\2_a\5\37\20\2`b\5\37\20\2a`\3\2\2\2ab\3\2\2\2b\36\3\2\2\2"+
		"cl\5\t\5\2dl\5\13\6\2el\5\17\b\2fl\5;\36\2gl\5\21\t\2hl\5\r\7\2il\5#\22"+
		"\2jl\5%\23\2kc\3\2\2\2kd\3\2\2\2ke\3\2\2\2kf\3\2\2\2kg\3\2\2\2kh\3\2\2"+
		"\2ki\3\2\2\2kj\3\2\2\2l \3\2\2\2mn\7.\2\2n\"\3\2\2\2op\7@\2\2p$\3\2\2"+
		"\2qr\7>\2\2r&\3\2\2\2st\7(\2\2tu\7(\2\2u(\3\2\2\2vw\7~\2\2wx\7~\2\2x*"+
		"\3\2\2\2yz\7@\2\2z{\7?\2\2{,\3\2\2\2|}\7>\2\2}~\7?\2\2~.\3\2\2\2\177\u0080"+
		"\7?\2\2\u0080\u0081\7?\2\2\u0081\60\3\2\2\2\u0082\u0083\7#\2\2\u0083\u0084"+
		"\7?\2\2\u0084\62\3\2\2\2\u0085\u0086\4\62;\2\u0086\64\3\2\2\2\u0087\u0088"+
		"\7\60\2\2\u0088\66\3\2\2\2\u0089\u008b\t\2\2\2\u008a\u0089\3\2\2\2\u008b"+
		"8\3\2\2\2\u008c\u008e\t\3\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2"+
		"\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092"+
		"\b\35\2\2\u0092:\3\2\2\2\u0093\u0094\7\'\2\2\u0094<\3\2\2\2\b\2]ak\u008a"+
		"\u008f\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}