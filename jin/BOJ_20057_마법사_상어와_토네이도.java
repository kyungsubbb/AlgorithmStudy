package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057_마법사_상어와_토네이도 {
	static int dx[][] = {
			//
			{-1,1,-2,2,0,-1,1,-1,1,0},
			{-1,-1,0,0,2,0,0,1,1,1},
			{-1,1,-2,2,0,-1,1,-1,1,0},
			{1,1,0,0,-2,0,0,-1,-1,-1}};
	static int dy[][] = {
			{1,1,0,0,-2,0,0,-1,-1,-1},
			{-1,1,-2,2,0,-1,1,-1,1,0},
			{-1,-1,0,0,2,0,0,1,1,1},
			{-1,1,-2,2,0,-1,1,-1,1,0}};
	static int percent[] = {1,1,2,2,5,7,7,10,10};
	static int N,result;
	static int[][] map;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 모래 입력
		// 토네이도 이동경로 계산
		int x = N / 2, y = N / 2;
		int idx = 1;
		int cnt = 1;
		int dir = 0; //좌 , 하, 우, 상
		while (true) {
			if (cnt == N) {
				for (int i = 0; i < cnt-1; i++) {
					y = y - idx;
					method(x,y,dir);
				}
				break;
			}
			// y좌표 이동
			for (int i = 0; i < cnt; i++) {
				y = y - idx;
				method(x,y,dir);
			}
			dir= (dir+1)%4;
			// x좌표 이동
			for (int i = 0; i < cnt; i++) {
				x = x + idx;
				method(x,y,dir);
			}
			idx *= -1;
			cnt++;
			dir= (dir+1)%4;
		}
		
		System.out.println(result);
	}

	// 모래 흩뿌리는 함수
	public static void method(int x,int y,int dir) {
		int sand = map[x][y];
		int tmp = sand;
		
		int nx,ny;
		for(int i=0;i<9;i++) {
			nx = x+dx[dir][i];
			ny = y+dy[dir][i];
			int spread = (sand * percent[i]) /100;
			tmp -= spread;
			if(!check(nx,ny)) {
				result+=spread;
			}else {
				map[nx][ny]+=spread;
			}
		}
		nx = x+dx[dir][9];
		ny = y+dy[dir][9];
		if(!check(nx,ny)) {
			result+=tmp;
		}else {
			map[nx][ny]+=tmp;
		}
		map[x][y]=0;
	}
	public static boolean check(int x,int y) {
		if(x<0||x>=N||y<0||y>=N) return false;
		else return true;
	}
}
