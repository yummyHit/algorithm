import java.util.*;

public class kakao_openchat {
	public static void main(String[] args){

		String[] arr = solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
		for(int i=0;i<arr.length;++i)
			System.out.println(arr[i]);
	}

	public static String[] solution(String[] record){
		String[] answer = null;
		HashMap<String,String> idNick = new HashMap<String, String>();
		String[][] splitR = new String[record.length][2];
		int row =0;
		for(int i=0;i< splitR.length;++i)
		{
			splitR[row] = record[i].split(" ");
			if(splitR[row][0].equals("Enter")||splitR[row][0].equals("Change"))
			{
				idNick.put(splitR[row][1],splitR[row][2]);
			}
			if(splitR[row][0].equals("Enter")||splitR[row][0].equals("Leave"))
			{
				row++;
			}
		}
		answer = new String[row];
		int count =0;
		for(int i=0;i<row;++i)
		{
			if(splitR[i][0].equals("Enter"))
			{
				answer[count++] = idNick.get(splitR[i][1])+"님이 들어왔습니다.";

			}
			else if(splitR[i][0].equals("Leave"))
			{
				answer[count++] = idNick.get(splitR[i][1])+"님이 나갔습니다.";
			}
		}
		return answer;
	}
}
