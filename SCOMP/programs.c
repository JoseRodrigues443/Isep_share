#include <stdio.h>
#include "programs.h"
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <unistd.h>

int comparaString(char *primeira , char *segunda){
	int i =0;
	while(*(primeira + i) != '\0' && *(segunda + i) != '\0'){
		if (*(primeira + i) != *(segunda + i) ){
			return 1;   /*diferente*/
		}
	}

	return 0;	/*igual*/
}

int catFile(void){
/*	char pasta[60] = "./backup";*/
/*	char comando[20] = "cp";*/
	int fd[2];
	char cat[20] = "cat";
	char sort[20] = "cp";
	
	printf("\nBegin:\n");
	char textoInserido[60] = "nada";
	char saida[60] = "exit";
	int sonStatus;
	
	pid_t pid;
	int toReturn = 0;
	int i =0;
	
	do{	/*diferente de sair*/
		printf("Que ficheiro pretende? (exit para sair):");
		scanf("%s",textoInserido);
		
		pid = fork(); 
		i++;
	
	
		if (pid > 0) {	/*papa*/
/*			printf("\nPai\n");*/
			waitpid(pid, &sonStatus, 0);
				if (!WIFEXITED(sonStatus)) {
					perror("\n______________A sair______________\n");
				}
		} else if (pid == -1) { 	/*erro*/
			perror("erro\n");
			exit(-1);
		
		}else{ /*if filho */

			if (i==0){	/*filho 1*/
				
				toReturn = execlp(cat, cat,"fx.txt",(char*)NULL);
			}else if (i==1) 	/*filho 2*/{
				toReturn = execlp(sort, sort, (char*)NULL);
			}
		}
	}while(comparaString(saida , textoInserido)==1);
	return toReturn;
}




