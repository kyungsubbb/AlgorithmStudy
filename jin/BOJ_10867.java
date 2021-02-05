package coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_10867 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());

		// TreeSet 선언 (이진탐색트리
		TreeSet<Integer> ts = new TreeSet<Integer>(
//				new Comparator<Integer>() {
//			public int compare(Integer o1, Integer o2) {
//				return o1-o2;
//			}
//		}
		);
		
		// 입력
		StringTokenizer st = new StringTokenizer(input.readLine());
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			ts.add(value);
		}
		
		// 출력
		StringBuilder output = new StringBuilder();
		Iterator<Integer> it = ts.iterator();
		int l = 1;
		while (it.hasNext()) {
			output.append(it.next());
			if (l <= ts.size() - 1) {
				output.append(" ");
				l++;
			}
		}
		System.out.println(output);
		
//		// 2번 안
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
//		
//		int size = Integer.parseInt(br.readLine());
//		
//		boolean[] num = new boolean[2001];
//		
//		StringTokenizer st2 = new StringTokenizer(br.readLine());
//		for(int i = 0; i < size; i++) {
//			num[Integer.parseInt(st2.nextToken()) + 1000] = true;
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for(int i = 0; i < num.length; i++) {
//			if(num[i]) {
//				sb.append(i - 1000).append(" ");
//			}
//		}
//		
//		System.out.println(sb);
		
	}// main

}