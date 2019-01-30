import java.util.Scanner;

public class ntech_2 {

	//number convert korean
	private String[] number_labels = {"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
	private String[] range_labels = {"", "십", "백", "천", "만"};
	public static int length;

	public String solution(int num) {
		int rangeCount = length-1;
		int rawValue = Integer.valueOf(num);
		StringBuilder result = new StringBuilder();
		while(rangeCount >= 0) {
			int mod = 1;
			switch(rangeCount) {
				case 4:
					mod *= 10;
				case 3:
					mod *= 10;
				case 2:
					mod *= 10;
				case 1:
					mod *= 10;
					break;
				default: 
					break;
			}
// 입력값: 20134 
// length == 5
// rangeCount == 4 == length-1
// 첫번째 mod == 10^4 == 10000
// number_lables[20134 / 10000] --> number_lables[2] ==	number_lables[1] == "이"
// rawValue = 20134 % 10000 == 134
// 두번째 mod == 10^3 == 1000
// number_lables[134 / 1000] --> number_lables[0] == "" + "백"
			System.out.println(range_labels[3]);
			if(rawValue/mod !=1)	// 이 if 문은 "일", "이" .. 붙이기 위한
				result.append(number_labels[rawValue/mod]);

			if(rawValue/mod >0) {	// 이 if 문은 "백", "천" .. 붙이기 위한
				result.append(range_labels[rangeCount]);
			}

			if(rangeCount == 0 && rawValue == 1)
				result.append("일");

			rawValue = rawValue % mod;
			rangeCount--;
		}

//		if((num)%10==1) {	// 일의 자리에 "일" 을 넣어주기 위함.
//			result.append("일");
//		}
		// System.out.println(result.toString());
		return result.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt(); 
		length = Integer.toString(input).length();

		ntech_2 sol = new ntech_2();
		System.out.println(sol.solution(Integer.valueOf(input)));
	}
}
