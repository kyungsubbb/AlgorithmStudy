package algorithm;

import java.util.Scanner;

public class B11724_연결요소의개수 {
	static int N;
	static int M;
	static boolean[][] map = new boolean[1001][1001];
	static boolean[] visited = new boolean[1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int cnt = 0;
		
		for (int i = 0; i < M; i++) {//간선 개수 만큼
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] =  map[y][x] = true;//연결
		}
		
		for (int i = 1; i <= N; i++) {
			if(visited[i] == false) {//방문 안했다면
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

	private static void dfs(int idx) {
		if(visited[idx] == true) {//방문했으면 완료
			return;
		}else {//안했으면
			visited[idx] = true;//방문 해주고
			for (int i = 1; i <= N; i++) {
				if(map[idx][i] == true && !visited[i]) {
					dfs(i);
				}
			}
		}
		
	}

}
