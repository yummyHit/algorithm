import java.util.Scanner;

public class basic_187 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();	// 입력받음
		StringBuilder sb = new StringBuilder(input);	// input 이라는것을 매개변수
		// 완벽한 String 이 아니라 Builder 를 이용하는 것

		while(true) {
			int num = sc.nextInt();
			if(num > sb.length()) num = sb.length();	// word 라는 4글자가있는데 우리가 5 를 입력하면 마지막번째를 지워주어야 하므로 length() 로 바꿔줘버림(현재 length()는 4)
	//		입력받은값이 word 였어
	//		그리고 10 을입력받으면 글자수를 넘어가기때문에 글자수로 치환해줌.
	//		마지막글자를 지우기 위함.
			sb.deleteCharAt(num - 1);	// num - 1 : index 가 되는것이고,
										// -1 을 해준 이유는 index 는 0부터이고, 우리가 입력받아서 지우려는 포인트는 몇번째 문자인지(글자위치)가 들어가기 때문에.
			System.out.println(sb.toString());
			if(sb.length() == 1)
				break;
		}
	}
}
