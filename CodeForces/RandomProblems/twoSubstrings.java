
package codeForcesPractice;

import java.util.Scanner;

public class twoSubstrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder s = new StringBuilder(sc.next());
		sc.close();
		int a = s.indexOf("AB");
		int b = s.indexOf("BA");
		if ((a > -1) && (a + 2 < s.length()) && (s.substring(a + 2).contains("BA"))) {
			System.out.println("YES");

		} else if ((b > -1) && (b + 2 < s.length()) && (s.substring(b + 2).contains("AB"))) {
			System.out.println("YES");

		} else {
			System.out.println("NO");
		}
	}
}
