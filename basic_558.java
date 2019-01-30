import java.util.Scanner;

public class basic_558 {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);

		int num[] = new int[100];
		int num01, i;
		for(i=0; i<100; i++) {
			num01 = sc.nextInt();

			if(num01 == 0) {
				break;
			}
			num[i] = num01;  
		}
		// 입력값이 "10, 20, 30, 40, 50, 0" 일 때, 마지막으로 빠져나오는 당시 i 값은 5
		// 즉, 		0, 1, 2, 3, 4, 5 번째 index 값이니 마지막으로 나오는 i 값은 5
		// num01 = i; 5 까지 들어가니까, 나중에 출력할 때 0, 50, 40, 30, 20, 10 이 나오므로
		// num01 = i - 1; 을 해준 것. 그럼 num01 은 4번째 인덱스를 가지고 5 부터 아래로 출력할 수 있음.
		num01 = i - 1;
		for(i=num01; i >= 0; i--) {
			// i = num01 을 해주었으니, i = 4 가 되고, 4 부터 -- 씩 해주므로, 4, 3, 2, 1, 0 번째 인덱스를
			// 출력하게 함.	즉 값으로는 50, 40, 30, 20, 10 값이 출력 됨.
			System.out.printf("%d ", num[i]);    
		}
	}
}
