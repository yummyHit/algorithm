import java.util.Scanner;

public class basic_569 {
	public static final int ROW_MAX = 5;
	public static final int COL_MAX = 4;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int arr[][] = new int[ROW_MAX][COL_MAX];
		int sum = 0, avg = 0, count = 0;

		for(int row = 0; row < 5; row++) {	
			sum = 0; avg = 0;
			for(int col = 0; col < 4; col++) { // col: 0 ~ 3
				arr[row][col] = sc.nextInt();
				sum += arr[row][col];
			}
			avg = sum / 4;
			if(avg >= 80) {
				System.out.println("pass");
				count++;
			}
			else
				System.out.println("fail");
		}
		System.out.printf("Successful: %d", count);
	}
}
