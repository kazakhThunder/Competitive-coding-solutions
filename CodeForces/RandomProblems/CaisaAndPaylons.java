package codeForcesPractice;

import java.util.Scanner;

public class CaisaAndPaylons {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		while (n-- > 0) {
			max = Integer.max(max, sc.nextInt());
		}
		System.out.println(max);
	}
}
