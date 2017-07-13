/** Escrever um programa que dado um ficheiro de texto, mostra: .

 número de algarismos; 

 número de letras do alfabeto; 

número de linhas de texto; 

número de espaços ou tabulações (\t); 

número de caracteres não identificados nos pontos anteriores

  **/

%{ /*declaracaoes C*/
	int numeroAlgarismos =0;
	int numeroAlfabeto =0;
	int numeroLinhasTexto =0;
	int numeroEspacos =0;
	int numeroTab =0;
	int numeroOutras =0;
	int totalTabEspaco;
%}

	/*macros-ER*/
	
	
	


	// area regras
%%		
[a-zA-Z]	numeroAlfabeto++;
[0-9]		numeroAlgarismos++;
[ ]		numeroEspacos++;
\n		numeroLinhasTexto++;
\t		numeroTab++;
.		numeroOutras++;


%%	/** area rotinas **/
main()
{
	printf("\nEscreva pro mundo (CTRL^D terminar): ");
	yylex();
	printf("\nNº Algarismos = %d", numeroAlgarismos);
	printf("\nNº Alfabeto = %d", numeroAlfabeto);
	printf("\nNº Linhas de texto = %d", numeroLinhasTexto);
	printf("\nNº Espacos = %d", numeroEspacos);
	printf("\nNº Tabs = %d", numeroTab);
	totalTabEspaco = numeroEspacos+numeroTab;
	printf("\nNº Tabs & Espaços = %d", totalTabEspaco);
	printf("\nNº Outros = %d", numeroOutras);
	printf("\nNº Algarismos = %d", numeroAlgarismos);
	
	printf("\nFIM\n");
}





















