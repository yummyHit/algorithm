import java.util.*;

public class line_30pts {
	public static void main(String[] args) {
		String[] arr = solution(new String[]{
			"POST /users/CONY", 
			"POST /users/BROWN", 
			"POST /users/CONY/data value=WEHRE_IS_SALLY", 
			"GET /users/CONY/data", 
			"GET /users/BROWN/data", 
			"GET /users/EDWARD/data", 
			"GET /abc", 
			"GET /users/CONY"});
		for(int i = 0; i < arr.length;++i)
			System.out.println(arr[i]);
	}

	public static String[] solution(String[] record) {
		String[] answer = new String[record.length];
		HashMap<String, String> map = new HashMap<String, String>();
		String[][] splitR = new String[record.length][3];
		int row = 0;
		for(int i = 0; i < splitR.length; ++i) {
			splitR[row] = record[i].split(" ");
			if(splitR[row][0].equals("POST")) {
				if(splitR[row][1].contains("/users/"))
					splitR[row][1] = splitR[row][1].replace("/users/", "");
				else
					splitR[row][1] = splitR[row][1].replaceAll(".*", "null");

				if(splitR[row][1].equals("null"))
					map.put(splitR[row][1], null);

				if(!splitR[row][1].contains("/data") && !map.containsKey(splitR[row][1])) {
					map.put(splitR[row][1], null);
					answer[row] = "201 CREATED";
				}

				if(splitR[row][1].contains("/data") && map.containsKey(splitR[row][1].split("/")[0]) && splitR[row][2] != null) {
					map.put(splitR[row][1].split("/")[0], splitR[row][2].split("=")[1]);
					answer[row] = "200 OK";
				}

				row++;
			}
		}

		for(int i = 0; i < splitR.length; ++i) {
			splitR[row] = record[i].split(" ");
			if(splitR[row][0].equals("GET")) {
				if(splitR[row][1].contains("/users/"))
					splitR[row][1] = splitR[row][1].replace("/users/", "");
				else
					splitR[row][1] = splitR[row][1].replaceAll(".*", "null");

				System.out.println(splitR[row][1]);

				if(splitR[row][1].equals("null"))
					answer[row] = "404 NOT_FOUND";
				else if(!map.containsKey(splitR[row][1].split("/")[0]))
					answer[row] = "403 FORBIDDEN";
				else if(splitR[row][1].contains("/data") && map.containsKey(splitR[row][1].split("/")[0]))
					if(map.get(splitR[row][1].split("/")[0]) != null)
						answer[row] = "200 OK " + map.get(splitR[row][1].split("/")[0]);
					else
						answer[row] = "404 NOT_FOUND";

				row++;
			}
		}
		return answer;
	}
}
