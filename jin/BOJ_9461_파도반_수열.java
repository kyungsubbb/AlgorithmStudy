package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9461_파도반_수열 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(input.readLine());
		for(int tc=1;tc<=T;tc++) {
			int N=Integer.parseInt(input.readLine());
			long[] dp = new long[101];
			dp[1]=1;
			dp[2]=1;
			dp[3]=1;
			for(int i=4;i<=N;i++) {
				dp[i]=dp[i-2]+dp[i-3];
			}
			System.out.println(dp[N]);
		}//tc
	}//main

}
