import java.util.Scanner;

public class game23 {
	static int solver(int n, int m, int count) {
		if (n == m) {
			return count;
		} else if (n > m) {
			return Integer.MAX_VALUE;
		} else {
			return Integer.min(solver(n * 2, m, count + 1), solver(n * 3, m, count + 1));
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		int ans = solver(n, m, 0);
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
}
