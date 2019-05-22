package codeForcesPractice;

import java.util.Scanner;

public class twoGram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cr[][] = new int[26][26];
		int n = sc.nextInt();
		String s = sc.next();
		for (int i = 0; i < n - 1; i++) {
			cr[s.charAt(i) - 65][s.charAt(i + 1) - 65]++;
		}
		int maxi = 0, maxj = 0;
		for (int i = 0; i < cr.length; i++) {
			for (int j = 0; j < cr.length; j++) {
				if (cr[i][j] > cr[maxi][maxj]) {
					maxi = i;
					maxj = j;
				}
			}
		}
		System.out.println((char) (65 + maxi) + "" + (char) (65 + maxj));
	}
}
