package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1987_알파벳 {
	static int R;// 세로
	static int C;// 가로
	static char[][] map;// 보드
	static boolean[] visited;
	static int[] dx = { -1, 1, 0, 0 };// 상하좌우
	static int[] dy = { 0, 0, -1, 1 };// 상하좌우
	static int max = 0;// 갈 수 있는 칸의 최대 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[26];// 알파벳 개수

		for (int i = 0; i < R; i++) {
			String s = br.readLine();//문자 한 줄 읽기
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		dfs(0, 0, 0);// (x, y), 이동 횟수

		System.out.println(max);

	}

	public static void dfs(int x, int y, int cnt) {
		if (visited[map[x][y]]) {// 방문했다면
			max = Math.max(max, cnt);// 최대값 갱신
			return;// 조건 만족하면 리턴
		} else {
			visited[map[x][y]] = true;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
					dfs(nx, ny, cnt + 1);
				}
			}	
			visited[map[x][y]] = false;
		}
	}
}
