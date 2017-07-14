grammar Formula4;

@header {
    package lapr4.blue.s3.lang.n1150433.formula.compiler;
}


expression
	: EQ comparison EOF
        | money_expression
	;

money_expression
        : TAGCURRENCY L_CURLY_BRACKET moneys R_CURLY_BRACKET
        ;

moneys: MONEY_NUM (money_operation MONEY_NUM)+ ;

money_operation:    (PLUS|MINUS|MULTI|DIV) ;

block
	: L_CURLY_BRACKET comparison ( SEMI comparison )* R_CURLY_BRACKET 
	;
	
comparison
	: concatenation
		( ( EQ | NEQ | GT | LT | LTEQ | GTEQ | ASSIGN) concatenation )?        
	;


concatenation
        : ( MINUS )? atom
        | concatenation PERCENT
        | <assoc=right> concatenation POWER concatenation
        | concatenation ( MULTI | DIV ) concatenation
        | concatenation ( PLUS | MINUS ) concatenation
        | concatenation AMP concatenation 
        | for_loop
        | while_loop
        | eval
        ;

for_loop
    : FOR L_CURLY_BRACKET comparison ( SEMI comparison )* R_CURLY_BRACKET ;

while_loop
    : DOWHILE LPAR comparison ( SEMI comparison )* RPAR 
    | WHILEDO LPAR comparison ( SEMI comparison )* RPAR 
    ;

eval
    : EVAL LPAR QUOT NUMBER ((PLUS|MINUS|MULTI|DIV) NUMBER)+ QUOT RPAR
    ;

atom
	:	function_call
	|	reference
	|	literal
	|	LPAR comparison RPAR
	|	block
	|	assignment
	;

assignment
	:  LPAR reference ASSIGN comparison RPAR
	;

function_call
	:	FUNCTION LPAR
		( comparison ( SEMI comparison )* )?
		RPAR
	;

reference
	:	CELL_REF
		( ( COLON ) CELL_REF )?
	;

literal
	:	NUMBER
	|	STRING
        |       VAR
	;

EVAL : ('EVAL' | 'eval' | 'Eval');

DOWHILE : ('DOWHILE' | 'dowhile' | 'DoWhile');

WHILEDO : ('WHILEDO' | 'whiledo' | 'WhileDo');

FOR : ('FOR' | 'for' | 'For') ;
fragment LETTER: ('a'..'z'|'A'..'Z') ;

  
FUNCTION : 
	  ( LETTER )+ 
	;	
	 
 
CELL_REF
	:
		( ABS )? LETTER ( LETTER )?
		( ABS )? ( DIGIT )+
	;

/*Variable */
VAR : 
        (UNDERSCORE|ATSYMBOL) LETTER (LETTER|DIGIT|UNDERSCORE)* 
        ;

/* String literals, i.e. anything inside the delimiters */

STRING  : QUOT ('\\"' | ~'"')* QUOT
        ;

QUOT: '"' 
	;

/* Numeric literals */
NUMBER: ( DIGIT )+ ( COMMA ( DIGIT )+ )? ;

fragment 
DIGIT : '0'..'9' ;

/* Comparison operators */
EQ		: '=' ;
NEQ		: '<>' ;
LTEQ	: '<=' ;
GTEQ	: '>=' ;
GT		: '>' ;
LT		: '<' ;

/* Text operators */
AMP		: '&' ;

/* Arithmetic operators */
PLUS	: '+' ;
MINUS	: '-' ;
MULTI	: '*' ;
DIV	: '/' ;
POWER	: '^' ;
PERCENT : '%' ;

/* Reference operators */
fragment ABS : '$' ;
fragment EXCL:  '!'  ;
COLON	: ':' ;
UNDERSCORE : '_' ;
ATSYMBOL : '@' ;
 
/* Miscellaneous operators */
COMMA	: ',' ;
SEMI	: ';' ;
LPAR	: '(' ;
RPAR	: ')' ; 
L_CURLY_BRACKET	: '{' ;
R_CURLY_BRACKET	: '}' ;

/* assignment operator */
ASSIGN  : ':=' ;

/* Money initializer with currencies */
TAGCURRENCY : ('#euro' | '#pound' | '#dollar') ;

/* the currency symbols */
/* represented with unicodes to avoid validation problems */
/* euro | dollar | pound */
CURRENCY_SYMBOL: ('\u20AC' | '\u0024' | '\u00A3') ;

MONEY_NUM:
         DIGIT+ ('.'(DIGIT)+)? CURRENCY_SYMBOL
         ;

/* White-space (ignored) */
WS: ( ' ' | '\r' '\n' | '\n' | '\t' ) -> skip ;