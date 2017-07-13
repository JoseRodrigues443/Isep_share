#define BUFFER_SIZE 121
#define WORD_SIZE 51
#define SHM_NAME "/shm_ex06"

typedef struct {
	char path_to_file[BUFFER_SIZE];
	char word_to_search[WORD_SIZE];
	int occurence_number;
}Array_Struct;
