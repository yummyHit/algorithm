#include <stdio.h>
#include <stdio_ext.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE 1024

typedef struct user_table {
	int method;
	char *userid;
	char *value;
	int data;
}USER;

enum {
	GET = 1,
	POST = 2,
	OK = 200,
	CREATED = 201,
	FORBIDDEN = 403,
	NOT_FOUND = 404,
	METHOD_NOT_ALLOWED = 405,
};

int main() {
	int num = 0, count = 0, i = 0, method = 0;
	USER user[MAX_SIZE / 16];

	printf("number: ");
	scanf("%d", &num);
	__fpurge(stdin);
	count = num;
	while(num > 0) {
		char buf[MAX_SIZE] = {0,};
		fgets(buf, sizeof(buf), stdin);
		if(!strncmp(buf, "GET", 3))
			method = GET;
		else if(!strncmp(buf, "POST", 4))
			method = POST;
		else {
			fprintf(stderr, "Wrong Method!\n");
			continue;
		}

		char *ptr = NULL, *rptr = NULL, *tmp = NULL, *rtmp = NULL;
		if(method) {
			user[i].method = method;
			user[i].userid = NULL;
			user[i].value = NULL;
			user[i].data = 0;
			for(ptr = strtok_r(buf, " ", &rptr); ptr; ptr = strtok_r(NULL, " ", &rptr)) {
				if(!strncmp(ptr, "GET", 3) || !strncmp(ptr, "POST", 4)) 
					continue;
				else if(!strncmp(ptr, "value", 5)) {
					strtok_r(ptr, "=", &tmp);
					user[i].value = malloc(sizeof(char) * strlen(tmp));
					strncpy(user[i].value, tmp, strlen(tmp));
					break;
				}
				else if(!strncmp(ptr, "/users/", 7)) {
					strtok_r(ptr, "/", &tmp);
					rtmp = strtok_r(NULL, "/", &tmp);
					user[i].userid = malloc(sizeof(char) * strlen(rtmp));
					strncpy(user[i].userid, rtmp, strlen(rtmp));
					if(!strncmp(tmp, "data", 4))
						user[i].data = OK;
				}
			}
			i++;
		}
		num--;
	}

	i = 0;
	num = count;
	while(num > 0) {
		method = 0;
		if(user[i].method == POST) {
			for(int j = 0; j < count; j++)
				if(i != j && user[j].method == POST && user[i].userid && user[j].userid && !strncmp(user[i].userid, user[j].userid, sizeof(user[j].userid))) {
					method = FORBIDDEN;
					break;
				}
			if(method == FORBIDDEN)
				printf("%d FORBIDDEN\n", FORBIDDEN);
			else
				if(user[i].value == NULL)
					printf("%d CREATED\n", CREATED);
				else
					printf("%d OK\n", OK);
		}
		else if(user[i].method == GET) {
			for(int j = 0; j < count; j++)
				if(i != j && user[j].method == POST && user[i].userid && user[j].userid && !strncmp(user[i].userid, user[j].userid, sizeof(user[j].userid))) {
					method = OK;
					if(user[j].value == NULL)
						printf("%d NOT_FOUND\n", NOT_FOUND);
					else if(user[j].value != NULL && user[j].data != OK)
						printf("%d METHOD_NOT_ALLOWED\n", METHOD_NOT_ALLOWED);
					else
						printf("%d OK %s", OK, user[j].value);
					break;
				}
			if(method != OK)
				printf("%d FORBIDDEN\n", FORBIDDEN);
		}
		i++;
		num--;
	}
}
