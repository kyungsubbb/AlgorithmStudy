package ct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {
	static int[][] wheel= new int[5][8]; //01[2]345[6]78
	static int sum=0;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		for(int i=1;i<=4;i++) {
			String str=input.readLine();
			for(int j=0;j<8;j++) {
				wheel[i][j]=str.charAt(j)-'0';
			}
		}
		int N=Integer.parseInt(input.readLine()); // rotate times
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(input.readLine());
			int num =Integer.parseInt(st.nextToken());
			int dir =Integer.parseInt(st.nextToken());
			check(num,dir);
		}
		calc();

		System.out.println(sum);
	}//main
	private static void check(int n, int dir) {
		int op_dir=dir*-1;
		boolean[] flag = new boolean[3];
		if(wheel[1][2]!=wheel[2][6]) flag[0]=true; // 1번 톱니바퀴의 3시위치와 2번 톱니바퀴의 9시 위치의 극이 다르면 true
		if(wheel[2][2]!=wheel[3][6]) flag[1]=true;
		if(wheel[3][2]!=wheel[4][6]) flag[2]=true;
		
		if(n==1) {
			rotate(n,dir);
			if(flag[0]) {
				rotate(2,op_dir);
				if(flag[1]) {
					rotate(3,dir);
					if(flag[2]) rotate(4,op_dir);
				}
			}
		}else if(n==2) {
			rotate(n,dir);
			if(flag[0]) rotate(1,op_dir);
			if(flag[1]) {
				rotate(3,op_dir);
				if(flag[2]) rotate(4,dir);
			}
		}else if(n==3) {
			rotate(n,dir);
			if(flag[2]) rotate(4,op_dir);
			if(flag[1]) {
				rotate(2,op_dir);
				if(flag[0]) rotate(1,dir);
			}
		}else {
			rotate(n,dir);
			if(flag[2]) {
				rotate(3,op_dir);
				if(flag[1]) {
					rotate(2,dir);
					if(flag[0]) rotate(1,op_dir);
				}
			}
		}
	}
	
	private static void rotate(int n, int dir) {
		if(dir == 1) {
			int tmp = wheel[n][7];
			for(int i=7;i>0;i--)
				wheel[n][i]=wheel[n][i-1];
			wheel[n][0]=tmp;
		}else {
			int tmp = wheel[n][0];
			for(int i=0;i<7;i++)
				wheel[n][i]=wheel[n][i+1];
			wheel[n][7]=tmp;
		}
	}
	
	private static void calc() { //점수계산
		if(wheel[1][0]==0) {}
		else sum+=1;		
		if(wheel[2][0]==0) {}
		else sum+=2;
		if(wheel[3][0]==0) {}
		else sum+=4;		
		if(wheel[4][0]==0) {}
		else sum+=8;		
	}
}
