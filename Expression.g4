grammar Expression;

@header {
package org.expression.parser;
}

expr
	: LPAREN expr RPAREN                   #parenExpr
	| left=expr op=LOGICAL 		right=expr #boolExpr
	| left=expr op=POW          right=expr #opExpr
	| left=expr op=(TIMES|DIV)  right=expr #opExpr
	| left=expr op=(PLUS|MINUS) right=expr #opExpr
	| left=expr op=OPERATOR     right=expr #opExpr						   
	| func                                 #funcExpr
	| atom                                 #atomExpr
	| left=expr op=POINT        right=expr #opExpr
	| arrayAccess                          #arrayAccessExpr
	;

atom
	: scientific       #atomValue
	| variable         #atomValue
	| array            #atomValue
	| matrix           #atomValue
	;

arrayAccess
	: (func | atom) LBRACE DIGIT (COMMA DIGIT)? RBRACE
	;

number
	: MINUS? DIGIT+ (POINT DIGIT+)?
	;

scientific
	: number (E number)?
	;

func
	: funcName LPAREN funcParams? RPAREN #funcDefinition
	;

funcParams
	: (expr) (COMMA (expr))*
	;

array
	: LBRACE (expr) (COMMA (expr))* RBRACE
	;

column
	: arrayInner SEMI_COLON
	;

arrayInner
	: (expr) (COMMA (expr))*
	;

matrix
	: LBRACE ((column (column)* arrayInner)|arrayInner) RBRACE
	;

funcName
	: LETTER (LETTER|DIGIT|UNDERSCORE)*
	;

variable
	: MINUS? LETTER (LETTER|DIGIT)*
	;

LBRACE
	: '['
	;

UNDERSCORE
	: '_'
	;

RBRACE
	: ']'
	;

PLUS
	: '+'
	;

MINUS
	: '-'
	;

TIMES
	: '*'
	;

DIV 
	: '/'
	;

POW
	: '^'
	;

LPAREN
	: '('
	;

RPAREN
	: ')'
	;

E
	: 'e'
	;

SEMI_COLON
	: ';'
	;

LOGICAL
	: AND | OR | GTE | LTE | EQ | NEQ | GT | LT
	;

OPERATOR
	: SYMBOL (SYMBOL)?
	;

SYMBOL
	: PLUS | MINUS | DIV | MODULO | POW | TIMES | GT | LT
	;

COMMA
	: ','
	;

GT
	: '>'
	;

LT 
	: '<'
	;

AND	
	: '&&'
	;

OR
	: '||'
	;

GTE
	: '>='
	;

LTE
	: '<='
	;

EQ 	
 	: '=='
 	;

NEQ
	: '!='
	;

DIGIT
	: ('0'..'9')
	;

POINT
	: '.'
	;

LETTER
	: ('a'..'z') | ('A'..'Z')
	;

WS
	: [ \r\n\t]+ -> channel(HIDDEN)
	;

MODULO
	: '%'
	;