package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17829_222_풀링 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int t=N;
		for (int k = 1; k <= t; k*=2) {
			for (int i = 0; i < N ; i += 2) {
				for (int j = 0; j < N; j += 2) {
					int[] nums = new int[4];
					nums[0] = map[i][j];
					nums[1] = map[i][j + 1];
					nums[2] = map[i + 1][j];
					nums[3] = map[i + 1][j + 1];
					Arrays.sort(nums);

					map[i / 2][j / 2] = nums[2];
				}
			}
			N=N/2;
		}
		System.out.println(map[0][0]);

	}

}
