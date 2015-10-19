grammar Expression;

@header {
package org.expression.parser;
}

start 
	: (expression|print|assignment|controlStatement) (expression|print|assignment|controlStatement)*
	;

expression
	: expr SEMI_COLON
	;

expr
    : incDecExpression                     #incDecExpr
	| arrayAccess                          #arrayAccessExpr
	| LPAREN expr RPAREN                   #parenExpr
	| left=expr op=LOGICAL 		right=expr #boolExpr
	| left=expr op=POW          right=expr #opExpr
	| left=expr op=(TIMES|DIV)  right=expr #opExpr
	| left=expr op=(PLUS|MINUS) right=expr #opExpr
	| left=expr op=OPERATOR     right=expr #opExpr						   
	| func                                 #funcExpr
	| atom                                 #atomExpr
	| left=expr op=POINT        right=expr #opExpr
	;

atom
	: scientific       #atomValue
	| variable         #atomValue
	| array            #atomValue
	| matrix           #atomValue
	;

incDecExpression
	: atom (INCREMENT|DECREMENT)
	| func (INCREMENT|DECREMENT)
	;

controlStatement
	: ifStatement
	| forLoop
	| whileLoop
	;

logicalOperation
	: left=expr op=LOGICAL right=expr
	;

forcedLogicalOperation
	: variable LOGICAL expr
	| expr LOGICAL variable
	;

forLoop
	: FOR LPAREN assignment forcedLogicalOperation SEMI_COLON (variable (INCREMENT|DECREMENT)) RPAREN BLOCKLEFT start BLOCKRIGHT
	;

whileLoop
	: WHILE LPAREN forcedLogicalOperation RPAREN BLOCKLEFT start BLOCKRIGHT
	;

ifStatement
	: IF LPAREN logicalOperation RPAREN BLOCKLEFT start? BLOCKRIGHT elseifStatement* elseStatement?
	;

elseifStatement
	: ELSEIF LPAREN logicalOperation RPAREN BLOCKLEFT start? BLOCKRIGHT
	;

elseStatement
	: ELSE BLOCKLEFT start? BLOCKRIGHT
	;

arrayAccess
	: (func | atom) LBRACE DIGIT (COMMA DIGIT)? RBRACE
	;

print
	: PRI expression 
	;

assignment
	: VAR variable ASSIGN expression
	| variable (LBRACE DIGIT (COMMA DIGIT)? RBRACE)? ASSIGN expression
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

INCREMENT
	: PLUS PLUS
	;

DECREMENT
	: MINUS MINUS
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

ASSIGN
	: '='
	;

DIGIT
	: ('0'..'9')
	;

POINT
	: '.'
	;

VAR
	: 'var'
	;

IF
	: 'if'
	;

ELSE
	: 'else'
	;

ELSEIF
	: 'elseif'
	;

FOR
	: 'for'
	;

WHILE
	: 'while'
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

PRI
	: 'print'
	;

BLOCKLEFT
	: '{'
	;

BLOCKRIGHT
	: '}'
	;

COMMENT
    :   '/*' .*? '*/' -> channel(HIDDEN)
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN)
    ;