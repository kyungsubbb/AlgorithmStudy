package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
//섬의 개수
public class B4963 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(br.readLine());

		int[] dx = { -1, 1, 0, 0, -1, 1, 1, -1 };// 좌상, 우상, 우하 , 좌하
		int[] dy = { 0, 0, -1, 1, -1, -1, 1, 1 };

		int cnt = 0;//개수 구할 변수
//		for (int tc = 1; tc <= 6; tc++) {
		//while 넣어서 00 나왔을 때 종료

			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int[][] map = new int[n1][n2];
			boolean[][] visit = new boolean[n1][n2];

			for (int i = 0; i < n1; i++) {
				st = new StringTokenizer(br.readLine()," ");//새로 한 줄 받기
				for (int j = 0; j < n1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					for (int k = 0; k < 8; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (nx >= 0 && ny >= 0 && nx < n1 && ny < n2 && map[nx][ny] == 1 && !visit[nx][ny]) {
							visit[nx][ny] = true;
						}
					}
					if (map[i][j] == 1 && !visit[i][j]) {
						visit[i][j] = true;
						cnt++;
					}
				}
			}
			System.out.println(cnt);

//		}
	}
}
