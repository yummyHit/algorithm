//문자열을 입력받아 알파벳 문자만 모두 대문자로 출력하는 프로그램을 작성하시오. 
//문자열의 길이는 100이하이다.

import java.util.*;
public class basic_600 {
	public static void main(String[] args) {
		String input = new String("My Name is notepad");
		StringTokenizer st = new StringTokenizer(input, " ");
		int count = 0;
		for(count = 0; st.hasMoreTokens(); count++, st.nextToken());
		/*
		count == 0, st == My, count++ / st.nextToken()
		count == 1, st == Name, count++ / st.nextToken()
		count == 2, st == is, count++ / st.nextToken()
		count == 3, st == notepad, count++ / st.nextToken()
		count == 4 --> st.hasMoreTokens() NULL
		*/
		System.out.println(count);
	}
}


/*
import java.util.Scanner;
//공백을 포함한 100글자 이하의 문자열을 입력받아 
//문장을 이루는 단어의 개수를 출력하는 프로그램을 작성하시오.

public class Main{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		int num = 1;

		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == ' ') { //여기서 ''하면 에러가 난다. 반드시 공백이랑 같아야 되는것
				num++;
			}
		}
		System.out.println(num);
	}
}
*/
