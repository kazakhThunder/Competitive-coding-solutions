package codeForcesPractice;

import java.util.Scanner;

public class givenLengthAnd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(), temp = m;
		int s = sc.nextInt();
		String max = "";
		String min = "";
		while (temp-- > 0) {
			if (s >= 9) {
				s = s - 9;
				max += 9;
			} else {
				max += s;
				s = 0;
			}
		}
		temp = m;
		while (temp > 0) {
			if (s < (9 * (temp))) {
				if (temp == m) {
					s = s - 1;
					min += 1;
				} else {
					min += 0;
				}
			} else {
				min += (s + 9 - (9 * temp));
				s = 9 * temp;
			}
			temp--;
		}
		if (max.charAt(0) != '0') {
			System.out.println(max);
		} else {
			System.out.println(-1);
		}
	}
}
