import java.util.Scanner;

public class basic_566 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int a[] = new int[100];
		int b = sc.nextInt();
		a[0] = 100;
		a[1] = b;
		System.out.printf("%d %d ", a[0], a[1]);

		for(int i=2; i<100; i++) {
			if(a[i-1]>=0) {
				a[i]=a[i-1]-a[i-2];

				System.out.printf("%d ", a[i]);
			}else {
				break;
			}
		}
	}
}
