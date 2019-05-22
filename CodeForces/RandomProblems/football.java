
package codeForcesPractice;

import java.util.Scanner;

public class football {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int count = 1, max = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				count++;
			} else {
				if (count > max) {
					max = count;
				}
				count = 1;
			}
		}
		if (count > max) {
			max = count;
		}
		String ans = (max >= 7) ? "YES" : "NO";
		System.out.println(ans);
	}
}
