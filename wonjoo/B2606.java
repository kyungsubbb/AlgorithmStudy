package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//바이러스

/*
7
6
1 2
2 3
1 5
5 2
5 6
4 7*/
public class B2606 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();//바이러스 걸린 애들 저장
		
		int N = Integer.parseInt(br.readLine());//컴퓨터 개수
		int E = Integer.parseInt(br.readLine());//간선 개수
		boolean[][] map = new boolean[N+1][N+1];//연결되었는지 확인
		boolean[] visited = new boolean[N+1];//방문했는지 확인
		
		for (int i = 0; i < E; i++) {//간선 수 만큼 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());//부모 노드
			int b = Integer.parseInt(st.nextToken());//자식 노드
			
			map[a][b] = true;
			map[b][a] = true;
		}
		
		q.add(1);//1은 이미 걸렸으니 넣고
		visited[1] = true;//1번은 방문

		
		while(!q.isEmpty()) {
			int current = q.poll();//요소 꺼내기
			for (int i = 1; i <= N; i++) {
				if(map[current][i] && !visited[i]) {//1번과 연결되어있고, 방문하지 않았으면
					q.add(i);//큐에 추가
					visited[i] = true;
				}
			}
		}	
		int result = 0;

		for (int i = 2; i <= N; i++) {//1을 제외하고
			if(visited[i] == true) {//방문한 노드들 카운트
				result++;
				//System.out.println(i);
			}
		}
		System.out.println(result);
	}

}
