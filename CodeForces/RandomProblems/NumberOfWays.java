
package codeForcesPractice;

import java.util.Scanner;

public class NumberOfWays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long sum = 0;
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		sc.close();
		if (sum % 3 != 0) {
			System.out.println(0);
		} else {
			sum /= 3;
			long anSum = 0;
			long ans = 0;
			int cnt[] = new int[n];
			long sums[] = new long[n];
			for (int i = n - 1; i >= 0; i--) {
				anSum += arr[i];
				if (anSum == sum) {
					cnt[i] = 1;
				} else {
					cnt[i] = 0;
				}
			}
			sums[n - 1] = cnt[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				sums[i] = sums[i + 1] + cnt[i];
			}
			anSum = 0;
			for (int i = 0; i < n - 2; i++) {
				anSum += arr[i];
				if (anSum == sum) {
					ans += sums[i + 2];
				}
			}
			System.out.println(ans);
		}

	}
}