import java.util.Scanner;

public class subArrayGCD {
	static int GCD(int a, int b) {
		if (a == 0 || b == 0) {
			return (a == 0) ? b : a;
		} else {
			int big = (a > b) ? a : b;
			int small = (big == a) ? b : a;
			return GCD((big % small), (small));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int GCD = 0;
			for (int i = 0; i < N; i++) {
				int temp = sc.nextInt();
				GCD = GCD(GCD, temp);
			}
			if (GCD == 1) {
				System.out.println(N);
			} else {
				System.out.println(-1);
			}
		}
	}
}
