import java.util.Scanner;
//방 번호
public class B1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String n = sc.next();
		int[] N = new int[10];//0~9 숫자 카드 저장
		int tmp;

		for(int i = 0; i < n.length(); i++) {
			tmp = n.charAt(i) - '0';//정수형으로 전환
			N[tmp]++;//배열에 정수형 저장
		}
		
		int max = 0;
		
		if((N[6] + N[9]) % 2 == 1) {//예를들어 99999 다섯자리이면 6,9의 개수로 나누면 하나가 남는다.
			max = (N[6] + N[9]) % 2 + 1;
		}else {//짝수 개수이면 2로 나눔
			max = (N[6] + N[9]) / 2;
		}
		
		N[6] = 0;
		N[9] = 0;
		
		for (int p:N) {//최대값 뽑기 
			max = Math.max(max, p);
		}
		System.out.println(max);
	}
}
