package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904_01타일 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		int[] dp = new int[N];
		dp[0] = 1;
		if (N > 1) {
			dp[1] = 2;
			for (int i = 2; i < N; i++) {
				dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
			}
		}
		System.out.println(dp[N - 1]);
	}
}
