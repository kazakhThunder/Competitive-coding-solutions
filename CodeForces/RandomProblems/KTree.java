package codeForcesPractice;

import java.util.Scanner;

public class KTree {
	static int count = 0;

	static void solverUtil(int n, int k) {
		if (n < 0) {
			return;
		} else if (n == 0) {
			count++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int d = sc.nextInt();
	}
}
