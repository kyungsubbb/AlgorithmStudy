package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963 {
	static int h, w;

	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static int[][] map;
	static boolean[][] visit;

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws IOException {

		while(true) {
		StringTokenizer st = new StringTokenizer(input.readLine());

		// 입력
		w = Integer.parseInt(st.nextToken()); // 너비 (열의 개수) j y
		h = Integer.parseInt(st.nextToken()); // 높이 (행의 개수) i x

		if(w==0&&h==0)break;
		
		map = new int[h][w]; // [x][y] [i][j]
		visit = new boolean[h][w];

		Queue<int[]> q = new LinkedList<int[]>();

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(input.readLine());
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					q.offer(new int[] { i, j }); //맵의 1인 값들을 큐에 넣음
			}
		}

		int cnt = 0;
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];

			q.poll();

			if (visit[x][y]) //첫 방문때 이미 같은 섬이라면 방문표시를 모두 해두기 때문에 같은 섬의 옆위치에서 큐가 시작되었더라도 if문을 만나 다음 while문으로
				continue;

			DFS(x, y); //DFS 시작 
			cnt++;
		}
		output.append(cnt + "\n");
		}
		System.out.println(output);
	}

	public static void DFS(int x, int y) {
		visit[x][y] = true; //현재위치 방문 true

		for (int i = 0; i < 8; i++) { //8방탐색
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= h || ny >= w) //범위 밖 continue
				continue;
			if (map[nx][ny] == 0) // 0이면 continue
				continue;
			if (visit[nx][ny]) // 방문했으면 continue
				continue;
			DFS(nx,ny); // 다음 nx ny 위치 탐색
		}
	}

}
