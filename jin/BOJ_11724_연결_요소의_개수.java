package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724_연결_요소의_개수 {
	static ArrayList<Integer>[] arr;
	static boolean[] visit;
	
	static int N,M;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		N = Integer.parseInt(st.nextToken()); //노드
		M = Integer.parseInt(st.nextToken()); //엣지
		
		arr =  new ArrayList[N+1];
		visit = new boolean[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i]= new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(input.readLine());
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	arr[x].add(y);
        	arr[y].add(x);
    	}
		//System.out.println(Arrays.deepToString(arr));
		
		int cnt=0;
		//System.out.println(arr[1].get(0));
		for(int i=1;i<=N;i++) {
			if(!visit[i]) { //visit[i]가 false 이면 DFS 시작
				DFS(i);     //연결요소를 모두 방문하고
				cnt++;		//cnt 1 증가
			}
		}
		System.out.println(cnt);
		
	}//main
	public static void DFS(int start) {
		visit[start]=true; // start 방문
		
//		for(int i=0;i<arr[start].size();i++) {
//			if(!visit[arr[start].get(i)]) {
//				DFS(i);
//			}
//		}
		ArrayList<Integer> nodes = arr[start];
		for(Integer node : nodes) { //배열 start 번째 요소에 연결된 정점들
			if(!visit[node]) {		// 모두
				DFS(node);			// 방문
			}
		}
	}
}
