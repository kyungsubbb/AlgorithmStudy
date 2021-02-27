package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B17829_222풀링 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[1023][1023];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			if (N == 1) {// 1일땐 1뿐이니까
				break;
			}
			for (int i = 0; i < N; i += 2) {// 2칸씩 넘어가면서 확인
				for (int j = 0; j < N; j += 2) {
					int[] tmp = { map[i][j], map[i][j + 1], map[i + 1][j], map[i + 1][j + 1] };
					Arrays.sort(tmp);
					map[i / 2][j / 2] = tmp[2];// 두번째로 큰자리 저장
				}
			}
			N /= 2;
		}
			System.out.println(map[0][0]);
	}
}
