/** Escrever um programa que permite substituir as seguintes cadeias: “FEUP” por “ISEP” e “2007” 
por “2008”. .  **/

%{ /*declaracaoes C*/

%}

	/*macros-ER*/
	//vazio

	
%%	/** area regras **/
feup|FEUP		printf("ISEP");
2007			printf("2008");
[ ]			//printf("<%s>",yytext);
.		//printf("Erro lexico: simbolo desconhecido %s\n",yytext);


%%	/** area rotinas **/
main()
{
	printf("\nEscreva pro mundo (CTRL^D terminar): ");
	yylex();
	printf("\nFIM\n");
}


