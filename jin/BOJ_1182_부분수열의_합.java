package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의_합 {
	
	static int N,S,cnt;
	static int[] arr;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr=new int[N];
		st = new StringTokenizer(input.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		DFS(0,0);
		
		if(S==0) {
			cnt--;
			System.out.println(cnt);
		}else {
			System.out.println(cnt);
		}
	}
	
	static void DFS(int idx, int sum) {
		if(idx == N) {
			if(sum == S) cnt++;
			return;
		}
		DFS(idx+1, sum+arr[idx]);
		
		DFS(idx+1, sum);
	}
}
