/** Escrever um programa que permite identificar números naturais

  **/

%{ /*declaracaoes C*/
%}

	/*macros-ER*/
	
	
	


	// area regras
%%		
-[0-9]		printf("%s", yytext );
[0-9]		printf("%s", yytext );;
[ ]		//;
\n		//;
\t		//;
.		//;


%%	/** area rotinas **/
main()
{
	printf("\nEscreva pro mundo (CTRL^D terminar): ");
	yylex();
	
	printf("\nFIM\n");
}





















