import java.util.*;

public class programmers_1 {
	public static boolean solution(int arrA[], int arrB[]) {
		boolean answer = false;
		int bhyoyul[][] = new int[arrA.length][arrA.length];
		int temp;

		for(int i = 0; i < arrA.length; i++) {
			bhyoyul[i] = arrA.clone();
			temp = arrA[arrA.length - 1];
			for(int j = arrA.length - 1; j >= 1; j--)
				arrA[j] = arrA[j - 1];
			arrA[0] = temp;
		}

		for(int i = 0; i < arrA.length; i++)
			if(Arrays.equals(bhyoyul[i], arrB))
				answer = true;

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arrA[] = new int[] {1, 2, 3, 4, 5, 6, 7};
		int arrB[] = new int[] {4, 5, 6, 7, 1, 2, 3};

		System.out.println(solution(arrA, arrB));
	}
}
