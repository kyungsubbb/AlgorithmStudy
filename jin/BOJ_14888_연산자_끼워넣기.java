package coding;
//https://www.acmicpc.net/problem/14888
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_¿¬»êÀÚ_³¢¿ö³Ö±â {
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	static int[] nums;
	static int[] opers=new int[4];
	static int N;
	
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		N=Integer.parseInt(input.readLine());
		StringTokenizer st = new StringTokenizer(input.readLine());
		nums=new int[N];
		for(int i=0;i<N;i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(input.readLine());
		for(int i=0;i<4;i++) {
			opers[i]=Integer.parseInt(st.nextToken());
		}
		
		DFS(nums[0],1);		
		
		System.out.println(max);
		System.out.println(min);
				
	}
	public static void DFS(int num, int cnt) {
		if (cnt == N) {
			max=Math.max(max, num);
			min=Math.min(min, num);
		}
		
		for(int i=0;i<4;i++) {
			if(opers[i]>0) {
				opers[i]--;
				switch(i) {
				case 0 : DFS(num+nums[cnt],cnt+1); break;
				case 1 : DFS(num-nums[cnt],cnt+1); break;
				case 2 : DFS(num*nums[cnt],cnt+1); break;
				case 3 : DFS(num/nums[cnt],cnt+1); break;
				
				}
				opers[i]++;				
			}
		}
	}

}
