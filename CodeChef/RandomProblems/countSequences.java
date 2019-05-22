import java.util.Scanner;

public class countSequences {
	static long fact(int n) {
		long ans = 1L;
		for (int i = 2; i <= n; i++) {
			ans = ans * i;
		}
		return ans;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			int R = sc.nextInt();
			int n = (R - L + 1);
			long ans = 0L;
			for (int r = 1; r <= N; r++) {
				ans += (fact(n)) / ((fact(n - r) * fact(r)));
			}
			System.out.println(ans);
		}
	}
}
