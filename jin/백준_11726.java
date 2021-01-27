//백준_11726
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long a = 1, b = 2, c = 3;
		if (n > 3) {
			for (int i = 0; i < (n - 3); i++) {
				a = b;
				b = c;
				c = (a + b)%10007;
			}
		} else {
			if (n == 1)
				c = a;
			else if (n == 2)
				c = b;
			else if (n == 3)
				c = a + b;
		}
		//c = c % 10007;
		System.out.println(c);
		sc.close();
	}
}