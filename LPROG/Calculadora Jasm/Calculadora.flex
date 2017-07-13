%{
  #include"Calculadora.tab.h" // header gerado pelo BISON
%}

%%

[0-9]+    	{yylval=atoi(yytext); return INT;}
[-+*/]		return yytext[0];
[ \t\r]    	/* ignorado */  // \r=CR & \n=LF

.          	printf("Erro lexico: simbolo desconhecido %s\n",yytext); 

\n         	return yytext[0];
<<EOF>>    	return 0;

