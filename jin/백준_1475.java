//백준 1475
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		int[] N = new int[9];

		for (int i = 0; i < str.length(); i++) {
			int n = str.charAt(i) - '0';
			if (n == 9)
				N[6]++;
			else
				N[n]++;
		}
		if (N[6] % 2 == 0)
			N[6] /= 2;
		else {
			N[6] /= 2;
			N[6]++;
		}
		int max = 0;
		for (int n : N) {
			max = Math.max(max, n);
		}
		System.out.println(max);
		sc.close();
	}
}