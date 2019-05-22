
package codeForcesPractice;

import java.util.Scanner;

public class boredom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Long count[] = new Long[100001];
		for (int i = 0; i < 100001; i++) {
			count[i] = 0L;
		}
		int arr[] = new int[n];
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			max = (arr[i] > max) ? arr[i] : max;
			count[arr[i]]++;
		}
		sc.close();
		Long dp[] = new Long[max + 1];
		dp[0] = 0L;
		dp[1] = 1L * count[1];
		int i = 2;
		for (i = 2; i < max + 1; i++) {
			dp[i] = Long.max(((dp[i - 2]) + (count[i] * i)), dp[i - 1]);
		}
		System.out.println(dp[max]);
	}
}
