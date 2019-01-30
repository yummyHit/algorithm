//문자를 입력받아 알파벳 문자인 경우에는 그대로 출력하고 숫자인 경우는 아스키코드값을 출력하는 작업을 반복하다가 기타의 문자가 입력되면 종료하는 프로그램을 작성하시오.
//* 입출력예에서 진한글씨가 출력
import java.util.Scanner;

public class basic_598 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		String n;
		while(true){
			n = input.next();
			char ch = n.charAt(0);
			int code = (int)ch;

			if(code>=65 && code<=90 || code>=97 && code<=122){
				System.out.println(ch);
			}
			else{
				try{
					System.out.println("hello");
					int a = Integer.parseInt(n);
					System.out.println(code);
				}
				catch(NumberFormatException e){
					System.out.println("Not Number, Not Alphabet!!");
					break;
				}
			}
		}
	}
}
