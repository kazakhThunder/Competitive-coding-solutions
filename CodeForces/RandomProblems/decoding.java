package codeForcesPractice;

import java.util.Scanner;

public class decoding {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		StringBuilder ans = new StringBuilder();
		for (int i = n - 1; i >= 0; i--) {
			ans.insert(ans.length() / 2, s.charAt(i));
		}
		System.out.println(ans);
	}
}
