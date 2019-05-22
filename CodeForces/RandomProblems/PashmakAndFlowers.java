package codeForcesPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class PashmakAndFlowers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b[] = new int[n];
		HashMap<Integer, Long> freq = new HashMap<Integer, Long>();
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
			long frequency = (freq.get(b[i]) == null) ? 0 : freq.get(b[i]);
			freq.put(b[i], frequency + 1);
		}
		Arrays.sort(b);
		int ans1 = (b[n - 1] - b[0]);
		if (ans1 == 0)
			System.out.println(0 + " " + ((freq.get(b[0])) * (freq.get(b[0]) - 1) / 2));
		else
			System.out.println(ans1 + " " + (freq.get(b[n - 1]) * freq.get(b[0])));
	}
}
