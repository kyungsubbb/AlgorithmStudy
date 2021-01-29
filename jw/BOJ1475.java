package com.algoStudy;

import java.util.Scanner;

public class BOJ1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		int max = 0;
		n= n.replaceAll("9", "6");
		
		int[] numbers = new int[10];
		for(int j=0; j<n.length(); j++) {
			for(int i=0; i<10; i++) {
				if(Integer.parseInt(Character.toString(n.charAt(j))) == i) {
					numbers[i]++;
					break;
				}
			}
		}
		
		if(numbers[6]%2 == 0) {
			numbers[6] /=2;
		}else {
			numbers[6] =numbers[6]/ 2 +1;
		}
		
		for(int i=0; i<10; i++) {
			if(max < numbers[i]) max = numbers[i];
		}
		System.out.println(max);
		sc.close();
	}
}