import java.util.Scanner;

public class basic_153 {
	public static void main(String[] args) {

		int [] num = new int[100];
		int n =0;
		Scanner sc = new Scanner(System.in);

		for(int i=0;i<num.length;i++) {
			num[i] = sc.nextInt(); //100개의 정수 입력 받아 배열에 저장
			if(num[i]!=-1) {
				n++; //입력받은 개수 카운트
				continue; //-1이 아니면 계속 입력 받음
			}else {
				if(n == 2) {
					System.out.println(num[n - 2] + " " + num[n - 1]);
				}
				else if(n == 1) {
					System.out.println(num[n - 1]);
				}
				else {
					System.out.println(num[n - 3] + " " + num[n - 2] + " " + num[n - 1]);
				}
				break;
			}
		}
	}
}
