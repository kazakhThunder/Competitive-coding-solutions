package codeForcesPractice;

import java.util.Scanner;

public class FlippingGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		int num[] = new int[n];
		int dp[] = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		if (num[0] == 0) {
			dp[0] = 1;
			count = 1;
		}
		for (int i = 1; i < n; i++) {
			if (num[i] == 0) {
				count++;
				dp[i] = Integer.max(count, dp[i - 1]);
			} else {
				count = 0;
				dp[i] = dp[i - 1];
			}
		}
		System.out.println(dp[n - 1]);
	}
}
