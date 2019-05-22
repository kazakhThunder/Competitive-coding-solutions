package codeForcesPractice;

import java.util.Scanner;

public class buyAShovel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int r = sc.nextInt();
		for (int i = 1; i <= 10; i++) {
			int temp = k * i;
			int temp1 = temp - r;
			if (temp % 10 == 0 || temp1 % 10 == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}
