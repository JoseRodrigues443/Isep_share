%{
  #include"maiormenor.tab.h" // header gerado pelo BISON
  extern int numErros;
%}

%%
\<							return MENOR;
\>							return MAIOR;
\<\=						return MENORIGUAL;
\>\=						return MAIORIGUAL;
\=							return IGUAL;
\<\>						return DIFERENTE;
[ ]							return ESPACO;
[0-9]+						yylval = atoi(yytext); return NUM;
.							printf("Erro lexico: simbolo desconhecido %s\n",yytext); numErros++;
<<EOF>>						return 0;

%%
