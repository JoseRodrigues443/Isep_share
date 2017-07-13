%{
    #include <stdio.h>
%}

%error-verbose	//ajuda depura��o erros
%token INT
%start regra

%%

regra: /*vazio*/
	| regra expressao '\n' {printf("O resultado �: %d\n",$2);} 	//recursividade!
	;

expressao:  operando '+' operando    {$$=$1+$3;}
	   | operando '-' operando    {$$=$1-$3;}
	   | operando '*' operando    {$$=$1*$3;}
	   | operando '/' operando    {if($3!=0) $$=$1/$3; 
									else {printf("�divis�o por ZERO!�"); $$=0;}
								  }
	   ;

operando: INT {$$=$1;}
          ;

%%

int main(){
  printf("Terminar com Ctrl+D:\n");
  yyparse();
  printf("F I M\n");
}

int yyerror(char *s){
  printf("erro sintatico/semantico: %s\n",s);
}
