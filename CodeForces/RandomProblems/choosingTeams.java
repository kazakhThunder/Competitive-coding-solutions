package codeForcesPractice;

import java.util.Arrays;
import java.util.Scanner;

public class choosingTeams {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int count = 0;
		int numOfTimes[] = new int[n];
		for (int i = 0; i < numOfTimes.length; i++) {
			numOfTimes[i] = sc.nextInt();
		}
		Arrays.sort(numOfTimes);
		for (int i = 2; i < n; i = i + 3) {
			if (5 - numOfTimes[i] >= k) {
				count++;
			}
		}
		System.out.println(count);
	}
}
