
package codeForcesPractice;

import java.util.Scanner;

public class AAndBTeamTraining {
	static int dp[][] = new int[1000][1000];

	static int solver(int n, int m, int count) {
		if ((n == 1 && m == 1) || (n <= 0) || (m <= 0)) {
			return count;
		}
		if (dp[n][m] == 0)
			return dp[n][m] = Integer.max(solver(n - 2, m - 1, count + 1), solver(n - 1, m - 2, count + 1));
		else
			return dp[n][m];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println((n < 2 && m < 2) ? 0 : solver(n, m, 0));
	}
}
