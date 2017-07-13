/** Escrever um programa que permite contar o número de ocorrências de uma cadeia de caracteres.  **/

%{ /*declaracaoes C*/
	int numCaracter = 0;
%}

	/*macros-ER*/
	//vazio

	
%%	/** area regras **/
ola|OLA		numCaracter++;printf("Nº Ola: %d",numCaracter);
[ ]			printf("<%s>",yytext);
.          	printf("Erro lexico: simbolo desconhecido %s\n",yytext);


%%	/** area rotinas **/
main()
{
	printf("\nEscreva pro mundo (CTRL^D terminar): ");
	yylex();
	printf("\nFIM\n");
}


