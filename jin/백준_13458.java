//백준_13458
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++)
			A[i] = sc.nextInt();

		long cnt = 0;
		int sv1 = sc.nextInt();
		int sv2 = sc.nextInt();

		// 총감독관
		for (int i = 0; i < N; i++) {
			if (A[i] >= sv1) {
				A[i] -= sv1;
				cnt++;
			} else {
				A[i] = 0;
				cnt++;
			}
		}

		// 부감독관
		for (int i = 0; i < N; i++) {
			if (A[i] == 0) {
				continue;
			} else if (A[i] > sv2) {
				cnt = cnt + (A[i] / sv2);
				A[i] = (A[i] % sv2);			
				if (A[i] < sv2) {
					A[i] = 0;
					cnt++;
					continue;
				}
			} else if (A[i] == sv2) {
				A[i] = 0;
				cnt++;
				continue;
			} else {

				A[i] = 0;
				cnt++;
			}
		}
		System.out.println(cnt);

		sc.close();
	}
}