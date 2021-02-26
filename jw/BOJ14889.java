package com.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14889 {
	static int[][] map;
	static int n;
	static int MIN = Integer.MAX_VALUE;
	static boolean[] isSelected;
	static int[] linkTeam;
	static int[] startTeam;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		isSelected = new boolean[n];
		startTeam = new int[n/2];
		linkTeam = new int[n/2];
		map = new int[n][n];
		
		for(int i = 0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		combination(0, 0);
		System.out.println(MIN);
	}
	
	static int diff() {
		int sum1=0;
		int sum2 = 0;

		for(int i=0; i<startTeam.length-1; i++) {
			for(int j=i+1; j<startTeam.length; j++) {
				int x = startTeam[i];
				int y = startTeam[j];
				sum1 += map[x][y] + map[y][x];
			}
		}
		
		for(int i=0; i<linkTeam.length-1; i++) {
			for(int j=i+1; j<linkTeam.length; j++) {
				int x = linkTeam[i];
				int y = linkTeam[j];
				sum2 += map[x][y] + map[y][x];
			}
		}
		int min = Math.abs(sum1-sum2);
		
		return min;
	}
	
	static void combination(int cnt, int start) {
		if(cnt == n/2) {			
			int idx = 0;
			for(int i=0; i<n; i++) {
				if(isSelected[i] == false) {
					linkTeam[idx++] = i;
				}
			}
			
			int result = diff();
			MIN = Math.min(MIN, result);
			
			return;
		}
		
		for(int i=start; i<n; i++) {
			isSelected[i] = true;
			startTeam[cnt] = i;
			combination(cnt+1, i+1);
			isSelected[i] = false;
		}
	}

}
