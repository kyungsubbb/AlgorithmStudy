package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9372_상근이의_여행 {
	static int N, M, result;
	static boolean visit[];
	static int arr[][];
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
	        int T = Integer.parseInt(input.readLine());
	        for(int tc=0; tc<T; tc++) {
	            StringTokenizer st = new StringTokenizer(input.readLine());
	            N = Integer.parseInt(st.nextToken());
	            M = Integer.parseInt(st.nextToken());
	            result = 0;
	            
	            arr = new int[N+1][N+1];
	            visit = new boolean[N+1];
	            for(int i=0; i<M; i++) {
	                st = new StringTokenizer(input.readLine());
	                int u = Integer.parseInt(st.nextToken());
	                int v = Integer.parseInt(st.nextToken());
	                arr[u][v] = 1;
	                arr[v][u] = 1;
	            }
	            BFS();
	            System.out.println(result-1);
	        }
	    }

	private static void BFS() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visit[1] = true;
		while (!queue.isEmpty()) {
			result++;
			int val = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (arr[val][i] != 0 && !visit[i]) {
					visit[i] = true;
					queue.add(i);
				}
			}
		}
	}
}
