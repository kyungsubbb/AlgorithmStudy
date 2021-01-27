package wonjoo;

import java.util.Scanner;

public class B11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[1001]; //n은 1에서 1000사이
		list[1] = 1;//2*1일때 1개
		list[2] = 2;//2*2일 때 2개
		for (int i = 3; i <= n; i++) {
			list[i] = (list[i - 1] + list[i - 2]) % 10007; // n개의 타일 = (n-2) + (n-1)
		}		
		System.out.println(list[n]);
	}
}
