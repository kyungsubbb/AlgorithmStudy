package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//퇴사
public class B14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		//인덱스 값을 넉넉하게 줘야한다.
		int[] T = new int[N + 10];//시간
		int[] P = new int[N + 10];//페이
		int[] save = new int[N + 10];//최대 수익 저장
		
		for (int i = 1; i <= N; i++) {//1일부터 시작
			st = new StringTokenizer(br.readLine(), " ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		
		for (int i = 1; i <= N+1; i++) {//N일부터 1일까지
			if(i + T[i] <= N + 1) {//i일 부터 상담 일수를 포함하여 (T[i]), 상담일 수가  N+1범위를 초과하지 않을 때
				save[i] = Math.max(max, save[i]);
				save[i + T[i]] = Math.max(save[i + T[i]], P[i] + save[i]);//최대값 구하는 식
				max = Math.max(max, save[i]);
			}else {//퇴사 날 넘으면
				save[i] = save[i + 1];
			}
		}
		System.out.println(max);
	}

}
