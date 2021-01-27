package wonjoo;

import java.util.Scanner;

public class B13458 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //시험장 수
		int[] a = new int[n];//응시자 수
		
		long cnt = 0;
		
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		int b = sc.nextInt();//총감독관
		int c = sc.nextInt();//부감독관
		
		for (int i = 0; i < n; i++) {
			a[i]-=b;//총감독관은 무조건 1명이어야한다.
			cnt++;
			if(a[i] <= 0) {
				continue;
			}
			else {
				cnt += a[i] / c;
				if(a[i] % c > 0) //나머지 부감독관으로 채우기
					cnt++;
			}
			}
		System.out.println(cnt);
		}				


	}

