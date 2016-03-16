grammar Expression;

@header {
package org.expression.parser;
}

start
	: importStatement* ex?
	;

ex 
	: (expression|print|assignment|controlStatement|procedure|returnStatement) (expression|print|assignment|controlStatement|procedure|returnStatement)*
	;


importStatement
	: IMPORT file SEMI_COLON
	;

file
	: (LETTER|DIGIT|E|'/'|'_'|'-')*
	;

expression
	: expr SEMI_COLON
	;

expr
	: incDecExpression	#incDecExpr
        | prefixOperation       #prefixExpr
        |   newStructure           #newExpr
	| arrayAccess                          #arrayAccessExpr
	| LPAREN expr RPAREN                   #parenExpr
	| instanceOfExpression      		   #instanceofExpr
	| left=expr op=LOGICAL 		right=expr #boolExpr
	| left=expr op=POW          right=expr #opExpr
	| left=expr op=(TIMES|DIV)  right=expr #opExpr
	| left=expr op=(PLUS|MINUS) right=expr #opExpr
	| left=expr op=OPERATOR     right=expr #opExpr
	| ternary							   #ternaryExpr						   
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
	: atom (INCREMENT|DECREMENT|OPERATOR)
	| func (INCREMENT|DECREMENT|OPERATOR)
	;

prefixOperation
        : (INCREMENT|DECREMENT|OPERATOR) atom
        | (INCREMENT|DECREMENT|OPERATOR) func
        ;

instanceOfExpression
	: NOT LPAREN variable INSTANCE_OF type RPAREN
	| variable INSTANCE_OF type
	;

controlStatement
	: ifStatement
	| forLoop
	| whileLoop
	;

logicalOperation
	: left=expr op=LOGICAL right=expr
	| instanceOfExpression
	;

forcedLogicalOperation
	: variable LOGICAL expr
	| expr LOGICAL variable
	| instanceOfExpression
	;

newStructure
	: NEW type LPAREN index (COMMA index)? RPAREN
	;

ternary
	: LPAREN logicalOperation RPAREN QMARK expr COLON expr 
	;

forLoop
	: FOR LPAREN assignment forcedLogicalOperation SEMI_COLON (variable (INCREMENT|DECREMENT)) RPAREN BLOCKLEFT ex? BLOCKRIGHT
	;

whileLoop
	: WHILE LPAREN forcedLogicalOperation RPAREN BLOCKLEFT ex? BLOCKRIGHT
	;

ifStatement
	: IF LPAREN logicalOperation RPAREN BLOCKLEFT ex? BLOCKRIGHT elseifStatement* elseStatement?
	;

elseifStatement
	: ELSEIF LPAREN logicalOperation RPAREN BLOCKLEFT ex? BLOCKRIGHT
	;

elseStatement
	: ELSE BLOCKLEFT ex? BLOCKRIGHT
	;

arrayAccess
	: (func | atom) LBRACE (index (COMMA index)?) RBRACE
	;

type
	: (SCALAR_TYPE|MATRIX_TYPE|ARRAY_TYPE)
	;

print
	: PRI expression 
	;

index
	: DIGIT|variable
	;

assignment
	: VAR variable ASSIGN expression
	| varName=variable (LBRACE ((index) (COMMA index)?) RBRACE)? ASSIGN expression
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

returnStatement
	: RETURN expression
	;

procedureParams
	: (variable) (COMMA (variable))*
	;

procedure
	: FUNCTION funcName LPAREN (procedureParams)? RPAREN (procedureReturnType)? BLOCKLEFT ex? BLOCKRIGHT
	;

procedureReturnType
	: RIGHT_ARROW type
	;

array
	: MINUS? LBRACE ((expr) (COMMA (expr))*)? RBRACE
	;

column
	: arrayInner SEMI_COLON
	;

arrayInner
	: (expr) (COMMA (expr))*
	;

matrix
	: MINUS? LBRACE ((column (column)* arrayInner)|arrayInner) RBRACE
	;

funcName
	: (LETTER|E) (LETTER|DIGIT|UNDERSCORE|E)*
	;

variable
	: MINUS? (LETTER|E) (LETTER|DIGIT|E)*
	;

INSTANCE_OF
	: 'instanceof'
	;

SCALAR_TYPE
	: 'Scalar'
	;

MATRIX_TYPE
	: 'Matrix'
	;

ARRAY_TYPE
	: 'Vector'
	;

RETURN
	: 'return'
	;

FUNCTION
	: 'function'
	;

INCREMENT
	: PLUS PLUS
	;

THROWS
	: 'throws'
	;

EXCEPTION
	: 'exception'
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

RIGHT_ARROW
	: '->'
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

IMPORT
	: 'import'
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

NEW
	: 'new'
	;

QMARK
	: '?'
	;

COLON
	: ':'
	;

PRI
	: 'print'
	;

NOT
 	: '!'
 	;

BLOCKLEFT
	: '{'
	;

QUOTE
	: '"'
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