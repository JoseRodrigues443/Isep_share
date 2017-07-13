%{
    #include <stdio.h>
    #include<string.h>
%}


%{
	#include <stdio.h>
	#include <stdlib.h>

	/* Declarar Variáveis C */
	int numErrors = 0;
	int numMaxAlunos = 0;
	int totalAlunos = 0;
	
	char * nomeDisciplinaComMaisAlunos = NULL;
	char * codCursoAtual = NULL;
	char * nomeFormador = NULL;

	/* Declaração Funções C */
	int yyerror(char *str);
	int yylex (void);
%}

/* Definir Tokens sendo possíveis de guardar */
%union{
	double real; 
	int inteiro;
	char * string;	
}


%token <string> CODIGO_FORMADOR NOME_FORMADOR CODIGO_CURSO NOME_CURSO
%token <inteiro> NUMERO_GENERICO
%type <inteiro> NUM_ALUNOS ANO_CURRICULAR CARGA_HORARIA
%error-verbose

%start FRASE

%%
FRASE:FRASE 	PARTE_1 {printf("%s %s %d Alunos\n TOTAL: %d alunos", nomeFormador, nomeDisciplinaComMaisAlunos, numMaxAlunos, totalAlunos);}
|/*vazio*/
;
	
	
PARTE_1:CODIGO_FORMADOR ' ' '\n' PARTE_2 {strcpy(codCursoAtual,$1);}
|CODIGO_FORMADOR ' ' NOME_FORMADOR '\n' PARTE_2 {strcpy(codCursoAtual,$1);}
;

PARTE_2:CODIGO_CURSO ' ' NOME_CURSO ' ' SUB_PARTE_2 ' ' PARTE_2	{/*codCursoAtual = $1;*/strcpy(codCursoAtual,$1);}
| CODIGO_CURSO ' ' SUB_PARTE_2 ' 'PARTE_2	{strcpy(codCursoAtual,$1);}
 
;

 

SUB_PARTE_2:ANO_CURRICULAR ' ' NUM_ALUNOS ' ' CARGA_HORARIA '\n' {
						if($3 >  numMaxAlunos){
							numMaxAlunos = $3;
							//nomeDisciplinaComMaisAlunos = codCursoAtual;
							strcpy(nomeDisciplinaComMaisAlunos,codCursoAtual);
						}
						totalAlunos+= $3;
						
						
}
;

ANO_CURRICULAR: NUMERO_GENERICO {if($1 > 0 && $1 < 10) {
			$$ = $1;
}}

;

NUM_ALUNOS: NUMERO_GENERICO {if($1 > 0) {
			$$ = $1;
}}

;


CARGA_HORARIA: NUMERO_GENERICO {if($1 > 0 && $1 < 20) {
			$$ = $1;
}}

;



%%






int main(void){
	printf("Terminar com Ctrl+D:\n");
	yyparse();
	printf("F I M\n");
}	


int yyerror(char *str){
	numErrors++;
	printf("\nFalhanços-->%d\n", numErrors);
	printf("Syntax Error : %s\n", str);
	return numErrors;
}



