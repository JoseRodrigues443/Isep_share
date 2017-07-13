/** Considerando o alfabeto 

 = {
0,1,2,3,4,5,6,7,8,9
}, represente as seguintes linguagens utilizando 
expressões regulares

L(A) = {u 


*
:u é um inteiro maior ou igual a 1000} 

  **/

%{ /*declaracaoes C*/
%}

	/*macros-ER*/
	
	
	


	// area regras
%%		
[0-9]?[1-9]([0-9]{3,})		printf("CORRETO: %s", yytext );

.		//;


%%	/** area rotinas **/
main()
{
	printf("\nEscreva pro mundo (CTRL^D terminar): ");
	yylex();
	
	printf("\nFIM\n");
}





















