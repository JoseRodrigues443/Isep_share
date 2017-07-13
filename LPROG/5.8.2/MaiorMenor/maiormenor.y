%{
    #include <stdio.h>
	int numErros = 0;

%}


%error-verbose 
%token  MENOR MAIOR MENORIGUAL MAIORIGUAL IGUAL DIFERENTE NUM ESPACO
%start producao

%%
		
frase: NUM ESPACO MENOR ESPACO NUM	{if($1 < $5){
								printf("Verdadeiro\n");
							} else{
								printf("Falso\n")
							;}
						};
						
frase: NUM ESPACO MAIOR ESPACO NUM	{if($1 > $5){
		printf("Verdadeiro\n");
	} else{
		printf("Falso\n")
	;}
};

frase: NUM ESPACO MAIORIGUAL ESPACO NUM	{if($1 >= $5){
		printf("Verdadeiro\n");
	} else{
		printf("Falso\n")
	;}
};

frase: NUM ESPACO MENORIGUAL ESPACO NUM	{if($1 <= $5){
		printf("Verdadeiro\n");
	} else{
		printf("Falso\n")
	;}
};

frase: NUM ESPACO IGUAL ESPACO NUM	{if($1 == $5){
		printf("Verdadeiro\n");
	} else{
		printf("Falso\n")
	;}
};

frase: NUM ESPACO DIFERENTE ESPACO NUM	{if($1 != $5){
		printf("Verdadeiro\n");
	} else{
		printf("Falso\n")
	;}
};

producao:	 /* vazio */
			| producao frase
			;
						
%%
int main(){
	printf("CTRL+D para terminar:\n");
	yyparse();
  if(numErros==0)
    printf("Frase válida\n");
  else
    printf("Frase inválida\nNúmero de erros: %d\n",numErros);
  return 0;
}

int yyerror(char *s){
  numErros++;
  printf("erro sintatico/semantico: %s\n",s);
}
