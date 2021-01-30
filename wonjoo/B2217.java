package wonjoo;

import java.util.Arrays;
import java.util.Scanner;
//로프
public class B2217 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] n = new int[N];
		
		
		for (int i = 0; i < N; i++) {
			n[i] = sc.nextInt();
		}
		
		Arrays.sort(n);//배열 오름차순 정렬
		int max = 0;

		for (int i = N - 1; i >= 0; i--) {//배열에서 가장 큰 수부터 꺼냄
				n[i] *= N-i;// 배열 첫번째 숫자인 10에 2를 곱함
				max = Math.max(max, n[i]);//0과 20중 최대값 저장
			}
		System.out.println(max);//최대값 출력
	}
}


