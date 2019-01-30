import java.util.*;
public class basic_608 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		boolean c_str = false, ab_str = false;
		/*
		for(int i=0;i<str.length();i++){
			if(str.charAt(i) == 'c'){
				c_str = true;
			} else if(str.charAt(i) == 'a' && i + 1 <= str.length() && str.charAt(i+1) == 'b'){
				ab_str = true;
			}
		}
		*/
		if(str.contains("c")) c_str = true;
		if(str.contains("ab")) ab_str = true;

		if(c_str) System.out.print("Yes ");
		else System.out.print("No ");

		if(ab_str) System.out.print("Yes");
		else System.out.print("No");
	}
}
