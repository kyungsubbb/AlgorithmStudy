package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어_벨트_위의_로봇 {
	static int N, K;
	static int[] belt;
	static boolean[] exist;
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(input.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[N*2];
		exist = new boolean[N];
		st = new StringTokenizer(input.readLine());
		for(int i=0;i<N*2;i++) {
			belt[i]=Integer.parseInt(st.nextToken());
		}
		int cnt=0;
		do {						//종료되었을 때 몇단계에서 종료되었는지를 출력하기 때문에  do while문으로 구성
			cnt++;
			rotate(); 				//1. 벨트가 한 칸 회전한다
			check();				//2. 로봇이 이동할 수 있다면 이동 , 3.올라가는 위치에 로봇이 없다면 로봇을 하나 올림
		}while(!(count()>=K));		//4. 내구도가 0인 칸의 개수가 K개 이상이라면 종료			
		System.out.println(cnt);	 
	}
	
	//회전
	private static void rotate() {
		int tmp= belt[N*2-1];
		for(int i=N*2-1;i>0;i--) {
			belt[i]=belt[i-1];
		}
		belt[0]=tmp;
		for(int i=N-2;i>=0;i--) {
			exist[i+1]=exist[i];
		}
		exist[0]=false;
		if(exist[N-1])exist[N-1]=false;
	}
	
	//로봇 옮기기, 떨어뜨리기, 올리기
	private static void check() {
		for(int i=N-2;i>=0;i--) {
			if(exist[i]&&!exist[i+1]&&belt[i+1]>=1) {
				exist[i]=false;
				exist[i+1]=true;
				belt[i+1]--;				
			}
		}
		if(exist[N-1])exist[N-1]=false; //마지막칸 로봇 땅으로
		if(!exist[0]&&belt[0]>=1) {
			exist[0]=true;
			belt[0]--;
		}
	}
	
	//내구도 카운팅
	private static int count() {
		int cnt=0;
		for(int i=0;i<N*2; i++) {
			if(belt[i]==0)cnt++;
		}
		return cnt;
	}
}
