
package codeForcesPractice;

import java.util.Scanner;

public class cutRibbon {
	static int dp[] = new int[10000];

	static int max(int a, int b, int c) {
		int ans;
		if (a >= b && b >= c) {
			ans = a;
		} else if (c >= a && c >= b) {
			ans = c;
		} else {
			ans = b;
		}
		if (ans == -1) {
			System.out.println(a + " " + b + " " + c);
		}
		return ans;
	}

	static int cut(int abc[], int n, int start, int count) {
		if (start > 2) {
			if (n == 0) {
				return count;
			} else {
				return -1;
			}
		} else if (n <= 0) {
			if (n < 0) {
				return 0;
			} else {
				return count;
			}
		}
		return (max(cut(abc, n - abc[start], start + 1, count + 1), cut(abc, n - abc[start], start, count + 1),
				cut(abc, n, start + 1, count)));
	}

	public static void main(String[] args) {
		// System.out.println(max(2, -2,3));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// dp = new int[n+1];
		int abc[] = new int[3];
		abc[0] = sc.nextInt();
		abc[1] = sc.nextInt();
		abc[2] = sc.nextInt();
		System.out.println(cut(abc, n, 0, 0));
	}
}
