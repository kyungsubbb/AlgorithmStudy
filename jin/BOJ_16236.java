package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_16236 {

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		int N = Integer.parseInt(input.readLine());

		int[][] map = new int[N][N];
		LinkedList<Shark> q = new LinkedList<>(); // 탐색을 탐는 큐

		int size = 2;
		for (int i = 0; i < N; i++) {
			String[] str = input.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (map[i][j] == 9) {
					q.add(new Shark(i, j, size));
					map[i][j] = 0;
				}
			}
		}
		int eat = 0;
		int time = 0;
		// 검색
		while (true) {
			LinkedList<Shark> fish = new LinkedList<>(); // 물고기를 담는 큐
			int[][] dist = new int[N][N]; // 상어의 위치로부터 각 칸의 이동거리를 담는 배열

			//정보만 담는 queue를 채워넣기 위 한 while문
			while (!q.isEmpty()) { // queue 가 비어있지 않으면 실행

				// queue 를 꺼내고 좌표를 입력
				Shark s = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = s.x + dx[i];
					int ny = s.y + dy[i];

					// nx,ny <- 다음좌표

					// 좌표가 맵의 크기안에 있고, 이동거리를 표시하지 않았고, 상어의 크기 보다 작다 -> 이동가능
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && dist[nx][ny] == 0 && map[nx][ny] <= size) {
						dist[nx][ny] = dist[s.x][s.y] + 1; // 현재의 이동거리보다 한칸 증가
						
						// 1~6 물고기의 크기 이고, 현재상어의 크기보다 작다면 -> 이동가능
						if (1 <= map[nx][ny] && map[nx][ny] <= 6 && map[nx][ny] < size) {
							fish.add(new Shark(nx, ny, dist[nx][ny])); // 물고기큐에 넣음
							q.add(new Shark(nx, ny, dist[nx][ny])); // 탐색 큐에 넣음
							continue;
						}
						q.add(new Shark(nx, ny, dist[nx][ny]));
					}
				}
			}
			// 물고기들이 없으면 종료
			if (fish.size() == 0) {
				System.out.println(time);
				return;
			}
			Shark dFish = fish.get(0);
			
			//물고기 큐의 첫번째 위치를 입력받은 후
			// 나머지큐의 거리가 가장 짧은 물고기를 dFish에 넣는다
			for (int i = 1; i < fish.size(); i++) {
				if (dFish.dist > fish.get(i).dist) {
					dFish = fish.get(i);
				}

				//거리가 동일하다면 위쪽 우선이기 때문에 x값이 더 작은 물고기를 dFish에 넣는다
				if (dFish.dist == fish.get(i).dist) {
					if (dFish.x > fish.get(i).x) {
						dFish = fish.get(i);
						continue;
					} else if (dFish.x == fish.get(i).x) { // x값도 같다면 왼쪽 우선이기 때문에  y값이 더 작은 물고기를 넣는다
						if (dFish.y > fish.get(i).y)
							dFish = fish.get(i);
					}
				}
			}
			// 가장 가깝고 먹을 수 있는 물고기를 찾으면

			time += dFish.dist; //이동거리만큼 time을 늘리고
			eat++;
			map[dFish.x][dFish.y] = 0; // 먹은 물고기 자리 0 으로
			
			//자기 사이즈 만큼 먹어야 사이즈 업
			if (eat == size) {
				size++;
				eat = 0;
			}
			q.add(new Shark(dFish.x, dFish.y, size)); // 먹은 물고기 자리에서부터 다시 시작

		}

	}// main
}

class Shark {
	int x;
	int y;
	int dist;

	public Shark(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
