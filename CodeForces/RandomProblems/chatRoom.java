package codeForcesPractice;

import java.util.Scanner;

public class chatRoom {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String hello = "hello";
		int count = 0;
		int j = 0;
		for (int i = 0; i < 5; i++) {
			for (; j < s.length(); j++) {
				if (s.charAt(j) == hello.charAt(i)) {
					count++;
					j++;
					break;
				}
			}
		}
		String a = (count == 5) ? "YES" : "NO";
		System.out.println(a);
	}
}
