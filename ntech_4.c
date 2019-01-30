#include <stdio.h>
#include <stdlib.h>

#define MAX_K_VALUE 50000000000000

int main() {
	int i = 1;
	long int sum = 0, k = 0, pre = 0;
	printf("Enter k value: ");
	scanf("%ld", &k);
	if(k < 1 || k > MAX_K_VALUE) {
		fprintf(stderr, "Out of range. Please enter 1 ~ 50000000000000 number\n");
		exit(1);
	}

	while(1) {
		sum += i++;
		if(k > pre && k <= sum) {
			printf("%ld\n", k - pre);
			break;
		}

		if(sum > MAX_K_VALUE) break;
		pre = sum;
	}
	return 0;
}
