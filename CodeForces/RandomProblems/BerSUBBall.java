package codeForcesPractice;

import java.util.Scanner;

public class BerSUBBall {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), count = 0;
		int bFreq[] = new int[101];
		for (int i = 0; i < n; i++) {
			bFreq[sc.nextInt()]++;
		}
		int m = sc.nextInt();
		int gFreq[] = new int[101];
		for (int i = 0; i < m; i++) {
			gFreq[sc.nextInt()]++;
		}
		for (int i = 1; i < 101; i++) {
			while (bFreq[i] != 0) {
				if (bFreq[i] > 0) {
					if (gFreq[i - 1] > 0) {
						--gFreq[i - 1];
						count++;
					} else if (gFreq[i] > 0) {
						--gFreq[i];
						count++;
					} else if (i + 1 < 101 && gFreq[i + 1] > 0) {
						--gFreq[i + 1];
						count++;
					} else {
						break;
					}
				}
				--bFreq[i];
			}
		}
		System.out.println(count);
	}
}
