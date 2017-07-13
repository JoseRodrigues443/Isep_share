#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <time.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <sys/mman.h>
#include <fcntl.h>
#include "ex06.h"

#define NUM_CHILDS 10

int main(int argc, char* argv[]){

	char *palavras[] = {"casa","Ramalhete","Maias","paredes","onde","os","casarao","pela","um","nome"}; /* palavras definidas para procurar */
	pid_t pid;
	int data_size = sizeof(Array_Struct) * NUM_CHILDS;
	int fd = shm_open(SHM_NAME, O_CREAT | O_RDWR, S_IRUSR | S_IWUSR);
		
	if(fd<0){
		perror("Erro na leitura da memoria partilhada!\n");
		exit(1);
	}
	if(ftruncate(fd, data_size) < 0){
		perror("Erro na alocação do espaço! \n");
		exit(2);
	}

	Array_Struct* shared_data = (Array_Struct*) mmap(NULL, data_size, PROT_READ | PROT_WRITE , MAP_SHARED, fd, 0);

	if(shared_data == NULL){
		perror("Não foi possivel criar o apontador da estrutura definida! \n");
		exit(3);
	}
	
	int i;
	for(i = 0; i < NUM_CHILDS; i++){ /* cria os filhos necessarios */
		pid = fork();
		if(pid < 0) {
			perror("Fork falhou");
			exit(-1);
		}else if(pid > 0){
			char path[BUFFER_SIZE];
			sprintf(path, "./files/file%d.txt", i+1);
			strcpy(shared_data[i].path_to_file, path);
			strcpy(shared_data[i].word_to_search, palavras[i]);
			shared_data[i].occurence_number = 0; /* inicializa a 0 de modo a poder contar o numero de ocurrencias */
		} else if(pid == 0){
			break; /* se for filho sai */
		}
	}

	if(pid > 0){ /* PAI */
		for(i = 0; i < NUM_CHILDS; i++){
			wait(NULL);
		}
		for(i = 0; i < NUM_CHILDS; i++){
			printf("No %dº filho, a palavra '%s' foi encontrada %d vezes\n", i, shared_data[i].word_to_search, shared_data[i].occurence_number);
		}
	}

	else if(pid == 0){ /* filho */
		char word[WORD_SIZE];
		FILE *fp;
		fp = fopen(shared_data[i].path_to_file, "r");
		if(fp == NULL){
			perror("Ficheiro nao encontrado");
			exit(8);
		}
		while(fscanf(fp, "%s", word) != EOF) { /* le do ficheiro para a variavel frase */
			if(memcmp(word, shared_data[i].word_to_search, strlen(shared_data[i].word_to_search)) == 0){ /* compara os primeiros n bytes da string, neste caso sera o tamaho da palavra a procurar */
				shared_data[i].occurence_number++;
			}
		}
		exit(10);
	}
		
	if(munmap(shared_data, data_size) < 0){
		perror("Erro no desmapeamento da memoria partilhada\n");
		exit(4);
	}
	
	if(close(fd) < 0){
		perror("Erro no fecho da memoria partilhada\n");
		exit(5);
	}

	if(shm_unlink(SHM_NAME) < 0){
		perror("Erro na remoção do ficheiro da memoria partilhada! \n");
		exit(6);
	}
	
	return 0;
}