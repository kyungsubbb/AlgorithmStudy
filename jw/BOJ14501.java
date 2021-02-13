package com.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
	static public int max,n;
	static public int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		solve(0,0);
		System.out.println(max);
	}
	
	static public void solve(int day, int sum) {
		//기저조건
		if(n == day) {
			max = Math.max(max, sum);
			return;
		}
		
		//선택했을 경우-day체크도 해야한다.
		if(arr[day][0] + day<=n)
			solve(day+arr[day][0],sum+arr[day][1]);
		
		//선택하지 않았을 경우
		solve(day+1, sum);
		
	}

}
