%{
    #include <stdio.h>
%}


%{
	#include <stdio.h>
	#include <stdlib.h>

	/* Declarar Variáveis C */
	int numErrors = 0;

	/* Declaração Funções C */
	int yyerror(char *str);
	int yylex (void);
%}

/* Definir Tokens sendo possíveis de guardar */
%union{
	double real; 
}

%token <real> MOEDA CAFE PINGO CHA CHOCOLATE COPO LEITE

%type <real> GUITO

%start FRASE

%%
FRASE	:	/* vazio */
			|	FRASE ELEMENTOS '\n'	{printf("\n\n______PODE REPETIR________\n\n");}
			|	FRASE '\n'		{printf("\n\n______PODE REPETIR________\n\n");}
			|	FRASE error '\n'{ yyerror("produto/moeda inválida"); }
			;

ELEMENTOS	:	CAFE ',' GUITO		{ if($3 >= $1){

							printf("CAFE,%.2f€\n", $3-$1); } else{ printf("FALTA DINHEIRO\n"); } 
 
 						}
		|	COPO ',' GUITO		{ 
							if($3 >= $1){ printf("COPO,%.2f€\n", $3-$1); } else{ printf("FALTA DINHEIRO\n"); }
							
						}
		|	CHOCOLATE ',' GUITO	{ if($3 >= $1){ printf("CHOCOLATE,%.2f€\n", $3-$1); } else{ printf("FALTA DINHEIRO\n"); } }
		|	LEITE ',' GUITO		{ if($3 >= $1){ printf("LEITE,%.2f€\n", $3-$1); } else{ printf("FALTA DINHEIRO\n"); } }
		|	CHA ',' GUITO		{ if($3 >= $1){ printf("CHA,%.2f€\n", $3-$1); } else{ printf("FALTA DINHEIRO\n"); } }
		|	PINGO ',' GUITO		{ if($3 >= $1){ printf("PINGO,%.2f€\n", $3-$1); } else{ printf("FALTA DINHEIRO\n"); } }
		;

GUITO	:	MOEDA{	$$ = $1; }
		|	GUITO ',' MOEDA{ $$ = $1 + $3; }
		;

%%

int main(void){
	printf("Terminar com Ctrl+D:\n");
	yyparse();
	printf("F I M\n");
}	


int yyerror(char *str){
	numErrors++;
	printf("Syntax Error : %s\n", str);
	return numErrors;
}
