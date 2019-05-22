
package codeForcesPractice;

import java.util.Scanner;

public class differentIsGood {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), count = 0;
		int arr[] = new int[26];
		String s = sc.next();
		if (n > 26) {
			System.out.println(-1);
			return;
		}
		for (int i = 0; i < n; i++) {
			arr[s.charAt(i) - 97]++;
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				count++;
			}
		}
		System.out.println((count == n) ? 0 : n - count);
	}
}
