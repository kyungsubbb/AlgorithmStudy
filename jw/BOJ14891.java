package day0226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14891 {
	static int[][] map,status;
	static int k;
	public static void main(String[] args) throws IOException {
		//1. 톱니바퀴 상태 입력
		//2. 회전 횟수와 방법 입력
		//3. (1번톱니의 2, 2번 톱니의 6), (2번톱니의 2, 3번 톱니의 6), (3번톱니의 2, 4번 톱니의 6)
		//3-1. 비교해서 극이 같다면 반대 방향으로 톱니를 돌리고
		//3-2. 비교해서 극이 다르다면 그대로 두고
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[4][8];
		
		//1. 톱니바퀴 상태 입력
		for(int i=0; i<4; i++) {
			String temp = br.readLine();
			for(int j=0; j<8; j++) {
				map[i][j] = temp.charAt(j) -'0';
			}
		}
		//2. 회전 횟수와 방법 입력
		k = Integer.parseInt(br.readLine());
		status = new int[k][2];
		int num;
		int s;
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			leftRotation(num-1, s);
			rightRotation(num-1,s);
			if(s==1) clockwise(num-1);
			else counterClockwise(num-1);
		}
		
		int p = 0;
		int sum = 0;
		for(int i=0; i<4; i++) {
			if(map[i][0] == 1) {
				sum+= Math.pow(2, p);
			}
			p++;
		}
		System.out.println(sum);
		
		
	}
	
	private static void rightRotation(int i, int s) {
		int right = i+1;//오른쪽 톱니
		
		if(right<4) {
			if(map[right][6] == map[i][2]) {//같다면 회전 X
				return;
			}else if(map[right][6] != map[i][2]) {//같지 않다면
				rightRotation(right,-s);
				if(s == 1) {
					counterClockwise(right);
				}else {
					clockwise(right);
				}
			}
		}		
	}

	private static void leftRotation(int i, int s) {
		int left = i-1;//왼쪽 톱니
		
		if(left>=0) {//왼쪽 바퀴
			if(map[left][2] == map[i][6]) {//같다면 회전 X
				return;
			}else if(map[left][2] != map[i][6]) {//같지 않다면
				leftRotation(left, -s);
				if(s == 1) {
					counterClockwise(left);
				}else {
					clockwise(left);
				}
			}
		}
	}

	//시계방향으로 회전
	static void clockwise(int num) {//num은 회전시키는 톱니바퀴 번호
		int lastNum = map[num][7];
		
		for(int i=7; i>0; i--) {
			map[num][i] = map[num][i-1];
		}
		map[num][0] = lastNum;
	}
	
	//반시계방향으로 회전
	static void counterClockwise(int num) {//num은 회전시키는 톱니바퀴 번호
		int firstNum = map[num][0];
		
		for(int i=0; i<7; i++) {
			map[num][i] = map[num][i+1];
		}
		map[num][7] = firstNum;
	}

}
