package codeForcesPractice;

import java.util.Scanner;

public class nightAtTheMuseum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char s[] = sc.next().toCharArray();
		int a = s[0] - 'a';
		int count = (a > 13) ? 26 - a : a;
		for (int i = 1; i < s.length; i++) {
			a = Math.abs(s[i] - s[i - 1]);
			count += (a > 13) ? (26 - a) : a;
		}
		System.out.println(count);
	}
}
