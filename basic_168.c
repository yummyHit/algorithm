#include <stdio.h>

#define MAX_SIZE 11

int main() {
	int num = 0, i = 0, j = 0;
	int arr[MAX_SIZE][MAX_SIZE] = { 0, 1 };
	scanf("%d", &num);
	for(i = 1; i <= num; i++)
		for(j = 1; j <= i; j++)
			arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];

	for(i = num; i > 0; i--) {
		for(j = i; j > 0; j--)
			printf("%d ", arr[i][j]);
		printf("\n");
	}

	return 0;
}
