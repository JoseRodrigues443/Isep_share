%{
    #include <stdio.h>
    #include <string.h>
	int numErros = 0;
	float dinheiroPago =0;
	float resultado=0;
	float precoBebida =0;
%}

%union {

	float real;
	char* string
	
};



%error-verbose 
%token SEPARADOR
%token <real> MOEDA
%token <string> BEBIDA
%type <real> repeteMoeda
%start frase

%%

repeteMoeda: MOEDA	{dinheiroPago += $1;}
	| repeteMoeda SEPARADOR MOEDA {dinheiroPago += $1 + $3;}
;

tipoBebida: BEBIDA	{

}

;


frase: tipoBebida SEPARADOR repeteMoeda {
	resultado = dinheiroPago - precoBebida;
	
	printf("Troco: %f\n", resultado);
};



%%
int main(){
	yyparse();
	if(numErros==0)
		printf("Frase valida\n");
	else
		printf("Frase invalida\nNumero de erros: %d\n",numErros);
	return 0;
};

int yyerror(char *s){
	numErros++;
	printf("erro sintatico/semantico: %s\n",s);
};



