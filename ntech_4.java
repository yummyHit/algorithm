import java.util.Scanner;

public class ntech_4 {
	public static final long MAX_K_VALUE = 50000000000000L;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int i = 1;
		long sum = 0, k = 0, pre = 0;
		System.out.print("Enter k value: ");
		k = sc.nextInt();

		if(k < 1 || k > MAX_K_VALUE)
			System.out.println("Out of range. Please enter 1 ~ 50000000000000 number\n");
		else {
			while(true) {
				sum += i++;
				if(k > pre && k <= sum) {
					System.out.println(k - pre);
					break;
				}

				if(sum > MAX_K_VALUE) break;
				pre = sum;
			}
		}
	}
}
