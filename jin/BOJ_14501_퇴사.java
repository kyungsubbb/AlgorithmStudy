package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_퇴사 {
	static int[][] info = new int[17][2];
	static int max_value;
	static int N;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(input.readLine());
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			info[i][0]=Integer.parseInt(st.nextToken()); //상담 시간
			info[i][1]=Integer.parseInt(st.nextToken()); //이익
		}
		
		for(int i=1;i<=N;i++) { //상담 시작날짜 1~N까지
			DFS(i,0);
		}
		System.out.println(max_value);
	}
	
	public static void DFS(int day, int value) {
		if(day+info[day][0]<=N+1) {
			value+=info[day][1]; //주의할 것이 day값을 먼저 더하면 info의 day인덱스가 바뀌게되어 틀린다
			day+=info[day][0];
			max_value =Math.max(value, max_value); // 모든 경우의 수 최대값 계산
			//System.out.println(day+" "+value);
			for(int i=day;i<=N;i++) { //그 다음 day 부터 시작
				DFS(i,value);
			}
		}else {
			return;
		}
	}

}
