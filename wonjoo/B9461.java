package algorithm;

import java.util.Scanner;

public class B9461_파도반수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		long[] x = new long[101];// 1부터 시작하니까 // long으로 바꾸니까 맞음 ..

		x[1] = 1;// 1부터 시작하니까
		x[2] = 1;
		// x[3] = 1;

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
		
			for (int i = 3; i < 101; i++) {//앞에 숫자 2개 저장해두고 3부터 시작
				x[i] = x[i - 2] + x[i - 3];
			}
			System.out.println(x[N]);
		}

	}

}
