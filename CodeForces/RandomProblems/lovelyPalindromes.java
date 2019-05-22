package codeForcesPractice;

import java.util.Scanner;

public class lovelyPalindromes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder(sc.next() + "");
		System.out.println(ans + "" + ans.reverse());
	}
}
