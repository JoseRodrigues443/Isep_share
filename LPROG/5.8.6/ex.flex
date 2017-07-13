%{ 
	#include <ctype.h>
	#include "ex.tab.h" /* Header gerado pelo Bison */

	extern int numErrors;
%} 

%% 

pingo		{	yylval.real = 0.35;	return PINGO; }
cafe		{	yylval.real = 0.35;	return CAFE; }
cha		{	yylval.real = 0.35;	return CHA; }
leite		{	yylval.real = 0.30;	return LEITE; }
copo		{	yylval.real = 0.05;	return COPO; }
chocolate	{	yylval.real = 0.40;	return CHOCOLATE; }

€

[0-9]+\.[0-9]+ {yylval.real=atof(yytext); return MOEDA;}
								
[\n\,]	return yytext[0];

[\t\r ]* 		/* ignorado */

.				{ printf("ERROR: Lexical error: character not recognized - %c\n", yytext[0]); numErrors++;} 

<<EOF>>         return 0; 

%%
