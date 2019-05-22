import java.util.Scanner;

public class ChefPRMS {
	static boolean prime(int N) {
		if (N == 1 || (N % 2 == 0 && N != 2)) {
			return false;
		}
		int count = 2;
		for (int i = 2; i <= N / 2; i++) {
			if (N % i == 0) {
				count++;
			}
			if (count > 2) {
				return false;
			}
		}
		return true;
	}

	static boolean SemPr(int N) {
		int countDiv = 0, countPr = 0;
		if (prime(N) || N == 0) {
			return false;
		}
		for (int i = 2; i < N; i++) {
			if ((N % i == 0)) {
				countDiv++;
				if (prime(i)) {
					countPr++;
				}
			}
			if (countDiv > 2) {
				return false;
			}
		}

		if (countDiv == countPr && (countDiv == 2)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int flag = 0;
			for (int j = 0; j <= N / 2; j++) {
				int t = N - j;
				if (SemPr(t) && SemPr(j)) {
					System.out.println("YES");
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println("NO");
			}
		}
	}
}
