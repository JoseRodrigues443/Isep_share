%{ 
	#include <ctype.h>
	#include "ex.tab.h" /* Header gerado pelo Bison */

	extern int numErrors;
%} 

%% 

[a-z]{3}[0-9]{2}		{yylval.string=(yytext);return CODIGO_FORMADOR;}
(\"[a-zA-Z]+([ ][a-zA-Z]+)*\")		{yylval.string=(yytext);return NOME_FORMADOR; }
[A-Z]{3}[0-9]{2}	{yylval.string=(yytext);return CODIGO_CURSO; }
[0-9]+		{yylval.inteiro=atoi(yytext) ;return NUMERO_GENERICO; }
(\"[a-z]+\")		{yylval.string=(yytext);return NOME_CURSO; }





[\n]	return yytext[0];
[ ]	return yytext[0];

[\t\r]* 		/* ignorado */

.				{printf("ERROR: Lexical error: character not recognized - %c\n", yytext[0]); numErrors++;} 

<<EOF>>         return 0; 

%%


/*
printf("sdfg------> %s\n" ,yytext);

([1][0-9]?)|[2-9]	{yylval.inteiro=atoi(yytext);return CARGA_HORARIA; }
[1-9][0-9]*	{yylval.inteiro=atoi(yytext);return NUM_ALUNOS; }

*/




