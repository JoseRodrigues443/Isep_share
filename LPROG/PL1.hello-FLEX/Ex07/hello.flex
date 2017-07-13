/**

S →AB
A → aB| (vazio)
B → bAC| (vazio)
C → c(A+B)


  **/

%{ /*declaracaoes C*/
%}

	/*macros-ER*/
	
	A []*
	B []
	C []
	
	


	// area regras
%%		
[0-9]+(\.[0-9]+)		printf("%s", yytext );
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





















