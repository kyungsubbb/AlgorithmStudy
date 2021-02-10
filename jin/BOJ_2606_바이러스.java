package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int[][] com ; //컴퓨터 연결상태 배열
	static boolean[] check; //감염 되었는지 여부
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		int M = Integer.parseInt(input.readLine());
		com = new int[N+1][N+1];
		check = new boolean[N+1];
		
		//입력
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			int a =Integer.parseInt(st.nextToken()); 
			int b =Integer.parseInt(st.nextToken()); 
			com[a][b]=1;
			com[b][a]=1;
		}
		
		System.out.println(BFS(1)); //1번을 통해 바이러스에 걸리는 컴퓨터의 수
	}
	public static int BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		check[start]=true; 							//시작 체크
		q.offer(start);    							//큐에 넣음
		int cnt =0;
		while(!q.isEmpty()) {						//큐가 비어있지 않으면
			int cur = q.poll();						//현재 위치의 변수
			for(int i=1;i<com.length;i++) {
				if(com[cur][i]==1&&!check[i]) {		//현재 컴퓨터와 연결된 모든 컴퓨터를 탐색 (==1)하고 감염되지않았다면
					q.offer(i);						//큐에 집어넣음
					check[i]=true;					//i도 감염체크
					cnt++;							//개수+1
				}
			}
		}
		return cnt;
	}
}
