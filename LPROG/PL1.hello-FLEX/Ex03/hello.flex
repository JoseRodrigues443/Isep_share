/** Escrever um programa que permite validar matrículas portuguesas”. .  **/

%{ /*declaracaoes C*/

%}

	/*macros-ER*/
	//vazio

	
%%	/** area regras **/
[0-9]{4}[a-zA-Z]{2}	printf("É uma matrícula");
[ ]		printf("Erro lexico: simbolo desconhecido %s\n",yytext);
.		printf("Erro lexico: simbolo desconhecido %s\n",yytext);


%%	/** area rotinas **/
main()
{
	printf("\nEscreva pro mundo (CTRL^D terminar): ");
	yylex();
	printf("\nFIM\n");
}


