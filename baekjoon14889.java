import java.util.*;

public class baekjoon14889{

	static int[][] map;
	static boolean[] visited;
	static int N, min = Integer.MAX_VALUE;

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		map = new int[N][N];
		visited = new boolean[N];

		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				map[i][j] = sc.nextInt();
		go(0,0); //왜 이렇게 하는지 모르겠다.
		System.out.println(min);
	}

	static void go(int start,int depth){
		if(depth == N/2){
			int Ateam = 0, Bteam =0;
			for(int i=0;i<N;i++){
				if(visited[i]==true){
					for(int j=0;j<N;j++)
						if(visited[j]==true){
							if(i==j)
								continue;
							Ateam+=(map[i][j]);
						}
				}else
					for(int j=0;j<N;j++)
						if(visited[j]==false){
							if(i==j)
								continue;
							Bteam+=(map[i][j]);
						}
			}

			min = Math.min(min, Math.abs(Ateam-Bteam));
			return;
		}else{
			for(int i=start;i<N;i++){
				if(visited[i])
					continue;
				visited[i]=true;
				go(i+1,depth+1);
				visited[i]=false;
			}
		}
	}
}
