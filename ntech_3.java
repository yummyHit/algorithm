import java.util.*;
import java.util.Scanner;
import java.io.*;

public class ntech_3 {

	public static char [] Solution(String encrypted_text, String key, int rotation) {
		char tmp = 0;
		char array[] = encrypted_text.toLowerCase().toCharArray();
		char array2[] = key.toCharArray();//abcdefghijk

		for(int i=0;i<rotation;i++){
			tmp=array[0];
			for(int len=0;len<array.length-1;len++){
				array[len]=array[len+1];
			}
			array[array.length-1]=tmp;
		}
		for(int i=0;i<array.length;i++){
			array[i]=(char) (array[i]-(array2[i]-96));
			if(array[i]<'a'){
				array[i]=(char) (array[i]+26);
			}
			else if(array[i]>'z')
				array[i]=(char) (array[i]-26);
		}
		return array;
	}
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String encrypted_text =sc.next();
		String key = sc.next();
		int rotation = sc.nextInt();

		System.out.println(Solution(encrypted_text, key, rotation));
	}
}
