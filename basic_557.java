/*
import java.util.*;

public class basic_557 {
	public static void main(String[] args) {

		char[] ch = new char[10];
		Scanner sc = new Scanner(System.in);

		for(int i=0;i<ch.length;i++) {
			String str = sc.next();	// next() --> space or new line 기준으로 문자열 끊는 것 같음.
			ch[i] = str.charAt(1); //10개의 문자 입력받아 저장 charAt(0)을 쓴다는게 이해가 잘 안되는데
		}
		//배열 내용 출력
		System.out.printf(ch[0]+" "+ ch[3]+" "+ch[6]);

	}
}
*/

import java.util.Scanner;

public class basic_557 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String[] a = new String[10]; 
		int i;
		for(i=0; i<10; i++) {
			a[i] = input.next();	// space or new line
		}
		System.out.print(a[0]+" "+a[3]+" "+a[6]);
	}
}
