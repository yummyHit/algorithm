//문자열을 입력받아 알파벳 문자만 모두 대문자로 출력하는 프로그램을 작성하시오. 
//문자열의 길이는 100이하이다.

import java.util.Scanner;
public class basic_599 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String n = input.next();
		char [] arr = new char[100];

		for(int i=0;i<n.length();i++) {
			//배열에 문자열 문자 하나씩 저장
			arr[i] = n.charAt(i);
			// "Hello"
			//arr[0] == 'H'
			//arr[1] == 'e'
			//arr[2] == 'l' ...
			//그 문자의 아스키코드
			//만약 코드가 알파벳 소문자라면
			if(arr[i] >= 97 && arr[i] <= 122) {
				//대문자로 바꾸어 줌
				System.out.print(Character.toString(arr[i]).toUpperCase());
				//코드가 알파벳 대문자라면
			}
			else if(arr[i]>=65 && arr[i] <=90) {
				//그냥 출력
				System.out.print(arr[i]);
			}
		}
	}
}
