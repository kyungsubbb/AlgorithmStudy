package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와_링크 {
	static int N;
	static int[][] map;
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		comb(0, 0);
		System.out.println(min);
	}

	static void comb(int cnt, int start) {
		if (cnt == N / 2) {
			diff();
			return;
		}
		for (int i = start; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				comb(cnt + 1, i + 1);
				visit[i] = false;
			}
		}
	}

	static void diff() {
		int start=0;
		int link =0;
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(visit[i]==true && visit[j] ==true) {
					start+=map[i][j];
					start+=map[j][i];
				}
				if(visit[i]==false && visit[j] ==false) {
					link+=map[i][j];
					link+=map[j][i];
				}
			}
		}
		int value = Math.abs(start-link);
		min = Math.min(value, min);
	}

}
