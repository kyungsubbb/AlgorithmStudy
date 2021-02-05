package com.algoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ10867 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<Integer> numbers = new HashSet();
		
		for(int i=0; i<n; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		List list = new ArrayList(numbers);
		Collections.sort(list);
		
		String result = list.toString().replace("[", "").replace(",", "").replace("]", "");
		System.out.println(result);
	}
}