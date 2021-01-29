package com.algoStudy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Integer[] rope = new Integer[n];
		
		for(int i=0; i<n; i++) {
			rope[i] = sc.nextInt();
		}
		Arrays.sort(rope,Collections.reverseOrder());
		
		int max = rope[0];
		
		for(int i=1; i<n; i++) {
			rope[i] *= (i+1);
			if(max <rope[i]) max = rope[i];
		}
		System.out.println(max);
		sc.close();
	}
}