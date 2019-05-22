package codeForcesPractice;

import java.util.Scanner;

public class wayTooLongWords {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder ans = new StringBuilder();
		while (n-- > 0) {
			String s = sc.next();
			if (s.length() <= 10) {
				ans.append(s + "\n");
			} else {
				ans.append((s.charAt(0)+"") + (s.length() - 2) + (s.charAt(s.length() - 1)+"") + "\n");
			}
		}
		System.out.print(ans);
	}
}
