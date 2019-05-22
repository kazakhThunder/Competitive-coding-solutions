package codeForcesPractice;

import java.util.Scanner;

public class longestUncommonSubSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		sc.close();
		if (a.equals(b)) {
			System.out.println(-1);
		} else {
			System.out.println((a.length() > b.length()) ? a.length() : b.length());
		}
	}
}
