#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_SIZE 1000

int main(int argc, char *argv[]) {
	int rotation_time = 0, i = 0, j = 0, length = 0;
	char file_contents[MAX_SIZE] = {0,}, key[MAX_SIZE] = {0,};
	FILE *fp = NULL;

	if(argc < 4) {
		fprintf(stderr, "Usage: %s <plain_text> <key> <rotation times>\n", argv[0]);
		exit(1);
	} else {
		rotation_time = strtol(argv[3], NULL, 10);
		if(rotation_time < -1000 || rotation_time > 1000) {
			fprintf(stderr, "Out of range rotation times! range(-1000 ~ 1000)\n");
			exit(1);
		} else
			strncpy(key, argv[2], sizeof(key));
	}

	fp = fopen(argv[1], "r");
	if(fp == NULL) {
		fprintf(stderr, "%s file doesn't exist!\n", argv[1]);
		exit(1);
	}

	while(fread(file_contents, 1, sizeof(file_contents), fp)); 
	length = strlen(file_contents) - 1;
	file_contents[length] = '\0';

	if(length != strlen(argv[2])) {
		fprintf(stderr, "The length of encrypt text and key are diffrent!\n");
		fclose(fp);
		exit(1);
	} else {
		while(file_contents[i]) {
			file_contents[i] = tolower(file_contents[i]);
			i++;
		}
		i = 0;
	}

	printf("########## input data ##########\n");
	printf("encrypt text\n --> %s\n", file_contents);
	printf("key\n --> %s\n", key);

	for(i = 0; i < rotation_time; i++) {
		char tmp = file_contents[0];
		for(j = 1; j < length; j++)
			file_contents[j - 1] = file_contents[j];
		file_contents[j - 1] = tmp;
	}

	printf("####### after rotation #########\n");
	printf(" --> %s\n", file_contents);

	i = 0;
	while(file_contents[i]) {
		file_contents[i] -= tolower(key[i]) - 96;
		if(file_contents[i] < 'a') file_contents[i] += 26;
		else if(file_contents[i] > 'z') file_contents[i] -= 26;
		i++;
	}

	printf("######## after decrypt #########\n");
	printf(" --> %s\n", file_contents);

	return 0;
}
